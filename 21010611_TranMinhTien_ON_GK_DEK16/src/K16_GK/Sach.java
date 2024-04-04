package K16_GK;

import java.io.Serializable;
import java.util.Objects;

public class Sach implements Serializable{
	private String maSach;
	private String tenSach;
	private int soTrang;
	private String theLoai;
	private String nhaXuatBan;
	public String getMaSach() {
		return maSach;
	}
	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}
	public String getTenSach() {
		return tenSach;
	}
	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}
	public int getSoTrang() {
		return soTrang;
	}
	public void setSoTrang(int soTrang) {
		this.soTrang = soTrang;
	}
	public String getTheLoai() {
		return theLoai;
	}
	public void setTheLoai(String theLoai) {
		this.theLoai = theLoai;
	}
	public String getNhaXuatBan() {
		return nhaXuatBan;
	}
	public void setNhaXuatBan(String nhaXuatBan) {
		this.nhaXuatBan = nhaXuatBan;
	}
	public Sach(String maSach, String tenSach, int soTrang, String theLoai, String nhaXuatBan) {
		super();
		this.maSach = maSach;
		this.tenSach = tenSach;
		this.soTrang = soTrang;
		this.theLoai = theLoai;
		this.nhaXuatBan = nhaXuatBan;
	}
	@Override
	public String toString() {
		return "Sach [maSach=" + maSach + ", tenSach=" + tenSach + ", soTrang=" + soTrang + ", theLoai=" + theLoai
				+ ", nhaXuatBan=" + nhaXuatBan + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(maSach);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sach other = (Sach) obj;
		return Objects.equals(maSach, other.maSach);
	}

}
