package BTLon_newa;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class GiamGia extends JFrame {

	private JPanel contentPane;
	private JTextField textField_magiam;
	private JTextField textField_tenct;
	private JTextField textField_dieukien;
	private JTextField textField_tungay;
	private JTextField textField_denngay;
	private JTextField textField_timkiem;
	private JTable table;
	private JTextField textField_phantram;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GiamGia frame = new GiamGia();
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
	public GiamGia() {
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
		panel.setBorder(new TitledBorder("Thông tin giảm giá"));
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

		JLabel lb_magiam = new JLabel("Mã giảm:");
		lb_magiam.setFont(new Font("Tahoma", Font.BOLD, 11));
		lb_magiam.setBounds(20, 52, 54, 21);
		panel.add(lb_magiam);

		textField_magiam = new JTextField();
		textField_magiam.setBounds(89, 52, 149, 20);
		panel.add(textField_magiam);
		textField_magiam.setColumns(10);

		textField_tenct = new JTextField();
		textField_tenct.setBounds(322, 52, 194, 20);
		panel.add(textField_tenct);
		textField_tenct.setColumns(10);

		JLabel lb_tenchuongtrinh = new JLabel("Tên CT:");
		lb_tenchuongtrinh.setFont(new Font("Tahoma", Font.BOLD, 11));
		lb_tenchuongtrinh.setBounds(258, 52, 54, 21);
		panel.add(lb_tenchuongtrinh);

		JLabel lb_dieukien = new JLabel("Điều kiện:");
		lb_dieukien.setFont(new Font("Tahoma", Font.BOLD, 11));
		lb_dieukien.setBounds(526, 52, 89, 21);
		panel.add(lb_dieukien);

		textField_dieukien = new JTextField();
		textField_dieukien.setBounds(616, 52, 216, 20);
		panel.add(textField_dieukien);
		textField_dieukien.setColumns(10);

		JLabel lb_tungay = new JLabel("Từ ngày:");
		lb_tungay.setFont(new Font("Tahoma", Font.BOLD, 11));
		lb_tungay.setBounds(20, 83, 54, 21);
		panel.add(lb_tungay);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		
		

		textField_tungay = new JTextField();
		textField_tungay.setBounds(89, 83, 233, 20);
		panel.add(textField_tungay);
		textField_tungay.setColumns(10);

		JLabel lb_tongtien = new JLabel("Đến ngày:");
		lb_tongtien.setFont(new Font("Tahoma", Font.BOLD, 11));
		lb_tongtien.setBounds(332, 83, 89, 21);
		panel.add(lb_tongtien);

		textField_denngay = new JTextField();
		textField_denngay.setBounds(402, 83, 216, 20);
		panel.add(textField_denngay);
		textField_denngay.setColumns(10);

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
		
		JLabel lb_phantram = new JLabel("Phần trăm:");
		lb_phantram.setFont(new Font("Tahoma", Font.BOLD, 11));
		lb_phantram.setBounds(626, 83, 89, 21);
		panel.add(lb_phantram);
		
		textField_phantram = new JTextField();
		textField_phantram.setColumns(10);
		textField_phantram.setBounds(701, 83, 131, 20);
		panel.add(textField_phantram);

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
		tableModel.addColumn("Mã giảm giá");
		tableModel.addColumn("Tên chương trình");
		tableModel.addColumn("Điều kiện");
		tableModel.addColumn("Từ ngày");
		tableModel.addColumn("Đến ngày");
		tableModel.addColumn("Phần trăm");
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
