package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.buttonview;

public class lastbuttonlistener implements ActionListener {
	private buttonview lastbuttonview;
	
	public lastbuttonlistener(buttonview lastbuttonview) {
		this.lastbuttonview = lastbuttonview;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		
		String nguonsukien= e.getActionCommand();
		if(nguonsukien=="1") 
		{
			this.lastbuttonview.changeto_1();
		}
		else if(nguonsukien=="2") 
		{
			this.lastbuttonview.changeto_2();
		}
		else if(nguonsukien=="3") 
		{
			this.lastbuttonview.changeto_3();
		}
		else this.lastbuttonview.changeto_4();
		
	}
	
}
