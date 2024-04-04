package bai04.Module02;

public class DiemSinhVien {
	private int maSinhVien;
	private String hoTen;
	private double diemLT;
	private double diemTH;

	public DiemSinhVien(int maSinhVien, String hoTen, double diemLT, double diemTH) throws Exception{
//		this.maSinhVien = maSinhVien;
//		this.hoTen = hoTen;
//		this.diemLT = diemLT;
//		this.diemTH = diemTH;
		setMaSinhVien(maSinhVien);
		setHoTen(hoTen);
		setDiemLT(diemLT);
		setDiemTH(diemTH);
		
	}

	public DiemSinhVien() {
		maSinhVien = 999999; // tra mac dinh
		hoTen = "Chua xac dinh";
		diemLT = 0;
		diemTH = 0;
	}

	public int getMaSinhVien() {
		return maSinhVien;
	}

	public void setMaSinhVien(int maSinhVien) {
		if (maSinhVien > 0)
			this.maSinhVien = maSinhVien;
		else
			this.maSinhVien = 0;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) throws Exception {
		if (!hoTen.trim().equals(""))
			this.hoTen = hoTen;
		else
			throw new Exception("Loi: Ten khong rong!");
	}

	public double getDiemLT() {
		return diemLT;
	}

	public void setDiemLT(double diemLT) {
		if (diemLT >= 0 && diemLT <= 10)
			this.diemLT = diemLT;
		else
			this.diemLT = 0;
	}

	public double getDiemTH() {
		return diemTH;
	}

	public void setDiemTH(double diemTH) {
		if (diemTH >= 0 && diemTH <= 10)
			this.diemTH = diemTH;
		else
			this.diemTH = 0;
	}

	public double tinhDiemTB() {
		return (this.diemLT + this.diemTH) / 2;
	}
	public String getLayTieuDe() {
		return String.format("%-14s%-21s%-10s%-10s%-10s", "masv", "hoten", "diemlt", "diemth", "diemtb");
	}

	public String toString() {

		return String.format("%-14d%-21s%-10.2f%-10.2f%-10.2f\n", maSinhVien, hoTen, diemLT, diemTH, tinhDiemTB());

	}

}
