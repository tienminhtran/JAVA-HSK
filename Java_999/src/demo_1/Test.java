package demo_1;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class Test extends JFrame{

	public static void main(String[] args) {
		JFrame jf = new JFrame();
		
		JPanel jp = new JPanel();
		TitledBorder tb = new TitledBorder("TIẾN IU EM");
		jp.setBorder(tb);
		
		jf.add(jp);
		jf.setVisible(true);
	}
	
}
