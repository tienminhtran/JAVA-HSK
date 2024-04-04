package BTLT;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URI;
import java.net.URL;

import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Canvas;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TrangDangNhap extends JFrame {

//	private static final String "D = null";
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrangDangNhap frame = new TrangDangNhap();
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
	public TrangDangNhap() {
		setSize(900, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setBounds(100, 100, 743, 567);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("User Login");
		lblNewLabel.setFont(new Font("Vineta BT", Font.BOLD, 17));
		lblNewLabel.setBounds(478, 147, 178, 56);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(458, 242, 182, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Username:*");
		lblNewLabel_1.setBounds(458, 214, 74, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Password:*");
		lblNewLabel_1_1_1.setBounds(462, 273, 74, 14);
		contentPane.add(lblNewLabel_1_1_1);

		JCheckBox chckbxNewCheckBox = new JCheckBox("Remember me:");
		chckbxNewCheckBox.setBounds(457, 330, 115, 23);
		contentPane.add(chckbxNewCheckBox);

		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new KhachHang().setVisible(true);
			}
		});
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.setBounds(457, 367, 183, 23);
		contentPane.add(btnNewButton);

		passwordField = new JPasswordField();
		passwordField.setBounds(458, 298, 182, 20);
		contentPane.add(passwordField);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\Login Modern.png"));
		lblNewLabel_2.setBounds(0, -47, 309, 617);
		contentPane.add(lblNewLabel_2);
	}
}
