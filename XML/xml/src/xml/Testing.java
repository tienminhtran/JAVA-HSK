package xml;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class Testing extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private DefaultTableModel tableModel;
	private JTable table;
	private JButton btnadd, btndelete, btnupdate, btnsave, btnfilter;
	private ManageProduct list = new ManageProduct();

	private Testing() {
		// TODO Auto-generated method stub
		setSize(900, 570);
		setTitle("DOM XML");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setResizable(false);

		String[] header = { "ProductId", "Name", "Manufacture", "Description", "Sname", "Country", "Web", "Price" };
		tableModel = new DefaultTableModel(header, 0);
		table = new JTable(tableModel);
		JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		loaddata();
		JPanel panel = new JPanel();
		btndelete = new JButton("Delete");
		btnsave = new JButton("Save");
		btnadd = new JButton("Add");
		btnupdate = new JButton("Update");
		btnfilter = new JButton("Filter");
		panel.add(btnadd);
		panel.add(btndelete);
		panel.add(btnupdate);
		panel.add(btnsave);
		panel.add(btnfilter);

		scrollPane.setBounds(10, 10, 870, 480);
		panel.setBounds(10, 490, 880, 70);

		add(scrollPane);
		add(panel);

		btnadd.addActionListener(this);
		btndelete.addActionListener(this);
		btnfilter.addActionListener(this);
		btnsave.addActionListener(this);
		btnupdate.addActionListener(this);
	}

	private void loaddata() {
		// TODO Auto-generated method stub
		while (table.getRowCount() != 0) {
			tableModel.removeRow(0);
		}
		ArrayList<Product> dom = list.getAllProducts();
		for (Product p : dom) {
			String[] rowS = { p.getProductID(), p.getName(), p.getManufacture(), p.getDescription(),
					p.getSupplier().getName(), p.getSupplier().getCountry(),
					p.getSupplier().getWebsite(), String.valueOf(p.getPrice()) };

			tableModel.addRow(rowS);

		}
	}

	public static void main(String[] args) {
		new Testing().setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnadd)) {
			themdulieu();
		}
		if (o.equals(btnsave)) {
			UpdateXML();
		}
		if (o.equals(btndelete)) {
			Xoa();
		}
		if (o.equals(btnupdate)) {
			Sua();
		}
	}

	public void themdulieu() {
		String id = JOptionPane.showInputDialog("Nhập vào mã sản phẩm");
		String name = JOptionPane.showInputDialog("Nhập vào tên sản phẩm");
		String hang = JOptionPane.showInputDialog("Nhập vào Hãng Sản Xuất");
		String mota = JOptionPane.showInputDialog("Nhập mô tả sản phẩm");
		String daily = JOptionPane.showInputDialog("Nhập vào tên đại lý");
		String quocgia = JOptionPane.showInputDialog("Nhập vào tên quốc gia");
		String web = JOptionPane.showInputDialog("Nhập vào tên website đại lý");
		String gia = JOptionPane.showInputDialog("Nhập vào giá sản phẩm");

		int gia2 = Integer.parseInt(gia);
		if (id.isEmpty() || name.isEmpty() || hang.isEmpty() || mota.isEmpty() || daily.isEmpty()
				|| quocgia.isEmpty() || web.isEmpty() || gia.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Bạn chưa nhập đủ thông tin");
		}
		Supplier supp = new Supplier(daily, quocgia, web);
		Product prod = new Product(id, name, hang, mota, supp, gia2);
		list.addProduct(prod);
		JOptionPane.showMessageDialog(this, "Thêm thành công");
		loaddata();
	}

	public void UpdateXML() {
		list.writeXMLFile();
		JOptionPane.showMessageDialog(this, "Cập nhật XML thành công");
	}

	public void Xoa() {
		int row = table.getSelectedRow();
		if (row != -1) {
			String productId = (String) table.getValueAt(row, 0);
			list.deleteProduct(productId);
			loaddata();
		}
	}

	private void Sua() {
		// TODO Auto-generated method stub
		String productId = JOptionPane.showInputDialog("Nhập mã sp : ");
		Double giamoi = Double.parseDouble(JOptionPane.showInputDialog("Nhập giá mới : "));
		if (rootPaneCheckingEnabled) {

		}

		list.updatePrice(productId, giamoi);
		loaddata();
	}

}
