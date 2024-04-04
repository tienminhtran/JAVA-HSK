package bai02.Module03;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SachGiaoKhoa extends Sach{
	private boolean tinhTrang;
	public SachGiaoKhoa(String maSach, LocalDate ngayNhap, double donGia, int soLuong, String nhaXuatBan,
			boolean tinhTrang) {
		super(maSach, ngayNhap, donGia, soLuong, nhaXuatBan);
		this.tinhTrang = tinhTrang;
	}
	public boolean isTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(boolean tinhTrang) {
		this.tinhTrang = tinhTrang;
			
	}


	
	@Override
	public double getThanhTien() {
		if(tinhTrang) {
			return super.getThanhTien();
 		} else {
 			return super.getThanhTien()*0.5;
 		}
	}
	public String layTieuDe()
	{
		return String.format("%-10s|","TT");
	}
	@Override
	public String toString() {
		String s = "";
		s = s + super.layTieuDe();
//		s = s + layTieuDe() + "\n";
		s = s + String.format("%s%-10s|", super.toString(), tinhTrang?"Moi":"Cu");
		return s;
	}
	
}
