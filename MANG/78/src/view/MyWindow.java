package view;

import javax.swing.JFrame;

public class MyWindow extends JFrame{
	public MyWindow()
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	{	
		
	}
	public void showit() 
	{
		this.setVisible(true);
	}
	public void showit(String title) 
	{
		this.setTitle(title);
		this.setVisible(true);
	}
	public void showit(String title, int width,int height) 
	{
		this.setTitle(title);
		this.setSize(width,height);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		MyWindow m1 = new MyWindow();
//		m1.showit();
//		m1.showit("OKE");
		m1.showit("OKE", 500, 300);
	}
}
