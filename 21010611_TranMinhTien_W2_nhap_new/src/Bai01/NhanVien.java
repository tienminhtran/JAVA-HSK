package Bai01;

import java.util.Objects;

public class NhanVien {

	private int maNV;
	private String ho ="";
	private String ten="";
	private boolean phai;
	private int tuoi;
	private double tienLuong;
	public NhanVien() {
		// TODO Auto-generated constructor stub
	}
	public NhanVien(int maNv) {
//		this.maNV=maNv;
//		this.ho = "";
//		this.ten = "";
//		this.phai = true;
//		this.tuoi = 0;
//		this.tienLuong = 0;
				this(maNv,"","",true,0,0);

	}
	public NhanVien(int maNV, String ho, String ten, boolean phai, int tuoi, double tienLuong) {
		this.maNV = maNV;
		this.ho = ho;
		this.ten = ten;
		this.phai = phai;
		this.tuoi = tuoi;
		this.tienLuong = tienLuong;
	}
	public int getMaNV() {
		return maNV;
	}
	public void setMaNV(int maNV) {
		this.maNV = maNV;
	}
	public String getHo() {
		return ho;
	}
	public void setHo(String ho) {
		this.ho = ho;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public boolean getPhai() {
		return phai;
	}
	public void setPhai(boolean phai) {
		this.phai = phai;
	}
	public int getTuoi() {
		return tuoi;
	}
	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}
	public double getTienLuong() {
		return tienLuong;
	}
	public void setTienLuong(double tienLuong) {
		this.tienLuong = tienLuong;
	}
	@Override
	public String toString() {
//		return "NhanVienModel [maNV=" + maNV + ", ho=" + ho + ", ten=" + ten + ", phai=" + phai + ", tuoi=" + tuoi
//				+ ", tienLuong=" + tienLuong + "]";
		return maNV+";"
		+ho+";"
		+ten+";"
		+phai+";"
		+tuoi+";"
		+tienLuong;
	}
	@Override
	public int hashCode() {
		return Objects.hash(ho, maNV, phai, ten, tienLuong, tuoi);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhanVien other = (NhanVien) obj;
		return Objects.equals(ho, other.ho) && maNV == other.maNV && Objects.equals(phai, other.phai)
				&& Objects.equals(ten, other.ten)
				&& Double.doubleToLongBits(tienLuong) == Double.doubleToLongBits(other.tienLuong) && tuoi == other.tuoi;
	}
	
	
}
