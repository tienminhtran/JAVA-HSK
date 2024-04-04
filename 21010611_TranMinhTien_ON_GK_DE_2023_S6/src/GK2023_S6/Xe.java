package GK2023_S6;

import java.io.Serializable;
import java.util.Objects;

public class Xe implements Serializable{

	private String ma;
	private String ten;
	private String hang;
	private int nam;
	private double gia;
	private String nk;
	private String kho;
	private String tinhTrang;
	private String loaiThue;

	public String getLoaiThue() {
		return loaiThue;
	}
	public void setLoaiThue(String loaiThue) {
		this.loaiThue = loaiThue;
	}
	public String getTinhTrang() {
		return tinhTrang;
	}
	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	public String getKho() {
		return kho;
	}
	public void setKho(String kho) {
		this.kho = kho;
	}
	@Override
	public int hashCode() {
		return Objects.hash(ma);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Xe other = (Xe) obj;
		return Objects.equals(ma, other.ma);
	}
	public String getMa() {
		return ma;
	}
	public void setMa(String ma) {
		this.ma = ma;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getHang() {
		return hang;
	}
	public void setHang(String hang) {
		this.hang = hang;
	}
	public int getNam() {
		return nam;
	}
	public void setNam(int nam) {
		this.nam = nam;
	}
	public double getGia() {
		return gia;
	}
	public void setGia(double gia) {
		this.gia = gia;
	}
	public String getNk() {
		return nk;
	}
	public void setNk(String nk) {
		this.nk = nk;
	}
	public Xe(String ma, String ten, String hang, int nam, double gia, String nk, String kho, String tinhTrang,
			String loaiThue) {
		super();
		this.ma = ma;
		this.ten = ten;
		this.hang = hang;
		this.nam = nam;
		this.gia = gia;
		this.nk = nk;
		this.kho = kho;
		this.tinhTrang = tinhTrang;
		this.loaiThue = loaiThue;
	}
	@Override
	public String toString() {
		return "Xe [ma=" + ma + ", ten=" + ten + ", hang=" + hang + ", nam=" + nam + ", gia=" + gia + ", nk=" + nk
				+ ", kho=" + kho + ", tinhTrang=" + tinhTrang + ", loaiThue=" + loaiThue + "]";
	}

}
	
