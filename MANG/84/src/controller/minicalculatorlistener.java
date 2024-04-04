package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.Minicalculatorview;

public class minicalculatorlistener implements ActionListener {

	private Minicalculatorview minicalculatorview;
	public minicalculatorlistener(Minicalculatorview kinicalculatorview) {
		this.minicalculatorview = kinicalculatorview;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String button = e.getActionCommand();
		if(button.equals("+")) 
		{
			this.minicalculatorview.plus();
		}
		else if(button.equals("-")) 
		{
			this.minicalculatorview.minus();
		}
		else if(button.equals("*")) 
		{
			this.minicalculatorview.multiply();
		}
		else if(button.equals("/")) 
		{
			this.minicalculatorview.devide();
		}
		else if(button.equals("^")) 
		{
			this.minicalculatorview.power();
		}
		else if(button.equals("%")) 
		{
			this.minicalculatorview.mod();
		}
		else this.minicalculatorview.reset();
	}

}
