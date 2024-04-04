package Bai1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class controller implements ActionListener{

	private View view;
	
	public controller(View view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if(src.equals("Giải"))
		{
			this.view.giaiPhuongTrinh();
		}
	}

	
}
