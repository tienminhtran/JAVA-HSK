package Thong;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

public class ThongTinNhanVienGUI extends JFrame implements ActionListener {
	private JTextField txtma, txtho, txtten, txttuoi, txtluong, txttim;
	private JLabel title, lma, lho, lten, ltuoi, lluong, ltim, lphai;
	private JRadioButton rnam, rnu;
	private JButton btim, bthem, bxoatrang, bxoa, bluu;
	private DefaultTableModel model;
	private JTable table_nv;
	private DsNhanVien dsNV;
	private Database data;

	public ThongTinNhanVienGUI() {
		dsNV = new DsNhanVien();
		data = new Database();
		setTitle("Thông tin nhân viên");
		setSize(1000, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		GUI();
		try {
			loadData();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
	}

	public void GUI() {
		JPanel pnBorder = new JPanel(new BorderLayout(10, 10));
		// tao north
		JPanel pn = new JPanel();
		title = new JLabel("THÔNG TIN NHÂN VIÊN");
		title.setFont(new Font("Times New Roman", Font.BOLD, 30));
		title.setForeground(Color.BLUE);
		pn.add(title);
		pnBorder.add(pn, BorderLayout.NORTH);
		this.add(pnBorder);
		// tao center
		JPanel pc = new JPanel();
		pc.setLayout(null);

		Font f = new Font("Times New Roman", Font.BOLD, 14);
		int x = 10, y = 0, wight = 100, height = 30;
		lma = new JLabel("Mã nhân viên: ");
		lma.setFont(f);
		lma.setBounds(x, y, wight, height);
		pc.add(lma);

		lho = new JLabel("Họ:");
		y += 40;
		lho.setBounds(x, y, wight, height);
		lho.setFont(f);
		pc.add(lho);

		y += 40;
		ltuoi = new JLabel("Tuổi:");
		ltuoi.setBounds(x, y, wight, height);
		ltuoi.setFont(f);
		pc.add(ltuoi);

		y += 40;
		lluong = new JLabel("Tiền lương:");
		lluong.setBounds(x, y, wight, height);
		lluong.setFont(f);
		pc.add(lluong);

		x = 110;
		y = 0;
		wight = 870;
		txtma = new JTextField(600);
		txtma.setBounds(x, y, wight, height);
		pc.add(txtma);

		y += 40;
		txtho = new JTextField(50);
		txtho.setBounds(x, y, 400, height);
		pc.add(txtho);

		x += 410;
		lten = new JLabel("Tên nhân viên:");
		lten.setBounds(x, y, 200, height);
		lten.setFont(f);
		pc.add(lten);

		x += 100;
		txtten = new JTextField(40);
		txtten.setBounds(x, y, 360, height);
		pc.add(txtten);

		x = 110;
		y += 40;
		txttuoi = new JTextField(40);
		txttuoi.setBounds(x, y, 600, height);
		pc.add(txttuoi);

		x += 610;
		lphai = new JLabel("Phái:");
		lphai.setFont(f);
		lphai.setBounds(x, y, 100, height);
		pc.add(lphai);

		x += 70;
		ButtonGroup group = new ButtonGroup();
		rnam = new JRadioButton("Nam");
		rnu = new JRadioButton("Nữ");
		rnam.setFont(f);
		rnu.setFont(f);
		rnam.setBounds(x, y, 70, height);
		x += 90;
		rnu.setBounds(x, y, 100, height);

		group.add(rnam);
		group.add(rnu);
		pc.add(rnam);
		pc.add(rnu);

		x = 110;
		y += 40;
		txtluong = new JTextField(100);
		txtluong.setBounds(x, y, wight, height);
		pc.add(txtluong);

		x = 0;
		y += 60;
		model = new DefaultTableModel();
		model.addColumn("Mã NV");
		model.addColumn("Họ");
		model.addColumn("Tên");
		model.addColumn("Phái");
		model.addColumn("Tuổi");
		model.addColumn("Tiền lương");
		table_nv = new JTable(model);
		TableColumn phaiColumn = table_nv.getColumnModel().getColumn(3);
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("Nam");
		comboBox.addItem("Nữ");
		phaiColumn.setCellEditor(new DefaultCellEditor(comboBox));
		JScrollPane sp = new JScrollPane(table_nv, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sp.setBounds(x, y, 1000, 800);
		pc.add(sp);
		pnBorder.add(pc, BorderLayout.CENTER);
		// tao vung south
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		splitPane.setResizeWeight(0.5);
		JPanel pstim = new JPanel();
		ltim = new JLabel("Nhập mã số cần tìm:");
		txttim = new JTextField(15);
		btim = new JButton("Tìm");
		pstim.add(ltim);
		pstim.add(txttim);
		pstim.add(btim);
		splitPane.add(pstim);

		JPanel psbutton = new JPanel();
		bthem = new JButton("Thêm");
		bxoa = new JButton("Xóa");
		bxoatrang = new JButton("Xóa trắng");
		bluu = new JButton("Lưu");
		psbutton.add(bthem);
		psbutton.add(bxoatrang);
		psbutton.add(bxoa);
		psbutton.add(bluu);
		splitPane.add(psbutton);
		pnBorder.add(splitPane, BorderLayout.SOUTH);
		btim.addActionListener(this);
		bthem.addActionListener(this);
		bxoatrang.addActionListener(this);
		bxoa.addActionListener(this);
		bluu.addActionListener(this);
		table_nv.addMouseListener(new MouseListener() {

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
				int row = table_nv.getSelectedRow();
				txtma.setText(model.getValueAt(row, 0).toString());
				txtho.setText(model.getValueAt(row, 1).toString());
				txtten.setText(model.getValueAt(row, 2) + "");
				txttuoi.setText(model.getValueAt(row, 4) + "");
				txtluong.setText(model.getValueAt(row, 5) + "");
				if (model.getValueAt(row, 3).toString().equalsIgnoreCase("Nam")) {
					rnam.setSelected(true);
					rnu.setSelected(false);
				} else {
					rnam.setSelected(false);
					rnu.setSelected(true);
				}
			}
		});
	}

	public void luunv() throws Exception {
		String ma = txtma.getText();
		String ho = txtho.getText();
		String ten = txtten.getText();
		int tuoi = Integer.parseInt(txttuoi.getText());
		double luong = Double.parseDouble(txtluong.getText());
		// gioi tinh
		String gioitinh = "";
		if (rnam.isSelected())
			gioitinh = rnam.getText();
		else if (rnu.isSelected())
			gioitinh = rnu.getText();
		NhanVien nv = new NhanVien(ma, ho, ten, tuoi, luong, gioitinh);
		if (dsNV.them(nv)){
			Object[] obj = new Object[6];
			obj[0] = ma;
			obj[1] = ho;
			obj[2] = ten;
			obj[3] = gioitinh;
			obj[4] = Integer.toString(tuoi);
			obj[5] = Double.toString(luong);
//			JOptionPane.showMessageDialog(this, "Thêm thành công");
//			String[] str = { ma, ho, ten, gioitinh, tuoi + "", luong + "" };
			model.addRow(obj);
			data.saveFile("Nhanvien.dat", dsNV);
		} else {
			JOptionPane.showMessageDialog(this, "ID này tồn tại");
			txtma.setText("");
		}
	}

	public void xoanv() throws Exception {
		int row = table_nv.getSelectedRow();
		if (row == -1) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần xóa");
		} else {
			if (JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa dòng này hay không", "Cảnh báo",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				dsNV.xoa(row);
				model.removeRow(row);
				xoaTrang();
				data.saveFile("Nhanvien.dat", dsNV);
			}
		}
	}

	public void loadData() throws Exception {
		dsNV = null;
		// sai tên thiếu n trong "nhan"		
//		if (model == null) {
//		    model = new DefaultTableModel();
//		}
		dsNV = (DsNhanVien) data.readFile("Nhanvien.dat");

		 if (dsNV == null) {
			dsNV = new DsNhanVien();
		} else {
			for (NhanVien nv : dsNV.getDs()) {
				String[] str = { nv.getMaNV(), nv.getHo(), nv.getTen(), nv.getPhai(), nv.getTuoi() + "",
						nv.getLuong() + "" };
				model.addRow(str);
				
			}
		}
	}

	public void xoaTrang() {
		txtho.setText("");
		txtten.setText("");
		txtma.setText("");
		txttuoi.setText("");
		rnam.setSelected(false);
		rnu.setSelected(false);
		txtluong.setText("");
	}

	public static void main(String[] args) {
		new ThongTinNhanVienGUI().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bthem) {
			if (bthem.getText().equals("Thêm")) {
				bxoa.setEnabled(false);
				bthem.setText("Hủy");
			} else {
				bxoa.setEnabled(true);
				bthem.setText("Thêm");
			}
		} else if (e.getSource() == bluu) {
			if (txtma.getText().trim().equals("") || txtho.getText().trim().equals("")
					|| txtten.getText().trim().equals("") || txttuoi.getText().trim().equals("")
					|| txtluong.getText().trim().equals("")) {
				JOptionPane.showConfirmDialog(this, "Vui lòng nhập thông tin");
			} else {
				try {
					luunv();
				} catch (Exception ea) {
					ea.printStackTrace();
				}
				xoaTrang();
				txtma.requestFocus();
				bxoa.setEnabled(true);
				bthem.setText("Thêm");
			}
		} else if (e.getSource() == bxoa) {
			try {
				xoanv();
			} catch (Exception ea) {
				ea.printStackTrace();
			}
		} else if (e.getSource() == bxoatrang) {
			xoaTrang();
		} else if (e.getSource() == btim) {
			if (txttim.getText().trim().equals("")) {
				JOptionPane.showConfirmDialog(this, "Vui lòng nhập mã nhân viên cần tìm");
			} else {
				String maNV = txttim.getText();
				NhanVien nv = dsNV.tim(maNV);
				if (nv == null) {
					JOptionPane.showConfirmDialog(this, "Không tìm thấy nhân viên");
				} else {
					txtma.setText(nv.getMaNV());
					txtho.setText(nv.getHo());
					txtten.setText(nv.getTen());
					txttuoi.setText(nv.getTuoi() + "");
					txtluong.setText(nv.getLuong() + "");
					if (nv.getPhai().equalsIgnoreCase("Nam")) {
						rnam.setSelected(true);
						rnu.setSelected(false);
					} else {
						rnam.setSelected(false);
						rnu.setSelected(true);
					}
				}
			}
		}
	}
}
