package Bai1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class View extends JFrame{

	private Model model;
	private JLabel jta_kq; 
	public View() {
		this.model = new Model();
		this.setTitle("^-^");
		this.setSize(400,280);
		this.setAutoRequestFocus(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.Init();
		this.setResizable(false);
		
	}
	private void Init() {
		Font f = new Font("Arial", Font.BOLD , 16);
		
		JPanel jp = new JPanel();
		jp.setLayout(new BorderLayout());
			JPanel jp_title = new JPanel();
			JLabel jl_title = new JLabel("GIẢI PHƯƠNG TRÌNH BẬC HAI", JLabel.CENTER);
			jl_title.setFont(f);
			jp_title.add(jl_title);
			jp_title.setBackground(Color.CYAN);
			
			JPanel jp_input = new JPanel();
			jp_input.setLayout(new GridLayout(4,3));
			
			JLabel jta_rong1 = new JLabel();
			JLabel jta_rong2 = new JLabel();
			JLabel jta_rong3 = new JLabel();
			JLabel jta_rong4= new JLabel();
			JLabel jta_rong5 = new JLabel();
			JLabel jta_rong6 = new JLabel();
			JLabel jta_rong7 = new JLabel();
			JLabel jta_rong8= new JLabel();
			
				JLabel jl_a = new JLabel("Nhập a:");
				JTextField jtf_a = new JTextField();
				
				JLabel jl_b = new JLabel("Nhập b:");
				JTextField jtf_b = new JTextField();
		
				
				JLabel jl_c = new JLabel("Nhập c:");
				JTextField jtf_c = new JTextField();
		
				JLabel jl_kq = new JLabel("Kết quả:");
				LineBorder lb = new LineBorder(Color.CYAN);

				jta_kq = new JLabel("");
				jta_kq.setBorder(lb);
				
				
				jp_input.add(jta_rong1);
				jp_input.add(jl_a);
				jp_input.add(jtf_a);
				jp_input.add(jta_rong5);

				jp_input.add(jta_rong2);
				jp_input.add(jl_b);
				jp_input.add(jtf_b);
				jp_input.add(jta_rong6);

				jp_input.add(jta_rong3);
				jp_input.add(jl_c);
				jp_input.add(jtf_c);
				jp_input.add(jta_rong7);

				jp_input.add(jta_rong4);
				jp_input.add(jl_kq);
				jp_input.add(jta_kq);
				jp_input.add(jta_rong8);

			
			JPanel jp_bottom = new JPanel();
			TitledBorder tb = new TitledBorder("Chọn tác vụ");
			jp_bottom.setBorder(tb);
				// sự kiện listen
				controller sukien = new controller(this);
				
				JButton jb_giai = new JButton("Giải");
				jb_giai.addActionListener(sukien);
				JButton jb_xoa_rong = new JButton("Xoá rỗng");
				JButton jb_thoat = new JButton("Thoát");
				
				jp_bottom.add(jb_giai);
				jp_bottom.add(jb_xoa_rong);
				jp_bottom.add(jb_thoat);

		jp.add(jp_title, BorderLayout.NORTH);
		jp.add(jp_input, BorderLayout.CENTER);
		jp.add(jp_bottom, BorderLayout.SOUTH);

				
		// chính
			this.setLayout(new BorderLayout());
			this.add(jp);
		
		this.setVisible(true);
		
	}
	public void giaiPhuongTrinh() {
		this.model.kq();
		this.jta_kq.setText("X1 = "+this.model.getX1()+"X2 = "+this.model.getX2());
		
	}
}
