package bai06.Module03;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class HangSanhSu extends HangHoa{
	private String nhaSanXuat;
	private LocalDate ngayNhapKho;

	public HangSanhSu(String maHang, String tenHang, double donGia, int soLuongTon, String nhaSanXuat, LocalDate ngayNhapKho) {
		super(maHang, tenHang, donGia, soLuongTon);
		setNgaySanXuat(nhaSanXuat);
		setNgayNhapKho(ngayNhapKho);
	}

	public HangSanhSu() {
		this.nhaSanXuat = "chua duoc rong";
		this.ngayNhapKho = LocalDate.now();
	}

	public String getNhaSanXuat() {
		return nhaSanXuat;
	}

	public void setNgaySanXuat(String nhaSanXuat) {
		if (!nhaSanXuat.trim().equals(""))
			this.nhaSanXuat = nhaSanXuat;
		else
			this.nhaSanXuat = "chua duoc rong";
	}

	public LocalDate getNgayNhapKho() {
		return ngayNhapKho;
	}

	public void setNgayNhapKho(LocalDate ngayNhapKho) {
		if (ngayNhapKho.isBefore(LocalDate.now()))
			this.ngayNhapKho = ngayNhapKho;
		else
			this.ngayNhapKho = LocalDate.now();
	}
	public long tinhSoNgayLuuKho() {
		LocalDate now = LocalDate.now();
		long sn = ngayNhapKho.until(now, ChronoUnit.DAYS);
		return sn;
	}

	@Override
	public boolean mucDoBuonBan() {
		if (this.getSoLuongTon() > 50 && tinhSoNgayLuuKho() > 10) {
			return true;
		}
		return false;
	}

	@Override
	public double tinhTienVAT() {
		
		return getDonGia()*0.1;
	}
	@Override
	public String toString() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("#,##0.000");
		String s = "-";
		return String.format("%s|%-15s|%-20s|%-20s|%-20s|%-20s|%-20s|%20s|%-20s|%20s|", super.toString(),s,s,s
				,s, s,nhaSanXuat, dtf.format(ngayNhapKho),mucDoBuonBan()?"Ban cham" : "Khong danh gia",df.format(tinhTienVAT()));
//		return String.format("%s, NSX: %s, Ngay nhap kho: %s, Muc do: %s, Tinh tien VAT: %s", super.toString(), nhaSanXuat, dtf.format(ngayNhapKho), mucDoBuonBan()?"Ban cham" : "Khong danh gia",df.format(tinhTienVAT()));
	}

}
