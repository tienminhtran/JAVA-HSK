package bai05.Module02;

import javax.annotation.processing.Messager;

public class HinhTamGiac {
	private double canhMa;
	private double canhMb;
	private double canhMc;

	public HinhTamGiac(double canhMa, double canhMb, double canhMc) throws Exception {
			setCanhMa(canhMa);
			setCanhMb(canhMb);
			setCanhMc(canhMc);
	
	}

	public HinhTamGiac(){
		canhMa = 0;
		canhMb = 0;
		canhMc = 0;
	}
	public boolean laTamGiac(double a, double b, double c) {
		if (a+b >=c ||b+c >=a || a+c>=b)
			return true;
		return false;
	}
	
	public double getCanhMa() {
		return canhMa;
	}

	public void setCanhMa(double canhMa){
		if(canhMa > 0 && laTamGiac(canhMa, canhMa, canhMa))
			this.canhMa = canhMa;
		else
			;
	}

	public double getCanhMb() {
		return canhMb;
	}

	public void setCanhMb(double canhMb) {
		if(canhMb > 0 && laTamGiac(canhMa, canhMa, canhMa))
			this.canhMb = canhMb;
		else
			;
	}

	public double getCanhMc() {
		return canhMc;
	}

	public void setCanhMc(double canhMc){
		if(canhMc > 0 && laTamGiac(canhMa, canhMa, canhMa))
			this.canhMc = canhMc;
		else 
			;
	}

	public double tinhChuVi() {
		if(canhMa > 0 && canhMb > 0 && canhMc > 0)
			return this.canhMa + this.canhMb + this.canhMc;
		else
			return 0;
	}

	public double tinhDienTich() {
		double p = tinhChuVi() / 2;
		return (double) Math.sqrt(p * (p - this.canhMa) * (p - this.canhMb) * (p - this.canhMc));
	}



	public String kiemTraTamGiac()  {
		if (laTamGiac(canhMa, canhMa, canhMa) == true) 
		{
			if ((this.canhMa == this.canhMb) && (this.canhMb == this.canhMc)) {
				return "Tam giac deu";
			} else if ((this.canhMa == this.canhMb) || (this.canhMb == this.canhMc) || (this.canhMa == this.canhMc)) {
				return "Tam giac can";

			} else if ((Math.pow(this.canhMa, 2) == Math.pow(this.canhMb, 2) + Math.pow(this.canhMc, 2))
					|| (Math.pow(this.canhMb, 2) == Math.pow(this.canhMa, 2) + Math.pow(this.canhMc, 2))
					|| (Math.pow(this.canhMc, 2) == Math.pow(this.canhMa, 2) + Math.pow(this.canhMb, 2))) {
				return "Tam giac vuong";

			} else if (((Math.pow(this.canhMa, 2) == Math.pow(this.canhMb, 2) + Math.pow(this.canhMc, 2))
					&& (this.canhMa == this.canhMb))
					|| ((Math.pow(this.canhMb, 2) == Math.pow(this.canhMa, 2) + Math.pow(this.canhMb, 2))
							&& (this.canhMa == this.canhMc))
					|| ((Math.pow(this.canhMc, 2) == Math.pow(this.canhMb, 2) + Math.pow(this.canhMa, 2))
							&& (this.canhMb == this.canhMc))) {
				return "Tam giac vuong can";

			} else 
				return "Tam giac thuong";

		}
		else
			return "Khong tam giac";
		

	}
	
	public String layTieuDe() {
		return String.format("%-10s%-10s%-10s%-10s%-10s%-20s", "Canh ma", "Canh mb", "Canh mc", "Chu vi", "Dien tich", "Kieu tam giac");
	}
	@Override
	public String toString() {
		return String.format("%-10.2f%-10.2f%-10.2f%-10.2f%-10.2f%-20s", canhMa, canhMb,canhMc,tinhChuVi(),tinhDienTich(),kiemTraTamGiac());
	}			


}

