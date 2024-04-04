package test;

import java.util.Scanner;

import main.DanhSachSinhVien;
import main.SinhVien;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DanhSachSinhVien dssv = new DanhSachSinhVien(); // sài contructer rỗng
		int luaChon = 0;
		do {
			System.out.println(".....................MENU.....................");
			System.out.println("Moi ban nhap chuc nang: ");
			System.out.println("" + "1.	Them sinh vien vao danh sach\n" + "2.	In danh sach sinh vien ra man hinh \n"
					+ "3.	Kiem tra danh sach co rong hay khong \n"
					+ "4.	Lay ra so luong sinh vien trong danh sach \n" + "5.	Lam rong danh sach sinh vien \r\n"
					+ "6.	Kiem tra sinh vien co ton tai trong danh sach hay khong dua tren ma sinh vien\r\n"
					+ "7.	Xoa mot sinh vien ra khoi danh sach dua tren ma sinh vien\n"
					+ "8.	Tim kiem tat ca sinh vien dua tren Ten duoc nhap tu ban phim\n"
					+ "9.	Xuat ra danh sach sinh vien co diem tu cao den thap\n" + "0.   Thoat khoi chuong trinh\n");
			luaChon = sc.nextInt();
			sc.nextLine();
			if (luaChon == 1) {
				System.out.println("Nhap ma sinh vien: "); String maSinhVien = sc.nextLine();
				System.out.println("Nhap ho va ten: "); String hoVaTen = sc.nextLine();
				System.out.println("Nhap nam sinh: "); int namSinh = sc.nextInt();
				System.out.println("Nhap diem trung binh: "); float diemTrungBinh = sc.nextFloat();
				SinhVien sv = new SinhVien(maSinhVien, hoVaTen, namSinh, diemTrungBinh);
				dssv.themSinhVien(sv);

			} else if (luaChon == 2) {
				dssv.inDanhSachSinhVien();

			} else if (luaChon == 3) {
				System.out.println("Danh sach rong: "+ dssv.kiemTraDanhSachRong());

			} else if (luaChon == 4) {
				System.out.println("So luong sinh vien: "+ dssv.laySoLuongSinhVien());

			} else if (luaChon == 5) {
				dssv.lamRongDanhSach();
			} else if (luaChon == 6) {
				System.out.println("Nhap ma sinh vien: "); String maSinhVien = sc.nextLine();
				SinhVien sv = new SinhVien(maSinhVien); // bên SinhVien.java đã có contructor rỗng 
						/*
						 * 	public SinhVien(String maSinhVien) {
							this.maSinhVien = maSinhVien;
							}// áp dụng câu 6
						 */
				System.out.println("Kiem tra sinh vien ton tai: "+dssv.kiemTraSinhVienTonTai(sv));
			} else if (luaChon == 7) {
				System.out.println("Nhap ma sinh vien: "); String maSinhVien = sc.nextLine();
				SinhVien sv = new SinhVien(maSinhVien); // bên SinhVien.java đã có contructor rỗng 
						/*
						 * 	public SinhVien(String maSinhVien) {
							this.maSinhVien = maSinhVien;
							}// áp dụng câu 6
						 */
				System.out.println("Xoa sinh ds: "+dssv.xoaSinhVien(sv));
			} else if (luaChon == 8) {
				System.out.println("Nhap ho va ten: "); String hoVaTen = sc.nextLine();
				System.out.println("Ket quan tim kiem: ");
				dssv.timKiemTenSinhVien(hoVaTen);
			} else if (luaChon == 9) {
				dssv.sapXepDanhSach();
				dssv.inDanhSachSinhVien();
			}

		} while (luaChon != 0);
	}
}
