package GUI;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import connectDB.ConnectDB;
import dao.SanPhamDao;
import entity.NhanVien;
import entity.SanPham;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Component;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class SANPHAM extends JPanel implements MouseListener{
	private JTextField textField_ma;
	private JTextField textField_tensp;
	private JTextField textField_sl;
	private JTextField textField_dongia;
	private JTextField textField_ngaynhap;
	private JTextField textField_baohanh;
	private JTable table;
	private JTextField textField_tim;
	private SanPhamDao sanPhamDao;
	private ConnectDB connectDB;
	private DefaultTableModel tableModel;
	private JComboBox comboBox_loai;
	private JTextArea textArea_mota;
	private JComboBox comboBox_thhieu;
	private DefaultComboBoxModel model;

	/**
	 * Create the panel.
	 */
	public SANPHAM() {
		sanPhamDao = new SanPhamDao();
		connectDB = new ConnectDB();
		try {
			connectDB.connect();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 939, 556);
		panel.setBackground(new Color(0, 255, 255));

		add(panel);
		panel.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(0, 255, 255));
		panel_2.setBounds(0, 0, 937, 47);
		panel.add(panel_2);

		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBackground(new Color(119, 255, 187));
		panel_2_1.setBounds(0, 0, 937, 47);
		panel_2.add(panel_2_1);

		JLabel lbNhanVien_1_1_1_1 = new JLabel("QUẢN LÝ SẢN PHẨM");
		lbNhanVien_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbNhanVien_1_1_1_1.setForeground(Color.RED);
		lbNhanVien_1_1_1_1.setFont(new Font("Arial", Font.BOLD, 25));
		lbNhanVien_1_1_1_1.setBackground(new Color(4, 255, 130));
		lbNhanVien_1_1_1_1.setBounds(0, 0, 937, 41);
		panel_2_1.add(lbNhanVien_1_1_1_1);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField_ma.setText("");
				textField_tensp.setText("");
				comboBox_loai.setSelectedIndex(0);
				textField_dongia.setText("");
				textField_sl.setText("");
				textArea_mota.setText("");
				textField_ngaynhap.setText("");
				comboBox_thhieu.setSelectedIndex(0);
				textField_baohanh.setText("");
			}
		});
		btnNewButton_3.setIcon(new ImageIcon("D:\\BAI_TAP_JAVA\\QLLK_NEW\\src\\img\\Refresh-icon.png"));
		btnNewButton_3.setForeground(new Color(0, 255, 127));
		btnNewButton_3.setBackground(new Color(0, 255, 127));
		btnNewButton_3.setBounds(602, 0, 46, 47);
		panel_2_1.add(btnNewButton_3);

		JLabel lblNewLabel_2 = new JLabel("Mã SP:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(98, 60, 91, 32);
		panel.add(lblNewLabel_2);

		textField_ma = new JTextField();
		textField_ma.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_ma.setColumns(10);
		textField_ma.setBounds(199, 58, 150, 33);
		panel.add(textField_ma);

		JLabel lblNewLabel_2_1 = new JLabel("Tên SP:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(359, 59, 91, 32);
		panel.add(lblNewLabel_2_1);

		textField_tensp = new JTextField();
		textField_tensp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_tensp.setColumns(10);
		textField_tensp.setBounds(448, 58, 150, 33);
		panel.add(textField_tensp);

		JLabel lblNewLabel_2_1_1 = new JLabel("Loại:");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_1.setBounds(615, 60, 78, 32);
		panel.add(lblNewLabel_2_1_1);

		comboBox_loai = new JComboBox();
		comboBox_loai.setModel(new DefaultComboBoxModel(new String[] { "Intel", "CPU","RAM","Màn hình", "Chuột", "Bàn phím", "Loa", "Tai nghe" }));
		comboBox_loai.setBounds(703, 58, 150, 33);
		panel.add(comboBox_loai);

		JLabel lblNewLabel_2_2 = new JLabel("Số lượng:");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_2.setBounds(98, 120, 91, 32);
		panel.add(lblNewLabel_2_2);

		textField_sl = new JTextField();
		textField_sl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_sl.setColumns(10);
		textField_sl.setBounds(199, 118, 150, 33);
		panel.add(textField_sl);

		JLabel lblNewLabel_2_1_2 = new JLabel("Đơn giá:");
		lblNewLabel_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_2.setBounds(359, 119, 91, 32);
		panel.add(lblNewLabel_2_1_2);

		textField_dongia = new JTextField();
		textField_dongia.setToolTipText(">0");

		textField_dongia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_dongia.setColumns(10);
		textField_dongia.setBounds(448, 118, 150, 33);
		panel.add(textField_dongia);

		JLabel lblNewLabel_2_1_1_1 = new JLabel("Mô tả:");
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_1_1.setBounds(615, 120, 78, 32);
		panel.add(lblNewLabel_2_1_1_1);

		textArea_mota = new JTextArea();
		textArea_mota.setBounds(703, 119, 150, 33);
		panel.add(textArea_mota);

		JLabel lblNewLabel_2_2_1 = new JLabel("Ngày nhập:");
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_2_1.setBounds(98, 179, 91, 32);
		panel.add(lblNewLabel_2_2_1);

		textField_ngaynhap = new JTextField();
		textField_ngaynhap.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_ngaynhap.setColumns(10);
		textField_ngaynhap.setBounds(199, 177, 150, 33);
		panel.add(textField_ngaynhap);

		JLabel lblNewLabel_2_1_2_1 = new JLabel("Thương hiệu:");
		lblNewLabel_2_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_2_1.setBounds(359, 178, 91, 32);
		panel.add(lblNewLabel_2_1_2_1);

		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Bảo hành:");
		lblNewLabel_2_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_1_1_1.setBounds(615, 179, 78, 32);
		panel.add(lblNewLabel_2_1_1_1_1);

		comboBox_thhieu = new JComboBox();
		comboBox_thhieu.setModel(new DefaultComboBoxModel(new String[] { "Dell", "Asus", "Intel", "SamSum","Iphone","ViewSonic", "MSI", "ASUS" }));
		comboBox_thhieu.setBounds(448, 178, 150, 33);
		panel.add(comboBox_thhieu);

		textField_baohanh = new JTextField();
		textField_baohanh.setBounds(703, 181, 150, 33);
		panel.add(textField_baohanh);
		textField_baohanh.setColumns(10);

		table = new JTable();

		table.setModel(tableModel = new DefaultTableModel(new Object[][] {},
				new String[] { "M\u00E3 SP", "T\u00EAn SP", "Lo\u1EA1i", "\u0110\u01A1n gi\u00E1",
						"S\u1ED1 l\u01B0\u1EE3ng", "M\u00F4 t\u1EA3", "Ng\u00E0y nh\u1EADp",
						"Th\u01B0\u01A1ng hi\u1EC7u", "B\u1EA3o h\u00E0nh" }));

		table.setFont(new Font("Arial", Font.PLAIN, 12));
		table.setBounds(0, 0, 1, 1);
		for (SanPham sp : sanPhamDao.getAll()) {
			Object[] rowData = { sp.getMaLK(), sp.getTenLK(), sp.getLoaiLK(), sp.getDonGia(), sp.getSoLuongTon(),
					sp.getMoTaLK(), sp.getNgayNhap(), sp.getThuongHieu(), sp.getBaoHanh() };
			tableModel.addRow(rowData);
		}

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 222, 937, 270);
		panel.add(scrollPane);

		JLabel lblTmKimSp = new JLabel("Tìm kiếm SP:");
		lblTmKimSp.setBounds(29, 510, 110, 28);
		panel.add(lblTmKimSp);

		textField_tim = new JTextField();
		textField_tim.setColumns(10);
		textField_tim.setBounds(149, 509, 150, 29);
		panel.add(textField_tim);

		JButton btnNewButton_tim = new JButton("Tìm kiếm");
		btnNewButton_tim.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_tim.setBackground(new Color(255, 182, 193));
		btnNewButton_tim.setBounds(324, 503, 125, 42);
		panel.add(btnNewButton_tim);

		JButton btnNewButton_them = new JButton("Thêm");



		btnNewButton_them.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_them.setBackground(new Color(0, 210, 0));
		btnNewButton_them.setBounds(486, 503, 125, 42);
		panel.add(btnNewButton_them);

		JButton btnNewButton_sua = new JButton("Sửa");
		btnNewButton_sua.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_sua.setBackground(new Color(219, 189, 70));
		btnNewButton_sua.setBounds(646, 503, 125, 42);
		panel.add(btnNewButton_sua);

		JButton btnNewButton_xoa = new JButton("Xóa");
		btnNewButton_xoa.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_xoa.setBackground(new Color(255, 128, 128));
		btnNewButton_xoa.setBounds(804, 503, 125, 42);
		panel.add(btnNewButton_xoa);

		// KIE6N5 KIE6N5 TABLEE.
//		napdulieu_loai();
//		napdulieu_thuonghieu();
		table.addMouseListener(this);

	}


