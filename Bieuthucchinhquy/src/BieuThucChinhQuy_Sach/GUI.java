/*^ký tự đầu
Ký tự cuối$
[abc] a hoặc b hoặc c
[^abc] ngoại từ a, b, c 
[a-d1-7] chỉ cho nhập 1 ký tự từ a-d hoặc 1-7. Nếu muốn nhập nhiều a2/ 12 thì thêm +
X | Z là x hoặc z
XZ tìm x theo z
QUY ĐỊNH
\\d số từ [0-9] cách 2 [0-9] 
\\D là ký tự cách 2 [^0-9]
\\s là ký tự khoảng trắng
\\S Không có khoảng trắng cách 2 [^\\s]
\\w Chữ và số
\\W Không chữ, số
\\S+ Một số ký tự không là khoảng trắng
\\b thuộc a-z hoặc A- Z hoặc 0-9  cách 2 [a-zA-Z0-9]
\\. Là kiếm dấu .
\\@ Là chữ @
. là số hoặc chữ 1 lần
SỐ LƯỢNG
*	0 hoặc nhiều
+ 	1 hoặc nhiều
?	0 hoặc 1 cách 2 {0,1}
{X}	x lần
{X,Y}	ít nhất x lần và nhiều nhất y lần
*?
*/

package BieuThucChinhQuy_Sach;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;
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

	private QLSACH qlsach;
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

		qlsach = new QLSACH();
		setTitle("Quản lý sách");
		setSize(1000, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		init();
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
		JScrollPane jScrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String src = e.getActionCommand();
		if (src.equals("Thêm")) {
			them();

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

	}

	public boolean masach_check(String ma) {
		String tuasach = jTextField_tuaSach.getText();
		String kytudau = tuasach.substring(0, 1);
		String s = kytudau + "\\d{3}";
		return ma.matches(s);
	}

	public boolean tuasach_tacgia_check(String src) {
		String s = "[a-zA-Z\\s+\\.]+";
		return src.matches(s);
	}

	public boolean isbn(String src) {
		String s = "\\d+(-\\d+){3,4}";
		return src.matches(s);
	}
	public boolean Kiemtrarong_chuoi(String src) {
		String s = "^\\s+$";
		return src.matches(s);
	}
	public boolean kiemtrarong_so(String src) {
		String s = "[0-9]+";
		return src.matches(s);
	}
	public boolean vadi() {
		String maSach = jTextField_maSach.getText();
		String tuaSach = jTextField_tuaSach.getText();
		String tacGia = jTextField_tacGia.getText();
		int namXuatBan = Integer.parseInt(jTextField_namXB.getText());
		String nhaXuatBan = jTextField_nhaXB.getText();
		int soTrang = Integer.parseInt(jTextField_soTrang.getText());
		double donGia = Double.parseDouble(jTextField_donGia.getText());
		String ISBN = jTextField_ISBN.getText();
		if (!masach_check(maSach)) {
			JOptionPane.showMessageDialog(this,
					"Mã sách phải theo qui ước sau: Có ký tự đầu là ký tự đầu của tựa sách, theo sau là 3 ký số");
			return false;
		}
		if (!tuasach_tacgia_check(tuaSach)) {
			JOptionPane.showMessageDialog(this, "Tựa sách phải theo qui ước");
			return false;
		}
		if (!tacGia.trim().equals("")) {
			if (!tuasach_tacgia_check(tacGia)) {
				JOptionPane.showMessageDialog(this, "Tác giả phải theo qui ước");
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(this, "Tác giả rỗng");
		}

		if (!isbn(ISBN)) {
			JOptionPane.showMessageDialog(this, "ISBN phải theo qui ước");
			return false;
		}
		
		return true;
	}

	public void them() {

		String maSach = jTextField_maSach.getText();
		String tuaSach = jTextField_tuaSach.getText();
		String tacGia = jTextField_tuaSach.getText();
		int namXuatBan = Integer.parseInt(jTextField_namXB.getText());
		String nhaXuatBan = jTextField_nhaXB.getText();
		int soTrang = Integer.parseInt(jTextField_soTrang.getText());
		double donGia = Double.parseDouble(jTextField_donGia.getText());
		String ISBN = jTextField_ISBN.getText();
		Sach s = new Sach(maSach, tuaSach, tacGia, namXuatBan, nhaXuatBan, soTrang, donGia, ISBN);
		if (!Kiemtrarong_chuoi(nhaXuatBan)) {
			if (vadi()) {
				if (qlsach.them(s)) {
					Object obj[] = new Object[8];
					obj[0] = maSach;
					obj[1] = tuaSach;
					obj[2] = tacGia;
					obj[3] = namXuatBan;
					obj[4] = nhaXuatBan;
					obj[5] = soTrang;
					obj[6] = donGia;
					obj[7] = ISBN;
					tableModel.addRow(obj);
					JOptionPane.showMessageDialog(this, "Thành");
				} else {
					JOptionPane.showMessageDialog(this, "id trùng");
				}
			} else {
				JOptionPane.showMessageDialog(this, "K Thành");
			}
		} else {
			JOptionPane.showMessageDialog(this, "RỖNG");

		}

	}

	public static void main(String[] args) {
		new GUI();
	}
}
