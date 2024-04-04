package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import Model.ThucDonModel;



public class ThucDonView extends JFrame{
	public ThucDonModel thucDonModel;
	private JRadioButton jrb_com;
	private JRadioButton jrb_pho;
	private JRadioButton jrb_banhmi;
	private JCheckBox jcb_sam;
	private JCheckBox jcb_pesi;
	private JCheckBox jcb_tauhu;
	private JCheckBox jcb_raucau;
	private ButtonGroup bg_chinh;
	private ButtonGroup bg_phu;
	
	public ThucDonView() {
	
		this.thucDonModel = new ThucDonModel();
		this.init();
		this.setVisible(true);
	}

	public void init() {
		this.setTitle("THỰC ĐƠN");
		this.setSize(500,450);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		Font f = new Font("Cambria", Font.PLAIN, 20);
		Font f1 = new Font("#9Slide05 SVNUT Triumph", Font.BOLD, 40);

		
		
		JPanel jp_title = new JPanel();
			JLabel jl_title = new JLabel("Thực đơn nhà hàng", JLabel.CENTER);
			jl_title.setFont(f1);
			jl_title.setForeground(Color.red);
			jp_title.add(jl_title);
			this.add(jl_title, BorderLayout.NORTH);
			
		//JLabel lj_tenmonchinh = new JLabel("Món chính");
		TitledBorder lB_tenmonchinh = new TitledBorder("Món chính");
		JPanel jp_chinh = new JPanel();
				jp_chinh.setLayout(null);
				jp_chinh.setBorder(lB_tenmonchinh);
				
				
				
				jp_chinh.setBounds(2, 50, 600, 80);
				
			//	lj_tenmonchinh.setBounds(30, 60, 60, 10);
			//jp_chinh.setLayout(new GridLayout(1,3));
			
				jrb_com = new JRadioButton("Cơm");
				jrb_com.setBounds(100, 20, 90, 50);
				jrb_com.setFont(f);

				jrb_pho = new JRadioButton("Phở");
				jrb_pho.setBounds(200, 20, 90, 50);
				jrb_pho.setFont(f);

				jrb_banhmi = new JRadioButton("Bánh Mỳ");
				jrb_banhmi.setBounds(300, 20, 100, 50);
				jrb_banhmi.setFont(f);

				jp_chinh.add(jrb_com);
				jp_chinh.add(jrb_pho);
				jp_chinh.add(jrb_banhmi);
				//jp_chinh.add(lB_tenmonchinh);
				//this.add(lj_tenmonchinh);
				
				// tạo BUTTON GORUP
				
				bg_chinh = new ButtonGroup();
				bg_chinh.add(jrb_com);
				bg_chinh.add(jrb_pho);
				bg_chinh.add(jrb_banhmi);

		
		//JLabel lj_tenmonphu= new JLabel("Món phụ");
		
		
		JPanel jp_phu = new JPanel();
		TitledBorder tb_tenmonphu = new TitledBorder("Món phụ");
		jp_phu.setBounds(2, 150, 600, 100);
		jp_phu.setLayout(null);
		jp_phu.setBorder(tb_tenmonphu);

		
		//tb_tenmonphu.setBounds(30, 140, 60, 20);

		
		
			jcb_raucau = new JCheckBox("Rau câu");	
			jcb_raucau.setBounds(150, 15, 100, 20);
			jcb_raucau.setFont(f);

			jcb_pesi = new JCheckBox("Nước Pesi");
			jcb_pesi.setBounds(250, 15, 120, 20);
			jcb_pesi.setFont(f);

			jcb_tauhu = new JCheckBox("Tàu hũ");
			jcb_tauhu.setBounds(150, 50, 100, 20);
			jcb_tauhu.setFont(f);

			jcb_sam = new JCheckBox("Nước sâm");
			jcb_sam.setBounds(250, 50, 150, 20);
			jcb_sam.setFont(f);

				
			jp_phu.add(jcb_raucau);
			jp_phu.add(jcb_pesi);
			jp_phu.add(jcb_tauhu);
			jp_phu.add(jcb_sam);
			// tạo BUTTON GORUP
			bg_phu = new ButtonGroup();
			bg_phu.add(jcb_raucau);
			bg_phu.add(jcb_pesi);
			bg_phu.add(jcb_tauhu);
			bg_phu.add(jcb_sam);

			
		JPanel jp_chinh_phu = new JPanel();
		jp_chinh_phu.setLayout(null);
		jp_chinh_phu.add(jp_chinh);
		jp_chinh_phu.add(jp_phu);

		
		JPanel jp_botom = new JPanel();
		jp_botom.setLayout(null);
		
		
			JButton jb_thanhtoan = new JButton("Thanh toán");
			jb_thanhtoan.setLayout(null);

			jb_thanhtoan.setBounds(300, 20, 150, 50);				
			jp_botom.add(jb_thanhtoan);
		//	jp_botom.setBounds(200, 100, 150, 50);				

		jp_botom.setBounds(getBounds());
		JTextArea jta_tonghop = new JTextArea();
		jta_tonghop.setBackground(Color.BLUE);
		jta_tonghop.setEditable(false);
		
	
		this.setLayout(new GridLayout(6,1));
		this.add(jp_title, BorderLayout.NORTH);
		this.add(jp_chinh);
		this.add(jp_phu);		
		this.add(jta_tonghop);
		this.add(jp_botom);
		//this.add(jp_chinh_phu, BorderLayout.CENTER);
		
		//this.add(jb_thanhtoan, BorderLayout.CENTER);
	}
}
