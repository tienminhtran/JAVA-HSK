package bai03.Module03;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class GiaoDichVang extends GiaoDich {
	private String loaiVang;

	public GiaoDichVang(String maGiaoDich, LocalDate ngayGiaoDich, double donGia, int soLuong, String loaiVang) {
		super(maGiaoDich, ngayGiaoDich, donGia, soLuong);
		setLoaiVang(loaiVang);
	}

	public String getLoaiVang() {
		return loaiVang;
	}

	public void setLoaiVang(String loaiVang) {
		if (!loaiVang.trim().equals(""))
			this.loaiVang = loaiVang;
		else
			this.loaiVang = "khong duoc rong";
	}
	/**
	 * tinh thành tiền
	 * @return thanh tien so luong * don gia;
	 */
	public double getThanhTien() {
		return super.getThanhTien();
		
	}

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,##0");
		return "GiaoDichVang [" + super.toString() + "loaiVang=" + loaiVang + ", getThanhTien()=" + df.format(getThanhTien()) + "]";
	}
	
	


}
