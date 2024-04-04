package view;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.countlistener;
import model.count;

public class countview extends JFrame{
	private count countmodel;
	private JButton jbutton_up;
	private JButton jbutton_down;
	private JLabel 	jlaber_value;
	private JButton jbutton_reset;
	public countview() {
		this.countmodel= new count();
		
		this.init();
		this.setVisible(true);
	}
	public void init() 
	{
		this.setTitle("COUNTER");
		this.setSize(300, 300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ActionListener ac = new countlistener(this);
		
		
		jbutton_down= new JButton("DOWN");
		jbutton_down.addActionListener(ac);
		jbutton_up  = new JButton(" UP    ");
		jbutton_up.addActionListener(ac);
		jbutton_reset = new JButton("RESET");
		jbutton_reset.addActionListener(ac);
		jlaber_value = new JLabel(this.countmodel.getValue()+"", JLabel.CENTER);
		
		JPanel jpanel= new JPanel();
		jpanel.setLayout(new BorderLayout());
		jpanel.add(jbutton_down, BorderLayout.EAST);
		jpanel.add(jbutton_up, BorderLayout.WEST);
		jpanel.add(jlaber_value,BorderLayout.CENTER);
		jpanel.add(jbutton_reset,BorderLayout.SOUTH);
		this.setLayout( new BorderLayout());
		this.add(jpanel,BorderLayout.CENTER);
	}
	public void increment() 
	{
		this.countmodel.increment();
		//settext
		this.jlaber_value.setText(this.countmodel.getValue()+"");
	}
	public void decrement() 
	{
		this.countmodel.decrement();
		this.jlaber_value.setText(this.countmodel.getValue()+"");
	}
	public void reset() 
	{
		this.countmodel.reset();
		this.jlaber_value.setText(this.countmodel.getValue()+"");
	}
}
