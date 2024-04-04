package Demo.HTTT17A_3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SinhVien {
	private String maSV;
	private String tenSV;
	private boolean gioiTinh;
	private LocalDate ngaySinh;

	public SinhVien(String maSV, String tenSV, boolean gioiTinh, LocalDate ngaySinh) {
		setMaSV(maSV);
		setTenSV(tenSV);
		setGioiTinh(gioiTinh);
		setNgaySinh(ngaySinh);
	}

	public String getMaSV() {
		return maSV;
	}

	public void setMaSV(String maSV) {
		if (!maSV.trim().equals(""))
			this.maSV = maSV;
		else
			this.maSV = "chua xac dinh";
	}

	public String getTenSV() {
		return tenSV;
	}

	public void setTenSV(String tenSV) {
		if (!tenSV.trim().equals(""))
			this.tenSV = tenSV;
		else
			this.tenSV = "chua xac dinh";
	}

	public boolean isGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public LocalDate getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(LocalDate ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String layTieuDe()
	{
		return String.format("%-20s %-20s %-20s %-20s %-20s", "STT", "MSSV", "HO TEN", "GIOI TINH", "NGAY SINH");
	}
	@Override
	public String toString() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String s = "";
		if (isGioiTinh() == true) 
		{
			s = "Nam";
		} else 
		{
			s = "Nu";
		}
		return String.format("%-20s %-20s %-20s %-20s\n", maSV, tenSV, s, dtf.format(ngaySinh));
	}

}
