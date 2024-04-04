package GUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;
import dao.KhachHangDao;
import dao.NhanVienDao;
import entity.KhachHang;
import entity.NhanVien;
import entity.SanPham;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;

public class NHANVIEN extends JPanel implements MouseListener, ActionListener {
	private DefaultTableModel tableModel;
	private JTextField textField_ma;
	private JTextField textField_ten;
	private JTextField textField_sdt;
	private JTextField textField_4;
	private JTable table;
	private NhanVienDao nhanVienDao;
	private ConnectDB connectDB;
	private JTextArea textArea_diachi;
	private JComboBox comboBox_gioitinh;
	private JComboBox comboBox_chucvu;
	private JPasswordField passwordField_pass;
	private JButton btnNewButton_them;
	private JButton btnNewButton_xoa;
	private JButton btnNewButton_sua;
	private JButton btnNewButton_tim;

	/**
	 * Create the panel.
	 */
	public NHANVIEN() {
		nhanVienDao = new NhanVienDao();
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

		JLabel lbNhanVien_1_1_1_1 = new JLabel("QUẢN LÝ NHÂN VIÊN");
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
				passwordField_pass.setText("");
				comboBox_gioitinh.setSelectedIndex(0);
				textField_sdt.setText("");
				comboBox_chucvu.setSelectedIndex(0);
				textArea_diachi.setText("");

			}
		});
		btnNewButton_3.setIcon(new ImageIcon("D:\\BAI_TAP_JAVA\\QLLK_NE\\src\\img\\Refresh-icon.png"));
		btnNewButton_3.setForeground(new Color(128, 255, 128));
		btnNewButton_3.setBackground(new Color(0, 255, 127));
		btnNewButton_3.setBounds(880, 0, 46, 45);
		panel_2.add(btnNewButton_3);

		JLabel lbNhanVien_1_1_1 = new JLabel("QUẢN LÝ KHÁCH HÀNG");
		lbNhanVien_1_1_1.setBounds(0, 0, 937, 41);
		panel.add(lbNhanVien_1_1_1);
		lbNhanVien_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbNhanVien_1_1_1.setForeground(Color.RED);
		lbNhanVien_1_1_1.setFont(new Font("Arial", Font.BOLD, 25));
		lbNhanVien_1_1_1.setBackground(new Color(4, 255, 130));

		JLabel lblNewLabel_2 = new JLabel("Mã NV:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(99, 58, 46, 32);
		panel.add(lblNewLabel_2);

		textField_ma = new JTextField();
		textField_ma.setEditable(false);
		textField_ma.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_ma.setColumns(10);
		textField_ma.setBounds(155, 58, 150, 33);
		panel.add(textField_ma);

		JLabel lblNewLabel_2_1 = new JLabel("Tên NV:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(360, 57, 59, 32);
		panel.add(lblNewLabel_2_1);

		textField_ten = new JTextField();
		textField_ten.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_ten.setColumns(10);
		textField_ten.setBounds(426, 58, 180, 33);
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

		JLabel lblNewLabel_2_1_2 = new JLabel("Chức vụ:");
		lblNewLabel_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_2.setBounds(360, 101, 59, 32);
		panel.add(lblNewLabel_2_1_2);

		JLabel lblNewLabel_2_1_1_1 = new JLabel("Địa chỉ:");
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_1_1.setBounds(616, 102, 68, 32);
		panel.add(lblNewLabel_2_1_1_1);

		textArea_diachi = new JTextArea();
		textArea_diachi.setBounds(675, 101, 150, 33);
		panel.add(textArea_diachi);

		table = new JTable();
		table.setModel(tableModel = new DefaultTableModel(new Object[][] {}, new String[] { "M\u00E3 NV", "T\u00EAn NV",
				"Password", "Gi\u1EDBi t\u00EDnh", "S\u0110T", "Ch\u1EE9c v\u1EE5", "\u0110\u1ECBa ch\u1EC9" }));

		table.setFont(new Font("Arial", Font.PLAIN, 12));
		table.setBounds(0, 0, 1, 1);

		for (NhanVien nv : nhanVienDao.getAll()) {
			Object[] rowData = { nv.getMaNV(), nv.getHoTen(), nv.getMK(), nv.getGioiTinh(), nv.getSdt(), nv.getChucVu(),
					nv.getDiachi() };
			tableModel.addRow(rowData);
		}
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 145, 937, 350);
		panel.add(scrollPane);

		JLabel lblNewLabel = new JLabel("Tìm kiếm NV:");
		lblNewLabel.setBounds(29, 513, 110, 28);
		panel.add(lblNewLabel);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(149, 509, 150, 29);
		panel.add(textField_4);

		btnNewButton_tim = new JButton("Tìm kiếm");
		btnNewButton_tim.setIcon(new ImageIcon("D:\\BAI_TAP_JAVA\\QLLK_NE\\src\\img\\Search-icon.png"));
		btnNewButton_tim.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_tim.setBackground(new Color(255, 182, 193));
		btnNewButton_tim.setBounds(324, 506, 135, 42);
		panel.add(btnNewButton_tim);

		btnNewButton_them = new JButton("Thêm");
		btnNewButton_them.setIcon(new ImageIcon("D:\\BAI_TAP_JAVA\\QLLK_NE\\src\\img\\add-icon.png"));
		btnNewButton_them.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_them.setBackground(new Color(0, 210, 0));
		btnNewButton_them.setBounds(486, 506, 125, 42);
		panel.add(btnNewButton_them);

		btnNewButton_xoa = new JButton("Xóa");
		btnNewButton_xoa.setIcon(new ImageIcon("D:\\BAI_TAP_JAVA\\QLLK_NE\\src\\img\\delete-icon.png"));
		btnNewButton_xoa.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_xoa.setBackground(new Color(255, 128, 128));
		btnNewButton_xoa.setBounds(804, 506, 125, 42);
		panel.add(btnNewButton_xoa);

		btnNewButton_sua = new JButton("Sửa");
		btnNewButton_sua.setIcon(new ImageIcon("D:\\BAI_TAP_JAVA\\QLLK_NE\\src\\img\\Pencil-icon.png"));
		btnNewButton_sua.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_sua.setBackground(new Color(219, 189, 70));
		btnNewButton_sua.setBounds(646, 506, 125, 42);
		panel.add(btnNewButton_sua);

		comboBox_chucvu = new JComboBox();
		comboBox_chucvu.setFont(new Font("Tahoma", Font.PLAIN, 10));
		comboBox_chucvu.setModel(new DefaultComboBoxModel(new String[] { "Admin", "User" }));
		comboBox_chucvu.setBounds(426, 104, 59, 33);
		panel.add(comboBox_chucvu);

		JLabel lblNewLabel_2_1_2_1 = new JLabel("Pass:");
		lblNewLabel_2_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_2_1.setBounds(491, 101, 37, 32);
		panel.add(lblNewLabel_2_1_2_1);

		passwordField_pass = new JPasswordField();
		passwordField_pass.setBounds(525, 101, 81, 33);
		panel.add(passwordField_pass);

		// Xử lý sự kiện
		btnNewButton_them.addActionListener(this);
		btnNewButton_sua.addActionListener(this);
		btnNewButton_xoa.addActionListener(this);
		btnNewButton_tim.addActionListener(this);

		table.addMouseListener(this);
//		napdulieu_chucvu();
	}
