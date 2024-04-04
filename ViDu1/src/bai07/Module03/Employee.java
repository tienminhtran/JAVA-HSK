package bai07.Module03;

public class Employee extends Person {
	private double heSoLuong;

	public Employee(String hoTen, String diaChi, double heSoLuong) {
		super(hoTen, diaChi);
		this.heSoLuong = heSoLuong;
	}

	public Employee() {
		this.heSoLuong = 0;
	}

	public double getHeSoLuong() {
		return heSoLuong;
	}

	public void setHeSoLuong(double heSoLuong) {
		if (heSoLuong >= 0)
			this.heSoLuong = heSoLuong;
		else
			this.heSoLuong = 0;
	}
	/**
	 * 
	 * @return tien luong = he so luong * tien luong mac dinh 3.600.000 do de k noi
	 */
	public double tinhLuong()
	{
		return heSoLuong*3600000;
	}
	public String danhGia()
	{
		if(tinhLuong() >10000000)
			return "Bac 1";
		else
			return "Bac co so";
	}

	@Override
	public String toString() {
		return "Employee ["+super.toString() +"heSoLuong=" + heSoLuong + ", tinhLuong()=" + tinhLuong() + ", danhGia()=" + danhGia()
				+ "]";
	}
	

}
