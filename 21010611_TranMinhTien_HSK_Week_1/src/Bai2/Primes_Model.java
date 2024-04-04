package Bai2;

public class Primes_Model {

	private int n;
	private String kq;


	
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

	public Primes_Model(int n) {
		super();
		this.n = n;
		this.kq = kq;
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
	public String ketqua() {
		int dem = 0;
		int i = 2;
		String s = "";
		while (dem < n) {
			if(checkSNT(i))
			{
				 s= s + i + "\n";
				dem++;		
			}
			i++;
		}
		//kq = System.out.println(s);
		return kq=kq+s;
	}
 

}


