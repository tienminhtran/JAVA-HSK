package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.lastbuttonlistener;
import model.Lastbutton;

public class buttonview extends JFrame{
	private Lastbutton lastbuttonmodel;
	private JLabel jlabel;
	public buttonview() {
		this.lastbuttonmodel= new Lastbutton();    
		this.init();
	
	}
	private void init() {
		this.setTitle("Last button");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300, 300);
		this.setLocationRelativeTo(null);
		
		JPanel jpanel_center= new JPanel();
		jpanel_center.setLayout(new GridLayout(2,2,5,5));
		
		// tao listener
		lastbuttonlistener lb= new lastbuttonlistener(this); 
		//tao phong chu in dam
		
		Font font = new Font("Aria", Font.ITALIC|Font.BOLD,20);
		JButton jbutton_1 = new JButton("1");
		jbutton_1.addActionListener(lb);
		
		// gan phong chu
		jbutton_1.setFont(font);
		JButton jbutton_2 = new JButton("2");
		jbutton_2.setFont(font);
		jbutton_2.addActionListener(lb);
		JButton jbutton_3 = new JButton("3");
		jbutton_3.setFont(font);
		jbutton_3.addActionListener(lb);
		JButton jbutton_4 = new JButton("4");
		jbutton_4.setFont(font);
		jbutton_4.addActionListener(lb);
		jpanel_center.add(jbutton_1);
		jpanel_center.add(jbutton_2);
		jpanel_center.add(jbutton_3);
		jpanel_center.add(jbutton_4);
		
		JPanel jpanel_footer = new JPanel();
		jlabel = new JLabel("------");
		jlabel.setFont(font);
		jpanel_footer.add(jlabel);
		this.setLayout(new BorderLayout());
		this.add(jpanel_center, BorderLayout.CENTER);
		this.add(jpanel_footer,BorderLayout.SOUTH);
		this.setVisible(true);
		
	}
	public void changeto_1() 
	{
		this.lastbuttonmodel.setvalue_1();
		jlabel.setText("Last button: "+ this.lastbuttonmodel.getValue());
		
	}
	public void changeto_2() 
	{
		this.lastbuttonmodel.setvalue_2();
		jlabel.setText("Last button: "+this.lastbuttonmodel.getValue());
	}
	public void changeto_3() 
	{
		this.lastbuttonmodel.setvalue_3();
		jlabel.setText("Last button: "+this.lastbuttonmodel.getValue());
	}
	public void changeto_4() 
	{
		this.lastbuttonmodel.setvalue_4();
		jlabel.setText("Last button: "+this.lastbuttonmodel.getValue());
	}
}
