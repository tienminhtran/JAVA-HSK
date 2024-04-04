package GUI;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import dao.DonHangDao;
import dao.ThongKeDao;
import entity.DonHang;
import entity.ThongKe;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class THONGKE extends JPanel {
	private ThongKe tk;
	private ThongKeDao tk_daoDao;
	private JLabel lblNewLabel_sanpham;
	private JLabel lblNewLabel_nhanvien;
	private JLabel lblNewLabel_doanhthu;
	private JLabel lblNewLabel_khachhang;
	private DonHangDao dhdao;
	/**
	 * Create the panel.
	 */
	public THONGKE() {
		tk = new ThongKe();
		tk_daoDao =new ThongKeDao();
		dhdao = new DonHangDao();
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 0, 939, 556);
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
		lbNhanVien_1_1_1_1_1.setBounds(0, 0, 937, 47);
		panel_2_1.add(lbNhanVien_1_1_1_1_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(0, 1, 4, 1, (Color) new Color(0, 51, 204)));
		panel_1.setBackground(new Color(30, 115, 242));
		panel_1.setBounds(74, 101, 373, 178);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JLabel lblNewLabel = new JLabel("Số khách hàng hiện tại:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 17));
		lblNewLabel.setBounds(28, 119, 186, 35);
		panel_1.add(lblNewLabel);
		btnNewButton.setIcon(new ImageIcon("D:\\BAI_TAP_JAVA\\QLLK_NE\\src\\img\\thongKeKhachHang.png"));
		btnNewButton.setBounds(0, 0, 373, 120);
		panel_1.add(btnNewButton);
		
		 lblNewLabel_khachhang = new JLabel("...");
		lblNewLabel_khachhang.setForeground(Color.WHITE);
		lblNewLabel_khachhang.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_khachhang.setBounds(218, 119, 123, 35);
		panel_1.add(lblNewLabel_khachhang);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new MatteBorder(0, 1, 4, 1, (Color) new Color(153, 153, 51)));
		panel_1_1.setBackground(new Color(0, 128, 0));
		panel_1_1.setBounds(492, 101, 373, 178);
		panel.add(panel_1_1);
		panel_1_1.setLayout(null);
		
		JLabel lblTngDoanhThu = new JLabel("Tổng doanh thu hiện tại:");
		lblTngDoanhThu.setForeground(Color.WHITE);
		lblTngDoanhThu.setFont(new Font("Tahoma", Font.ITALIC, 17));
		lblTngDoanhThu.setBounds(15, 115, 186, 35);
		panel_1_1.add(lblTngDoanhThu);
		
		 lblNewLabel_doanhthu = new JLabel("...");
		lblNewLabel_doanhthu.setForeground(Color.WHITE);
		lblNewLabel_doanhthu.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_doanhthu.setBounds(211, 115, 123, 35);
		panel_1_1.add(lblNewLabel_doanhthu);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setIcon(new ImageIcon("D:\\BAI_TAP_JAVA\\QLLK_NE\\src\\img\\thongKeDoanhThu.png"));
		btnNewButton_3.setBounds(0, 0, 373, 121);
		panel_1_1.add(btnNewButton_3);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBorder(new MatteBorder(0, 1, 4, 1, (Color) new Color(255, 20, 147)));
		panel_1_2.setBackground(new Color(221, 0, 111));
		panel_1_2.setBounds(74, 324, 373, 178);
		panel.add(panel_1_2);
		panel_1_2.setLayout(null);
		
		 lblNewLabel_nhanvien = new JLabel("...");
		lblNewLabel_nhanvien.setForeground(Color.WHITE);
		lblNewLabel_nhanvien.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_nhanvien.setBounds(212, 111, 123, 35);
		panel_1_2.add(lblNewLabel_nhanvien);
		
		JLabel lblSNhnVin = new JLabel("Số nhân viên hiện tại:");
		lblSNhnVin.setForeground(Color.WHITE);
		lblSNhnVin.setFont(new Font("Tahoma", Font.ITALIC, 17));
		lblSNhnVin.setBounds(22, 111, 186, 35);
		panel_1_2.add(lblSNhnVin);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon("D:\\BAI_TAP_JAVA\\QLLK_NE\\src\\img\\thongKeNhanVien.png"));
		btnNewButton_1.setBounds(0, 0, 373, 110);
		panel_1_2.add(btnNewButton_1);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setBorder(new MatteBorder(0, 1, 4, 1, (Color) new Color(255, 204, 0)));
		panel_1_1_1.setBackground(new Color(201, 103, 14));
		panel_1_1_1.setBounds(492, 324, 373, 178);
		panel.add(panel_1_1_1);
		panel_1_1_1.setLayout(null);
		
		JLabel lblSSnPhm = new JLabel("Số sản phẩm hiện tại:");
		lblSSnPhm.setForeground(Color.WHITE);
		lblSSnPhm.setFont(new Font("Tahoma", Font.ITALIC, 17));
		lblSSnPhm.setBounds(10, 113, 186, 35);
		panel_1_1_1.add(lblSSnPhm);
		
		 lblNewLabel_sanpham = new JLabel("...");
		lblNewLabel_sanpham.setForeground(Color.WHITE);
		lblNewLabel_sanpham.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_sanpham.setBounds(200, 113, 123, 35);
		panel_1_1_1.add(lblNewLabel_sanpham);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon("D:\\BAI_TAP_JAVA\\QLLK_NE\\src\\img\\thongKesanpham.png"));
		btnNewButton_2.setBounds(0, 0, 373, 110);
		panel_1_1_1.add(btnNewButton_2);
		hienThiThongKe();

	}
	
	public void hienThiThongKe() {
		lblNewLabel_sanpham.setText(tk_daoDao.getTongSoLuongSP()+"");
		lblNewLabel_nhanvien.setText(tk_daoDao.getSoLuongNhanVien()+"");
		lblNewLabel_khachhang.setText(tk_daoDao.getSoLuongKhachHang()+"");
		double tongtien = 0;
		for (DonHang dh : dhdao.getAll()) {
			tongtien += dh.getTongtien();
		}
		
		lblNewLabel_doanhthu.setText(tongtien+"");
	}

}
