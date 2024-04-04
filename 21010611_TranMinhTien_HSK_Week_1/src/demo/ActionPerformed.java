package demo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionPerformed implements ActionListener{

	private giaiPhuongTrinhBacHai giaiPhuongTrinhBacHai;

	public ActionPerformed(giaiPhuongTrinhBacHai giaiPhuongTrinhBacHai) {
		super();
		this.giaiPhuongTrinhBacHai = giaiPhuongTrinhBacHai;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
			String src = e.getActionCommand();
			if(src.equals("Giải"))
			{
				this.giaiPhuongTrinhBacHai.giaiPhuongTrinh();
			}else if(src.equals("Xoá rỗng"))
			{
				
			}else {
				
			}
			
		
	}
	
}
