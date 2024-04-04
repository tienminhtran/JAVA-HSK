package bai07.Module03;

public class Customer extends Person {
	private String tenCongTy;
	private double triGiaHoaDon;
	private boolean danhGia;

	public Customer(String hoTen, String diaChi, String tenCongTy, double triGiaHoaDon, boolean danhGia) {
		super(hoTen, diaChi);
		this.tenCongTy = tenCongTy;
		this.triGiaHoaDon = triGiaHoaDon;
		this.danhGia = danhGia;
	}

	public Customer() {
		this.tenCongTy = "XXXXX";
		this.triGiaHoaDon = 1;
		this.danhGia = true;
	}

	public boolean getDanhGia() {
		return danhGia;
	}

	public void setDanhGia(boolean danhGia) {
		if(this.triGiaHoaDon > 4)
			this.danhGia = true;
		else
			this.danhGia = false;
	}

	public String getTenCongTy() {
		return tenCongTy;
	}

	public void setTenCongTy(String tenCongTy) {
		if (!tenCongTy.trim().equals(""))
			this.tenCongTy = tenCongTy;
		else
			this.tenCongTy = "xxxxxx";
	}

	public double getTriGiaHoaDon() {
		return triGiaHoaDon;
	}

	public void setTriGiaHoaDon(double triGiaHoaDon) {
		if (triGiaHoaDon > 0)
			this.triGiaHoaDon = triGiaHoaDon;
		else
			this.triGiaHoaDon = 1;
	}



	@Override
	public String toString() {
		String s = "";
		if(danhGia == true)
		{
			s = s + "KH Vip";
		}
		else
			s = s + "KH thuong";
		return "Customer [" + super.toString() + "tenCongTy=" + tenCongTy + ", triGiaHoaDon=" + triGiaHoaDon
				+ ", danhGia=" + s + "]";
	}

}
