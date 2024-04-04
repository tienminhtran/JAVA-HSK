package ONGK;

import java.io.Serializable;

public class SinhVien implements Serializable{

	private String maSinhVien;
	private String hoVaTen;
	private String maLop;
	private double diemLyThuyet;
	private double diemThucHang;
	private double diemTrungBinh;
	private String ketQua;
	public SinhVien(String maSinhVien, String hoVaTen, String maLop, double diemLyThuyet, double diemThucHang) {
		super();
		this.maSinhVien = maSinhVien;
		this.hoVaTen = hoVaTen;
		this.maLop = maLop;
		this.diemLyThuyet = diemLyThuyet;
		this.diemThucHang = diemThucHang;
		this.diemTrungBinh = diemTrungBinh;
		this.ketQua = ketQua;
	}
	public String getMaSinhVien() {
		return maSinhVien;
	}
	public void setMaSinhVien(String maSinhVien) {
		this.maSinhVien = maSinhVien;
	}
	public String getHoVaTen() {
		return hoVaTen;
	}
	public void setHoVaTen(String hoVaTen) {
		this.hoVaTen = hoVaTen;
	}
	public String getMaLop() {
		return maLop;
	}
	public void setMaLop(String maLop) {
		this.maLop = maLop;
	}
	public double getDiemLyThuyet() {
		return diemLyThuyet;
	}
	public void setDiemLyThuyet(double diemLyThuyet) {
		this.diemLyThuyet = diemLyThuyet;
	}
	public double getDiemThucHang() {
		return diemThucHang;
	}
	public void setDiemThucHang(double diemThucHang) {
		this.diemThucHang = diemThucHang;
	}
	public double getDiemTrungBinh() {
		return diemTrungBinh;
	}
	public void setDiemTrungBinh(double diemTrungBinh) {
		this.diemTrungBinh = diemTrungBinh;
	}
	public String getKetQua() {
		return daurot();
	}
	public void setKetQua(String ketQua) {
		this.ketQua = ketQua;
	}
	@Override
	public String toString() {
		return "SinhVien [maSinhVien=" + maSinhVien + ", hoVaTen=" + hoVaTen + ", maLop=" + maLop + ", diemLyThuyet="
				+ diemLyThuyet + ", diemThucHang=" + diemThucHang + ", diemTrungBinh=" + diemTrungBinh + ", ketQua="
				+ ketQua + "]";
	}
	
	
	public void diemTB(double diemLyThuyet, double diemThucHang) {
		this.diemTrungBinh = (diemLyThuyet+diemThucHang)/2;
	}
	public double kq() {
		return (diemLyThuyet+diemThucHang)/2;

	}
//	public void diemTB(double diemLyThuyet, double diemThucHang) {
//		// TODO Auto-generated method stub
//		(diemLyThuyet+diemThucHang)/2;
//	}
//	
//	public double kq() {
//	    double dtb = (diemLyThuyet + diemThucHang) / 2;
//	    if (dtb >= 5) {
//	        return dtb;
//	    } else {
//	        return 0;
//	    }
//	}
	public String daurot(){
		return kq()>=5?"Đậu":"Rớt";
	}
	public void kqDau() {
	   if((diemLyThuyet + diemThucHang)/2 >=5) {
		   this.ketQua = "Đậu";
	   }
	   
	}
	public void kqRot() {
		if((diemLyThuyet + diemThucHang)/2 <5) {
			   this.ketQua = "Rớt";
		}  
	}
	
	public SinhVien() {
		super();
	}

	
}
