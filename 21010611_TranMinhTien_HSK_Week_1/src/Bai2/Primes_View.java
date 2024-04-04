package Bai2;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class Primes_View extends JFrame{

	private Primes_Model primes_Model;
	private JTextArea jTA;
	private JTextField jt;
	public Primes_View() {
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
		Primes_Controller pc = new Primes_Controller(this);
		jt = new JTextField();
		jt.setBounds(50, 30,200,25);
		JButton jb = new JButton("Generate");
		jb.addActionListener(pc);
		jb.setBounds(250,30,90,25);
		

		this.add(jt);
		this.add(jb);
		
	
		jTA = new JTextArea();
		jTA.setBounds(50,70,290,135);
		jTA.setEditable(false);
		
		this.add(jTA);
		this.setVisible(true);
	}

	//int c = Integer.parseInt(this.jtf_c.getText().trim());
	public void hienthi()
	{
		int so = Integer.valueOf(this.jt.getText());
		this.primes_Model.setN(so);
		this.primes_Model.ketqua();
		this.jTA.setText(String.valueOf(this.primes_Model.getKq()));
	}
}
