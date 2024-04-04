package Bai1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener{

	private View view;
	
	public Controller(View view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if(src.equals("Giải"))
		{
			this.view.giaiPhuongTrinh();
		}else if(src.equals("Xoá rỗng"))
		{
			this.view.Xoatrang();
		}else {
			this.view.thoat();
		}
	}

	
}
