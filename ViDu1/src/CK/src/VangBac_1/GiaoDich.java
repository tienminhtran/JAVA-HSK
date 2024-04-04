package VangBac_1;

import java.time.LocalDate;
import java.util.Objects;

public abstract class GiaoDich {
	// Giao dịch vàng: Mã giao dịch, ngày giao dịch
	private String maGiaoDich;
	private LocalDate ngayGiaoDich;
	private double donGia;

	public GiaoDich(String maGiaoDich, LocalDate ngayGiaoDich, double donGia) {
		/*
		this.maGiaoDich = maGiaoDich;
		this.ngayGiaoDich = ngayGiaoDich;
		this.donGia = donGia;*/
		// LÀM XONG TO STRING VÀ RÀNG BUỘC QUAY LÊN XOÁ this.... => THAY BẰNG DƯỚI
		setMaGiaoDich(maGiaoDich);
		setNgayGiaoDich(ngayGiaoDich);
		setDonGia(donGia);
	}


	public String getMaGiaoDich() {
		return maGiaoDich;
	}

	public void setMaGiaoDich(String maGiaoDich) {
		if (!maGiaoDich.trim().equals("")) // chuỗi !--------..trim().equals("")
			this.maGiaoDich = maGiaoDich;
		else
			this.maGiaoDich = "xxx";
	}

	public LocalDate getNgayGiaoDich() {
		return ngayGiaoDich;
	}

	public void setNgayGiaoDich(LocalDate ngayGiaoDich) {
		if (ngayGiaoDich.isBefore(LocalDate.now()))
			this.ngayGiaoDich = ngayGiaoDich;
		else
			this.ngayGiaoDich = LocalDate.now();
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		if (donGia > 0) // double hoặc int >0
			this.donGia = donGia;
		else
			this.donGia = 0;
	}

	public abstract double tinhThanhTien();
	@Override
	public String toString() {
		return "GiaoDich [maGiaoDich=" + maGiaoDich + ", ngayGiaoDich=" + ngayGiaoDich + ", donGia=" + donGia + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(maGiaoDich);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GiaoDich other = (GiaoDich) obj;
		return Objects.equals(maGiaoDich, other.maGiaoDich);
	}



}
