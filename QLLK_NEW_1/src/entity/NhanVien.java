/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;
import java.util.Objects;

/**
 *
 * @author Admin
 */
public class NhanVien {
    private String maNV;
	private String hoTen;
	private String MK;
	private String gioiTinh;
	private String chucVu;
	private String sdt;
	private String diachi;
	

	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getMK() {
		return MK;
	}
	public void setMK(String mK) {
		MK = mK;
	}
	public NhanVien(String maNV, String hoTen, String mK, String gioiTinh, String chucVu, String sdt, String diachi) {
		super();
		this.maNV = maNV;
		this.hoTen = hoTen;
		MK = mK;
		this.gioiTinh = gioiTinh;
		this.chucVu = chucVu;
		this.sdt = sdt;
		this.diachi = diachi;
	}
	public NhanVien(String maNV, String mK) {
		super();
		this.maNV = maNV;
		this.MK = mK;
	}
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getChucVu() {
		return chucVu;
	}
	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maNV);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhanVien other = (NhanVien) obj;
		return Objects.equals(maNV, other.maNV);
	}
	
}
