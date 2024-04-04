package w5_Loi;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.TabableView;



public class view extends JFrame implements ActionListener {
	DefaultTableModel model;
	DsSach dssach;
	private Databasee databasee;
	private JComboBox<String> comboBox;
	private JLabel jLabel_masach;
	private JLabel jLabel_tuasach;
	private JLabel jLabel_namsx;
	private JLabel jLabel_sotrang;
	private JLabel jLabel_isbn;
	private JLabel jLabel_tacgia;
	private JLabel jLabel_nhaxuatban;
	private JLabel jLabel_dongia;
	private JLabel jLabel_timtheomasach;
	private JTextField jtf_masach;
	private JTextField jtf_tuasach;
	private JTextField jtf_namsx;
	private JTextField jtf_sotrang;
	private JTextField jtf_isbn;
	private JTextField jtf_tacgia;
	private JTextField jtf_nhaxuatban;
	private JTextField jtf_dongia;
	private JButton jbt_them,jbt_xoarong,jbt_sua,jbt_xoa;
	private JTable table;
	public DsSach ds;

	
	public view() {
		dssach=new DsSach();
		init();
		databasee = new Databasee();
		try {
			loadData();
		} catch ( Exception e) {
			e.printStackTrace();
		}
		setVisible(true);
		
	}
	//lay mảng mã sách
	

