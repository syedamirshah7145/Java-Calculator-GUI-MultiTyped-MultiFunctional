package Scientific;

import javax.swing.*;
import java.awt.*;

public class Sci_Cal implements ActionListener {
	
	JFrame frame;
	JTextField textField;
	JPanel panel;
	
	JButton[] num_buttons = new JButton[10];
	JButton[] hex_buttons = new JButton[6];
	JButton[] trig_func_buttons = new JButton[12];
	JButton[] sim_func_buttons = new JButton[9];
	JButton[] hyp_func_buttons = new JButton[12];
	JButton[] drle_func_buttons = new JButton[9];
	
	JButton b_add,b_sub,b_divide,b_mul,b_div,b_rem;
	JButton b_clear,b_backspace,b_equal,b_dot;
	JButton b_A,b_B,b_C,b_D,b_E,b_F;
	JButton b_sin,b_cos,b_tan,b_cosec,b_sec,b_cot,b_sin_inv,b_cos_inv,b_tan_inv,b_cosec_inv,b_sec_inv,b_cot_inv;
	JButton b_sinh,b_cosh,b_tanh,b_cosech,b_sech,b_coth,b_sinh_inv,b_cosh_inv,b_tanh_inv,b_cosech_inv,b_sech_inv,b_coth_inv;
	JButton b_log,b_exp,b_deg,b_rad;
	JButton b_abs,b_fact,b_sq,b_cube,b_sqrt;
	
	JRadioButton decimal_type;
	JRadioButton hexadecimal_type;
	JRadioButton binary_type;
	JRadioButton octal_type;
	ButtonGroup num_type;
	
	JRadioButton int_type;
	JRadioButton double_type;
	JRadioButton float_type;
	JRadioButton long_type;
	ButtonGroup data_type;
	
	Font myFont = new Font("Times New Roman",Font.BOLD,20);
	
	double num1=0,num2=0,result=0;
	
	char operator;
	
