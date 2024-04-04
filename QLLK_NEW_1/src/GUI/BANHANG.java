package GUI;

import javax.swing.JPanel;

import java.awt.Canvas;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.sql.SQLException;

import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;
import dao.SanPhamDao;
import entity.SanPham;

import javax.swing.border.MatteBorder;
import java.awt.Component;
import java.awt.event.MouseAdapter;

public class BANHANG extends JPanel {
	private JTable table;
	private DefaultTableModel tableModel;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_mahd;
	private JTextField textField_makh;
	private JTextField textField_tenkh;
	private JTextField textField_ngaylap;
	private JTextField textField_sdt;
	private JTextField textField_diachi;
	private JTextField textField_10;
	private SanPhamDao sanPhamDao;
	private ConnectDB connectDB;

	/**
	 * Create the panel.
	 */
	public BANHANG() {
		sanPhamDao = new SanPhamDao();
		connectDB = new ConnectDB();
		try {
			connectDB.connect();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		setBackground(new Color(0, 255, 255));
		setLayout(null);



		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setBackground(new Color(0, 255, 255));
		panel.setBounds(0, 0, 474, 556);
		add(panel);
		panel.setLayout(null);

		table = new JTable();
		table.setModel(tableModel=new DefaultTableModel(new Object[][] {},
				new String[] { "M\u00E3 SP", "T\u00EAn SP", "M\u00F4 t\u1EA3", "\u0110\u01A1n gi\u00E1",
			 			"Lo\u1EA1i SP" }));

		table.setFont(new Font("Arial", Font.PLAIN, 14));
		table.setBounds(0, 0, 1, 1);
		for (SanPham sp : sanPhamDao.getAll()) {
			Object[] rowData = { sp.getMaLK(), sp.getTenLK(),sp.getMoTaLK(),sp.getDonGia(),sp.getLoaiLK()};
			tableModel.addRow(rowData);
		}
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 46, 474, 350);
		panel.add(scrollPane);

		JButton btnNewButton = new JButton("Thêm HD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setBounds(319, 474, 125, 42);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Tìm kiếm");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBackground(new Color(255, 182, 193));
		btnNewButton_1.setBounds(319, 421, 125, 42);
		panel.add(btnNewButton_1);

		JLabel lblNewLabel = new JLabel("Tổng số lượng:");
		lblNewLabel.setBounds(24, 481, 110, 28);
		panel.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(144, 480, 150, 29);
		panel.add(textField);
		textField.setColumns(10);

		JLabel lblTmKimSn = new JLabel("Tìm kiếm sản phẩm");
		lblTmKimSn.setBounds(24, 428, 110, 28);
		panel.add(lblTmKimSn);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(144, 427, 150, 29);
		panel.add(textField_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(119, 255, 187));
		panel_2.setBounds(0, 0, 474, 47);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lbNhanVien_1_1 = new JLabel("DANH SÁCH SẢN PHẨM");
		lbNhanVien_1_1.setBounds(0, 0, 474, 41);
		panel_2.add(lbNhanVien_1_1);
		lbNhanVien_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbNhanVien_1_1.setForeground(new Color(255, 0, 0));
		lbNhanVien_1_1.setFont(new Font("Arial", Font.BOLD, 25));
		lbNhanVien_1_1.setBackground(new Color(4, 255, 130));

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_1.setBackground(Color.CYAN);
		panel_1.setBounds(479, 46, 474, 510);
		add(panel_1);

		JButton btnNewButton_2 = new JButton("Thanh toán");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_2.setBackground(new Color(40, 148, 255));
		btnNewButton_2.setBounds(295, 435, 125, 42);
		panel_1.add(btnNewButton_2);

		JButton btnNewButton_1_1 = new JButton("Xóa");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1_1.setBackground(new Color(255, 128, 128));
		btnNewButton_1_1.setBounds(295, 369, 125, 42);
		panel_1.add(btnNewButton_1_1);

		JLabel lblNewLabel_1 = new JLabel("Số tiền khách đưa:");
		lblNewLabel_1.setBounds(15, 369, 110, 28);
		panel_1.add(lblNewLabel_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(122, 369, 147, 29);
		panel_1.add(textField_2);

		JLabel lblTmKimSn_1 = new JLabel("Số tiền trả khách:");
		lblTmKimSn_1.setBounds(15, 409, 110, 28);
		panel_1.add(lblTmKimSn_1);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(122, 408, 147, 29);
		panel_1.add(textField_3);

		JLabel lblNewLabel_2 = new JLabel("Mã HD:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 11, 46, 32);
		panel_1.add(lblNewLabel_2);

		textField_mahd = new JTextField();
		textField_mahd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_mahd.setColumns(10);
		textField_mahd.setBounds(66, 11, 150, 33);
		panel_1.add(textField_mahd);

		JLabel lblNewLabel_2_1 = new JLabel("Mã KH:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(10, 54, 46, 32);
		panel_1.add(lblNewLabel_2_1);

		textField_makh = new JTextField();
		textField_makh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_makh.setColumns(10);
		textField_makh.setBounds(66, 54, 150, 33);
		panel_1.add(textField_makh);

		JLabel lblNewLabel_2_1_1 = new JLabel("Tên KH:");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_1.setBounds(10, 97, 57, 32);
		panel_1.add(lblNewLabel_2_1_1);

		textField_tenkh = new JTextField();
		textField_tenkh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_tenkh.setColumns(10);
		textField_tenkh.setBounds(66, 97, 150, 33);
		panel_1.add(textField_tenkh);

		JLabel lblNewLabel_2_2 = new JLabel("Ngày lập:");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_2.setBounds(226, 10, 59, 32);
		panel_1.add(lblNewLabel_2_2);

		textField_ngaylap = new JTextField();
		textField_ngaylap.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_ngaylap.setColumns(10);
		textField_ngaylap.setBounds(295, 10, 150, 33);
		panel_1.add(textField_ngaylap);

		JLabel lblNewLabel_2_1_2 = new JLabel("SĐT:");
		lblNewLabel_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_2.setBounds(226, 53, 59, 32);
		panel_1.add(lblNewLabel_2_1_2);

		textField_sdt = new JTextField();
		textField_sdt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_sdt.setColumns(10);
		textField_sdt.setBounds(295, 53, 150, 33);
		panel_1.add(textField_sdt);

		JLabel lblNewLabel_2_1_1_1 = new JLabel("Địa chỉ:");
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_1_1.setBounds(226, 96, 70, 32);
		panel_1.add(lblNewLabel_2_1_1_1);

		textField_diachi = new JTextField();
		textField_diachi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_diachi.setColumns(10);
		textField_diachi.setBounds(295, 96, 150, 33);
		panel_1.add(textField_diachi);

		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 SP", "T\u00EAn SP", "B\u1EA3o h\u00E0nh", "S\u1ED1 l\u01B0\u1EE3ng", "T\u1ED5ng ti\u1EC1n"
			}
		));

		table.setFont(new Font("Arial", Font.PLAIN, 12));
		table.setBounds(0, 0, 1, 1);
		JScrollPane scrollPane_1 = new JScrollPane(table);
		scrollPane_1.setBounds(10, 140, 435, 210);
		panel_1.add(scrollPane_1);
		
		JLabel lblTmKimSn_1_1 = new JLabel("Tổng tiền:");
		lblTmKimSn_1_1.setBounds(15, 449, 110, 28);
		panel_1.add(lblTmKimSn_1_1);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(122, 448, 147, 29);
		panel_1.add(textField_10);

		JPanel panelNhanVien_1 = new JPanel();
		panelNhanVien_1.setLayout(null);
		panelNhanVien_1.setBackground(new Color(0, 225, 113));
		panelNhanVien_1.setBounds(479, 0, 474, 47);
		add(panelNhanVien_1);

		JLabel lbNhanVien_1 = new JLabel("HÓA ĐƠN ĐẶT HÀNG");

		lbNhanVien_1.setBackground(new Color(4, 255, 130));
		lbNhanVien_1.setBounds(0, 0, 466, 47);
		panelNhanVien_1.add(lbNhanVien_1);
		lbNhanVien_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbNhanVien_1.setForeground(new Color(255, 255, 255));
		lbNhanVien_1.setFont(new Font("Arial", Font.BOLD, 25));
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField_sdt.setText("");
				textField_tenkh.setText("");
				textField_diachi.setText("");
			}
		});
		btnNewButton_3.setForeground(new Color(0, 255, 127));
		btnNewButton_3.setBackground(new Color(0, 255, 127));
		btnNewButton_3.setIcon(new ImageIcon("D:\\BAI_TAP_JAVA\\QLLK_NEW\\src\\img\\Refresh-icon.png"));
		btnNewButton_3.setBounds(377, 0, 46, 47);
		panelNhanVien_1.add(btnNewButton_3);



	}
}
