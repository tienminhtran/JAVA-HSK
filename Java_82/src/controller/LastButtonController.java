package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.LastButtonView;

public class LastButtonController implements ActionListener{

	private LastButtonView lastButtonView;
	
	public LastButtonController(LastButtonView lastButtonView) {
		this.lastButtonView = lastButtonView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if(src.equals("1"))
			this.lastButtonView.changeTo_1();
		else if(src.equals("2"))
			this.lastButtonView.changeTo_2();
		else if(src.equals("3"))
			this.lastButtonView.changeTo_3();
		else
			this.lastButtonView.changeTo_4();
	}

}
