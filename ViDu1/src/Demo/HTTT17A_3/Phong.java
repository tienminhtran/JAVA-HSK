package Demo.HTTT17A_3;

import java.awt.image.DataBufferByte;
import java.time.format.DateTimeFormatter;

public class Phong {
	private String maPhong;
	private int count;
	private SinhVien[] ds;
	private boolean loaiPhong;

	// count so l hien con
	// int n nhap bao nhieu pt cap phat
	public Phong(String maPhong, int n, boolean loaiPhong) {
		this.maPhong = maPhong;
		this.count = 0;
		ds = new SinhVien[n];
		this.loaiPhong = loaiPhong;
	}

	public String getMaPhong() {
		return maPhong;
	}

	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}

//	public int getCount() {
//		return count;
//	}
//
//	public void setCount(int count) {
//		this.count = count;
//	}

	public SinhVien[] getDs() {
		return ds;
	}

	public void setDs(SinhVien[] ds) {
		this.ds = ds;
	}

	public boolean isLoaiPhong() {
		return loaiPhong;
	}

	public void setLoaiPhong(boolean loaiPhong) {
		this.loaiPhong = loaiPhong;
	}

	public Phong(int n) {
		ds = new SinhVien[n];
		count = 0;
	}

	/**
	 * thêm phần tử vào mảng
	 */
	
	public boolean themSinhVien(SinhVien a) {
		if (count < ds.length && loaiPhong == a.isGioiTinh()) {
			ds[count++] = a;
			return true;
		} else {
			return false;
		}
	}

	public SinhVien timKiemSinhVien(String maSV) {
		for (int i = 0; i < count; i++)
			if (ds[i].getMaSV().compareToIgnoreCase(maSV) == 0) {
				return ds[i];
			}
		return null;
	}

	public void xoaSinhVien(String maTim) throws Exception {
		for (int i = 0; i < count; i++) {
			if (ds[i].getMaSV().compareToIgnoreCase(maTim) == 0) 
			{
				for (int j = i; j < count - 1; j++) 
				{
					ds[j] = ds[j + 1];
				}
				count--;
				return;
			}

		}
		throw new Exception("Khong tim thay ma ");
	}

	public void sapXepTenSinhVien() {
		SinhVien index;
		for (int i = 0; i < count - 1; i++) {
			for (int j = i + 1; j < count; j++) {
				if (ds[i].getTenSV().compareTo(ds[j].getTenSV()) > 0) {
					index = ds[i];
					ds[i] = ds[j];
					ds[j] = index;
				}
			}
		}
	}
	
	public SinhVien timSinhVienTuoiLN() {
		int max = 0;
		// 1999 1930
		for (int i = 0; i < count; i++)
		{
			if(ds[i].getNgaySinh().getYear() < ds[max].getNgaySinh().getYear())
			{
				max = i;
			}
		}
		return ds[max];
	}


	public String thongTin()
	{

				return String.format("Ma Phong: %s\n"
				+ "So giuong: %d\n"
				+ "Loai phong: %s\n"
				+ "So luong hien co: %d\n"
				+ "\n"
				+ "Danh sach sinh vien: ", maPhong,ds.length,loaiPhong==true?"Nam" : "Nu", count);
	}
	public String toString() {
		String s = "";	
		for (int i = 0; i < count; i++) {
			s = s + String.format("%-20d %s", i+1, ds[i]);
		}
		return s;
	}

	
}
