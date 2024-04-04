package Demo.DEON;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SinhVien {
	private String maSSV;
	private String tenSV;
	private LocalDate ngaySinh;
	private boolean gioiTinh;
	private int soTC;
	private double soTienMotTC = 750000;
	private double diemTB;

	public SinhVien(String maSSV, String tenSV, LocalDate ngaySinh, boolean gioiTinh, int soTC, double diemTB) {
		setMaSSV(maSSV);
		setTenSV(tenSV);
		setNgaySinh(ngaySinh);
		setGioiTinh(gioiTinh);
		setSoTC(soTC);
		this.soTienMotTC = 750000;
		setDiemTB(diemTB);
	}

	public String getMaSSV() {
		return maSSV;
	}

	public void setMaSSV(String maSSV) {
		if (!maSSV.trim().equals("") && maSSV.indexOf("SV", 0) == 0)
			this.maSSV = maSSV;
		else
			this.maSSV = "chua xac dinh";
	}

	public String getTenSV() {
		return tenSV;
	}

	public void setTenSV(String tenSV) {
		if (!tenSV.trim().equals(""))
			this.tenSV = tenSV;
		else
			this.tenSV = "chua xac dinh";
	}

	public LocalDate getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(LocalDate ngaySinh) {
		if (ngaySinh.getYear() <= 2003)
			this.ngaySinh = ngaySinh;
		else
			this.ngaySinh = LocalDate.of(2000, 1, 1);
	}

	public boolean isGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public int getSoTC() {
		return soTC;
	}

	public void setSoTC(int soTC) {
		if (soTC >= 0)
			this.soTC = soTC;
		else
			this.soTC = 0;
	}

	public double getSoTienMotTC() {
		return soTienMotTC;
	}

	public void setSoTienMotTC(double soTienMotTC) {
		this.soTienMotTC = soTienMotTC;
	}

	public double getDiemTB() {
		return diemTB;
	}

	public void setDiemTB(double diemTB) {
		if (diemTB >= 0 && diemTB <= 10)
			this.diemTB = diemTB;
		else
			this.diemTB = 0;
	}

	public double tinhTienTinChi() {
		return soTC * soTienMotTC;
	}

	public String toString()
	{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String s="";
		s = (isGioiTinh()==true) ? "Nam" : "Nu";
		DecimalFormat df = new DecimalFormat("#,##0VND");
		return String.format("%s[%s,%s,%s],SoTC:%d,SoTien:%s-DiemTB:%.2f", 
				tenSV,maSSV,dtf.format(ngaySinh),s,soTC,df.format(tinhTienTinChi()),diemTB);
	}
}
