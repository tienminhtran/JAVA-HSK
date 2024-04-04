package copybai;

public class C {

}
/*
package GK2023_S6;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JOptionPane;

public class Databasee {

	public Databasee() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	//GHI FILE
	public void savefile(String fileName, Object o) {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(fileName);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(o);
			oos.close();
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Lỗi file");
			return;
		}
	}
	
	//DOC FILE
	public Object readfile(String fileName) {
		Object o = null;
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(fileName);
			ois = new ObjectInputStream(fis);
			o = ois.readObject();
			ois.close();
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Lỗi file");
			
		}
		return o;
	}
}
***************************************************************************************

package GK2023_S6;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class Gui extends JFrame implements ActionListener, MouseListener {
	private DanhSachXe danhSachXe;
	private Databasee databasee;
	private JTextField jTextField_ma;
	private JTextField jTextField_ten;
	private JTextField jTextField_hang;
	private JTextField jTextField_mansx;
	private JTextField jTextField_gia;
	private JCheckBox jCheckBox_nk;
	private JButton jButton_them;
	private JButton jButton_xoatrang;
	private JButton jButton_xoa;
	private JButton jButton_loc;
	private JTextField jTextField_tim;
	private JButton jButton_luu;
	private JLabel jLabel_tim;
	private DefaultTableModel tableModel;
	private JTable table;
	private JComboBox jComboBox_kho;
	private JRadioButton jRadioButton_conhang;
	private JRadioButton jRadioButton_hethang;
	private ButtonGroup buttonGroup_tinhtrang;
	private ButtonGroup buttonGroup_thue;
	private JRadioButton jRadioButton_VAT;
	private JRadioButton jRadioButton_GTGT;
	private AbstractButton jButton_sua;

	public Gui() {
		danhSachXe = new DanhSachXe();
		databasee = new Databasee();
		// TODO Auto-generated constructor stub
		this.setTitle("Tiến gk");
		this.setSize(800, 500);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.init();
		loadData();

		this.setVisible(true);

	}

	private void init() {
		// TODO Auto-generated method stub
		JPanel jPanel_nam = new JPanel();
		jPanel_nam.setLayout(new BorderLayout());
		jPanel_nam.setBorder(new TitledBorder("Thông tin xe"));
		TitledBorder titledBorder_xe = new TitledBorder("Thông tin xe");
		JPanel jPanel_con = new JPanel();
		JLabel jLabel_ma = new JLabel("Mã xe");
		JLabel jLabel_ten = new JLabel("Tên xe");
		JLabel jLabel_hang = new JLabel("Hãng sx");
		JLabel jLabel_namsx = new JLabel("Năm sx");
		JLabel jLabel_gia = new JLabel("Gía bán");
		JLabel jLabel_nk = new JLabel("Nhập khẩu");
		JLabel jLabel_kho = new JLabel("Kho chứa");
		JLabel jLabel_tinhtrang = new JLabel("     Tình Trạng");
		JLabel jLabel_thue = new JLabel("Thuế");

		jTextField_ma = new JTextField(20);
		jTextField_ten = new JTextField();
		jTextField_hang = new JTextField();
		jTextField_mansx = new JTextField();
		jTextField_gia = new JTextField();

		jCheckBox_nk = new JCheckBox();
		String kho[] = { "Bình Tân", "Gò Vấp", "Bình Thạnh" };
		jComboBox_kho = new JComboBox(kho);

		jRadioButton_conhang = new JRadioButton("Còn hàng");
		jRadioButton_hethang = new JRadioButton("Hết hàng");
		buttonGroup_tinhtrang = new ButtonGroup();
		buttonGroup_tinhtrang.add(jRadioButton_hethang);
		buttonGroup_tinhtrang.add(jRadioButton_conhang);

		jRadioButton_VAT = new JRadioButton("VAT");
		jRadioButton_GTGT = new JRadioButton("GTGT");
		buttonGroup_thue = new ButtonGroup();
		buttonGroup_thue.add(jRadioButton_VAT);
		buttonGroup_thue.add(jRadioButton_GTGT);

		BoxLayout boxLayout = new BoxLayout(jPanel_con, BoxLayout.Y_AXIS);
		Box b, b1, b2, b3, b4;

		b = Box.createVerticalBox();
		b1 = Box.createHorizontalBox();
		b2 = Box.createHorizontalBox();
		b3 = Box.createHorizontalBox();
		b4 = Box.createHorizontalBox();

		b1.add(jLabel_ma);
		b1.add(jTextField_ma);
//		b1.add(jLabel_r);
		b1.add(Box.createHorizontalStrut(400));

		b2.add(jLabel_ten);
		b2.add(jTextField_ten);
		b2.add(jLabel_hang);
		b2.add(jTextField_hang);

		b3.add(jLabel_namsx);
		b3.add(jTextField_mansx);
		b3.add(jLabel_gia);
		b3.add(jTextField_gia);

		b4.add(jLabel_nk);
		b4.add(jCheckBox_nk);
		b4.add(jLabel_tinhtrang);
		b4.add(jRadioButton_conhang);
		b4.add(jRadioButton_hethang);
		b4.add(jLabel_kho);
		b4.add(jComboBox_kho);
		b4.add(jLabel_thue);
		b4.add(jRadioButton_VAT);
		b4.add(jRadioButton_GTGT);
//		b4.add(Box.createHorizontalStrut(100));

//		b4.add(jLabel_r1);

		jLabel_namsx.setPreferredSize(jLabel_nk.getPreferredSize());
		jLabel_ma.setPreferredSize(jLabel_nk.getPreferredSize());
		jLabel_ten.setPreferredSize(jLabel_nk.getPreferredSize());
//		jLabel_nk.setPreferredSize(jTextField_ma.getPreferredSize());
//		b4.setBounds(0, 0, 10, 20);
		b.add(b1);
		b.add(b2);
		b.add(b3);
		b.add(b4);

		jPanel_con.add(b);
		jPanel_nam.add(jPanel_con, BorderLayout.NORTH);

		JPanel jPanel_giua = new JPanel();
		jPanel_giua.setLayout(new BorderLayout());
		JPanel giua_nam = new JPanel();

		jButton_them = new JButton("Thêm");
		jButton_xoatrang = new JButton("Xóa trắng");
		jButton_xoa = new JButton("Xóa");
		jButton_luu = new JButton("Lưu");
		jButton_sua = new JButton("Sửa");
		jButton_loc = new JButton("Lọc theo mã xe");
		jLabel_tim = new JLabel("Tìm theo mã xe");
		jTextField_tim = new JTextField(5);
		giua_nam.add(jButton_them);
		giua_nam.add(jButton_xoatrang);
		giua_nam.add(jButton_xoa);
		giua_nam.add(jButton_luu);
		giua_nam.add(jButton_sua);
		giua_nam.add(jLabel_tim);
		giua_nam.add(jTextField_tim);
		giua_nam.add(jButton_loc);
		jPanel_nam.add(giua_nam, BorderLayout.CENTER);
		this.add(jPanel_nam, BorderLayout.NORTH);

		// TABLE
		JPanel jPanel_giua_giua = new JPanel();
		jPanel_giua_giua.setLayout(new BorderLayout());
		tableModel = new DefaultTableModel();
		tableModel.addColumn("Mã xe");
		tableModel.addColumn("Tên xe");
		tableModel.addColumn("Hãng sx");
		tableModel.addColumn("Năm sx");
		tableModel.addColumn("Gía bán");
		tableModel.addColumn("Nhập khẩu");
		tableModel.addColumn("Kho chứa");
		tableModel.addColumn("Tình trạng");
		tableModel.addColumn("Thuế");

		table = new JTable(tableModel);
		table.setDefaultEditor(Object.class, null);
		table.setRowSelectionAllowed(true);

		JScrollPane jsp = new JScrollPane(table);
//		JScrollPane(table,  JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.setBorder(new TitledBorder("Danh mục xe"));
		jPanel_giua_giua.add(jsp);
		this.add(jPanel_giua_giua, BorderLayout.CENTER);

		// dưa jradio thuế xuống bảng thành jcombox
		TableColumn thueColumn = table.getColumnModel().getColumn(8);
		String thue[] = { "VAT", "GTGT" };
		JComboBox jComboBox_thue = new JComboBox(thue);
		thueColumn.setCellEditor(new DefaultCellEditor(jComboBox_thue));

		/// sk
		jButton_them.addActionListener(this);
		jButton_xoatrang.addActionListener(this);
		jButton_xoa.addActionListener(this);
		jButton_luu.addActionListener(this);
		jButton_sua.addActionListener(this);
		jButton_loc.addActionListener(this);

		table.addMouseListener(this);

	}

	public static void main(String[] args) {
		new Gui();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String src = e.getActionCommand();
		if (src.equals("Thêm")) {
			them();
		} else if (src.equals("Xóa trắng")) {
			xoatrang();
		} else if (src.equals("Xóa")) {
			xoa();
			databasee.savefile("Xe.dat", danhSachXe);

		} else if (src.equals("Lưu")) {
			databasee.savefile("Xe.dat", danhSachXe);
		} else if (src.equals("Lọc theo mã xe")) {
			tim();
		} else if (src.equals("Sửa")) {
			sua();
			databasee.savefile("Xe.dat", danhSachXe);

		}
	}

	private void sua() {
		// TODO Auto-generated method stub
		int dong = table.getSelectedRow();
		String ma = jTextField_ma.getText();
		String ten = jTextField_ten.getText();
		String hang = jTextField_hang.getText();
		int nam = Integer.parseInt(jTextField_mansx.getText());
		double gia = Double.parseDouble(jTextField_gia.getText());

		String nk = "";
		if (jCheckBox_nk.isSelected() == true) {
			nk = "Nhập khẩu";
		} else {
			nk = "Trong nước";
		}
		String kho = (String) jComboBox_kho.getSelectedItem();
		String tt = "";
		if (jRadioButton_conhang.isSelected()) {
			tt = "Còn hàng";
		} else {
			tt = "Hết hàng";
		}
		String thue = "";
		if (jRadioButton_VAT.isSelected()) {
			thue = "VAT";
		} else {
			thue = "GTGT";
		}
		Xe xe = new Xe(ma, ten, hang, nam, gia, nk, kho, tt, thue);
		danhSachXe.sua(xe);
		if (dong != -1) {
			for (int i = 0; i < table.getRowCount(); i++) {
				String matim = table.getValueAt(i, 0).toString();
				if (matim.equals(xe.getMa())) {
					if (!(matim.equals(jTextField_ma.getText()))) {
						JOptionPane.showConfirmDialog(this, "Mã không có sửa", "Thông báo", JOptionPane.OK_OPTION);
					} else {
						JOptionPane.showConfirmDialog(this, "Cập nhật thành công");
						table.setValueAt(xe.getMa(), i, 0);
						table.setValueAt(xe.getTen(), i, 1);
						table.setValueAt(xe.getHang(), i, 2);
						table.setValueAt(xe.getNam(), i, 3);
						table.setValueAt(xe.getGia(), i, 4);
						table.setValueAt(xe.getNk(), i, 5);
						table.setValueAt(xe.getKho(), i, 6);
						table.setValueAt(xe.getTinhTrang(), i, 7);
						table.setValueAt(xe.getLoaiThue(), i, 8);
					}

				}
			}

		} else {
			JOptionPane.showConfirmDialog(this, "Chọn 1 dòng", "Thông báo", JOptionPane.OK_OPTION);
		}
	}

	private void tim() {
		// TODO Auto-generated method stub
		String src = jTextField_tim.getText();
		Xe x = danhSachXe.tim(src);
		if (x != null) {

			for (int i = 0; i < table.getRowCount(); i++) {
				String code = table.getValueAt(i, 0).toString();
				if (src.equals(code)) {
					JOptionPane.showConfirmDialog(this, "thấy", "Thông báo", JOptionPane.OK_CANCEL_OPTION);
					table.setRowSelectionInterval(i, i);
					this.mouseClicked(null);
				}
			}
		} else {
			JOptionPane.showConfirmDialog(this, "Không thấy", "Thông báo", JOptionPane.OK_CANCEL_OPTION);
		}

	}

	private void xoa() {
		// TODO Auto-generated method stub
		int hang = table.getSelectedRow();
		if (hang != -1) {
			int src = JOptionPane.showConfirmDialog(this, "Bạn cÓ muốn xóa không", "Thông báo",
					JOptionPane.OK_CANCEL_OPTION);
			if (src == JOptionPane.OK_OPTION) {
				danhSachXe.xoa(hang);
				tableModel.removeRow(hang);
			} else {
				return;
			}

		} else {
			JOptionPane.showConfirmDialog(this, "Chọn 1 dòng", "Thông báo", JOptionPane.OK_OPTION);

		}
	}

	private void xoatrang() {
		// TODO Auto-generated method stub
		jTextField_ma.setText(" ");
		jTextField_ten.setText(" ");
		jTextField_hang.setText(" ");
		jTextField_mansx.setText(" ");
		jTextField_gia.setText(" ");
		jCheckBox_nk.setSelected(false);
		jComboBox_kho.setSelectedIndex(0);
		buttonGroup_tinhtrang.clearSelection();
		buttonGroup_thue.clearSelection();
	}

	private void them() {
		// TODO Auto-generated method stub
		String ma = jTextField_ma.getText();
		String ten = jTextField_ten.getText();
		String hang = jTextField_hang.getText();
		int nam = Integer.parseInt(jTextField_mansx.getText());
		double gia = Double.parseDouble(jTextField_gia.getText());

		String nk = "";
		if (jCheckBox_nk.isSelected() == true) {
			nk = "Nhập khẩu";
		} else {
			nk = "Trong nước";
		}
		String kho = (String) jComboBox_kho.getSelectedItem();
		String tt = "";
		if (jRadioButton_conhang.isSelected()) {
			tt = "Còn hàng";
		} else {
			tt = "Hết hàng";
		}
		String thue = "";
		if (jRadioButton_VAT.isSelected()) {
			thue = "VAT";
		} else {
			thue = "GTGT";
		}
		Xe xe = new Xe(ma, ten, hang, nam, gia, nk, kho, tt, thue);

		if (danhSachXe.them(xe)) {
			Object obj[] = new Object[9];
			obj[0] = ma;
			obj[1] = ten;
			obj[2] = hang;
			obj[3] = Integer.toString(nam);
			obj[4] = Double.toString(gia);
			obj[5] = nk;
			obj[6] = kho;
			obj[7] = tt;
			obj[8] = thue;

			JOptionPane.showConfirmDialog(this, "THêm thành công");
			tableModel.addRow(obj);
		} else {
			JOptionPane.showConfirmDialog(this, "Thêm không thành công, trùng mã", "Thông báo",
					JOptionPane.OK_CANCEL_OPTION);
			jTextField_ma.setText(" ");
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int hang = table.getSelectedRow();
		if (hang != -1) {
			jTextField_ma.setText(table.getValueAt(hang, 0).toString());
			jTextField_ten.setText(table.getValueAt(hang, 1).toString());
			jTextField_hang.setText(table.getValueAt(hang, 2).toString());
			jTextField_mansx.setText(table.getValueAt(hang, 3).toString());
			jTextField_gia.setText(table.getValueAt(hang, 4).toString());

			if (table.getValueAt(hang, 5).toString().equals("Nhập khẩu")) {
				jCheckBox_nk.setSelected(true);
			} else {
				jCheckBox_nk.setSelected(false);

			}
			jComboBox_kho.setSelectedItem(table.getValueAt(hang, 6));
			if (table.getValueAt(hang, 7).toString().equals("Còn hàng")) {
				jRadioButton_conhang.setSelected(true);
			} else {
				jRadioButton_hethang.setSelected(false);

			}
			if (table.getValueAt(hang, 8).toString().equals("VAT")) {
				jRadioButton_VAT.setSelected(true);
			} else {
				jRadioButton_GTGT.setSelected(false);

			}

		}
	}

	public void loadData() {
		danhSachXe = null;
		danhSachXe = (DanhSachXe) databasee.readfile("Xe.dat");
		if (danhSachXe == null) {
			danhSachXe = new DanhSachXe();
		} else {

			for (Xe x : danhSachXe.getDsze()) {
				Object[] o = new Object[9];
				o[0] = x.getMa();
				o[1] = x.getTen();
				o[2] = x.getHang();
				o[3] = x.getNam() + "";
				o[4] = x.getGia() + "";
				o[5] = x.getNk();
				o[6] = x.getKho();
				o[7] = x.getTinhTrang();
				o[8] = x.getLoaiThue();

				tableModel.addRow(o);
			}
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

***************************************************************************************

package GK2023_S6;

import java.io.Serializable;
import java.util.ArrayList;

public class DanhSachXe  implements Serializable{
	private ArrayList<Xe> dsze;

	public DanhSachXe(ArrayList<Xe> dsze) {
		super();
		this.dsze = dsze;
	}

	public ArrayList<Xe> getDsze() {
		return dsze;
	}
	public DanhSachXe() {
		// TODO Auto-generated constructor stub
		dsze = new ArrayList<Xe>();
	}

	public boolean them(Xe x) {
		if(!dsze.contains(x)) {
			dsze.add(x);
			return true;
		}
		return false;
	}
	public boolean xoa(int vt) {
		if(vt >=0 && vt<=dsze.size()-1) {
			dsze.remove(vt);
			return true;
		}
		return false;
	}
	public Xe tim(String ma) {
		for (Xe xe : dsze) {
			if(xe.getMa().equals(ma)) {
				return xe;
			}
		}
		return null;
	}
	public void sua(Xe x) {
		dsze.remove(x);
		dsze.add(x);
	}

}
***************************************KHÓA 16************************************************
package K16_GK;


import java.awt.BorderLayout;
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


public class Gui extends JFrame implements ActionListener, MouseListener{

	private QuanLySach quanLySach;
	private JLabel jLabel_maSach;
	private JLabel jLabel_soTrang;
	private JLabel jLabel_theLoai;
	private JLabel jLabel_tenSach;
	private JLabel jLabel_nhaXuatBan;
	private JTextField jTextField_maSach;
	private JTextField jTextField_tenSach;
	private JTextField jTextField_soTrang;
	private JComboBox jComboBox_theloai;
	private JTextField jTextField_nhaXuatBan;
	private DefaultTableModel tableModel;
	private JTable jTable;
	private JButton jButton_them;
	private JButton jButton_xoarong;
	private JButton jButton_xoa;
	private JButton jButton_luu;
	private JButton jButton_tim;
	private JTextField jTextField_tim;
	private JLabel jLabel_tim;
	private Databasee databasee;
	private JButton jButton_huy;
	private JButton jButton_huytim;

	public Gui() {
		quanLySach = new QuanLySach();		
		this.databasee = new Databasee();

		this.setTitle("Kiểm tra Giữa Kỳ Trần Minh Tiến - 21010611");
		this.setSize(800,500);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.init();
		this.setVisible(true);
		try {
			loadData();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	private void init() {
		JPanel jPanel_title = new JPanel();
			JLabel jLabel_title = new JLabel("THÔNG TIN SÁCH");
			jPanel_title.add(jLabel_title);
		this.add(jPanel_title, BorderLayout.NORTH);
		JPanel jPanel_center = new JPanel();
			jPanel_center.setLayout(new BorderLayout());
				JPanel jPanel_combobox = new JPanel();
					jPanel_combobox.setLayout(new BorderLayout());

					 jLabel_maSach = new JLabel("Mã sách:        ");
					 jLabel_tenSach = new JLabel("Tên sách:");
					 jLabel_soTrang = new JLabel("Số trang:");
					 jLabel_theLoai= new JLabel("Thể loại: ");
					 jLabel_nhaXuatBan = new JLabel("Nhà xuất bản:");
					
					 jTextField_maSach = new JTextField(62);
					 jTextField_tenSach = new JTextField();
					 jTextField_soTrang = new JTextField();
					String theloai[]= {"Toán", "Tin học", "Hóa học", "Sinh học"};
					 jComboBox_theloai = new JComboBox<>(theloai);
					 jTextField_nhaXuatBan = new JTextField();
					
					BoxLayout boxLayout = new BoxLayout(jPanel_combobox, BoxLayout.Y_AXIS);
					Box b, b1, b2, b3;
					b = Box.createVerticalBox();
						b1 = Box.createHorizontalBox();
						b2 = Box.createHorizontalBox();
						b3 = Box.createHorizontalBox();
					
						b1.add(jLabel_maSach);
						b1.add(jTextField_maSach);	
						jTextField_maSach.setPreferredSize(jLabel_maSach.getPreferredSize());
						
						b2.add(jLabel_tenSach);
						jLabel_tenSach.setPreferredSize(jLabel_maSach.getPreferredSize());

						b2.add(jTextField_tenSach);
						jTextField_tenSach.setPreferredSize(jLabel_maSach.getPreferredSize());

						b2.add(jLabel_soTrang);

						b2.add(jTextField_soTrang);
						
						b3.add(jLabel_theLoai);
						jLabel_theLoai.setPreferredSize(jLabel_maSach.getPreferredSize());

						b3.add(jComboBox_theloai);	
						jComboBox_theloai.setPreferredSize(jLabel_maSach.getPreferredSize());

						b3.add(jLabel_nhaXuatBan);
						b3.add(jTextField_nhaXuatBan);	
					b.add(b1);
					b.add(b2);
					b.add(b3);
					
					jPanel_combobox.add(b);
					jPanel_center.add(jPanel_combobox, BorderLayout.NORTH);
					
				JPanel jPanel_table = new JPanel();
				jPanel_table.setLayout(new BorderLayout());

				
				 tableModel = new DefaultTableModel();
				tableModel.addColumn("Mã sách");
				tableModel.addColumn("Tên sách");
				tableModel.addColumn("Số trang");
				tableModel.addColumn("Thể loại");
				tableModel.addColumn("Nhà xuất bản");
					
				 jTable= new JTable(tableModel);
				JScrollPane jsp = new JScrollPane(jTable);
				jPanel_table.add(jsp);
				jPanel_center.add(jPanel_table, BorderLayout.CENTER);

					
				JPanel jPanel_bt = new JPanel();
					 jButton_them = new JButton("Thêm");
					 jButton_xoarong = new JButton("Xóa rỗng");
					 jButton_xoa = new JButton("Xoá");
					 jButton_luu = new JButton("Lưu");
					 jButton_tim = new JButton("Tìm");
					 jButton_huytim = new JButton("Hủy tìm");
					 jTextField_tim = new JTextField(20);
					 jLabel_tim = new JLabel("Nhập mã sách cần tìm:");
				jPanel_bt.add(jLabel_tim);
				jPanel_bt.add(jTextField_tim);
				jPanel_bt.add(jButton_tim);
				jPanel_bt.add(jButton_them);
				jPanel_bt.add(jButton_xoarong);
				jPanel_bt.add(jButton_xoa);
				jPanel_bt.add(jButton_luu);
				
				
				
				this.add(jPanel_center, BorderLayout.CENTER);
				this.add(jPanel_bt, BorderLayout.SOUTH);
				
				//xự kiện
				jButton_them.addActionListener(this);
				jButton_xoarong.addActionListener(this);
				jButton_xoa.addActionListener(this);
				jButton_luu.addActionListener(this);
				jButton_tim.addActionListener(this);
				jButton_huytim.addActionListener(this);
				
				this.jTable.addMouseListener(this);
//				jButton_huytim.addMouseListener(this);

	}	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row= jTable.getSelectedRow();
		if(row!=-1) {
			jTextField_maSach.setText(jTable.getValueAt(row, 0).toString());
			jTextField_tenSach.setText(jTable.getValueAt(row, 1).toString());
			jTextField_soTrang.setText(jTable.getValueAt(row, 2).toString());
			jComboBox_theloai.setSelectedItem(jTable.getValueAt(row, 3));
			jTextField_nhaXuatBan.setText(jTable.getValueAt(row, 4).toString());
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
		String src = e.getActionCommand();
		if(src.equals("Thêm")) {
			themSach();
		}else if(src.equals("Xóa rỗng")) {
			xoaTrang();
		}else if(src.equals("Lưu")) {
			databasee.savefile("QLS.dat", quanLySach);
		}else if(src.equals("Xoá")) {
			xoa();
		}else if(src.equals("Tìm")) {
			tim();
		}
			else if(src.equals("Hủy tìm")) {
			try {
				huytim();
				jButton_tim.setText("Tìm");

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}	
	public void themSach() {
		String maSach = jTextField_maSach.getText();
		String tenSach = jTextField_tenSach.getText();
		int soTrang = Integer.parseInt(jTextField_soTrang.getText());
		String theLoai = (String) jComboBox_theloai.getSelectedItem();
		String nhaXuatBan = jTextField_nhaXuatBan.getText();
		Sach s = new Sach(maSach, tenSach, soTrang, theLoai, nhaXuatBan);
		if(soTrang>0)
		{
			if(!maSach.trim().equals("") && !tenSach.trim().equals("")&&  !theLoai.trim().equals("") && !nhaXuatBan.trim().equals("")) {
				if(quanLySach.themSach(s)) {
					Object obj[] = new Object[5];
					obj[0] = maSach;
					obj[1] = tenSach;
					obj[2] = Integer.toString(soTrang);
					obj[3] = theLoai;
					obj[4] = nhaXuatBan;
					JOptionPane.showConfirmDialog(this, "Thêm thành công");
					tableModel.addRow(obj);
				}
			}else {
				JOptionPane.showConfirmDialog(this, "Dữ liệu không được rỗng");
			}
		}else {
			JOptionPane.showConfirmDialog(this, "Số trang lớn 0");
		}


	}
	public void xoaTrang() {
		jTextField_maSach.setText(" ");
		jTextField_tenSach.setText(" ");
		jTextField_soTrang.setText(" ");
		jTextField_nhaXuatBan.setText(" ");
		jComboBox_theloai.setSelectedIndex(0);
	}
	public void xoa() {
		int hang = jTable.getSelectedRow();
		if(hang!=-1) {
			 int src = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa không");
			if(src == JOptionPane.YES_OPTION) {
				quanLySach.xoaSach(hang);
				tableModel.removeRow(hang);
				xoaTrang();
			}
		}else {
			 JOptionPane.showConfirmDialog(this, "Chọn một dòng cần xóa");
		}
		
	}
	public void tim() {
		String maSachTim = jTextField_tim.getText();
		Sach s = quanLySach.timSach(maSachTim);
		if(!maSachTim.trim().equals(""))
		{
				if(s!=null) {
				String hang[] = {s.getMaSach(), s.getTenSach(), s.getSoTrang()+"", s.getTheLoai(), s.getNhaXuatBan()};
				for(int i = 0; i<jTable.getRowCount();i++)
				{
					jTable.getSelectionModel().setSelectionInterval(i, i);
//					JOptionPane.showConfirmDialog(this, "Tìm thấy");

				}
				}else {
					JOptionPane.showConfirmDialog(this, "Không tìm thấy");
			}
		}else {
			JOptionPane.showConfirmDialog(this, "Nhập mã tìm");
		}	
	}
	//TÌM LẤY 1 DÒNG
	/*
	public void tim() {
		String maSachTim = jTextField_tim.getText();
		Sach s = quanLySach.timSach(maSachTim);
		if(!maSachTim.trim().equals(""))
		{
				if(s!=null) {
				tableModel.setRowCount(0);
				String hang[] = {s.getMaSach(), s.getTenSach(), s.getSoTrang()+"", s.getTheLoai(), s.getNhaXuatBan()};
				tableModel.addRow(hang);
				jButton_huytim.setEnabled(false);
				jButton_tim.setText("Hủy tìm");
				jTable.setRowSelectionInterval(0, 0);
				for(int i = 0; i<jTable.getRowCount();i++)
				{
					mouseClicked(null);

				}
				}else {
					JOptionPane.showConfirmDialog(this, "Không tìm thấy");
			}
		}else {
			JOptionPane.showConfirmDialog(this, "Nhập mã tìm");
		}
	}
	*/
	//tìm k trưc tiếp trên hàng không dùng hàm trên danh sách
