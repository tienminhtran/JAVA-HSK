package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.MyColorController;
import model.MyColorModel;

public class MyColorView extends JFrame {

	private MyColorModel myColorModel;
	private JLabel jlabel;

	public MyColorView() {
		this.myColorModel = new MyColorModel();
		this.init();
		this.setVisible(true);
	}

	private void init() {
		this.setTitle("My Color");
		this.setSize(800,600 );
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Tạo font
		Font f_text = new Font("Cambria", Font.BOLD, 40);
		Font f = new Font("Cambria", Font.BOLD, 20);

		// GẮN SỰ KIỆN
		
		MyColorController mcc = new MyColorController(this);
		
		// tạo khung Jlabel trên
			JPanel jp_North = new JPanel();
			jp_North.setLayout(new BorderLayout());
	
			// tạo Jlabel
			jlabel = new JLabel("Text",jlabel.CENTER);
			jlabel.setFont(f_text);
			jp_North.add(jlabel,BorderLayout.NORTH);

		// tạo khung bottom

		JPanel jp_Bottom = new JPanel();
		jp_Bottom.setLayout(new GridLayout(2, 3));

			// tạo màu chữ
	
			JButton jb_text_red = new JButton("Red text");
			jb_text_red.setForeground(Color.RED);
			jb_text_red.setFont(f);
			jb_text_red.addActionListener(mcc);
			
			JButton jb_text_yellow = new JButton("Yellow text");
			jb_text_yellow.setForeground(Color.YELLOW);
			jb_text_yellow.setFont(f);
			jb_text_yellow.addActionListener(mcc);

			JButton jb_text_green = new JButton("Green text");
			jb_text_green.setForeground(Color.GREEN);
			jb_text_green.setFont(f);
			jb_text_green.addActionListener(mcc);

			// tạo màu nền
			JButton jb_background_red = new JButton("Red background");
			//jb_background_red.setForeground(Color.WHITE); //Thay màu trắng cho chữ "Red background"
			jb_background_red.setBackground(Color.RED);
			jb_background_red.setOpaque(true);
			jb_background_red.setFont(f);
			jb_background_red.addActionListener(mcc);

			JButton jb_background_yellow = new JButton("Yellow background");
			jb_background_yellow.setBackground(Color.YELLOW);
			jb_background_yellow.setOpaque(true);
			jb_background_yellow.setFont(f);
			jb_background_yellow.addActionListener(mcc);

			JButton jb_background_green = new JButton("Green background");
			jb_background_green.setBackground(Color.GREEN);
			jb_background_green.setOpaque(true);
			jb_background_green.setFont(f);
			jb_background_green.addActionListener(mcc);

			jp_Bottom.add(jb_text_red);
			jp_Bottom.add(jb_text_yellow);
			jp_Bottom.add(jb_text_green);
			jp_Bottom.add(jb_background_red);
			// jb_background_red.setBackground(Color.RED); // cách 2 có thể thay màu nên thay vì khai báo trên
			jp_Bottom.add(jb_background_yellow);
			jp_Bottom.add(jb_background_green);

		// khung chính
		this.setLayout(new BorderLayout());
		this.add(jp_North, BorderLayout.NORTH);
		this.add(jp_Bottom, BorderLayout.CENTER);

	}

	public void changeTextColor(Color color) {
		this.jlabel.setForeground(color);
	}
	
	public void changeBackgroundColor(Color color) {
		this.jlabel.setBackground(color);
		this.jlabel.setOpaque(true);
	}
}
