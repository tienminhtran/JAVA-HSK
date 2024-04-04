package Wiev;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class MyCalculator extends JFrame{
	public MyCalculator() {
		this.setTitle("MyCalculator");
		this.setSize(300,300);
		this.setLocationRelativeTo(null);
		
		
		// tạo layout
		
		
//		FlowLayout fl = new FlowLayout();
//		this.setLayout(fl);
		
//		BorderLayout bl = new BorderLayout();
//		this.setLayout(bl);

		
//		GridLayout gl = new GridLayout(5,3);
//		this.setLayout(gl);
		
		
		// tạo khung nhập dl
		JTextField jt = new JTextField(50);
		
		
		JPanel jp_text = new JPanel();
		jp_text.setLayout(new BorderLayout());
		// jp_head.setLayout(new BorderLayout()) KHỞI TẠO TRỰC TIẾP THÌ KHÔNG CẦN DÒNG 25;26
		jp_text.add(jt, BorderLayout.CENTER);
		
		
		
		
		

		
		JButton jb_0 = new JButton("0");
		JButton jb_1 = new JButton("1");
		JButton jb_2 = new JButton("2");
		JButton jb_3 = new JButton("3");
		JButton jb_4 = new JButton("4");
		JButton jb_5 = new JButton("5");
		JButton jb_6 = new JButton("6");
		JButton jb_7 = new JButton("7");
		JButton jb_8 = new JButton("8");
		JButton jb_9 = new JButton("9");
		JButton jb_cong = new JButton("+");
		JButton jb_tru = new JButton("-");
		JButton jb_nhan = new JButton("x");
		JButton jb_chia = new JButton("/");
		JButton jb_bang = new JButton("=");		
		
		JPanel jp_button = new JPanel();
		jp_button.setLayout(new GridLayout(5,3));
		
		
		jp_button.add(jb_0);
		jp_button.add(jb_1);
		jp_button.add(jb_2);
		jp_button.add(jb_3);
		jp_button.add(jb_4);
		jp_button.add(jb_5);
		jp_button.add(jb_6);
		jp_button.add(jb_7);
		jp_button.add(jb_8);
		jp_button.add(jb_9);
		jp_button.add(jb_cong);
		jp_button.add(jb_tru);
		jp_button.add(jb_nhan);
		jp_button.add(jb_chia);
		jp_button.add(jb_bang);

		this.setLayout(new BorderLayout());
		this.add(jp_text,BorderLayout.NORTH);
		this.add(jp_button,BorderLayout.CENTER);
		
		
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		try {
			
//			com.sun.java.swing.plaf.gtk.GTKLookAndFeel
//			com.sun.java.swing.plaf.motif.MotifLookAndFeel
//			com.sun.java.swing.plaf.windows.WindowsLookAndFeel
			
			
//			UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
//			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
			new MyCalculator();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
