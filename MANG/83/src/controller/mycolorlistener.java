package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.Mycolorview;

public class mycolorlistener implements ActionListener {

	private Mycolorview mycolorview;
	public mycolorlistener(Mycolorview Mycolorview) {
		this.mycolorview= Mycolorview;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String src =e.getActionCommand();
		if(src.equals("Red Text")) 
		{
			this.mycolorview.changecolor(Color.RED);
		}
		else if(src.equals("Yello Text")) 
		{
			this.mycolorview.changecolor(Color.YELLOW);
		}
		else if(src.equals("Green Text"))
				{
			this.mycolorview.changecolor(Color.GREEN);
				}
		else if(src.equals("Red Background")) 
		{
			this.mycolorview.changebackgruondcolor(Color.RED);
		}
		else if(src.equals("Yello Background")) 
		{
			this.mycolorview.changebackgruondcolor(Color.YELLOW);
		}
		else if(src.equals("MAU TRANG NHU CU")) 
		{
			this.mycolorview.changebackgruondcolor(Color.WHITE);
			this.mycolorview.changecolor(Color.BLACK);
		}
		else this.mycolorview.changebackgruondcolor(Color.GREEN);
		
	}

}
