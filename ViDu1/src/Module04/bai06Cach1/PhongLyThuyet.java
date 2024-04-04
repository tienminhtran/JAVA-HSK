package Module04.bai06Cach1;

import java.text.DecimalFormat;

public class PhongLyThuyet  extends Phong{
	private boolean mayChieu;

	public PhongLyThuyet(String maPhong, String dayNha, double dienTich, int soBongDen, boolean mayChieu) {
		super(maPhong, dayNha, dienTich, soBongDen);
		this.mayChieu = mayChieu;
	}

	public boolean isMayChieu() {
		return mayChieu;
	}

	public void setMayChieu(boolean mayChieu) {
		this.mayChieu = mayChieu;
	}

	@Override
	public boolean kiemTRaPhongDatChuan() {
		if(super.kiemTraDuAnhSach())
			return mayChieu; 
		return false;
	}

	@Override
	public String toString() {
		return String.format("%s %-20s",super.toString(),kiemTRaPhongDatChuan() ? "Co may chieu" : "Khong may chieu");
	}
}
