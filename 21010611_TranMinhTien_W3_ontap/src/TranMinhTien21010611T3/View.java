package TranMinhTien21010611T3;

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
	private Databasee databasee;
	
	public View() {
		this.databasee = new Databasee();
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
						
						b = Box.createVerticalBox(); //trục d�?c
							b1 = Box.createHorizontalBox();// trục ngang
							b2 = Box.createHorizontalBox();// trục ngang
							b3 = Box.createHorizontalBox();// trục ngang
							b4 = Box.createHorizontalBox();// trục ngang
					//b là nguyên chương trình chính add hết b1, b2, b3, b4
					b.add(b1);
					b.add(b2);
					b.add(b3);
					b.add(b4);

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
	
	}


	
}
