package bai03.Module02;

public class Cylinder {
	private double banKinh;
	private double chieuCao;

	public Cylinder(double banKinh, double chieuCao) throws Exception {
		if (banKinh > 0 && chieuCao > 0) {
			this.banKinh = banKinh;
			this.chieuCao = chieuCao;
		}
		else
			throw new Exception("Loi: ban kinh, chieu cao phai la so duong");

	}

	public Cylinder() {
		banKinh = 0;
		chieuCao = 0;
	}

	public double getBanKinh() {
		return banKinh;
	}

	public void setBanKinh(double banKinh) throws Exception {
		if (banKinh > 0)
			this.banKinh = banKinh;
		else
			throw new Exception("Loi: ban kinh phai la so duong");
	}

	public double getChieuCao() {
		return chieuCao;
	}

	public void setChieuCao(double chieuCao) throws Exception {
		if (chieuCao > 0)
			this.chieuCao = chieuCao;
		else
			throw new Exception("Loi: chieu cao phai la so duong");
	}

	public double tinhDienTichXungQuanh() {
		return 2 * Math.PI * this.banKinh * this.chieuCao;
	}

	public double tinhDienTichToanPhan() {
		return 2 * Math.PI * this.chieuCao + 2 * Math.PI * Math.pow(this.banKinh, 2);
	}

	public double tinhTheTich() {
		return Math.PI * this.chieuCao * Math.pow(this.banKinh, 2);
	}

}

/*
 * CÔNG THỨC: SXQ = 2 PI R L V = H PI R2 STP = 2 PI H + 2 PI R2
 */
