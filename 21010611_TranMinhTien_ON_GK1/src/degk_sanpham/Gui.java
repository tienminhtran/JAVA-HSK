package degk_sanpham;

import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class Gui extends JFrame{

	private DanhMucSanPham danhMucSanPham;

	public Gui()  {
		danhMucSanPham = new DanhMucSanPham();
		this.setTitle("Bai giua ky");
		this.setSize(700,500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.init();
		this.setVisible(true);
		
	}

	private void init() {
		// TODO Auto-generated method stub
		JPanel jPanel_combobox = new JPanel();
			TitledBorder titledBorder_combobox = new TitledBorder("Thông tin sản phẩm"); 
	}
	public static void main(String[] args) {
		new Gui();
	}
	
}
