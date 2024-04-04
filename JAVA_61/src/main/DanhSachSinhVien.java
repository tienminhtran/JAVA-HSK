package main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class DanhSachSinhVien {
	private ArrayList<SinhVien> danhSach;

	public DanhSachSinhVien() {
		// khai báo Arrylist
		this.danhSach = new ArrayList<SinhVien>();
	}

	public DanhSachSinhVien(ArrayList<SinhVien> danhSach) {
		this.danhSach = danhSach;
	}

	/////////////////////// Thêm
	public void themSinhVien(SinhVien sv) {
		this.danhSach.add(sv); // add( ) chèn sinh vien cuối
		// có thể sử dụng add(x , ) vào vị trí x
	}

	//////////////////////// IN DANH SÁCH
	public void inDanhSachSinhVien() {
		for (SinhVien sinhVien : danhSach) {
			System.out.println(sinhVien);
		}
	}

	////////////////////// DANH SÁCH RỖNG HAY KHÔNG
	public boolean kiemTraDanhSachRong() {
		return this.danhSach.isEmpty();
		// isEmpty kiểm tra ds rỗng k
	}

	//////////// Lấy ra số lượng sinh viên trong danh sách.
	public int laySoLuongSinhVien() {
		return this.danhSach.size();
	}

	///////////// Làm rỗng danh sách sinh viên. XOÁ TOÀN BỘ
	public void lamRongDanhSach() {
		this.danhSach.removeAll(danhSach);
	}

	////////////// KIỂM TRA SINH VIEN TỒN TẠI KHÔNG
	public boolean kiemTraSinhVienTonTai(SinhVien sv) {
		return this.danhSach.contains(sv);
	}

	/////////////// XOÁ MỘT SINH VIÊN
	public boolean xoaSinhVien(SinhVien sv) {
		return this.danhSach.remove(sv);
	}

	//////////////// TÌM KIẾM TÊN SINH VIÊN
	public void timKiemTenSinhVien(String ten) {
		for (SinhVien sinhVien : danhSach) {
			if (sinhVien.getHoVaTen().indexOf(ten) >= 0) {
				System.out.println(sinhVien);
			}
		}
	}

	////////////////// XUẤT DANH SÁCH SV CÓ ĐIỂM TỪ TRÊN XUỐNG
	public void sapXepDanhSach() {
		Collections.sort(this.danhSach, new Comparator<SinhVien>() {

			@Override
			public int compare(SinhVien sv1, SinhVien sv2) {
				// TODO Auto-generated method stub
				if (sv1.getDiemTrungBinh() < sv2.getDiemTrungBinh()) {
					return 1;
				} else if (sv1.getDiemTrungBinh() > sv2.getDiemTrungBinh()) {
					return -1;
				} else {
					return 0;
				}
			}

		});
	}
}