	public void init() {
		
		setTitle("Quản lý sách");	
		setSize(1000,700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		
		//xu li center1
		JPanel jPanel_center1 = new JPanel();
		JPanel jPanel_center1_tay = new JPanel();
		JPanel jPanel_center1_dong = new JPanel();
		Box box = Box.createVerticalBox();//doc
		Box box1 = Box.createVerticalBox();
		Box b1  =box.createHorizontalBox();//ngang
		Box b2  =box.createHorizontalBox();
		Box b3  =box.createHorizontalBox();
		Box b11  =box.createHorizontalBox();//ngang
		Box b22  =box.createHorizontalBox();
		Box b33  =box.createHorizontalBox();
		Box b4  =box.createHorizontalBox();
		Box b5  =box.createHorizontalBox();
		box.add(b1);
		box.add(box.createVerticalStrut(5));
		box.add(b2);
		box.add(box.createVerticalStrut(5));
		box.add(b3);
		box.add(box.createVerticalStrut(5));
		box.add(b4);
		box.add(box.createVerticalStrut(5));
		box.add(b5);
		jPanel_center1_tay.add(box);
		jPanel_center1.add(jPanel_center1_tay,BorderLayout.WEST);
		jPanel_center1_dong.add(box1);
		jPanel_center1.add(jPanel_center1_dong,BorderLayout.EAST);
		jPanel_center1.setBorder(BorderFactory.createLineBorder(Color.blue));
		jPanel_center1.setBorder(new TitledBorder("Records Editor"));
		
		box1.add(b11);
		box1.add(box.createVerticalStrut(5));
		box1.add(b22);
		box1.add(box.createVerticalStrut(5));
		box1.add(b33);
		
		
		jLabel_masach= new JLabel("Mã sách:              ");
		jLabel_tuasach=new JLabel("Tựa sách:            ");
		jLabel_namsx = new JLabel("Năm xuất bản:     ");
		jLabel_sotrang=new JLabel("Số trang:              ");
		jLabel_isbn=   new JLabel("International Standard Book Number(ISBN):");
		jLabel_tacgia= new     JLabel("Tác giả:             ");
		jLabel_nhaxuatban= new JLabel("Nhà xuất bản:   ");
		jLabel_dongia = new    JLabel("Đơn giá:            ");
		jLabel_timtheomasach = new JLabel("Tìm theo mã sách: ");
		jtf_masach = new JTextField(35);
		jtf_tuasach = new JTextField();
		jtf_namsx=new JTextField();
		jtf_sotrang= new JTextField();
		jtf_isbn = new JTextField();
		jtf_tacgia= new JTextField(38);
		jtf_nhaxuatban= new JTextField();
		jtf_dongia= new JTextField();
		
		b1.add(jLabel_masach);
		b1.add(jtf_masach);
		b2.add(jLabel_tuasach);
		b2.add(jtf_tuasach);
		b11.add(jLabel_tacgia);
		b11.add(jtf_tacgia);
		b3.add(jLabel_namsx);
		b3.add(jtf_namsx);
		b22.add(jLabel_nhaxuatban);
		b22.add(jtf_nhaxuatban);
		b4.add(jLabel_sotrang);
		b4.add(jtf_sotrang);
		b33.add(jLabel_dongia);
		b33.add(jtf_dongia);
		b5.add(jLabel_isbn);
		b5.add(jtf_isbn);
		b11.add(jLabel_tacgia);
		b11.add(jtf_tacgia);
		b22.add(jLabel_nhaxuatban);
		b22.add(jtf_nhaxuatban);
		b33.add(jLabel_dongia);
		b33.add(jtf_dongia);
		
		//center2
		
		jbt_them = new JButton("Thêm");
		jbt_them.addActionListener(this);
		jbt_xoarong= new JButton("Xóa rỗng");
		jbt_xoarong.addActionListener(this);
		jbt_sua= new JButton("Sửa");
		jbt_sua.addActionListener(this);
		jbt_xoa= new JButton("Xóa");
		jbt_xoa.addActionListener(this);
		JPanel jpanel_center2 = new JPanel();
		jpanel_center2.add(jbt_them);
		jpanel_center2.add(jbt_xoarong);
		jpanel_center2.add(jbt_sua);
		jpanel_center2.add(jbt_xoa);
		//jcombobox
		jLabel_timtheomasach = new JLabel("Tìm theo mã sách");
		comboBox= new JComboBox<String>(dssach.getMaSach());
		//jpanel_center2
		jpanel_center2.add(jLabel_timtheomasach);
		jpanel_center2.add(comboBox);
		
		
		
		
		
		//jpanel_center3 jtable
		String[] cols= {"Mã sách","Tựa sách","Tác giả","Năm xuất bản","Nhà xuất bản","Số trang","Đơn giá","ISBN"};
		model = new DefaultTableModel(cols,0);
		 table = new JTable(model); 
		JScrollPane pane = new JScrollPane(table);
		pane.setBorder(new TitledBorder("Danh sách các cuốn sách"));
		//pane.setBorder(BorderFactory.createLineBorder(Color.blue));
		//jPanel_center1.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		
		//ko cho phép sửa
		table.setDefaultEditor(Object.class, null);
		
		//Tạo sự kiện để nhấp dòng thì có thể hiển thị lên table
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(table.getSelectedRow()!=-1) 
				{
					jtf_masach.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
					jtf_tuasach.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
					jtf_tacgia.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
					jtf_namsx.setText(table.getValueAt(table.getSelectedRow(), 3).toString());
					jtf_nhaxuatban.setText(table.getValueAt(table.getSelectedRow(), 4).toString());
					jtf_sotrang.setText(table.getValueAt(table.getSelectedRow(), 5).toString());
					jtf_dongia.setText(table.getValueAt(table.getSelectedRow(), 6).toString());
					jtf_isbn.setText(table.getValueAt(table.getSelectedRow(), 7).toString());
					
				}
				
			}
		});
		
		
		this.add(jPanel_center1,BorderLayout.NORTH);
		this.add(jpanel_center2,BorderLayout.CENTER);
		this.add(pane,BorderLayout.SOUTH);
		
		
		
	}

	
	//kt tac gia
	public boolean kiemTraTacGia(String tacgia) 
	{
		for (int i = 0; i < tacgia.length(); i++) {
	        char c = tacgia.charAt(i);
	        if (!Character.isLetter(c) &&c!=' ' && c != '.') {
	            return false;
	        }
	    }
		return true;
	}
	//kt tua sach
	public boolean kiemTraTuasach(String tuasach) 
	{
		for (int i = 0; i < tuasach.length(); i++) {
	        char c = tuasach.charAt(i);
	        // kiểm tra có phải chữ l
	        if (!Character.isLetter(c) ||c!=' ' || c != '.') {
	            return false;
	        }
	    }
		return true;
	}
	//kt isbn
	public boolean kiemTraISBN(String x) 
	{
		String pattern = "\\d{1,}-\\d{1,}-\\d{1,}-\\d{1,}-?\\d{0,1}";
		if(x.matches(pattern)) 
		{
			return true;
		}
		return false;
	}
	// xu li su kien
	public void them() 
	{
		String masach = jtf_masach.getText();
		String tuasach = jtf_tuasach.getText();
		String tacgia  = jtf_tacgia.getText();
		int namxuatban = Integer.valueOf(jtf_namsx.getText());
		String nhaxuatban = jtf_nhaxuatban.getText();
		int sotrang = Integer.valueOf(jtf_sotrang.getText());
		int dongia = Integer.valueOf(jtf_dongia.getText());
		String isbn = jtf_isbn.getText();
		Sach s = new Sach(masach, tuasach, tacgia, nhaxuatban, isbn, namxuatban, sotrang, dongia);
		
		if(masach.equals("")||tuasach.equals("")||tacgia.equals("")||isbn.equals("")) 
		{
			JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin");	
		}
		
		else if(kiemTraTuasach(tuasach)==false||kiemTraTacGia(tacgia)==false) 
		{
			JOptionPane.showMessageDialog(this, "Tựa sách và Tác giả không chứa số và kí tự đặc biệt");
			jtf_tuasach.setText("");
			jtf_tacgia.setText("");
		}	
		else if(kiemTraISBN(isbn)==false) 
		{
			JOptionPane.showMessageDialog(this, "ISBN không theo mẫu dạng");
			jtf_isbn.setText("");
		}
		else if(s.getMasach().charAt(0)==tuasach.charAt(0)&&(s.getMasach().charAt(1)>0||s.getMasach().charAt(1)<9)&&(s.getMasach().charAt(2)>0||s.getMasach().charAt(2)<9)&&(s.getMasach().charAt(3)>0||s.getMasach().charAt(3)<9)&&s.getMasach().length()==4) 
		{	
			if(dssach.themSach(s)) 
			{
				Object[] obj = new Object[8];
				obj[0]=masach;
				obj[1]=tuasach;
				obj[2]=	tacgia;
				obj[3]=namxuatban;
				obj[4]=nhaxuatban;
				obj[5]=sotrang;
				obj[6]=dongia;
				obj[7]=isbn;
				model.addRow(obj);
				JOptionPane.showMessageDialog(this, "Thêm thành công");
				
			}
			else 
			{
					JOptionPane.showMessageDialog(this, "Mã sách không được trùng");
					jtf_masach.setText("");	
			}
		}	
		else 
		{
			JOptionPane.showMessageDialog(null, "Mã sách không theo quy ước");
			jtf_masach.setText("");
		}
		comboBox= new JComboBox<String>(dssach.getMaSach());
		databasee.saveFive("DanhMucSach.dat", dssach);
	}
	public void xoaRong() 
	{
		jtf_masach.setText("");
		jtf_tuasach.setText("");
		jtf_namsx.setText("");
		jtf_sotrang.setText("");
		jtf_isbn.setText("");
		jtf_tacgia.setText("");
		jtf_nhaxuatban.setText("");
		jtf_dongia.setText("");
	}
	public void Xoa() 
	{
		int row =table.getSelectedRow();
		if(row==-1) 
		{
			JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng muốn xóa");
		}
		else 
		{
			if(JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa dòng này hay không?","Cảnh báo",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) 
			{
				model.removeRow(row);
				dssach.xoaSach(row);
				xoaRong();
				databasee.saveFive("DanhMucSach.dat", dssach);
			}
		}
	}
	public void Sua() 
	{
		int row= table.getSelectedRow();
		if(row==-1) 
		{
			JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng muốn sửa");
			return;
		}
		String masach = jtf_masach.getText();
		String tuasach = jtf_tuasach.getText();
		String tacgia  = jtf_tacgia.getText();
		String namxuatban = jtf_namsx.getText();
		String nhaxuatban = jtf_nhaxuatban.getText();
		String sotrang = jtf_sotrang.getText();
		String dongia = jtf_dongia.getText();
		String isbn = jtf_isbn.getText();
		if(masach.equals("")||tuasach.equals("")||tacgia.equals("")||namxuatban.equals("")||nhaxuatban.equals("")||sotrang.equals("")||dongia.equals("")||isbn.equals("")) 
		{
			JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin!");
			return;
		}
		if(kiemTraTuasach(tuasach)==false||kiemTraTacGia(tacgia)==false) 
		{
			JOptionPane.showMessageDialog(this, "Tựa sách và Tác giả không chứa số và kí tự đặc biệt");
			jtf_tuasach.setText("");
			jtf_tacgia.setText("");
			return;
		}	
		if(kiemTraISBN(isbn)==false) 
		{
			JOptionPane.showMessageDialog(this, "ISBN không theo mẫu dạng");
			jtf_isbn.setText("");
			return;
		}
		if(masach.charAt(0)==tuasach.charAt(0)&&(masach.charAt(1)>0||masach.charAt(1)<9)&&(masach.charAt(2)>0||masach.charAt(2)<9)&&(masach.charAt(3)>0||masach.charAt(3)<9)&&masach.length()==4) 
		{
			for(int i=0;i<table.getRowCount();i++) 
			{
				String rowMasach =(String)table.getValueAt(i, 0);
				if(rowMasach.equals(masach)&&i!=row) 
				{
					JOptionPane.showMessageDialog(this, "Mã sách đã tồn tại!");
					return;
				}
			}
			
		}
		if(JOptionPane.showConfirmDialog(this, "Bạn có muốn sửa dòng này không?","Cảnh báo",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) 
		{
			String[] data= {masach,tuasach,tacgia,namxuatban,nhaxuatban,sotrang,dongia,isbn};
				model.removeRow(row);
				model.insertRow(row, data);
				
				Sach s = new Sach(masach, tuasach, tacgia, nhaxuatban, isbn,Integer.valueOf(namxuatban) ,Integer.valueOf(sotrang), Integer.valueOf(dongia));
				dssach.xoaSach(row);
				dssach.themSach(s);
				JOptionPane.showMessageDialog(this, "Sửa dữ liệu thành công!");
				databasee.saveFive("DanhMucSach.dat", dssach);
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(jbt_them)) 
		{
			them();
		}
		else if(o.equals(jbt_xoarong)) 
		{
			xoaRong();
		}
		else if(o.equals(jbt_xoa)) 
		{
			Xoa();
		}
		else if(o.equals(jbt_sua)) 
		{
			Sua();
		}
		
	}
	
	public void loadData() throws Exception{
		ds= (DsSach) databasee.readFile("DanhMucSach.dat");
		if(dssach==null) 
		{
			ds= new DsSach();
		}	
		else 
		{
			for (Sach sach : ds.getDssach()) {
				String[] row = {sach.getMasach(),sach.getTuasach(),sach.getTacgia(),String.valueOf(sach.getNamxuatban()),sach.getNhaxuatban(),String.valueOf(sach.getSotrang()),String.valueOf(sach.getDongia()),sach.getIsbn()};
				model.addRow(row);
			}
		}
	}
	public static void main(String[] args) {
		new view();
		
	}
}
