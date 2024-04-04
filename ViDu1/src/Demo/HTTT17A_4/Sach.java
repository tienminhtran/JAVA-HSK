package Demo.HTTT17A_4;

import java.text.DecimalFormat;

public class Sach {
	private String maNguoiMuon;
	private String hoTen;
	private String tenSach;
	private String theLoai;
	private int soNgayMuon;

	public Sach(String maNguoiMuon, String hoTen, String tenSach, String theLoai, int soNgayMuon) {
		setMaNguoiMuon(maNguoiMuon);
		setHoTen(hoTen);
		setTenSach(tenSach);
		setTheLoai(theLoai);
		setSoNgayMuon(soNgayMuon);
	}

	public String getMaNguoiMuon() {
		return maNguoiMuon;
	}

	public void setMaNguoiMuon(String maNguoiMuon) {
		if (maNguoiMuon.indexOf("Th", 0) == 0 && maNguoiMuon.length() == 3)
			this.maNguoiMuon = maNguoiMuon;
		else
			this.maNguoiMuon = "ThX";
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		if (!hoTen.trim().equals(""))
			this.hoTen = hoTen;
		else
			this.hoTen = "Chua xac dinh";
	}

	public String getTenSach() {
		return tenSach;
	}

	public void setTenSach(String tenSach) {
		if (!tenSach.trim().equals(""))
			this.tenSach = tenSach;
		else
			this.tenSach = "Chua xac dinh";
	}

	public String getTheLoai() {
		return theLoai;
	}

	public void setTheLoai(String theLoai) {
//		if (theLoai.indexOf("TR", 0) == 0 || theLoai.indexOf("KN", 0) == 0)
		if(theLoai == "TR" || theLoai == "KN")
			this.theLoai = theLoai;
		else
			this.theLoai = "XX";
	}

	public int getSoNgayMuon() {
		return soNgayMuon;
	}

	public void setSoNgayMuon(int soNgayMuon) {
		if (soNgayMuon >= 1 && soNgayMuon <= 90)
			this.soNgayMuon = soNgayMuon;
		else
			this.soNgayMuon = 0;
	}
	
	public double tinhTienThueSach()
	{
		if(soNgayMuon <=7)
		{
			return soNgayMuon*2000;
		}
		else
		{
			return 7*2000 + (soNgayMuon-7)*1000;
		}
	}

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,##0VND");
		return "\nSach [maNguoiMuon=" + maNguoiMuon + ", hoTen=" + hoTen + ", tenSach=" + tenSach + ", theLoai=" + theLoai
				+ ", soNgayMuon=" + soNgayMuon + ", tinhTienThueSach()=" + df.format(tinhTienThueSach()) + "]";
	}

	
	

}
