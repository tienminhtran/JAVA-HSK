package bai11.Module02;


import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class SoTietKiem {
	private String maSo;
	private LocalDate ngayMoSo;
	private double soTienGoi;
	private int kyHan;
	private double laiSuat;
	
	public SoTietKiem(String maSo, LocalDate ngayMoSo, double soTienGoi, int kyHan, double laiSuat) {
		this.maSo = maSo;
		this.ngayMoSo = ngayMoSo;
		this.soTienGoi = soTienGoi;
		this.kyHan = kyHan;
		this.laiSuat = laiSuat;
	}

	public String getMaSo() {
		return maSo;
	}

	public void setMaSo(String maSo) {
		this.maSo = maSo;
	}

	public LocalDate getNgayMoSo() {
		return ngayMoSo;
	}

	public void setNgayMoSo(LocalDate ngayMoSo) {
		this.ngayMoSo = ngayMoSo;
	}

	public double getSoTienGoi() {
		return soTienGoi;
	}

	public void setSoTienGoi(double soTienGoi) {
		this.soTienGoi = soTienGoi;
	}

	public int getKyHan() {
		return kyHan;
	}

	public void setKyHan(int kyHan) {
		this.kyHan = kyHan;
	}

	public double getLaiSuat() {
		return laiSuat;
	}

	public void setLaiSuat(double laiSuat) {
		this.laiSuat = laiSuat;
	}
	// so 
	public int tinhSoThangGoiThuc() {
		Period age = Period.between(ngayMoSo, LocalDate.now());
		int dt_nam = age.getYears();
		int dt_thang = age.getMonths();
		int soThangGoi = dt_nam * 12 + dt_thang;
		if(soThangGoi % kyHan == 0) {
			return soThangGoi;
		}
		else
			return soThangGoi/kyHan*kyHan;
	}
	public double tinhTienLai() {
		return this.soTienGoi*this.laiSuat*tinhSoThangGoiThuc();
	}

	public String toString() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DecimalFormat dec = new DecimalFormat("#,##0.00");
//		return String.format("STK %s[%s - %s]KH %d thang, so thang tinh lai: %d, ls %.3f, so tien: %s --> Tien lai: %s\n",
//				this.maSo, dtf.format(ngayMoSo), dtf.format(LocalDate.now()),this.kyHan, tinhSoThangGoiThuc(), laiSuat, dec.format(soTienGoi), dec.format(tinhTienLai()));
		return String.format("|%-5s|%-15s|%-15s|%-2d thang  |%-18s|%-15.3f|%-15s|%-15s|\n",
				this.maSo, dtf.format(ngayMoSo), dtf.format(LocalDate.now()),this.kyHan, tinhSoThangGoiThuc(), laiSuat, dec.format(soTienGoi), dec.format(tinhTienLai()));
	}
	
}