//	public void napdulieu_chucvu() {
//	    Set<String> loaiSet = new HashSet<>();
//	    for (int i = 0; i < table.getRowCount(); i++) {
//	        String loai = table.getValueAt(i, 4).toString();
//	        loaiSet.add(loai);
//	    }
//	    DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(loaiSet.toArray(new String[0]));
//	    comboBox_chucvu.setModel(model);
//	}

	public void them() {
		if (textField_ten.getText().equals("") || textField_sdt.getText().equals("") || textArea_diachi.getText().equals("") || passwordField_pass.getText().equals("")) 
		{
			JOptionPane.showMessageDialog(null, "Dữ liệu không rỗng !", "Cảnh báo",
					JOptionPane.ERROR_MESSAGE);
		}
		else {
			String ma = textField_ma.getText();
			String hoten = textField_ten.getText();
			Pattern pattern_tenNV = Pattern.compile("^[a-zA-Z\\s]+{2,20}$");
			Matcher matcher_tenNV = pattern_tenNV.matcher(hoten);
			String mk = passwordField_pass.getText().toString();
			Pattern pattern_mk = Pattern.compile("^\\w{3,}");
			Matcher matcher_mk = pattern_mk.matcher(mk);
			String gioitinh = comboBox_gioitinh.getSelectedItem().toString();
			String chucvu = comboBox_chucvu.getSelectedItem().toString();
			String sdt = textField_sdt.getText();
			Pattern pattern_sdt = Pattern.compile("^0\\d{9}$");
			Matcher matcher_sdt = pattern_sdt.matcher(sdt);
			String diachi = textArea_diachi.getText();
			Pattern pattern_diaChi = Pattern.compile("\\d+\\s+[\\w\\s]+");
			Matcher matcher_diaChi = pattern_diaChi.matcher(diachi);

			if (!matcher_sdt.matches()) {
				JOptionPane.showMessageDialog(null, "Số điện thoại phải là 10 số !", "Cảnh báo", JOptionPane.ERROR_MESSAGE);
				textField_sdt.setText("");
				return;
			}
			
			if (!matcher_mk.matches()) {
				JOptionPane.showMessageDialog(null, "Mật khẩu phải có ít nhất 3 ký tự !", "Cảnh báo", JOptionPane.ERROR_MESSAGE);
				passwordField_pass.setText("");
				return;
			}


			else {
				NhanVien nv = new NhanVien(ma, hoten, mk, gioitinh, chucvu, sdt, diachi);
				nhanVienDao.insert(nv);

				Object[] row = new Object[7];
				row[0] = "Reset...";
				row[1] = nv.getHoTen();
				row[2] = nv.getMK();
				row[3] = nv.getGioiTinh();
				row[4] = nv.getChucVu();
				row[5] = nv.getSdt();
				row[6] = nv.getDiachi();
				tableModel.addRow(row);
				JOptionPane.showMessageDialog(this, "Thêm thành công");
				refreshData();
			}
		}
	}

	public void xoa() {
		int row = table.getSelectedRow();
		if (row != -1) {
			String ma = table.getValueAt(row, 0).toString();
			nhanVienDao.delete(ma);
			tableModel.removeRow(row);
		} else {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập chọn một dòng để xóa");
		}
	}

	public void sua() {
		String ma = textField_ma.getText();
		String hoten = textField_ten.getText();
		String mk = passwordField_pass.getText().toString();
		String gioitinh = comboBox_gioitinh.getSelectedItem().toString();
		String chucvu = comboBox_chucvu.getSelectedItem().toString();
		String sdt = textField_sdt.getText();
		String diachi = textArea_diachi.getText();
		int row = table.getSelectedRow();
		if (row != -1) {
			NhanVien nv = new NhanVien(ma, hoten, mk, gioitinh, chucvu, sdt, diachi);
			nhanVienDao.update(nv);
			table.setValueAt(nv.getHoTen(), row, 1);
			table.setValueAt(nv.getMK(), row, 2);
			table.setValueAt(nv.getGioiTinh(), row, 3);
			table.setValueAt(nv.getSdt(), row, 4);
			table.setValueAt(nv.getChucVu(), row, 5);
			table.setValueAt(nv.getDiachi(), row, 6);
			JOptionPane.showMessageDialog(this, "Cập nhật thành công!");

		} else {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập chọn một dòng để sửa");

		}
	}

	public void timKiem() {
		String matim = textField_4.getText().toString();
		if (matim.trim().equals("")) {
			JOptionPane.showConfirmDialog(this, "Nhập dữ liệu để tìm");
		} else {
			NhanVien nv = nhanVienDao.selectByID(matim);
			if (nv != null) {
				for (int i = 0; i < table.getRowCount(); i++) {
					String table_tim = table.getValueAt(i, 0).toString();
					if (matim.equals(table_tim)) {
						table.setRowSelectionInterval(i, i);
						mouseClicked(null);
					}
				}
			} else {
				JOptionPane.showConfirmDialog(this, "Không tìm thấy");
				textField_4.setText("");

			}
		}

	}

	public void refreshData() {
		// TODO Auto-generated method stub
		// Lấy lại dữ liệu từ cơ sở dữ liệu
		List<NhanVien> newData = nhanVienDao.getAll();

		// Chuyển đổi dữ liệu và cập nhật table model
		tableModel.setDataVector(convertDataToVector(newData), getColumnNames());
	}

	public Object[] getColumnNames() {
		// TODO Auto-generated method stub
		return new Object[] { "Mã NV", "Tên NV", "Password", "Giới tính", "SĐT", "Chức vụ", "Địa chỉ" };

	}

	public Object[][] convertDataToVector(List<NhanVien> newData) {
		// TODO Auto-generated method stub
		Object[][] result = new Object[newData.size()][];
		for (int i = 0; i < newData.size(); i++) {
			NhanVien nv = newData.get(i);
			result[i] = new Object[] { nv.getMaNV(), nv.getHoTen(), nv.getMK(), nv.getGioiTinh(), nv.getSdt(),
					nv.getChucVu(), nv.getDiachi() };

		}
		return result;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int hang = table.getSelectedRow();
		if (hang != -1) {
			textField_ma.setText(tableModel.getValueAt(hang, 0).toString());
			textField_ten.setText(tableModel.getValueAt(hang, 1).toString());
			passwordField_pass.setText(tableModel.getValueAt(hang, 2).toString());
			comboBox_gioitinh.setSelectedItem(tableModel.getValueAt(hang, 3).toString());
			textField_sdt.setText(tableModel.getValueAt(hang, 4).toString());
			comboBox_chucvu.setSelectedItem(tableModel.getValueAt(hang, 5).toString());
			textArea_diachi.setText(tableModel.getValueAt(hang, 6).toString());
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnNewButton_them)) {
			if (btnNewButton_them.getText().equals("Thêm")) {
				btnNewButton_sua.setEnabled(false);
				btnNewButton_xoa.setEnabled(false);
				btnNewButton_them.setText("Lưu");
			} else if (btnNewButton_them.getText().equals("Lưu")) {
				btnNewButton_sua.setEnabled(true);
				btnNewButton_xoa.setEnabled(true);
				btnNewButton_them.setText("Thêm");
				them();
			}
		} else if (o.equals(btnNewButton_sua)) {
			int row = table.getSelectedRow();

			if (row != -1) {
				if (btnNewButton_sua.getText().equals("Sửa")) {
					btnNewButton_them.setEnabled(false);
					btnNewButton_xoa.setEnabled(false);
					btnNewButton_sua.setText("Lưu");
				} else if (btnNewButton_sua.getText().equals("Lưu")) {
					btnNewButton_them.setEnabled(true);
					btnNewButton_xoa.setEnabled(true);
					btnNewButton_sua.setText("Sửa");
					sua();

				}
			} else {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập chọn một dòng để sửa");

			}

		} else if (o.equals(btnNewButton_xoa)) {
			xoa();
		} else if (o.equals(btnNewButton_tim)) {
			timKiem();
		}
	}
}
