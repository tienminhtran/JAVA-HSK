package bai11.Module02;

import java.time.LocalDate;

public class KhachHang {
	private String maKH;
	private String hoTenKH;
	private SoTietKiem[] dsSoTietKiem;
	private int soLuongSoHienCo;
	


	public KhachHang(String maKH, String hoTenKH, int n) {
		this.maKH = maKH;
		this.hoTenKH = hoTenKH;
		dsSoTietKiem = new SoTietKiem[n];
		this.soLuongSoHienCo = 0;// count
	}

	public String getMaKH() {
		return maKH;
	}


	public String getHoTenKH() {
		return hoTenKH;
	}

	public void setHoTenKH(String hoTenKH) {
		this.hoTenKH = hoTenKH;
	}

	public SoTietKiem[] getDsSoTietKiem() {
		return dsSoTietKiem;
	}

	
	public int getSoLuongSoHienCo() {
		return soLuongSoHienCo;
	}

	

	/**
	 * thêm so tiet kiem
	 */

//	public void AddCDList(SoTietKiem a) throws Exception {
//		if (soLuongSoHienCo < dsSoTietKiem.length)
//			dsSoTietKiem[soLuongSoHienCo++] = a;
//		else {
//			throw new Exception("Vượt quá kích thước mảng");
//		}
//	}
	public boolean themSoTietKiem(String maSo, LocalDate ngayMoSo, double soTienGoi, int kyHan, double laiSuat)
	{
		if(soLuongSoHienCo < dsSoTietKiem.length)
		{
			dsSoTietKiem[soLuongSoHienCo++] = new SoTietKiem(maSo, ngayMoSo, soTienGoi, kyHan, laiSuat);
			return true;
		}
		return false;
	}

	public int getLength() {
		return soLuongSoHienCo;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i < soLuongSoHienCo; i++) {
			s = s + dsSoTietKiem[i];
		}

		return s;
	}
	public String layTieuDe() {
		return String.format("|%-5s|%-15s|%-15s|%-10s|%-18s|%-15s|%-15s|%-15s|",
				"STK", "Ngay Goi", "Ngay rut","Ky han","So th tinh lai","Lai Suat","So Tien Goi", "Tien Lai");
	}

}
