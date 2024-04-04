
package GK_2023;

import java.io.Serializable;

public class Xe implements Serializable {
	private String ma, tenxe, hang, nhapkhau;
	private int namsx, gia;
	public Xe(String ma, String tenxe, String hang, String nhapkhau, int namsx, int gia) {
		super();
		this.ma = ma;
		this.tenxe = tenxe;
		this.hang = hang;
		this.nhapkhau = nhapkhau;
		this.namsx = namsx;
		this.gia = gia;
	}
	public String getMa() {
		return ma;
	}
	public void setMa(String ma) {
		this.ma = ma;
	}
	public String getTenxe() {
		return tenxe;
	}
	public void setTenxe(String tenxe) {
		this.tenxe = tenxe;
	}
	public String getHang() {
		return hang;
	}
	public void setHang(String hang) {
		this.hang = hang;
	}
	public String getNhapkhau() {
		return nhapkhau;
	}
	public void setNhapkhau(String nhapkhau) {
		this.nhapkhau = nhapkhau;
	}
	public int getNamsx() {
		return namsx;
	}
	public void setNamsx(int namsx) {
		this.namsx = namsx;
	}
	public int getGia() {
		return gia;
	}
	public void setGia(int gia) {
		this.gia = gia;
	}
	@Override
	public String toString() {
		return "Xe [ma=" + ma + ", tenxe=" + tenxe + ", hang=" + hang + ", nhapkhau=" + nhapkhau + ", namsx=" + namsx
				+ ", gia=" + gia + "]";
	}
	
	
}
