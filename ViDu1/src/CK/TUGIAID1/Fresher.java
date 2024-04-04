package CK.TUGIAID1;

import java.time.LocalDate;

public class Fresher extends Employee{
	private int namTotNghiep;
	private LoaiTotNghiep xepLoai;
	public Fresher(String ma, FullName hoTen, LocalDate ngaySinh, String soDienThoai, int namTotNghiep,
			LoaiTotNghiep xepLoai) {
		super(ma, hoTen, ngaySinh, soDienThoai);
		setNamTotNghiep(namTotNghiep);
		setXepLoai(xepLoai);
	}
	public Fresher() {
		this.namTotNghiep = LocalDate.now().getYear();
		this.xepLoai = LoaiTotNghiep.A;
	}
	public int getNamTotNghiep() {
		return namTotNghiep;
	}
	public void setNamTotNghiep(int namTotNghiep) {
		if(namTotNghiep <=LocalDate.now().getYear())
		this.namTotNghiep = namTotNghiep;
		else
			this.namTotNghiep = LocalDate.now().getYear();
	}
	public LoaiTotNghiep getXepLoai() {
		return xepLoai;
	}
	public void setXepLoai(LoaiTotNghiep xepLoai) {
		this.xepLoai = xepLoai;
	}
	@Override
	public String toString() {
		return String.format("%s %-15s %-15d %-15s %-15s %-15s", super.toString(),"-",namTotNghiep,xepLoai,"-","-");
	}
	

}