//	private void tim() {
//	String key = jComboBox.getSelectedItem().toString();
//	for (int i = 0; i < table.getRowCount(); i++) {
//		String code = (String) table.getValueAt(i, 0);
//		if (key.equals(code)) {
//			table.getSelectionModel().setSelectionInterval(i, i);
//			table.repaint();
//		}
//	}
//}
	//tìm theo kiểu int:
	/*
	private void tim() {
		int pos = danhSachNhanVien.timKiem(this.jtf_khungtim.getText());
		if(pos==-1) {
			JOptionPane.showConfirmDialog(this, "Không tìm thấy id cần tìm", "Thông báo", JOptionPane.OK_CANCEL_OPTION);
		}else {
			JOptionPane.showMessageDialog(this, "Tìm thấy nhân viên");
			table.setRowSelectionInterval(pos, pos);
		}
	}
	*/
/*
	public void huytim() throws Exception {
		tableModel.removeRow(0);
		loadData();
	}
	public void loadData() throws Exception {
		quanLySach=null;
		quanLySach= (QuanLySach) databasee.readfile("QLS.dat");
		if(quanLySach==null) {
			quanLySach = new QuanLySach();
		}else {
			for (Sach s : quanLySach.getDs()) {
				String hang[] = {s.getMaSach(), s.getTenSach(), s.getSoTrang()+"", s.getTheLoai(), s.getNhaXuatBan()};
				tableModel.addRow(hang);
			}
		}
		
	}
	public static void main(String[] args) {
		new Gui();
		
	}
	

}
*/
/*
*****************************************entity**********************************************
********************************công ty*******************************************************

package entity;

import java.util.ArrayList;

import entity.PhongBan;

public class Congty {

	private ArrayList<PhongBan> dspb;

	public Congty() {
		super();
		this.dspb =new ArrayList<PhongBan>();
	}

	public ArrayList<PhongBan> getDspb() {
		return dspb;
	}

	public void themPhongBna(PhongBan pb) {
		dspb.add(pb);
	}
}

**************************************nhan vien*************************************************

package entity;

public class NhanVien {

	private String maSo;
	private String ho;
	private String ten;
	private boolean phai;
	private int tuoi;
	private long tienLuong;
	private PhongBan phongBan;
	public NhanVien(String maSo, String ho, String ten, boolean phai, int tuoi, long tienLuong, PhongBan phongBan) {
		super();
		this.maSo = maSo;
		this.ho = ho;
		this.ten = ten;
		this.phai = phai;
		this.tuoi = tuoi;
		this.tienLuong = tienLuong;
		this.phongBan = phongBan;
	}
	public String getMaSo() {
		return maSo;
	}
	public void setMaSo(String maSo) {
		this.maSo = maSo;
	}
	public String getHo() {
		return ho;
	}
	public void setHo(String ho) {
		this.ho = ho;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public boolean isPhai() {
		return phai;
	}
	public void setPhai(boolean phai) {
		this.phai = phai;
	}
	public int getTuoi() {
		return tuoi;
	}
	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}
	public long getTienLuong() {
		return tienLuong;
	}
	public void setTienLuong(long tienLuong) {
		this.tienLuong = tienLuong;
	}
	public PhongBan getPhongBan() {
		return phongBan;
	}
	public void setPhongBan(PhongBan phongBan) {
		this.phongBan = phongBan;
	}
	@Override
	public String toString() {
		return "NhanVien [maSo=" + maSo + ", ho=" + ho + ", ten=" + ten + ", phai=" + phai + ", tuoi=" + tuoi
				+ ", tienLuong=" + tienLuong + ", phongBan=" + phongBan + "]";
	}

}

*************************************phong ban**************************************************
package entity;

import java.util.ArrayList;
import java.util.Objects;

public class PhongBan {

	private String maPhong;
	private String tenPhong;
	private ArrayList<NhanVien> dsnv;
	public PhongBan(String maPhong, String tenPhong) {
		super();
		this.maPhong = maPhong;
		this.tenPhong = tenPhong;
		this.dsnv = new ArrayList<NhanVien>();
	}
	
	public void themNhanVien(String maSo, String ho, String ten, boolean phai, int tuoi, long tienLuong ) {
		NhanVien nv = new NhanVien(maSo, ho, ten, phai, tuoi, tienLuong, this); 
		dsnv.add(nv);
		
	}

	public String getMaPhong() {
		return maPhong;
	}

	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}

	public String getTenPhong() {
		return tenPhong;
	}

	public void setTenPhong(String tenPhong) {
		this.tenPhong = tenPhong;
	}

	public ArrayList<NhanVien> getDsnv() {
		return dsnv;
	}

	public void setDsnv(ArrayList<NhanVien> dsnv) {
		this.dsnv = dsnv;
	}

	@Override
	public String toString() {
		return tenPhong;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dsnv, maPhong, tenPhong);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhongBan other = (PhongBan) obj;
		return Objects.equals(dsnv, other.dsnv) && Objects.equals(maPhong, other.maPhong)
				&& Objects.equals(tenPhong, other.tenPhong);
	}
	
	
}
********************************GUI*******************************************************

********************************APP*******************************************************

package GUI;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import entity.Congty;
import entity.NhanVien;
import entity.PhongBan;

public class Application extends JFrame{

	private ArrayList<PhongBan>dspb;
	private DefaultMutableTreeNode root;
	private JTree tree;

	public Application(ArrayList<PhongBan> dspb) {
		super();
		this.setTitle("---^^---");
//		this.setExtendedState(MAXIMIZED_BOTH);
		this.setSize(800,480);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.dspb = dspb;
		
		root = new DefaultMutableTreeNode("Danh sách phòng ban");
		tree= new JTree(root);
		tree.setShowsRootHandles(true);
		
		int sophongban = dspb.size();
		for(int i = 0; i<sophongban; i++) {
			PhongBan pb = dspb.get(i);
			DefaultMutableTreeNode node = new DefaultMutableTreeNode(pb);
			root.add(node);
		}
		add(new JScrollPane(tree), BorderLayout.CENTER);
		tree.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(e.getClickCount()==2) {
					DefaultMutableTreeNode x = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
					if(x!=null) {
						Object gt = x.getUserObject();
						if(gt instanceof PhongBan) {
							PhongBan pb = (PhongBan) x.getUserObject();
							ArrayList<NhanVien> dsnv = pb.getDsnv();
							NhanvienGIU giu = new NhanvienGIU(dsnv, pb.getTenPhong());
							giu.show();
						}
					}
				}
			}
		});
	}
		
	public static void main(String[] args) {
		Congty ct = new Congty();
		PhongBan tc, kt;
		ct.themPhongBna(tc = new PhongBan("TC", "Phòng Tài chính"));
		ct.themPhongBna(kt = new PhongBan("KT", "Phòng Kỹ Thuật"));
		
		
		tc.themNhanVien("1112", "Trần", "Na", true, 25, 366666);
		kt.themNhanVien("8888", "Trần", "Tiến", true, 25, 366666);
		tc.themNhanVien("1111", "Trần", "Huỳnh", true, 25, 366666);
		kt.themNhanVien("1000", "Phan", "Sinh", true, 15, 366666);
		kt.themNhanVien("7777", "Nguyễn", "Tài", true, 15, 366666);
		tc.themNhanVien("6666", "Trần", "Kỹ", false, 25, 366666);
		
		

		
		ArrayList<PhongBan> dspb = ct.getDspb();
		new Application(dspb).setVisible(true);
	}
	
}

********************************NHAVIEN GUI*******************************************************
package GUI;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import entity.NhanVien;

public class NhanvienGIU extends JFrame {

	private ArrayList<NhanVien> dsnv;
	private JTable jTable;
	private DefaultTableModel model;

	public NhanvienGIU(ArrayList<NhanVien> dsnv, String title) {
		this.setTitle(title);
		this.setSize(600,380);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.dsnv = dsnv;
		String colum[] = {"Mã", "Họ", "Tên", "Phòng ban", "Tuổi", "Tiền lương"};
//		model = new DefaultTableModel(colum, 0);		
		jTable = new JTable(model = new DefaultTableModel(colum, 0));

		for(int i = 0; i<dsnv.size();i++) {
			NhanVien nv = dsnv.get(i);
			String hang[] = {nv.getMaSo(), nv.getHo(), nv.getTen(), nv.getPhongBan().toString(), nv.getTuoi()+"", nv.getTienLuong()+""};
			model.addRow(hang);
		}
		jTable.setRowHeight(30);
		add(new JScrollPane(jTable), BorderLayout.CENTER);
	}
	
}



*/