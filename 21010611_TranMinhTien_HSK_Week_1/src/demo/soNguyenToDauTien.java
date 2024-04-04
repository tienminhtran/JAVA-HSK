package demo;

import java.io.PrintStream;

public class soNguyenToDauTien {
	private int n;
	private String kq = "";


	
	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public String getKq() {
		return kq;
	}

	public void setKq(String kq) {
		this.kq = kq;
	}

	public soNguyenToDauTien(int n) {
		super();
		this.n = n;
		//this.kq = kq;
	}

	public boolean checkSNT(int n)
	{
		if(this.n < 2)
		{
			return false;
		}
		for (int i = 2; i*i <=n; i++) {
			if(n % i == 0)
			{
				return false;
			}
		}
		return true; // snt

	}
	//@Override

	public String toString() {
		int dem = 0;
		int i = 2;

		while (dem < this.n) {
			if(checkSNT(i))
			{
				 kq = kq + i + "\n";
				dem++;		
			}
			i++;
		}
		
		return kq;
	}
	public static void main(String[] args) {
		soNguyenToDauTien a = new soNguyenToDauTien(5);
		System.out.println(a.toString());
		
		
	}

}
