package Bai3;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class Pheptoan extends JFrame{

	public Pheptoan() {
		this.setTitle("Cộng-trừ-nhân chia");
		this.setSize(600,500);
		this.setAutoRequestFocus(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.Init();
	}

	private void Init() {
		Font f = new Font("Arial", Font.BOLD , 30);

		JPanel jb = new JPanel();
		//jb.setLayout(new BorderLayout());
			JLabel jl_title = new JLabel("CỘNG TRỪ NHÂN CHIA", JLabel.CENTER);
			jl_title.setFont(f);			
			jb.add(jl_title);

		
		JPanel jp_center = new JPanel();
		jp_center.setLayout(null);
			jp_center.setBounds(10, 20, 125, 235);
			
				TitledBorder tb = new TitledBorder("Chọn tác vụ");
				jp+._center.setBorder(tb);
				
					JButton jb_giai = new JButton("Giải");
					jb_giai.setBounds(10, 20, 100, 50);
					JButton jb_xoa = new JButton("Xoá");
					jb_xoa.setBounds(10, 75, 100, 50);
	
					JButton jb_thoat = new JButton("Thoát");
					jb_thoat.setBounds(10, 132, 100, 50);
	
					jp_center.add(jb_giai);
					jp_center.add(jb_xoa);
					jp_center.add(jb_thoat);

		
		this.setLayout(new BorderLayout());	
		this.add(jb, BorderLayout.NORTH);
		this.add(jp_center);
		
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new Pheptoan();
	}
}
