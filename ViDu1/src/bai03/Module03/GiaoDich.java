package bai03.Module03;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class GiaoDich {
	private String maGiaoDich;
	private LocalDate ngayGiaoDich;
	private double donGia;
	private int soLuong;

	public GiaoDich() {
		this.maGiaoDich = "Khong duoc rong";
		this.ngayGiaoDich = LocalDate.now();
		this.donGia = 0;
		this.soLuong = 0;
	}

	public GiaoDich(String maGiaoDich, LocalDate ngayGiaoDich, double donGia, int soLuong) {
		setMaGiaoDich(maGiaoDich);
		setNgayGiaoDich(ngayGiaoDich);
		setDonGia(donGia);
		setSoLuong(soLuong);
	}

	public String getMaGiaoDich() {
		return maGiaoDich;
	}

	public void setMaGiaoDich(String maGiaoDich) {
		if (!maGiaoDich.trim().equals(""))
			this.maGiaoDich = maGiaoDich;
		else
			this.maGiaoDich = "Khong duoc rong";
	}

	public LocalDate getNgayGiaoDich() {
		return ngayGiaoDich;
	}

	public void setNgayGiaoDich(LocalDate ngayGiaoDich) {
		if (ngayGiaoDich.isAfter(LocalDate.now()))
			this.ngayGiaoDich = ngayGiaoDich;
		else
			this.ngayGiaoDich = LocalDate.now();
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		if (donGia > 0)
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
	/**
	 * tinh thành tiền
	 * @return thanh tien so luong * don gia;
	 */
	public double getThanhTien() {
		return soLuong * donGia;
		
	}

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,##0");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return "GiaoDich [maGiaoDich=" + maGiaoDich + ", ngayGiaoDich=" + dtf.format(ngayGiaoDich) + ", donGia=" + df.format(donGia)
				+ ", soLuong=" + soLuong + "]";
	}

	
}
