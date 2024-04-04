package deQuyenTHITHUCHANH;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class NhanVienNoi extends NhanVien {
	/*
	 * Return Đúng thì là suất ăn công nghiệp ngược lại là suất ăn phục vụ
	 */
	private boolean loaiSuatAn;

	public NhanVienNoi(String maNV, String tenNV, LocalDate ngaySinh, String diaChi, int soSuatAn, double giaSuatAn,
			boolean loaiSuatAn) {
		super(maNV, tenNV, ngaySinh, diaChi, soSuatAn, giaSuatAn);
		this.loaiSuatAn = loaiSuatAn;
	}

	public NhanVienNoi() {
		super();
		this.loaiSuatAn = true;
	}

	public boolean isLoaiSuatAn() {
		return loaiSuatAn;
	}

	public void setLoaiSuatAn(boolean loaiSuatAn) {
		this.loaiSuatAn = loaiSuatAn;
	}

	@Override
	public double tinhTien() {
		if (loaiSuatAn)
			return getSoSuatAn() * getGiaSuatAn();
		else {
			return getSoSuatAn() * getGiaSuatAn() + (getSoSuatAn() * getGiaSuatAn() * 0.05);
		}
	}

	public static String getTieuDe() {
		return NhanVien.getTieuDe() + String.format("  %-20s  %10s", "Loai Suat An", "Tien An");
	}

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,##0.00");
		return super.toString()
				+ String.format("  %-20s  %10s", loaiSuatAn ? "Cong Nghiep" : "Phuc Vu", df.format(tinhTien()));
	}

}
