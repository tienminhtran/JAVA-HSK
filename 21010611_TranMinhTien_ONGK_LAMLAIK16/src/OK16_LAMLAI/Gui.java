package OK16_LAMLAI;

import java.awt.BorderLayout;
import java.awt.Dimension;
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

public class Gui extends JFrame implements ActionListener, MouseListener {

	private DanhSachSach danhSachSach;
	private JTextField jTextField_ma;
	private JTextField jTextField_ten;
	private JTextField jTextField_theloai;
	private JTextField jTextField_sotrang;
	private DefaultTableModel tableModel;
	private JTable table;
	private JButton jPanel_them;
	private JButton jButton_tim;
	private JButton jButton_xoatarng;
	private JButton jButton_xoa;
	private JButton jButton_luu;
	private JTextField jTextField_tim;
	private JTextField jTextField_nxb;
	private JComboBox jComboBox;

	public Gui() {
		danhSachSach = new DanhSachSach();
		this.setTitle("BÀI GIỮA KỲ");
		this.setSize(800, 500);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.innit();
		this.setVisible(true);
	}

	private void innit() {
		JPanel jPanel_bac = new JPanel();
		JLabel jLabel_title = new JLabel("THÔNG TIN SÁCH");
		jPanel_bac.add(jLabel_title);
		this.add(jPanel_bac, BorderLayout.NORTH);
		JPanel jPanel_giua = new JPanel();
		jPanel_giua.setLayout(new BorderLayout());
		JPanel jPanel_giua_componet = new JPanel();
		BoxLayout boxLayout = new BoxLayout(jPanel_giua_componet, BoxLayout.Y_AXIS);

		JLabel jLabel_ma = new JLabel("Mã sách");
		JLabel jLabel_ten = new JLabel("Tên");
		JLabel jLabel_sotrang = new JLabel("Số trang");
		JLabel jLabel_theloai = new JLabel("Thể loại");
		JLabel jLabel_nxb = new JLabel("Nhà xuất bản");

		jTextField_ma = new JTextField();
		jTextField_ten = new JTextField();
		jTextField_sotrang = new JTextField();
		jTextField_ma.setPreferredSize(jLabel_theloai.getPreferredSize());
		jTextField_ten.setPreferredSize(jLabel_theloai.getPreferredSize());
		String s[] = { "Toán", "Lý", "Tin học" };
		jComboBox = new JComboBox(s);
		jTextField_nxb = new JTextField();
		Box b, b1, b2, b3;
		b = Box.createVerticalBox();
		b1 = Box.createHorizontalBox();
		b2 = Box.createHorizontalBox();
		b3 = Box.createHorizontalBox();

		b.add(b1);
		b.add(b2);
		b.add(b3);
		b1.add(jLabel_ma);
		b1.add(jTextField_ma);
		b2.add(jLabel_ten);
		b2.add(jTextField_ten);
		b2.add(jLabel_sotrang);
		b2.add(jTextField_sotrang);
		b3.add(jLabel_theloai);
		b3.add(jComboBox);
		b3.add(jLabel_nxb);
		b3.add(jTextField_nxb);

		// table
		JPanel jPanel_giua_TABLE = new JPanel();

		tableModel = new DefaultTableModel();
		tableModel.addColumn("Mả sách");
		tableModel.addColumn("Tên sách");
		tableModel.addColumn("Số trang");
		tableModel.addColumn("Thể loại");
		tableModel.addColumn("Nhà xuất bản");
		table = new JTable(tableModel);
		Dimension size = new Dimension(780, 250);
		table.setPreferredScrollableViewportSize(size);
		JScrollPane jsp = new JScrollPane(table);
		jPanel_giua_TABLE.add(jsp);

		jPanel_giua.add(b, BorderLayout.NORTH);
		jPanel_giua.add(jPanel_giua_TABLE, BorderLayout.CENTER);

		this.add(jPanel_giua, BorderLayout.CENTER);

		JPanel jPanel_btn = new JPanel();

		JLabel jLabel_tim = new JLabel("Nhập mã cần tìm");
		jTextField_tim = new JTextField(20);

		jPanel_them = new JButton("Thêm");
		jButton_tim = new JButton("Tìm");
		jButton_xoatarng = new JButton("Xóa trắng");
		jButton_xoa = new JButton("Xóa");
		jButton_luu = new JButton("Lưu");
		jPanel_btn.add(jLabel_tim);
		jPanel_btn.add(jTextField_tim);
		jPanel_btn.add(jButton_tim);
		jPanel_btn.add(jPanel_them);
		jPanel_btn.add(jButton_xoatarng);
		jPanel_btn.add(jButton_xoa);
		jPanel_btn.add(jButton_luu);
		this.add(jPanel_btn, BorderLayout.SOUTH);

		// sk
		jPanel_them.addActionListener(this);
		jButton_tim.addActionListener(this);
		jButton_xoatarng.addActionListener(this);
		jButton_xoa.addActionListener(this);
		jButton_luu.addActionListener(this);

		table.addMouseListener(this);

	}

