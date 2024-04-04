package CK.NhanVien;

import java.util.Objects;

public abstract class NhanVien {
	private String maNhanVien;
	private double heSoLuong;
	private double phuCap;

	public NhanVien(String maNhanVien, double heSoLuong, double phuCap) {
		setMaNhanVien(maNhanVien);
		setHeSoLuong(heSoLuong);
		setPhuCap(phuCap);

	}

	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		if (!maNhanVien.trim().equals(""))
			this.maNhanVien = maNhanVien;
		else
			this.maNhanVien = "xxx";
	}

	public double getHeSoLuong() {
		return heSoLuong;
	}

	public void setHeSoLuong(double heSoLuong) {
		if (heSoLuong >= 0)
			this.heSoLuong = heSoLuong;
		else
			this.heSoLuong = 0;
	}

	public double getPhuCap() {
		return phuCap;
	}

	public void setPhuCap(double phuCap) {
		if (phuCap >= 2.34 && phuCap <=4.99)
			this.phuCap = phuCap;
		else
			this.phuCap = 0;
	}

	public abstract double tinhLuongNhanVien();

	@Override
	public String toString() {
		return String.format("%-10s%-10.2f%-10.2f", maNhanVien, heSoLuong, phuCap);
	}

	@Override
	public int hashCode() {
		return Objects.hash(maNhanVien);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhanVien other = (NhanVien) obj;
		return Objects.equals(maNhanVien, other.maNhanVien);
	}
	
	
	
	
}
