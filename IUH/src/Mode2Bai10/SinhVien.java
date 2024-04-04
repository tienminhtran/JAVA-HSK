package Mode2Bai10;

public class SinhVien {
	private String maSV;
	private String hoTen;
	public SinhVien(String maSV, String hoTen) {
		this.maSV = maSV;
		this.hoTen = hoTen;
	}
	public String getMaSV() {
		return maSV;
	}
	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String toString() {
		return String.format("%-5s|%-20s\n", maSV, hoTen);
	}
}
