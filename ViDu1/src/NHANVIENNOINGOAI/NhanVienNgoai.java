package NHANVIENNOINGOAI;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class NhanVienNgoai extends NhanVien {
	private double thue;

	public NhanVienNgoai(String maNhanVien, String tenNhanVien, LocalDate ngaySinh, String diaChi, int soSuatAn,
			double giaSuatAn, double thue) {
		super(maNhanVien, tenNhanVien, ngaySinh, diaChi, soSuatAn, giaSuatAn);
		this.thue = thue;
	}

	public NhanVienNgoai() {
		this.thue = 0;
	}

	public double getThue() {
		return thue;
	}

	public void setThue(double thue) {
		if (thue >= 0)
			this.thue = thue;
		else
			this.thue = 0;
	}

	@Override
	public double tienAn() {
		return super.getSoSuatAn()*super.getGiaSuatAn()+thue;
	}

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,##0");
		return "NhanVienNgoai [ toString()=" + super.toString()+ "thue=" + thue + ", tienAn()=" + df.format(tienAn()) +"]";
	}
	

}
