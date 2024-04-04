package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.countview;

public class countlistener implements ActionListener{
	private countview ctv;
	public countlistener(countview ctv) {
		this.ctv= ctv;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
//		System.out.println("Ban da nhan nut!");
		//lay ra chuoi up hoac down
		String src= e.getActionCommand();
//		System.out.println("Ban da nhan nut: "+src);
		if(src.equals(" UP     ")) 
		{
			this.ctv.increment();
		}
		else if(src.equals("DOWN")) 
		{
			this.ctv.decrement();
		}
		//listener lang nghe thao tac nguoi dung
	}
	
}