	public static void main(String[] args) {
		new Gui();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if (src.equals("Thêm")) {
			them();
		} else if (src.equals("Xóa trắng")) {
			XOATRANG();
		} else if (src.equals("Xóa")) {
			xoa();
		} else if (src.equals("Tìm")) {
			tim();
		}

	}

	public void tim() {
		String maSachTim = jTextField_tim.getText();
		Sach s = danhSachSach.tim(maSachTim);
		if (!maSachTim.trim().equals("")) {
			if (s != null) {
				String hang[] = { s.getMaSach(), s.getTenSach(), s.getSoTrang() + "", s.getTheLoai(),
						s.getNhaXuatBan() };
				for (int i = 0; i < table.getRowCount(); i++) {
					table.getSelectionModel().setSelectionInterval(i, i);

				}
			} else {
				JOptionPane.showConfirmDialog(this, "Không tìm thấy");
			}
		} else {
			JOptionPane.showConfirmDialog(this, "Nhập mã tìm");
		}
	}

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
	private void them() {
		// TODO Auto-generated method stub
		String maSach = jTextField_ma.getText();
		String tenSach = jTextField_ten.getText();
		int soTrang = Integer.parseInt(jTextField_sotrang.getText());
		String theLoai = jComboBox.getSelectedItem() + "";
		String nhaXuatBan = jTextField_nxb.getText();

		if (!maSach.trim().equals("") && !tenSach.trim().equals("") && !theLoai.trim().equals("")
				&& !nhaXuatBan.trim().equals("")) {
		Object obj[] = new Object[5];
		obj[0] = maSach;
		obj[1] = tenSach;
		obj[2] = Integer.toString(soTrang);
		obj[3] = theLoai;
		obj[4] = nhaXuatBan;
		Sach s = new Sach(maSach, tenSach, soTrang, theLoai, nhaXuatBan);
			danhSachSach.themSach(s);
			tableModel.addRow(obj);
		} else {
			JOptionPane.showConfirmDialog(this, "DỮ LIÊU RỖNG");
		}

	}

	private void XOATRANG() {
		jTextField_ma.setText(" ");
		jTextField_ten.setText(" ");
		jTextField_theloai.setText(" ");
		jTextField_sotrang.setText(" ");
		jComboBox.setSelectedItem("Toán");
		jTextField_nxb.setText(" ");
	}

	private void xoa() {
		int hang = table.getSelectedRow();
		if (hang != -1) {
			int check = JOptionPane.showConfirmDialog(this, "Bạn muốn xóa hả", "TT", JOptionPane.OK_CANCEL_OPTION);
			if (check == JOptionPane.OK_OPTION) {
				danhSachSach.xoaSach(hang);
				tableModel.removeRow(hang);
			}

		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int hang = table.getSelectedRow();
		if (hang != -1) {
			jTextField_ma.setText(table.getValueAt(hang, 0).toString());
			jTextField_ten.setText(table.getValueAt(hang, 1).toString());
			jTextField_sotrang.setText(table.getValueAt(hang, 2).toString());
			jComboBox.setSelectedItem(table.getValueAt(hang, 3));
			jTextField_nxb.setText(table.getValueAt(hang, 4).toString());
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
