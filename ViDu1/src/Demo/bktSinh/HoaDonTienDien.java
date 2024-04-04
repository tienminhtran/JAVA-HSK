package Demo.bktSinh;

import java.time.LocalDate;

public class HoaDonTienDien {
	private String ma;
	private LocalDate ngayLapHoaDon;
	private double soKWTieuThu, donGia;

	public HoaDonTienDien(String ma, LocalDate ngayLapHoaDon, double soKWTieuThu, double donGia) {
		setMa(ma);
		setNgayLapHoaDon(ngayLapHoaDon);
		setSoKWTieuThu(soKWTieuThu);
		setDonGia(donGia);
	}

	public HoaDonTienDien() {
		this.ma = "xxxx";
		this.ngayLapHoaDon = LocalDate.now();
		this.soKWTieuThu = 0;
		this.donGia = 0;
	}

	public String getMa() {
		return ma;
	}

	public void setMa(String ma) {
		if ((ma.charAt(0) == 'A' || ma.charAt(0) == 'B') && 
				!ma.trim().equals(""))
			this.ma = ma;
		else
			this.ma = "xxxx";
	}

	public LocalDate getNgayLapHoaDon() {
		return ngayLapHoaDon;
	}

	public void setNgayLapHoaDon(LocalDate ngayLapHoaDon) {
		if (ngayLapHoaDon.isBefore(LocalDate.now()))
			this.ngayLapHoaDon = ngayLapHoaDon;
		else
			this.ngayLapHoaDon = LocalDate.now();

	}

	public double getSoKWTieuThu() {
		return soKWTieuThu;
	}

	public void setSoKWTieuThu(double soKWTieuThu) {
		if (soKWTieuThu >= 0)
			this.soKWTieuThu = soKWTieuThu;
		else
			this.soKWTieuThu = 0;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		if (donGia >= 0)
			this.donGia = donGia;
		else
			this.donGia = 0;
	}
//	Hàm tinhTien() trả về tiền điện = số kw tiêu thụ * đơn giá, nhưng nếu mã khách hàng bắt đầu là “B”
//			thì đơn giá tính gấp đôi;
	public double tinhTien() {
		if(ma.charAt(0) == 'B') 
			return soKWTieuThu*donGia*2;
		else 
			return soKWTieuThu*donGia;
	}

	@Override
	public String toString() {
		return "HoaDonTienDien [ma=" + ma + ", ngayLapHoaDon=" + ngayLapHoaDon + ", soKWTieuThu=" + soKWTieuThu
				+ ", donGia=" + donGia + ", tinhTien()=" + tinhTien() + "]";
	}
	
}
