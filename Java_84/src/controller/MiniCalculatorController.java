package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.MiniCalculatorView;

public class MiniCalculatorController implements ActionListener{

	private MiniCalculatorView miniCalculatorView;
	
	public MiniCalculatorController(MiniCalculatorView miniCalculatorView) {
		this.miniCalculatorView = miniCalculatorView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if(src.equals("+"))
		{
			this.miniCalculatorView.cong();
		}else if(src.equals("-"))
		{
			this.miniCalculatorView.tru();
		}else if(src.equals("*"))
		{
			this.miniCalculatorView.nhan();
		}else if(src.equals("/"))
		{
			this.miniCalculatorView.chia();
		}else if(src.equals("^"))
		{
			this.miniCalculatorView.luythua();
		}else if(src.equals("%"))
		{
			this.miniCalculatorView.mod();
		}
		
	}

}
