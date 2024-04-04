package Demo.bktTai;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class HoaDonTienDien {
	private int thang;
	private int nam;
	private double soKWTieuThu;
	private double dinhMuc;
	private double donGia;

	public HoaDonTienDien(int thang, int nam, double soKWTieuThu, double dinhMuc, double donGia) {
		setThang(thang);
		setNam(nam);
		setSoKWTieuThu(soKWTieuThu);
		setDinhMuc(dinhMuc);
		setDonGia(donGia);
	}

	public HoaDonTienDien() {
		this.thang = 1;
		this.nam = 2022;
		this.soKWTieuThu = 0;
		this.dinhMuc = 0;
		this.donGia = 0;
	}

	public int getThang() {
		return thang;
	}

	public void setThang(int thang) {
		if (thang >= 1 && thang <= 12)
			this.thang = thang;
		else
			this.thang = 1;
	}

	public int getNam() {
		return nam;
	}

	public void setNam(int nam) {
		LocalDateTime localDate = LocalDateTime.now();
	    int year = localDate.getYear();
		if (nam <= year)
			this.nam = nam;
		else
			this.nam = year;
	}

	public double getSoKWTieuThu() {
		return soKWTieuThu;
	}

	public void setSoKWTieuThu(double soKWTieuThu) {
		if (soKWTieuThu >= 0)
			this.soKWTieuThu = soKWTieuThu;
		else
			this.soKWTieuThu = 0;
	}

	public double getDinhMuc() {
		return dinhMuc;
	}

	public void setDinhMuc(double dinhMuc) {
		if (dinhMuc >= 0)
			this.dinhMuc = dinhMuc;
		else
			this.dinhMuc = 0;
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
	/*
	 * ▪ Nếu số KW tiêu thụ <= định mức thì tiền = số KW tiêu thụ*đơn giá.
	 * 
	 * ▪ Ngược lại, tiền = định mức*đơn giá + số KW vượt định mức*đơn giá*2.5 số KW
	 * vượt định mức = (soKWTieuThu - dinhMuc)
	 */

	public double tinhTien() {
		if (this.soKWTieuThu <= this.dinhMuc)
			return this.soKWTieuThu * donGia;
		else
			return (dinhMuc * donGia) + (soKWTieuThu - dinhMuc) * donGia * 2.5;
	}

	@Override
	public String toString() {
		return "HoaDonTienDien [" + "thang=" + thang + ", nam=" + nam + ", soKWTieuThu=" + soKWTieuThu + ", dinhMuc="
				+ dinhMuc + ", donGia=" + donGia + ", tinhTien()=" + tinhTien() + "]";
	}

}
