package Controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import View.NhanVienView;

public class NhanVienControllerMouseListener implements MouseListener {

	private NhanVienView nhanVienView;

	public NhanVienControllerMouseListener(NhanVienView nhanVienView) {
		this.nhanVienView = nhanVienView;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.isPopupTrigger())
		{
			this.nhanVienView.hienThiTTLenKhung();;
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
