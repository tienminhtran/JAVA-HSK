package entity;

import java.util.ArrayList;
import java.util.Objects;

public class PhongBan {

	private String maPhong;
	private String tenPhong;
	private ArrayList<NhanVien> dsnv;
	public PhongBan(String maPhong, String tenPhong) {
		super();
		this.maPhong = maPhong;
		this.tenPhong = tenPhong;
		this.dsnv = new ArrayList<NhanVien>();
	}
	
	public void themNhanVien(String maSo, String ho, String ten, boolean phai, int tuoi, long tienLuong ) {
		NhanVien nv = new NhanVien(maSo, ho, ten, phai, tuoi, tienLuong, this); 
		dsnv.add(nv);
		
	}

	public String getMaPhong() {
		return maPhong;
	}

	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}

	public String getTenPhong() {
		return tenPhong;
	}

	public void setTenPhong(String tenPhong) {
		this.tenPhong = tenPhong;
	}

	public ArrayList<NhanVien> getDsnv() {
		return dsnv;
	}

	public void setDsnv(ArrayList<NhanVien> dsnv) {
		this.dsnv = dsnv;
	}

	@Override
	public String toString() {
		return tenPhong;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dsnv, maPhong, tenPhong);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhongBan other = (PhongBan) obj;
		return Objects.equals(dsnv, other.dsnv) && Objects.equals(maPhong, other.maPhong)
				&& Objects.equals(tenPhong, other.tenPhong);
	}
	
	
}
