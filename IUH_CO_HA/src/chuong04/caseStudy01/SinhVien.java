package chuong04.caseStudy01;

public class SinhVien  {
	private int ma;
	private String ten;
	private int tuoi;
	private String diaChi;

	public int getMa() {
		return ma;
	}

	public void setMa(int ma) {
		this.ma = ma;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public int getTuoi() {
		return tuoi;
	}

	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public SinhVien(int ma, String ten, int tuoi, String diaChi) {
		this.ma = ma;
		this.ten = ten;
		this.tuoi = tuoi;
		this.diaChi = diaChi;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("%5d %15s %10d %15s", ma, ten, tuoi, diaChi);
	}

	

}
