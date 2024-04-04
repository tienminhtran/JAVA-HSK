package Bai1;

public class Model {

	public double a;
	public double b;
	public double c;
	public double kq1;
	public double kq2;
	public String ketqua;

	public double getKq1() {
		return kq1;
	}

	public void setKq1(double kq1) {
		this.kq1 = kq1;
	}

	public double getKq2() {
		return kq2;
	}

	public void setKq2(double kq2) {
		this.kq2 = kq2;
	}

	public Model() {
		// TODO Auto-generated constructor stub
	}

	public String getKetqua() {
		return ketqua;
	}

	public void setKetqua(String ketqua) {
		this.ketqua = ketqua;
	}

	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}

	public double getC() {
		return c;
	}

	public void setC(double c) {
		this.c = c;
	}

	public void tinh() {
		double delta = b * b - 4 * a * c;

		if(a==0)
		{
			if(b==0)
			{
				if(c==0)
				{
					this.ketqua = "Phương trình vô số nghiệm";
				}else {
					this.ketqua = "Phương trình vô ghiệm";
				}
			}else
			{
				this.ketqua = "Phương trình có nghiệm duy nhất x = " + Math.round((-c/b)*100.0)/100.0;

			}
		}
		else if (delta > 0)
		{
			this.kq1 = (-b + Math.sqrt(delta)) / (2 * a);
			this.kq2 = (-b - Math.sqrt(delta)) / (2 * a);
			this.ketqua = "Phương trình có hai nghiệm x1 = "+ Math.round(kq1*100.0)/100.0 + "  x2 = " + Math.round(kq2*100.0)/100.0;
		}else if(delta == 0)
		{
			this.ketqua = "Phương trình có nghiệm kep: x1=x2="+ Math.round(delta*100.0)/100.0 ;

		}
		else
		{
			this.ketqua = "Phương trình vô nghiệm";
		}

	}

}
