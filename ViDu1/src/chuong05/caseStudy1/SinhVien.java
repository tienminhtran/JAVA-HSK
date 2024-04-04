package chuong05.caseStudy1;

import java.util.Objects;

public class SinhVien {
	private int ma;
	private String hoTen;
	private int namSinh;
	public int getMa() {
		return ma;
	}
	public void setMa(int ma) {
		this.ma = ma;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public int getNamSinh() {
		return namSinh;
	}
	public void setNamSinh(int namSinh) {
		this.namSinh = namSinh;
	}
	public SinhVien(int ma, String hoTen, int namSinh) {
		super();
		this.ma = ma;
		this.hoTen = hoTen;
		this.namSinh = namSinh;
	}
	@Override
	public String toString() {
		return String.format("%5d %10s %5d", ma,hoTen,namSinh);
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
		SinhVien other = (SinhVien) obj;
		return ma == other.ma;
	}
	
}
