package PaintComPonentsView;

import java.awt.BorderLayout;
import java.awt.Paint;

import javax.swing.JFrame;
import javax.swing.JPanel;

import paintcomponentsdemo.PaintComPonentsDeMo;

public class View extends JFrame {

	public View() {
		this.setTitle("Java 88");
		this.setSize(700, 700);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		PaintComPonentsDeMo pcpd = new PaintComPonentsDeMo();

		this.setVisible(true);
		this.setLayout(new BorderLayout());
		this.add(pcpd, BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		new View();
	}
}
