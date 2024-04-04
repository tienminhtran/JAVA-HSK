package wiev;

import java.awt.GridLayout;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ViDu_GridLayout extends JFrame {

	public ViDu_GridLayout() {
		this.setTitle("ViDu_GridLayout");
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		// tạo layout
		GridLayout gl = new GridLayout();
		this.setLayout(gl);

		// tạo jbutton

		/*
		 * // tạo jbutton lưới toàn JF JButton jbu1 = new JButton("1"); JButton jbu2 =
		 * new JButton("2"); JButton jbu3 = new JButton("3");
		 * 
		 * this.add(jbu1); this.add(jbu2); this.add(jbu3);
		 */

		/*
		 // tạo kiểu 1  2	3	4
		 //			 5	6	7	8
		GridLayout gl1 = new GridLayout(4, 4); // 4 dòng - 4 cột (ma trận)
		this.setLayout(gl1);
		for (int i = 1; i <= 16; i++) {
			JButton jbu4 = new JButton(i + "");
			this.add(jbu4);
		}
		
		*/

		/*
		 // tạo kiểu có kích thước khác đề cao rộng
		GridLayout gl2 = new GridLayout(4, 4, 20, 40); // 4 dòng ; 4 cột (ma trận); ngang cách đều 20 ; CAO 40 
		this.setLayout(gl2);
		for (int i = 1; i <= 16; i++) {
			JButton jbu5 = new JButton(i + "");
			this.add(jbu5);
		}
		*/
		GridLayout gl2 = new GridLayout(4, 4, 20, 40); // 4 dòng ; 4 cột (ma trận); ngang cách đều 20 ; CAO 40 
		this.setLayout(gl2);
		for (int i = 1; i <= 16; i++) {
			JButton jbu5 = new JButton(i+"");
			this.add(jbu5);
		}	
			
			
			
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new ViDu_GridLayout();

	}
}
