package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JEditorPane;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Panel;
import javax.swing.ImageIcon;

/**
 * @author Admin
 *
 */
public class TRANGCHU extends JFrame {

	private JPanel contentPane;
	private JButton btnNewButton_1_2_1;
	private JButton btnNewButton_1;
	private JButton btnNewButton_1_1;
	private JButton btnNewButton_1_1_1;
	private JButton btnNewButton_1_2;
	private JButton btnNewButton_1_1_1_1;
	private Panel panel_BANHANG;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TRANGCHU frame = new TRANGCHU();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
					frame.setResizable(false);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void tatNV() {
		
		//btnNewButton_1_2_1.setEnabled(false);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BANHANG banhang = new BANHANG();
				panel_BANHANG.setLayout(new java.awt.BorderLayout());
				panel_BANHANG.removeAll();
				panel_BANHANG.add(banhang);
				banhang.setBackground(Color.GRAY);
				btnNewButton_1.setBackground(new Color(217, 217, 0)); // bán hàng
				btnNewButton_1_1.setBackground(new Color(255, 255, 198)); // đơn hàng
				btnNewButton_1_1_1.setBackground(new Color(255, 255, 198)); // thống kê
				btnNewButton_1_2.setBackground(new Color(255, 255, 198)); // khách hàng
				btnNewButton_1_1_1_1.setBackground(new Color(255, 255, 198)); // sp
				btnNewButton_1_2_1.setBackground(new Color(255, 255, 198));// nv

				panel_BANHANG.revalidate();
			}
		});

		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DONHANG donhang = new DONHANG();
				panel_BANHANG.setLayout(new java.awt.BorderLayout());
				panel_BANHANG.removeAll();
				panel_BANHANG.add(donhang);
				donhang.setBackground(Color.GRAY);
				btnNewButton_1.setBackground(new Color(255, 255, 198)); // bán hàng
				btnNewButton_1_1.setBackground(new Color(217, 217, 0)); // bán hàng
				btnNewButton_1_1_1.setBackground(new Color(255, 255, 198)); // thống kê
				btnNewButton_1_2.setBackground(new Color(255, 255, 198)); // khách hàng
				btnNewButton_1_1_1_1.setBackground(new Color(255, 255, 198)); // sp
				btnNewButton_1_2_1.setBackground(new Color(255, 255, 198));// nv
				panel_BANHANG.revalidate();
			}
		});


		
	}
	/**
	 * Create the frame.
	 */
	public TRANGCHU() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 660);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 297, 213, -276);
		contentPane.add(panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 255, 127));
		panel_1.setBounds(0, 11, 213, 599);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		 btnNewButton_1 = new JButton("Bán hàng");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		btnNewButton_1.setBackground(new Color(255, 255, 224));
		btnNewButton_1.setFont(new Font("#9Slide01 Noi dung ngan", Font.PLAIN, 18));

		btnNewButton_1.setBounds(0, 0, 213, 56);
		panel_1.add(btnNewButton_1);
		
		

		 btnNewButton_1_1 = new JButton("Đơn hàng");

		btnNewButton_1_1.setBackground(new Color(255, 255, 224));
		btnNewButton_1_1.setFont(new Font("#9Slide01 Noi dung ngan", Font.PLAIN, 18));
		btnNewButton_1_1.setBounds(0, 67, 213, 56);
		panel_1.add(btnNewButton_1_1);

		 btnNewButton_1_1_1 = new JButton("Thống kê");

		btnNewButton_1_1_1.setBackground(new Color(255, 255, 224));
		btnNewButton_1_1_1.setFont(new Font("#9Slide01 Noi dung ngan", Font.PLAIN, 18));
		btnNewButton_1_1_1.setBounds(0, 335, 213, 56);
		panel_1.add(btnNewButton_1_1_1);

		 btnNewButton_1_2 = new JButton("Khách hàng");

		btnNewButton_1_2.setBackground(new Color(255, 255, 224));
		btnNewButton_1_2.setFont(new Font("#9Slide01 Noi dung ngan", Font.PLAIN, 18));
		btnNewButton_1_2.setBounds(0, 201, 213, 56);
		panel_1.add(btnNewButton_1_2);

		 btnNewButton_1_1_1_1 = new JButton("Sản phẩm");

		btnNewButton_1_1_1_1.setBackground(new Color(255, 255, 224));
		btnNewButton_1_1_1_1.setFont(new Font("#9Slide01 Noi dung ngan", Font.PLAIN, 18));
		btnNewButton_1_1_1_1.setBounds(0, 134, 213, 56);
		panel_1.add(btnNewButton_1_1_1_1);

		 btnNewButton_1_2_1 = new JButton("Nhân viên");


		btnNewButton_1_2_1.setBackground(new Color(255, 255, 224));
		btnNewButton_1_2_1.setFont(new Font("#9Slide01 Noi dung ngan", Font.PLAIN, 18));
		btnNewButton_1_2_1.setBounds(0, 268, 213, 56);
		panel_1.add(btnNewButton_1_2_1);
		
		JButton btnNewButton = new JButton("");

		btnNewButton.setIcon(new ImageIcon("D:\\BAI_TAP_JAVA\\QLLK_NE\\src\\img\\thgy.jpg"));
		btnNewButton.setBounds(0, 398, 213, 201);
		panel_1.add(btnNewButton);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 255, 255));
		panel_2.setBounds(215, 11, 959, 599);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel = new JLabel("PHẦN MỀM QUẢN LÝ LINH KIỆN MÁY TÍNH");
		lblNewLabel.setForeground(new Color(249, 108, 23));
		lblNewLabel.setBounds(282, 0, 387, 33);
		panel_2.add(lblNewLabel);
		lblNewLabel.setBackground(new Color(0, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));

		 panel_BANHANG = new Panel();
		panel_BANHANG.setBounds(10, 33, 939, 556);
		panel_2.add(panel_BANHANG);
		// XUẤT HIỆN KHI NHẤN VÀO LOGIN
		BANHANG banhang = new BANHANG();
		panel_BANHANG.setLayout(new java.awt.BorderLayout());
		panel_BANHANG.removeAll();
		panel_BANHANG.add(banhang);
		banhang.setBackground(Color.GRAY);
		
		JButton btnNewButton_2 = new JButton("Đăng xuất");

		btnNewButton_2.setForeground(new Color(0, 0, 0));
		btnNewButton_2.setBackground(new Color(128, 255, 255));
		btnNewButton_2.setIcon(new ImageIcon("D:\\BAI_TAP_JAVA\\QLLK_NE\\src\\img\\xuat.png"));
		btnNewButton_2.setBounds(10, 3, 127, 30);
		panel_2.add(btnNewButton_2);
		btnNewButton_1.setBackground(new Color(217, 217, 0));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BANHANG banhang = new BANHANG();
				panel_BANHANG.setLayout(new java.awt.BorderLayout());
				panel_BANHANG.removeAll();
				panel_BANHANG.add(banhang);
				banhang.setBackground(Color.GRAY);
				btnNewButton_1.setBackground(new Color(217, 217, 0)); // bán hàng
				btnNewButton_1_1.setBackground(new Color(255, 255, 198)); // đơn hàng
				btnNewButton_1_1_1.setBackground(new Color(255, 255, 198)); // thống kê
				btnNewButton_1_2.setBackground(new Color(255, 255, 198)); // khách hàng
				btnNewButton_1_1_1_1.setBackground(new Color(255, 255, 198)); // sp
				btnNewButton_1_2_1.setBackground(new Color(255, 255, 198));// nv

				panel_BANHANG.revalidate();
			}
		});
	}

}
