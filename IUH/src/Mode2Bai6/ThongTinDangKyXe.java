package Mode2Bai6;

public class ThongTinDangKyXe {
	private String tenChuXe;
	private String loaiXe;
	private double triGiaXe;
	private double dungTichXyLanh;

	public ThongTinDangKyXe(String tenChuXe, String loaiXe, double triGiaXe, double dungTichXyLanh) {
		this.tenChuXe = tenChuXe;
		this.loaiXe = loaiXe;
		this.triGiaXe = triGiaXe;
		this.dungTichXyLanh = dungTichXyLanh;
	}

	public ThongTinDangKyXe() {
		this.tenChuXe = null;
		this.loaiXe = null;
		this.triGiaXe = 0;
		this.dungTichXyLanh = 0;
	}

	public String getTenChuXe() {
		return tenChuXe;
	}

	public void setTenChuXe(String tenChuXe) {
		this.tenChuXe = tenChuXe;
	}

	public String getLoaiXe() {
		return loaiXe;
	}

	public void setLoaiXe(String loaiXe) {
		this.loaiXe = loaiXe;
	}

	public double getTriGiaXe() {
		return triGiaXe;
	}

	public void setTriGiaXe(double triGiaXe) throws Exception{
		if (triGiaXe >= 0) 
			this.triGiaXe = triGiaXe;
		else
			throw new Exception("Loi: Nhap tri gia xe phai >=0");		
	}

	public double getDungTichXyLanh() {
		return dungTichXyLanh;
	}

	public void setDungTichXyLanh(double dungTichXyLanh) throws Exception{
		if(dungTichXyLanh >= 0)
			this.dungTichXyLanh = dungTichXyLanh;
		else
			throw new Exception("Loi: Dung Tich Xy Lanh phai >=0");		

	}
	public double tinhThuePhaiNop() {
		if(this.dungTichXyLanh < 100)
			return this.triGiaXe * 1/100;
		else if(this.dungTichXyLanh >= 100 && this.dungTichXyLanh <= 200)
			return this.triGiaXe * 3/100;
		else
			return this.triGiaXe * 5/100;
	}

	@Override
	public String toString() {
		return String.format("%-20s%-15s%-15.2f%-15.2f%-15.2f\n", tenChuXe, loaiXe, dungTichXyLanh, triGiaXe, tinhThuePhaiNop());
	}

	
}
