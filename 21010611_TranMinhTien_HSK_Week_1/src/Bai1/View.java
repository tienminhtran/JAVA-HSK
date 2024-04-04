package Bai1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class View extends JFrame{

	private Model model;
	private JLabel jta_kq;
	private JLabel jl_ht;
	private JTextField jtf_a;
	private JTextField jtf_b;
	private JTextField jtf_c;
	private JTextField jtf_ht; 
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
			jp_input.setLayout(null);

				JLabel jl_a = new JLabel("Nhập a:");
				jl_a.setBounds(30, 30, 60, 20);
				jtf_a = new JTextField(25);
				jtf_a.setBounds(90, 30, 220, 20);

				JLabel jl_b = new JLabel("Nhập b:");
				jl_b.setBounds(30, 50, 60, 20);
				jtf_b = new JTextField(25);
				jtf_b.setBounds(90, 50, 220, 20);

				
				JLabel jl_c = new JLabel("Nhập c:");
				jl_c.setBounds(30, 70, 60, 20);
				jtf_c = new JTextField(25);
				jtf_c.setBounds(90, 70, 220, 20);

				JLabel jl_kq = new JLabel("Kết quả:");
				jl_kq.setBounds(30, 90, 60, 20);


				jl_ht = new JLabel();
				jtf_ht = new JTextField();
				jtf_ht.setEditable(false);
				jtf_ht.setBounds(90, 90, 220, 20);

				
				
				jp_input.add(jl_a);
				jp_input.add(jtf_a);

				jp_input.add(jl_b);
				jp_input.add(jtf_b);

				jp_input.add(jl_c);
				jp_input.add(jtf_c);

				jp_input.add(jl_kq);
				jp_input.add(jtf_ht);

			
			JPanel jp_bottom = new JPanel();
			TitledBorder tb = new TitledBorder("Chọn tác vụ");
			jp_bottom.setBorder(tb);
				// sự kiện listen
				Controller sukien = new Controller(this);
				
				JButton jb_giai = new JButton("Giải");
				jb_giai.addActionListener(sukien);
				JButton jb_xoa_rong = new JButton("Xoá rỗng");
				jb_xoa_rong.addActionListener(sukien);

				JButton jb_thoat = new JButton("Thoát");
				jb_thoat.addActionListener(sukien);

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


		Double a = Double.valueOf(this.jtf_a.getText());
		Double b = Double.valueOf(this.jtf_b.getText());
		Double c = Double.valueOf(this.jtf_c.getText());		

		this.model.setA(a);
		this.model.setB(b);
		this.model.setC(c);
		this.model.tinh();		
		this.jtf_ht.setText(String.valueOf(this.model.getKetqua())+" ");
		
	}
	public void Xoatrang() {
		this.jtf_a.setText(" ");
		this.jtf_b.setText(" ");
		this.jtf_c.setText(" ");
		this.jtf_ht.setText(" ");
		
	}
	public void thoat() {
			System.exit(0);
	}
}
