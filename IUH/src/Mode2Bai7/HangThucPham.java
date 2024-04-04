package Mode2Bai7;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HangThucPham {
	private String maHang;
	private String tenHang;
	private float donGia;
	private LocalDate ngaySanXuat;
	private LocalDate ngayHetHan;

	public HangThucPham(String maHang, String tenHang, float donGia, LocalDate ngaySanXuat, LocalDate ngayHetHan) throws Exception{
		setMaHang(maHang);
		setTenHang(tenHang);
		setDonGia(donGia);
		setNgaySanXuat(ngaySanXuat);
		setNgayHetHan(ngayHetHan);
	}

	public HangThucPham(String maHang) {
		this.maHang = maHang;
	}

	public String getMaHang() {
		return maHang;
	}

	public void setMaHang(String maHang) throws Exception {
		if (!maHang.trim().equals(" "))
			this.maHang = maHang;
		else
			throw new Exception("Loi: Ma hang rong!");
	}

	public String getTenHang() {
		return tenHang;
	}

	public void setTenHang(String tenHang) throws Exception {
		if (!tenHang.trim().equals(" "))
			this.tenHang = tenHang;
		else
			this.tenHang = "xxx";
	}

	public float getDonGia() {
		return donGia;
	}

	public void setDonGia(float donGia) {
		if (donGia >= 0) {
			this.donGia = donGia;
		} else
			this.donGia = 0;
	}

	public LocalDate getNgaySanXuat() {
		return ngaySanXuat;
	}

	public void setNgaySanXuat(LocalDate ngaySanXuat) {
		if (ngaySanXuat.isBefore(LocalDate.now())) // ngày sản xuất = ngày hiện tại
			this.ngaySanXuat = ngaySanXuat; 
		else
			this.ngaySanXuat = LocalDate.now();
	}

	public LocalDate getNgayHetHan() {
		return ngayHetHan;
	}

	public void setNgayHetHan(LocalDate ngayHetHan) {
		if (ngayHetHan.isAfter(ngaySanXuat)) // ngày hết hạn sau ngày sản xuất
			this.ngayHetHan = ngayHetHan;
		else
			this.ngayHetHan = ngaySanXuat;
	}
	//-	Kiểm tra hàng đã hết hạn chưa:
	public boolean kiemTraHetHan() {
		if(ngayHetHan.isBefore(LocalDate.now())) {
			return true; //5/9/2021 hh 5/6/2022
		}
		return false ;// 31/8/2018 // befor trước 
	}

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,##0.00VND");// đơn giá
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");// định dạng ngày  
		return String.format("%-15s%-20s%-15s%-30s%-30s%-30s", maHang, tenHang,df.format(donGia),
				dtf.format(ngaySanXuat),dtf.format(ngayHetHan), kiemTraHetHan() ? "Hang het han":" ");
	}
	
}
//HangThucPham
//-maHang: String
//-tenHang: String
//-donGia: float
//-ngaySanXuat: LocalDate
//-ngayHetHan: LocalDate
//+kiemTraHangHetHan: void
//+toString(): void
//<< constructor >>
//+HangThucPham(String, String, float, LocalDate, LocalDate)
//+HangThucPham(String)
//<< property get >>
//+getMaHang(): String
//+getTenHang():String
//+getDonGia():float
//+getNgaySanXuat(): LocalDate
//+getNgayHetHan():LocalDate
//<< property set >>
//+getTenHang(): void
//+getDonGia():void
//+getNgaySanXuat():void
//+getNgayHetHan():void
