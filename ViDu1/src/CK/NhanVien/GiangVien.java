package CK.NhanVien;

import java.text.DecimalFormat;

public class GiangVien extends NhanVien{
	private TrinhDo trinhDo;
	private int soTietDay;
	
	
	public GiangVien(String maNhanVien, double heSoLuong, double phuCap, TrinhDo trinhDo, int soTietDay) {
		super(maNhanVien, heSoLuong, phuCap);
		this.trinhDo = trinhDo;
		setSoTietDay(soTietDay);
	}


	public TrinhDo getTrinhDo() {
		return trinhDo;
	}


	public void setTrinhDo(TrinhDo trinhDo) {
		this.trinhDo = trinhDo;
	}


	public int getSoTietDay() {
		return soTietDay;
	}


	public void setSoTietDay(int soTietDay) {
		if(soTietDay>=0)
		this.soTietDay = soTietDay;
		else
			soTietDay = 0;
	}


	@Override
	public double tinhLuongNhanVien() {
		if(trinhDo.TS.equals("TS"))
		{
			return super.getHeSoLuong()*1490 + super.getPhuCap() + soTietDay*100*1.5;
		}
		else
			return super.getHeSoLuong()*1490 + super.getPhuCap() + soTietDay*100;
	
	}


	@Override
	public String toString() {
		
		DecimalFormat df = new DecimalFormat("#,##0.000");
		return String.format("%s%-10s%-10d%-10s%-10s", super.toString(),trinhDo,soTietDay,"-",df.format(tinhLuongNhanVien()));
	}
	
	
}
