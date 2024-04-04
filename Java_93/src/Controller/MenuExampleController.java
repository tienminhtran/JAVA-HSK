package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.AbstractButton;

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
		}else if(src.equals("Toolbar")){
			AbstractButton checkBox = (AbstractButton) e.getSource();
			boolean check = checkBox.getModel().isSelected();
			if(check)
			{
				this.menuExampleView.hienthitoolbar();
				System.out.printf("Bạn đã mở: ");
			}else {
				this.menuExampleView.antoolbar();
				System.out.printf("Bạn đã tắt: ");
			}
		}
		
		else {
			this.menuExampleView.Text("Bạn đã click: "+src);

		}
	}

}
