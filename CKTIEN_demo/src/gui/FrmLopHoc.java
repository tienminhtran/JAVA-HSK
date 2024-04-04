package gui;

import java.awt.Color;
import java.awt.Font;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import connection.ConnectionDB;
import dao.giaovien_dao;
import dao.tonghop_dao;
import entity.giaovien;
import entity.tonghop;

public class FrmLopHoc extends JFrame implements ActionListener, MouseListener {

	private JTextField txtMaLop;
	private JTextField txtTenLop;
	private JTextField txtSiSo;
	private JComboBox cboGVCN;
	private JButton btnThem;
	private JButton btnLuu;
	private JButton btnSua;
	private JButton btnXoa;
	private JButton btnTimGV, btnTimLop;
	private DefaultTableModel dataModel;
	private JTable table;
	private ConnectionDB cbd;
	private giaovien_dao gv_dao;
	private tonghop_dao th_dao;

	public FrmLopHoc() throws SQLException {
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int dialogResult = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn đóng ứng dụng?",
						"Xác nhận đóng ứng dụng", JOptionPane.YES_NO_OPTION);
				if (dialogResult == JOptionPane.YES_OPTION) {
					// Thực hiện việc đóng ứng dụng
					System.exit(0);
				}
			}
		});

		///

		cbd = new ConnectionDB();
		cbd.connect();
		gv_dao = new giaovien_dao();
		th_dao = new tonghop_dao();
		setTitle("Thông tin lớp hoc");
		setSize(1000, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		Box b, b1, b2, b3, b4, b44, b5, b6, b7;
		// Dùng Box layout
		add(b = Box.createVerticalBox()); // Box theo chi�?u d�?c
		b.add(Box.createVerticalStrut(10)); // Tạo khoảng cách theo chi�?u d�?c
		b.add(b1 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10)); // b1 -> b7: Box theo chi�?u ngang
		b.add(b2 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b.add(b3 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b.add(b4 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b.add(b44 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b.add(b5 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b.add(b6 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b.add(b7 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));

		JLabel lblTieuDe, lblMaLop, lblTenLop, lblGVCN, lblSiSo;
		b1.add(lblTieuDe = new JLabel("THÔNG TIN LỚP HỌC", JLabel.CENTER));
		lblTieuDe.setFont(new Font("Arial", Font.BOLD, 26));

		b2.add(lblMaLop = new JLabel("Mã lớp: ", JLabel.RIGHT));
		b2.add(txtMaLop = new JTextField());
		b3.add(lblTenLop = new JLabel("Tên lớp: ", JLabel.RIGHT));
		b3.add(txtTenLop = new JTextField());
		b4.add(lblGVCN = new JLabel("Giáo viên chủ nhiệm: ", JLabel.RIGHT));
		b4.add(cboGVCN = new JComboBox<String>());
		for(giaovien gv:gv_dao.getAllgiaovien()) {
			cboGVCN.addItem(gv.getTengiaovien());
		}
		cboGVCN.setEditable(false);
		b44.add(lblSiSo = new JLabel("Sỉ số : ", JLabel.RIGHT));
		b44.add(txtSiSo = new JTextField());

		lblMaLop.setPreferredSize(lblGVCN.getPreferredSize());
		lblTenLop.setPreferredSize(lblGVCN.getPreferredSize());
		lblSiSo.setPreferredSize(lblGVCN.getPreferredSize());

		b5.add(btnThem = new JButton("Thêm"));
		b5.add(btnLuu = new JButton("Lưu"));
		b5.add(btnSua = new JButton("Sửa"));
		b5.add(btnXoa = new JButton("Xóa"));
		b5.add(btnTimGV = new JButton("Tìm theo mã giáo viên"));
		b5.add(btnTimLop = new JButton("Tìm theo mã lớp"));

		String[] headers = { "Mã lớp", "Tên lớp", "Giáo viên CN", "Sỉ số" };
		dataModel = new DefaultTableModel(headers, 0);
		for (tonghop th : th_dao.getAlltonghop()) {
			Object[] row = { th.getMalop(), th.getTenlop(), th.getGiaoviencn(), th.getSiso() };
			dataModel.addRow(row);
		}
		JScrollPane scroll;
		b6.add(scroll = new JScrollPane(table = new JTable(dataModel)));
		scroll.setBorder(BorderFactory.createTitledBorder("Danh sách lớp h�?c"));

		b7.add(Box.createHorizontalStrut(600));

		btnThem.addActionListener(this);
		btnLuu.addActionListener(this);
		btnXoa.addActionListener(this);
		btnSua.addActionListener(this);
		btnTimGV.addActionListener(this);
		btnTimLop.addActionListener(this);
		table.addMouseListener(this);

		// Khi chương trình chạy, nạp toàn bộ danh sách lớp h�?c lên bảng

	}

	public boolean KiemtraMa(String src) {
		String s = "^ĐH[0-9]{2}[A-Z]";
		return src.matches(s);
	}

	public boolean KiemtraTen(String src) {
		String s = "[\\w\\s]*";
		return src.matches(s);
	}
	public boolean KiemtraSiso(String src) {
		String s = "4[0-9]|[5-9][0-9]";
		return src.matches(s);
	}

	public boolean vadi() {
		if (!KiemtraMa(txtMaLop.getText())) {
			txtMaLop.requestFocus();
			JOptionPane.showMessageDialog(null, "Mã bắt đầu là ĐH 2 số và chữ Hoa: ĐH18A");
			return false;
		}
		if (!KiemtraTen(txtTenLop.getText())) {
			txtTenLop.requestFocus();
			JOptionPane.showMessageDialog(null, "Ten loi");
			return false;
		}if(!KiemtraSiso(txtSiSo.getText())) {
			txtSiSo.requestFocus();
			JOptionPane.showMessageDialog(null, "40<..<90");
			return false;
		}
		return true;
	}

	public void them() {
		if (vadi()) {
			tonghop t = new tonghop(txtMaLop.getText(), txtTenLop.getText(), String.valueOf(cboGVCN.getSelectedItem()),
					Integer.parseInt(txtSiSo.getText()));
			th_dao.themtonghop(t);
			Object[] o = { txtMaLop.getText(), txtTenLop.getText(), cboGVCN.getSelectedItem(),
					Integer.parseInt(txtSiSo.getText()) };
			dataModel.addRow(o);
		}

	}

//	public void xoa() {
//		int hang = table.getSelectedRow();
//		if (hang != -1) {
//			String ma = (String) table.getValueAt(hang, 0);
//			th_dao.xoatonghop(ma);
//			dataModel.removeRow(hang);
//		} else {
//			JOptionPane.showMessageDialog(this, "Vui lòng nhập chọn một dòng để xóa");
//
//		}
//	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnThem)) {
			xoaRongTextfields();
			txtMaLop.requestFocus();
		} else if (o.equals(btnLuu)) {
			them();
		} else if (o.equals(btnSua)) {

		} else if (o.equals(btnXoa)) {
//			xoa();
		} else if (o.equals(btnTimLop)) {
			int index = 0;
			String s = JOptionPane.showInputDialog("Nhập mã bạn muốn tìm");
			for (int i = 0; i < table.getRowCount(); i++) {
				String data = table.getValueAt(i, 0).toString();
				if (s.trim().equalsIgnoreCase(data)) {
					index = 1;
					JOptionPane.showMessageDialog(this, "Tìm thấy");
					System.out.println(data);
					table.setRowSelectionInterval(i, i);
				}
			}
			if (index == 0) {
				JOptionPane.showMessageDialog(this, "K Tìm thấy");
				System.out.println("--");

			}
		}

	}

	private void xoaRongTextfields() {
		txtMaLop.setText("");
		txtTenLop.setText("");
		cboGVCN.setSelectedItem(null);
		txtSiSo.setText("");
		txtMaLop.requestFocus();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int hang = table.getSelectedRow();
		txtMaLop.setText(table.getValueAt(hang, 0).toString());
		txtTenLop.setText(table.getValueAt(hang, 1).toString());
		cboGVCN.setSelectedItem(table.getValueAt(hang, 2));
		txtSiSo.setText(table.getValueAt(hang, 3).toString());
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
