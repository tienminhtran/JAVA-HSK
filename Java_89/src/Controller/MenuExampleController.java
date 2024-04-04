package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.MenuExampleView;

public class MenuExampleController implements ActionListener {

	private MenuExampleView menuExampleView;


	public MenuExampleController(MenuExampleView menuExampleView) {
		this.menuExampleView = menuExampleView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if(src.equals("New")) {
			this.menuExampleView.Text("Bạn đã click JmenuItem New");
		}else if(src.equals("Open File")) {
			this.menuExampleView.Text("Bạn đã click JmenuItem Open File");
			//System.exit(0);
		}else if(src.equals("Paste")) {
			this.menuExampleView.Text("Bạn đã click JmenuItem Paste");
		}else
		{
			//this.menuExampleView.Text("Bạn đã click JmenuItem Exit");
			System.exit(0);
		}
	}

}
