package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.minicalculatorlistener;
import model.minicalculatormodel;

public class Minicalculatorview extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1;
	private minicalculatormodel minicalculatormodel;
	private JTextField jtextfield_firstvalue;
	private JTextField jtextfield_secondvalue;
	private JTextField jtextfield_answer;
	
	public Minicalculatorview() {
		this.minicalculatormodel= new minicalculatormodel();
		this.init();
	}
	public void init() 
	{
		this.setTitle("Mini Calculator");
		this.setSize(300,300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Font font = new Font("Aria", Font.BOLD,20);
		JLabel jlabel_firstvalue= new JLabel("1st value");
		jlabel_firstvalue.setFont(font);
		jlabel_firstvalue.setForeground(Color.RED);
		JLabel jlabel_secondvalue= new JLabel("2st value");
		jlabel_secondvalue.setFont(font);
		jlabel_secondvalue.setForeground(Color.BLUE);
		JLabel jlabel_answer = new JLabel("Answer");
		jlabel_answer.setFont(font);
		jlabel_answer.setForeground(Color.MAGENTA);
		
		// nhap du lieu
		jtextfield_firstvalue= new JTextField(20);
		jtextfield_firstvalue.setFont(font);
		jtextfield_firstvalue.setBackground(Color.RED);
		jtextfield_secondvalue= new JTextField(20);
		jtextfield_secondvalue.setFont(font);
		jtextfield_secondvalue.setBackground(Color.BLUE);
		jtextfield_answer = new JTextField(20);
		jtextfield_answer.setFont(font);
		jtextfield_answer.setBackground(Color.MAGENTA);
		
		JPanel jpanelIO= new JPanel();
		jpanelIO.setLayout(new GridLayout(3,2,0,20));
		jpanelIO.add(jlabel_firstvalue);
		jpanelIO.add(jtextfield_firstvalue);
		jpanelIO.add(jlabel_secondvalue);
		jpanelIO.add(jtextfield_secondvalue);
		jpanelIO.add(jlabel_answer);
		jpanelIO.add(jtextfield_answer);
		
		minicalculatorlistener mc= new minicalculatorlistener(this);
		JButton jbutton_plus= new JButton("+");
		jbutton_plus.setFont(font);
		jbutton_plus.addActionListener(mc);
		
		JButton jbutton_minus= new JButton("-");
		jbutton_minus.setFont(font);
		jbutton_minus.addActionListener(mc);
		
		JButton jbutton_multiply= new JButton("*");
		jbutton_multiply.setFont(font);
		jbutton_multiply.addActionListener(mc);
		
		JButton jbutton_devide= new JButton("/");
		jbutton_devide.setFont(font);
		jbutton_devide.addActionListener(mc);
		
		JButton jbutton_pow= new JButton("^");
		jbutton_pow.setFont(font);
		jbutton_pow.addActionListener(mc);
		
		JButton jbutton_mod= new JButton("%");
		jbutton_mod.setFont(font);
		jbutton_mod.addActionListener(mc);
		
		JPanel jpanel_button = new JPanel();
		jpanel_button.setLayout(new GridLayout(2,3));
		jpanel_button.add(jbutton_plus);
		jpanel_button.add(jbutton_minus);
		jpanel_button.add(jbutton_multiply);
		jpanel_button.add(jbutton_devide);
		jpanel_button.add(jbutton_pow);
		jpanel_button.add(jbutton_mod);
		//them nua
		JButton reset= new JButton("0");
		reset.setFont(font);
		jpanel_button.add(reset);
		reset.addActionListener(mc);
		
		
		
		this.setLayout(new BorderLayout(10,50));
		this.add(jpanelIO,BorderLayout.CENTER);
		this.add(jpanel_button,BorderLayout.SOUTH);
		
		
		
		
		
		
		this.setVisible(true);
	}
	public void plus() 
	{
		double firstvalue= Double.valueOf(jtextfield_firstvalue.getText()) ;
		double secondvalue= Double.valueOf(jtextfield_secondvalue.getText());
		this.minicalculatormodel.setFirst_value(firstvalue);
		this.minicalculatormodel.setSecondvalue(secondvalue);
		this.minicalculatormodel.plus();
		this.jtextfield_answer.setText(String.valueOf(this.minicalculatormodel.getAnswer()));
		
	}
	public void minus() 
	{
		double firstvalue= Double.valueOf(jtextfield_firstvalue.getText()) ;
		double secondvalue= Double.valueOf(jtextfield_secondvalue.getText());
		this.minicalculatormodel.setFirst_value(firstvalue);
		this.minicalculatormodel.setSecondvalue(secondvalue);
		this.minicalculatormodel.minus();
		this.jtextfield_answer.setText(String.valueOf(this.minicalculatormodel.getAnswer()));
	}
	public void multiply() 
	{
		double firstvalue= Double.valueOf(jtextfield_firstvalue.getText()) ;
		double secondvalue= Double.valueOf(jtextfield_secondvalue.getText());
		this.minicalculatormodel.setFirst_value(firstvalue);
		this.minicalculatormodel.setSecondvalue(secondvalue);
		this.minicalculatormodel.multiply();
		this.jtextfield_answer.setText(String.valueOf(this.minicalculatormodel.getAnswer()));
	}
	public void devide() 
	{
		double firstvalue= Double.valueOf(jtextfield_firstvalue.getText()) ;
		double secondvalue= Double.valueOf(jtextfield_secondvalue.getText());
		this.minicalculatormodel.setFirst_value(firstvalue);
		this.minicalculatormodel.setSecondvalue(secondvalue);
		this.minicalculatormodel.devide();
		this.jtextfield_answer.setText(String.valueOf(this.minicalculatormodel.getAnswer()));
	}
	public void power() 
	{
		double firstvalue= Double.valueOf(jtextfield_firstvalue.getText()) ;
		double secondvalue= Double.valueOf(jtextfield_secondvalue.getText());
		this.minicalculatormodel.setFirst_value(firstvalue);
		this.minicalculatormodel.setSecondvalue(secondvalue);
		this.minicalculatormodel.power();
		this.jtextfield_answer.setText(String.valueOf(this.minicalculatormodel.getAnswer()));
	}
	public void mod() 
	{
		double firstvalue= Double.valueOf(jtextfield_firstvalue.getText()) ;
		double secondvalue= Double.valueOf(jtextfield_secondvalue.getText());
		double math2= Math.round(secondvalue*100)/100.0;
		double math1= Math.round(firstvalue*100)/100.0;
		this.minicalculatormodel.setFirst_value(firstvalue);
		this.minicalculatormodel.setSecondvalue(secondvalue);
		this.minicalculatormodel.mod();
		this.jtextfield_answer.setText(String.valueOf(this.minicalculatormodel.getAnswer()));
		
	}
	public void reset() 
	{
		this.jtextfield_answer.setText(null);
		this.jtextfield_firstvalue.setText(null);
		this.jtextfield_secondvalue.setText(null);
	}
}
