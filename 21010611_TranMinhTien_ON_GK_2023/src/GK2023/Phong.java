package GK2023;

import java.io.Serializable;

public class Phong implements Serializable{
	private int maPhong;
	private String tenPhong;
	private double dienTich;
	private String loaiPhong;
	private String ghiChu;
	
	
	public Phong(int maPhong) {
		this(maPhong, "ten phong", 0, "loai phong", "ghi chu");
	}
	
	public Phong(int maPhong, String tenPhong, double dienTich, String loaiPhong, String ghiChu) {
		super();
		this.maPhong = maPhong;
		this.tenPhong = tenPhong;
		this.dienTich = dienTich;
		this.loaiPhong = loaiPhong;
		this.ghiChu = ghiChu;
	}
	public int getMaPhong() {
		return maPhong;
	}
	public void setMaPhong(int maPhong) {
		this.maPhong = maPhong;
	}
	public String getTenPhong() {
		return tenPhong;
	}
	public void setTenPhong(String tenPhong) {
		this.tenPhong = tenPhong;
	}
	public double getDienTich() {
		return dienTich;
	}
	public void setDienTich(double dienTich) {
		this.dienTich = dienTich;
	}
	public String getLoaiPhong() {
		return loaiPhong;
	}
	public void setLoaiPhong(String loaiPhong) {
		this.loaiPhong = loaiPhong;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + maPhong;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Phong other = (Phong) obj;
		if (maPhong != other.maPhong)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Phong [maPhong=" + maPhong + ", tenPhong=" + tenPhong + ", dienTich=" + dienTich + ", loaiPhong="
				+ loaiPhong + ", ghiChu=" + ghiChu + "]";
	}
	
	
}
