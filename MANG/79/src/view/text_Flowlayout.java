package view;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class text_Flowlayout extends JFrame
{
	public text_Flowlayout() 
	{
		this.setTitle("Test_Flowlayout");
		this.setSize(600,400);
		// can giua cua so chuong trinh
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// set layout
		//tao layout
		FlowLayout flowlayout = new FlowLayout();
		//Canh trai canh phai canh giua
		FlowLayout flowlayout_1= new FlowLayout(FlowLayout.RIGHT);
//		FlowLayout flowlayout_1= new FlowLayout(FlowLayout.CENTER,50,50);
		
		
		FlowLayout flowlayout_2= new FlowLayout();
		
		// cach hien thi
		this.setLayout(flowlayout_1);
		
		//Tao ra button
		JButton jbutton_1 = new JButton("1");
		JButton jbutton_2 = new JButton("2");
		JButton jbutton_3 = new JButton("3");
		
		//add thanh phan vao
		this.add(jbutton_1);
		this.add(jbutton_2);
		this.add(jbutton_3);
		this.add(new JButton("4"));
	
	
	}
	
	public static void main(String[] args) {
		new text_Flowlayout();
	}
	
	
}