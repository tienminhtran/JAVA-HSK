package ViDu;

public class SinhVien implements Comparable<SinhVien>{
	private int maSinhVien;
	private String hoVaTen;
	private String tenLop;
	private double diemTrungBinh;
	public SinhVien(int maSinhVien, String hoVaTen, String tenLop, double diemTrungBinh) {
		this.maSinhVien = maSinhVien;
		this.hoVaTen = hoVaTen;
		this.tenLop = tenLop;
		this.diemTrungBinh = diemTrungBinh;
	}
	public int getMaSinhVien() {
		return maSinhVien;
	}
	public void setMaSinhVien(int maSinhVien) {
		this.maSinhVien = maSinhVien;
	}
	public String getTenLop() {
		return tenLop;
	}
	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
	}
	public double getDiemTrungBinh() {
		return diemTrungBinh;
	}
	public void setDiemTrungBinh(double diemTrungBinh) {
		this.diemTrungBinh = diemTrungBinh;
	}
	public String getTen(){
		String s = this.hoVaTen.trim();
		if(s.indexOf(" ") >=0) {
			int vt = s.lastIndexOf(" ");

			return s.substring(vt+1);
		}
		else {
			return s;
		}
	}
	/*
	 * Tran Minh Tien
	 */
	@Override
	public int compareTo(SinhVien o) {
		// TODO Auto-generated method stub
		// so sanh ten: Adam, Nguyen Van A, Tran Thi Thanh Yen 
		
		// so sanh ma sinh vien
		//return this.maSinhVien - o.maSinhVien;
		String tenThis = this.getTen();
		String ten0 = o.getTen();
		
		return tenThis.compareTo(ten0);
	}
	
}
