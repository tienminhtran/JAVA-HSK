package GUI;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import dao.ThongKeDao;
import entity.ThongKe;

public class THONGKE extends JPanel {

	private ThongKe tk;
	private ThongKeDao tk_daoDao;
	private JLabel lbl_spTK;
	private JLabel lbl_nvTK_1;
	private JLabel lbl_khTK_1_1;
	
	/**
	 * Create the panel.
	 */
	public THONGKE() {
		tk = new ThongKe();
		tk_daoDao =new ThongKeDao();
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 939, 556);
		add(panel);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(469, 5, 1, 1);
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(119, 255, 187));
		panel.add(panel_2);
		
		JLabel lbNhanVien_1_1_1_1 = new JLabel("QUẢN LÝ NHÂN VIÊN");
		lbNhanVien_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbNhanVien_1_1_1_1.setForeground(Color.RED);
		lbNhanVien_1_1_1_1.setFont(new Font("Arial", Font.BOLD, 25));
		lbNhanVien_1_1_1_1.setBackground(new Color(4, 255, 130));
		lbNhanVien_1_1_1_1.setBounds(0, 0, 937, 41);
		panel_2.add(lbNhanVien_1_1_1_1);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBackground(new Color(119, 255, 187));
		panel_2_1.setBounds(0, 0, 937, 47);
		panel.add(panel_2_1);
		
		JLabel lbNhanVien_1_1_1_1_1 = new JLabel("QUẢN LÝ THỐNG KÊ");
		lbNhanVien_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbNhanVien_1_1_1_1_1.setForeground(Color.RED);
		lbNhanVien_1_1_1_1_1.setFont(new Font("Arial", Font.BOLD, 25));
		lbNhanVien_1_1_1_1_1.setBackground(new Color(4, 255, 130));
		lbNhanVien_1_1_1_1_1.setBounds(0, 0, 937, 41);
		panel_2_1.add(lbNhanVien_1_1_1_1_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(0, 1, 4, 1, (Color) new Color(0, 51, 204)));
		panel_1.setBackground(new Color(0, 102, 255));
		panel_1.setBounds(74, 101, 373, 178);
		panel.add(panel_1);
		
			 lbl_spTK = new JLabel("");
			lbl_spTK.setFont(new Font("Tahoma", Font.BOLD, 20));
			lbl_spTK.setBounds(43, 64, 192, 29);
			panel_1.add(lbl_spTK);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new MatteBorder(0, 1, 4, 1, (Color) new Color(153, 153, 51)));
		panel_1_1.setBackground(new Color(51, 255, 153));
		panel_1_1.setBounds(492, 101, 373, 178);
		panel.add(panel_1_1);
		
			lbl_nvTK_1 = new JLabel("");
			lbl_nvTK_1.setBounds(51, 68, 100, 25);
			lbl_nvTK_1.setFont(new Font("Tahoma", Font.BOLD, 20));
			panel_1_1.add(lbl_nvTK_1);
		
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBorder(new MatteBorder(0, 1, 4, 1, (Color) new Color(255, 20, 147)));
		panel_1_2.setBackground(new Color(255, 182, 193));
		panel_1_2.setBounds(74, 324, 373, 178);
		panel.add(panel_1_2);
		
			lbl_khTK_1_1 = new JLabel("");
			lbl_khTK_1_1.setBounds(38, 60, 100, 25);
			lbl_khTK_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
			panel_1_2.add(lbl_khTK_1_1);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setBorder(new MatteBorder(0, 1, 4, 1, (Color) new Color(255, 204, 0)));
		panel_1_1_1.setBackground(Color.BLUE);
		panel_1_1_1.setBounds(492, 324, 373, 178);
		panel.add(panel_1_1_1);
		hienThiThongKe();

	}
	
	public void hienThiThongKe() {
		lbl_spTK.setText("Tổng số sản phẩm: "+tk_daoDao.getTongSoLuongSP());
		lbl_nvTK_1.setText("Tổng số nhân viên: "+tk_daoDao.getSoLuongNhanVien());
		lbl_khTK_1_1.setText("Tổng số khách hàng: "+tk_daoDao.getSoLuongKhachHang());
	}

}
