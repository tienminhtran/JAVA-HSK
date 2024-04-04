package Demo.gk_TaiKhoan;

public class KhachHang {
	private String hoTen;
	private  DiaChi diaChi;
	private boolean phaiNam;
	public KhachHang(String hoTen, DiaChi diaChi, boolean phaiNam) {
		setHoTen(hoTen);
		this.diaChi = diaChi;
		this.phaiNam = phaiNam;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		if(!hoTen.trim().equals(""))
		this.hoTen = hoTen;
		else
			this.hoTen = "xxx";
	}
	public DiaChi getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(DiaChi diaChi) {
		this.diaChi = diaChi;
	}
	public boolean isPhaiNam() {
		return phaiNam;
	}
	public void setPhaiNam(boolean phaiNam) {
			this.phaiNam = phaiNam;
	}
	public String toString()
	{
		String s="";
		if(isPhaiNam() == true)
		{
			s = "Mr";
		}
		else
		{
			s = "Mrs";
		}
		return String.format("%s. %s %s", s, hoTen,diaChi.toString());
	}
}
