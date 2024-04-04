package BTLon_newa;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class NhanVien extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NhanVien frame = new NhanVien();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private JPanel contentPane;
	private JLabel jlabel_timKiem;
	private JLabel jLabel_maNV;
	private JTextField jTextField_maNV;

	/**
	 * Create the frame.
	 */
	public NhanVien() {
		setSize(900, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
//		setBounds(0, -15, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder("Nhập thông tin nhân viên"));
		panel.setToolTipText("Thông tin");
		panel.setBounds(10, 33, 874, 140);
		contentPane.add(panel);
		panel.setLayout(null);

		jlabel_timKiem = new JLabel("Tìm kiếm:");
		jlabel_timKiem.setFont(new Font("Tahoma", Font.BOLD, 11));
		jlabel_timKiem.setBounds(193, 13, 77, 17);
		panel.add(jlabel_timKiem);

		JTextField jTextField_timKiem = new JTextField();
		jTextField_timKiem.setBounds(270, 11, 406, 20);
		panel.add(jTextField_timKiem);
		jTextField_timKiem.setColumns(10);

		jLabel_maNV = new JLabel("Mã NV:");
		jLabel_maNV.setFont(new Font("Tahoma", Font.BOLD, 11));
		jLabel_maNV.setBounds(10, 52, 54, 21);
		panel.add(jLabel_maNV);

		jTextField_maNV = new JTextField();
		jTextField_maNV.setBounds(65, 52, 137, 20);
		panel.add(jTextField_maNV);
		jTextField_maNV.setColumns(10);

		JTextField jTextField_tenNV = new JTextField();
		jTextField_tenNV.setBounds(259, 51, 213, 20);
		panel.add(jTextField_tenNV);
		jTextField_tenNV.setColumns(10);

		JLabel jLabel_tenNV = new JLabel("Tên NV:");
		jLabel_tenNV.setFont(new Font("Tahoma", Font.BOLD, 11));
		jLabel_tenNV.setBounds(213, 51, 54, 21);
		panel.add(jLabel_tenNV);

		JLabel jLabel_sdt = new JLabel("SĐT:");
		jLabel_sdt.setFont(new Font("Tahoma", Font.BOLD, 11));
		jLabel_sdt.setBounds(485, 52, 70, 21);
		panel.add(jLabel_sdt);

		JTextField jTextField_sdt = new JTextField();
		jTextField_sdt.setBounds(550, 52, 122, 20);
		panel.add(jTextField_sdt);
		jTextField_sdt.setColumns(10);

		JLabel jLabel_gioiTinh = new JLabel("Giới tính:");
		jLabel_gioiTinh.setFont(new Font("Tahoma", Font.BOLD, 11));
		jLabel_gioiTinh.setBounds(685, 52, 54, 21);
		panel.add(jLabel_gioiTinh);

		JRadioButton rdbtnNam = new JRadioButton("Nam");
		rdbtnNam.setBounds(740, 50, 54, 23);
		panel.add(rdbtnNam);

		JRadioButton rdbtnNu = new JRadioButton("Nữ");
		rdbtnNu.setBounds(800, 50, 47, 23);
		panel.add(rdbtnNu);

		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnNam);
		buttonGroup.add(rdbtnNu);
		
		JLabel jLabel_diaChi = new JLabel("Địa chỉ:");
		jLabel_diaChi.setFont(new Font("Tahoma", Font.BOLD, 11));
		jLabel_diaChi.setBounds(10, 83, 54, 21);
		panel.add(jLabel_diaChi);
		
		
		

		JTextField jTextField_diaChi = new JTextField();
		jTextField_diaChi.setBounds(65, 83, 406, 20);
		panel.add(jTextField_diaChi);
		jTextField_diaChi.setColumns(10);

		JLabel jLabel_email = new JLabel("Email:");
		jLabel_email.setFont(new Font("Tahoma", Font.BOLD, 11));
		jLabel_email.setBounds(485, 83, 70, 21);
		panel.add(jLabel_email);

		JTextField jTextField_email = new JTextField();
		jTextField_email.setBounds(550, 83, 200, 21);
		panel.add(jTextField_email);
		jTextField_email.setColumns(10);
		
		

		

//		jLabel_gioiTinh = new JLabel("Giới tính:");
//		jLabel_chucVu.setFont(new Font("Tahoma", Font.BOLD, 11));
//		jLabel_chucVu.setBounds(10, 113, 54, 21);
//		panel.add(jLabel_chucVu);
//
//		JComboBox cb_chucVu = new JComboBox();
//		cb_chucVu.addItem("Quản lý");
//		cb_chucVu.setBounds(65,113,137,20);
//		panel.add(cb_chucVu);

//		JTextField jTextField_ngaySinh = new JTextField();
//		jTextField_ngaySinh.setBounds(550, 83, 122, 20);
//		panel.add(jTextField_ngaySinh);
//		jTextField_ngaySinh.setColumns(10);
		
		JButton button_loc = new JButton("Lọc");
//		button_loc.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
		button_loc.setBounds(684, 10, 89, 23);
		panel.add(button_loc);
//		
//		Canvas canvas = new Canvas();
//		canvas.setBounds(20, -28, 47, 23);
//		panel.add(canvas);
//
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 172, 874, 45);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JButton jButton_them = new JButton("Thêm");
		jButton_them.setForeground(new Color(0, 0, 0));
		jButton_them.setBackground(new Color(128, 255, 255));
		jButton_them.setBounds(195, 11, 89, 23);
		panel_1.add(jButton_them);

		JButton jButton_sua = new JButton("Xóa");
		jButton_sua.setBackground(new Color(0, 255, 128));
		jButton_sua.setBounds(350, 11, 89, 23);
		panel_1.add(jButton_sua);
		
		JButton jButton_xoa = new JButton("Sửa");
		jButton_xoa.setBackground(new Color(255, 128, 128));
		jButton_xoa.setBounds(508, 11, 89, 23);
		panel_1.add(jButton_xoa);

		JButton jButton_lamMoi = new JButton("Làm mới");
		jButton_lamMoi.setBackground(new Color(255, 128, 128));
		jButton_lamMoi.setBounds(655, 11, 89, 23);
		panel_1.add(jButton_lamMoi);
	
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 228, 874, 265);
		

		DefaultTableModel  tableModel = new DefaultTableModel();
		tableModel.addColumn("Mã NV");
		tableModel.addColumn("Tên NV");
		tableModel.addColumn("SĐT");
		tableModel.addColumn("Giới tính");
		tableModel.addColumn("Địa chỉ");
		tableModel.addColumn("Email");
		panel_2.setLayout(null);
		JTable table = new JTable(tableModel);
		JScrollPane jbs = new JScrollPane(table);
		jbs.setBounds(0, 5, 874, 252);
		panel_2.add(jbs);		
		contentPane.add(panel_2);
		
		JLabel lblNewLabel_1 = new JLabel(" @ Copy rigth _ Mua bán link kiện");
		lblNewLabel_1.setBackground(new Color(240, 240, 240));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel_1.setBounds(400, 536, 202, 14);
		contentPane.add(lblNewLabel_1);

	}
}

