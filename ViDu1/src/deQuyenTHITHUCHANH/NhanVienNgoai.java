package deQuyenTHITHUCHANH;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class NhanVienNgoai extends NhanVien {
	private double thue;

	public NhanVienNgoai(String maNV, String tenNV, LocalDate ngaySinh, String diaChi, int soSuatAn, double giaSuatAn,
			double thue) {
		super(maNV, tenNV, ngaySinh, diaChi, soSuatAn, giaSuatAn);
		setThue(thue);
	}

	public NhanVienNgoai() {
		super();
		this.thue = 1;
	}

	public double getThue() {
		return thue;
	}

	public void setThue(double thue) {
		if (thue > 0) {
			this.thue = thue;
		} else {
			this.thue = 1;
		}
	}

	@Override
	public double tinhTien() {
		return getGiaSuatAn() * getSoSuatAn() + thue;
	}

	public static String getTieuDe() {
		return NhanVien.getTieuDe() + String.format("  %20s  %10s", "Thue", "Tien An");
	}

	public String toString() {
		DecimalFormat df = new DecimalFormat("#,##0.00");
		return super.toString() + String.format("  %20s  %10s", df.format(thue), df.format(tinhTien()));
	}

}
