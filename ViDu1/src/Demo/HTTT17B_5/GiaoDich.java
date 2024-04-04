package Demo.HTTT17B_5;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class GiaoDich {
	private String maGiaoDich;
	private String loaiGiaoDich;
	private LocalDate ngayGiaoDich;
	private double dienTich;
	private double donGia;

	public GiaoDich(String maGiaoDich, String loaiGiaoDich, LocalDate ngayGiaoDich, double dienTich, double donGia) {
		setMaGiaoDich(maGiaoDich);
		setLoaiGiaoDich(loaiGiaoDich);
		setNgayGiaoDich(ngayGiaoDich);
		setDienTich(dienTich);
		setDonGia(donGia);
//		this.maGiaoDich = maGiaoDich;
//		this.loaiGiaoDich = loaiGiaoDich;
//		this.ngayGiaoDich = ngayGiaoDich;
//		this.dienTich = dienTich;
//		this.donGia = donGia;
	}

	public String getMaGiaoDich() {
		return maGiaoDich;
	}

	public void setMaGiaoDich(String maGiaoDich) {
		this.maGiaoDich = maGiaoDich;
	}

	public String getLoaiGiaoDich() {
		return loaiGiaoDich;
	}

	public void setLoaiGiaoDich(String loaiGiaoDich) {
		if (loaiGiaoDich.compareToIgnoreCase("Nha") == 0 || loaiGiaoDich.compareToIgnoreCase("Dat") == 0)
			this.loaiGiaoDich = loaiGiaoDich;
		else
			this.loaiGiaoDich = "Chua cap nhat";
	}

	public LocalDate getNgayGiaoDich() {
		return ngayGiaoDich;
	}

	public void setNgayGiaoDich(LocalDate ngayGiaoDich) {
		if (ngayGiaoDich != null)
			this.ngayGiaoDich = ngayGiaoDich;
		else
			this.ngayGiaoDich = LocalDate.now();
	}

	public double getDienTich() {
		return dienTich;
	}

	public void setDienTich(double dienTich) {
		if (dienTich > 25)
			this.dienTich = dienTich;
		else
			this.dienTich = 0;
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

	public double thanhTien() {
		return dienTich * donGia * 0.1;
	}

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,##0.000VND");
		return "GiaoDich [maGiaoDich=" + maGiaoDich + ", loaiGiaoDich=" + loaiGiaoDich + ", ngayGiaoDich="
				+ ngayGiaoDich + ", dienTich=" + dienTich + ", donGia=" + donGia + ", thanhTien()=" + df.format(thanhTien()) + "]";
	}

}
