package BTLon_newa;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class BanHang extends JFrame {

	private JPanel contentPane;
	private JLabel jLabel_loaihang,jLabel_timkiem, jLabel_nhacc, jLabel_sl,  jLabel_ten, jLabel_ma, jLabel_gia;
	private JTextField jtext_nhacc, jtext_sl,  jtext_ten, jtext_ma, jtext_gia, jtext_tim;
	private JComboBox combo_loaihang;
	private JButton jbt_them, jbt_xoa, jbt_sua, jbt_lamMoi, jbt_tim;
	private JTable table_mh;
	private DefaultTableModel model_mh;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BanHang frame = new BanHang();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BanHang() {
		setTitle("Mặt hàng");
		setSize(900,600);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//combonent
		jLabel_loaihang = new JLabel("Loại hàng: ");
		jLabel_nhacc = new JLabel("Nhà cung cấp:");
		jLabel_sl = new JLabel("Số lượng:");
		jLabel_ten = new JLabel("Tên hàng:");
		jLabel_ma = new JLabel("Mã hàng:");
		jLabel_gia = new JLabel("Giá:");
		jLabel_timkiem = new JLabel("Tìm kiếm:");
		
		jtext_nhacc  = new JTextField();
		jtext_nhacc.setPreferredSize(new Dimension(0,28));
		jtext_sl= new JTextField(); 
		jtext_sl.setPreferredSize(new Dimension(0,28));

		jtext_ten= new JTextField();
		jtext_ma= new JTextField(); 
		jtext_gia= new JTextField(); 
		jtext_gia.setPreferredSize(new Dimension(0,28));

		jtext_tim= new JTextField(30);
		jtext_tim.setPreferredSize(new Dimension(0,28));
		
		jbt_them = new JButton("Thêm");
		jbt_xoa = new JButton("Xóa");
		jbt_sua = new JButton("Sửa");
		jbt_lamMoi = new JButton("Làm mới");
		jbt_tim  =new JButton("Tìm");
		
		combo_loaihang = new JComboBox();
		combo_loaihang.addItem("            ");
		//khu vuc content
		JPanel jPanel_content = new JPanel();
			//khu vuc timkiem
			JPanel jPanel_tk = new JPanel();
//			jPanel_tk.setLayout(new BoxLayout(jPanel_tk, BoxLayout.X_AXIS));
			
			jPanel_tk.add(jLabel_timkiem);
			jPanel_tk.add(jtext_tim);
			jPanel_tk.add(jbt_tim);
			add(jPanel_tk, BorderLayout.NORTH);
			
			// khu vuc nhap lieu
			JPanel jPanel_nhaplieu = new JPanel();
			JLabel jLabel_td  = new JLabel("Nhập thông tin mặt hàng");
			jPanel_nhaplieu.add(jLabel_td);
			jPanel_nhaplieu.setLayout(new BoxLayout(jPanel_nhaplieu, BoxLayout.Y_AXIS));
			Box b_main, b1, b2;
			b_main = Box.createVerticalBox();
			b_main.add(Box.createVerticalStrut(15));
			b_main.add(b1 = Box.createHorizontalBox());
			b_main.add(Box.createVerticalStrut(15));
			b_main.add(b2 = Box.createHorizontalBox());
			b_main.add(Box.createVerticalStrut(15));
			
			b1.add(Box.createHorizontalStrut(20));
			b1.add(jLabel_ma);
			b1.add(jtext_ma);
			b1.add(Box.createHorizontalStrut(75));
			b1.add(jLabel_ten);
			b1.add(jtext_ten);
			b1.add(Box.createHorizontalStrut(100));
			b1.add(jLabel_loaihang);
			b1.add(combo_loaihang);
			b1.add(Box.createHorizontalStrut(50));

//			jLabel_ma.setPreferredSize(jLabel_nhacc.getPreferredSize());
			
			
			b2.add(Box.createHorizontalStrut(20));
			b2.add(jLabel_nhacc);
			b2.add(jtext_nhacc);
			b2.add(Box.createHorizontalStrut(80));
			b2.add(jLabel_gia);
			b2.add(jtext_gia);
			b2.add(Box.createHorizontalStrut(80));
			b2.add(jLabel_sl);
			b2.add(jtext_sl);
			b2.add(Box.createHorizontalStrut(50));

			jPanel_nhaplieu.add(b_main);
			
			Box b_bt= Box.createHorizontalBox();
			b_bt.add(jbt_them);
			b_bt.add(jbt_xoa);
			b_bt.add(jbt_sua);
			b_bt.add(jbt_lamMoi);
			
			
			jPanel_nhaplieu.add(b_bt);
			String[] colum = {"Mã MH", "Tên MH", "Loại MH", "Số lượng", "Giá", "Nhà cung cấp"};
			model_mh = new DefaultTableModel(colum, 0);
			table_mh = new JTable(model_mh);
			JScrollPane sc = new JScrollPane(table_mh, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			jPanel_nhaplieu.add(sc);

			add(jPanel_nhaplieu, BorderLayout.CENTER);
	}

}
