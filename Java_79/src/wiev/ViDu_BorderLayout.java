package wiev;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.Border;

public class ViDu_BorderLayout extends JFrame {

	public ViDu_BorderLayout() {
		this.setTitle("Cua so BorderLayout");
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		// tạo không có khoảng cách giữa các Jbutton

		// tạo layout
		BorderLayout bl = new BorderLayout();
		this.setLayout(bl);
		// tạo jbutton
		JButton jbu1 = new JButton("1-Bắc");
		JButton jbu2 = new JButton("2-Nam");
		JButton jbu3 = new JButton("3-Đông");
		JButton jbu4 = new JButton("4-Tây");
		JButton jbu5 = new JButton("5-Giữa");

		this.add(jbu1, BorderLayout.NORTH);
		this.add(jbu2, BorderLayout.SOUTH);
		this.add(jbu3, BorderLayout.EAST);
		this.add(jbu4, BorderLayout.WEST);
		this.add(jbu5, BorderLayout.CENTER);

		// cách 2 có khoảng cách 
		
		// tạo layout
//		BorderLayout bl1 = new BorderLayout(15,15);
//		this.setLayout(bl1);
		// tạo jbutton
//		JButton jbu6 = new JButton("1-Bắc");
//		JButton jbu7 = new JButton("2-Nam");
//		JButton jbu8 = new JButton("3-Đông");
//		JButton jbu9 = new JButton("4-Tây");
//		JButton jbu10 = new JButton("5-Giữa");
//
//		this.add(jbu6, BorderLayout.NORTH);
//		this.add(jbu7, BorderLayout.SOUTH);
//		this.add(jbu8, BorderLayout.EAST);
//		this.add(jbu9, BorderLayout.WEST);
//		this.add(jbu10, BorderLayout.CENTER);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new ViDu_BorderLayout();
	}
}
