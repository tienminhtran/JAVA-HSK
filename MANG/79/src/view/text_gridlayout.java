package view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class text_gridlayout extends JFrame
{
	public text_gridlayout() 
	{
		this.setTitle("Test_GridLayout");
		this.setSize(600,400);
		// can giua cua so chuong trinh
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// set layout
		//tao layout
		GridLayout gridlayout= new GridLayout();
		GridLayout gridlayout_1= new GridLayout(4,4);
		GridLayout gridlayout_2= new GridLayout(4,4,25,25);
		// cach hien thi
		this.setLayout(gridlayout_2);
		
		//Tao ra button
		for(int i=0;i<16;i++) 
		{
			JButton jbutton = new JButton(i+"");
			this.add(jbutton);
		}

	
	
	}
	
	public static void main(String[] args) {
		new text_gridlayout();
	}
	
	
}