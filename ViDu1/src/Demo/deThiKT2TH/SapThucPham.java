package Demo.deThiKT2TH;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class SapThucPham extends Sap {
	private double phiDichVuDongLanh;

	public SapThucPham(String maSap, double dienTich, double donGiaThue, double doanhThu, LocalDate ngayThanhLap, double phiDichVuDongLanh) {
		super(maSap, dienTich, donGiaThue, doanhThu, ngayThanhLap);
		setPhiDichVuDongLanh(phiDichVuDongLanh);
	}

	public SapThucPham() {
		this.phiDichVuDongLanh = 0;

	}

	public double getPhiDichVuDongLanh() {
		return phiDichVuDongLanh;
	}

	public void setPhiDichVuDongLanh(double phiDichVuDongLanh) {
		if (phiDichVuDongLanh > 0)
			this.phiDichVuDongLanh = phiDichVuDongLanh;
		else
			this.phiDichVuDongLanh = 0;
	}

	@Override
	public double tienThueSap() {
		return super.getDonGiaThue()*super.getDienTich()+0.05*super.getDoanhThu()+phiDichVuDongLanh;
	}

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,##0");
		return "SapThucPham [toString()=" + super.toString() + "phiDichVuDongLanh=" + phiDichVuDongLanh + ", tienBanQuanLy=" +  df.format(tienThueSap())
				+"]";
	}

}
