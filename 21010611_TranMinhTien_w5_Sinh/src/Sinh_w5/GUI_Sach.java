package Sinh_w5;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;

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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class GUI_Sach extends JFrame implements ActionListener{
	public QLSach qlSach;
	private Database data;
	private JLabel jLabel_ma, jLabel_tuasach, jLabel_nhaxb, jLabel_soTrg,
		jLabel_ISBN, jLabel_tgia, jLabel_namXB, jLabel_donGia, jLabel_tim;
	
	private JTextField text_ma, text_tuasach, text_nhaxb, text_soTrg,
		text_ISBN, text_tgia, text_namXB, text_donGia;
	private JButton jbt_them, jbt_xoaTr, jbt_xoa, jbt_sua, jbt_thoat;
	private JTable table_s;
	private DefaultTableModel model_s;
	private JPanel jPanel_center;
	private JComboBox comboBox_ma;
	private Box b_jbt;
	private DefaultComboBoxModel model_com;
	public GUI_Sach() {
		
		qlSach = new QLSach();
		data = new Database();
		setTitle("^-^");
		setSize(1200, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		showIt();
		try {
			LoadData();
			additem();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void showIt() {
		
		//tao cac componet
		
			//Jlabel
			jLabel_ma = new JLabel("Mã sách:");
			jLabel_tuasach = new JLabel("Tựa sách:");
			jLabel_nhaxb = new JLabel("Nhà xuất bản:");
			jLabel_soTrg = new JLabel("Số trang:");
			jLabel_ISBN = new JLabel("International Standard Book Number (ISBN):");
			jLabel_tgia = new JLabel("Tác giả");
			jLabel_namXB = new JLabel("Năm xuất bản");
			jLabel_donGia = new JLabel("Đơn giá");
			jLabel_tim = new JLabel("TÌm theo mã sách");
			
			//jtextField
			text_ma = new JTextField();
			text_tuasach = new JTextField();
			text_namXB = new JTextField();
			text_nhaxb = new JTextField();
			text_soTrg = new JTextField();
			text_ISBN = new JTextField();
			text_tgia = new JTextField(45);
			text_nhaxb = new JTextField();
			text_donGia = new JTextField();

			//Jbutton
			jbt_them = new JButton("Thêm");
			jbt_xoaTr = new JButton("Xóa trắng");
			jbt_xoa = new JButton("Xóa");
			jbt_sua = new JButton("Sửa");
			jbt_thoat = new JButton("Thoát");
			
		//khu vực nội dung
			//khu vực bắc
			JPanel jPanel_north = new JPanel();
			jPanel_north.setLayout(new BoxLayout(jPanel_north, BoxLayout.X_AXIS));
			jPanel_north.setBorder( new TitledBorder("Records Edittor"));

				//kv tay_bawsc
					JPanel jPanel_north_west = new JPanel();
					jPanel_north_west.setLayout(new BoxLayout(jPanel_north_west, BoxLayout.Y_AXIS));
					jPanel_north_west.setPreferredSize(new Dimension(400,150));
					Box b_west, bw_1, bw_2, bw_3, bw_4, bw_5;
					b_west = Box.createVerticalBox();
					b_west.add(bw_1 = Box.createHorizontalBox());
					b_west.add(Box.createVerticalStrut(5));
					b_west.add(bw_2 = Box.createHorizontalBox());
					b_west.add(Box.createVerticalStrut(5));
					b_west.add(bw_3 = Box.createHorizontalBox());
					b_west.add(Box.createVerticalStrut(5));
					b_west.add(bw_4 = Box.createHorizontalBox());
					b_west.add(Box.createVerticalStrut(5));
					b_west.add(bw_5 = Box.createHorizontalBox());
					b_west.add(Box.createVerticalStrut(5));

					jPanel_north_west.add(b_west);
					jPanel_north_west.add(Box.createVerticalStrut(10));
					
					bw_1.add(jLabel_ma);
					bw_1.add(text_ma);
					jLabel_ma.setPreferredSize(jLabel_namXB.getPreferredSize());
//					text_ma.setPreferredSize(new Dimension(20,100));

					
					bw_2.add(jLabel_tuasach);
					bw_2.add(text_tuasach);
					jLabel_tuasach.setPreferredSize(jLabel_namXB.getPreferredSize());
					
					bw_3.add(jLabel_namXB);
					bw_3.add(text_namXB);
					
					bw_4.add(jLabel_soTrg);
					bw_4.add(text_soTrg);
					jLabel_soTrg.setPreferredSize(jLabel_namXB.getPreferredSize());
					
					bw_5.add(jLabel_ISBN);
					bw_5.add(text_ISBN);
			
				//kv dong_bac
					JPanel jPanel_north_south = new JPanel();
					jPanel_north_south.setPreferredSize(new Dimension(600,100));
					Box b_south, bs_2, bs_3, bs_4;
					b_south = Box.createVerticalBox();
					b_south.add(Box.createVerticalStrut(25));
					b_south.add(bs_2 = Box.createHorizontalBox());
					b_south.add(Box.createVerticalStrut(5));
					b_south.add(bs_3 = Box.createHorizontalBox());
					b_south.add(Box.createVerticalStrut(5));
					b_south.add(bs_4 = Box.createHorizontalBox());
				

					jPanel_north_south.add(b_south);
					jPanel_north_south.add(Box.createVerticalStrut(10));
					
					bs_2.add(jLabel_tgia);
					bs_2.add(text_tgia);
					jLabel_tgia.setPreferredSize(jLabel_nhaxb.getPreferredSize());
					text_tgia.setPreferredSize(new Dimension(40,23));

					
					bs_3.add(jLabel_nhaxb);
					bs_3.add(text_nhaxb);
					text_nhaxb.setPreferredSize(new Dimension(40,23));

										
					bs_4.add(jLabel_donGia);
					bs_4.add(text_donGia);
					text_donGia.setPreferredSize(new Dimension(40,23));
					jLabel_donGia.setPreferredSize(jLabel_nhaxb.getPreferredSize());
					
			//add vao khu vuc	
			jPanel_north.add(jPanel_north_west);
			jPanel_north.add(jPanel_north_south);

		//khu vực center
			jPanel_center = new JPanel();
			jPanel_center.setLayout(new BoxLayout(jPanel_center, BoxLayout.Y_AXIS));
				//tạo box chứa các button
				  b_jbt = Box.createHorizontalBox();
				b_jbt.add(Box.createHorizontalStrut(250));
				b_jbt.add(jbt_them);
				b_jbt.add(Box.createHorizontalStrut(5));
				b_jbt.add(jbt_xoaTr);
				b_jbt.add(Box.createHorizontalStrut(5));
				b_jbt.add(jbt_sua);
				b_jbt.add(Box.createHorizontalStrut(5));
				b_jbt.add(jbt_xoa);
				b_jbt.add(Box.createHorizontalStrut(5));
				b_jbt.add(jbt_thoat);
				//khu vực chứa chức năng tìm kiếm
			JPanel jPanel_box = new JPanel();
			comboBox_ma = new JComboBox();
			comboBox_ma.setPreferredSize(jbt_them.getPreferredSize());
			jPanel_box.add(jLabel_tim);
			jPanel_box.add(comboBox_ma);

					
				
			jPanel_center.add(b_jbt);
			taoBang();
			
		b_jbt.add(jPanel_box);
		add(jPanel_north, BorderLayout.NORTH);
		add(jPanel_center, BorderLayout.CENTER);
			
	
		// DSLK
			jbt_them.addActionListener(this);
			jbt_xoa.addActionListener(this);
			jbt_xoaTr.addActionListener(this);
			jbt_sua.addActionListener(this);
			jbt_thoat.addActionListener(this);
			comboBox_ma.addActionListener(this);
		
		table_s.addMouseListener(new MouseListener() {
			
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

				int row = table_s.getSelectedRow();
				text_ma.setText(model_s.getValueAt(row, 0).toString());
				text_tuasach.setText(model_s.getValueAt(row, 1).toString());
				text_tgia.setText(model_s.getValueAt(row, 2).toString());
				text_namXB.setText(model_s.getValueAt(row, 3).toString());
				text_nhaxb.setText(model_s.getValueAt(row, 4).toString());
				text_soTrg.setText(model_s.getValueAt(row, 5).toString());
				text_donGia.setText(model_s.getValueAt(row, 6).toString());
				text_ISBN.setText(model_s.getValueAt(row, 7).toString());	
			}
		});
		
		comboBox_ma.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				String valueItem = (String) comboBox_ma.getSelectedItem();
				for (int i = 0; i < table_s.getRowCount(); i++) {
					if(valueItem.equals(table_s.getValueAt(i, 0))) {
						table_s.setRowSelectionInterval(i, i);
						text_ma.setText(model_s.getValueAt(i, 0).toString());
						text_tuasach.setText(model_s.getValueAt(i, 1).toString());
						text_tgia.setText(model_s.getValueAt(i, 2).toString());
						text_namXB.setText(model_s.getValueAt(i, 3).toString());
						text_nhaxb.setText(model_s.getValueAt(i, 4).toString());
						text_soTrg.setText(model_s.getValueAt(i, 5).toString());
						text_donGia.setText(model_s.getValueAt(i, 6).toString());
						text_ISBN.setText(model_s.getValueAt(i, 7).toString());	
					}
				}
			}
		});
	}
	
	public void taoBang() {
		String[] column = {"Mã sách", "Tựa sách", "Tác giả", "Năm xuất bản", "Nhà xuất bản", "Số trang", "Đơn giá", "ISBN"};
		model_s = new DefaultTableModel(column, 0);
		table_s = new JTable(model_s);
		
		JScrollPane sp = new JScrollPane(table_s, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sp.setBorder(new TitledBorder("Danh sách các cuốn sách"));
		jPanel_center.add(sp);
	}
	
	//additem
	public void additem() {
		model_com = new DefaultComboBoxModel();
		for (int i = 0; i < table_s.getRowCount(); i++) {
			model_com.addElement(table_s.getValueAt(i, 0).toString());
		}
		 comboBox_ma.setModel(model_com);

	}
	
	/*
	 * Kiểm tra kí tự đặc biệt 
	 */
	public boolean isDigitsOrNum(String digit) {
		for (int i = 0; i < digit.length(); i++) {
			char charec = digit.charAt(i);
			if(!Character.isLetter(charec)&&charec!='.' &&charec!=' ') {
				return false;
			}
		}
		return true;
	}
	
	/*
	 * Kiểm tra ISBN
	 * 
	 * \\d: ký tự số từ 0 đến 9.
	 * {1,}: xuất hiện từ một lần trở lên.
	 * -: dấu gạch ngang (-).
	 * ?: có thể xuất hiện hoặc không xuất hiện.
	 */
	 
	public boolean isISBN(String digit) {
	    String is_isbn = "\\d{1,}-\\d{1,}-\\d{1,}-\\d{1,}(-\\d{1,})?";
	    return digit.matches(is_isbn);
	}

	/**
	 * Kiểm tra năm sản xuất >= 1900 và <= năm hiện tại
	 * @param year
	 * @return
	 */
	 
	public boolean isYear(int year) {
	    if(!(year >= 1900 && year <= LocalDate.now().getYear())) {
	    	return false;
	    }
	    return true;
	}
	
	
	/**
	 * Thêm dữ liệu sách vào bảng
	 * @throws Exception
	 */
	public void themSach() throws Exception{
		String maSach = text_ma.getText();
		String tuaSach = text_tuasach.getText();
		String tacGia = text_tgia.getText();
		int namXB = Integer.parseInt(text_namXB.getText());
		String nhaXB = text_nhaxb.getText();
		int soTrang = Integer.parseInt(text_soTrg.getText());
		double donGia = Double.parseDouble(text_donGia.getText());
		String ISBN = text_ISBN.getText();

		Sach sach = new Sach(maSach, tuaSach, tacGia, namXB, nhaXB, soTrang, donGia, ISBN);
		
		/*
		 * Kiểm tra ký tự tựa sách và tác giả
		 */
		if(!isDigitsOrNum(tuaSach)) {
			JOptionPane.showMessageDialog(this, "Tựa sách có chứa ký tự đặc biệt và số");
			text_tuasach.setText("");
			text_tuasach.requestFocus();
		} else if(!isDigitsOrNum(tacGia) ) {
			JOptionPane.showMessageDialog(this, "Tác giả có chứa ký tự đặc biệt và số");
			text_tgia.setText("");
			text_tgia.requestFocus();
		} else if(!isISBN(ISBN)){
			JOptionPane.showMessageDialog(this, "ISBN không đúng cú pháp");
			text_ISBN.setText("");
			text_ISBN.requestFocus();
		} else if(!isYear(namXB)){
			JOptionPane.showMessageDialog(this, "Năm sản xuất >= 1900 và <= năm hiện tại");
			text_namXB.setText("");
			text_namXB.requestFocus();
		} else if(soTrang < 0){
			JOptionPane.showMessageDialog(this, "Số trang phải là số nguyên dương");
			text_soTrg.setText("");
			text_soTrg.requestFocus();
		} else if(donGia < 0){
			JOptionPane.showMessageDialog(this, "Đơn giá phải là số nguyên dương");
			text_donGia.setText("");
			text_donGia.requestFocus();
		}else if(maSach.charAt(0) == tuaSach.charAt(0) && Character.isDigit(maSach.charAt(1))&&Character.isDigit(maSach.charAt(2))
				&& Character.isDigit(maSach.charAt(3))) {
			if(qlSach.themSach(sach)) {
				Object[] obj = new Object[8];
				obj[0] = maSach;
				obj[1] = tuaSach;
				obj[2] = tacGia;
				obj[3] = Integer.toString(namXB);
				obj[4] = nhaXB;
				obj[5] = Integer.toString(soTrang);
				obj[6] = Double.toString(donGia);
				obj[7] = ISBN;		
				model_s.addRow(obj);	
				JOptionPane.showMessageDialog(this, "Thêm dữ liệu thành công");			
				data.saveFile("Sach.dat", qlSach);
			} else {
				JOptionPane.showMessageDialog(this, "Id này tồn tại");
				text_ma.setText("");
			}
		} else {
			JOptionPane.showMessageDialog(this, "User nhập mã sách không đúng quy ước!Phải nhập có ký tự đầu là ký tự đầu của tựa sách, "
					+ "theo sau là 3 ký số");
			text_ma.setText("");
			text_ma.requestFocus();
		}
		
	}
	
	/**
	 * Xóa một dòng
	 * @throws Exception
	 */
	public void xoa() throws Exception{
		int row = table_s.getSelectedRow();
		if(row==-1) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần xóa");
		} else {
			if(JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa dòng đã chọn hay không?", "Cảnh báo", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
				qlSach.xoaSach(row);
				model_s.removeRow(row);
				xoaRong();
				data.saveFile("Sach.dat", qlSach);
			}
		}
	}
	
	/**
	 * sửa một dòng
	 */
	public void sua() {
		int row = table_s.getSelectedRow();
		if(row != -1) {
			String maSach = text_ma.getText();
			String tuaSach = text_tuasach.getText();
			String tacGia = text_tgia.getText();
			int namXB = Integer.parseInt(text_namXB.getText());
			String nhaXB = text_nhaxb.getText();
			int soTrang = Integer.parseInt(text_soTrg.getText());
			double donGia = Double.parseDouble(text_donGia.getText());
			String ISBN = text_ISBN.getText();
				Sach s = new Sach(maSach, tuaSach, tacGia, namXB, nhaXB, soTrang, donGia, ISBN);
				qlSach.sua(s);
				for (int i = 0; i < table_s.getRowCount(); i++) {
					String idString = table_s.getValueAt(i,0) +"";
					if (idString.equalsIgnoreCase(s.getMaSach())) {
						table_s.setValueAt(s.getMaSach(), i, 0);
						table_s.setValueAt(s.getTuaSach(), i, 1);
						table_s.setValueAt(s.getTacGia(), i, 2);
						table_s.setValueAt(s.getNamXB(), i, 3);
						table_s.setValueAt(s.getNhaXB(), i, 4);
						table_s.setValueAt(s.getSoTrang(), i, 5);
						table_s.setValueAt(s.getDonGia(), i, 6);
						table_s.setValueAt(s.getISBN(), i, 7);
						JOptionPane.showMessageDialog(this, "Cập nhật thành công");
						data.saveFile("Sach.dat", qlSach);
					}
				}
			
			
		} else {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cập nhật");

		}
		
	}
	
	public void xoaRong()
	{
		text_ma.setText("");
		text_tuasach.setText("");
		text_tgia.setText("");
		text_namXB.setText("");
		text_nhaxb.setText("");
		text_soTrg.setText("");
		text_donGia.setText("");
		text_ISBN.setText("");	
	}
	
	private void LoadData() throws Exception{
		qlSach = null;
		qlSach = (QLSach) data.readFile("Sach.dat");
		if(qlSach == null) {
			qlSach = new QLSach();
		} else {
			for (Sach s : qlSach.getDsSach()) {
				Object[] obj = new Object[8];
				obj[0] = s.getMaSach();
				obj[1] = s.getTuaSach();
				obj[2] = s.getTacGia();
				obj[3] = Integer.toString(s.getNamXB());
				obj[4] = s.getNhaXB();
				obj[5] = Integer.toString(s.getSoTrang());
				obj[6] = Double.toString(s.getDonGia());
				obj[7] = s.getISBN();	
				model_s.addRow(obj);
			}
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(jbt_them)) {
			if(text_ma.getText().trim().equals("")||text_tuasach.getText().trim().equals("") || text_tgia.getText().trim().equals("")||
					text_soTrg.getText().trim().equals("")||text_namXB.getText().trim().equals("")|| text_nhaxb.getText().trim().equals("")||
					text_donGia.getText().trim().equals("")|| text_ISBN.getText().trim().equals("")) {
				JOptionPane.showMessageDialog(this, "Ô nhập dữ liệu còn trống");
			} else {
				try {
					themSach();
					additem();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}  else if(o.equals(jbt_xoa)) {
			try {
				xoa();
				additem();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		else if (o.equals(jbt_xoaTr)) {
			xoaRong();
		} else if (o.equals(jbt_sua)) {
			sua();
		}else if (o.equals(jbt_thoat)) {
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		new GUI_Sach().setVisible(true);
	}
}
