package view;

import javax.swing.JFrame;

public class MyWindown extends JFrame {

	public MyWindown() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void showIt() {
		this.setVisible(true);
	}

	public void showIt(String title) {
		this.setTitle(title);
		this.setVisible(true);

	}

	public void showIt(String title, int ngang, int doc) {
		this.setTitle(title);
		this.setSize(ngang, doc);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		MyWindown mw = new MyWindown();
		mw.showIt();
		MyWindown mw1 = new MyWindown();
		mw1.showIt("Cua so 2");
		MyWindown mw2 = new MyWindown();
		mw2.showIt("Cua so 3", 600, 400);
	}
}
