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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class LoaiHang extends JFrame {

	private JPanel contentPane;
	private JTextField textField_tenloai;
	private JTextField textField_timkiem;
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoaiHang frame = new LoaiHang();
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
	public LoaiHang() {
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
		panel.setBorder(new TitledBorder("Thông tin phiếu nhập hàng"));
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

		JLabel lb_mapn = new JLabel("Mã loại:");
		lb_mapn.setFont(new Font("Tahoma", Font.BOLD, 11));
		lb_mapn.setBounds(20, 52, 54, 21);
		panel.add(lb_mapn);

		textField_tenloai = new JTextField();
		textField_tenloai.setBounds(466, 52, 307, 20);
		panel.add(textField_tenloai);
		textField_tenloai.setColumns(10);

		JLabel lb_tenloai = new JLabel("Tên loại:");
		lb_tenloai.setFont(new Font("Tahoma", Font.BOLD, 11));
		lb_tenloai.setBounds(390, 52, 54, 21);
		panel.add(lb_tenloai);
		
		ButtonGroup buttonGroup = new ButtonGroup();

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
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Hàng điện tử"}));
		comboBox.setBounds(84, 51, 296, 22);
		panel.add(comboBox);

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
		tableModel.addColumn("Mã loại");
		tableModel.addColumn("Mã tên loại");
	
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
