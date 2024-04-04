package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.MiniCalculatorController;
import model.MiniCalculatorModel;

public class MiniCalculatorView extends JFrame {

	private MiniCalculatorModel miniCalculatorModel;
	private JTextField jtf_value_st1;
	private JTextField jtf_value_st2;
	private JTextField jtf_answer;

	public MiniCalculatorView() {
		this.miniCalculatorModel = new MiniCalculatorModel();
		this.init();
	}

	private void init() {
		this.setTitle("Mini Calculator");
		this.setSize(500,200);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Font f = new Font("Cambria", Font.BOLD, 20);
		
		// tạo khung trên, textfiled

		
		
			JLabel jl_value_st1 = new JLabel("1st Value");
			jl_value_st1.setFont(f);
			
			JLabel jl_value_st2 = new JLabel("2st Value");
			jl_value_st2.setFont(f);
	
			JLabel jl_answer= new JLabel("Answer");
			jl_answer.setFont(f);

		
			// tạo textfield
			jtf_value_st1 = new JTextField(20);
			jtf_value_st1.setFont(f);
			
			jtf_value_st2 = new JTextField(50);			
			jtf_value_st2.setFont(f);

			jtf_answer = new JTextField(50);
			jtf_answer.setFont(f);

		
			JPanel jp_center = new JPanel();
			jp_center.setLayout(new GridLayout(3,2,10,10));
			
			jp_center.add(jl_value_st1);
			jp_center.add(jtf_value_st1);
			
			jp_center.add(jl_value_st2);
			jp_center.add(jtf_value_st2);
			
			jp_center.add(jl_answer);
			jp_center.add(jtf_answer);
	
		// tạo khung bottom
				// tạo listenr
			MiniCalculatorController miniCalculatorController = new MiniCalculatorController(this);

			JButton jb_cong = new JButton("+");
			jb_cong.addActionListener(miniCalculatorController);
			jb_cong.setFont(f);
			
			JButton jb_tru = new JButton("-");
			jb_tru.addActionListener(miniCalculatorController);
			jb_tru.setFont(f);
			
			JButton jb_nhan = new JButton("*");
			jb_nhan.addActionListener(miniCalculatorController);
			jb_nhan.setFont(f);
			
			JButton jb_chia = new JButton("/");
			jb_chia.addActionListener(miniCalculatorController);
			jb_chia.setFont(f);
			
			JButton jb_luythua = new JButton("^");
			jb_luythua.addActionListener(miniCalculatorController);
			jb_luythua.setFont(f);
			
			JButton jb_div = new JButton("%");
			jb_div.addActionListener(miniCalculatorController);
			jb_div.setFont(f);
			
			JPanel jp_bottom = new JPanel();
			jp_bottom.setLayout(new GridLayout(2,3, 5,5));
			jp_bottom.add(jb_cong);
			jp_bottom.add(jb_tru);
			jp_bottom.add(jb_nhan);
			jp_bottom.add(jb_chia);
			jp_bottom.add(jb_luythua);
			jp_bottom.add(jb_div);
			
		// khung chính
			this.setLayout(new BorderLayout(10,10));
			this.add(jp_center,BorderLayout.CENTER);
			this.add(jp_bottom,BorderLayout.SOUTH);
			
		this.setVisible(true);
	}
	public void cong() {
		double firstValue = Double.valueOf(jtf_value_st1.getText());
		double secondValue = Double.valueOf(jtf_value_st2.getText());
		this.miniCalculatorModel.setFirstValue(firstValue);
		this.miniCalculatorModel.setSecondValue(secondValue);
		this.miniCalculatorModel.cong();
		this.jtf_answer.setText(this.miniCalculatorModel.getAnswer()+"");
		
	}
	public void tru() {
		double firstValue = Double.valueOf(this.jtf_value_st1.getText());
		double secondValue = Double.valueOf(this.jtf_value_st2.getText());
		this.miniCalculatorModel.setFirstValue(firstValue);
		this.miniCalculatorModel.setSecondValue(secondValue);
		this.miniCalculatorModel.tru();
		this.jtf_answer.setText(this.miniCalculatorModel.getAnswer()+"");
	}
	
	public void nhan() {
		double firstValue = Double.valueOf(this.jtf_value_st1.getText());
		double secondValue = Double.valueOf(this.jtf_value_st2.getText());
		this.miniCalculatorModel.setFirstValue(firstValue);
		this.miniCalculatorModel.setSecondValue(secondValue);
		this.miniCalculatorModel.nhan();
		this.jtf_answer.setText(this.miniCalculatorModel.getAnswer()+"");	}
	
	public void chia() {
		double firstValue = Double.valueOf(this.jtf_value_st1.getText());
		double secondValue = Double.valueOf(this.jtf_value_st2.getText());
		this.miniCalculatorModel.setFirstValue(firstValue);
		this.miniCalculatorModel.setSecondValue(secondValue);
		this.miniCalculatorModel.chia();
		this.jtf_answer.setText(this.miniCalculatorModel.getAnswer()+"");	}
	
	public void luythua() {
		double firstValue = Double.valueOf(this.jtf_value_st1.getText());
		double secondValue = Double.valueOf(this.jtf_value_st2.getText());
		this.miniCalculatorModel.setFirstValue(firstValue);
		this.miniCalculatorModel.setSecondValue(secondValue);
		this.miniCalculatorModel.luythua();
		this.jtf_answer.setText(this.miniCalculatorModel.getAnswer()+"");	}
	
	public void mod() {
		double firstValue = Double.valueOf(this.jtf_value_st1.getText());
		double secondValue = Double.valueOf(this.jtf_value_st2.getText());
		this.miniCalculatorModel.setFirstValue(firstValue);
		this.miniCalculatorModel.setSecondValue(secondValue);
		this.miniCalculatorModel.mod();
		this.jtf_answer.setText(this.miniCalculatorModel.getAnswer()+"");	}
	
}
