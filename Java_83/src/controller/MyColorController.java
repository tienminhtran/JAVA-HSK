package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.MyColorView;

public class MyColorController implements ActionListener{

	private MyColorView myColorView;
	
	
	public MyColorController(MyColorView myColorView) {
		this.myColorView = myColorView;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		
		if(src.equals("Red text"))
		{
			this.myColorView.changeTextColor(Color.RED);
		}else if(src.equals("Yellow text"))
		{
			this.myColorView.changeTextColor(Color.YELLOW);
		}else if(src.equals("Green text"))
		{
			this.myColorView.changeTextColor(Color.GREEN);
		}
		else if(src.equals("Red background"))
		{
			this.myColorView.changeBackgroundColor(Color.RED);
		}else if(src.equals("Yellow background"))
		{
			this.myColorView.changeBackgroundColor(Color.YELLOW);
		}else if(src.equals("Green background"))
		{
			this.myColorView.changeBackgroundColor(Color.GREEN);
		}
		
	}

	
}
