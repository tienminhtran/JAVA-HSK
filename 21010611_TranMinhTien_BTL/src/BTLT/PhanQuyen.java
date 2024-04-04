package BTLT;

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
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;

public class PhanQuyen extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PhanQuyen frame = new PhanQuyen();
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
	public PhanQuyen() {
		setSize(900, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
//		setBounds(0, -15, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 271, 874, 45);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(128, 255, 255));
		btnNewButton.setBounds(268, 9, 89, 23);
		panel_1.add(btnNewButton);

		JButton btnXa = new JButton("Xóa");
		btnXa.setBackground(new Color(0, 255, 128));
		btnXa.setBounds(404, 9, 89, 23);
		panel_1.add(btnXa);

		JButton btnSa = new JButton("Sửa");
		btnSa.setBackground(new Color(255, 128, 255));
		btnSa.setBounds(546, 9, 89, 23);
		panel_1.add(btnSa);
		

		DefaultTableModel  tableModel = new DefaultTableModel();
		tableModel.addColumn("Mã HK");
		tableModel.addColumn("Tên HK");
		tableModel.addColumn("SĐT");
		tableModel.addColumn("Giới tính");
		tableModel.addColumn("Địa chỉ");
		tableModel.addColumn("Email");
		
		JLabel lblNewLabel_1 = new JLabel(" @ Copy rigth _ Mua bán link kiện");
		lblNewLabel_1.setBackground(new Color(240, 240, 240));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel_1.setBounds(400, 536, 202, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Phân quyền quản trị");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel.setBounds(400, 32, 151, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Nhóm quyền: ");
		lblNewLabel_2.setBounds(325, 57, 100, 14);
		contentPane.add(lblNewLabel_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Quản lý"}));
		comboBox.setBounds(435, 53, 129, 22);
		contentPane.add(comboBox);
		
		JCheckBox cb_nhaphang = new JCheckBox("Quản lý nhập hàng");
		cb_nhaphang.setBounds(366, 81, 185, 23);
		contentPane.add(cb_nhaphang);
		
		JCheckBox cb_sanpham = new JCheckBox("Quản lý sản phẩm");
		cb_sanpham.setBounds(366, 107, 185, 23);
		contentPane.add(cb_sanpham);
		
		JCheckBox cb_nhanvien = new JCheckBox("Quản lý nhân viên");
		cb_nhanvien.setBounds(366, 136, 185, 23);
		contentPane.add(cb_nhanvien);
		
		JCheckBox cb_khachhang = new JCheckBox("Quản lý khách hàng");
		cb_khachhang.setBounds(366, 162, 185, 23);
		contentPane.add(cb_khachhang);
		
		JCheckBox cb_thongke = new JCheckBox("Quản lý thống kê");
		cb_thongke.setBounds(366, 191, 185, 23);
		contentPane.add(cb_thongke);

	
	}
}
