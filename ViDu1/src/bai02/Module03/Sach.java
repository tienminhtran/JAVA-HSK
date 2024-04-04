package bai02.Module03;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Sach {
	private String maSach;
	private LocalDate ngayNhap;
	private double donGia;
	private int soLuong;
	private String nhaXuatBan;
	public Sach(String maSach, LocalDate ngayNhap, double donGia, int soLuong, String nhaXuatBan) {
		setMaSach(maSach);
		setNgayNhap(ngayNhap);
		setDonGia(donGia);
		setSoLuong(soLuong);
		setNhaXuatBan(nhaXuatBan);
	}

	public Sach() {
		this.maSach = "xxxx";
		this.ngayNhap = LocalDate.now();
		this.donGia = 0;
		this.soLuong = 0;
		this.nhaXuatBan = "Nguyen Van A";
	}
	
	public String getMaSach() {
		return maSach;
	}

	public void setMaSach(String maSach) {
		if (!maSach.trim().equals(""))
			this.maSach = maSach;
		else
			this.maSach = "Ma sach khong hop le";
	}

	public LocalDate getNgayNhap() {
		return ngayNhap;
	}

	public void setNgayNhap(LocalDate ngayNhap) {
		if (ngayNhap.isBefore(LocalDate.now()))
			this.ngayNhap = ngayNhap;
		else
			this.ngayNhap = LocalDate.now();
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

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		if (soLuong >= 0)
			this.soLuong = soLuong;
		else
			this.soLuong = 0;
	}

	public String getNhaXuatBan() {
		return nhaXuatBan;
	}

	public void setNhaXuatBan(String nhaXuatBan) {
		if (!nhaXuatBan.trim().equals(""))
			this.nhaXuatBan = nhaXuatBan;
		else
			this.nhaXuatBan = "Nha xuat ban khong hop le!";
	}



	public double getThanhTien() {
		return donGia*soLuong;
	}
	public String layTieuDe()
	{
		return String.format("|%-10s|%-10s|%-10s|%-10s|%-10s|","Ma sach", "Ngay N", "Don gia", "SL", "NXB");
	}
	@Override
	public String toString() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String s = "";
		s = s + layTieuDe();
		s = s +"\n";
		s =  s + String.format("|%-10s|%-10s|%10.0f|%10d|%-10s|", maSach, dtf.format(ngayNhap), donGia, soLuong, nhaXuatBan);
	return s;
	}
	
}
