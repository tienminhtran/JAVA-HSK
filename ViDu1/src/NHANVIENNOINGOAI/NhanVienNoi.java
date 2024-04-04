package NHANVIENNOINGOAI;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class NhanVienNoi extends NhanVien {

	private boolean loaiXuatAn;

	public NhanVienNoi(String maNhanVien, String tenNhanVien, LocalDate ngaySinh, String diaChi, int soSuatAn,
			double giaSuatAn, Boolean loaiXuatAn) {
		super(maNhanVien, tenNhanVien, ngaySinh, diaChi, soSuatAn, giaSuatAn);
		this.loaiXuatAn = loaiXuatAn;
	}

	/**
	 * true công nghiệp flase phục vụ
	 */
	public NhanVienNoi() {
		this.loaiXuatAn = true;
	}

	public boolean isLoaiXuatAn() {
		return loaiXuatAn;
	}

	public void setLoaiXuatAn(boolean loaiXuatAn) {
		this.loaiXuatAn = loaiXuatAn;
	}

	@Override
	public double tienAn() {
		if (isLoaiXuatAn() == true) {
			return super.getSoSuatAn() * super.getGiaSuatAn();
		} else
			return super.getSoSuatAn() * super.getGiaSuatAn() * 0.05;
	}

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,##0");
		return "NhanVienNoi [ toString()=" + super.toString() +", loaiXuatAn=" + loaiXuatAn + ", tienAn()= "+df.format(tienAn())
				+ "]";
	}


	

}
