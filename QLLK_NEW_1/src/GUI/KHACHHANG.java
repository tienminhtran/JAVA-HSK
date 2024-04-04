package GUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;
import dao.KhachHangDao;
import dao.SanPhamDao;
import entity.KhachHang;
import entity.SanPham;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;

public class KHACHHANG extends JPanel implements MouseListener{
	private DefaultTableModel tableModel;
	private JTextField textField_ma;
	private JTextField textField_ten;
	private JTextField textField_sdt;
	private JTextField textField_mail;
	private JTextField textField_4;
	private JTable table;
	private KhachHangDao khachHangDao;
	private ConnectDB connectDB;
	private JComboBox comboBox_gioitinh;
	private JTextArea textArea_diachi;

	/**
	 * Create the panel.
	 */
	public KHACHHANG() {
		khachHangDao = new KhachHangDao();
		connectDB = new ConnectDB();
		try {
			connectDB.connect();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 255, 255));
		panel.setBounds(0, 0, 939, 556);
		add(panel);
		panel.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(119, 255, 187));
		panel_2.setBounds(0, 0, 937, 47);
		panel.add(panel_2);

		JLabel lbNhanVien_1_1_1_1 = new JLabel("QUẢN LÝ KHÁCH HÀNG");
		lbNhanVien_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbNhanVien_1_1_1_1.setForeground(Color.RED);
		lbNhanVien_1_1_1_1.setFont(new Font("Arial", Font.BOLD, 25));
		lbNhanVien_1_1_1_1.setBackground(new Color(4, 255, 130));
		lbNhanVien_1_1_1_1.setBounds(0, 0, 937, 41);
		panel_2.add(lbNhanVien_1_1_1_1);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField_ma.setText("");
				textField_ten.setText("");
				textField_sdt.setText("");
				textField_mail.setText("");
				textArea_diachi.setText("");
				textField_ma.setText("");
				comboBox_gioitinh.setSelectedIndex(0);
				
			}
		});
		btnNewButton_3.setIcon(new ImageIcon("D:\\BAI_TAP_JAVA\\QLLK_NEW\\src\\img\\Refresh-icon.png"));
		btnNewButton_3.setForeground(new Color(0, 255, 127));
		btnNewButton_3.setBackground(new Color(0, 255, 127));
		btnNewButton_3.setBounds(616, 0, 46, 47);
		panel_2.add(btnNewButton_3);

		JLabel lbNhanVien_1_1_1 = new JLabel("QUẢN LÝ KHÁCH HÀNG");
		lbNhanVien_1_1_1.setBounds(0, 0, 937, 41);
		panel.add(lbNhanVien_1_1_1);
		lbNhanVien_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbNhanVien_1_1_1.setForeground(Color.RED);
		lbNhanVien_1_1_1.setFont(new Font("Arial", Font.BOLD, 25));
		lbNhanVien_1_1_1.setBackground(new Color(4, 255, 130));

		JLabel lblNewLabel_2 = new JLabel("Mã KH:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(99, 58, 46, 32);
		panel.add(lblNewLabel_2);

		textField_ma = new JTextField();
		textField_ma.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_ma.setColumns(10);
		textField_ma.setBounds(155, 58, 150, 33);
		panel.add(textField_ma);

		JLabel lblNewLabel_2_1 = new JLabel("Tên KH:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(360, 57, 59, 32);
		panel.add(lblNewLabel_2_1);

		textField_ten = new JTextField();
		textField_ten.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_ten.setColumns(10);
		textField_ten.setBounds(426, 58, 150, 33);
		panel.add(textField_ten);

		JLabel lblNewLabel_2_1_1 = new JLabel("Giới tính:");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_1.setBounds(616, 58, 68, 32);
		panel.add(lblNewLabel_2_1_1);

		 comboBox_gioitinh = new JComboBox();
		comboBox_gioitinh.setModel(new DefaultComboBoxModel(new String[] { "Nam", "Nữ" }));
		comboBox_gioitinh.setBounds(675, 58, 150, 33);
		panel.add(comboBox_gioitinh);

		JLabel lblNewLabel_2_2 = new JLabel("SĐT:");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_2.setBounds(99, 102, 46, 32);
		panel.add(lblNewLabel_2_2);

		textField_sdt = new JTextField();
		textField_sdt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_sdt.setColumns(10);
		textField_sdt.setBounds(155, 102, 150, 33);
		panel.add(textField_sdt);

		JLabel lblNewLabel_2_1_2 = new JLabel("Email:");
		lblNewLabel_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_2.setBounds(360, 101, 59, 32);
		panel.add(lblNewLabel_2_1_2);

		textField_mail = new JTextField();
		textField_mail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_mail.setColumns(10);
		textField_mail.setBounds(426, 102, 150, 33);
		panel.add(textField_mail);

		JLabel lblNewLabel_2_1_1_1 = new JLabel("Địa chỉ:");
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_1_1.setBounds(616, 102, 68, 32);
		panel.add(lblNewLabel_2_1_1_1);

		 textArea_diachi = new JTextArea();
		textArea_diachi.setBounds(675, 101, 150, 33);
		panel.add(textArea_diachi);

		table = new JTable();
		table.setModel(tableModel = new DefaultTableModel(new Object[][] {

		}, new String[] { "M\u00E3 KH", "T\u00EAn KH", "Gi\u1EDBi t\u00EDnh", "S\u0110T", "Email",
				"\u0110\u1ECBa ch\u1EC9" }));

		table.setFont(new Font("Arial", Font.PLAIN, 12));
		table.setBounds(0, 0, 1, 1);

		for (KhachHang kh : khachHangDao.getAll()) {
			Object[] rowData = {kh.getMaKH(), kh.getHoTenKH(), kh.getGioiTinh(), kh.getSdt(), kh.getEmail(), kh.getDiaChi()};
			tableModel.addRow(rowData);
		}
//		JScrollPane scrollPane = new JScrollPane(table);
//		scrollPane.setBounds(0, 46, 937, 350);
//		panel.add(scrollPane);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 145, 937, 350);
		panel.add(scrollPane);

		JLabel lblNewLabel = new JLabel("Tìm kiếm KH:");
		lblNewLabel.setBounds(29, 513, 110, 28);
		panel.add(lblNewLabel);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(149, 512, 150, 29);
		panel.add(textField_4);

		JButton btnNewButton_1 = new JButton("Tìm kiếm");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBackground(new Color(255, 182, 193));
		btnNewButton_1.setBounds(324, 506, 125, 42);
		panel.add(btnNewButton_1);

		JButton btnNewButton_1_1 = new JButton("Thêm");
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1_1.setBackground(new Color(0, 210, 0));
		btnNewButton_1_1.setBounds(486, 506, 125, 42);
		panel.add(btnNewButton_1_1);

		JButton btnNewButton_1_1_1 = new JButton("Xóa");
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1_1_1.setBackground(new Color(255, 128, 128));
		btnNewButton_1_1_1.setBounds(804, 506, 125, 42);
		panel.add(btnNewButton_1_1_1);

		JButton btnNewButton_1_1_2 = new JButton("Sửa");
		btnNewButton_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1_1_2.setBackground(new Color(219, 189, 70));
		btnNewButton_1_1_2.setBounds(646, 506, 125, 42);
		panel.add(btnNewButton_1_1_2);
		
		table.addMouseListener(this);
	}
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int hang = table.getSelectedRow();
		if (hang != -1) {
			textField_ma.setText(tableModel.getValueAt(hang, 0).toString());
			textField_ten.setText(tableModel.getValueAt(hang, 1).toString());
			if(table.getValueAt(hang, 2).equals("Nam")) {
				comboBox_gioitinh.setSelectedIndex(0);
			}else {
				comboBox_gioitinh.setSelectedIndex(1);

			}
			textField_sdt.setText(tableModel.getValueAt(hang, 3).toString());
			textField_mail.setText(tableModel.getValueAt(hang, 4).toString());
			textArea_diachi.setText(tableModel.getValueAt(hang, 5).toString());
		}

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
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
