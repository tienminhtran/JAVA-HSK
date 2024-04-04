package BTLon_newa;

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
import javax.swing.JComboBox;

public class NhaCungCap extends JFrame {

	private JPanel contentPane;
	private JTextField textField_ma;
	private JTextField textField_ten;
	private JTextField textField_phone;
	private JTextField textField_mail;
	private JTextField textField_timkiem;
	private JTable table;
	private JTextField textField_sofax;
	private JTextField textField_diachis;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NhaCungCap frame = new NhaCungCap();
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
	public NhaCungCap() {
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
		panel.setBorder(new TitledBorder("Thông tin các nhà cung cấp"));
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

		JLabel lblNewLabel = new JLabel("Mã NCC:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(20, 52, 54, 21);
		panel.add(lblNewLabel);

		textField_ma = new JTextField();
		textField_ma.setBounds(80, 52, 200, 20);
		panel.add(textField_ma);
		textField_ma.setColumns(10);

		textField_ten = new JTextField();
		textField_ten.setBounds(369, 52, 200, 20);
		panel.add(textField_ten);
		textField_ten.setColumns(10);

		JLabel lblTnKh = new JLabel("Tên NCC:");
		lblTnKh.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTnKh.setBounds(305, 52, 54, 21);
		panel.add(lblTnKh);

		JLabel lblSinThoi = new JLabel("Địa chỉ:");
		lblSinThoi.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSinThoi.setBounds(579, 52, 77, 21);
		panel.add(lblSinThoi);

		JLabel lblaCh = new JLabel("Phone:");
		lblaCh.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblaCh.setBounds(20, 83, 54, 21);
		panel.add(lblaCh);

		ButtonGroup buttonGroup = new ButtonGroup();

		textField_phone = new JTextField();
		textField_phone.setBounds(80, 83, 200, 20);
		panel.add(textField_phone);
		textField_phone.setColumns(10);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmail.setBounds(579, 84, 66, 21);
		panel.add(lblEmail);

		textField_mail = new JTextField();
		textField_mail.setBounds(656, 83, 200, 20);
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

		textField_sofax = new JTextField();
		textField_sofax.setColumns(10);
		textField_sofax.setBounds(369, 83, 200, 20);
		panel.add(textField_sofax);

		JLabel lblEmail_1 = new JLabel("Sofax:");
		lblEmail_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmail_1.setBounds(303, 83, 66, 21);
		panel.add(lblEmail_1);

		textField_diachis = new JTextField();
		textField_diachis.setColumns(10);
		textField_diachis.setBounds(656, 52, 200, 20);
		panel.add(textField_diachis);

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

		DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn("Mã NCC");
		tableModel.addColumn("Tên NCC");
		tableModel.addColumn("Địa chỉ");
		tableModel.addColumn("Số fax");
		tableModel.addColumn("Email");
		tableModel.addColumn("Phone");
		panel_2.setLayout(null);
		JTable table = new JTable(tableModel);
		JScrollPane jbs = new JScrollPane(table);
		jbs.setBounds(0, 11, 874, 252);
		panel_2.add(jbs);
		contentPane.add(panel_2);

		JLabel lblNewLabel_1 = new JLabel(" @ Copy rigth _ Mua bán link kiện");
		lblNewLabel_1.setBackground(new Color(240, 240, 240));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel_1.setBounds(400, 536, 202, 14);
		contentPane.add(lblNewLabel_1);

	}
}
