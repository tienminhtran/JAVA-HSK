package bai01.Module03;

public class ChuyenXeNgoaiThanh extends ChuyenXe {

	private String noiDen;
	private int soNgayDi;

	public ChuyenXeNgoaiThanh(String maCX, String hoTen, String soXe, double doanhThu, String noiDen, int soNgayDi) {
		super(maCX, hoTen, soXe, doanhThu);
		this.noiDen = noiDen;
		this.soNgayDi = soNgayDi;
	}

	public String getNoiDen() {
		return noiDen;
	}

	public void setNoiDen(String noiDen) {
		if (!noiDen.trim().equals(""))
			this.noiDen = noiDen;
		else
			this.noiDen = "Khong rong";
	}

	public int getSoNgayDi() {
		return soNgayDi;
	}

	public void setSoNgayDi(int soNgayDi) {
		if (soNgayDi > 0)
			this.soNgayDi = soNgayDi;
		else
			this.soNgayDi = 0;
	}

	public String toString() {
		return String.format("Ma So chuyen: %s, Ho Ten: %s, So xe %s, doanh thu: %.2f, noi den: %s, so ngay di: %d",
				super.getMaCX(), super.getHoTen(), super.getSoXe(), super.getDoanhThu(), noiDen, soNgayDi);
	}
}
