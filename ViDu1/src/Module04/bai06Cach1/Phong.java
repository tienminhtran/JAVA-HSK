package Module04.bai06Cach1;

import java.text.DecimalFormat;

public abstract class Phong {
	private String maPhong;
	private String dayNha;
	private double dienTich;
	private int soBongDen;

	public Phong(String maPhong, String dayNha, double dienTich, int soBongDen) {
		setMaPhong(maPhong);
		setDayNha(dayNha);
		setDienTich(dienTich);
		setSoBongDen(soBongDen);
	}

	public Phong()
	{
		this.maPhong = "xxx";
		this.dayNha = "xxx";
		this.dienTich = 0;
		this.soBongDen = 0;
	}
	public String getMaPhong() {
		return maPhong;
	}

	public void setMaPhong(String maPhong) {
		if (!maPhong.trim().equals(""))
			this.maPhong = maPhong;
		else
			this.maPhong = "XXX";
	}

	public String getDayNha() {
		return dayNha;
	}

	public void setDayNha(String dayNha) {
		if (!dayNha.trim().equals(""))
			this.dayNha = dayNha;
		else
			this.dayNha = "xxx";
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

	public int getSoBongDen() {
		return soBongDen;
	}

	public void setSoBongDen(int soBongDen) {
		if (soBongDen > 0)
			this.soBongDen = soBongDen;
		else
			this.soBongDen = 0;
	}
	
	public boolean kiemTraDuAnhSach() {
		double ct = dienTich/10;
		if (dienTich >=10 && soBongDen >=ct) {
			return true;
		}
		return false;
	}

	public abstract boolean kiemTRaPhongDatChuan();

	@Override
	public String toString() {
		DecimalFormat dec = new DecimalFormat("#,##0");
		return String.format("%-8s %-7s %-9s %-11d", maPhong, dayNha, dec.format(dienTich), soBongDen);
	}

}
