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
			Integer maso = Integer.parseInt(this.nhanVienView.jtf_t1.getText());
			String ho = this.nhanVienView.jtf_t2.getText();
			String ten = this.nhanVienView.jtf_t3.getText()+"";
			boolean phai = this.nhanVienView.jrb_gt.isSelected() ? true : false;
			int tuoi = Integer.parseInt(this.nhanVienView.jtf_t4.getText());
			Double luong = Double.parseDouble(this.nhanVienView.jtf_t6.getText());
			NhanVien nv = new NhanVien(maso, ho, ten, false, tuoi, luong);
			this.nhanVienView.them(nv);			
			this.nhanVienView.xoaTrang();

//			String pt [] = {Integer.toString(maso), ho,ten, Boolean.toString(phai), Integer.toString(tuoi), luong+"" };
//			this.nhanVienView.tableModel.addRow(pt);
		}
		
	}	
	//private int maNV;
//	private String ho;
//	private String ten;
//	private boolean phai;
//	private int tuoi;
//	private double tienLuong;

}
