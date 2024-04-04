package Controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import view.MouseExampleView;

public class MouseExampleController implements MouseListener, MouseMotionListener{

	private MouseExampleView mouseExampleView;
	
	public MouseExampleController(MouseExampleView mouseExampleView) {
		this.mouseExampleView = mouseExampleView;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		this.mouseExampleView.dem_click();
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		this.mouseExampleView.divao();
		int x = e.getX();
		int y = e.getY();
		this.mouseExampleView.layToaDo(x,y);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		this.mouseExampleView.dira();

	}

	// chỉ lấy sự di chuyển của chuột mới lấy  MouseMotionListener
	// NẾU MÀ CHỈ CÓ CLASS MOUSE LISTEN THÌ TOẠ ĐỘ CHỈ HIỆN LÚC CHUỘT 
	// KHÔNG DI CHUYỂN CÒN DI CHUYỂN K HIỆN RA TOẠ ĐỘ
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		this.mouseExampleView.layToaDo(x,y);
		
	}

}
