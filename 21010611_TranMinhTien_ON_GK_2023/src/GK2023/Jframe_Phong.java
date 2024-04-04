package GK2023;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Jframe_Phong extends JFrame implements ActionListener, MouseListener{
	private JTextField txtMa;
	private JTextField txtTen;
	private JTextField txtDienTich;
	private JTextField txtGhiChu;
	private JComboBox<String> cbLoaiPhong;
	private JTextField txtTimPhong;
	private JButton btnTim;
	private JButton btnThem;
	private JButton btnLamMoi;
	private JButton btnXoa;
	private JButton btnLuuFile;
	private JTable table;
	private DefaultTableModel model;
	private QuanLy_Phong ds;
	private DocGhiFile fi;
	private static final String tenFile = "data\\DanhSachPhong.txt";
	
	public Jframe_Phong() {
		setTitle("Kiểm tra giữa kì Trần Vũ Duy 21026331 DHKTPM17ATT");
		setSize(900, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(new BorderLayout());
		
		JLabel lblTitle = new JLabel();
		JPanel panelNorth = new JPanel();
		JPanel panelWest = new JPanel();
		panelWest.setLayout(new GridLayout(12, 1, 5, 5));
		panelWest.add(new JLabel("Mã Phòng:"));
		panelWest.add(txtMa = new JTextField(20));
		panelWest.add(new JLabel("Tên Phòng:"));
		panelWest.add(txtTen = new JTextField(20));
		panelWest.add(new JLabel("Diện tích:"));
		panelWest.add(txtDienTich = new JTextField(20));
		panelWest.add(new JLabel("Loại phòng:"));
		panelWest.add(cbLoaiPhong = new JComboBox<String>());
		panelWest.add(new JLabel("Ghi chú:"));
		panelWest.add(txtGhiChu = new JTextField(20));
		
		panelNorth.add(lblTitle = new JLabel("-- THÔNG TIN PHÒNG --"));
		lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
		this.add(panelNorth, BorderLayout.NORTH);
		this.add(panelWest, BorderLayout.WEST);
		
		
		String[] cols = "Mã Phòng;Tên Phòng;Diện Tích;Loại Phòng;Ghi Chú".split(";");
		model = new DefaultTableModel(cols, 0);
		table = new JTable(model);
		this.add(new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.CENTER);
		table.setRowHeight(20);
		
		JPanel panelSouth = new JPanel();
		panelSouth.add(new JLabel("Tìm theo mã phòng:"));
		panelSouth.add(txtTimPhong = new JTextField(20));
		panelSouth.add(Box.createHorizontalStrut(20));
		panelSouth.add(btnTim = new JButton("Tìm"));
		panelSouth.add(btnThem = new JButton("Thêm"));
		panelSouth.add(btnLamMoi = new JButton("Làm mới"));
		panelSouth.add(btnXoa = new JButton("Xóa"));
		panelSouth.add(btnLuuFile = new JButton("Lưu file"));
		
		this.add(panelSouth, BorderLayout.SOUTH);
		cbLoaiPhong.addItem("1 giường đôi");
		cbLoaiPhong.addItem("2 giường đôi");
		cbLoaiPhong.addItem("2 giường đơn");
		
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnLamMoi.addActionListener(this);
		btnLuuFile.addActionListener(this);
		btnTim.addActionListener(this);
		table.addMouseListener(this);
		
		ds = new QuanLy_Phong();
		fi = new DocGhiFile();
		try {
			ds = (QuanLy_Phong) fi.docFile(tenFile);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Danh sách rỗng");
		}
		
		updateTable();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnThem)) {
			themActions();
		} else if (o.equals(btnLamMoi)) {
			lamMoi();
		} else if (o.equals(btnXoa)) {
			xoaActions();
		} else if (o.equals(btnLuuFile)) {
			try {
				fi.ghiFile(tenFile, ds);
				JOptionPane.showMessageDialog(this, "Lưu file thành công");
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(this, "Lưu file thất bại");
			}
		} else if (o.equals(btnTim)) {
			timPhong();
		}
		
	}

	public void timPhong() {
		int ma = Integer.parseInt(txtTimPhong.getText());
		for (int i = 0; i < ds.soLuong(); i++) {
			if (ma == ds.getPhong(i).getMaPhong()) {
				JOptionPane.showMessageDialog(this, "Tìm thấy");
				return;
			}
		}
		JOptionPane.showMessageDialog(this, "Không tìm thấy");
	}
	
	public void xoaActions() {
		int row = table.getSelectedRow();
		int ma = Integer.parseInt(table.getValueAt(row, 0).toString());
		if (row != -1) {
			if (ds.xoaPhong(ma)) {
				int loinhac = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa không?", "Chú ý", JOptionPane.YES_NO_OPTION);
				if (loinhac == JOptionPane.YES_OPTION) {
					model.removeRow(row);
					updateTable();
				}
			}
		} else {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng bạn muốn xóa!");
		}
	}
	
	public void themActions() {
		try {
			int ma = Integer.parseInt(txtMa.getText());
			String ten = txtTen.getText();
			double dientich = Double.parseDouble(txtDienTich.getText());
			String loaiphong = cbLoaiPhong.getSelectedItem().toString();
			String ghichu = txtGhiChu.getText();
			Phong p = new Phong(ma, ten, dientich, loaiphong, ghichu);
			if (dientich>0) {
				if (ds.themPhong(p)) {
					updateTable();
				} else {
					JOptionPane.showMessageDialog(this, "Trùng mã");
					txtMa.requestFocus();
					txtMa.selectAll();
				}
			} else {
				JOptionPane.showMessageDialog(this, "Diện tích phải lớn hơn 0");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Lỗi nhập liệu (Các trường rỗng)");
		}
	}
	
	public void updateTable() {
		xoaDuLieu();
		for (int i = 0; i < ds.soLuong(); i++) {
			Phong p = ds.getPhong(i);
			String[] cols = {p.getMaPhong()+"", p.getTenPhong(), p.getDienTich()+"", p.getLoaiPhong(),p.getGhiChu()};
			model.addRow(cols);
		}
	}
	
	public void xoaDuLieu() {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.getDataVector().removeAllElements();
	}
	
	public void lamMoi() {
		txtMa.setText("");
		txtTen.setText("");
		txtDienTich.setText("");
		txtGhiChu.setText("");
		txtMa.requestFocus();
		cbLoaiPhong.setSelectedIndex(0);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		txtMa.setText(table.getValueAt(row, 0).toString());
		txtTen.setText(table.getValueAt(row, 1).toString());
		txtDienTich.setText(table.getValueAt(row, 2).toString());
		txtGhiChu.setText(table.getValueAt(row, 4).toString());
		cbLoaiPhong.setSelectedIndex(row);
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
