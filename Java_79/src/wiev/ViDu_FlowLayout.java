package wiev;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ViDu_FlowLayout extends JFrame {
	public ViDu_FlowLayout() {
		 
		
		//set layout
		FlowLayout fl = new FlowLayout(FlowLayout.CENTER);
		FlowLayout f2 = new FlowLayout(FlowLayout.LEADING);
		FlowLayout f3 = new FlowLayout(FlowLayout.RIGHT);
		FlowLayout f4 = new FlowLayout(FlowLayout.TRAILING);
		FlowLayout f5 = new FlowLayout(FlowLayout.LEFT,100,20);
		// căn trái, ngang cách đều 100, dọc(cao) 20

		this.setLayout(f5);
		
		JButton jbu1 = new JButton("1");
		JButton jbu2 = new JButton("2");
		JButton jbu3 = new JButton("3");

		this.add(jbu1);
		this.add(jbu2);
		this.add(jbu3);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new ViDu_FlowLayout();
	}
}
