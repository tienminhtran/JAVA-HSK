package bai06.Module03;

import java.text.DecimalFormat;

public abstract class HangHoa {
	private String maHang;
	private String tenHang;
	private double donGia;
	private int soLuongTon;

	public HangHoa(String maHang, String tenHang, double donGia, int soLuongTon) {
		setMaHang(maHang);
		setTenHang(tenHang);
		setDonGia(donGia);
		setSoLuongTon(soLuongTon);
	}

	public HangHoa() {
		this.maHang = "khong duoc rong";
		this.tenHang = "xxx";
		this.donGia = 0;
		this.soLuongTon = 0;
	}

	public String getMaHang() {
		return maHang;
	}

	/**
	 * Khong duoc sua ma private
	 * @param maHang
	 */
	private void setMaHang(String maHang) {
		if (!maHang.trim().equals(""))
			this.maHang = maHang;
		else
			this.maHang = "khong duoc rong";
	}

	public String getTenHang() {
		return tenHang;
	}

	public void setTenHang(String tenHang) {
		if (!tenHang.trim().equals(""))
			this.tenHang = tenHang;
		else
			this.tenHang = "xxx";
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		if (donGia >= 0)
			this.donGia = donGia;
		else
			this.donGia = 0;
	}

	public int getSoLuongTon() {
		return soLuongTon;
	}

	public void setSoLuongTon(int soLuongTon) {
		if (soLuongTon >= 0)
			this.soLuongTon = soLuongTon;
		else
			this.soLuongTon = 0;
	}
	
	public abstract boolean mucDoBuonBan();
	
	public abstract double tinhTienVAT();

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,##0VND");
		return String.format("|%-10s|%-15s|%15s|%12s", maHang, tenHang, df.format(donGia),soLuongTon);
//		return "HangHoa [maHang=" + + ", tenHang=" + + ", donGia=" +  + ", soLuongTon="
//				+  + "]";
	}


}
