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
	private JButton jbutton_up;
	private JButton jbutton_down;
	private JButton jbutton_reset;
	private JLabel jlabel_value;
	public CounterView() {
		this.counterModel = new CounterModel();
		this.init();
		this.setVisible(true);
	}
	public void init() {
		this.setTitle("Counter");
		this.setSize(300,300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		ActionListener ac = new CounterListener(this);
		
		jbutton_up = new JButton("Up");
		jbutton_up.addActionListener(ac);
		
		jbutton_down = new JButton("Down");
		jbutton_down.addActionListener(ac);

		jbutton_reset= new JButton("Reset");
		jbutton_reset.addActionListener(ac);
		
		
		jlabel_value = new JLabel(this.counterModel.getValue()+"", JLabel.CENTER);
		
		JPanel jp = new JPanel();
		jp.setLayout(new BorderLayout());
		
		jp.add(jbutton_up, BorderLayout.WEST);
		jp.add(jbutton_down, BorderLayout.EAST);
		jp.add(jbutton_reset, BorderLayout.SOUTH);

		jp.add(jlabel_value, BorderLayout.CENTER);
		
		this.setLayout(new BorderLayout());
		this.add(jp,BorderLayout.CENTER);
	}
	public void increment() {
		this.counterModel.increment();
		this.jlabel_value.setText(this.counterModel.getValue()+"");
	}
	public void decrement() {
		this.counterModel.decrement();
		this.jlabel_value.setText(this.counterModel.getValue()+"");
	}
	public void reset() {
		this.counterModel.reset();
		this.jlabel_value.setText(this.counterModel.getValue()+"");
	}
}
