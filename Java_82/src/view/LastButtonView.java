package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.LastButtonController;
import model.LastButtonModel;

public class LastButtonView extends JFrame{

	private LastButtonModel lastButtonModel;
	private JLabel jlable;

	public LastButtonView(){
		this.lastButtonModel = new LastButtonModel();
		this.init();
		this.setVisible(true);
	}

	private void init() {
		this.setTitle("Lats Button");
		this.setSize(300,300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		// khung trên
		JPanel jp_Center = new JPanel();
		jp_Center.setLayout(new GridLayout(2, 2));
		
			// tạo forn chữ
		Font f = new Font("Cambria", Font.PLAIN, 20);
		
		// tạo listener
		LastButtonController lbc = new LastButtonController(this);
		
		JButton jb_1 = new JButton("1");
		jb_1.setFont(f);
		jb_1.addActionListener(lbc);
		
		JButton jb_2 = new JButton("2");
		jb_2.setFont(f);
		jb_2.addActionListener(lbc);

		JButton jb_3 = new JButton("3");
		jb_3.setFont(f);
		jb_3.addActionListener(lbc);

		JButton jb_4 = new JButton("4");
		jb_4.setFont(f);
		jb_4.addActionListener(lbc);

		jp_Center.add(jb_1);
		jp_Center.add(jb_2);
		jp_Center.add(jb_3);
		jp_Center.add(jb_4);
		
		
		
		// khung dưới
		JPanel jp_bottom = new JPanel();
		jp_bottom.setLayout(new BorderLayout());
		
		jlable = new JLabel("---",JLabel.CENTER);
		jlable.setFont(f);

		jp_bottom.add(jlable);
		
		
		// khung chính
		
		this.setLayout(new BorderLayout());
		this.add(jp_Center, BorderLayout.CENTER);
		this.add(jp_bottom, BorderLayout.SOUTH);

	}
	public void changeTo_1() {
		this.lastButtonModel.setValue_1();
		this.jlable.setText("Last button: "+this.lastButtonModel.getValue());
	}

	
	public void changeTo_2() {
		this.lastButtonModel.setValue_2();
		this.jlable.setText("Last button: "+this.lastButtonModel.getValue());
	}
	
	public void changeTo_3() {
		this.lastButtonModel.setValue_3();
		this.jlable.setText("Last button: "+this.lastButtonModel.getValue());
	}

	
	public void changeTo_4() {
		this.lastButtonModel.setValue_4();
		this.jlable.setText("Last button: "+this.lastButtonModel.getValue());
	}
	
	
	
	
	
}
