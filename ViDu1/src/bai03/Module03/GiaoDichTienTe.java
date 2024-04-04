package bai03.Module03;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class GiaoDichTienTe extends GiaoDich {
	private double tiGia;
	private LoaiTienTe loaiTien;

	public GiaoDichTienTe(String maGiaoDich, LocalDate ngayGiaoDich, double donGia, int soLuong, double tiGia,
			LoaiTienTe loaiTien) {
		super(maGiaoDich, ngayGiaoDich, donGia, soLuong);
		setTiGia(tiGia);
		setLoaiTien(loaiTien);
	}

	public double getTiGia() {
		return tiGia;
	}

	public void setTiGia(double tiGia) {
		if (tiGia >= 0)
			this.tiGia = tiGia;
		else
			this.tiGia = 0;
	}

	public LoaiTienTe getLoaiTien() {
		return loaiTien;
	}

	public void setLoaiTien(LoaiTienTe loaiTien) {
		if (LoaiTienTe.VN.equals("VN"))
			this.loaiTien = loaiTien;
		else
			this.loaiTien = LoaiTienTe.VN;
	}

	/**
	 * @return thành tiền o Nếu là tiền USD hoặc Euro thì: thành tiền = số lượng *
	 *         đơn giá * tỉ giá. o Nếu là tiền VN thì: thành tiềloa = số lượng * đơn
	 *         giá.
	 */
	public double getThanhTien() {
		if (getLoaiTien().equals(loaiTien))
			return super.getThanhTien();
		else {
			return super.getThanhTien() * tiGia;
		}
	}

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,##0");
		return "GiaoDichTienTe [" + super.toString() + "tiGia=" + df.format(tiGia) + ", loaiTien=" + loaiTien + ", getThanhTien()="
				+ df.format(getThanhTien()) + "]";
	}

}
