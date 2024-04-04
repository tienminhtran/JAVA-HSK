package bai04.Module03;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {

		DecimalFormat df = new DecimalFormat("#,##0");
		LocalDate ngay = LocalDate.of(2022, 10, 11);
		LocalDate ngay1 = LocalDate.of(2022, 9, 21);
		LocalDate ngay2 = LocalDate.of(2022, 7, 23);
		LocalDate ngay3 = LocalDate.of(2022, 6, 5);

		SachGiaoKhoa s = new SachGiaoKhoa("A01", ngay, 1000, 2, "Ha Noi", false);
		SachGiaoKhoa s1 = new SachGiaoKhoa("A02", ngay1, 2000, 4, "Da Nang", true);
		SachGiaoKhoa s2 = new SachGiaoKhoa("A03", ngay2, 4000, 5, "Ha Noi", true);
		SachThamKhao s3 = new SachThamKhao("A04", ngay1, 1000, 2, "Nhi Dong", 4);
		SachThamKhao s4 = new SachThamKhao("A05", ngay3, 1200, 4, "Ha Noi", 3);
		SachThamKhao s5 = new SachThamKhao("A06", ngay2, 3000, 5, "Ha Noi", 2);

		DanhSachSach ds = new DanhSachSach(100);
		ds.them(s);
		ds.them(s1);
		ds.them(s2);
		ds.them(s3);
		ds.them(s4);
		ds.them(s5);
		System.out.println(ds);
//		xuatDanhSach(s);
		System.out.println("Tong thanh tien sach giao khoa: " + df.format(ds.tinhTongThanhTienSGK()));
		System.out.println("Tong thanh tien sach tham khao: " + df.format(ds.tinhTongThanhTienSTK()));

		String k;
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap ten nha xb: ");
		k = sc.nextLine();

//		Sach[] kq = ds.xuatSachGiaoKhoa(k);
//		if (kq[0] == null) {
//			System.out.println("Khong tim thay");
//		} else {		
//			System.out.println("Xuat danh sach theo nxb: ");
//			for (Sach sach : kq) {
//				if (sach != null)
//					System.out.println(sach);
//			}
//		}
		Sach[] kq = ds.xuatSachGiaoKhoa(k);
		if (kq.length==0) {
			System.out.println("Khong tim thay");
		} else {		
			System.out.println("Xuat danh sach theo nxb: ");
			for (Sach sach : kq) {
					System.out.println(sach);
			}
		}


		 System.out.println("Thanh tien cao nhat: " +df.format(ds.tinhThanhTienCaoNhat()));

	}

}
