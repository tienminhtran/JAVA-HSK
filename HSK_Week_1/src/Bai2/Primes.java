package Bai2;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class Primes extends JFrame{

	public Primes() {
		this.setTitle("Primes");
		this.setSize(400,280);
		this.setAutoRequestFocus(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.init();
		this.setResizable(false);
	}

	private void init() {
		setLayout(null);
		
		JTextField jt = new JTextField();
		jt.setBounds(50, 30,200,50);
		JButton jb = new JButton("Generate");
		jb.setBounds(250,30,90,50);
		

		this.add(jt);
		this.add(jb);
		
	
		JTextArea jTA = new JTextArea("---------------------------");
		jTA.setBounds(50,100,90,50);
		this.add(jTA);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new Primes();
		
	}
}
