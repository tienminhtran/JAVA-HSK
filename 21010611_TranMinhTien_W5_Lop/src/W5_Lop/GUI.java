package W5_Lop;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class GUI extends JFrame implements ActionListener, MouseListener, ItemListener {
	private DanhSachCacSach danhSachCacSach;
	private Databasee databasee;
	private DefaultTableModel tableModel;
	private JTable table;
	private JLabel jLabel_maSach;
	private JLabel jLabel_tuaSach;
	private JLabel jLabel_tacGia;
	private JLabel jLabel_namXB;
	private JLabel jLabel_soTrang;
	private JLabel jLabel_donGia;
	private JLabel jLabel_nhaXB;
	private JLabel jLabel_r;
	private JLabel jLabel_ISBN;
	private JTextField jTextField_maSach;
	private JTextField jTextField_tuaSach;
	private JTextField jTextField_tacGia;
	private JTextField jTextField_namXB;
	private JTextField jTextField_nhaXB;
	private JTextField jTextField_soTrang;
	private JTextField jTextField_donGia;
	private JTextField jTextField_ISBN;
	private JTextField jTextField_r;
	private JComboBox jComboBox;
	private DefaultComboBoxModel model;

	public GUI() {
		danhSachCacSach = new DanhSachCacSach();
		databasee = new Databasee();
		setTitle("Quản lý sách");
		setSize(1000, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		init();
		loadData();
		napdulieu();
		setVisible(true);
	}

	private void init() {
		// TODO Auto-generated method stub
		jLabel_maSach = new JLabel("Mã sách:");
		jLabel_tuaSach = new JLabel("Tựa sách:");
		jLabel_tacGia = new JLabel("Tác giả:");
		jLabel_namXB = new JLabel("Năm xuất bản:");
		jLabel_nhaXB = new JLabel("Nhà xuất bản:");
		jLabel_soTrang = new JLabel("Số trang:");
		jLabel_donGia = new JLabel("Đơn giá:");
		jLabel_ISBN = new JLabel("International Standard Book Number (ISBN):");
		jLabel_r = new JLabel("                                  ");

		jTextField_maSach = new JTextField(10);
		jTextField_tuaSach = new JTextField();
		jTextField_tacGia = new JTextField();
		jTextField_namXB = new JTextField();
		jTextField_nhaXB = new JTextField(35);
		jTextField_soTrang = new JTextField();
		jTextField_donGia = new JTextField();
		jTextField_ISBN = new JTextField();

		JPanel jPanel_top = new JPanel();

		TitledBorder titledBorder_top = new TitledBorder("Records Editor");
		jPanel_top.setBorder(titledBorder_top);
		BoxLayout boxLayout_top = new BoxLayout(jPanel_top, BoxLayout.X_AXIS);

		JPanel jPanel_top_con_trai = new JPanel();
		BoxLayout boxLayout_trai = new BoxLayout(jPanel_top_con_trai, BoxLayout.Y_AXIS);
		Box b, b1, b2, b3, b4, b5;

		b = Box.createVerticalBox();
		b1 = Box.createHorizontalBox();
		b2 = Box.createHorizontalBox();
		b3 = Box.createHorizontalBox();
		b4 = Box.createHorizontalBox();
		b5 = Box.createHorizontalBox();

		b3.add(jLabel_namXB);
		b3.add(jTextField_namXB);

		b1.add(jLabel_maSach);
		jLabel_maSach.setPreferredSize(jLabel_namXB.getPreferredSize());
		b1.add(jTextField_maSach);
		b1.add(jLabel_r);

		b2.add(jLabel_tuaSach);
		jLabel_tuaSach.setPreferredSize(jLabel_namXB.getPreferredSize());
		b2.add(jTextField_tuaSach);

		b4.add(jLabel_soTrang);
		jLabel_soTrang.setPreferredSize(jLabel_namXB.getPreferredSize());
		b4.add(jTextField_soTrang);

		b5.add(jLabel_ISBN);
		b5.add(jTextField_ISBN);
		b.add(b1);
		b.add(b2);
		b.add(b3);
		b.add(b4);
		b.add(b5);

		JPanel jPanel_top_con_phai = new JPanel();
		BoxLayout boxLayout_phai = new BoxLayout(jPanel_top_con_phai, BoxLayout.Y_AXIS);
		Box c, c1, c2, c3, c4;

		c = Box.createVerticalBox();
		c.add(Box.createVerticalStrut(20));

		c1 = Box.createHorizontalBox();
		c2 = Box.createHorizontalBox();
		c3 = Box.createHorizontalBox();

		c2.add(jLabel_nhaXB);
		c2.add(jTextField_nhaXB);

		c1.add(jLabel_tacGia);
		jLabel_tacGia.setPreferredSize(jLabel_nhaXB.getPreferredSize());
		c1.add(jTextField_tacGia);

		c3.add(jLabel_donGia);
		jLabel_donGia.setPreferredSize(jLabel_nhaXB.getPreferredSize());
		c3.add(jTextField_donGia);

		c.add(c1);
		c.add(c2);
		c.add(c3);

		// CHINH

		jPanel_top_con_trai.add(b);
		jPanel_top.add(jPanel_top_con_trai);

		jPanel_top_con_phai.add(c);
		jPanel_top.add(jPanel_top_con_phai);

		// add lay out box

		jPanel_top.setLayout(boxLayout_top);
		jPanel_top_con_trai.setLayout(boxLayout_trai);

		JPanel jPanel_ceter = new JPanel();
		JPanel jPanel_ceter_button = new JPanel();

		JButton jButton_them = new JButton("Thêm");
		JButton jButton_xoarong = new JButton("Xóa rỗng");
		JButton jButton_sua = new JButton("Sửa");
		JButton jButton_xoa = new JButton("Xóa");
		JLabel jButton_matim = new JLabel("Tìm theo mã sách");
		jComboBox = new JComboBox();

		jPanel_ceter_button.add(jButton_them);
		jPanel_ceter_button.add(jButton_xoarong);
		jPanel_ceter_button.add(jButton_sua);
		jPanel_ceter_button.add(jButton_xoa);
		jPanel_ceter_button.add(jButton_matim);
		jPanel_ceter_button.add(jComboBox);
		jPanel_ceter.add(jPanel_ceter_button, BorderLayout.NORTH);

//					jPanel_ceter.setBorder(titledBorder_dssach);

		// Tao bảng
		JPanel jPanel_ceter_table = new JPanel();
		tableModel = new DefaultTableModel();
		tableModel.addColumn("Mã sách");
		tableModel.addColumn("Tựa sách");
		tableModel.addColumn("Tác giả");
		tableModel.addColumn("Năm xuất bản");
		tableModel.addColumn("Nhà xuất bản");
		tableModel.addColumn("Số trang");
		tableModel.addColumn("�?ơn giá");
		tableModel.addColumn("ISBN");

		table = new JTable(tableModel);
		JScrollPane jScrollPane = new JScrollPane(table,  JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		jScrollPane.setBorder(new TitledBorder("Danh sách các cuốn sách"));
		table.setRowSelectionAllowed(true);
		jPanel_ceter_table.add(jScrollPane);
		Dimension size = new Dimension(950, 330);
		table.setPreferredScrollableViewportSize(size);
		jPanel_ceter.add(jPanel_ceter_table, BorderLayout.CENTER);

		// chính

		new BorderLayout();
		this.add(jPanel_top, BorderLayout.NORTH);
		this.add(jPanel_ceter, BorderLayout.CENTER);
//			this.add(jPanel_ceter_dssach);
		// gắn sự kiện

		jButton_them.addActionListener(this);
		jButton_xoarong.addActionListener(this);
		jButton_xoa.addActionListener(this);
		jButton_sua.addActionListener(this);
		table.addMouseListener(this);
		jComboBox.addItemListener(this);

		this.addMouseListener(this);

	}

	public void napdulieu() {
		model = new DefaultComboBoxModel();
		for (int i = 0; i < table.getRowCount(); i++) {
			String maSach = table.getValueAt(i, 0).toString();
			model.addElement(maSach);
		}
		jComboBox.setModel(model);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String src = e.getActionCommand();
		if (src.equals("Xóa rỗng")) {
			this.xoaTrang();
		} else if (src.equals("Thêm")) {
			try {
				this.themSach();
				napdulieu();
				databasee.savefile("Sach.dat", danhSachCacSach);
			} catch (Exception e2) {
				JOptionPane.showConfirmDialog(this, "Vui lòng kiểm tra thông tin vừa nhập không  chính xác!!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
			}
		} else if (src.equals("Xóa")) {
			this.xoaSach();
			databasee.savefile("Sach.dat", danhSachCacSach);

			napdulieu();

		} else if (src.equals("Sửa")) {
			this.capnhat();
			napdulieu();

		}
	}

	public boolean kiemTraTuaSach_TacGia(String ts_tg) {
		String s="([a-zA-Z\\s\\.]+)";
			return ts_tg.matches(s);
		
	}

	public boolean kyTuBaKyTuCuoiMaSo(String kt) {
		// Kiểm tra độ dài của chuỗi nhập có phải là 4 không
		if (kt.length() != 4) {
			return false;
		}
		// Kiểm tra 3 ký tự cuối có phải là chữ không
		String lastThreeChars = kt.substring(1);
		for (int i = 0; i < lastThreeChars.length(); i++) {
			if (!Character.isDigit(lastThreeChars.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	/*
	 * / \\d: ký tự số từ 0 đến 9. {1,}: xuất hiện từ một lần trở lên. -: dấu gạch
	 * ngang (-). ?: có thể xuất hiện hoặc không xuất hiện. {0,1}: tối đa một lần
	 * xuất hiện.
	 */
	public boolean kiemTraISBN(String isbn) {
		//	cách 1	
		//String pattern = "\\d{1,}-\\d{1,}-\\d{1,}-\\d{1,}(-\\d{1,})?";
		// cách 2
		String pattern = "\\d+(-\\d+){3,4}";
		if (isbn.matches(pattern)) {
			return true;
		}
		return false;
	}

	public boolean validDate() {
		String maSach = jTextField_maSach.getText();
		String tuaSach = jTextField_tuaSach.getText();
		String tacGia = jTextField_tacGia.getText();
		int namxb = Integer.parseInt(jTextField_namXB.getText());
		String nhaxb = jTextField_nhaXB.getText();
		int sotrang = Integer.parseInt(jTextField_soTrang.getText());
		double dongia = Double.parseDouble(jTextField_donGia.getText());
		String isbn = jTextField_ISBN.getText();
//		if (maSach.trim().equals("")) {
//			JOptionPane.showMessageDialog(this, "Mã sách không được trống!!!");
//			return false;
//		}
		if (tuaSach.trim().equals("")) {
			JOptionPane.showMessageDialog(this, "Tựa sách không được trống!!!");
			return false;
		}
		if (!kiemTraTuaSach_TacGia(tuaSach)) {
			JOptionPane.showMessageDialog(this, "Tựa sách không chứa ký tự đặt biệt và số!!!");
			return false;
		}
//		if (tacGia.trim().equals("")) {
//			JOptionPane.showMessageDialog(this, "Tác giả không được trống!!!");
//			return false;
//		}
//		if (!kiemTraTuaSach_TacGia(tacGia)) {
//			JOptionPane.showMessageDialog(this, "Tác giả không chứa ký tự đặt biệt và số!!!");
//			return false;
//		}
//		if (dongia <= 0) {
//			JOptionPane.showMessageDialog(this, "Đơn giá lớn 0!!!");
//			return false;
//
//		}
//		if (sotrang <= 0) {
//			JOptionPane.showMessageDialog(this, "Số trang lớn 0!!!");
//			return false;
//		}
//		if (namxb < 1900 || namxb > LocalDate.now().getYear()) {
//			// !(s.getNamXuatBan() < Calendar.getInstance().get(Calendar.YEAR))
//			// nếu năm <1900 và lớn hơn năm hiện tại thì xuất lỗi
//			JOptionPane.showMessageDialog(this,
//					"Năm phải lớn hơn bằng 1900 và nhỏ hơn năm " + LocalDate.now().getYear() + "!!!");
//			return false;
//
//		}
//		if (!kiemTraISBN(isbn)) {
//			JOptionPane.showMessageDialog(this, "ISBN chưa đúng định dạng!!!");
//			return false;
//		}
		return true;
	}

	private void xoaTrang() {
		// TODO Auto-generated method stub
		jTextField_maSach.setText(" ");
		jTextField_tuaSach.setText(" ");
		jTextField_tacGia.setText(" ");
		jTextField_namXB.setText(" ");
		jTextField_nhaXB.setText(" ");
		jTextField_soTrang.setText(" ");
		jTextField_donGia.setText(" ");
		jTextField_ISBN.setText(" ");
	}

	private void themSach() throws Exception {
		// TODO Auto-generated method stub
		String maSach = jTextField_maSach.getText();
		String tuaSach = jTextField_tuaSach.getText();
		String tacGia = jTextField_tacGia.getText();
		int namxb = Integer.parseInt(jTextField_namXB.getText());
		String nhaxb = jTextField_nhaXB.getText();
		int sotrang = Integer.parseInt(jTextField_soTrang.getText());
		double dongia = Double.parseDouble(jTextField_donGia.getText());
		String isbn = jTextField_ISBN.getText();

		Sach s = new Sach(maSach, tuaSach, tacGia, namxb, nhaxb, sotrang, dongia, isbn);
		Object obj[] = new Object[8];
		obj[0] = maSach;
		obj[1] = tuaSach;
		obj[2] = tacGia;
		obj[3] = Integer.toString(namxb);
		obj[4] = nhaxb;
		obj[5] = Integer.toString(sotrang);
		obj[6] = Double.toString(dongia);
		obj[7] = isbn;
		// mã không rỗng

		if (s.getMaSach().charAt(0) == s.getTuaSach().charAt(0) && kyTuBaKyTuCuoiMaSo(s.getMaSach())) {
			if (validDate()) {
				if (danhSachCacSach.themSach(s)) {
					JOptionPane.showMessageDialog(this, "Thêm thành công sách mới!!!");
					tableModel.addRow(obj);
				} else {
					JOptionPane.showConfirmDialog(this, "Lỗi id sách trùng!!!");
				}
			}
		} else {
			JOptionPane.showMessageDialog(this, "Mã sách không đúng định dạng!!!");
		}
	}
	private void xoaSach() {
		int hang = table.getSelectedRow();
		if (hang != -1) {
			danhSachCacSach.xoaViTri(hang);
			tableModel.removeRow(hang);
		}
	}

	public void capnhat() {
		int hang = table.getSelectedRow();

		if (hang != -1) {
			String maSach = jTextField_maSach.getText();
			String tuaSach = jTextField_tuaSach.getText();
			String tacGia = jTextField_tacGia.getText();
			int namxb = Integer.parseInt(jTextField_namXB.getText());
			String nhaxb = jTextField_nhaXB.getText();
			int sotrang = Integer.parseInt(jTextField_soTrang.getText());
			double dongia = Double.parseDouble(jTextField_donGia.getText());
			String isbn = jTextField_ISBN.getText();

			Sach s = new Sach(maSach, tuaSach, tacGia, namxb, nhaxb, sotrang, dongia, isbn);
			this.danhSachCacSach.update(s);
			int soLuongDong = table.getRowCount();
			for (int i = 0; i < soLuongDong; i++) {
				String id = table.getValueAt(i, 0) + "";
				if (id.equals(s.getMaSach() + "") && validDate()) {
					JOptionPane.showConfirmDialog(this, "Cập nhật thành công!", "Thông báo", JOptionPane.OK_OPTION);
					table.setValueAt(s.getMaSach() + "", i, 0);
					table.setValueAt(s.getTuaSach() + "", i, 1);
					table.setValueAt(s.getTacGia() + "", i, 2);
					table.setValueAt(s.getNamXuatBan() + "", i, 3);
					table.setValueAt(s.getNhaXuatBan() + "", i, 4);
					table.setValueAt(s.getSoTrang() + "", i, 5);
					table.setValueAt(s.getDonGia() + "", i, 6);
					table.setValueAt(s.getISBN() + "", i, 7);
				}
			}
		} else {
			JOptionPane.showConfirmDialog(this, "Chọn dòng cần cập nhật nha bạn!!!", "Thông báo",
					JOptionPane.OK_OPTION);
		}
	}

//	private void tim() {
//		String key = jComboBox.getSelectedItem().toString();
//		for (int i = 0; i < table.getRowCount(); i++) {
//			String code = (String) table.getValueAt(i, 0);
//			if (key.equals(code)) {
//				table.getSelectionModel().setSelectionInterval(i, i);
//				table.repaint();
//			}
//		}
//	}

	private void tim() {
		String key = jComboBox.getSelectedItem().toString();
		for (int i = 0; i < table.getRowCount(); i++) {
			String code = (String) table.getValueAt(i, 0);
			if (key.equals(code)) {
				table.getSelectionModel().setSelectionInterval(i, i);
				table.repaint();
			}
		}
	}

	public void loadData() {
		danhSachCacSach = null;
		danhSachCacSach = (DanhSachCacSach) databasee.readfile("Sach.dat");
		if (danhSachCacSach == null) {
			danhSachCacSach = new DanhSachCacSach();
		} else {
			for (Sach s : danhSachCacSach.getDsSach()) {
				String hang[] = { s.getMaSach(), s.getTuaSach(), s.getTacGia(), s.getNamXuatBan() + "",
						s.getNhaXuatBan(), s.getSoTrang() + "", s.getDonGia() + "", s.getISBN() };
				tableModel.addRow(hang);
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

		int hang = table.getSelectedRow();
		if (hang != -1) {
			jTextField_maSach.setText(table.getValueAt(hang, 0).toString());
			jTextField_tuaSach.setText(table.getValueAt(hang, 1).toString());
			jTextField_tacGia.setText(table.getValueAt(hang, 2).toString());
			jTextField_namXB.setText(table.getValueAt(hang, 3).toString());
			jTextField_nhaXB.setText(table.getValueAt(hang, 4).toString());
			jTextField_soTrang.setText(table.getValueAt(hang, 5).toString());
			jTextField_donGia.setText(table.getValueAt(hang, 6).toString());
			jTextField_ISBN.setText(table.getValueAt(hang, 7).toString());
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
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		String selectedValue = (String) jComboBox.getSelectedItem();
		for (int i = 0; i < table.getRowCount(); i++) {
			String value = (String) table.getValueAt(i, 0);
			if (selectedValue.equals(value)) {
				table.setRowSelectionInterval(i, i);
				mouseClicked(null);
			}
		}
	}
}
