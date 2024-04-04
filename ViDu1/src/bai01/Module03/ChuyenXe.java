package bai01.Module03;

public class ChuyenXe {
	private String maCX;
	private String hoTen;
	private String soXe;
	private double doanhThu;

	public ChuyenXe(String maCX, String hoTen, String soXe, double doanhThu) {
		setMaCX(maCX);
		setHoTen(hoTen);
		setSoXe(soXe);		
		setDoanhThu(doanhThu);
	}

	public String getMaCX() {
		return maCX;
	}

	public void setMaCX(String maCX) {
		if (!maCX.trim().equals(""))
			this.maCX = maCX;
		else
			this.maCX = "Khong rong";
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		if (!hoTen.trim().equals(""))
			this.hoTen = hoTen;
		else
			this.hoTen = "Khong rong";
	}

	public String getSoXe() {
		return soXe;
	}

	public void setSoXe(String soXe) {
		if (!soXe.trim().equals(""))
			this.soXe = soXe;
		else
			this.soXe = "Khong rong";
	}

	public double getDoanhThu() {
		return doanhThu;
	}

	public void setDoanhThu(double doanhThu) {
		if(doanhThu >= 0)
		this.doanhThu = doanhThu;
		else
			this.doanhThu = 0;
	}

	public String toString() {
		return String.format("Ma So chuyen: %s, Ho Ten: %s, So xe %s, doanh thu: %.2f", maCX, hoTen, soXe, doanhThu);
	}
}
