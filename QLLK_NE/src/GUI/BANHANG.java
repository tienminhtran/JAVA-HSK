package GUI;

import javax.swing.JPanel;

import java.awt.Canvas;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;
import dao.DonHangDao;
import dao.KhachHangDao;
import dao.NhanVienDao;
import dao.SanPhamDao;
import entity.DonHang;
import entity.KhachHang;
import entity.NhanVien;
import entity.SanPham;

import javax.swing.border.MatteBorder;
import java.awt.Component;
import java.awt.event.MouseAdapter;

public class BANHANG extends JPanel implements ItemListener{
	private JTable table2;
	private JTable table1;
	private DefaultTableModel tableModel;
	private JTextField textField_sl;
	private JTextField textField_otim;
	private JTextField textField_tienkhachdua;
	private JTextField textField_tienkhachtra;
	private JTextField textField_tenkh;
	private JTextField textField_ngaylap;
	private JTextField textField_sdt;
	private JTextField textField_diachi;
	private JTextField textField_tien;
	private SanPhamDao sanPhamDao;
	private ConnectDB connectDB;
	private DefaultTableModel tableModel2;
	private KhachHangDao kdao;
	private DefaultComboBoxModel modelCombox;
	private DefaultComboBoxModel modelcombox_nv;

	private JButton btnNewButton_thanhtoan;
	private JComboBox comboBox_ma;
	private NhanVienDao nvdao;
	private JComboBox comboBox_manv;
	private DonHangDao donHangDao ;
	/**
	 * Create the panel.
	 */
	public BANHANG() {
		kdao = new KhachHangDao();
		nvdao = new NhanVienDao();
		sanPhamDao = new SanPhamDao();
		connectDB = new ConnectDB();
		modelCombox = new DefaultComboBoxModel();
		modelcombox_nv = new DefaultComboBoxModel();
		 donHangDao = new DonHangDao();
		try {
			connectDB.connect();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		setBackground(new Color(0, 255, 255));
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setBackground(new Color(0, 255, 255));
		panel.setBounds(0, 0, 474, 556);
		add(panel);
		panel.setLayout(null);

		table1 = new JTable();
		table1.setModel(tableModel = new DefaultTableModel(new Object[][] {}, new String[] { "M\u00E3 SP",
				"T\u00EAn SP", "M\u00F4 t\u1EA3", "\u0110\u01A1n gi\u00E1", "Lo\u1EA1i SP" }));

		table1.setFont(new Font("Arial", Font.PLAIN, 14));
		table1.setBounds(0, 0, 1, 1);
		for (SanPham sp : sanPhamDao.getAll()) {
			Object[] rowData = { sp.getMaLK(), sp.getTenLK(), sp.getMoTaLK(), sp.getDonGia(), sp.getLoaiLK() };
			tableModel.addRow(rowData);
		}
		JScrollPane scrollPane = new JScrollPane(table1);
		scrollPane.setBounds(0, 46, 474, 350);
		panel.add(scrollPane);

		JButton btnNewButton_them = new JButton("Thêm HD");

		btnNewButton_them.setIcon(new ImageIcon("D:\\BAI_TAP_JAVA\\QLLK_NE\\src\\img\\add-icon.png"));
		btnNewButton_them.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_sl.getText().equals("")) {
					JOptionPane.showConfirmDialog(null, "Vui lòng nhập số lượng!!");
				}
				capnhapTable2();
				textField_tien.setText(tongtien1());

			}
		});
		btnNewButton_them.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_them.setBackground(Color.GREEN);
		btnNewButton_them.setBounds(319, 474, 135, 42);
		panel.add(btnNewButton_them);

		
		JButton btnNewButton_tim = new JButton("Tìm kiếm");
		btnNewButton_tim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tims();
			}
		});
		btnNewButton_tim.setIcon(new ImageIcon("D:\\BAI_TAP_JAVA\\QLLK_NE\\src\\img\\Search-icon.png"));
		btnNewButton_tim.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_tim.setBackground(new Color(255, 182, 193));
		btnNewButton_tim.setBounds(319, 421, 135, 42);
		panel.add(btnNewButton_tim);

		JLabel lblNewLabel = new JLabel("Tổng số lượng:");
		lblNewLabel.setBounds(24, 481, 120, 28);
		panel.add(lblNewLabel);

		textField_sl = new JTextField();
		textField_sl.setBounds(144, 480, 150, 29);
		panel.add(textField_sl);
		textField_sl.setColumns(10);

		JLabel lblTmKimSn = new JLabel("Tìm kiếm sản phẩm");
		lblTmKimSn.setBounds(24, 428, 120, 28);
		panel.add(lblTmKimSn);

		textField_otim = new JTextField();
		textField_otim.setColumns(10);
		textField_otim.setBounds(144, 427, 150, 29);
		panel.add(textField_otim);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(119, 255, 187));
		panel_2.setBounds(0, 0, 474, 47);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JLabel lbNhanVien_1_1 = new JLabel("DANH SÁCH SẢN PHẨM");
		lbNhanVien_1_1.setBounds(0, 0, 474, 47);
		panel_2.add(lbNhanVien_1_1);
		lbNhanVien_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbNhanVien_1_1.setForeground(new Color(255, 0, 0));
		lbNhanVien_1_1.setFont(new Font("Arial", Font.BOLD, 25));
		lbNhanVien_1_1.setBackground(new Color(4, 255, 130));

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_1.setBackground(Color.CYAN);
		panel_1.setBounds(479, 46, 474, 510);
		add(panel_1);

		btnNewButton_thanhtoan = new JButton("Thanh toán");
		btnNewButton_thanhtoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(textField_tien.getText().equals("")) 
				{
					JOptionPane.showMessageDialog(null, "Vui lòng thêm hóa đơn");
				}
				textField_tien.setText(tongtien());
				textField_tienkhachtra.setText(tienthua()+"");
				thanhtoan();
				
			}
		});
		btnNewButton_thanhtoan.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_thanhtoan.setBackground(new Color(40, 148, 255));
		btnNewButton_thanhtoan.setBounds(295, 435, 125, 42);
		panel_1.add(btnNewButton_thanhtoan);

		JButton btnNewButton_xoa = new JButton("Xóa");
		btnNewButton_xoa.setIcon(new ImageIcon("D:\\BAI_TAP_JAVA\\QLLK_NE\\src\\img\\delete-icon.png"));
		btnNewButton_xoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoa();
			}
		});

		btnNewButton_xoa.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_xoa.setBackground(new Color(255, 128, 128));
		btnNewButton_xoa.setBounds(295, 369, 125, 42);
		panel_1.add(btnNewButton_xoa);

		JLabel lblNewLabel_1 = new JLabel("Số tiền khách đưa:");
		lblNewLabel_1.setBounds(20, 409, 110, 28);
		panel_1.add(lblNewLabel_1);

		textField_tienkhachdua = new JTextField();
		textField_tienkhachdua.setColumns(10);
		textField_tienkhachdua.setBounds(127, 409, 147, 29);
		panel_1.add(textField_tienkhachdua);

		JLabel lblTmKimSn_1 = new JLabel("Số tiền trả khách:");
		lblTmKimSn_1.setBounds(20, 449, 110, 28);
		panel_1.add(lblTmKimSn_1);

		textField_tienkhachtra = new JTextField();
		textField_tienkhachtra.setEditable(false);
		textField_tienkhachtra.setColumns(10);
		textField_tienkhachtra.setBounds(127, 448, 147, 29);
		panel_1.add(textField_tienkhachtra);

		JLabel lblNewLabel_2 = new JLabel("Mã NV:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 96, 57, 32);
		panel_1.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("Mã KH:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(10, 11, 46, 32);
		panel_1.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_1_1 = new JLabel("Tên KH:");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_1.setBounds(10, 53, 57, 32);
		panel_1.add(lblNewLabel_2_1_1);

		textField_tenkh = new JTextField();
		textField_tenkh.setEditable(false);
		textField_tenkh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_tenkh.setColumns(10);
		textField_tenkh.setBounds(66, 53, 150, 33);
		panel_1.add(textField_tenkh);

		JLabel lblNewLabel_2_2 = new JLabel("Ngày lập:");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_2.setBounds(226, 10, 59, 32);
		panel_1.add(lblNewLabel_2_2);

		textField_ngaylap = new JTextField();
		textField_ngaylap.setEditable(false);
		textField_ngaylap.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_ngaylap.setColumns(10);
		textField_ngaylap.setBounds(295, 10, 150, 33);
		panel_1.add(textField_ngaylap);

		JLabel lblNewLabel_2_1_2 = new JLabel("SĐT:");
		lblNewLabel_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_2.setBounds(226, 53, 59, 32);
		panel_1.add(lblNewLabel_2_1_2);

		textField_sdt = new JTextField();
		textField_sdt.setEditable(false);
		textField_sdt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_sdt.setColumns(10);
		textField_sdt.setBounds(295, 53, 150, 33);
		panel_1.add(textField_sdt);

		JLabel lblNewLabel_2_1_1_1 = new JLabel("Địa chỉ:");
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_1_1.setBounds(226, 96, 70, 32);
		panel_1.add(lblNewLabel_2_1_1_1);

		textField_diachi = new JTextField();
		textField_diachi.setEditable(false);
		textField_diachi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_diachi.setColumns(10);
		textField_diachi.setBounds(295, 96, 150, 33);
		panel_1.add(textField_diachi);

		table2 = new JTable();
		table2.setModel(tableModel2 = new DefaultTableModel(new Object[][] {},
				new String[] { "M\u00E3 SP", "T\u00EAn SP", "S\u1ED1 l\u01B0\u1EE3ng", "T\u1ED5ng ti\u1EC1n" }));

		table2.setFont(new Font("Arial", Font.PLAIN, 12));
		table2.setBounds(0, 0, 1, 1);
		JScrollPane scrollPane_1 = new JScrollPane(table2);
		scrollPane_1.setBounds(10, 140, 435, 210);
		panel_1.add(scrollPane_1);

		JLabel lblTmKimSn_1_1 = new JLabel("Tổng tiền:");
		lblTmKimSn_1_1.setBounds(20, 370, 110, 28);
		panel_1.add(lblTmKimSn_1_1);

		textField_tien = new JTextField();
		textField_tien.setEditable(false);
		textField_tien.setColumns(10);
		textField_tien.setBounds(127, 369, 147, 29);
		panel_1.add(textField_tien);

		comboBox_ma = new JComboBox();
		
		
		comboBox_ma.setEditable(true);
		comboBox_ma.setBounds(66, 10, 150, 33);
		panel_1.add(comboBox_ma);
		
		comboBox_manv = new JComboBox();
		comboBox_manv.setEditable(true);
		comboBox_manv.setBounds(66, 96, 150, 33);
		panel_1.add(comboBox_manv);

		JPanel panelNhanVien_1 = new JPanel();
		panelNhanVien_1.setLayout(null);
		panelNhanVien_1.setBackground(new Color(0, 225, 113));
		panelNhanVien_1.setBounds(479, 0, 474, 47);
		add(panelNhanVien_1);

		JLabel lbNhanVien_1 = new JLabel("HÓA ĐƠN ĐẶT HÀNG");

		lbNhanVien_1.setBackground(new Color(4, 255, 130));
		lbNhanVien_1.setBounds(0, 0, 466, 47);
		panelNhanVien_1.add(lbNhanVien_1);
		lbNhanVien_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbNhanVien_1.setForeground(new Color(255, 255, 255));
		lbNhanVien_1.setFont(new Font("Arial", Font.BOLD, 25));

		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField_sdt.setText("");
				textField_tenkh.setText("");
				textField_diachi.setText("");
			}
		});
		btnNewButton_3.setForeground(new Color(0, 255, 128));
		btnNewButton_3.setBackground(new Color(0, 255, 127));
		btnNewButton_3.setIcon(new ImageIcon("D:\\BAI_TAP_JAVA\\QLLK_NE\\src\\img\\Refresh-icon.png"));
		btnNewButton_3.setBounds(400, 0, 46, 45);
		panelNhanVien_1.add(btnNewButton_3);

		comboBox_ma.addItemListener(this);
		////thu di m
		napdulieu();
		napdulieu2();
		///

		
	}
	
	
	public void tims() {
		String malk = textField_otim.getText();
		int index = 0;
		if (!malk.trim().equals("")) {
			for (int i = 0; i < table1.getRowCount(); i++) {
				if (table1.getValueAt(i, 0).toString().equalsIgnoreCase(malk) || table1.getValueAt(i, 4).toString().equalsIgnoreCase(malk)) {
					index = 1;
					table1.getSelectionModel().setSelectionInterval(i, i);

				}
			}
			if (index == 0) {
				JOptionPane.showConfirmDialog(this, "Không tìm thấy");
				textField_otim.setText("");
			}
		} else {
			JOptionPane.showConfirmDialog(this, "Nhập dữ liệu để tìm");
		}
	}

	public String tongtien() {
		double tong = 0;
		for(int i = 0 ;i<table2.getRowCount();i++) {
			tong = tong + Double.parseDouble(table2.getValueAt(i, 3).toString());
			
		}
		return tong+"";
	}
	public String tongtien1() {
		double tong = 0;
		for(int i = 0 ;i<table2.getRowCount();i++) {
			tong = tong + Double.parseDouble(table2.getValueAt(i, 3).toString());
			
		}
		return tong+"";
	}
	public double tienthua() {
		double a = Double.parseDouble(textField_tienkhachdua.getText());
		double b = Double.parseDouble(textField_tien.getText());
		return a-b;
	}
	public void capnhapTable2() {
		String cot1 = table1.getValueAt(table1.getSelectedRow(), 0).toString();
		String cot2 = table1.getValueAt(table1.getSelectedRow(), 1).toString();
		String cot3 = textField_sl.getText();
		Double cot4 = Double.valueOf(table1.getValueAt(table1.getSelectedRow(), 3).toString())
				* Integer.parseInt(textField_sl.getText());
		Object ojb[] = new Object[4];
		ojb[0] = cot1;
		ojb[1] = cot2;
		ojb[2] = cot3;
		ojb[3] = cot4;
		tableModel2.addRow(ojb);
	}

	// nap lien combobox
	public void napdulieu() {
		modelCombox = new DefaultComboBoxModel();
		
		for (KhachHang kh : kdao.getAll()) {
			String maKH = kh.getMaKH();
			modelCombox.addElement(maKH);
		}
		comboBox_ma.setModel(modelCombox);
		//tao sở do bên bán hàng mã jtext, bên đây combox, ko phải đâu, keieru như cái trên là lấy dữ liệu ra á, kiểu j nó cx âdd
	}// m chỉ lấy cái thằng vòng for thôi, keieru như gọi bên sql rar xong ôi so sách với tk tỏng combox
	public void laythongtinconlai() {		
		for (KhachHang kh : kdao.getAll()) {
			String maKH = kh.getMaKH();
			if(comboBox_ma.getSelectedItem().toString().trim().equalsIgnoreCase(maKH)) {
				textField_tenkh.setText(kh.getHoTenKH());
				textField_sdt.setText(kh.getSdt());
				textField_diachi.setText(kh.getDiaChi());
				long millis=System.currentTimeMillis();
				java.sql.Date date=new java.sql.Date(millis);		 
		        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		        String dateString = sdf.format(date);
		        textField_ngaylap.setText(dateString);
		      
			}
		}

		// giờ lấy hóa đơn bên dao
	
	}
	public void napdulieu2() {		
		for (NhanVien nv : nvdao.getAll()) {
			String manv = nv.getMaNV();
			modelcombox_nv.addElement(manv);
		}
		comboBox_manv.setModel(modelcombox_nv);
	}
	
	public void thanhtoan() {
		String makh = comboBox_ma.getSelectedItem().toString();

		String manv = comboBox_manv.getSelectedItem().toString();
		String masp = "";
		String tensp = "";
		Double tongtien = null;
		for(int i =0 ; i<table2.getRowCount();i++) {
			 masp = table2.getValueAt(i, 0).toString(); 
			 tensp = table2.getValueAt(i, 1).toString();
			 tongtien = Double.parseDouble(table2.getValueAt(i, 3).toString());
		}
		
		String tenkh = textField_tenkh.getText();
		long millis=System.currentTimeMillis();
		java.sql.Date date=new java.sql.Date(millis);

		DonHang dh = new DonHang("", manv, tensp, makh, tenkh, date, tongtien);
		donHangDao.insertSP(dh);
	}
	public void xoa() {
		int hang = table2.getSelectedRow();
		if (hang != -1) {
			String ma = (String) table2.getValueAt(hang, 0);
			tableModel2.removeRow(hang);
		} else {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập chọn một dòng để xóa");
		}
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		laythongtinconlai();
	}

	
//		tableModel2 = new DefaultComboBoxModel();
//		for (int i = 0; i < table2.getRowCount(); i++) {
//			String maSach = table.getValueAt(i, 0).toString();
//			model.addElement(maSach);
//		}
//		jComboBox.setModel(model);
}