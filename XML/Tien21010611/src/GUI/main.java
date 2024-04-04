package GUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DAO.LopHoc_Dao;
import connectDB.ConnectDB;
//import db.contentDB;
import emtity.LopHoc;

public class main extends JFrame implements ActionListener {
	private JLabel jLabel_malop, jLabel_tenlop, jLabel_gvcn;
	private JTextField jtext_malop, jtext_tenlop, jtext_gvcn;
	private JButton jbt_them, jbt_xoa, jbt_sua, jbt_luu, jbt_xemTT, jbt_mt_trai, jbt_mt_tt, jbt_mt_p, jbt_mt_pp;
	private JTable table;
	private DefaultTableModel model;
	private LopHoc_Dao lop_Dao;
	private ConnectDB connectDB;

	public main() throws SQLException {
		lop_Dao = new LopHoc_Dao();
		connectDB = new ConnectDB();
		try {
			connectDB.connect();

		} catch (SQLException e) {
			e.printStackTrace();
		}
//        	connectDB.connect();

		setTitle("Lop hoc");
		setSize(900, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		showIT();
		khoa();

	}

	public void showIT() {
		jLabel_malop = new JLabel("Ma lop");
		jLabel_tenlop = new JLabel("Ten lop: ");
		jLabel_gvcn = new JLabel("GVCN");

		jtext_malop = new JTextField();
		jtext_tenlop = new JTextField();
		jtext_gvcn = new JTextField();

		jbt_them = new JButton("Them");
		jbt_xoa = new JButton("Xoa");
		jbt_sua = new JButton("Sua");
		jbt_luu = new JButton("Luu");
		jbt_xemTT = new JButton("Xem thong tin sinh vien");
		jbt_mt_trai = new JButton("<");
		jbt_mt_tt = new JButton("<<");
		jbt_mt_p = new JButton(">");
		jbt_mt_pp = new JButton(">>");

		JPanel jPanel_north = new JPanel();
		JLabel jLabel_td = new JLabel("THONG TIN LOP HOC");
		jPanel_north.add(jLabel_td, BorderLayout.CENTER);

		String[] colum = { "Ma lop", "Ten Lop", "Si so" };
		model = new DefaultTableModel(colum, 0);
		table = new JTable(model);

		JScrollPane sc = new JScrollPane(table);

		JPanel jPanel_south = new JPanel();
		jPanel_south.setLayout(new BoxLayout(jPanel_south, BoxLayout.Y_AXIS));

		JPanel jPanel_button_muiten = new JPanel();
		jPanel_button_muiten.add(jbt_mt_tt);
		jPanel_button_muiten.add(jbt_mt_trai);
		jPanel_button_muiten.add(jbt_mt_p);
		jPanel_button_muiten.add(jbt_mt_pp);

		jPanel_south.add(jPanel_button_muiten);

		Box b_main, b1, b2, b3;
		b_main = Box.createVerticalBox();
		b_main.add(b1 = Box.createHorizontalBox());
		b_main.add(b2 = Box.createHorizontalBox());
		b_main.add(b3 = Box.createHorizontalBox());

		b1.add(jLabel_malop);
		b1.add(jtext_malop);
		b1.add(Box.createHorizontalStrut(600));
		jLabel_malop.setPreferredSize(jLabel_tenlop.getPreferredSize());
		b2.add(jLabel_tenlop);
		b2.add(jtext_tenlop);
		b3.add(jLabel_gvcn);
		b3.add(jtext_gvcn);
		b3.add(Box.createHorizontalStrut(300));
		jLabel_gvcn.setPreferredSize(jLabel_tenlop.getPreferredSize());

		jPanel_south.add(b_main);

		JPanel jPanel_bt_tt = new JPanel();
		jPanel_bt_tt.add(jbt_them);
		jPanel_bt_tt.add(jbt_luu);
		jPanel_bt_tt.add(jbt_sua);
		jPanel_bt_tt.add(jbt_xoa);
		jPanel_bt_tt.add(jbt_xemTT);

//		jtext_gvcn.setEditable(false);
//		jbt_luu.setEnabled(false);

		jPanel_south.add(jPanel_bt_tt);

		add(jPanel_north, BorderLayout.NORTH);
		add(sc, BorderLayout.CENTER);
		add(jPanel_south, BorderLayout.SOUTH);

		// loaddata tu SQL

		table.setRowHeight(25);

		for (LopHoc lh : lop_Dao.getAllLopHoc()) {
			Object[] rowData = { lh.getMalop(), lh.getTenlop(), lh.getGiaovienCN() };
			model.addRow(rowData);
		}

		table.addMouseListener(new MouseListener() {

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
				int row = table.getSelectedRow();
				jtext_malop.setText(table.getValueAt(row, 0).toString());
				jtext_tenlop.setText(table.getValueAt(row, 1).toString());
				jtext_gvcn.setText(table.getValueAt(row, 2).toString());

			}
		});

		jbt_them.addActionListener(this);
		jbt_xoa.addActionListener(this);
		jbt_sua.addActionListener(this);
		jbt_luu.addActionListener(this);

	}

