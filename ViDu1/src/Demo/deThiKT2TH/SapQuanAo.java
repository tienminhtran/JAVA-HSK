package Demo.deThiKT2TH;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class SapQuanAo extends Sap{

	
	public SapQuanAo(String maSap, double dienTich, double donGiaThue, double doanhThu, LocalDate ngayThanhLap) {
		super(maSap, dienTich, donGiaThue, doanhThu, ngayThanhLap);
	}

	@Override
	public double tienThueSap() {
		if(super.getDoanhThu()<100000000)
		{
			return super.getDonGiaThue()*super.getDienTich()+0.1*super.getDoanhThu();
		}
		return super.getDonGiaThue()*super.getDienTich()+0.2*super.getDoanhThu();
	}

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,##0");

		return "SapQuanAo [toString()=" + super.toString()+" tienBanQuanLy=" + df.format(tienThueSap()) + "]";
	}

	
}
