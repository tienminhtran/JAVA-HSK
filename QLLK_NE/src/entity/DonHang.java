package entity;

import java.sql.Date;

public class DonHang {
	private String mahd;
	private String manv;
	private String tensp;
	private String makh;
	private String tenkh;
	private Date ngaylaphd;
	private double tongtien;
	public String getMahd() {
		return mahd;
	}
	public void setMahd(String mahd) {
		this.mahd = mahd;
	}
	public String getManv() {
		return manv;
	}
	public void setManv(String manv) {
		this.manv = manv;
	}
	public String getTensp() {
		return tensp;
	}
	public void setTensp(String tensp) {
		this.tensp = tensp;
	}
	public String getMakh() {
		return makh;
	}
	public void setMakh(String makh) {
		this.makh = makh;
	}
	public String getTenkh() {
		return tenkh;
	}
	public void setTenkh(String tenkh) {
		this.tenkh = tenkh;
	}
	public Date getNgaylaphd() {
		return ngaylaphd;
	}
	public void setNgaylaphd(Date ngaylaphd) {
		this.ngaylaphd = ngaylaphd;
	}
	public double getTongtien() {
		return tongtien;
	}
	public void setTongtien(double tongtien) {
		this.tongtien = tongtien;
	}
	public DonHang(String mahd, String manv, String tensp, String makh, String tenkh, Date ngaylaphd, double tongtien) {
		super();
		this.mahd = mahd;
		this.manv = manv;
		this.tensp = tensp;
		this.makh = makh;
		this.tenkh = tenkh;
		this.ngaylaphd = ngaylaphd;
		this.tongtien = tongtien;
	}
	
	
}
