package GK_2023;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.lang.model.element.Element;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class GUI extends JFrame implements ActionListener, MouseListener {

	private QLXe ds;
	private Database database;
	private JLabel jLabel_ma, jLabel_ten, jLabel_namsx, jLabel_nk, jLabel_hang, jLabel_gia, jLabel_timXe;
	private JTextField jtext_ma, jtext_ten, jtext_namsx, jtext_hang, jtext_gia, jtext_timXe;
	private JButton jbt_them, jbt_xoa, jbt_XoaR, jbt_tim, jbt_luu;
	private JCheckBox jCbox_nk;
	private JTable table;
	private DefaultTableModel model;

	public GUI() {
		ds = new QLXe();
		database = new Database();
		setTitle("Phan Tien Sinh 21010761");
		setResizable(false);
		setLocationRelativeTo(null);
		setSize(900, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		showit();
		try {
			loadData();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void showit() {
		// component
		jLabel_ma = new JLabel("Mã xe:");
		jLabel_ten = new JLabel("Tên xe:");
		jLabel_namsx = new JLabel("Năm sản xuất");
		jLabel_nk = new JLabel("Nhập khẩu");
		jLabel_hang = new JLabel("Hãng SX");
		jLabel_gia = new JLabel("Giá bán");
		jLabel_timXe = new JLabel("Tìm theo mã Xe");

		jtext_ma = new JTextField();
		jtext_ten = new JTextField();
		jtext_namsx = new JTextField();
		jtext_hang = new JTextField();
		jtext_gia = new JTextField();
		jtext_timXe = new JTextField();

		jbt_luu = new JButton("Lưu");
		jbt_them = new JButton("Thêm");
		jbt_tim = new JButton("Lọc theo Mã Xe");
		jbt_xoa = new JButton("Xóa");
		jbt_XoaR = new JButton("Xóa Trắng");

		jCbox_nk = new JCheckBox();

		// khu vuc bac-textfield

		JPanel jPanel_north = new JPanel();
		jPanel_north.setLayout(new BoxLayout(jPanel_north, BoxLayout.Y_AXIS));

		Box b_main, b1, b2, b3, b4;
		b_main = Box.createVerticalBox();
		b_main.add(Box.createVerticalStrut(15));
		b_main.add(b1 = Box.createHorizontalBox());
		b_main.add(Box.createVerticalStrut(15));
		b_main.add(b2 = Box.createHorizontalBox());
		b_main.add(Box.createVerticalStrut(15));
		b_main.add(b3 = Box.createHorizontalBox());
		b_main.add(Box.createVerticalStrut(15));
		b_main.add(b4 = Box.createHorizontalBox());
		b_main.add(Box.createVerticalStrut(15));

		b1.add(jLabel_ma);
		b1.add(jtext_ma);
		jLabel_ma.setPreferredSize(jLabel_namsx.getPreferredSize());

		b2.add(jLabel_ten);
		b2.add(jtext_ten);
		b2.add(jLabel_hang);
		b2.add(jtext_hang);
		jLabel_ten.setPreferredSize(jLabel_namsx.getPreferredSize());

		b3.add(jLabel_namsx);
		b3.add(jtext_namsx);
		b3.add(jLabel_gia);
		b3.add(jtext_gia);

		b4.add(jLabel_nk);
		b4.add(jCbox_nk);
		b4.add(Box.createHorizontalStrut(800));
		jPanel_north.add(b_main);

		// khu vuc center
		JPanel jPanel_center = new JPanel();
		jPanel_center.setLayout(new BoxLayout(jPanel_center, BoxLayout.Y_AXIS));

		Box b_bt = Box.createHorizontalBox();
		b_bt.add(Box.createHorizontalStrut(60));
		b_bt.add(jbt_them);
		b_bt.add(Box.createHorizontalStrut(10));
		b_bt.add(jbt_XoaR);
		b_bt.add(Box.createHorizontalStrut(10));
		b_bt.add(jbt_xoa);
		b_bt.add(Box.createHorizontalStrut(10));
		b_bt.add(jbt_luu);
		b_bt.add(Box.createHorizontalStrut(10));
		b_bt.add(jLabel_timXe);
		b_bt.add(Box.createHorizontalStrut(10));
		b_bt.add(jtext_timXe);
		b_bt.add(Box.createHorizontalStrut(10));
		b_bt.add(jbt_tim);
		b_bt.add(Box.createHorizontalStrut(60));

		jPanel_center.add(b_bt);

		String[] column = { "Mã Xe", "Tên Xe", "Hãng SX", "Năm SX", "Giá bán", "Nhập khẩu" };
		model = new DefaultTableModel(column, 0);
		table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		jPanel_center.add(scrollPane);

		add(jPanel_north, BorderLayout.NORTH);
		add(jPanel_center, BorderLayout.CENTER);
		
		//XLSK
		jbt_luu.addActionListener(this);
		jbt_them.addActionListener(this);
		jbt_tim.addActionListener(this);
		jbt_xoa.addActionListener(this);
		jbt_XoaR.addActionListener(this);
		
		table.addMouseListener(this);
	}

	public void them() {
		if (jtext_ma.getText().equals("") || jtext_ten.getText().equals("") || jtext_hang.getText().equals("")
				|| jtext_namsx.getText().equals("") || jtext_gia.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Vui long nhap day du thong tin");
			jtext_ma.requestFocus();
			xoaRong();

		} else {
			String ma = jtext_ma.getText();
			String tenxe = jtext_ten.getText();
			String hang = jtext_hang.getText();
			String nhapkhau = "";
			if (jCbox_nk.isSelected() == true) {
				nhapkhau = "Nhập khẩu";
			} else {
				nhapkhau = "Xuất khẩu";

			}
			int namsx = Integer.parseInt(jtext_namsx.getText());
			int gia = Integer.parseInt(jtext_gia.getText());
			Xe x = new Xe(ma, tenxe, hang, nhapkhau, namsx, gia);

			if (ds.them(x)) {
				Object[] o = new Object[6];
				o[0] = ma;
				o[1] = tenxe;
				o[2] = hang;
				o[3] = namsx+"";
				o[4] = gia+"";
				o[5] = nhapkhau;
				model.addRow(o);
				JOptionPane.showMessageDialog(this, "Thêm thành công!!");
				xoaRong();
			} else {
				JOptionPane.showMessageDialog(this, "Mã xe trùng!!");
			}
		}

	}

	
	public void xoa() {
		int row = table.getSelectedRow();
		if(row!= 1) {
			if(JOptionPane.showConfirmDialog(this, "Có chắc là xóa dòng này không?","Cảnh báo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				ds.xoa(row);
				model.removeRow(row);
				JOptionPane.showMessageDialog(this, "Xóa thành công!!");
				xoaRong();
			}
		} else {
			JOptionPane.showMessageDialog(this, "Xóa thành công!!");

		}
		
	}
	
	public void tim() {
		String maTim =  jtext_timXe.getText();
		Xe x = ds.timKiem(maTim);
		if(x!=null ) {
			for (int i = 0; i < table.getRowCount(); i++) {
				String table_data_tim  = table.getValueAt(i, 0).toString();
				if(table_data_tim.equals(maTim)) {
					table.setRowSelectionInterval(i, i);
					mouseClicked(null);
				}
			}
			jtext_timXe.setText("");
//			jtext_timXe.requestFocus();
		} else {
			JOptionPane.showMessageDialog(this, "Không tìm thấy!!");

		}
	}
	
	public void loadData()throws Exception {
		ds = null;
		ds = (QLXe) database.readFile("Xe.dat");
		if(ds==null) {
			ds = new QLXe();
		} else {
			for (Xe x : ds.getDs()) {
				Object[] o = new Object[6];
				o[0] = x.getMa();
				o[1] = x.getTenxe();
				o[2] = x.getHang();
				o[3] = x.getNamsx()+"";
				o[4] = x.getGia()+"";
				o[5] = x.getNhapkhau();
				model.addRow(o);
			}
		}
	}
	public void xoaRong() {
		jtext_gia.setText("");
		jtext_hang.setText("");
		jtext_ma.setText("");
		jtext_namsx.setText("");
		jtext_ten.setText("");
		jCbox_nk.setSelected(false);
	}
	public static void main(String[] args) {
		new GUI().setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		jtext_gia.setText(table.getValueAt(row, 4).toString());
		jtext_hang.setText(table.getValueAt(row, 2).toString());
		jtext_ma.setText(table.getValueAt(row, 0).toString());
		jtext_namsx.setText(table.getValueAt(row, 3).toString());
		jtext_ten.setText(table.getValueAt(row, 1).toString());
		boolean check;
		if(table.getValueAt(row, 5).toString().equals("Nhập khẩu")) {
			check = true;
		} else {
			check = false;
		}
		jCbox_nk.setSelected(check);
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
		Object s = e.getSource();
		if(s.equals(jbt_them)) {
			them();
		} else if(s.equals(jbt_xoa)) {
			xoa();
		} else if(s.equals(jbt_XoaR)) {
			xoaRong();
		} else if(s.equals(jbt_tim)) {
			tim();
		} else if(s.equals(jbt_luu)) {
			database.saveFile("Xe.dat", ds);

		}

	}

}
