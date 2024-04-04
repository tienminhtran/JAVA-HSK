package K16_GK;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class Gui extends JFrame implements ActionListener, MouseListener{

	private QuanLySach quanLySach;
	private JLabel jLabel_maSach;
	private JLabel jLabel_soTrang;
	private JLabel jLabel_theLoai;
	private JLabel jLabel_tenSach;
	private JLabel jLabel_nhaXuatBan;
	private JTextField jTextField_maSach;
	private JTextField jTextField_tenSach;
	private JTextField jTextField_soTrang;
	private JComboBox jComboBox_theloai;
	private JTextField jTextField_nhaXuatBan;
	private DefaultTableModel tableModel;
	private JTable jTable;
	private JButton jButton_them;
	private JButton jButton_xoarong;
	private JButton jButton_xoa;
	private JButton jButton_luu;
	private JButton jButton_tim;
	private JTextField jTextField_tim;
	private JLabel jLabel_tim;
	private Databasee databasee;
	private JButton jButton_huy;
	private JButton jButton_huytim;

	public Gui() {
		quanLySach = new QuanLySach();		
		this.databasee = new Databasee();

		this.setTitle("Kiểm tra Giữa Kỳ Trần Minh Tiến - 21010611");
		this.setSize(800,500);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.init();
		this.setVisible(true);
		try {
			loadData();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	private void init() {
		JPanel jPanel_title = new JPanel();
			JLabel jLabel_title = new JLabel("THÔNG TIN SÁCH");
			jPanel_title.add(jLabel_title);
		this.add(jPanel_title, BorderLayout.NORTH);
		JPanel jPanel_center = new JPanel();
			jPanel_center.setLayout(new BorderLayout());
				JPanel jPanel_combobox = new JPanel();
					jPanel_combobox.setLayout(new BorderLayout());

					 jLabel_maSach = new JLabel("Mã sách:        ");
					 jLabel_tenSach = new JLabel("Tên sách:");
					 jLabel_soTrang = new JLabel("Số trang:");
					 jLabel_theLoai= new JLabel("Thể loại: ");
					 jLabel_nhaXuatBan = new JLabel("Nhà xuất bản:");
					
					 jTextField_maSach = new JTextField(62);
					 jTextField_tenSach = new JTextField();
					 jTextField_soTrang = new JTextField();
					String theloai[]= {"Toán", "Tin học", "Hóa học", "Sinh học"};
					 jComboBox_theloai = new JComboBox<>(theloai);
					 jTextField_nhaXuatBan = new JTextField();
					
					BoxLayout boxLayout = new BoxLayout(jPanel_combobox, BoxLayout.Y_AXIS);
					Box b, b1, b2, b3;
					b = Box.createVerticalBox();
						b1 = Box.createHorizontalBox();
						b2 = Box.createHorizontalBox();
						b3 = Box.createHorizontalBox();
					
						b1.add(jLabel_maSach);
						b1.add(jTextField_maSach);	
						jTextField_maSach.setPreferredSize(jLabel_maSach.getPreferredSize());
						
						b2.add(jLabel_tenSach);
						jLabel_tenSach.setPreferredSize(jLabel_maSach.getPreferredSize());

						b2.add(jTextField_tenSach);
						jTextField_tenSach.setPreferredSize(jLabel_maSach.getPreferredSize());

						b2.add(jLabel_soTrang);

						b2.add(jTextField_soTrang);
						
						b3.add(jLabel_theLoai);
						jLabel_theLoai.setPreferredSize(jLabel_maSach.getPreferredSize());

						b3.add(jComboBox_theloai);	
						jComboBox_theloai.setPreferredSize(jLabel_maSach.getPreferredSize());

						b3.add(jLabel_nhaXuatBan);
						b3.add(jTextField_nhaXuatBan);	
					b.add(b1);
					b.add(b2);
					b.add(b3);
					
					jPanel_combobox.add(b);
					jPanel_center.add(jPanel_combobox, BorderLayout.NORTH);
					
				JPanel jPanel_table = new JPanel();
				jPanel_table.setLayout(new BorderLayout());

				
				 tableModel = new DefaultTableModel();
				tableModel.addColumn("Mã sách");
				tableModel.addColumn("Tên sách");
				tableModel.addColumn("Số trang");
				tableModel.addColumn("Thể loại");
				tableModel.addColumn("Nhà xuất bản");
					
				 jTable= new JTable(tableModel);
				JScrollPane jsp = new JScrollPane(jTable);
				jPanel_table.add(jsp);
				jPanel_center.add(jPanel_table, BorderLayout.CENTER);

					
				JPanel jPanel_bt = new JPanel();
					 jButton_them = new JButton("Thêm");
					 jButton_xoarong = new JButton("Xóa rỗng");
					 jButton_xoa = new JButton("Xoá");
					 jButton_luu = new JButton("Lưu");
					 jButton_tim = new JButton("Tìm");
					 jButton_huytim = new JButton("Hủy tìm");
					 jTextField_tim = new JTextField(20);
					 jLabel_tim = new JLabel("Nhập mã sách cần tìm:");
				jPanel_bt.add(jLabel_tim);
				jPanel_bt.add(jTextField_tim);
				jPanel_bt.add(jButton_tim);
				jPanel_bt.add(jButton_them);
				jPanel_bt.add(jButton_xoarong);
				jPanel_bt.add(jButton_xoa);
				jPanel_bt.add(jButton_luu);
				
				
				
				this.add(jPanel_center, BorderLayout.CENTER);
				this.add(jPanel_bt, BorderLayout.SOUTH);
				
				//xự kiện
				jButton_them.addActionListener(this);
				jButton_xoarong.addActionListener(this);
				jButton_xoa.addActionListener(this);
				jButton_luu.addActionListener(this);
				jButton_tim.addActionListener(this);
				jButton_huytim.addActionListener(this);
				
				this.jTable.addMouseListener(this);
//				jButton_huytim.addMouseListener(this);

	}	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row= jTable.getSelectedRow();
		if(row!=-1) {
			jTextField_maSach.setText(jTable.getValueAt(row, 0).toString());
			jTextField_tenSach.setText(jTable.getValueAt(row, 1).toString());
			jTextField_soTrang.setText(jTable.getValueAt(row, 2).toString());
			jComboBox_theloai.setSelectedItem(jTable.getValueAt(row, 3));
			jTextField_nhaXuatBan.setText(jTable.getValueAt(row, 4).toString());
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
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String src = e.getActionCommand();
		if(src.equals("Thêm")) {
			themSach();
		}else if(src.equals("Xóa rỗng")) {
			xoaTrang();
		}else if(src.equals("Lưu")) {
			databasee.savefile("QLS.dat", quanLySach);
		}else if(src.equals("Xoá")) {
			xoa();
		}else if(src.equals("Tìm")) {
			tim();
		}
			else if(src.equals("Hủy tìm")) {
			try {
				huytim();
				jButton_tim.setText("Tìm");

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}	
	public void themSach() {
		String maSach = jTextField_maSach.getText();
		String tenSach = jTextField_tenSach.getText();
		int soTrang = Integer.parseInt(jTextField_soTrang.getText());
		String theLoai = (String) jComboBox_theloai.getSelectedItem();
		String nhaXuatBan = jTextField_nhaXuatBan.getText();
		Sach s = new Sach(maSach, tenSach, soTrang, theLoai, nhaXuatBan);
		if(soTrang>0)
		{
			if(!maSach.trim().equals("") && !tenSach.trim().equals("")&&  !theLoai.trim().equals("") && !nhaXuatBan.trim().equals("")) {
				if(quanLySach.themSach(s)) {
					Object obj[] = new Object[5];
					obj[0] = maSach;
					obj[1] = tenSach;
					obj[2] = Integer.toString(soTrang);
					obj[3] = theLoai;
					obj[4] = nhaXuatBan;
					JOptionPane.showConfirmDialog(this, "Thêm thành công");
					tableModel.addRow(obj);
				}
			}else {
				JOptionPane.showConfirmDialog(this, "Dữ liệu không được rỗng");
			}
		}else {
			JOptionPane.showConfirmDialog(this, "Số trang lớn 0");
		}


	}
	public void xoaTrang() {
		jTextField_maSach.setText(" ");
		jTextField_tenSach.setText(" ");
		jTextField_soTrang.setText(" ");
		jTextField_nhaXuatBan.setText(" ");
		jComboBox_theloai.setSelectedIndex(0);
	}
	public void xoa() {
		int hang = jTable.getSelectedRow();
		if(hang!=-1) {
			 int src = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa không");
			if(src == JOptionPane.YES_OPTION) {
				quanLySach.xoaSach(hang);
				tableModel.removeRow(hang);
				xoaTrang();
			}
		}else {
			 JOptionPane.showConfirmDialog(this, "Chọn một dòng cần xóa");
		}
		
	}
	public void tim() {
		String maSachTim = jTextField_tim.getText();
		Sach s = quanLySach.timSach(maSachTim);
		if(!maSachTim.trim().equals(""))
		{
				if(s!=null) {
				String hang[] = {s.getMaSach(), s.getTenSach(), s.getSoTrang()+"", s.getTheLoai(), s.getNhaXuatBan()};
				for(int i = 0; i<jTable.getRowCount();i++)
				{
					jTable.getSelectionModel().setSelectionInterval(i, i);
//					JOptionPane.showConfirmDialog(this, "Tìm thấy");

				}
				}else {
					JOptionPane.showConfirmDialog(this, "Không tìm thấy");
			}
		}else {
			JOptionPane.showConfirmDialog(this, "Nhập mã tìm");
		}	
	}
	//TÌM LẤY 1 DÒNG
	/*
	public void tim() {
		String maSachTim = jTextField_tim.getText();
		Sach s = quanLySach.timSach(maSachTim);
		if(!maSachTim.trim().equals(""))
		{
				if(s!=null) {
				tableModel.setRowCount(0);
				String hang[] = {s.getMaSach(), s.getTenSach(), s.getSoTrang()+"", s.getTheLoai(), s.getNhaXuatBan()};
				tableModel.addRow(hang);
				jButton_huytim.setEnabled(false);
				jButton_tim.setText("Hủy tìm");
				jTable.setRowSelectionInterval(0, 0);
				for(int i = 0; i<jTable.getRowCount();i++)
				{
					mouseClicked(null);

				}
				}else {
					JOptionPane.showConfirmDialog(this, "Không tìm thấy");
			}
		}else {
			JOptionPane.showConfirmDialog(this, "Nhập mã tìm");
		}
	}
	*/
	//tìm k trưc tiếp trên hàng không dùng hàm trên danh sách
//	private void tim() {
//	String key = jComboBox.getSelectedItem().toString();
//	for (int i = 0; i < table.getRowCount(); i++) {
//		String code = (String) table.getValueAt(i, 0);
//		if (key.equals(code)) {
//			table.getSelectionModel().setSelectionInterval(i, i);
//			table.repaint();
//		}
//	}
//}
	//tìm theo kiểu int:
	/*
	private void tim() {
		int pos = danhSachNhanVien.timKiem(this.jtf_khungtim.getText());
		if(pos==-1) {
			JOptionPane.showConfirmDialog(this, "Không tìm thấy id cần tìm", "Thông báo", JOptionPane.OK_CANCEL_OPTION);
		}else {
			JOptionPane.showMessageDialog(this, "Tìm thấy nhân viên");
			table.setRowSelectionInterval(pos, pos);
		}
	}
	*/
	public void huytim() throws Exception {
		tableModel.removeRow(0);
		loadData();
	}
	public void loadData() throws Exception {
		quanLySach=null;
		quanLySach= (QuanLySach) databasee.readfile("QLS.dat");
		if(quanLySach==null) {
			quanLySach = new QuanLySach();
		}else {
			for (Sach s : quanLySach.getDs()) {
				String hang[] = {s.getMaSach(), s.getTenSach(), s.getSoTrang()+"", s.getTheLoai(), s.getNhaXuatBan()};
				tableModel.addRow(hang);
			}
		}
		
	}
	public static void main(String[] args) {
		new Gui();
		
	}
	

}
