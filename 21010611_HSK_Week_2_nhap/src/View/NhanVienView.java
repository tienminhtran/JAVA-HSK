package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import Controller.NhanVienController;
import model.NhanVien;
import model.QLNVModel;

public class NhanVienView extends JFrame{

	public QLNVModel qlnvModel;
	private NhanVien nhanVienModel;
    private JTable table;
    private DefaultTableModel tableModel;
	private JTextField txtTim;
	private JButton btnThem;
	private JButton btnXoaTrang;
	private JButton btnLuu;
	private JButton btnXoa;
	public JTextField jtf_t6;
	public JRadioButton jrb_gt;
	public JTextField jtf_t4;
	public JTextField jtf_t3;
	public JTextField jtf_t2;
	public JTextField jtf_t1;
    public NhanVienView() {
		this.qlnvModel = new QLNVModel();
		this.setTitle("^-^");
		this.setSize(800,480);
		this.setAutoRequestFocus(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.Init();
		
		this.setResizable(false);		
		this.setVisible(true);
	}
	private void Init() {
		
		// sự kiện
		
		NhanVienController nvc = new NhanVienController(this);
		
		
		Font f = new Font("Arial", Font.BOLD , 40);

		JPanel jp_head = new JPanel();
		jp_head.setLayout(new BorderLayout());
		JLabel jl_title = new JLabel("THÔNG TIN NHÂN VIÊN", JLabel.CENTER);
		jl_title.setForeground(Color.BLUE);
		jl_title.setFont(f);
		jp_head.add(jl_title, BorderLayout.CENTER);
		
		JPanel jp_center = new JPanel();
		jp_center.setLayout(null);
		
			JLabel jl_t1 = new JLabel("Mã nhân viên:");
			jl_t1.setBounds(0,40,80,20);
			jtf_t1 = new JTextField();
			jtf_t1.setBounds(82,40,700,20);

			JLabel jl_t2 = new JLabel("Họ:");
			jl_t2.setBounds(0,70,80,20);
			 jtf_t2 = new JTextField();
			jtf_t2.setBounds(82,70,250,20);
			JLabel jl_t3 = new JLabel("Tên nhân viên:");
			jl_t3.setBounds(333,70,90,20);
			jtf_t3 = new JTextField();
			jtf_t3.setBounds(423,70,360,20);
			
			JLabel jl_t4 = new JLabel("Tuổi:");
			jl_t4.setBounds(0,100,80,20);
			jtf_t4 = new JTextField();
			jtf_t4.setBounds(82,100,600,20);
			
			JLabel jl_t5 = new JLabel("Phái:");
			jl_t5.setBounds(680,100,449,20);

			jrb_gt = new JRadioButton("Nữ");
			jrb_gt.setBounds(739,100,449,20);

			JLabel jl_t6 = new JLabel("Tiền lương:");
			jl_t6.setBounds(0,130,80,20);
			jtf_t6 = new JTextField();
			jtf_t6.setBounds(82,130,700,20);
			
			jp_center.add(jl_t1);
			jp_center.add(jtf_t1);
			jp_center.add(jl_t2);
			jp_center.add(jtf_t2);

			jp_center.add(jl_t3);
			jp_center.add(jtf_t3);

			jp_center.add(jl_t4);
			jp_center.add(jtf_t4);
			
			
			
			jp_center.add(jl_t5);
			jp_center.add(jrb_gt);
			
			jp_center.add(jl_t6);			
			jp_center.add(jtf_t6);

	        tableModel = new DefaultTableModel();
	        tableModel.addColumn("Mã NV");
	        tableModel.addColumn("Họ");
	        tableModel.addColumn("Tên");
	        tableModel.addColumn("Phái");
	        //JComboBox<E>
	        tableModel.addColumn("Tuổi");
	        tableModel.addColumn("Tiền lương");
			
	        for(int i = 0; i<1;i++) {
	        	tableModel.addRow(new Object[] {"", ""});
	        }
//	        
	        table = new JTable(tableModel);
	        
	        JScrollPane jsp = new JScrollPane(table);
	        jsp.setBounds(0, 160, 800, 200);
			jp_center.add(jsp);

/*
			JPanel jp_bot = new JPanel();
			
			jp_bot.setLayout(new GridLayout(1,2));

				JPanel jp_bot_trai = new JPanel();
				jp_bot_trai.setLayout(new GridLayout(1, 3));
				jp_bot_trai.setBorder(new LineBorder(Color.BLACK, 2)); // MÀU VIỀN
//				jp_bot_trai.setBackground(Color.red);
	
					JLabel jl_khungtim = new JLabel("Nhập mã số cần tìm:");
//					jl_khungtim.setBounds(0, 400, 180, 20);
		
					JTextField jtf_khungtim = new JTextField(20);
//					jtf_khungtim.setBounds(121, 400, 200, 20);
		
					JButton jb_khungtim = new JButton("Tìm");
//					jb_khungtim.setBounds(330, 400, 70, 20);

					jp_bot_trai.add(jl_khungtim);
					jp_bot_trai.add(jtf_khungtim);
					jp_bot_trai.add(jb_khungtim);
			
			
					jp_bot.add(jp_bot_trai);

			

				JPanel jp_bot_phai = new JPanel();;
				jp_bot_phai.setLayout(new BoxLayout(jp_bot_phai, BoxLayout.X_AXIS));
				jp_bot_phai.setBorder(new LineBorder(Color.BLACK, 2)); // MÀU VIỀN

				jp_bot_phai.add(Box.createHorizontalGlue());

					JButton jb_them = new JButton("Thêm");

					
					
					JButton jb_xoatrang = new JButton("Xoá trắng");
					JButton jb_xoa = new JButton("Xoá");
					JButton jb_luu = new JButton("Lưu");
					JPanel jb_r1 = new JPanel();
					//JButton jb_r1 = new JButton("");

					jp_bot_phai.add(jb_them);
					jp_bot_phai.add(jb_xoatrang);
					jp_bot_phai.add(jb_xoa);
					jp_bot_phai.add(jb_luu);
					jp_bot_phai.add(jb_r1);

			
					jp_bot.add(jp_bot_phai);
		
	*/
			JSplitPane jspane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
			
				JPanel jp_bot_trai = new JPanel();
					JLabel jl_khungtim = new JLabel("Nhập mã số cần tìm:");
					JTextField jtf_khungtim = new JTextField(20);
					JButton jb_khungtim = new JButton("Tìm");
					
					
					jp_bot_trai.add(jl_khungtim);
					jp_bot_trai.add(jtf_khungtim);
					jp_bot_trai.add(jb_khungtim);
				
				JPanel jp_bot_phai = new JPanel();
					JButton jb_them = new JButton("Thêm");
					jb_them.addActionListener(nvc);
					
					JButton jb_xoatrang = new JButton("Xoá trắng");
					jb_xoatrang.addActionListener(nvc);

					JButton jb_xoa = new JButton("Xoá");
					jb_xoa.addActionListener(nvc);

					JButton jb_luu = new JButton("Lưu");
					jb_luu.addActionListener(nvc);
					
					jp_bot_phai.add(jb_them);
					jp_bot_phai.add(jb_xoatrang);
					jp_bot_phai.add(jb_xoa);
					jp_bot_phai.add(jb_luu);
			jspane.add(jp_bot_trai);
			jspane.add(jp_bot_phai);
			


			
		this.setLayout(new BorderLayout());
		this.add(jp_head, BorderLayout.NORTH);
		this.add(jp_center, BorderLayout.CENTER);
		this.add(jspane, BorderLayout.SOUTH);

	}
	public void xoaTrang() {
		// TODO Auto-generated method stub
		jtf_t4.setText("");
		jtf_t3.setText("");
		jtf_t2.setText("");
		jtf_t1.setText("");
		jrb_gt.setSelected(false);
		jtf_t6.setText("");

	}
	public void them(NhanVien nv) {
		this.qlnvModel.insert(nv);
		String pt [] = {Integer.toString(nhanVienModel.getMaNV()), nhanVienModel.getHo(),
				nhanVienModel.getTen(), Boolean.toString(nhanVienModel.getPhai()), Integer.toString(nhanVienModel.getTuoi()), nhanVienModel.getTienLuong()+"" };
		this.tableModel.addRow(pt);
//		DefaultTableModel model = (DefaultTableModel) table.getModel();
//		model.addRow(new Object[] {
//				nv.getMaNV()+"",
//				nv.getHo(),
//				nv.getTen(),
//				nv.getPhai(),
//				nv.getTuoi()+"",
//				nv.getTienLuong()+"",
//		});
	}
	

}
