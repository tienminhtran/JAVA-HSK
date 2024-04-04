package BTLT;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTable;
import java.awt.Canvas;

public class KhachHang extends JFrame {

	private JPanel contentPane;
	private JTextField textField_ma;
	private JTextField textField_ten;
	private JTextField textField_sdt;
	private JTextField textField_diachi;
	private JTextField textField_mail;
	private JTextField textField_timkiem;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KhachHang frame = new KhachHang();
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
	public KhachHang() {
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
		panel.setBorder(new TitledBorder("Thông tin khách hàng"));
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

		JLabel lblNewLabel = new JLabel("Mã KH:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(20, 52, 54, 21);
		panel.add(lblNewLabel);

		textField_ma = new JTextField();
		textField_ma.setBounds(70, 52, 137, 20);
		panel.add(textField_ma);
		textField_ma.setColumns(10);

		textField_ten = new JTextField();
		textField_ten.setBounds(259, 51, 213, 20);
		panel.add(textField_ten);
		textField_ten.setColumns(10);

		JLabel lblTnKh = new JLabel("Tên KH:");
		lblTnKh.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTnKh.setBounds(213, 51, 54, 21);
		panel.add(lblTnKh);

		JLabel lblSinThoi = new JLabel("Số điện thoại:");
		lblSinThoi.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSinThoi.setBounds(497, 52, 77, 21);
		panel.add(lblSinThoi);

		textField_sdt = new JTextField();
		textField_sdt.setBounds(579, 52, 122, 20);
		panel.add(textField_sdt);
		textField_sdt.setColumns(10);

		JLabel lblGiiTnh = new JLabel("Giới tính:");
		lblGiiTnh.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGiiTnh.setBounds(709, 52, 54, 21);
		panel.add(lblGiiTnh);

		JRadioButton rdbtnNam = new JRadioButton("Nam");
		rdbtnNam.setBounds(755, 50, 54, 23);
		panel.add(rdbtnNam);

		JRadioButton rdbtnNu = new JRadioButton("Nữ");
		rdbtnNu.setBounds(809, 50, 47, 23);
		panel.add(rdbtnNu);

		JLabel lblaCh = new JLabel("Địa chỉ:");
		lblaCh.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblaCh.setBounds(20, 83, 54, 21);
		panel.add(lblaCh);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnNam);
		buttonGroup.add(rdbtnNu);
		
		

		textField_diachi = new JTextField();
		textField_diachi.setBounds(70, 83, 406, 20);
		panel.add(textField_diachi);
		textField_diachi.setColumns(10);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmail.setBounds(497, 83, 54, 21);
		panel.add(lblEmail);

		textField_mail = new JTextField();
		textField_mail.setBounds(579, 83, 267, 20);
		panel.add(textField_mail);
		textField_mail.setColumns(10);

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
		tableModel.addColumn("Mã HK");
		tableModel.addColumn("Tên HK");
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
