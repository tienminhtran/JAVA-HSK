package chuong04.chuyenXe;

public class ChuyenXe {
	private String maSoChuyen, hoTenTaiXe, soXe;
	private double doanhThu;
	public String getMaSoChuyen() {
		return maSoChuyen;
	}
	public void setMaSoChuyen(String maSoChuyen) {
		this.maSoChuyen = maSoChuyen;
	}
	public String getHoTenTaiXe() {
		return hoTenTaiXe;
	}
	public void setHoTenTaiXe(String hoTenTaiXe) {
		this.hoTenTaiXe = hoTenTaiXe;
	}
	public String getSoXe() {
		return soXe;
	}
	public void setSoXe(String soXe) {
		this.soXe = soXe;
	}
	public double getDoanhThu() {
		return doanhThu;
	}
	public void setDoanhThu(double doanhThu) {
		this.doanhThu = doanhThu;
	}
	public ChuyenXe(String maSoChuyen, String hoTenTaiXe, String soXe, double doanhThu) {
		this.maSoChuyen = maSoChuyen;
		this.hoTenTaiXe = hoTenTaiXe;
		this.soXe = soXe;
		this.doanhThu = doanhThu;
	}
	public ChuyenXe() {
		super();
	}
	@Override
	public String toString() {
		return "ChuyenXe [maSoChuyen=" + maSoChuyen + ", hoTenTaiXe=" + hoTenTaiXe + ", soXe=" + soXe + ", doanhThu="
				+ doanhThu + "]";
	}

	
}
