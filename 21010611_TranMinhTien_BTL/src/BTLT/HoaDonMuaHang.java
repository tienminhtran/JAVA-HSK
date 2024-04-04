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
import javax.swing.JComboBox;

public class HoaDonMuaHang extends JFrame implements ActionListener{
	private NhaCungCap nhaCungCap;
	private JPanel contentPane;
	private JTextField textField_mahd;
	private JTextField textField_masp;
	private JTextField textField_ngaydat;
	private JTextField textField_ngayhan;
	private JTextField textField_timkiem;
	private JTable table;
	private JTextField textField_ngaygiao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HoaDonMuaHang frame = new HoaDonMuaHang();
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
	public HoaDonMuaHang() {
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
		panel.setBorder(new TitledBorder("Thông tin đơn hàng cần mua"));
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

		JLabel lblTnKh = new JLabel("Mã SP:");
		lblTnKh.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTnKh.setBounds(305, 52, 54, 21);
		panel.add(lblTnKh);

		JLabel lblSinThoi = new JLabel("Loại hàng:");
		lblSinThoi.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSinThoi.setBounds(579, 52, 77, 21);
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

		JLabel lblEmail = new JLabel("Ngày nhận:");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmail.setBounds(579, 84, 66, 21);
		panel.add(lblEmail);

		textField_ngayhan = new JTextField();
		textField_ngayhan.setBounds(656, 83, 200, 20);
		panel.add(textField_ngayhan);
		textField_ngayhan.setColumns(10);

		JButton button_loc = new JButton("Lọc");
		button_loc.addActionListener(this);
		button_loc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_loc.setBounds(684, 10, 89, 23);
		panel.add(button_loc);
		
		Canvas canvas = new Canvas();
		canvas.setBounds(20, -28, 47, 23);
		panel.add(canvas);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(656, 51, 200, 22);
		panel.add(comboBox);
		
		textField_ngaygiao = new JTextField();
		textField_ngaygiao.setColumns(10);
		textField_ngaygiao.setBounds(369, 83, 200, 20);
		panel.add(textField_ngaygiao);
		
		JLabel lblEmail_1 = new JLabel("Ngày giao:");
		lblEmail_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmail_1.setBounds(303, 83, 66, 21);
		panel.add(lblEmail_1);

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
		tableModel.addColumn("Mã SP");
		tableModel.addColumn("Loại hàng");
		tableModel.addColumn("Ngày đặt");
		tableModel.addColumn("Ngày giao");
		tableModel.addColumn("Ngày nhận");
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String src = e.getActionCommand();
		if(src.equals("Lọc")) {
			new NhaCungCap().setVisible(true);
		}
	}
}
