package view;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class test_borderlayout extends JFrame
{
	public test_borderlayout() 
	{
		this.setTitle("Test_Flowlayout");
		this.setSize(600,400);
		// can giua cua so chuong trinh
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// set layout
		//tao layout
		
		BorderLayout borderlayout = new BorderLayout();
		BorderLayout borderlayout_2 = new BorderLayout(15,15);
		
		
		// cach hien thi
		this.setLayout(borderlayout_2);
		
		//Tao ra button
		JButton jbutton_1 = new JButton("1");
		JButton jbutton_2 = new JButton("2");
		JButton jbutton_3 = new JButton("3");
		JButton jbutton_4 = new JButton("4");
		JButton jbutton_5 = new JButton("5");
		
		//add thanh phan vao
		this.add(jbutton_1, BorderLayout.NORTH);
		this.add(jbutton_2, BorderLayout.SOUTH);
		this.add(jbutton_3, BorderLayout.EAST);
		this.add(new JButton("4"), BorderLayout.WEST);
		this.add(jbutton_5,BorderLayout.CENTER);
	
	
	}
	
	public static void main(String[] args) {
		new test_borderlayout(); 
	}
	
	
}