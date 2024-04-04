package CK.NhanVien;

import java.text.DecimalFormat;

public class NhanVienHanhChinh extends NhanVien{
	private int soNgayNghi;
	



	public NhanVienHanhChinh(String maNhanVien, double heSoLuong, double phuCap, int soNgayNghi) {
		super(maNhanVien, heSoLuong, phuCap);
		setSoNgayNghi(soNgayNghi);
	}

	public int getSoNgayNghi() {
		return soNgayNghi;
	}


	public void setSoNgayNghi(int soNgayNghi) {
		if(soNgayNghi >=0)
		this.soNgayNghi = soNgayNghi;
		else
			this.soNgayNghi = 0;
	}

	@Override
	public double tinhLuongNhanVien() {
		return super.getHeSoLuong()*1490 + super.getPhuCap() +soNgayNghi*200;
	}

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,##0.000");
		return String.format("%s%-10s%-10s%-10d%-10s", super.toString(),"-","-",soNgayNghi,df.format(tinhLuongNhanVien()));
	}
	

}
