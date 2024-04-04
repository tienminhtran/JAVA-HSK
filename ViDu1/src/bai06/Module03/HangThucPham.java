package bai06.Module03;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HangThucPham extends HangHoa {
	private String nhaCungCap;
	private LocalDate ngaySanXuat;
	private LocalDate ngayHetHan;

	public HangThucPham(String maHang, String tenHang, double donGia, int soLuongTon, String nhaCungCap,
			LocalDate ngaySanXuat, LocalDate ngayHetHan) {
		super(maHang, tenHang, donGia, soLuongTon);
		setNhaCungCap(nhaCungCap);
		setNgaySanXuat(ngaySanXuat);
		setNgayHetHan(ngayHetHan);
	}
	

	public HangThucPham(String maHang, String tenHang, double donGia, int soLuongTon) {
		super(maHang, tenHang, donGia, soLuongTon);
		this.nhaCungCap = "Khong duoc rong";
		this.ngaySanXuat = LocalDate.now();
		this.ngayHetHan = ngaySanXuat;
	}

	public String getNhaCungCap() {
		return nhaCungCap;
	}

	public void setNhaCungCap(String nhaCungCap) {
		if (!nhaCungCap.trim().equals(""))
			this.nhaCungCap = nhaCungCap;
		else
			this.nhaCungCap = "khong duoc rong";
	}

	public LocalDate getNgaySanXuat() {
		return ngaySanXuat;
	}

	public void setNgaySanXuat(LocalDate ngaySanXuat) {
		if (ngaySanXuat.isBefore(LocalDate.now()))
			this.ngaySanXuat = ngaySanXuat;
		else
			this.ngaySanXuat = LocalDate.now();
	}

	public LocalDate getNgayHetHan() {
		return ngayHetHan;
	}

	public void setNgayHetHan(LocalDate ngayHetHan) {
		if (ngayHetHan.isAfter(ngaySanXuat))
			this.ngayHetHan = ngayHetHan;
		else
			this.ngayHetHan = ngaySanXuat;
	}

	@Override
	public boolean mucDoBuonBan() {
		if(this.getSoLuongTon() > 0 && !ngayHetHan.isAfter(LocalDate.now()))
		{
			return true;
		}
		return false;
	}

	@Override
	public double tinhTienVAT() {
		return getDonGia()*0.05;
	}
	@Override
	public String toString() {
//		return String.format("|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|",
//				"Ma hang", "Ten hang", "DonGia", "So luong ton", "Nha cung cap", "Ngay san xuat", "Ngay het han",
//				"Tg bao hanh", "Cong xuat", "Ngay san xuat", "Ngay nhap kho", "Muc do", "Thanh tien");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("#,##0.000");
		String s = "-";
		return String.format("%s|%-15s|%20s|%20s|%-20s|%-20s|%-20s|%-20s|%-20s|%20s|", super.toString(),nhaCungCap, dtf.format(ngaySanXuat), dtf.format(ngayHetHan)
				,s,s,s,s,mucDoBuonBan()?"Kho ban" : "Khong danh gia",df.format(tinhTienVAT()));
//		return String.format("%s, Nha cung cap: %s, NXS: %s den NHH: %s, Muc do: %s, Tinh tien VAT: %s",
		//super.toString(), nhaCungCap, dtf.format(ngaySanXuat), dtf.format(ngayHetHan), mucDoBuonBan()?"Kho ban" : "Khong danh gia",df.format(tinhTienVAT() )  );
	}

}
