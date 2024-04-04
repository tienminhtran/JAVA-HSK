package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import connectDB.ConnectDB;
import dao.LoginDao;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

public class LOGIN extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	public TRANGCHU trangchu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LOGIN frame = new LOGIN();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LOGIN() {
		LoginDao loginDao = new LoginDao();

		try {
			ConnectDB.getInstance().connect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 759, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(173, 255, 47));
		panel.setBounds(0, 0, 358, 428);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("COMPANY NAME");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Swis721 Ex BT", Font.BOLD, 18));
		lblNewLabel.setBounds(81, 11, 197, 50);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("@DHCN IUH 2023");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblNewLabel_1.setBounds(108, 384, 130, 14);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("D:\\BAI_TAP_JAVA\\QLLK_NE\\src\\img\\160317icon_login.png"));
		lblNewLabel_4.setBounds(21, 31, 314, 353);
		panel.add(lblNewLabel_4);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 206, 209));
		panel_1.setBounds(352, 0, 391, 428);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("LOGIN");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("#9Slide03 AmpleSoft Bold", Font.BOLD, 31));
		lblNewLabel_2.setBounds(10, 63, 381, 36);
		panel_1.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Username:");
		lblNewLabel_3.setBounds(35, 130, 91, 36);
		panel_1.add(lblNewLabel_3);

		textField = new JTextField();
		textField.setBounds(34, 169, 316, 43);
		panel_1.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_3_1 = new JLabel("Password:");
		lblNewLabel_3_1.setBounds(36, 219, 91, 36);
		panel_1.add(lblNewLabel_3_1);

		passwordField = new JPasswordField();
		passwordField.setBounds(34, 266, 316, 43);
		panel_1.add(passwordField);

		JButton btnNewButton = new JButton("Login");

		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLUE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(35, 336, 89, 43);
		panel_1.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().equals("") || passwordField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập tên đăng nhập và mật khẩu!!!", "Thông báo",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					if (loginDao.dieuKienLogin(textField.getText(),
							String.valueOf(passwordField.getPassword())) == true) {
						JOptionPane.showMessageDialog(null, "Đăng nhập thành công!!!");
						setVisible(false);
						TRANGCHU trangchu = new TRANGCHU();		
						trangchu.setVisible(true);
						trangchu.setLocationRelativeTo(null);
						if (textField.getText().contains("NV001")) {
							trangchu.BTNNV();
						} else {
							  trangchu.tatNV();

						}
					} else {
						JOptionPane.showMessageDialog(null, "Tên đăng nhập hoặc mật khẩu không trùng khớp!!!", "Cảnh báo",
								JOptionPane.ERROR_MESSAGE);
						textField.setText("");
						passwordField.setText("");
						
					}
				}
			}
		});
	}
}
//NV001 1Admin
//NV002 2NV