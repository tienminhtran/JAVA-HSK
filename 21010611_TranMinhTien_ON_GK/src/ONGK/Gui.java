package ONGK;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
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
import javax.swing.table.TableModel;
import javax.swing.text.JTextComponent;

public class Gui extends JFrame implements ActionListener, MouseListener {

	private DachSachSinhVien dachSachSinhVien;
	private Databasee databasee;
	private SinhVien sinhVien;
	private JTextField jTextField_masv;
	private JTextField jTextField_hovaten;
	private JComboBox jComboBox_malop;
	private JTextField jTextField_diemthuchanh;
	private JTextField jTextField_diemlythuyet;
	private JTextComponent jTextField_diemtrungbinh;
	private JTextField jTextField_ketqua;
	private DefaultTableModel tableModel;
	private JTable table;
	private JButton jButton_kq;
	private JButton jButton_them;
	private JButton jButton_luu;
	private JButton jButton_clear;
	private JButton jButton_sua;
	private JButton jButton_Xoa;
	private JButton jButton_tim;

	public Gui() {
		this.dachSachSinhVien = new DachSachSinhVien();
		databasee = new Databasee();
		this.sinhVien = new SinhVien();
		this.setTitle("Chương trình QLSV");
		this.setSize(900, 500);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.init();
		this.setVisible(true);
		try {
			loadData();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void init() {
		JPanel jPanel_chinh = new JPanel();
		jPanel_chinh.setLayout(new GridLayout(0, 2));
		JPanel jPanel_trai = new JPanel();
		jPanel_trai.setLayout(new GridLayout(0, 1));

		JLabel jLabel_title = new JLabel("THÔNG TIN SINH VIÊN");
		JLabel jLabel_masv = new JLabel("Mã sinh viên");
		JLabel jLabel_hovaten = new JLabel("Họ và tên");
		JLabel jLabel_malop = new JLabel("Mã lớp");
		JLabel jLabel_diemlythuyet = new JLabel("Điểm lý thuyết");
		JLabel jLabel_diemtrungbinh = new JLabel("Điểm trung bình");
		JLabel jLabel_diemthuchanh = new JLabel("Điểm trung bình");
		JLabel jLabel_ketqua = new JLabel("Kết quả");

		jTextField_masv = new JTextField(20);
		jTextField_hovaten = new JTextField();
		jComboBox_malop = new JComboBox();
		jComboBox_malop.addItem("NCTH16A");
		jComboBox_malop.addItem("NCTH16B");
		jComboBox_malop.addItem("NCTH16C");
		jTextField_diemlythuyet = new JTextField();
		jTextField_diemthuchanh = new JTextField();
		jTextField_diemtrungbinh = new JTextField();
		jTextField_diemtrungbinh.setEditable(false);
		jTextField_ketqua = new JTextField();
		jTextField_ketqua.setEditable(false);

		jPanel_trai.add(jLabel_title);
		jPanel_trai.add(jLabel_masv);
		jPanel_trai.add(jTextField_masv);
		jPanel_trai.add(jLabel_hovaten);
		jPanel_trai.add(jTextField_hovaten);
		jPanel_trai.add(jLabel_malop);
		jPanel_trai.add(jComboBox_malop);
		jPanel_trai.add(jLabel_diemlythuyet);
		jPanel_trai.add(jTextField_diemlythuyet);
		jPanel_trai.add(jLabel_diemthuchanh);
		jPanel_trai.add(jTextField_diemthuchanh);
		jPanel_trai.add(jLabel_diemtrungbinh);
		jPanel_trai.add(jTextField_diemtrungbinh);
		jPanel_trai.add(jLabel_ketqua);
		jPanel_trai.add(jTextField_ketqua);
		JPanel jPanel_phai = new JPanel();
		jPanel_phai.setLayout(new GridLayout(0, 1));

		// tạo bảng

		tableModel = new DefaultTableModel();
		tableModel.addColumn("Mã SV");
		tableModel.addColumn("Họ tên");
		tableModel.addColumn("Lớp");
		tableModel.addColumn("Lý thuyết");
		tableModel.addColumn("Thực hành");
		tableModel.addColumn("Trung bình");
		tableModel.addColumn("Kết quả");
		table = new JTable(tableModel);
		JScrollPane jScrollPane = new JScrollPane(table);
		jPanel_phai.add(jScrollPane);
		jPanel_chinh.add(jPanel_trai);
		jPanel_chinh.add(jPanel_phai);

		this.add(jPanel_chinh);
		JPanel jPanel_btn = new JPanel();
		jButton_kq = new JButton("Kết quả");
		jButton_them = new JButton("Thêm");
		jButton_clear = new JButton("Clear");
		jButton_luu = new JButton("Lưu");
		jButton_Xoa = new JButton("Xóa");
		jButton_sua = new JButton("Sửa");
		jButton_tim = new JButton("Tìm");

		jPanel_btn.add(jButton_kq);
		jPanel_btn.add(jButton_them);
		jPanel_btn.add(jButton_clear);
		jPanel_btn.add(jButton_luu);
		jPanel_btn.add(jButton_Xoa);
		jPanel_btn.add(jButton_sua);
		jPanel_btn.add(jButton_tim);
		jPanel_trai.add(jPanel_btn, BorderLayout.CENTER);

		// su kien
		jButton_kq.addActionListener(this);
		jButton_them.addActionListener(this);
		jButton_clear.addActionListener(this);
		jButton_luu.addActionListener(this);
		jButton_Xoa.addActionListener(this);
		jButton_sua.addActionListener(this);
		jButton_tim.addActionListener(this);

		table.addMouseListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String src = e.getActionCommand();
		if (src.equals("Thêm")) {
			them();
		} else if (src.equals("Kết quả")) {
			tb();
			kq();
		} else if (src.equals("Clear")) {
			xoatrang();
		} else if (src.equals("Lưu")) {
			databasee.savefile("SV.dat", dachSachSinhVien);

		} else if (src.equals("Xóa")) {
			xoa();
		} else if (src.equals("Sửa")) {
			sua();
		}
	}

	public void them() {
		String maSinhVien = jTextField_masv.getText();
		String hoVaTen = jTextField_hovaten.getText();
		String maLop = jComboBox_malop.getSelectedItem().toString();
		double diemLyThuyet = Double.parseDouble(jTextField_diemlythuyet.getText());
		double diemThucHang = Double.parseDouble(jTextField_diemthuchanh.getText());
		SinhVien sv = new SinhVien(maSinhVien, hoVaTen, maLop, diemLyThuyet, diemThucHang);
//		 SinhVien sv1= null;
		if (dachSachSinhVien.themSinhVien(sv)) {
			Object obj[] = new Object[7];
			obj[0] = maSinhVien;
			obj[1] = hoVaTen;
			obj[2] = maLop;
			obj[3] = Double.toString(diemLyThuyet);
			obj[4] = Double.toString(diemThucHang);
			obj[5] = sv.kq();
			obj[6] = sv.daurot();
			JOptionPane.showConfirmDialog(this, "Thêm thành công");
			tableModel.addRow(obj);
		}
	}

	public void tb() {
		double diemlythuyet = Double.parseDouble(jTextField_diemlythuyet.getText());
		double diemthuchanh = Double.parseDouble(jTextField_diemthuchanh.getText());
		this.sinhVien.diemTB(diemlythuyet, diemthuchanh);
		this.jTextField_diemtrungbinh.setText(this.sinhVien.getDiemTrungBinh() + "");
	}

	public void kq() {
		this.sinhVien.daurot();
		this.jTextField_ketqua.setText(this.sinhVien.getKetQua());
	}

	public void xoatrang() {
		jTextField_masv.setText(" ");
		jTextField_hovaten.setText(" ");
		jTextField_diemlythuyet.setText(" ");
		jTextField_diemthuchanh.setText(" ");
		jTextField_diemtrungbinh.setText(" ");
		jTextField_ketqua.setText(" ");
		jComboBox_malop.setSelectedIndex(0);
	}

	public void xoa() {
		int hang = table.getSelectedRow();
		if (hang != -1) {
			JOptionPane.showConfirmDialog(this, "Bạn muốn xóa không");
			dachSachSinhVien.xoaVT(hang);
			tableModel.removeRow(hang);

		} else {
			JOptionPane.showConfirmDialog(this, "Chọn một dòng cần xóa");
		}
	}

	public void sua() {
		String maSinhVien = jTextField_masv.getText();
		String hoVaTen = jTextField_hovaten.getText();
		String maLop = jComboBox_malop.getSelectedItem().toString();
		double diemLyThuyet = Double.parseDouble(jTextField_diemlythuyet.getText());
		double diemThucHang = Double.parseDouble(jTextField_diemthuchanh.getText());
		SinhVien sv = new SinhVien(maSinhVien, hoVaTen, maLop, diemLyThuyet, diemThucHang);
		this.dachSachSinhVien.sua(sv);
		for (int i = 0; i < table.getRowCount(); i++) {
			String id = table.getValueAt(i, 0) + "";
			if (id.contains(sv.getMaSinhVien())) {
				if (id.equals(sv.getMaSinhVien())) {
					JOptionPane.showConfirmDialog(this, "Cập nhật thành công!", "Thông báo", JOptionPane.OK_OPTION);
					table.setValueAt(sv.getHoVaTen() + "", i, 1);
					table.setValueAt(sv.getMaLop() + "", i, 2);
					table.setValueAt(sv.getDiemLyThuyet() + "", i, 3);
					table.setValueAt(sv.getDiemThucHang() + "", i, 4);
				}
			} 
		}
		
//				JOptionPane.showConfirmDialog(this, "Mã số sinh viên là duy nhất không được phép thay đổi!!!",
//						"Thông báo", JOptionPane.OK_OPTION);	

	}

	public static void main(String[] args) {
		new Gui();
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		int hang = table.getSelectedRow();
		if (hang != -1) {
			jTextField_masv.setText(tableModel.getValueAt(hang, 0).toString());
			jTextField_hovaten.setText(tableModel.getValueAt(hang, 1).toString());
			jComboBox_malop.setSelectedItem(tableModel.getValueAt(hang, 2));
			jTextField_diemlythuyet.setText(tableModel.getValueAt(hang, 3).toString());
			jTextField_diemthuchanh.setText(tableModel.getValueAt(hang, 4).toString());
			jTextField_diemtrungbinh.setText(tableModel.getValueAt(hang, 5).toString());
			jTextField_ketqua.setText(tableModel.getValueAt(hang, 6).toString());
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
	}

	public void loadData() throws Exception {
		dachSachSinhVien = null;
		dachSachSinhVien = (DachSachSinhVien) databasee.readfile("SV.dat");
		if (dachSachSinhVien == null) {
			dachSachSinhVien = new DachSachSinhVien();
		} else {
			for (SinhVien sv : dachSachSinhVien.getDsSinhVien()) {
				String hang[] = { sv.getMaSinhVien(), sv.getHoVaTen(), sv.getMaLop(), sv.getDiemLyThuyet() + "",
						sv.getDiemThucHang() + "", sv.kq() + "", sv.getKetQua() };
				tableModel.addRow(hang);
			}
		}

	}
}