	Sci_Cal() {
		
		frame = new JFrame("Scientific Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(730,730);
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(20,90,80));
		
		textField = new JTextField();
		textField.setFont(myFont);
		textField.setBounds(50,25,600,50);
		textField.setEditable(false);
		
		decimal_type = new JRadioButton("DECIMAL",true);
		decimal_type.setFocusable(false);
		decimal_type.setBounds(203,110,110,30);
		decimal_type.setActionCommand("DEC");
		decimal_type.addActionListener(this);
		
		hexadecimal_type = new JRadioButton("HEXADECIMAL");
		hexadecimal_type.setFocusable(false);
		hexadecimal_type.setBounds(53,110,110,30);
		hexadecimal_type.setActionCommand("HEX");
		hexadecimal_type.addActionListener(this);
		
		octal_type = new JRadioButton("OCTAL");
		octal_type.setFocusable(false);
		octal_type.setBounds(353,110,110,30);
		octal_type.setActionCommand("OCT");
		octal_type.addActionListener(this);
		
		binary_type = new JRadioButton("BINARY");
		binary_type.setFocusable(false);
		binary_type.setBounds(503,110,110,30);
		binary_type.setActionCommand("BIN");
		binary_type.addActionListener(this);
		
		num_type = new ButtonGroup();
		num_type.add(hexadecimal_type);
		num_type.add(decimal_type);
		num_type.add(octal_type);
		num_type.add(binary_type);
		
		
		int_type = new JRadioButton("INTEGER");
		int_type.setBounds(53,160,110,30);
		int_type.setFocusable(false);
		int_type.setActionCommand("Integer");
		int_type.addActionListener(this);
		
		double_type = new JRadioButton("DOUBLE");
		double_type.setBounds(503,160,110,30);
		double_type.setFocusable(false);
		double_type.setActionCommand("Double");
		double_type.addActionListener(this);
		
		float_type = new JRadioButton("FLOAT");
		float_type.setBounds(353,160,110,30);
		float_type.setFocusable(false);
		float_type.setActionCommand("Float");
		float_type.addActionListener(this);
		
		long_type = new JRadioButton("LONG");
		long_type.setBounds(203,160,110,30);
		long_type.setFocusable(false);
		long_type.setActionCommand("Long");
		long_type.addActionListener(this);
		
		data_type = new ButtonGroup();
		data_type.add(int_type);
		data_type.add(long_type);
		data_type.add(float_type);
		data_type.add(double_type);
		
		b_add = new JButton("+");
		b_sub = new JButton("-");
		b_mul = new JButton("*");
		b_div = new JButton("/");
		b_dot = new JButton(".");
		b_rem = new JButton("%");
		b_clear = new JButton("Clear");
		b_backspace = new JButton("Back");
		b_equal = new JButton("=");
		
		sim_func_buttons[0] = b_add;
		sim_func_buttons[1] = b_sub;
		sim_func_buttons[2] = b_mul;
		sim_func_buttons[3] = b_div;
		sim_func_buttons[4] = b_rem;
		sim_func_buttons[5] = b_dot;
		sim_func_buttons[6] = b_clear;
		sim_func_buttons[7] = b_backspace;
		sim_func_buttons[8] = b_equal;
		
		for(int i=0;i<9;i++) {
			sim_func_buttons[i].addActionListener(this);
			sim_func_buttons[i].setFocusable(false);
			sim_func_buttons[i].setFont(myFont);
		}
		
		
		for(int i = 0;i<10;i++) {
			num_buttons[i] = new JButton(String.valueOf(i));
			num_buttons[i].addActionListener(this);
			num_buttons[i].setFocusable(false);
			num_buttons[i].setFont(myFont);
		}
		
		
		b_A = new JButton("A");
		b_B = new JButton("B");
		b_C = new JButton("C");
		b_D = new JButton("D");
		b_E = new JButton("E");
		b_F = new JButton("F");
		
		hex_buttons[0] = b_A;
		hex_buttons[1] = b_B;
		hex_buttons[2] = b_C;
		hex_buttons[3] = b_D;
		hex_buttons[4] = b_E;
		hex_buttons[5] = b_F;
		
		for(int i = 0;i<6;i++) {
			hex_buttons[i].addActionListener(this);
			hex_buttons[i].setFocusable(false);
			hex_buttons[i].setFont(myFont);
		}
		
		
		b_sin = new JButton("Sin()");
		b_cos = new JButton("Cos()");
		b_tan = new JButton("Tan()");
		b_cosec = new JButton("Cosec()");
		b_sec = new JButton("Sec()");
		b_cot = new JButton("Cot()");
		b_sin_inv = new JButton("SinI()");
		b_cos_inv = new JButton("CosI()");
		b_tan_inv = new JButton("TanI()");
		b_cosec_inv = new JButton("CosecI()");
		b_sec_inv = new JButton("SecI()");
		b_cot_inv = new JButton("CotI()");
		
		trig_func_buttons[0] = b_sin; 
		trig_func_buttons[1] = b_cos; 
		trig_func_buttons[2] = b_tan; 
		trig_func_buttons[3] = b_cosec; 
		trig_func_buttons[4] = b_sec; 
		trig_func_buttons[5] = b_cot; 
		trig_func_buttons[6] = b_sin_inv; 
		trig_func_buttons[7] = b_cos_inv; 
		trig_func_buttons[8] = b_tan_inv; 
		trig_func_buttons[9] = b_cosec_inv; 
		trig_func_buttons[10] = b_sec_inv;
		trig_func_buttons[11] = b_cot_inv; 
		
		for (int i = 0; i < 12; i++) {
            trig_func_buttons[i].addActionListener(this);
            trig_func_buttons[i].setFont(myFont);
            trig_func_buttons[i].setFocusable(false);
        }
		
		
		b_sinh = new JButton("Sinh()");
		b_cosh = new JButton("Cosh()");
		b_tanh = new JButton("Tanh()");
		b_cosech = new JButton("Cosech()");
		b_sech = new JButton("Sech()");
		b_coth = new JButton("Coth()");
		b_sinh_inv = new JButton("SinhI()");
		b_cosh_inv = new JButton("CoshI()");
		b_tanh_inv = new JButton("CothI()");
		b_cosech_inv = new JButton("CosechI()");
		b_sech_inv = new JButton("SechI()");
		b_coth_inv = new JButton("CothI()");
		
		hyp_func_buttons[0] = b_sinh;
		hyp_func_buttons[1] = b_cosh;
		hyp_func_buttons[2] = b_tanh;
		hyp_func_buttons[3] = b_cosech;
		hyp_func_buttons[4] = b_sech;
		hyp_func_buttons[5] = b_coth;
		hyp_func_buttons[6] = b_sinh_inv;
		hyp_func_buttons[7] = b_cosh_inv;
		hyp_func_buttons[8] = b_tanh_inv;
		hyp_func_buttons[9] = b_cosech_inv;
		hyp_func_buttons[10] = b_sech_inv;
		hyp_func_buttons[11] = b_coth_inv;
		
		for (int i = 0; i < 12; i++) {
            hyp_func_buttons[i].addActionListener(this);
            hyp_func_buttons[i].setFont(myFont);
            hyp_func_buttons[i].setFocusable(false);
        }
		
		
		b_log = new JButton("Log()");
        b_exp = new JButton("Exp()");
        b_deg = new JButton("Deg()");
        b_rad = new JButton("Rad()");
        b_abs = new JButton("+/-");
        b_fact = new JButton("n!");
        b_sq = new JButton("x^2");
        b_sqrt = new JButton("Sqrt");
        b_cube = new JButton("x^3");

        drle_func_buttons[0] = b_log;
        drle_func_buttons[1] = b_exp;
        drle_func_buttons[2] = b_deg;
        drle_func_buttons[3] = b_rad;
        drle_func_buttons[4] = b_abs;
        drle_func_buttons[5] = b_fact;
        drle_func_buttons[6] = b_sq;
        drle_func_buttons[7] = b_sqrt;
        drle_func_buttons[8] = b_cube;

        for (int i = 0; i < 9; i++) {
            drle_func_buttons[i].addActionListener(this);
            drle_func_buttons[i].setFont(myFont);
            drle_func_buttons[i].setFocusable(false);
        }
		
		
		
		
		
		
		
	}
	
	public static void main(String[] args) {
		
		Sci_Cal Calcu = new Sci_Cal();
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}
	
	
	

}
