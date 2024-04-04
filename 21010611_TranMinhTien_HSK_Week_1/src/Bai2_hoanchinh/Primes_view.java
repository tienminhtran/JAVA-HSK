package Bai2_hoanchinh;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Primes_view extends JFrame implements ActionListener {

	private Primes_model prtModel;
	private JButton jtb_generate;
	private JTextField jField_nhap;
	private JTextArea jArea_hienthi;

	public Primes_view() {
		prtModel = new Primes_model();

		setTitle("Primes");
		setSize(450, 350);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void createGui() {
		setLayout(null);
		jField_nhap = new JTextField(20);
		jField_nhap.setToolTipText("Nhập số nguyên tố cần hiển thị");

		jtb_generate = new JButton("Generate");

		jArea_hienthi = new JTextArea();
		JScrollPane scroll = new JScrollPane(jArea_hienthi);
		jArea_hienthi.setToolTipText("Các số nguyên tố");
		jArea_hienthi.setEditable(false);

		jtb_generate.addActionListener(this);

//Cách 1
		jField_nhap.setBounds(50, 30, 200, 30);
		jtb_generate.setBounds(260, 30, 90, 30);
		scroll.setBounds(50, 70, 300, 170);
		this.add(jField_nhap);
		this.add(jtb_generate);
		this.add(scroll);

//Cách 2
//		JPanel jPanel_north= new JPanel();
//		jPanel_north.add(jField_nhap);
//		jPanel_north.add(jtb_generate);
//		
//		this.setLayout(new BorderLayout(50,40));
//		this.add(jPanel_north,  BorderLayout.NORTH);
//		this.add(scroll, BorderLayout.CENTER);
//		this.add(new JPanel(), BorderLayout.EAST);
//		this.add(new JPanel(), BorderLayout.WEST);
//		this.add(new JPanel(), BorderLayout.SOUTH);

		this.setVisible(true);
	}

	public void soNGTo() {
		try {
			int n = Integer.valueOf(jField_nhap.getText());

			if (n > 0) {
				prtModel.setN(n);
				prtModel.soNgt(n);
				jArea_hienthi.setText(prtModel.getAnswer());
			} else {
				JOptionPane.showMessageDialog(null, "Chỉ nhập số nguyên dương");
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Nhập sai dữ liệu");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String string = e.getActionCommand();
		if (string.equals("Generate")) {
			soNGTo();
		}
	}

	public static void main(String[] args) {
		Primes_view pri = new Primes_view();
		pri.createGui();
	}
}
