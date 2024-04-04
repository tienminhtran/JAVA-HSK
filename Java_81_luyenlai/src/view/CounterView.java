package view;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.CounterListener;
import model.CounterModel;

public class CounterView extends JFrame{
	private CounterModel counterModel;
	private JButton jbutton_tang;
	private JButton jbutton_giam;
	private JLabel jlabel_value;
	
	public CounterView() {
		this.counterModel = new CounterModel();
		this.setVisible(true);
		this.init();
	}
	public void init() {
		this.setTitle("Counter");
		this.setSize(300,300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ActionListener ac = new CounterListener(this);
		
		
		jbutton_tang = new JButton("Up");
		jbutton_tang.addActionListener(ac);
		
		jbutton_giam = new JButton("Down");
		jbutton_giam.addActionListener(ac);

		
		jlabel_value = new JLabel(this.counterModel.getValue()+"",JLabel.CENTER);
		
		JPanel jp = new JPanel();
		jp.setLayout(new BorderLayout());

		
		jp.add(jbutton_tang, BorderLayout.WEST);
		jp.add(jbutton_giam, BorderLayout.EAST);
		jp.add(jlabel_value, BorderLayout.CENTER);
		
// chương trình chinh hiển thị
		this.setLayout(new BorderLayout());
		this.add(jp,BorderLayout.CENTER);
	}
	public void tang() {
		this.counterModel.tang();
		this.jlabel_value.setText(this.counterModel.getValue()+"");
	}
	public void giam() {
		this.counterModel.giam();
		this.jlabel_value.setText(this.counterModel.getValue()+"");
	}
	
}
