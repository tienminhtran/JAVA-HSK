package Mode2Bai5;

import javax.annotation.processing.Messager;

public class HinhTamGiac {
	private float canhMa;
	private float canhMb;
	private float canhMc;

	public HinhTamGiac(float canhMa, float canhMb, float canhMc) throws Exception {
			setCanhMa(canhMa);
			setCanhMb(canhMb);
			setCanhMc(canhMc);
	
	}

	public HinhTamGiac(){
		canhMa = 0;
		canhMb = 0;
		canhMc = 0;
	}

	public float getCanhMa() {
		return canhMa;
	}

	public void setCanhMa(float canhMa){
		if(canhMa > 0)
			this.canhMa = canhMa;
		else
			this.canhMa = 0;
	}

	public float getCanhMb() {
		return canhMb;
	}

	public void setCanhMb(float canhMb) {
		if(canhMb > 0)
			this.canhMb = canhMb;
		else
			this.canhMb = 0;
	}

	public float getCanhMc() {
		return canhMc;
	}

	public void setCanhMc(float canhMc){
		if(canhMc > 0)
			this.canhMc = canhMc;
		else 
			this.canhMc = 0;
	}

	public float tinhChuVi() {
		if(canhMa > 0 && canhMb > 0 && canhMc > 0)
			return this.canhMa + this.canhMb + this.canhMc;
		else
			return 0;
	}

	public float tinhDienTich() {
		float p = tinhChuVi() / 2;
		return (float) Math.sqrt(p * (p - this.canhMa) * (p - this.canhMb) * (p - this.canhMc));
	}

	public boolean kiemTraTamGiacThuong() {
		if ((this.canhMa + this.canhMb > this.canhMc) && (this.canhMb + this.canhMc > this.canhMa)
				&& (this.canhMa + this.canhMc > this.canhMb))
			return true;
		return false;
	}

	public int kiemTraTamGiac() throws Exception {
		if (kiemTraTamGiacThuong() == true) {
			if ((this.canhMa == this.canhMb) && (this.canhMb == this.canhMc)) {
//				System.out.println("Tam giac deu ");
				throw new Exception(" Tam giac deu");
			} else if ((this.canhMa == this.canhMb) || (this.canhMb == this.canhMc) || (this.canhMa == this.canhMc)) {
//				System.out.println("Tam giac can ");
				throw new Exception(" Tam giac can");

			} else if ((Math.pow(this.canhMa, 2) == Math.pow(this.canhMb, 2) + Math.pow(this.canhMc, 2))
					|| (Math.pow(this.canhMb, 2) == Math.pow(this.canhMa, 2) + Math.pow(this.canhMc, 2))
					|| (Math.pow(this.canhMc, 2) == Math.pow(this.canhMa, 2) + Math.pow(this.canhMb, 2))) {
//				System.out.println("Tam giac vuong ");
				throw new Exception(" Tam giac vuong");

			} else if (((Math.pow(this.canhMa, 2) == Math.pow(this.canhMb, 2) + Math.pow(this.canhMc, 2))
					&& (this.canhMa == this.canhMb))
					|| ((Math.pow(this.canhMb, 2) == Math.pow(this.canhMa, 2) + Math.pow(this.canhMb, 2))
							&& (this.canhMa == this.canhMc))
					|| ((Math.pow(this.canhMc, 2) == Math.pow(this.canhMb, 2) + Math.pow(this.canhMa, 2))
							&& (this.canhMb == this.canhMc))) {
//				System.out.println("Tam giac vuong can ");
				throw new Exception(" Tam giac vuong can");

			} else {
//				System.out.println("Tam giac thuong ");
				throw new Exception(" Tam giac thuong");

			}

		}
		return 0;
	}

	@Override
	public String toString() {
		return "HinhTamGiac [canhMa=" + canhMa + ", canhMb=" + canhMb + ", canhMc=" + canhMc + ", tinhChuVi()="
				+ tinhChuVi() + ", tinhDienTich()=" + tinhDienTich();
				
//		try {
//			System.out.println(kiemTraTamGiac())
//		} catch (Exception e) {			
//			System.out.println(e.getMessage());
//		}
	}

//	public void kiemTraTamGiac() {
//		if(kiemTraTamGiacThuong()==true) {
//			if((this.canhMa == this.canhMb) && (this.canhMb == this.canhMc)) {
//				System.out.println("Tam giac deu ");
//			}else if((this.canhMa == this.canhMb) || (this.canhMb == this.canhMc) ||(this.canhMa == this.canhMc)) {
//				System.out.println("Tam giac can ");
//			}else if((Math.pow(this.canhMa,2)==Math.pow(this.canhMb,2) + Math.pow(this.canhMc,2)) 
//					|| (Math.pow(this.canhMb,2)==Math.pow(this.canhMa,2) + Math.pow(this.canhMc,2))
//					|| (Math.pow(this.canhMc,2)==Math.pow(this.canhMa,2) + Math.pow(this.canhMb,2))) {
//				System.out.println("Tam giac vuong ");
//			}else if(((Math.pow(this.canhMa,2)==Math.pow(this.canhMb,2) + Math.pow(this.canhMc,2)) && (this.canhMa == this.canhMb)) 
//					||((Math.pow(this.canhMb,2)==Math.pow(this.canhMa,2) + Math.pow(this.canhMb,2)) && (this.canhMa == this.canhMc)) 
//					||((Math.pow(this.canhMc,2)==Math.pow(this.canhMb,2) + Math.pow(this.canhMa,2)) && (this.canhMb == this.canhMc))) {
//				System.out.println("Tam giac vuong can ");
//
//			}else {
//				System.out.println("Tam giac thuong ");
//			}
//				
//		}
//	}

}
