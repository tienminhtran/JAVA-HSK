package view;

import javax.swing.JFrame;

public class ViDu {

	public static void main(String[] args) {
		JFrame jf = new JFrame();
		// hiện tên
		jf.setTitle("Cua so JF");
		// hiện kích thước ngang dọc
		jf.setSize(600, 400);
		// thoát chương trình
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// hiện JF
		jf.setVisible(true);
	}

}
