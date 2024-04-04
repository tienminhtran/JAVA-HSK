package TranMinhTien_21010611_W2_3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
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



public class View extends JFrame implements ActionListener, MouseListener{
	public DanhSachNhanVien danhSachNhanVien;
	private DefaultTableModel tableModel;
	public JTable table;
	public JButton jb_them;
	public JButton jb_xoatrang;
	public JButton jb_xoa;
	public JButton jb_luu;
	public JButton jb_sua;
	public JButton jb_thoat;
	public JLabel jLabel_ma;
	public JLabel JjLabel_ho;
	public JLabel jLabel_ten;
	public JLabel jLabel_tuoi;
	public JLabel jLabel_phai;
	public JLabel jLabel_tienluong;
	public JTextField jTextField_ma;
	public JTextField jTextField_ho;
	public JTextField jTextField_ten;
	public JTextField jTextField_tuoi;
	public JTextField jTextField_phai;
	public JTextField jTextField_tienluong;
	public JRadioButton jRadioButton_nam;
	public JRadioButton jRadioButton_nu;
	public ButtonGroup buttonGroup;
	public Component jLabel_ho;
	private JButton jb_khungtim;
	private JTextField jtf_khungtim;
	
	public View() {
		this.danhSachNhanVien = new DanhSachNhanVien();
		this.setSize(800,480);
		this.setAutoRequestFocus(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.Init();
		this.setResizable(false);		
		this.setVisible(true);
	}

	public void Init() {
		Font f = new Font("Arial", Font.BOLD , 40);

		// trên
			JPanel jPanel_head = new JPanel();
			jPanel_head.setLayout(new BorderLayout());
			JLabel jl_title = new JLabel("THÔNG TIN NHÂN VIÊN", JLabel.CENTER);
			jl_title.setForeground(Color.BLUE);
			jl_title.setFont(f);
			jPanel_head.add(jl_title, BorderLayout.CENTER);
			
			//this.add(jPanel_head, BorderLayout.NORTH);
			
		// giữa
			jLabel_ma = new JLabel("Mã nhân viên:");
			jLabel_ho = new JLabel("Họ:");
			jLabel_ten = new JLabel("Tên nhân viên:");			
			jLabel_tuoi = new JLabel("Tuổi:");
			jLabel_phai = new JLabel("Phái:");
			jLabel_tienluong = new JLabel("Tiền lương:");
			
			 jTextField_ma = new JTextField();
			 jTextField_ho = new JTextField();
			 jTextField_ten = new JTextField();
			 jTextField_tuoi = new JTextField();
			 jTextField_phai = new JTextField();
			 jTextField_tienluong = new JTextField();
			
			// tạo jradiobutton cho phái
			jRadioButton_nam = new JRadioButton("Nam");
			jRadioButton_nu = new JRadioButton("Nữ");
				
				// group 2 jradio
				buttonGroup = new ButtonGroup();
				buttonGroup.add(jRadioButton_nam);
				buttonGroup.add(jRadioButton_nu);
				// TẠO MỘT jpanel chứa phần trung tâm
				JPanel jPanel_center = new JPanel();
					//TẠO  BOXLAYOUT
					BoxLayout boxLayout = new BoxLayout(jPanel_center,BoxLayout.Y_AXIS);
				 
					jPanel_center.setLayout(boxLayout);
					
						// TẠO BOX 
						Box b, b1, b2, b3,  b4;
						
						b = Box.createVerticalBox(); //trục dọc
							b1 = Box.createHorizontalBox();// trục ngang
							b2 = Box.createHorizontalBox();// trục ngang
							b3 = Box.createHorizontalBox();// trục ngang
							b4 = Box.createHorizontalBox();// trục ngang
					//b là nguyên chương trình chính add hết b1, b2, b3, b4
					b.add(b1);
				//	b.add(Box.createHorizontalStrut(15));
					b.add(b2);
				//	b.add(Box.createHorizontalStrut(15));
					b.add(b3);
				//	b.add(Box.createHorizontalStrut(15));
					b.add(b4);
				//	b.add(Box.createHorizontalStrut(15));

					// add phần tử JLABE và JTEXT
					b1.add(jLabel_ma);
					b1.add(jTextField_ma);
					
					// bắt ràng buộc theo kiểu mã nhân viên
					
					b2.add(jLabel_ho);
					b2.add(jTextField_ho);
					b2.add(jLabel_ten);
					b2.add(jTextField_ten);
					jLabel_ho.setPreferredSize(jLabel_ma.getPreferredSize());

					b3.add(jLabel_tuoi);
					b3.add(jTextField_tuoi);
					b3.add(jLabel_phai);
					b3.add(jRadioButton_nam);
					b3.add(jRadioButton_nu);
					jLabel_tuoi.setPreferredSize(jLabel_ma.getPreferredSize());

					b4.add(jLabel_tienluong);
					b4.add(jTextField_tienluong);
					jLabel_tienluong.setPreferredSize(jLabel_ma.getPreferredSize());
					
					jPanel_center.add(b);
					jPanel_center.add(Box.createHorizontalStrut(10));
//					this.add(jPanel_center, BorderLayout.CENTER);
					
					
					// tạo bảng
			        tableModel = new DefaultTableModel();
			        tableModel.addColumn("Mã NV");
			        tableModel.addColumn("Họ");
			        tableModel.addColumn("Tên");
			        tableModel.addColumn("Tuổi");
			        tableModel.addColumn("Phái");
			        tableModel.addColumn("Tiền lương");
			       
		 
			        table = new JTable(tableModel);
			        JScrollPane jsp = new JScrollPane(table);
			        table.setRowSelectionAllowed(true);
//			        table.setEditingRow(ERROR);
			        jPanel_center.add(jsp);
			        // TẠO BUTTON
			 

					JSplitPane jspane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
					
						JPanel jp_bot_trai = new JPanel();
							JLabel jl_khungtim = new JLabel("Nhập mã số cần tìm:");
							jtf_khungtim = new JTextField(10);
							jb_khungtim = new JButton("Tìm");
							
							
							jp_bot_trai.add(jl_khungtim);
							jp_bot_trai.add(jtf_khungtim);
							jp_bot_trai.add(jb_khungtim);
						
						JPanel jp_bot_phai = new JPanel();
							jb_them = new JButton("Thêm");
							
							jb_xoatrang = new JButton("Xoá trắng");

							jb_xoa = new JButton("Xoá");

							jb_luu = new JButton("Lưu");

							jb_sua = new JButton("Cập nhật");
							
							jb_thoat = new JButton("Thoát");
							
							jp_bot_phai.add(jb_them);
							jp_bot_phai.add(jb_sua);
							jp_bot_phai.add(jb_xoatrang);
							jp_bot_phai.add(jb_xoa);
							jp_bot_phai.add(jb_luu);
							jp_bot_phai.add(jb_thoat);

					jspane.add(jp_bot_trai);
					jspane.add(jp_bot_phai);
		
					this.setLayout(new BorderLayout());
					this.add(jPanel_head, BorderLayout.NORTH);
					this.add(jPanel_center, BorderLayout.CENTER);
					this.add(jspane, BorderLayout.SOUTH);		
					
			// SỰ KIỆN
			jb_them.addActionListener(this);
			jb_xoa.addActionListener(this);
			jb_xoatrang.addActionListener(this);
			jb_luu.addActionListener(this);
			jb_sua.addActionListener(this);
			jb_thoat.addActionListener(this);
			jb_khungtim.addActionListener(this);

			this.table.addMouseListener(this);					
			this.addMouseListener(this);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row= table.getSelectedRow();
		jTextField_ma.setText(table.getValueAt(row, 0).toString());
		jTextField_ho.setText(table.getValueAt(row, 1).toString());
		jTextField_ten.setText(table.getValueAt(row, 2).toString());
		jTextField_tuoi.setText(table.getValueAt(row, 3).toString());		

		if(tableModel.getValueAt(row, 4).toString().equalsIgnoreCase("Nam")){
			jRadioButton_nam.setSelected(true);
			jRadioButton_nu.setSelected(false);
		}else {
			jRadioButton_nam.setSelected(false);
			jRadioButton_nu.setSelected(true);
		}
		

		jTextField_tienluong.setText(table.getValueAt(row, 5).toString());
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
		// TODO Auto-generated method stub
		String src = e.getActionCommand();
		if(src.equals("Thêm"))
		{
			
				try {
					this.themnv();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showConfirmDialog(this, "Vui lòng nhập thông tin", "Lỗi", JOptionPane.ERROR_MESSAGE);
				}
		}else if(src.equals("Xoá"))
		{
			try {
				this.xoanv();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if(src.equals("Xoá trắng"))
		{
			if(jTextField_ma.getText().equals(""))
			{
				JOptionPane.showConfirmDialog(this, "Vui lòng nhập thông tin", "Lỗi", JOptionPane.ERROR_MESSAGE);

			}else {
				this.xoaTrang();
			}
			
		}else if(src.equals("Lưu")) {
			int awt = JOptionPane.showConfirmDialog(this, "Chức năng lưu file này chưa thực hiện", "Thông báo", JOptionPane.WARNING_MESSAGE);
			{
				this.luu();
			}
		}else if(src.equals("Cập nhật")) {
			
			this.capnhat();
		}else if(src.equals("Thoát")) {
			int awt = JOptionPane.showConfirmDialog(this, "Bạn có muốn thoát không! ", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
			if(awt == JOptionPane.OK_OPTION)
			{
				System.exit(0);
			}
			else {
				
			}
		}else if(src.equals("Tìm")) {
			this.tim();
		}
		
	}


	public void capnhat() {
		int hang = table.getSelectedRow();

		if(hang!=-1)
		{
			
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		String maNv= jTextField_ma.getText();
		String ho= jTextField_ho.getText();
		String ten= jTextField_ten.getText();
		String phai = "";
		if(jRadioButton_nam.isSelected()) {
			phai = jRadioButton_nam.getText();
		}else {
			phai = jRadioButton_nu.getText();
		}
		int tuoi = Integer.parseInt(jTextField_tuoi.getText());
		double tienluong= Double.parseDouble(jTextField_tienluong.getText());		
		NhanVien nv = new NhanVien(maNv, ho, ten, tuoi, phai, tienluong);
			this.danhSachNhanVien.update(nv);

					int soLuongDong = table.getRowCount();
						for (int i = 0; i < soLuongDong; i++) {
						String id = tableModel.getValueAt(i, 0) + "";
						if (id.equals(nv.getMaNV() + "")) {
							JOptionPane.showConfirmDialog(this, "Cập nhật thành công!","Thông báo", JOptionPane.OK_OPTION);
							table.setValueAt(nv.getMaNV() + "", i, 0);
							table.setValueAt(nv.getHo() + "", i, 1);
							table.setValueAt(nv.getTen() + "", i, 2);
							table.setValueAt(nv.getTuoi() + "", i, 3);
							table.setValueAt(nv.getPhai() + "", i, 4);
							table.setValueAt(nv.getTienLuong() + "", i, 5);
					}
				}
		}else {
			JOptionPane.showConfirmDialog(this, "Chọn dòng cần cập nhật nha bạn!!!","Thông báo", JOptionPane.OK_OPTION);
		}

		}
	
	private void tim() {
		// TODO Auto-generated method stub
		if(jtf_khungtim.getText().equals("")) {
			JOptionPane.showConfirmDialog(this, "Vui lòng nhập mã id cần tìm!", "Lỗi", JOptionPane.ERROR_MESSAGE);
		}else
		{
			String ma = jtf_khungtim.getText()+"";
			NhanVien nv = danhSachNhanVien.timkiem(ma);
			if(nv == null)
			{
				JOptionPane.showConfirmDialog(this, "Không tìm thấy id cần tìm", "Thông báo", JOptionPane.OK_CANCEL_OPTION);
			}else {
				//onJtextField();
				jTextField_ma.setText(nv.getMaNV());
				jTextField_ho.setText(nv.getHo());
				jTextField_ten.setText(nv.getTen());
				if (nv.getPhai().equals("Nam")) {
					jRadioButton_nam.setSelected(true);
					jRadioButton_nu.setSelected(false);
				}else {
					jRadioButton_nu.setSelected(false);
					jRadioButton_nu.setSelected(true);
				}
				jTextField_tuoi.setText(nv.getTuoi()+"");
				jTextField_tienluong.setText(nv.getTienLuong()+"");
					for(int i = 0; i<table.getRowCount();i++) {
						for(int j = 0; j<table.getColumnCount();j++) {
							if(table.getModel().getValueAt(i, j).equals(jtf_khungtim.getText())) {
								//System.out.println(table.getModel().getValueAt(i, j));
									table.setRowSelectionInterval(i, i);
									
								//	addMouseListener();	
							}
						}
					}
			}
		}
		

	}

	private void luu() {
		// TODO Auto-generated method stub
		
	}

	private void xoaTrang() {
		// TODO Auto-generated method stub
		jTextField_ma.setText("");
		jTextField_ho.setText("");
		jTextField_ten.setText("");
		jTextField_tuoi.setText("");
		buttonGroup.clearSelection();
		jTextField_tienluong.setText("");
	}

	private void xoanv(){
		// TODO Auto-generated method stub
		int hang = table.getSelectedRow();
		if(hang!=-1)
		{
			//int maNv= Integer.parseInt(table.getValueAt(hang, 0)+"");
			int anw = JOptionPane.showConfirmDialog(this, "Có muốn xoá không? ");
			if(anw ==JOptionPane.YES_OPTION )
			{
				danhSachNhanVien.xoaViTri(hang);
				tableModel.removeRow(hang);
				xoaTrang();
			}
		} else {
				JOptionPane.showConfirmDialog(this, "Chọn dòng cần xoá");
			}
	}

	private void themnv() throws Exception{
		// TODO Auto-generated method stub
		String maNv= jTextField_ma.getText();
		String ho= jTextField_ho.getText();
		String ten= jTextField_ten.getText();
		int tuoi = Integer.parseInt(jTextField_tuoi.getText());
		String phai = "";
		if(jRadioButton_nam.isSelected()) {
			phai = jRadioButton_nam.getText();
		}else {
			phai = jRadioButton_nu.getText();
		}
		double tienluong= Double.parseDouble(jTextField_tienluong.getText());		
		NhanVien nv = new NhanVien(maNv, ho, ten, tuoi, phai, tienluong);

		if(maNv.trim().equals("")){
				
				
			JOptionPane.showMessageDialog(this, "Nhập liệu sai", "Cảnh báo", JOptionPane.INFORMATION_MESSAGE);
			JOptionPane.showMessageDialog(this, "Vui lòng nhập lại!", "Nhắc nhở", JOptionPane.INFORMATION_MESSAGE);
			xoaTrang();
				return;
		}		
		 if(danhSachNhanVien.themNv(nv)) {
			Object[] obj = new Object[6];
 			obj[0]=	maNv;
			obj[1]=	ho;
			obj[2]=	ten;
			obj[3]=	Integer.toString(tuoi);
			obj[4]=	phai;
			obj[5]=	Double.toString(tienluong);
			int check = JOptionPane.showConfirmDialog(this, "Thêm thành công nhân viên");
				
			
			if(check==JOptionPane.YES_OPTION)
			{
					tableModel.addRow(obj);
					

			}
		}else {
			JOptionPane.showConfirmDialog(this, "Lỗi id trùng");
			jTextField_ma.setText("");
		}	
	}

}
