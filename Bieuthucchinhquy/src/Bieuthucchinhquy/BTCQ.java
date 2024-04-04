package Bieuthucchinhquy;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Label;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BTCQ extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BTCQ frame = new BTCQ();
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
	public BTCQ() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(174, 10, 168, 39);
		contentPane.add(textField);
		textField.setColumns(10);

		Label label = new Label("Dữ liệu");
		label.setBounds(41, 21, 62, 22);
		contentPane.add(label);

		Button button = new Button("Kiểm tra");
		button.addActionListener(this);
		button.setBounds(154, 108, 99, 39);
		contentPane.add(button);
	}

	public void actionPerformed(ActionEvent e) {
//		String s = "0\\d{9}";
//		String s = "^0\\d"; // có + là 001233 mới đúng
//		String s = "^0\\d{2}"; // 003/ 034 000 đúng
//		String s = "[0-9]\\d{9}"; //1  012345678  / 2 12345678 [0-9] bắt buộc có một số and \\d là [0-9] kèm them {9} đủ 9 số
//		String s = "\\d{9}"; // cmnd
//		String s = "\\w"; // chỉ nhận 1 số or 1 chữ hoa thg CÓ + nhập nhiều

//		String s = "\\w+\\.";.
//		String s = "\\w+\\@gmail\\.com|vn";
//		String s = ".n{1,3}p$";
//		String s = "\\D+[abc][zv]\\w"; aaaabczc
//		String s = "\\w+";
//		String s = "[^abc]";
//		String s = "[a-d1-7]+"; 
//		String s = ".+[0-9]";
//		String s = "\\w+\\s\\w+";
//		String s = "[a-d]*?";  // không nhập vẫn đúng vì * không hoặc nhiều
//		String s = "\\d.";
//		String s = "[0-9]{3}-[0-9]{3}-[0-9]{2}-[0-9]";
//		String s = "\\w{3}(-\\w){3,4}"; //aaa-b-c-d
//		String s = "\\w{2}(-\\w{3}){3,4}";
		// tien.iuh.edu@gmail.com
//		String s = "\\w+(.\\w+)*\\@gmail.com|.vn";

		// 0123456789
//		String s = "0[1-9]\\d{8}";
//		String s = "^0\\d.+"; 
//		String s = "[0-9]\\d{9}"; 
		// tien.iuh.edu@gmail.com|.vn
		// tien@gmail.com
		// tien.zalo
//		String s = "\\w+.*@gmail.(com|vn)+";
//		String s = "\\w+(.\\w+)*@gmail.com|.vn";
//		String s = "\\D+[abc][zv]\\w"; 
		// Chứa ktrang, k ký tu db tru dau cham không số |
		// Tran minh .
//		String s = "([a-zA-Z\\s\\.])+";
//		String a = "Tien1324";
		//          0123
//		String s1 = a.substring(0,1);
		// (từ đấu, đến )
//		String s = s1 + "[0-9]{3}"; // s = "ie003"
//		String s2="([a-zA-Z\\s\\.]+)";
		// KÝ TỰ ĐẦU T
		
//		String s = "\\d{3}-\\w\\d{2}-\\d{3}-\\d{4}";
//		String s = "\\d{3}-[a-zA-Z]\\d{2}(-\\d{3,4})+";
//		String s = "\\d+(-\\d+){3,4}";
//		String s = "NV\\d{8}";
//		String s = "[a-zA-Z\\s]+";
//		String s = "[\\w\\s]+";
//		String s = "[18-60]+";
//		String s = "^[a-zA-Z][\\w\\.\\_]*@(gmail|iuh|gg)+";
//		String s = "1[8-9]|[2-5][0-9]|60";
//		String s = "^\\S+$";
		String s = "4[0-9]|[5-9][0-9]";
				// tien_123@iuh
		if (textField.getText().matches(s)) {
			JOptionPane.showMessageDialog(this, "Dữ liệu đúng");
		} else {
			JOptionPane.showMessageDialog(this, "Dữ liệu sai");

		}
	}
}
