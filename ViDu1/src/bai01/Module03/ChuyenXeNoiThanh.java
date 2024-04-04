package bai01.Module03;

public class ChuyenXeNoiThanh extends ChuyenXe {
	private double soKM;
	private int soTuyen;

	public ChuyenXeNoiThanh(String maCX, String hoTen, String soXe, double doanhThu, double soKM, int soTuyen) {
		super(maCX, hoTen, soXe, doanhThu);
		this.soKM = soKM;
		this.soTuyen = soTuyen;
	}

	public double getSoKM() {
		return soKM;
	}

	public void setSoKM(double soKM) {
		if (soKM > 0)
			this.soKM = soKM;
		else
			this.soKM = 0;
	}

	public int getSoTuyen() {
		return soTuyen;
	}

	public void setSoTuyen(int soTuyen) {
		if (soTuyen > 0)
			this.soTuyen = soTuyen;
		else
			this.soTuyen = 0;
	}

	public String toString() {
		return String.format(
				"Ma So chuyen: %s, Ho Ten: %s, So xe %s, doanh thu: %.2f, sotuyen: %d, soKM di duoc: %.2fkm",
				super.getMaCX(), super.getHoTen(), super.getSoXe(), super.getDoanhThu(), soTuyen, soKM);
	}
}
