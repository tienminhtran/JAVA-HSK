package Controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.MenuExampleView;

public class MenuExampleControllerListener implements MouseListener{

	private MenuExampleView menuExampleView;

	public MenuExampleControllerListener(MenuExampleView menuExampleView) {
		super();
		this.menuExampleView = menuExampleView;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.isPopupTrigger()) {
			this.menuExampleView.jpm.show(e.getComponent(), e.getX(), e.getY());
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.isPopupTrigger()) {
			this.menuExampleView.jpm.show(e.getComponent(), e.getX(), e.getY());
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
