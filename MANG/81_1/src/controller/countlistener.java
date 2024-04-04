package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.countview;

public class countlistener implements ActionListener {
	private countview countview;
	public countlistener(countview countview) {
		this.countview=countview;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if(src==" UP    ") 
		{
			this.countview.increment();
		}
		else if(src.equals("DOWN")) 
		{
			this.countview.decrement();
		}
		else this.countview.reset();
	}
	
}
