package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import Controller.NhanVienController;
import Controller.NhanVienControllerMouseListener;
import model.NhanVien;
import model.QLNVModel;

public class NhanVienView extends JFrame implements ActionListener{

	public QLNVModel qlnvModel;
	public List<QLNVModel> ds;
	public NhanVien nhanVienModel;
	public JTable table;
    public DefaultTableModel tableModel;
    public JTextField txtTim;
	public JButton btnThem;
	public JButton btnXoaTrang;
	public JButton btnLuu;
	public JButton btnXoa;
	public JTextField jtf_t6;
	public JTextField jtf_t4;
	public JTextField jtf_t3;
	public JTextField jtf_t2;
	public JTextField jtf_t1;
	public JRadioButton jrb_gtnu;
	public JRadioButton jrb_gtnam;
	public ButtonGroup bg_gt;
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
		hienThiTTLenKhung();
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
			jtf_t4.setBounds(82,100,500,20);
			
			JLabel jl_t5 = new JLabel("Phái:");
			jl_t5.setBounds(590,100,100,20);

			jrb_gtnam = new JRadioButton("Nam");
			jrb_gtnam.setBounds(650,100,90,20);
			
			jrb_gtnu = new JRadioButton("Nữ");
			jrb_gtnu.setBounds(739,100,90,20);
			
			bg_gt = new ButtonGroup();
			bg_gt.add(jrb_gtnam);
			bg_gt.add(jrb_gtnu);


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
			jp_center.add(jrb_gtnam);
			jp_center.add(jrb_gtnu);
			
			
			jp_center.add(jl_t6);			
			jp_center.add(jtf_t6);

	        tableModel = new DefaultTableModel();
	        tableModel.addColumn("Mã NV");
	        tableModel.addColumn("Họ");
	        tableModel.addColumn("Tên");
	        tableModel.addColumn("Phái");
	        tableModel.addColumn("Tuổi");
	        tableModel.addColumn("Tiền lương");
	        
	        //TableColumn column = table.getColumnModel().getColumn(3);
	        
//	        JComboBox combox = new JComboBox();
//	        combox.addItem("Nam");
//	        combox.addItem("Nữ");
//	        JRadioButton jrb_nam = new JRadioButton("Nam");
//	        for(int i = 0; i<1;i++) {
//	        	tableModel.addRow(new Object[] {"", ""});
//	        }
//	        
	        table = new JTable(tableModel);
	        NhanVienControllerMouseListener nvcm = new NhanVienControllerMouseListener(this);
	        JScrollPane jsp = new JScrollPane(table);
	        jsp.addMouseListener(nvcm);
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
	/*
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
		//this.qlnvModel.insert(nv);
//		String pt [] = {Integer.toString(nhanVienModel.getMaNV()), nhanVienModel.getHo(),
//				nhanVienModel.getTen(), Boolean.toString(nhanVienModel.getPhai()), Integer.toString(nhanVienModel.getTuoi()), nhanVienModel.getTienLuong()+"" };
//		this.tableModel.addRow(pt);
//		xoaTrang();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.addRow(new Object[] {
				nv.getMaNV(),
				nv.getHo(),
				nv.getTen(),
				nv.getPhai(),
				nv.getTuoi(),
				nv.getTienLuong(),
		});
	}
	public void themNhanhvienvaobang(NhanVien nv) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		this.qlnvModel.insert(nv);
	}
	public void thucHienThemnv() {
		Integer maso = Integer.parseInt(this.jtf_t1.getText());
		String ho = this.jtf_t2.getText();
		String ten = this.jtf_t3.getText();
		boolean phai = this.jrb_gt.isSelected() ? true : false;
		int tuoi = Integer.parseInt(this.jtf_t4.getText());
		Double luong = Double.parseDouble(this.jtf_t6.getText());
		NhanVien nv = new NhanVien(maso, ho, ten, false, tuoi, luong);
		this.themNhanhvienvaobang(nv);
	}
	*/
	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if(src.equals("Thêm"))
		{
			this.themnv();
		}else if(src.equals("Xoá"))
		{
			this.xoanv();
		}else if(src.equals("Xoá trắng"))
		{
			this.xoaTrang();
		}else {
			this.luu();
		}
		
	}
	public void luu() {
		// TODO Auto-generated method stub
		
	}
	public void xoaTrang() {
		jtf_t4.setText("");
		jtf_t3.setText("");
		jtf_t2.setText("");
		jtf_t1.setText("");
		bg_gt.clearSelection();
		jtf_t6.setText("");
		
	}
	public void chonHangNV() {
		int hang = table.getSelectedRow();
		int maNv= Integer.parseInt((String)table.getModel().getValueAt(hang, 0));

	}
	public void xoanv() {
		//int anw = JOptionPane.showConfirmDialog(rootPane, "Có muốn xoá không ");
		// hiện thi YES NO  K HIỂN THI CANEL 
		int hang = table.getSelectedRow();
		int anw = JOptionPane.showConfirmDialog(rootPane, "Có muốn xoá không? ","Cảnh báo", JOptionPane.YES_NO_OPTION);
		if(anw ==JOptionPane.YES_OPTION )
		{
			if(qlnvModel.removeNV(anw))
			{
				tableModel.removeRow(hang);
			}
		
		}
		
	}
	public void themnv() {
		int maNv= Integer.valueOf(jtf_t1.getText());
		String ho= jtf_t2.getText();
		String ten= jtf_t3.getText();
		boolean phai= (jrb_gtnam.isSelected());
		int tuoi = Integer.parseInt(jtf_t4.getText());
		double tienluong= Double.parseDouble(jtf_t6.getText());
		NhanVien nv = new NhanVien(maNv, ho, ten, phai, tuoi, tienluong);
		if(qlnvModel.insert(nv)) {
			String hang[]= {
					Integer.toString(maNv),
					ho,
					ten,
					(nv.getPhai()?"Nam":"Nữ"),
					Integer.toString(tuoi),
					tienluong+""
				};
			tableModel.addRow(hang);
		}	 
			
	}
	public void hienThiTTLenKhung() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		model_table.getValueAt(i_row, 0);
		int maNv= Integer.valueOf(model_table.getValueAt(i_row, 0)+"");
		String ho= model_table.getValueAt(i_row, 1)+"";
		String ten= model_table.getValueAt(i_row, 2)+"";
		boolean phai= (jrb_gtnam.isSelected());
		int tuoi = Integer.valueOf(model_table.getValueAt(i_row, 4)+"");
		double tienluong= Double.parseDouble(model_table.getValueAt(i_row, 5)+"");
		
		NhanVien nv = new NhanVien(maNv, ho, ten, phai, tuoi, tienluong);
		this.jtf_t1.setText(maNv+"");
		this.jtf_t2.setText(ho+"");
		this.jtf_t3.setText(ten+"");
		this.jtf_t4.setText(tuoi+"");
		if(phai)
		{
			jrb_gtnam.setSelected(true);
		}else {
			jrb_gtnu.setSelected(false);

		}
		this.bg_gt.setSelected(null, phai);
		this.jtf_t6.setText(tienluong+"");
	}
}
