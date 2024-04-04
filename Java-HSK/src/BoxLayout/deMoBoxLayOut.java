package BoxLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class deMoBoxLayOut extends JFrame{
	public deMoBoxLayOut() {
		setTitle("BoxLayout");
		setSize(450, 250);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		//setResizable(false);		
		
		Box box, b, c, d;
		add(box = Box.createVerticalBox());
		box.add(b = Box.createHorizontalBox());
		box.add(c = Box.createHorizontalBox());
		box.add(d = Box.createVerticalBox());
		
		
//		add(a = Box.createVerticalBox());
//		a.add(b = Box.createHorizontalBox());
//		a.add(c = Box.createHorizontalBox());
//		a.add(d = Box.createVerticalBox());
		for (int i = 0; i < 3; i++) {
			b.add(Box.createHorizontalGlue() );
			b.add(new JButton("Button " + i));
		}
//		b.add(Box.createHorizontalGlue());

		for (int i = 0; i < 5; i++) {
			c.add(new JButton("Button " + i));
		}
		for (int i = 0; i < 5; i++) {
			d.add(Box.createVerticalStrut(5));
			d.add(new JButton("Button " + i));
		}
//		d.add(Box.createVerticalStrut(5));

		
		setVisible(true);
	}

	public static void main(String[] args) {
		new deMoBoxLayOut();
	}

}
