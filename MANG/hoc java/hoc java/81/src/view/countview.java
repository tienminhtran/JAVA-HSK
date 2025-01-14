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
	private JLabel jlabel_value;
	public countview() {
		this.countmodel= new count();
		this.init();
		this.setVisible(true);
	}
	public void init() 
	{
		this.setTitle("counter");
		this.setSize(300,300);
		this.setLocationRelativeTo(null);	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//tao ra doi tuong de hanh dong
		ActionListener ac = new countlistener(this);
		//moi lan nhan nut la hanh dong
		jbutton_up = new JButton(" UP     ");
		jbutton_up.addActionListener(ac);
		jbutton_down= new JButton("DOWN");
		jbutton_down.addActionListener(ac);
		jlabel_value= new JLabel(this.countmodel.getValue()+"",JLabel.CENTER);
		
		JPanel jpanel = new JPanel();
		jpanel.setLayout(new BorderLayout());
		jpanel.add(jbutton_up, BorderLayout.WEST);
		jpanel.add(jlabel_value,BorderLayout.CENTER);
		jpanel.add(jbutton_down,BorderLayout.EAST);
		this.setLayout(new BorderLayout());
		this.add(jpanel, BorderLayout.CENTER);
		
	}
	public void increment() 
	{
		this.countmodel.increment();
		//settext
		this.jlabel_value.setText(this.countmodel.getValue()+"");
	}
	public void decrement() 
	{
		this.countmodel.decrement();
		this.jlabel_value.setText(this.countmodel.getValue()+"");
	}
}
