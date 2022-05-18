package Scientific;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	
	JButton b_add,b_sub,b_divide,b_mul,b_div,b_rem,b_nnum;
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
	JRadioButton short_type;
	JRadioButton byte_type;
	ButtonGroup data_type;
	
	Font myFont = new Font("Xenara",Font.BOLD,12);
	
	double num1=0,num2=0,result=0;
	
	char operator;
	
	Sci_Cal() {
		
		frame = new JFrame("Scientific Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(440,520);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.getContentPane().setBackground(new Color(65,189,250));
		
		textField = new JTextField();
		textField.setFont(myFont);
		textField.setBounds(0,0,420,50);
		textField.setEditable(false);
		
		decimal_type = new JRadioButton("DECIMAL",true);
		decimal_type.setFocusable(false);
		decimal_type.setBounds(116,55,70,30);
		decimal_type.setActionCommand("DEC");
		decimal_type.addActionListener(this);
		
		hexadecimal_type = new JRadioButton("HEXA");
		hexadecimal_type.setFocusable(false);
		hexadecimal_type.setBounds(0,55,70,30);
		hexadecimal_type.setActionCommand("HEX");
		hexadecimal_type.addActionListener(this);
		
		octal_type = new JRadioButton("OCTAL");
		octal_type.setFocusable(false);
		octal_type.setBounds(233,55,70,30);
		octal_type.setActionCommand("OCT");
		octal_type.addActionListener(this);
		
		binary_type = new JRadioButton("BINARY");
		binary_type.setFocusable(false);
		binary_type.setBounds(349,55,70,30);
		binary_type.setActionCommand("BIN");
		binary_type.addActionListener(this);
		
		num_type = new ButtonGroup();
		num_type.add(hexadecimal_type);
		num_type.add(decimal_type);
		num_type.add(octal_type);
		num_type.add(binary_type);
		
		
		int_type = new JRadioButton("INTEGER",true);
		int_type.setBounds(140,90,70,30);
		int_type.setFocusable(false);
		int_type.setActionCommand("Integer");
		int_type.addActionListener(this);
		
		short_type = new JRadioButton("SHORT");
		short_type.setBounds(70,90,70,30);
		short_type.setFocusable(false);
		short_type.setActionCommand("Short");
		short_type.addActionListener(this);
		
		byte_type = new JRadioButton("BYTE");
		byte_type.setBounds(0,90,70,30);
		byte_type.setFocusable(false);
		byte_type.setActionCommand("Byte");
		byte_type.addActionListener(this);
		
		double_type = new JRadioButton("DOUBLE");
		double_type.setBounds(350,90,70,30);
		double_type.setFocusable(false);
		double_type.setActionCommand("Double");
		double_type.addActionListener(this);
		
		float_type = new JRadioButton("FLOAT");
		float_type.setBounds(280,90,70,30);
		float_type.setFocusable(false);
		float_type.setActionCommand("Float");
		float_type.addActionListener(this);
		
		long_type = new JRadioButton("LONG");
		long_type.setBounds(210,90,70,30);
		long_type.setFocusable(false);
		long_type.setActionCommand("Long");
		long_type.addActionListener(this);
		
		data_type = new ButtonGroup();
		data_type.add(int_type);
		data_type.add(long_type);
		data_type.add(float_type);
		data_type.add(double_type);
		data_type.add(byte_type);
		data_type.add(short_type);
		
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
		
		
		b_nnum = new JButton("-Neg");
		b_nnum.addActionListener(this);
        b_nnum.setFont(myFont);
        b_nnum.setFocusable(false);
        
		b_clear.addActionListener(this);
        b_clear.setFont(myFont);
        b_clear.setFocusable(false);
        
        b_equal.addActionListener(this);
        b_equal.setFont(myFont);
        b_equal.setFocusable(false);
        
        b_backspace.addActionListener(this);
        b_backspace.setFont(myFont);
        b_backspace.setFocusable(false);
        
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
        
        
        panel = new JPanel();
        panel.setBounds(0, 130, 420, 340);
        panel.setLayout(new GridLayout(12,5,5,5));
        panel.setBackground(new Color(67,189,250));
        panel.add(num_buttons[1]);
        panel.add(num_buttons[2]);
        panel.add(num_buttons[3]);
        panel.add(hex_buttons[0]);
        panel.add(hex_buttons[1]);
        panel.add(num_buttons[4]);
        panel.add(num_buttons[5]);
        panel.add(num_buttons[6]);
        panel.add(hex_buttons[2]);
        panel.add(hex_buttons[3]);
        panel.add(num_buttons[7]);
        panel.add(num_buttons[8]);
        panel.add(num_buttons[9]);
        panel.add(hex_buttons[4]);
        panel.add(hex_buttons[5]);
        panel.add(b_dot);
        panel.add(num_buttons[0]);
        panel.add(b_add);
        panel.add(trig_func_buttons[0]);
        panel.add(trig_func_buttons[1]);
        panel.add(b_sub);
        panel.add(b_mul);
        panel.add(b_div);
        panel.add(trig_func_buttons[2]);
        panel.add(trig_func_buttons[3]);
        panel.add(b_rem);
        panel.add(hyp_func_buttons[0]);
        panel.add(hyp_func_buttons[1]);
        panel.add(trig_func_buttons[4]);
        panel.add(trig_func_buttons[5]);
        panel.add(hyp_func_buttons[2]);
        panel.add(hyp_func_buttons[3]);
        panel.add(hyp_func_buttons[4]);
        panel.add(trig_func_buttons[6]);
        panel.add(trig_func_buttons[7]);
        panel.add(hyp_func_buttons[5]);
        panel.add(hyp_func_buttons[6]);
        panel.add(hyp_func_buttons[7]);
        panel.add(trig_func_buttons[8]);
        panel.add(trig_func_buttons[9]);
        panel.add(hyp_func_buttons[8]);
        panel.add(hyp_func_buttons[9]);
        panel.add(hyp_func_buttons[10]);
        panel.add(trig_func_buttons[10]);
        panel.add(trig_func_buttons[11]);
        panel.add(hyp_func_buttons[11]);
        panel.add(drle_func_buttons[0]);
        panel.add(drle_func_buttons[1]);
        panel.add(drle_func_buttons[2]);
        panel.add(drle_func_buttons[3]);
        panel.add(drle_func_buttons[4]);
        panel.add(drle_func_buttons[5]);
        panel.add(drle_func_buttons[6]);
        panel.add(drle_func_buttons[7]);
        panel.add(drle_func_buttons[8]);
        panel.add(b_nnum);
        panel.add(b_clear);
        panel.add(b_equal);
        panel.add(b_backspace);
        
        frame.add(textField);
        frame.add(hexadecimal_type);
        frame.add(decimal_type);
        frame.add(octal_type);
        frame.add(binary_type);
        frame.add(byte_type);
        frame.add(short_type);
        frame.add(int_type);
        frame.add(long_type);
        frame.add(float_type);
        frame.add(double_type);
        frame.add(panel);
        frame.setVisible(true);
        
		
		
		
		
		
		
		
	}
	
	public static void main(String[] args) {
		
		Sci_Cal Calcu = new Sci_Cal();
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i = 0;i<10;i++) {
			if(e.getSource()==num_buttons[i]) {
				textField.setText(textField.getText().concat(String.valueOf(i)));
				if(data_type.getSelection().getActionCommand().equals("Double") || data_type.getSelection().getActionCommand().equals("Float")) {
				
				}
				else {
					textField.setText(isIntegerParsable(textField.getText(),data_type.getSelection().getActionCommand()));	
				}
			}
		}
		if(e.getSource()==b_A) {
			textField.setText(textField.getText().concat("A"));
		}
		if(e.getSource()==b_B) {
			textField.setText(textField.getText().concat("B"));
		}
		if(e.getSource()==b_C) {
			textField.setText(textField.getText().concat("C"));
		}
		if(e.getSource()==b_D) {
			textField.setText(textField.getText().concat("D"));
		}
		if(e.getSource()==b_E) {
			textField.setText(textField.getText().concat("E"));
		}
		if(e.getSource()==b_F) {
			textField.setText(textField.getText().concat("F"));
		}
		if(e.getSource()==b_dot) {
			textField.setText(textField.getText().concat("."));
		}
		if (e.getSource() == b_nnum){
			num1 = Double.parseDouble(textField.getText());
			result = num1 * -1;
			if (data_type.getSelection().getActionCommand().equals("Double") || data_type.getSelection().getActionCommand().equals("Float")){
                textField.setText(isDoubleParsable(String.valueOf(result), data_type.getSelection().getActionCommand()));
            } else {
                textField.setText(isIntegerParsable(String.valueOf((long) result), data_type.getSelection().getActionCommand()));
            }
            num1 = result;
		}
		if(e.getSource()==b_add) {		
			num1 = Double.parseDouble(textField.getText());
			operator = '+';
			textField.setText("");
		}
		if (e.getSource()==b_sub) {
			num1 = Double.parseDouble(textField.getText());
			operator = '-';
			textField.setText("");
		}
		if(e.getSource()==b_div) {
			num1 = Double.parseDouble(textField.getText());
			operator = '/';
			textField.setText("");
		}	
		if (e.getSource() == b_fact) {
			result = 1;
            num1 = Double.parseDouble(textField.getText());
            for (int factor = 2; factor <= num1; factor++) {
                result *= factor;
            }
            if (data_type.getSelection().getActionCommand().equals("Double") || data_type.getSelection().getActionCommand().equals("Float")){
                textField.setText(isDoubleParsable(String.valueOf(result), data_type.getSelection().getActionCommand()));
            } else {
                textField.setText(isIntegerParsable(String.valueOf((long) result), data_type.getSelection().getActionCommand()));
            }
            num1 = result;
		}
		if(e.getSource()==b_mul) {
			num1 = Double.parseDouble(textField.getText());
			operator = '*';
			textField.setText("");
		}
		if(e.getSource()==b_rem) {
			num1 = Double.parseDouble(textField.getText());
			operator = '%';
			textField.setText("");
		}
		if(e.getSource()==b_equal) {
			num2 = Double.parseDouble(textField.getText());
			switch(operator) {
			case'+':
				result = num1+num2;
				break;
			case '-':
				result = num1 - num2;
				break;
			case '*':
				result = num1*num2;
				break;
			case '/':
				result = num1/num2;
				break;
			case '%':
				result = num1%num2;
				break;
			}
			
			if (data_type.getSelection().getActionCommand().equals("Double") || data_type.getSelection().getActionCommand().equals("Float")){
                textField.setText(isDoubleParsable(String.valueOf(result), data_type.getSelection().getActionCommand()));
            } else {
                textField.setText(isIntegerParsable(String.valueOf((long)result), data_type.getSelection().getActionCommand()));
            }
            result = num1;
			
		}
		if(e.getSource()==b_clear) {
			textField.setText("");
		}
		if(e.getSource()==b_sq) {
			num1 = Double.parseDouble(textField.getText());
			result = Math.pow(num1, 2);
			if (data_type.getSelection().getActionCommand().equals("Double") || data_type.getSelection().getActionCommand().equals("Float")){
                textField.setText(isDoubleParsable(String.valueOf(result), data_type.getSelection().getActionCommand()));
            } else {
                textField.setText(isIntegerParsable(String.valueOf((long) result), data_type.getSelection().getActionCommand()));
            }
            num1 = result;
		}
		if(e.getSource()==b_sqrt) {
			num1 = Double.parseDouble(textField.getText());
			result = Math.sqrt(num1);
			if (data_type.getSelection().getActionCommand().equals("Double") || data_type.getSelection().getActionCommand().equals("Float")){
                textField.setText(isDoubleParsable(String.valueOf(result), data_type.getSelection().getActionCommand()));
            } else {
                textField.setText(isIntegerParsable(String.valueOf((long) result), data_type.getSelection().getActionCommand()));
            }
            num1 = result;
			
		}
		if(e.getSource()==b_cube) {
			num1 = Double.parseDouble(textField.getText());
			result = Math.pow(num1, 3);
			if (data_type.getSelection().getActionCommand().equals("Double") || data_type.getSelection().getActionCommand().equals("Float")){
                textField.setText(isDoubleParsable(String.valueOf(result), data_type.getSelection().getActionCommand()));
            } else {
                textField.setText(isIntegerParsable(String.valueOf((long) result), data_type.getSelection().getActionCommand()));
            }
            num1 = result;
			
		}
		
		//If HexaDecimal Selection,Enabled/Disabled
		if(num_type.getSelection().getActionCommand().equals("HEX")) {
			b_nnum.setEnabled(false);
			for(int i = 0;i<num_buttons.length;i++) {
				num_buttons[i].setEnabled(true);
			}
			for(int i = 0;i<hex_buttons.length;i++) {
				hex_buttons[i].setEnabled(true);
			}
			for(int i = 0;i<sim_func_buttons.length;i++) {
				sim_func_buttons[i].setEnabled(true);
				sim_func_buttons[5].setEnabled(false);
			}
			for(int i = 0;i<trig_func_buttons.length;i++) {
				trig_func_buttons[i].setEnabled(false);
			}
			for(int i = 0;i<hyp_func_buttons.length;i++) {
				hyp_func_buttons[i].setEnabled(false);
			}
			for(int i = 0;i<drle_func_buttons.length;i++) {
				drle_func_buttons[i].setEnabled(false);
			}
			
			int_type.setEnabled(true);
			long_type.setEnabled(true);
			float_type.setEnabled(false);
			double_type.setEnabled(false);
			
		}
		
		//If Decimal Selection,Enabled/Disabled
		else if(num_type.getSelection().getActionCommand().equals("DEC")) {
			b_backspace.setEnabled(true);
			for (int i = 0; i < num_buttons.length; i++) {
                num_buttons[i].setEnabled(true);
            }
            for (int i = 0; i < hex_buttons.length; i++) {
                hex_buttons[i].setEnabled(false);
            }
            for (int i = 0; i < sim_func_buttons.length; i++) {
                sim_func_buttons[i].setEnabled(true);
            }
            for (int i = 0; i < trig_func_buttons.length; i++) {
                trig_func_buttons[i].setEnabled(true);
            }
            for (int i = 0; i < hyp_func_buttons.length; i++) {
                hyp_func_buttons[i].setEnabled(true);
            }
            for (int i = 0; i < drle_func_buttons.length; i++) {
                drle_func_buttons[i].setEnabled(true);
            }
            b_nnum.setEnabled(true);
            
            int_type.setEnabled(true);
            long_type.setEnabled(true);
            float_type.setEnabled(true);
            double_type.setEnabled(true);
            
		}
		
		//If Octal Selection,Enabled/Disabled
		else if(num_type.getSelection().getActionCommand().equals("OCT")) {
			b_nnum.setEnabled(false);
			for (int i = 0; i < num_buttons.length; i++) {
                num_buttons[i].setEnabled(false);
            }
            for (int i = 0; i < 8; i++) {
                num_buttons[i].setEnabled(true);
            }
            for (int i = 0; i < hex_buttons.length; i++) {
                hex_buttons[i].setEnabled(false);
            }
            for (int i = 1; i < sim_func_buttons.length; i++) {
                sim_func_buttons[i].setEnabled(true);
                sim_func_buttons[5].setEnabled(false);
            }
            for (int i=0; i < trig_func_buttons.length; i++) {
                trig_func_buttons[i].setEnabled(false);
            }
            for (int i = 0; i < hyp_func_buttons.length; i++) {
                hyp_func_buttons[i].setEnabled(false);
            }
            for (int i = 0; i < drle_func_buttons.length; i++) {
                drle_func_buttons[i].setEnabled(false);
            }
            
            int_type.setEnabled(true);
            long_type.setEnabled(true);
            float_type.setEnabled(false);
            double_type.setEnabled(false);
            int_type.setSelected(true);
		}
		
		//if Binary Selection,Enabled/Disabled
		else if(num_type.getSelection().getActionCommand().equals("BIN")) {
			b_nnum.setEnabled(false);
			for (int i = 0; i < num_buttons.length; i++) {
                num_buttons[i].setEnabled(false);
            }
            for (int i = 0; i < 2; i++) {
                num_buttons[i].setEnabled(true);
            }
            for (int i = 0; i < hex_buttons.length; i++) {
                hex_buttons[i].setEnabled(false);
            }
            for (int i = 1; i < sim_func_buttons.length; i++) {
                sim_func_buttons[i].setEnabled(true);
                sim_func_buttons[5].setEnabled(false);
            }
            for (int i = 0; i < trig_func_buttons.length; i++) {
                trig_func_buttons[i].setEnabled(false);
            }
            for (int i = 0; i < hyp_func_buttons.length; i++) {
                hyp_func_buttons[i].setEnabled(false);
            }
            for (int i = 0; i < drle_func_buttons.length; i++) {
                drle_func_buttons[i].setEnabled(false);
            }
            int_type.setEnabled(true);
            long_type.setEnabled(true);
            float_type.setEnabled(false);
            double_type.setEnabled(false);
            int_type.setSelected(true);
			
		}
		
		if(e.getSource()==b_log) {
			num1 = Double.parseDouble(textField.getText());
			result = Math.log(num1);
			if (data_type.getSelection().getActionCommand().equals("Double") || data_type.getSelection().getActionCommand().equals("Float")){
                textField.setText(isDoubleParsable(String.valueOf(result), data_type.getSelection().getActionCommand()));
            } else {
                textField.setText(isIntegerParsable(String.valueOf((long)result), data_type.getSelection().getActionCommand()));
            }
            num1 = result;
			
		}
		if(e.getSource()==b_abs) {
			num1 = Double.parseDouble(textField.getText());
			result = Math.abs(num1);
			if (data_type.getSelection().getActionCommand().equals("Double") || data_type.getSelection().getActionCommand().equals("Float")){
                textField.setText(isDoubleParsable(String.valueOf(result), data_type.getSelection().getActionCommand()));
            } else {
                textField.setText(isIntegerParsable(String.valueOf((long)result), data_type.getSelection().getActionCommand()));
            }
            num1 = result;
		}
		if(e.getSource()==b_exp) {
			num1 = Double.parseDouble(textField.getText());
			result = Math.exp(num1);
			if (data_type.getSelection().getActionCommand().equals("Double") || data_type.getSelection().getActionCommand().equals("Float")){
                textField.setText(isDoubleParsable(String.valueOf(result), data_type.getSelection().getActionCommand()));
            } else {
                textField.setText(isIntegerParsable(String.valueOf((long)result), data_type.getSelection().getActionCommand()));
            }
            num1 = result;
		}
		if(e.getSource()==b_deg) {
			num1 = Double.parseDouble(textField.getText());
			result = Math.toDegrees(num1);
			if (data_type.getSelection().getActionCommand().equals("Double") || data_type.getSelection().getActionCommand().equals("Float")){
                textField.setText(isDoubleParsable(String.valueOf(result), data_type.getSelection().getActionCommand()));
            } else {
                textField.setText(isIntegerParsable(String.valueOf((long)result), data_type.getSelection().getActionCommand()));
            }
            num1 = result;
		}
		if(e.getSource()==b_rad) {
			num1 = Double.parseDouble(textField.getText());
			result = Math.toRadians(num1);
			if (data_type.getSelection().getActionCommand().equals("Double") || data_type.getSelection().getActionCommand().equals("Float")){
                textField.setText(isDoubleParsable(String.valueOf(result), data_type.getSelection().getActionCommand()));
            } else {
                textField.setText(isIntegerParsable(String.valueOf((long)result), data_type.getSelection().getActionCommand()));
            }
            num1 = result;
		}
		if(e.getSource()==b_sin) {
			num1 = Double.parseDouble(textField.getText());
			result = Math.sin(num1);
			if (data_type.getSelection().getActionCommand().equals("Double") || data_type.getSelection().getActionCommand().equals("Float")){
                textField.setText(isDoubleParsable(String.valueOf(result), data_type.getSelection().getActionCommand()));
            } else {
                textField.setText(isIntegerParsable(String.valueOf((long)result), data_type.getSelection().getActionCommand()));
            }
            num1 = result;
		}
		if(e.getSource()==b_cos) {
			num1 = Double.parseDouble(textField.getText());
			result = Math.cos(num1);
			if (data_type.getSelection().getActionCommand().equals("Double") || data_type.getSelection().getActionCommand().equals("Float")){
                textField.setText(isDoubleParsable(String.valueOf(result), data_type.getSelection().getActionCommand()));
            } else {
                textField.setText(isIntegerParsable(String.valueOf((long)result), data_type.getSelection().getActionCommand()));
            }
            num1 = result;
		}
		if(e.getSource()==b_tan) {
			num1 = Double.parseDouble(textField.getText());
			result = Math.tan(num1);
			if (data_type.getSelection().getActionCommand().equals("Double") || data_type.getSelection().getActionCommand().equals("Float")){
                textField.setText(isDoubleParsable(String.valueOf(result), data_type.getSelection().getActionCommand()));
            } else {
                textField.setText(isIntegerParsable(String.valueOf((long)result), data_type.getSelection().getActionCommand()));
            }
            num1 = result;
		}
		if(e.getSource()==b_cosec) {
			num1 = Double.parseDouble(textField.getText());
			result =1/( Math.sin(num1));
			if (data_type.getSelection().getActionCommand().equals("Double") || data_type.getSelection().getActionCommand().equals("Float")){
                textField.setText(isDoubleParsable(String.valueOf(result), data_type.getSelection().getActionCommand()));
            } else {
                textField.setText(isIntegerParsable(String.valueOf((long)result), data_type.getSelection().getActionCommand()));
            }
            num1 = result;
		}
		if(e.getSource()==b_sec) {
			num1 = Double.parseDouble(textField.getText());
			result =1/(Math.cos(num1));
			if (data_type.getSelection().getActionCommand().equals("Double") || data_type.getSelection().getActionCommand().equals("Float")){
                textField.setText(isDoubleParsable(String.valueOf(result), data_type.getSelection().getActionCommand()));
            } else {
                textField.setText(isIntegerParsable(String.valueOf((long)result), data_type.getSelection().getActionCommand()));
            }
            num1 = result;
		}
		if(e.getSource()==b_cot) {
			num1 = Double.parseDouble(textField.getText());
			result = 1/(Math.tan(num1));
			if (data_type.getSelection().getActionCommand().equals("Double") || data_type.getSelection().getActionCommand().equals("Float")){
                textField.setText(isDoubleParsable(String.valueOf(result), data_type.getSelection().getActionCommand()));
            } else {
                textField.setText(isIntegerParsable(String.valueOf((long)result), data_type.getSelection().getActionCommand()));
            }
            num1 = result;
		}
		if(e.getSource()==b_sin_inv) {
			num1 = Double.parseDouble(textField.getText());
			result = Math.asin(num1);
			if (data_type.getSelection().getActionCommand().equals("Double") || data_type.getSelection().getActionCommand().equals("Float")){
                textField.setText(isDoubleParsable(String.valueOf(result), data_type.getSelection().getActionCommand()));
            } else {
                textField.setText(isIntegerParsable(String.valueOf((long)result), data_type.getSelection().getActionCommand()));
            }
            num1 = result;
		}
		if(e.getSource()==b_cos_inv) {
			num1 = Double.parseDouble(textField.getText());
			result = Math.acos(num1);
			if (data_type.getSelection().getActionCommand().equals("Double") || data_type.getSelection().getActionCommand().equals("Float")){
                textField.setText(isDoubleParsable(String.valueOf(result), data_type.getSelection().getActionCommand()));
            } else {
                textField.setText(isIntegerParsable(String.valueOf((long)result), data_type.getSelection().getActionCommand()));
            }
            num1 = result;
		}
		if(e.getSource()==b_tan_inv) {
			num1 = Double.parseDouble(textField.getText());
			result = Math.atan(num1);
			if (data_type.getSelection().getActionCommand().equals("Double") || data_type.getSelection().getActionCommand().equals("Float")){
                textField.setText(isDoubleParsable(String.valueOf(result), data_type.getSelection().getActionCommand()));
            } else {
                textField.setText(isIntegerParsable(String.valueOf((long)result), data_type.getSelection().getActionCommand()));
            }
            num1 = result;
		}
		if(e.getSource()==b_cosec_inv) {
			num1 = Double.parseDouble(textField.getText());
			result = 1/(Math.asin(num1));
			if (data_type.getSelection().getActionCommand().equals("Double") || data_type.getSelection().getActionCommand().equals("Float")){
                textField.setText(isDoubleParsable(String.valueOf(result), data_type.getSelection().getActionCommand()));
            } else {
                textField.setText(isIntegerParsable(String.valueOf((long)result), data_type.getSelection().getActionCommand()));
            }
            num1 = result;
		}
		if(e.getSource()==b_sec_inv) {
			num1 = Double.parseDouble(textField.getText());
			result = 1/(Math.acos(num1));
			if (data_type.getSelection().getActionCommand().equals("Double") || data_type.getSelection().getActionCommand().equals("Float")){
                textField.setText(isDoubleParsable(String.valueOf(result), data_type.getSelection().getActionCommand()));
            } else {
                textField.setText(isIntegerParsable(String.valueOf((long)result), data_type.getSelection().getActionCommand()));
            }
            num1 = result;
		}
		if(e.getSource()==b_cot_inv) {
			num1 = Double.parseDouble(textField.getText());
			result = 1/(Math.atan(num1));
			if (data_type.getSelection().getActionCommand().equals("Double") || data_type.getSelection().getActionCommand().equals("Float")){
                textField.setText(isDoubleParsable(String.valueOf(result), data_type.getSelection().getActionCommand()));
            } else {
                textField.setText(isIntegerParsable(String.valueOf((long)result), data_type.getSelection().getActionCommand()));
            }
            num1 = result;
		}
		if(e.getSource()==b_sinh) {
			num1 = Double.parseDouble(textField.getText());
			result = Math.sinh(num1);
			if (data_type.getSelection().getActionCommand().equals("Double") || data_type.getSelection().getActionCommand().equals("Float")){
                textField.setText(isDoubleParsable(String.valueOf(result), data_type.getSelection().getActionCommand()));
            } else {
                textField.setText(isIntegerParsable(String.valueOf((long)result), data_type.getSelection().getActionCommand()));
            }
            num1 = result;
		}
		if(e.getSource()==b_cosh) {
			num1 = Double.parseDouble(textField.getText());
			result = Math.cosh(num1);
			if (data_type.getSelection().getActionCommand().equals("Double") || data_type.getSelection().getActionCommand().equals("Float")){
                textField.setText(isDoubleParsable(String.valueOf(result), data_type.getSelection().getActionCommand()));
            } else {
                textField.setText(isIntegerParsable(String.valueOf((long)result), data_type.getSelection().getActionCommand()));
            }
            num1 = result;
		}
		if(e.getSource()==b_tanh) {
			num1 = Double.parseDouble(textField.getText());
			result = Math.tanh(num1);
			if (data_type.getSelection().getActionCommand().equals("Double") || data_type.getSelection().getActionCommand().equals("Float")){
                textField.setText(isDoubleParsable(String.valueOf(result), data_type.getSelection().getActionCommand()));
            } else {
                textField.setText(isIntegerParsable(String.valueOf((long)result), data_type.getSelection().getActionCommand()));
            }
            num1 = result;
		}
		if(e.getSource()==b_cosech) {
			num1 = Double.parseDouble(textField.getText());
			result = 1/(Math.sinh(num1));
			if (data_type.getSelection().getActionCommand().equals("Double") || data_type.getSelection().getActionCommand().equals("Float")){
                textField.setText(isDoubleParsable(String.valueOf(result), data_type.getSelection().getActionCommand()));
            } else {
                textField.setText(isIntegerParsable(String.valueOf((long)result), data_type.getSelection().getActionCommand()));
            }
            num1 = result;
		}
		if(e.getSource()==b_sech) {
			num1 = Double.parseDouble(textField.getText());
			result = 1/(Math.cosh(num1));
			if (data_type.getSelection().getActionCommand().equals("Double") || data_type.getSelection().getActionCommand().equals("Float")){
                textField.setText(isDoubleParsable(String.valueOf(result), data_type.getSelection().getActionCommand()));
            } else {
                textField.setText(isIntegerParsable(String.valueOf((long)result), data_type.getSelection().getActionCommand()));
            }
            num1 = result;
		}
		if(e.getSource()==b_coth) {
			num1 = Double.parseDouble(textField.getText());
			result = 1/(Math.tanh(num1));
			if (data_type.getSelection().getActionCommand().equals("Double") || data_type.getSelection().getActionCommand().equals("Float")){
                textField.setText(isDoubleParsable(String.valueOf(result), data_type.getSelection().getActionCommand()));
            } else {
                textField.setText(isIntegerParsable(String.valueOf((long)result), data_type.getSelection().getActionCommand()));
            }
            num1 = result;
		}
		if(e.getSource()==b_sinh_inv) {
			num1 = Double.parseDouble(textField.getText());
			result = Math.log10(num1+(Math.sqrt((num1*num1)+1)));
			if (data_type.getSelection().getActionCommand().equals("Double") || data_type.getSelection().getActionCommand().equals("Float")){
                textField.setText(isDoubleParsable(String.valueOf(result), data_type.getSelection().getActionCommand()));
            } else {
                textField.setText(isIntegerParsable(String.valueOf((long)result), data_type.getSelection().getActionCommand()));
            }
            num1 = result;
		}
		if(e.getSource()==b_cosh_inv) {
			num1 = Double.parseDouble(textField.getText());
			result = Math.log10(num1+(Math.sqrt((num1*num1)-1)));
			if (data_type.getSelection().getActionCommand().equals("Double") || data_type.getSelection().getActionCommand().equals("Float")){
                textField.setText(isDoubleParsable(String.valueOf(result), data_type.getSelection().getActionCommand()));
            } else {
                textField.setText(isIntegerParsable(String.valueOf((long)result), data_type.getSelection().getActionCommand()));
            }
            num1 = result;
		}
		if(e.getSource()==b_tanh_inv) {
			num1 = Double.parseDouble(textField.getText());
			result = 1/2 * (Math.log10((1+num1)/(1-num1)));
			if (data_type.getSelection().getActionCommand().equals("Double") || data_type.getSelection().getActionCommand().equals("Float")){
                textField.setText(isDoubleParsable(String.valueOf(result), data_type.getSelection().getActionCommand()));
            } else {
                textField.setText(isIntegerParsable(String.valueOf((long)result), data_type.getSelection().getActionCommand()));
            }
            num1 = result;
		}
		if(e.getSource()==b_cosech_inv) {
			num1 = Double.parseDouble(textField.getText());
			result = Math.log10((1+(Math.sqrt(1+(num1*num1))))/num1);
			if (data_type.getSelection().getActionCommand().equals("Double") || data_type.getSelection().getActionCommand().equals("Float")){
                textField.setText(isDoubleParsable(String.valueOf(result), data_type.getSelection().getActionCommand()));
            } else {
                textField.setText(isIntegerParsable(String.valueOf((long)result), data_type.getSelection().getActionCommand()));
            }
            num1 = result;
		}
		if(e.getSource()==b_sech_inv) {
			num1 = Double.parseDouble(textField.getText());
			result = Math.log10(1+(Math.sqrt(1-(num1*num1)))/num1);
			if (data_type.getSelection().getActionCommand().equals("Double") || data_type.getSelection().getActionCommand().equals("Float")){
                textField.setText(isDoubleParsable(String.valueOf(result), data_type.getSelection().getActionCommand()));
            } else {
                textField.setText(isIntegerParsable(String.valueOf((long)result), data_type.getSelection().getActionCommand()));
            }
            num1 = result;
		}
		if(e.getSource()==b_coth_inv) {
			num1 = Double.parseDouble(textField.getText());
			result = 1/2*(Math.log10((num1+1)/(num1-1)));
			if (data_type.getSelection().getActionCommand().equals("Double") || data_type.getSelection().getActionCommand().equals("Float")){
                textField.setText(isDoubleParsable(String.valueOf(result), data_type.getSelection().getActionCommand()));
            } else {
                textField.setText(isIntegerParsable(String.valueOf((long)result), data_type.getSelection().getActionCommand()));
            }
            num1 = result;
		}
    }
	
	
	
	
	
	//checking if Parsable
	public static String isIntegerParsable(String number,String type) {
		try {
			if(type.equals("Byte")) {
				number = Byte.toString(Byte.parseByte(number));
			}
			else if(type.equals("Short")) {
				number = Short.toString(Short.parseShort(number));
			}
			else if(type.equals("Integer")) {
				number = Integer.toString(Integer.parseInt(number));
			}
			else if(type.equals("Long")) {
				number = Long.toString(Long.parseLong(number));
			}
		}
		catch(java.lang.NumberFormatException e) {
			number = "NumberFormatException";
		}
		
		return number;
	}
	
	public static String isDoubleParsable(String number,String type) {
		try {
			if(type.equals("Float")) {
				number = Float.toString(Float.parseFloat(number));
			}
			else if(type.equals("Double")){
			number = Double.toString(Float.parseFloat(number));
			}
		}
		catch(java.lang.NumberFormatException e) {
			number = "numberFormatException";
		}
		return number;
	}
	


}
