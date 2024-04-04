package Demo.deThiKT2TH;

import java.text.DecimalFormat;
import java.time.LocalDate;

public abstract class Sap {

	private String maSap;
	private double dienTich;
	private double donGiaThue = 5000000;
	private double doanhThu;
	private LocalDate ngayThanhLap;

	public Sap(String maSap, double dienTich, double donGiaThue, double doanhThu, LocalDate ngayThanhLap) {
		setMaSap(maSap);
		setDienTich(dienTich);
		setDonGiaThue(donGiaThue);
		setDoanhThu(doanhThu);
		setNgayThanhLap(ngayThanhLap);

	}

	public Sap() {
		this.maSap = "chua duoc rong";
		this.dienTich = 0;
		this.donGiaThue = 5000000;
		this.doanhThu = 0;
	}

	public LocalDate getNgayThanhLap() {
		return ngayThanhLap;
	}

	public void setNgayThanhLap(LocalDate ngayThanhLap) {
		if (ngayThanhLap.isAfter(LocalDate.now()))
			this.ngayThanhLap = ngayThanhLap;
		else
			this.ngayThanhLap = LocalDate.now();
	}

	public String getMaSap() {
		return maSap;
	}

	public void setMaSap(String maSap) {
		if (!maSap.trim().equals(""))
			this.maSap = maSap;
		else
			this.maSap = "chua duoc rong";
	}

	public double getDienTich() {
		return dienTich;
	}

	public void setDienTich(double dienTich) {
		if (dienTich > 0)
			this.dienTich = dienTich;
		else
			this.dienTich = 0;
	}

	public double getDonGiaThue() {
		return donGiaThue;
	}

	public void setDonGiaThue(double donGiaThue) {
		if (donGiaThue > 0)
			this.donGiaThue = 5000000;
		else
			this.donGiaThue = 0;
	}

	public double getDoanhThu() {
		return doanhThu;
	}

	public void setDoanhThu(double doanhThu) {
		if (doanhThu > 0)
			this.doanhThu = doanhThu;
		else
			this.doanhThu = 0;
	}

	public abstract double tienThueSap();

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,##0");
		return "Sap [maSap=" + maSap + ", dienTich=" + dienTich + ", donGiaThue=" + df.format(donGiaThue)
				+ ", doanhThu=" + df.format(doanhThu) + "Ngay thanh lap: "+ ngayThanhLap + "]";
	}

}
