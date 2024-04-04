package CK.NganHang;

import java.text.DecimalFormat;

public class TheTinDung extends TaiKhoan {
	private double mucHanTinDung;
	private double tongTienChiTieu;

	public TheTinDung(String maThe, String tenChuSoHuu, double mucHanTinDung, double tongTienChiTieu) {
		super(maThe, tenChuSoHuu);
		setMucHanTinDung(mucHanTinDung);
		setTongTienChiTieu(tongTienChiTieu);
		
	}

	public double getMucHanTinDung() {
		return mucHanTinDung;
	}

	public void setMucHanTinDung(double mucHanTinDung) {
		if (mucHanTinDung >= 0)
			this.mucHanTinDung = mucHanTinDung;
		else
			this.mucHanTinDung = 0;
	}

	public double getTongTienChiTieu() {
		return tongTienChiTieu;
	}

	public void setTongTienChiTieu(double tongTienChiTieu) {
		if (tongTienChiTieu >= 0)
			this.tongTienChiTieu = tongTienChiTieu;
		else
			this.tongTienChiTieu = 0;
	}

	@Override
	public boolean khaNangChiTieu() {
		if(tongTienChiTieu >= mucHanTinDung)
			return true;
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
		return String.format("%s%-10s%-10s%-10s%-10s", super.toString(),"-",df.format(mucHanTinDung),df.format(tongTienChiTieu), s);

	}
	

}
