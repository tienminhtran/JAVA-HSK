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
