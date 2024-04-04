package bai1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class bai extends JFrame {
		public bai() {
			setTitle("^-^");
			setSize(400,200);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setLocationRelativeTo(null);
			init();//setResizable(false);
			setVisible(true);
			
		}
	private void init() {
			JLabel jLabel_title = new JLabel("GIẢI PHƯƠNG TRÌNH BẬC HAI",JLabel.CENTER);
			jLabel_title.setFont(new Font("Arial", Font.BOLD, 20));
			
			JPanel jPanel_north = new JPanel();
			jPanel_north.setBackground(Color.cyan);
			jPanel_north.add(jLabel_title);
						
			JPanel jPanel_center = new JPanel();
			
			JPanel jp_r1 = new JPanel();
			JPanel jp_r2 = new JPanel();
			JPanel jp_r3 = new JPanel();
			JPanel jp_r4 = new JPanel();
			
			JLabel jLabel_a = new JLabel("Nhập a:");
			JLabel jLabel_b = new JLabel("Nhập b:");
			JLabel jLabel_c = new JLabel("Nhập c:");
			JLabel jLabel_kq = new JLabel("Kết quả:");
			
			JTextField jTextField_a = new JTextField();
			JTextField jTextField_b = new JTextField();
			JTextField jTextField_c = new JTextField();
			JTextField jTextField_kq = new JTextField();
			jTextField_kq.setEditable(false);
			jPanel_center.setLayout(new GridLayout(4, 4));

			jPanel_center.add(jLabel_a);
			jPanel_center.add(jTextField_a);
			jPanel_center.add(jp_r1);
			jPanel_center.add(jp_r2);

			jPanel_center.add(jLabel_b);
			jPanel_center.add(jTextField_b);
			jPanel_center.add(jp_r2);

			jPanel_center.add(jLabel_c);
			jPanel_center.add(jTextField_c);
			jPanel_center.add(jp_r3);

			jPanel_center.add(jLabel_kq);
			jPanel_center.add(jTextField_kq);
			jPanel_center.add(jp_r4);

			
			//các jbutton
			JButton jbt_giai= new JButton("Giải");
			JButton jbt_xoa= new JButton("Xóa");
			JButton jbt_thoat= new JButton("Thoát");
			
			//khu vực phía nam
			JPanel jPanel_southJ = new JPanel();
			jPanel_southJ.add(jbt_giai);
			jPanel_southJ.add(jbt_xoa);
			jPanel_southJ.add(jbt_thoat);
			
			jPanel_southJ.setBorder(new TitledBorder("Chọn tác vụ"));
			
			
			this.setLayout(new BorderLayout());
			this.add(jPanel_north, BorderLayout.NORTH);
			this.add(jPanel_center, BorderLayout.CENTER);
			this.add(jPanel_southJ,BorderLayout.SOUTH);
		}
	public static void main(String[] args) {
		new bai();
	}
}
