package HOMEEX;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultCellEditor;
import javax.swing.Icon;
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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

public class GUI extends JFrame implements ActionListener, MouseListener {

	private DanhSachQuocGia danhSachQuocGia;
	private Databasee databasee;
	private JTextField jTextField_country;
	private JTextField jTextField_captital;
	private JTextField jTextField_population;
	private JComboBox jComboBox_dem;
	private JButton jButton_add;
	private JButton jButton_clear;
	private JButton jButton_update;
	private JButton jButton_delete;
	private JButton jButton_search;
	private DefaultTableModel tableModel;
	private JTable jTable;
	private JCheckBox jCheckBox_dem;
	private JButton jButton_huytim;

	public GUI() {
		danhSachQuocGia = new DanhSachQuocGia();
		databasee = new Databasee();
		this.setTitle("Bài về quốc gia");
		this.setSize(800, 500);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.init();
		try {
			loadData();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		this.setVisible(true);
	}

	private void init() {
		JPanel jPanel_top = new JPanel();
		JLabel jLabel_title = new JLabel("USING JTAABLE COMPONENT");
		jPanel_top.add(jLabel_title);
		this.add(jPanel_top, BorderLayout.NORTH);

		JPanel jPanel_center = new JPanel();
		JPanel jPanel_center_combobox = new JPanel();
		BoxLayout boxLayout = new BoxLayout(jPanel_center_combobox, BoxLayout.Y_AXIS);

		Box b, b1, b2, b3, b4;

		b = Box.createVerticalBox();
		b1 = Box.createHorizontalBox();
		b2 = Box.createHorizontalBox();
		b3 = Box.createHorizontalBox();
		b4 = Box.createHorizontalBox();

		JLabel jLabel_country = new JLabel("Enter country");
		JLabel jLabel_r = new JLabel("                                                                         ");
		JLabel jLabel_r1 = new JLabel("                                                                         ");

		JLabel jLabel_captital = new JLabel("Enter captital");
		JLabel jLabel_population = new JLabel("Enter population");
		JLabel jLabel_select_democracy = new JLabel("Select democracy");

		jTextField_country = new JTextField();
		jTextField_captital = new JTextField(50);
		jTextField_population = new JTextField();
//					String[] dem = {"True", "False"};

		b.add(b1);
		b.add(b2);
		b.add(b3);
		b.add(b4);

		b1.add(jLabel_country);
		jLabel_country.setPreferredSize(jLabel_select_democracy.getPreferredSize());
		b1.add(jTextField_country);
		b1.add(jLabel_r);

		b2.add(jLabel_captital);
		jLabel_captital.setPreferredSize(jLabel_select_democracy.getPreferredSize());
		b2.add(jTextField_captital);

		b3.add(jLabel_population);
		jLabel_population.setPreferredSize(jLabel_select_democracy.getPreferredSize());
		b3.add(jTextField_population);

		b4.add(jLabel_select_democracy);
		b4.add(jComboBox_dem);
		b4.add(jLabel_r1);

		jPanel_center_combobox.add(b);
		jPanel_center.add(jPanel_center_combobox, BorderLayout.NORTH);
		JPanel jPanel_center_table = new JPanel();

		tableModel = new DefaultTableModel();
		tableModel.addColumn("Country");
		tableModel.addColumn("Captital");
		tableModel.addColumn("Population");
		tableModel.addColumn("Democracy");
		jTable = new JTable(tableModel);		jComboBox_dem = new JComboBox();
		jComboBox_dem.addItem("true");
		jComboBox_dem.addItem("false");
		jCheckBox_dem = new JCheckBox();
		TableColumn tableColumn_dem = jTable.getColumnModel().getColumn(3);
		tableColumn_dem.setCellEditor(new DefaultCellEditor(jCheckBox_dem));
//		 jComboBox_dem = new JComboBox<>(dem);

//      jTable.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(jCheckBox_dem));

		Dimension size = new Dimension(780, 250);
		jTable.setPreferredScrollableViewportSize(size);
		JScrollPane jScrollPane = new JScrollPane(jTable);
		jPanel_center_table.add(jScrollPane);
		jPanel_center.add(jPanel_center_table);
		this.add(jPanel_center, BorderLayout.CENTER);

		JPanel jPanel_btn = new JPanel();
		jButton_add = new JButton("Add");
		jButton_clear = new JButton("Clear");
		jButton_update = new JButton("Update");
		jButton_delete = new JButton("Delete");
		jButton_search = new JButton("Search");
		jButton_huytim = new JButton("Hủy tìm");

		jPanel_btn.add(jButton_add);
		jPanel_btn.add(jButton_clear);
		jPanel_btn.add(jButton_update);
		jPanel_btn.add(jButton_delete);
		jPanel_btn.add(jButton_search);
		this.add(jPanel_btn, BorderLayout.SOUTH);

		// su75 kiebnn
		jButton_add.addActionListener(this);
		jButton_clear.addActionListener(this);
		jButton_update.addActionListener(this);
		jButton_delete.addActionListener(this);
		jButton_search.addActionListener(this);
		jButton_huytim.addActionListener(this);
		jTable.addMouseListener(this);
	}

	public static void main(String[] args) {
		new GUI();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String src = e.getActionCommand();
		if (src.equals("Add")) {
			them();
			databasee.savefile("DSQG.dat", danhSachQuocGia);
		} else if (src.equals("Clear")) {
			clear();
		} else if (src.equals("Delete")) {
			xoa();
			clear();
			databasee.savefile("DSQG.dat", danhSachQuocGia);
		} else if (src.equals("Update")) {
			capnhat();

		} else if (src.equals("Search")) {
			tim();
		} else if (src.equals("Hủy tìm")) {
			try {
				huytim();
				jButton_search.setText("Search");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int hang = jTable.getSelectedRow();
		if (hang != -1) {
			jTextField_country.setText(jTable.getValueAt(hang, 0).toString());
			jTextField_captital.setText(jTable.getValueAt(hang, 1).toString());
			jTextField_population.setText(jTable.getValueAt(hang, 2).toString());
			jComboBox_dem.setSelectedItem(jTable.getValueAt(hang, 3).toString());
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

	public void them() {

		String country = jTextField_country.getText();
		String capital = jTextField_captital.getText();
		int opulation = Integer.parseInt(jTextField_population.getText());
		boolean democracy;
		if (jComboBox_dem.getSelectedItem().equals("true")) {
			democracy = true;
		} else {
			democracy = false;
		}
		QuocGia qd = new QuocGia(country, capital, opulation, democracy);

		Object obj[] = new Object[4];
		obj[0] = country;
		obj[1] = capital;
		obj[2] = Integer.toString(opulation);
		if (democracy) {
			jCheckBox_dem.setSelected(true);
			obj[3] = jCheckBox_dem.isSelected();
		} else {
			jCheckBox_dem.setSelected(false);
			obj[3] = jCheckBox_dem.isSelected();
		}
//		jComboBox_dem.setVisible(false);

		if (danhSachQuocGia.them(qd)) {
			tableModel.addRow(obj);
		}
	}

	public void clear() {
		jTextField_country.setText(" ");
		jTextField_captital.setText(" ");
		jTextField_population.setText(" ");
		jCheckBox_dem.setSelected(true);

	}

	public void xoa() {
		int hang = jTable.getSelectedRow();
		if (hang != -1) {
			danhSachQuocGia.xoavitri(hang);
			tableModel.removeRow(hang);
		}
	}

	public void capnhat() {
		int hang = jTable.getSelectedRow();
		if (hang != -1) {

			String country = jTextField_country.getText();
			String capital = jTextField_captital.getText();
			int opulation = Integer.parseInt(jTextField_population.getText());
			boolean democracy;
			if (jComboBox_dem.getSelectedItem().equals("True")) {
				democracy = true;
			} else {
				democracy = false;
			}
			QuocGia qd = new QuocGia(country, capital, opulation, democracy);

			this.danhSachQuocGia.update(qd);
			for (int i = 0; i < jTable.getRowCount(); i++) {
				String id = jTable.getValueAt(i, 0) + "";
				if (id.equals(qd.getCountry())) {
//					jTable.setValueAt(qd.getCountry() , i, 0);
					jTable.setValueAt(qd.getCapital(), i, 1);
					jTable.setValueAt(qd.getOpulation(), i, 2);
					if (qd.isDemocracy()) {
						jCheckBox_dem.setSelected(true);
						jTable.setValueAt(jCheckBox_dem.isSelected(), i, 3);

					} else {
						jCheckBox_dem.setSelected(false);
						jTable.setValueAt(jCheckBox_dem.isSelected(), i, 3);
					}
				}

			}
			databasee.savefile("DSQG.dat", danhSachQuocGia);

		}
	}

	public void tim() {
		String mathanhpho = JOptionPane.showInputDialog("Nhập mã thành phố cần tìm: ");

		QuocGia qg = danhSachQuocGia.timKiem(mathanhpho);
		if (!mathanhpho.trim().equals("")) {
			if (qg != null) {
				tableModel.setRowCount(0);
				String hang[] = { qg.getCountry(), qg.getCapital(), qg.getOpulation() + "", qg.isDemocracy() + "" };
				tableModel.addRow(hang);
				jButton_huytim.setEnabled(false);
				jButton_search.setText("Hủy tìm");
				jTable.setRowSelectionInterval(0, 0);
				for (int i = 0; i < jTable.getRowCount(); i++) {
					mouseClicked(null);

				}
			} else {
				JOptionPane.showConfirmDialog(this, "Không tìm thấy");
			}
		} else {
			JOptionPane.showConfirmDialog(this, "Nhập mã tìm");
		}
	}

	public void huytim() throws Exception {
		tableModel.removeRow(0);
		loadData();
	}

	public void loadData() {
		danhSachQuocGia = null;
		danhSachQuocGia = (DanhSachQuocGia) databasee.readfile("DSQG.dat");
		if (danhSachQuocGia == null) {
			danhSachQuocGia = new DanhSachQuocGia();
		} else {
			for (QuocGia qg : danhSachQuocGia.getDsQuocGia()) {
				String hang[] = { qg.getCountry(), qg.getCapital(), qg.getOpulation() + "", qg.isDemocracy() + "" };
				tableModel.addRow(hang);
			}
		}
	}

}
