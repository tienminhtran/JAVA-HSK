package Sinhs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class Gui extends JFrame implements ActionListener, MouseListener {
	private DsCountry dsCtry;
	private Database data;
	private JLabel jLabel_coutry, jLabel_cap, jLabel_pop, jLabel_democr;
	private JButton jbt_them, jbt_xoaTr, jbt_xoa, jbt_sua, jbt_thoat;
	private JTextField jtext_coutry, jtext_cap, jtext_pop;
	private JCheckBox jCheckBox;
	private JComboBox comboBox;
	private JTable table_ctr;
	private DefaultTableModel model_ctr;

	public Gui() {
		dsCtry = new DsCountry();
		data = new Database();
		setTitle("Using JTable Component & IO Stream");
		setSize(900, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		showIt();
		try {
			loadData();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void showIt() {
		// Cac component

		jLabel_coutry = new JLabel("Enter country: ");
		jLabel_cap = new JLabel("Enter Captital: ");
		jLabel_pop = new JLabel("Enter Population: ");
		jLabel_democr = new JLabel("Enter democracy: ");

		jtext_coutry = new JTextField();
		jtext_cap = new JTextField();
		jtext_pop = new JTextField();

		jbt_them = new JButton("Add");
		jbt_xoaTr = new JButton("Clear");
		jbt_xoa = new JButton("Delete");
		jbt_sua = new JButton("Update");
		jbt_thoat = new JButton("Exit");

		comboBox = new JComboBox();
		comboBox.addItem("true");
		comboBox.addItem("false");

		jCheckBox = new JCheckBox();
		// khu vực bắc
		JPanel jPanel_north = new JPanel();

		JLabel north_tieude = new JLabel("Using JTable Component");
		north_tieude.setFont(new Font("Arial", Font.BOLD, 24));
		north_tieude.setForeground(Color.blue);

		jPanel_north.add(north_tieude, BorderLayout.CENTER);

		// khu vực center
		JPanel jPanel_center = new JPanel();
		jPanel_center.setLayout(new BoxLayout(jPanel_center, BoxLayout.Y_AXIS));

		Box b_main, b1, b2, b3, b4;
		b_main = Box.createVerticalBox();
		b_main.add(b1 = Box.createHorizontalBox());
		b_main.add(Box.createVerticalStrut(15));
		b_main.add(b2 = Box.createHorizontalBox());
		b_main.add(Box.createVerticalStrut(15));
		b_main.add(b3 = Box.createHorizontalBox());
		b_main.add(Box.createVerticalStrut(15));
		b_main.add(b4 = Box.createHorizontalBox());
		b_main.add(Box.createVerticalStrut(15));

		// add them vao box
		b1.add(jLabel_coutry);
		b1.add(jtext_coutry);
		jLabel_coutry.setPreferredSize(jLabel_democr.getPreferredSize());

		b2.add(jLabel_cap);
		b2.add(jtext_cap);
		jLabel_cap.setPreferredSize(jLabel_democr.getPreferredSize());

		b3.add(jLabel_pop);
		b3.add(jtext_pop);
		jLabel_pop.setPreferredSize(jLabel_democr.getPreferredSize());

		b4.add(jLabel_democr);
		b4.add(comboBox);

		// tao table
		String[] collum = { "Country", "Captital", "Population", "Democracy" };
		model_ctr = new DefaultTableModel(collum, 0);
		table_ctr = new JTable(model_ctr);
		JScrollPane scoll = new JScrollPane(table_ctr, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scoll.setBorder(new TitledBorder(""));
		table_ctr.setDefaultEditor(Object.class, null);

		jPanel_center.add(b_main);
		jPanel_center.add(scoll);

		// khu vực south
		JPanel jPanel_south = new JPanel();

		Box b_jbt = Box.createHorizontalBox();
		b_jbt.add(jbt_them);
		b_jbt.add(Box.createHorizontalStrut(15));
		b_jbt.add(jbt_xoaTr);
		b_jbt.add(Box.createHorizontalStrut(15));
		b_jbt.add(jbt_sua);
		b_jbt.add(Box.createHorizontalStrut(15));
		b_jbt.add(jbt_xoa);
		b_jbt.add(Box.createHorizontalStrut(15));
		b_jbt.add(jbt_thoat);
		jPanel_south.add(b_jbt, BorderLayout.CENTER);

		add(jPanel_north, BorderLayout.NORTH);
		add(jPanel_center, BorderLayout.CENTER);
		add(jPanel_south, BorderLayout.SOUTH);

		jbt_them.addActionListener(this);
		jbt_xoa.addActionListener(this);
		jbt_xoaTr.addActionListener(this);
		jbt_sua.addActionListener(this);
		jbt_thoat.addActionListener(this);
		comboBox.addActionListener(this);
		
		table_ctr.addMouseListener(this);
	}

	/**
	 * Kiểm tra ký tự
	 */

	public boolean isDigit(String digit) {
		for (int i = 0; i < digit.length(); i++) {
			char c = digit.charAt(i);
			if (!Character.isLetter(c) && c != ' ') {
				return false;
			}
		}
		return true;
	}

	public boolean valiDate() {
		String counttry = jtext_coutry.getText();
		String cap = jtext_cap.getText();
		String pop = jtext_pop.getText();

		if (counttry.trim().equals("") || cap.trim().equals("") || pop.trim().equals("")) {
			JOptionPane.showMessageDialog(this, "Ô nhập dữ liệu còn trống");
			return false;
		}

		if (!isDigit(counttry)) {
			JOptionPane.showMessageDialog(this, "Coutry không chứa ký số hoặc các ký tự đặc biệt khác");
			jtext_coutry.setText("");
			jtext_coutry.requestFocus();
			return false;
		}
		if (!isDigit(cap)) {
			JOptionPane.showMessageDialog(this, "Capital không chứa ký số hoặc các ký tự đặc biệt khác");
			jtext_cap.setText("");
			jtext_cap.requestFocus();
			return false;
		}
		if (!isDigit(pop)) {
			JOptionPane.showMessageDialog(this, "Population không chứa ký số hoặc các ký tự đặc biệt khác");
			jtext_pop.setText("");
			jtext_pop.requestFocus();
			return false;
		}
		return true;
	}

	public void them() throws Exception {
		String counttry = jtext_coutry.getText();
		String cap = jtext_cap.getText();
		String pop = jtext_pop.getText();
		boolean demo;
		if (comboBox.getSelectedItem().equals("true")) {
			demo = true;
		} else {
			demo = false;
		}

		Country ctr = new Country(counttry, cap, pop, demo);
		
			if (dsCtry.themCtr(ctr)) {
				if (valiDate()) {
				Object[] obj = new Object[4];
				obj[0] = counttry;
				obj[1] = cap;
				obj[2] = pop;
				if (demo) {
					jCheckBox.setSelected(true);
					obj[3] = jCheckBox.isSelected();
				} else {
					jCheckBox.setSelected(false);
					obj[3] = jCheckBox.isSelected();
				}
				model_ctr.addRow(obj);
				JOptionPane.showMessageDialog(this, "Thêm thành công");
				data.saveFile("Country.dat", dsCtry);

			} else {
				JOptionPane.showMessageDialog(this, "Id này tồn tại");
				jtext_coutry.setText("");
			}
		}

	}

	public void xoa() throws Exception {
		int row = table_ctr.getSelectedRow();		
		if (row == -1) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần xóa");
		} else {
			if (JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa dòng đã chọn hay không?", "Cảnh báo",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				dsCtry.xoa(row);
				model_ctr.removeRow(row);
				xoaRong();
				data.saveFile("Country.dat", dsCtry);
			}
		}
	}

	public void sua() throws Exception {
		
		int row = table_ctr.getSelectedRow();
		if(row != -1) {
			String counttry = jtext_coutry.getText();
			String cap = jtext_cap.getText();
			String pop = jtext_pop.getText();
			boolean demo;
			if (comboBox.getSelectedItem().equals("true")) {
				demo = true;
			} else {
				demo = false;
			}
			Country crt = new Country(counttry, cap, pop, demo);
			dsCtry.sua(crt);
			
			for (int i = 0; i < table_ctr.getRowCount(); i++) {
				String idString = table_ctr.getValueAt(i, 0).toString();
				if(idString.equals(crt.getCountry())) {
					if(valiDate()) {
						table_ctr.setValueAt(crt.getCaptital(), i, 1);
						table_ctr.setValueAt(crt.getPopulation(), i, 2);
						if(crt.isDemocracy()) {
							jCheckBox.setSelected(true);
							table_ctr.setValueAt(jCheckBox.isSelected(), i, 3);
						} else {
							jCheckBox.setSelected(false);
							table_ctr.setValueAt(jCheckBox.isSelected(), i, 3);
						}
						data.saveFile("Country.dat", dsCtry);
					}
				}
			}
		}
		
		
		
	}
	
	
	public void xoaRong() {
		jtext_coutry.setText("");
		jtext_cap.setText("");
		jtext_pop.setText("");
		comboBox.setSelectedItem("false");
	}
	public void loadData() throws Exception {
		dsCtry = null;
		dsCtry = (DsCountry) data.readFile("Country.dat");
		if (dsCtry == null) {
			dsCtry = new DsCountry();
		} else {
			for (Country ctr : dsCtry.getDsCtry()) {
				String[] collum = { ctr.getCountry(), ctr.getCaptital(), ctr.getPopulation(), ctr.isDemocracy() + "" };
				model_ctr.addRow(collum);
			}
		}
	}

	public static void main(String[] args) {
		new Gui().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object scr = e.getSource();
		if (scr.equals(jbt_them)) {
			try {
				them();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} else if (scr.equals(jbt_xoa)) {
			try {
				xoa();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} else if (scr.equals(jbt_sua)) {
			try {
				sua();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}else if (scr.equals(jbt_xoaTr)) {
			xoaRong();
		}else if (scr.equals(jbt_thoat)) {
			System.exit(0);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table_ctr.getSelectedRow();
		jtext_coutry.setText(table_ctr.getValueAt(row, 0).toString());
		jtext_cap.setText(table_ctr.getValueAt(row, 1).toString());
		jtext_pop.setText(table_ctr.getValueAt(row, 2).toString());
		comboBox.setSelectedItem(table_ctr.getValueAt(row, 3).toString());
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