	public static void main(String[] args) throws SQLException {
		new main().setVisible(true);
	}

	public void khoa() {
		jtext_malop.setEnabled(false);
		jtext_tenlop.setEnabled(false);
		jtext_gvcn.setEnabled(false);
	}

	public void mokhoa() {
		jtext_malop.setEnabled(true);
		jtext_tenlop.setEnabled(true);
		jtext_gvcn.setEnabled(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String src = e.getActionCommand();
		if (src.equals("Them")) {
			mokhoa();
			jbt_them.setEnabled(false);
			jbt_sua.setEnabled(false);
			jbt_xoa.setEnabled(false);
			jbt_xemTT.setEnabled(false);
		} else if (src.equals("Luu")) {
			luu();
			jbt_them.setEnabled(true);
			jbt_sua.setEnabled(true);
			jbt_xoa.setEnabled(true);
			jbt_xemTT.setEnabled(true);
			xoarong();
		} else if (src.equals("Sua")) {
			sua();
		} else if (src.equals("Xoa")) {
			xoa();
//			jbt_them.setEnabled(false);
//			jbt_luu.setEnabled(false);
//			jbt_sua.setEnabled(false);
//			jbt_xemTT.setEnabled(false);			
			xoarong();
		}
	}

	public void xoarong() {
		jtext_malop.setText(" ");
		jtext_tenlop.setText(" ");
		jtext_gvcn.setText(" ");
	}

	public void luu() {
		if (!jtext_malop.getText().equals(" ")) {
			LopHoc lop = new LopHoc(jtext_malop.getText(), jtext_tenlop.getText(), jtext_gvcn.getText());
			lop_Dao.addLop(lop);
			JOptionPane.showMessageDialog(this, "Thêm thành công");
			Object[] rowData = { lop.getMalop(), lop.getTenlop(), lop.getGiaovienCN() };
			model.addRow(rowData);
		} else {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin để lưu học viên");

		}

	}

	public void xoa() {
		int hang = table.getSelectedRow();
		if (hang != -1) {
			String ma = (String) table.getValueAt(hang, 0);
			lop_Dao.deleteLop(ma);
			model.removeRow(hang);
		} else {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập chọn một dòng để xóa");

		}
	}

	public void sua() {

		int hang = table.getSelectedRow();
		LopHoc lop = new LopHoc(jtext_malop.getText(), jtext_tenlop.getText(), jtext_gvcn.getText());
		if (hang != -1) {
			jtext_malop.setEditable(false);
			jtext_tenlop.setEnabled(true);
			jtext_gvcn.setEnabled(true);
			lop_Dao.UpdateLop(lop);
			for (int i = 0; i < table.getRowCount(); i++) {
				String id = table.getValueAt(i, 0) + "";
				if (id.equals(jtext_malop.getText())) {
					JOptionPane.showConfirmDialog(this, "Cập nhật thành công!", "Thông báo", JOptionPane.OK_OPTION);
					table.setValueAt(lop.getMalop() + "", i, 0);
					table.setValueAt(lop.getTenlop() + "", i, 1);
					table.setValueAt(lop.getGiaovienCN() + "", i, 2);
				}
			}
		} else {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập chọn một dòng để sửa");

		}
	}
}
