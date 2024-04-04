package Bai2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Primes_Controller implements ActionListener{

	private Primes_View primes_View; 

	public Primes_Controller(Primes_View primes_View) {
		this.primes_View = primes_View;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if(src.equals("Generate"))
		{
			this.primes_View.hienthi();
		}
		
	}

}
