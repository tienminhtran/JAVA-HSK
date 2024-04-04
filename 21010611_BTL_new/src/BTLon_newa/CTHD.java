package BTLon_newa;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class CTHD extends JFrame implements ActionListener{

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CTHD frame = new CTHD();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private JLabel jLabel_maHD;
	private JPanel contentPane;
	private JLabel jlabel_timKiem;
	private JTextField jTextField_maHD;

	/**
	 * Create the frame.
	 */
	public CTHD() {
		setSize(900, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
//		setBounds(0, -15, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder("Thông tin Chi tiết hóa đơn"));
		panel.setToolTipText("Thông tin");
		panel.setBounds(10, 33, 874, 140);
		contentPane.add(panel);
		panel.setLayout(null);

		jlabel_timKiem = new JLabel("Tìm kiếm:");
		jlabel_timKiem.setFont(new Font("Tahoma", Font.BOLD, 11));
		jlabel_timKiem.setBounds(193, 13, 77, 17);
		panel.add(jlabel_timKiem);

		JTextField jTextField_timKiem = new JTextField();
		jTextField_timKiem.setBounds(270, 11, 406, 20);
		panel.add(jTextField_timKiem);
		jTextField_timKiem.setColumns(10);

		jLabel_maHD = new JLabel("Mã HĐ:");
		jLabel_maHD.setFont(new Font("Tahoma", Font.BOLD, 11));
		jLabel_maHD.setBounds(10, 52, 54, 21);
		panel.add(jLabel_maHD);

		jTextField_maHD = new JTextField();
		jTextField_maHD.setBounds(90, 52, 200, 20);
		panel.add(jTextField_maHD);
		jTextField_maHD.setColumns(10);

		JLabel jLabel_maKH = new JLabel("Mã KH:");
		jLabel_maKH.setFont(new Font("Tahoma", Font.BOLD, 11));
		jLabel_maKH.setBounds(300, 52, 54, 21);
		panel.add(jLabel_maKH);

		JTextField jTextField_maKH = new JTextField();
		jTextField_maKH.setBounds(360, 52, 213, 20);
		panel.add(jTextField_maKH);
		jTextField_maKH.setColumns(10);
		
		JLabel jLabel_maNV = new JLabel("Mã NV:");
		jLabel_maNV.setFont(new Font("Tahoma", Font.BOLD, 11));
		jLabel_maNV.setBounds(590, 52, 54, 21);
		panel.add(jLabel_maNV);

		JTextField jTextField_maNV = new JTextField();
		jTextField_maNV.setBounds(655, 52, 213, 20);
		panel.add(jTextField_maNV);
		jTextField_maNV.setColumns(10);
		
		JLabel jLabel_loaiHang = new JLabel("Loại Hàng:");
		jLabel_loaiHang.setFont(new Font("Tahoma", Font.BOLD, 11));
		jLabel_loaiHang.setBounds(10, 82, 70, 21);
		panel.add(jLabel_loaiHang);
		
		String loaiHang[] = {};
		JComboBox cb_loaiHang = new JComboBox();
		cb_loaiHang.setBounds(90, 82, 200, 20);
		panel.add(cb_loaiHang);
		
		JLabel jLabel_giaBan = new JLabel("Giá bán:");
		jLabel_giaBan.setFont(new Font("Tahoma", Font.BOLD, 11));
		jLabel_giaBan.setBounds(300, 82, 54, 21);
		panel.add(jLabel_giaBan);

		JTextField jTextField_giaBan = new JTextField();
		jTextField_giaBan.setBounds(360, 82, 213, 20);
		panel.add(jTextField_giaBan);
		jTextField_giaBan.setColumns(10);
		
		JLabel jLabel_soLuong = new JLabel("Số Lượng:");
		jLabel_soLuong.setFont(new Font("Tahoma", Font.BOLD, 11));
		jLabel_soLuong.setBounds(590, 82, 70, 21);
		panel.add(jLabel_soLuong);

		JTextField jTextField_soLuong = new JTextField();
		jTextField_soLuong.setBounds(655, 82, 213, 20);
		panel.add(jTextField_soLuong);
		jTextField_soLuong.setColumns(10);
		
		JLabel jLabel_mucGiamGia = new JLabel("Mức giảm giá:");
		jLabel_mucGiamGia.setFont(new Font("Tahoma", Font.BOLD, 11));
		jLabel_mucGiamGia.setBounds(10, 112, 100, 21);
		panel.add(jLabel_mucGiamGia);
		
		String mucGiamGia[] = {};
		JComboBox cb_mucGiamGia = new JComboBox();
		cb_mucGiamGia.setBounds(90, 112, 200, 20);
		panel.add(cb_mucGiamGia);

		JLabel jLabel_maSP = new JLabel("Mã SP:");
		jLabel_maSP.setFont(new Font("Tahoma", Font.BOLD, 11));
		jLabel_maSP.setBounds(300, 112, 54, 21);
		panel.add(jLabel_maSP);

		JTextField jTextField_maSP = new JTextField();
		jTextField_maSP.setBounds(360, 112, 213, 20);
		panel.add(jTextField_maSP);
		jTextField_maSP.setColumns(10);
		
		JLabel jLabel_thanhTien = new JLabel("Thành tiền:");
		jLabel_thanhTien.setFont(new Font("Tahoma", Font.BOLD, 11));
		jLabel_thanhTien.setBounds(590, 112, 70, 21);
		panel.add(jLabel_thanhTien);

		JTextField jTextField_thanhTien = new JTextField();
		jTextField_thanhTien.setBounds(655, 112, 213, 20);
		panel.add(jTextField_thanhTien);
		jTextField_thanhTien.setColumns(10);


		
		JButton button_loc = new JButton("Lọc");
		button_loc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_loc.setBounds(684, 10, 89, 23);
		panel.add(button_loc);
		
		Canvas canvas = new Canvas();
		canvas.setBounds(20, -28, 47, 23);
		panel.add(canvas);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 172, 874, 45);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(128, 255, 255));
		btnNewButton.setBounds(195, 11, 89, 23);
		panel_1.add(btnNewButton);

		JButton btnXa = new JButton("Xóa");
		btnXa.setBackground(new Color(0, 255, 128));
		btnXa.setBounds(298, 11, 89, 23);
		panel_1.add(btnXa);

		JButton btnSa = new JButton("Sửa");
		btnSa.setBackground(new Color(255, 128, 255));
		btnSa.setBounds(405, 11, 89, 23);
		panel_1.add(btnSa);

		JButton btnXaTrng = new JButton("Xóa trắng");
		btnXaTrng.setBackground(new Color(255, 128, 128));
		btnXaTrng.setBounds(508, 11, 89, 23);
		panel_1.add(btnXaTrng);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 228, 874, 265);

		DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn("Mã HĐ");
		tableModel.addColumn("Mã KH");
		tableModel.addColumn("Mã NV");
		tableModel.addColumn("Loại hàng");
		tableModel.addColumn("Giá bán");
		tableModel.addColumn("Số lượng");
		tableModel.addColumn("Mức giảm giá");
		tableModel.addColumn("Mã SP");
		tableModel.addColumn("Thành tiền");
		panel_2.setLayout(null);
		JTable table = new JTable(tableModel);
		JScrollPane jbs = new JScrollPane(table);
		jbs.setBounds(0, 11, 874, 252);
		panel_2.add(jbs);
		contentPane.add(panel_2);

		JLabel lblNewLabel_1 = new JLabel(" @ Copy rigth _ Mua bán link kiện");
		lblNewLabel_1.setBackground(new Color(240, 240, 240));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel_1.setBounds(400, 536, 202, 14);
		contentPane.add(lblNewLabel_1);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}

