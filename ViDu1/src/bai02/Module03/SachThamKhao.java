package bai02.Module03;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SachThamKhao extends Sach{
	
	private int thue;

	public int getThue() {
		return thue;
	}

	public void setThue(int thue) {
		this.thue = thue;
	}

	public SachThamKhao(String maSach, LocalDate ngayNhap, double donGia, int soLuong, String nhaXuatBan, int thue) {
		super(maSach, ngayNhap, donGia, soLuong, nhaXuatBan);
		this.thue = thue;
	}

	@Override
	public double getThanhTien() {
		return super.getThanhTien()+ thue;
	}
	public String layTieuDe()
	{
		return String.format("%-10s|","Thue");
	}
	@Override
	public String toString() {
		String s = "";
		s = s + super.layTieuDe();
//		s = s + layTieuDe();
		s = s + String.format("%s%-10d|", super.toString(), thue);
		return s;
	}
	
}
