package entity;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.Date;
import java.util.List;
import java.util.Objects;

import dao.SanPhamDao;
/**
 *
 * @author Admin
 */
public class SanPham {
    private String maLK;
	private String tenLK;
	private String moTaLK;
	private double donGia;
	private String loaiLK;
	private String thuongHieu;
	private int soLuongTon;
	private Date ngayNhap;
	private String baoHanh;
   
	public SanPham(String maLK, String tenLK, String moTaLK, double donGia, String loaiLK, String thuongHieu,
			int soLuongTon, Date ngayNhap, String baoHanh) {
		this.maLK = maLK;
		this.tenLK = tenLK;
		this.moTaLK = moTaLK;
		this.donGia = donGia;
		this.loaiLK = loaiLK;
		this.thuongHieu = thuongHieu;
		this.soLuongTon = soLuongTon;
		this.ngayNhap = ngayNhap;
		this.baoHanh = baoHanh;
	}
	public SanPham( String maLK, String tenLK, String moTaLK, double donGia, String loaiLK, String thuongHieu,
			int soLuongTon, String baoHanh) {
		this.tenLK = tenLK;
		this.moTaLK = moTaLK;
		this.donGia = donGia;
		this.loaiLK = loaiLK;
		this.thuongHieu = thuongHieu;
		this.soLuongTon = soLuongTon;
		this.baoHanh = baoHanh;
	}
	public SanPham( String tenLK, String moTaLK, double donGia, String loaiLK, String thuongHieu,
			int soLuongTon, String baoHanh) {
		this.tenLK = tenLK;
		this.moTaLK = moTaLK;
		this.donGia = donGia;
		this.loaiLK = loaiLK;
		this.thuongHieu = thuongHieu;
		this.soLuongTon = soLuongTon;
		this.baoHanh = baoHanh;
	}
	public SanPham( String maLK) {
		this.maLK = maLK;

	}
	public String getMaLK() {
		return maLK;
	}
	public void setMaLK(String maLK) {
		this.maLK = maLK;
	}
	public String getTenLK() {
		return tenLK;
	}
	public void setTenLK(String tenLK) {
		this.tenLK = tenLK;
	}
	public String getMoTaLK() {
		return moTaLK;
	}
	public void setMoTaLK(String moTaLK) {
		this.moTaLK = moTaLK;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	public String getLoaiLK() {
		return loaiLK;
	}
	public void setLoaiLK(String loaiLK) {
		this.loaiLK = loaiLK;
	}
	public String getThuongHieu() {
		return thuongHieu;
	}
	public void setThuongHieu(String thuongHieu) {
		this.thuongHieu = thuongHieu;
	}
	public int getSoLuongTon() {
		return soLuongTon;
	}
	public void setSoLuongTon(int soLuongTon) {
		this.soLuongTon = soLuongTon;
	}
	public Date getNgayNhap() {
		return ngayNhap;
	}
	public void setNgayNhap(Date ngayNhap) {
		this.ngayNhap = ngayNhap;
	}
	public String getBaoHanh() {
		return baoHanh;
	}
	public void setBaoHanh(String baoHanh) {
		this.baoHanh = baoHanh;
	}

	//2022-12-1
//	@Override
//	public int hashCode() {
//		return Objects.hash(loaiLK, thuongHieu);
//	}
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		SanPham other = (SanPham) obj;
//		return Objects.equals(loaiLK, other.loaiLK) && Objects.equals(thuongHieu, other.thuongHieu);
//	}
}
