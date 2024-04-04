package CK.DE2GIAODICH;

import java.time.LocalDate;

public class GiaoDichVang extends GiaoDich{
	private String loaiVang;
	private int soLuong;
	private String donVi;
	public GiaoDichVang(String maGD, LocalDate ngayGD, double donGia, String loaiVang, int soLuong, String donVi) {
		super(maGD, ngayGD, donGia);
		this.loaiVang = loaiVang;
		this.soLuong = soLuong;
		this.donVi = donVi;
	}
	public String getLoaiVang() {
		return loaiVang;
	}
	public void setLoaiVang(String loaiVang) {
		this.loaiVang = loaiVang;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public String getDonVi() {
		return donVi;
	}
	public void setDonVi(String donVi) {
		this.donVi = donVi;
	}
	@Override
	public double tinhThanhTien() {
		if(loaiVang.equals("9999")) {
			return soLuong*donGia+0.1*soLuong*donGia;
		} else if(loaiVang.equals("999")){
			return soLuong*donGia+0.05*soLuong*donGia;
 
		} else {
			return soLuong*donGia;
		}
	}
	@Override
	public String toString() {
		return "GiaoDichVang "+super.toString()+", loaiVang=" + loaiVang + ", soLuong=" + soLuong + ", donVi=" + donVi + ", tinhThanhTien()="
				+ tinhThanhTien();
	}
	
	
}
