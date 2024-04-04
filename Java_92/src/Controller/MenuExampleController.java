package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import view.MenuExampleView;

public class MenuExampleController implements ActionListener {

	private MenuExampleView menuExampleView;


	public MenuExampleController(MenuExampleView menuExampleView) {
		this.menuExampleView = menuExampleView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if(src.equals("Exit")) {
			System.exit(0);
		}else {
			this.menuExampleView.Text("Bạn đã click: "+src);

		}
	}

}
