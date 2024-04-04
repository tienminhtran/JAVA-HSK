package BTLon_newa;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EtchedBorder;

public class HoaDonBanHang extends JFrame{

	private JPanel contentPane;
	private JTextField textField_mahd;
	private JTextField textField_masp;
	private JTextField textField_ngaydat;
	private JTextField textField_ngayhan;
	private JTextField textField_timkiem;
	private JTable table;
	private JTextField textField_ngaygiao;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HoaDonBanHang window = new HoaDonBanHang();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HoaDonBanHang() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setTitle("Hóa đơn bán hàng - Nhân viên nhập");
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
		panel.setBorder(new TitledBorder(null, "Th\u00F4ng tin \u0111\u01A1n h\u00E0ng c\u1EA7n nh\u1EADp", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setToolTipText("Thông tin");
		panel.setBounds(10, 33, 874, 140);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblTmKim = new JLabel("Tìm kiếm:");
		lblTmKim.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTmKim.setBounds(193, 13, 77, 17);
		panel.add(lblTmKim);

		textField_timkiem = new JTextField();
		textField_timkiem.setBounds(270, 11, 406, 20);
		panel.add(textField_timkiem);
		textField_timkiem.setColumns(10);

		JLabel lblNewLabel = new JLabel("Mã HD:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(20, 52, 54, 21);
		panel.add(lblNewLabel);

		textField_mahd = new JTextField();
		textField_mahd.setBounds(80, 52, 200, 20);
		panel.add(textField_mahd);
		textField_mahd.setColumns(10);

		textField_masp = new JTextField();
		textField_masp.setBounds(369, 52, 200, 20);
		panel.add(textField_masp);
		textField_masp.setColumns(10);

		JLabel lblTnKh = new JLabel("Mã KH:");
		lblTnKh.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTnKh.setBounds(305, 52, 54, 21);
		panel.add(lblTnKh);

		JLabel lblSinThoi = new JLabel("Mã NV:");
		lblSinThoi.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSinThoi.setBounds(592, 52, 54, 21);
		panel.add(lblSinThoi);

		JLabel lblaCh = new JLabel("Ngày đặt:");
		lblaCh.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblaCh.setBounds(20, 83, 54, 21);
		panel.add(lblaCh);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		
		

		textField_ngaydat = new JTextField();
		textField_ngaydat.setBounds(80, 83, 200, 20);
		panel.add(textField_ngaydat);
		textField_ngaydat.setColumns(10);

		JLabel lblEmail = new JLabel("Ngày chuyển hàng:");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmail.setBounds(20, 115, 121, 21);
		panel.add(lblEmail);

		textField_ngayhan = new JTextField();
		textField_ngayhan.setBounds(656, 83, 200, 20);
		panel.add(textField_ngayhan);
		textField_ngayhan.setColumns(10);

		JButton button_loc = new JButton("Lọc");
		button_loc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_loc.setBounds(684, 10, 89, 23);
		panel.add(button_loc);
		
		Canvas canvas = new Canvas();
		canvas.setBounds(20, -28, 47, 23);
		panel.add(canvas);
		
		textField_ngaygiao = new JTextField();
		textField_ngaygiao.setColumns(10);
		textField_ngaygiao.setBounds(369, 83, 200, 20);
		panel.add(textField_ngaygiao);
		
		JLabel lblEmail_1 = new JLabel("Ngày giao:");
		lblEmail_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmail_1.setBounds(303, 83, 66, 21);
		panel.add(lblEmail_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(656, 52, 200, 20);
		panel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(151, 115, 418, 20);
		panel.add(textField_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nơi nhận:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(589, 86, 67, 14);
		panel.add(lblNewLabel_2);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 172, 874, 45);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(128, 255, 255));
		btnNewButton.setBounds(195, 11, 89, 23);
		panel_1.add(btnNewButton);

		JButton btnXa = new JButton("Xóa");
		btnXa.setBackground(new Color(0, 255, 128));
		btnXa.setBounds(298, 11, 89, 23);
		panel_1.add(btnXa);

		JButton btnSa = new JButton("Sửa");
		btnSa.setBackground(new Color(255, 128, 255));
		btnSa.setBounds(405, 11, 89, 23);
		panel_1.add(btnSa);

		JButton btnXaTrng = new JButton("Xóa trắng");
		btnXaTrng.setBackground(new Color(255, 128, 128));
		btnXaTrng.setBounds(508, 11, 89, 23);
		panel_1.add(btnXaTrng);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 228, 874, 265);
		

		DefaultTableModel  tableModel = new DefaultTableModel();
		tableModel.addColumn("Mã HD");
		tableModel.addColumn("Mã KH");
		tableModel.addColumn("Mã NV");
		tableModel.addColumn("Ngày đặt");
		tableModel.addColumn("Ngày giao");
		tableModel.addColumn("Nơi nhận");
		tableModel.addColumn("Ngày chuyển hàng");
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
