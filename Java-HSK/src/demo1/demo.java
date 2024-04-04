package demo1;

import java.awt.BorderLayout;
import java.awt.Label;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class demo extends JFrame {
	public demo() {
		this.setTitle("^-^");
		this.setSize(800,480);
		this.setAutoRequestFocus(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		creat();
		setVisible(true);
	}

	private void creat() {
		JLabel jLabela = new JLabel("aaaaaaaaaaaaaa");
		JLabel jLabela_r1 = new JLabel(" ");
		JLabel jLabela_r2 = new JLabel(" ");
		JLabel jLabelb = new JLabel("b");
		JLabel jLabelc = new JLabel("c");
		JTextField jta = new JTextField(20);
		JTextField jtb = new JTextField(50);
		JTextField jtc = new JTextField(10);
		
		JPanel jp_head = new JPanel();
		BoxLayout boxLayout = new BoxLayout(jp_head, BoxLayout.Y_AXIS);
		jp_head.setLayout(boxLayout);
		Box b,b1,b2;
			b = Box.createVerticalBox();
				b1 = Box.createHorizontalBox();
				b2 = Box.createHorizontalBox();
			b.add(b1);
			b.add(Box.createVerticalStrut(15));
			b.add(b2);
				b1.add(jLabela);
				b1.add(jLabela_r1);
				b1.add(jta);
				
				b2.add(jLabelb);				
				jLabelb.setPreferredSize(jLabela.getPreferredSize());

				b2.add(jLabela_r2);
				b2.add(jtb);
				b2.add(jLabelc);
				b2.add(jtc);
			jp_head.add(b);
			this.add(jp_head,BorderLayout.NORTH);
	}
	public static void main(String[] args) {
		new demo();
	}
}