package CK.TUGIAID1;

import java.time.LocalDate;

public class Intern extends Employee{
	private String chuyenNganh;
	private int hocKy;
	public Intern(String ma, FullName hoTen, LocalDate ngaySinh, String soDienThoai, String chuyenNganh, int hocKy) {
		super(ma, hoTen, ngaySinh, soDienThoai);
		this.chuyenNganh = chuyenNganh;
		this.hocKy = hocKy;
	}
	public Intern() {
		this.chuyenNganh = "chua xac dinh";
		this.hocKy = 6;
	}
	public String getChuyenNganh() {
		return chuyenNganh;
	}
	public void setChuyenNganh(String chuyenNganh) {
		if(!chuyenNganh.trim().equals(""))
		this.chuyenNganh = chuyenNganh;
		else
			this.chuyenNganh = "chua xac dinh";
	}
	public int getHocKy() {
		return hocKy;
	}
	public void setHocKy(int hocKy) {
		if(hocKy >=6 && hocKy <=10)
		this.hocKy = hocKy;
		else
			this.hocKy = 6;
	}
	@Override
	public String toString() {
		return String.format("%s %-15s %-15s %-15s %-15s %-15s", super.toString(), "-","-","-",chuyenNganh, hocKy);
	
	}
}
