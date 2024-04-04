package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import controller.TimKiemController;
import model.TimKiemModel;

public class TimKiemView extends JFrame{

	private TimKiemModel timKiemModel;
	private JTextField jtf_tukhoa;
	private JTextArea jta_vanban;
	private JLabel jl_kq;

	public TimKiemView() {
		this.timKiemModel = new TimKiemModel();
		this.init();
		
	}

	private void init() {
		this.setTitle("Tìm kiếm");
		this.setSize(600,400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Font f = new Font("Cambria", Font.BOLD, 20);
		
		// tạo listener
		TimKiemController tkc = new TimKiemController(this);
		// tạo khung trên chứa nội dung văn bản
		JLabel jl_vanban = new JLabel("Văn bản");
		jl_vanban.setFont(f);
		
		
		
		jta_vanban = new JTextArea(100,100);
		jta_vanban.setFont(f);

			JPanel jp_center = new JPanel();
			jp_center.setLayout(new BorderLayout());
			jp_center.add(jl_vanban,BorderLayout.NORTH);
			jp_center.add(jta_vanban,BorderLayout.CENTER);

		
		// tạo khung bottom và nút button
		JLabel jl_tukhoa = new JLabel("Từ khoá");
		jl_tukhoa.setFont(f);
		
		jtf_tukhoa = new JTextField();
		jtf_tukhoa.setFont(f);

			JPanel jp_tukhoa = new JPanel();
			jp_tukhoa.setLayout(new GridLayout(1, 1));
			jp_tukhoa.add(jl_tukhoa);
			jp_tukhoa.add(jtf_tukhoa);

		
		JButton jb_thongke = new JButton("Thống kê");
		jb_thongke.setFont(f);
		jb_thongke.setForeground(Color.WHITE);
		jb_thongke.setBackground(Color.BLUE);
		jb_thongke.setOpaque(true);
		jb_thongke.addActionListener(tkc);
		
		jl_kq = new JLabel();
		jl_kq.setFont(f);
		jl_kq.setForeground(Color.RED);
		jl_kq.setBackground(Color.PINK);
		jl_kq.setOpaque(true);

			JPanel jp_thongke_kq= new JPanel();
			jp_thongke_kq.setLayout(new GridLayout(1, 2));
			jp_thongke_kq.add(jb_thongke);
			jp_thongke_kq.add(jl_kq);
			
		// ráp JPanel jp_tukhoa AND jp_thongke_kq
			JButton jb_bottom = new JButton();
			jb_bottom.setLayout(new BorderLayout());
			jb_bottom.add(jp_tukhoa,BorderLayout.CENTER);
			jb_bottom.add(jp_thongke_kq,BorderLayout.SOUTH);

		// Khung chính
			this.setLayout(new BorderLayout());
			this.add(jp_center, BorderLayout.CENTER);
			this.add(jb_bottom, BorderLayout.SOUTH);

			
		this.setVisible(true);
	}
	public void timKiem()
	{
		this.timKiemModel.setVanBan(this.jta_vanban.getText());
		this.timKiemModel.setTuKhoa(this.jtf_tukhoa.getText());
		this.timKiemModel.timKiem();
		this.jl_kq.setText(this.timKiemModel.getKetQua());
	}
	
}
