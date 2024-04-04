package bai09.Module02;

public class HinhTron {
	private double banKinh;
	private ToaDo tam;
	public HinhTron(double banKinh, ToaDo tam) {
		this.banKinh = banKinh;
		this.tam = tam;
	}
	public HinhTron() {
		banKinh = 0;
		tam = new ToaDo();
	}
	public double getBanKinh() {
		return banKinh;
	}
	public void setBanKinh(double banKinh) {
		this.banKinh = banKinh;
	}
	public ToaDo getTam() {
		return tam;
	}
	public void setTam(ToaDo tam) {
		this.tam = tam;
	}
	//c v 2pi r
	// s pi rr
	public double tinhChuVi() {
		return 2*Math.PI*this.banKinh;
	}
	public double tinhDienTich() {
		return Math.PI*this.banKinh*this.banKinh;
	}
	@Override
	public String toString() {
		return String.format("Dien tich va chu vi hinh tron tam %s co ban kinh %.2f, dien tich %.2f",tam, tinhChuVi(),tinhDienTich());
	}
	
	
	
}
