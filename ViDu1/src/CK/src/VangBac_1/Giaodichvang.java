package VangBac_1;

import java.time.LocalDate;

public class Giaodichvang extends GiaoDich {
	// lớp con có extends CHA

	private String loaiVang;
	private int soLuong;
	private double donViTinh;



	public Giaodichvang(String maGiaoDich, LocalDate ngayGiaoDich, double donGia, String loaiVang, int soLuong,
			double donViTinh) {
		super(maGiaoDich, ngayGiaoDich, donGia);
		
		setLoaiVang(loaiVang);
		setDonViTinh(donViTinh);
		setSoLuong(soLuong);
//		this.loaiVang = loaiVang;
//		this.soLuong = soLuong;
//		this.donViTinh = donViTinh;
	}

	public String getLoaiVang() {
		return loaiVang;
	}

	public void setLoaiVang(String loaiVang) { 
		if (loaiVang.equalsIgnoreCase("9999") || loaiVang.equalsIgnoreCase("999") || loaiVang.equals("99"))
			// 9999/999 /99 không rỗng không !....trim.equ..
			this.loaiVang = loaiVang;
		else
			this.loaiVang = "9999";
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		if (soLuong > 0)
			this.soLuong = soLuong;
		else
			this.soLuong = 0;
	}

	public double getDonViTinh() {
		return donViTinh;
	}

	public void setDonViTinh(double donViTinh) {
		if (donViTinh > 0)
			this.donViTinh = donViTinh;
		else
			this.donViTinh = 0;
	}

	@Override
	public double tinhThanhTien() {
		if(loaiVang.equalsIgnoreCase("9999") )
		{
			// lấy công thức có liên quan cha thì super
			return soLuong*super.getDonGia()+0.1*(soLuong*super.getDonGia());
		}
		else if(loaiVang.equalsIgnoreCase("999"))
		{
			return soLuong*super.getDonGia()+0.05*(soLuong*super.getDonGia());

		}
		else
			return soLuong*super.getDonGia();
	}

	@Override
	public String toString() {
		return "Giaodichvang [loaiVang=" + loaiVang + ", soLuong=" + soLuong + ", donViTinh=" + donViTinh
				+ ", toString()=" + super.toString() + "]";
	}


	

}
