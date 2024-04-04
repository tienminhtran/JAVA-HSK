package demo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class giaiPhuongTrinhBacHai_test extends JFrame implements ActionListener{

	//private ActionPerformed actionPerformed;
	private JLabel jta_kq;
	private JLabel jl_ht;
	private JTextField jtf_a;
	private JTextField jtf_b;
	private JTextField jtf_c;
	private JTextField jtf_ht;
	private JButton jb_giai;
	private JButton jb_xoa_rong;
	private JButton jb_thoat; 
	
	public giaiPhuongTrinhBacHai_test() throws HeadlessException {

		this.setTitle("^-^");
		this.setSize(400,280);
		this.setAutoRequestFocus(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.Init();
		addAction();
		//this.setResizable(false);
		
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
			//jp_input.setLayout(new BorderLayout());
			jp_input.setLayout(null);
//			JLabel jta_rong1 = new JLabel();
//			JLabel jta_rong2 = new JLabel();
//			JLabel jta_rong3 = new JLabel();
//			JLabel jta_rong4= new JLabel();
//			JLabel jta_rong5 = new JLabel();
//			JLabel jta_rong6 = new JLabel();
//			JLabel jta_rong7 = new JLabel();
//			JLabel jta_rong8= new JLabel();
			
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

				//LineBorder lb = new LineBorder(Color.CYAN);

				jtf_ht = new JTextField(20);
				jtf_ht.setEditable(false);
				jtf_ht.setBounds(90, 90, 220, 20);

				
				
				//jp_input.add(jta_rong1);
				jp_input.add(jl_a);
				jp_input.add(jtf_a);
				//jp_input.add(jta_rong5);

			//	jp_input.add(jta_rong2);
				jp_input.add(jl_b);
				jp_input.add(jtf_b);
				//jp_input.add(jta_rong6);

			//	jp_input.add(jta_rong3);
				jp_input.add(jl_c);
				jp_input.add(jtf_c);
				//jp_input.add(jta_rong7);

				//jp_input.add(jta_rong4);
				jp_input.add(jl_kq);
				jp_input.add(jtf_ht);
				//jp_input.add(jta_rong8);

			
			JPanel jp_bottom = new JPanel();
			TitledBorder tb = new TitledBorder("Chọn tác vụ");
			jp_bottom.setBorder(tb);
			
				//ActionPerformed ac = new ActionPerformed(this);
				// sự kiện 
				jb_giai = new JButton("Giải");
				//jb_giai.addActionListener(ac);				

				jb_xoa_rong = new JButton("Xoá rỗng");
				//jb_xoa_rong.addActionListener(ac);				

				jb_thoat = new JButton("Thoát");
				//jb_thoat.addActionListener(ac);

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
//		int a = Integer.parseInt(this.jtf_a.getText().trim());
//		int b = Integer.parseInt(this.jtf_b.getText().trim());
//		int c = Integer.parseInt(this.jtf_c.getText().trim());
		String htkq = " ";
		if(a==0)
		{
			if(b==0)
			{
				if(c==0)
				{
					htkq = "Phương trình có vô số nghiệm";
				}else
				{
					htkq = "Phương trình có vô nghiệm: x =";

				}
			}else
			{
				double deta = b*b - 4*a*c;
				if(deta < 0)
				{
					htkq = "Phương trình có vô nghiệm";
				}else if (deta == 0)
				{
					htkq = "Phương trình có nghiệm kép x = "+(-b/(2*a));
				}else
				{
					htkq =  "Phương trình có nghiệm 2 nghiệm x1 = "+(-b + Math.sqrt(deta))/2*a + "x2 = " + (-b - Math.sqrt(deta))/2*a ;
				}

			}
		}
		//jtf_ht.setText(htkq);
	}
	public void Xoatrang() {
		this.jtf_a.setText(" ");
		this.jtf_b.setText(" ");
		this.jtf_c.setText(" ");
		this.jtf_ht.setText(" ");
		
	}
	public void thoat() {
		int anw = JOptionPane.showConfirmDialog(rootPane, "Có muốn thoát không? ");
		// hiện thi YES NO  K HIỂN THI CANEL 
		//int anw = JOptionPane.showConfirmDialog(rootPane, "Có muốn thoát không? ","Cảnh báo", JOptionPane.YES_NO_OPTION);
		if(anw == 0)
		{
			System.exit(0);
		}else {
			
		}
		
	}

	// thêm sự kiện
	public void addAction() {
		jb_giai.addActionListener(this);				
		jb_xoa_rong.addActionListener(this);				
		jb_thoat.addActionListener(this);
	}
	public static void main(String[] args) {
		new giaiPhuongTrinhBacHai_test();
		//actionPerformed
	}
	@Override
	public void actionPerformed(ActionEvent e) {
			String src = e.getActionCommand();
			if(src.equals("Giải"))
			{
				this.giaiPhuongTrinh();
			}else if(src.equals("Xoá rỗng"))
			{
				this.Xoatrang();
			}else {
				this.thoat();
			}
			
		
	}
	
}
