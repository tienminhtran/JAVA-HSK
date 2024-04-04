package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import View.NhanVienView;
import model.NhanVien;
import model.QLNVModel;

public class NhanVienController implements ActionListener{

	public NhanVienView nhanVienView;
	 
	public NhanVienController(NhanVienView nhanVienView) {
		this.nhanVienView = nhanVienView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		JOptionPane.showMessageDialog(nhanVienView, "Bạn vừa nhấn vào "+src);
		if(src.equals("Thêm"))
		{
			this.nhanVienView.themnv();
			this.nhanVienView.xoaTrang();
		}else if(src.equals("Xoá trắng")) {
			this.nhanVienView.xoaTrang();

		}else if(src.equals("Lưu"))
			this.nhanVienView.hienThiTTLenKhung();
		
	}	


}