//
//	public void napdulieu_loai() {
//	    Set<String> loaiSet = new HashSet<>();
//	    for (int i = 0; i < table.getRowCount(); i++) {
//	        String loai = table.getValueAt(i, 2).toString();
//	        loaiSet.add(loai);
//	    }
//	    DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(loaiSet.toArray(new String[0]));
//	    comboBox_loai.setModel(model);
//	}
//	public void napdulieu_thuonghieu() {
//	    Set<String> thuonghieuset = new HashSet<>();
//	    for (int i = 0; i < table.getRowCount(); i++) {
//	        String loai = table.getValueAt(i, 7).toString();
//	        thuonghieuset.add(loai);
//	    }
//	    DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(thuonghieuset.toArray(new String[0]));
//	    comboBox_thhieu.setModel(model);
//	}

	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int hang = table.getSelectedRow();
		if (hang != -1) {
			textField_ma.setText(tableModel.getValueAt(hang, 0).toString());
			textField_tensp.setText(tableModel.getValueAt(hang, 1).toString());
			comboBox_loai.setSelectedItem(tableModel.getValueAt(hang, 2).toString());
			textField_dongia.setText(tableModel.getValueAt(hang, 3).toString());
			textField_sl.setText(tableModel.getValueAt(hang, 4).toString());
			textArea_mota.setText(tableModel.getValueAt(hang, 5).toString());
			textField_ngaynhap.setText(tableModel.getValueAt(hang, 6).toString());
			comboBox_thhieu.setSelectedItem(tableModel.getValueAt(hang, 7).toString());
			textField_baohanh.setText(tableModel.getValueAt(hang, 8).toString());
			
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
	
	
//	if (!jtext_malop.getText().equals(" ")) {
//	LopHoc lop = new LopHoc(jtext_malop.getText(), jtext_tenlop.getText(), jtext_gvcn.getText());
//	lop_Dao.addLop(lop);
//	JOptionPane.showMessageDialog(this, "Thêm thành công");
//	Object[] rowData = { lop.getMalop(), lop.getTenlop(), lop.getGiaovienCN() };
//	model.addRow(rowData);
//} else {
//	JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin để lưu học viên");
//
//}
//
//}
}

