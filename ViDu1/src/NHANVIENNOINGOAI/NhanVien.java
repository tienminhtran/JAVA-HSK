package NHANVIENNOINGOAI;

import java.text.DecimalFormat;
import java.time.LocalDate;

public abstract class NhanVien {
	private String maNhanVien;
	private String tenNhanVien;
	private LocalDate ngaySinh;
	private String diaChi;
	private int soSuatAn;
	private double giaSuatAn;

	public NhanVien(String maNhanVien, String tenNhanVien, LocalDate ngaySinh, String diaChi, int soSuatAn,
			double giaSuatAn) {
		setMaNhanVien(maNhanVien);
		setTenNhanVien(tenNhanVien);
		setNgaySinh(ngaySinh);
		setDiaChi(diaChi);
		setSoSuatAn(soSuatAn);
		setGiaSuatAn(giaSuatAn);
	}

	public NhanVien() {
		this.maNhanVien = "chua xac dinh";
		this.tenNhanVien = "chua xac dinh";
		this.ngaySinh = LocalDate.of(1999, 9, 9);
		this.diaChi = "chua xac dinh";
		this.soSuatAn = 0;
		this.giaSuatAn = 0;
	}

	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		if (!maNhanVien.trim().equals(""))
			this.maNhanVien = maNhanVien;
		else
			this.maNhanVien = "chua xac dinh";
	}

	public String getTenNhanVien() {
		return tenNhanVien;
	}

	public void setTenNhanVien(String tenNhanVien) {
		if (!tenNhanVien.trim().equals(""))
			this.tenNhanVien = tenNhanVien;
		else
			this.tenNhanVien = "chua xac dinh";
	}

	public LocalDate getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(LocalDate ngaySinh) {
		if (ngaySinh.isBefore(LocalDate.now()) && ngaySinh.getYear() <= 2002)
			this.ngaySinh = ngaySinh;
		else
			this.ngaySinh = LocalDate.of(1999, 9, 9);
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		if (!diaChi.trim().equals(""))
			this.diaChi = diaChi;
		else
			this.diaChi = "chua xac dinh";
	}

	public int getSoSuatAn() {
		return soSuatAn;
	}

	public void setSoSuatAn(int soSuatAn) {
		if (soSuatAn >= 0)
			this.soSuatAn = soSuatAn;
		else
			this.soSuatAn = 0;
	}

	public double getGiaSuatAn() {
		return giaSuatAn;
	}

	public void setGiaSuatAn(double giaSuatAn) {
		if (giaSuatAn > 0)
			this.giaSuatAn = giaSuatAn;
		else
			this.giaSuatAn = 0;
	}
	
	public abstract double tienAn();

	
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,##0");
		return "NhanVien [maNhanVien=" + maNhanVien + ", tenNhanVien=" + tenNhanVien + ", ngaySinh=" + ngaySinh
				+ ", diaChi=" + diaChi + ", soSuatAn=" + soSuatAn + ", giaSuatAn=" + giaSuatAn + "]";
	}
	
	

}
