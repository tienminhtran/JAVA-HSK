package bai06.Module03;

import java.time.LocalDate;
import java.util.Scanner;

import tranMinhTien.bai02.Sach;
/*
 * LAY THONT IN HANG HOA: DS
 * TIM KIEM : HH
 * SAP SEP: DS, HH, LIST
 */
public class Test {

	public static void main(String[] args) {

		LocalDate ngay = LocalDate.of(2022, 10, 11);
		LocalDate ngay1 = LocalDate.of(2022, 10, 21);
		LocalDate ngay2 = LocalDate.of(2022, 10, 23);
		LocalDate ngay3 = LocalDate.of(2021, 12, 5);

		LocalDate ngay4 = LocalDate.of(2023, 12, 11);
		LocalDate ngay5 = LocalDate.of(2023, 12, 21);
		LocalDate ngay6 = LocalDate.of(2022, 10, 22);

		DanhSachHangHoa dshh = new DanhSachHangHoa(100);

		HangThucPham htp1 = new HangThucPham("TP01", "Dau an", 36000, 10, "TP.HCM", ngay, ngay4);
		HangThucPham htp2 = new HangThucPham("TP02", "Nuoc tuong", 26000, 10, "TP.HCM", ngay3, ngay6);
		HangSanhSu hss1 = new HangSanhSu("SS01", "Binh hoa", 15000, 10, "Nhat Ban", ngay1);
		HangSanhSu hss2 = new HangSanhSu("SS02", "Binh su", 12000, 60, "Thai Lan", ngay3);
		HangDienMay hdm1 = new HangDienMay("DM01", "Tu lanh", 3600000, 15, 12, 3.5);
		HangDienMay hdm2 = new HangDienMay("DM02", "May giat", 4600000, 2, 6, 7.5);
		dshh.them(htp1);
		dshh.them(htp2);
		dshh.them(hss1);
		dshh.them(hss2);
		dshh.them(hdm1);
		dshh.them(hdm2);
		System.out.println(dshh.getTieuDe());
		System.out.println(dshh);
		System.out.println(dshh.layThongTinHangThucPham());
//		System.out.println("Lay thong tin hang thuc pham" + "\n" + dshh.layThongTinHangThucPham());
//		System.out.println("Lay thong tin hang thuc pham" + "\n" + dshh.layThongTinHangSanhSu());
//		System.out.println("Lay thong tin hang thuc pham" + "\n" + dshh.layThongTinHangDienMay());
//
//		String k;
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Nhap ma hang hoa: ");
//		k = sc.nextLine();
//		HangHoa[] kq = dshh.timKiemMaHangHoa(k);
//		if (kq.length == 0) {
//			System.out.println("Khong tim thay");
//		} else {
//			System.out.println("Xuat danh sach theo hang hoa: ");
//			for (HangHoa hangHoa : kq) {
//				System.out.println(hangHoa);
//			}
//		}
//
//		System.out.println("\n" + "Sap xep ten hang hoa tang dan");
//		dshh.sapXepTenHangHoaTang();
//		System.out.println(dshh.getTieuDe());
//		System.out.println(dshh);
//		System.out.println("\n" + "Sap xep so luong ton giam");
//		dshh.sapXepSoLuongTonGiam();
//		System.out.println(dshh.getTieuDe());
//		System.out.println(dshh);
//		System.out.println("\n" + "Lay thong tin hang thuc pham" + "\n" + dshh.layThongTinThucPhamKhoBan());
//
//		String ma;
//		sc = new Scanner(System.in);
//		System.out.println("Nhap ma hang hoa: ");
//		ma = sc.nextLine();
//		if (dshh.xoaMaHang(ma))
//			System.out.println("Xoa thanh cong");
//		else
//			System.out.println("Khong tim thay ma xoa");
//		System.out.println(dshh.getTieuDe());
//		System.out.println(dshh);
//
//		String ma1;
//		sc = new Scanner(System.in);
//		System.out.println("Nhap ma hang hoa: ");
//		ma1 = sc.nextLine();
//		double gia;
//		sc = new Scanner(System.in);
//		System.out.println("Gia hang hoa can sua: ");
//		gia = sc.nextDouble();
//		if (dshh.suaThongTin(ma1, gia) == true) {
//			System.out.println("Sua thanh cong");
//			System.out.println(dshh.getTieuDe());
//			System.out.println(dshh);
//		} else
//			System.out.println("Sua khong thanh cong");
//
	}

}