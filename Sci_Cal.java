package Scientific;

import javax.swing.*;
import java.awt.*;

public class Sci_Cal implements ActionListener {
	
	JFrame frame;
	JTextField textField;
	JPanel panel;
	
	JButton[] num_buttons = new JButton[10];
	JButton[] hex_buttons = new JButton[6];
	JButton[] trig_func_Buttons = new JButton[12];
	JButton[] sim_func_buttons = new JButton[9];
	JButton[] hyp_func_buttons = new JButton[12];
	JButton[] drle_func_Buttons = new JButton[9];
	
	JButton b_add,b_sub,b_divide,b_mul,b_div;
	JButton b_clear,b_backspace,b_equal,b_dot;
	JButton b_A,b_B,b_C,b_D,b_E,b_F;
	JButton b_sin,b_cos,b_tan,b_cosec,b_sec,b_cot,b_sin_inv,b_cos_inv,b_tan_inv,b_cosec_inv,b_sec_inv,b_cot_inv;
	JButton b_sinh,b_cosh,b_tanh,b_cosech,b_sech,b_coth,b_sinh_inv,b_cosh_inv,b_tanh_inv,b_cosech_inv,b_sech_inv,b_coth_inv;
	JButton b_log,b_exp,b_deg,b_rad;
	JButton b_abs,b_fact,b_sq,b_cube,b_sqrt;
	
	JRadioButton degree_type;
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
		
		
	}
	
	public static void main(String[] args) {
		
		Sci_Cal Calcu = new Sci_Cal();
		
	}
	
	
	

}
