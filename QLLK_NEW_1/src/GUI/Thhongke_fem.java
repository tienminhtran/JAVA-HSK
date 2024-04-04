package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

public class Thhongke_fem extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Thhongke_fem frame = new Thhongke_fem();
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
	public Thhongke_fem() {
getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 939, 556);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(469, 5, 1, 1);
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(119, 255, 187));
		panel.add(panel_2);
		
		JLabel lbNhanVien_1_1_1_1 = new JLabel("QUẢN LÝ NHÂN VIÊN");
		lbNhanVien_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbNhanVien_1_1_1_1.setForeground(Color.RED);
		lbNhanVien_1_1_1_1.setFont(new Font("Arial", Font.BOLD, 25));
		lbNhanVien_1_1_1_1.setBackground(new Color(4, 255, 130));
		lbNhanVien_1_1_1_1.setBounds(0, 0, 937, 41);
		panel_2.add(lbNhanVien_1_1_1_1);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBounds(0, 0, 937, 47);
		panel_2_1.setLayout(null);
		panel_2_1.setBackground(new Color(119, 255, 187));
		panel.add(panel_2_1);
		
		JLabel lbNhanVien_1_1_1_1_1 = new JLabel("QUẢN LÝ THỐNG KÊ");
		lbNhanVien_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbNhanVien_1_1_1_1_1.setForeground(Color.RED);
		lbNhanVien_1_1_1_1_1.setFont(new Font("Arial", Font.BOLD, 25));
		lbNhanVien_1_1_1_1_1.setBackground(new Color(4, 255, 130));
		lbNhanVien_1_1_1_1_1.setBounds(0, 0, 937, 41);
		panel_2_1.add(lbNhanVien_1_1_1_1_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(74, 101, 373, 178);
		panel_1.setBorder(new MatteBorder(0, 1, 4, 1, (Color) new Color(0, 51, 204)));
		panel_1.setBackground(new Color(0, 102, 255));
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lbl_spTK = new JLabel("New label");
		lbl_spTK.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbl_spTK.setBounds(43, 64, 192, 29);
		panel_1.add(lbl_spTK);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(492, 101, 373, 178);
		panel_1_1.setBorder(new MatteBorder(0, 1, 4, 1, (Color) new Color(153, 153, 51)));
		panel_1_1.setBackground(new Color(51, 255, 153));
		panel.add(panel_1_1);
		panel_1_1.setLayout(null);
		
		JLabel lbl_nvTK_1 = new JLabel("New label");
		lbl_nvTK_1.setBounds(51, 68, 100, 25);
		lbl_nvTK_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_1_1.add(lbl_nvTK_1);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBounds(74, 324, 373, 178);
		panel_1_2.setBorder(new MatteBorder(0, 1, 4, 1, (Color) new Color(255, 20, 147)));
		panel_1_2.setBackground(new Color(255, 182, 193));
		
		panel.add(panel_1_2);
		panel_1_2.setLayout(null);
		
		JLabel lbl_khTK_1_1 = new JLabel("New label");
		lbl_khTK_1_1.setBounds(38, 60, 100, 25);
		lbl_khTK_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_1_2.add(lbl_khTK_1_1);
		
		
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setBounds(492, 324, 373, 178);
		panel_1_1_1.setBorder(new MatteBorder(0, 1, 4, 1, (Color) new Color(255, 204, 0)));
		panel_1_1_1.setBackground(Color.BLUE);
		panel.add(panel_1_1_1);
	}
}
