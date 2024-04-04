package CK.NganHang;

import java.text.DecimalFormat;

public class TheGhiNo extends TaiKhoan {

	private double soTienHienCo;

	public TheGhiNo(String maThe, String tenChuSoHuu, double soTienHienCo) {
		super(maThe, tenChuSoHuu);
		setSoTienHienCo(soTienHienCo);
	}

	public double getSoTienHienCo() {
		return soTienHienCo;
	}

	public void setSoTienHienCo(double soTienHienCo) {
		if (soTienHienCo >= 0)
			this.soTienHienCo = soTienHienCo;
		else
			this.soTienHienCo = 0;
	}

	@Override
	public boolean khaNangChiTieu() {
		if(soTienHienCo >=100000)
			return true;
		else
			return false;
	}

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,##0");
		String s = "";
		if(khaNangChiTieu() == true)
		{
			s = s + "Co";
		}
		else
		{
			s = s + "Khong";
		}
		return String.format("%s%-10s%-10s%-10s%-10s", super.toString(),df.format(soTienHienCo),"-","-", s);
	
	}
	

}
