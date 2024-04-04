package bai13.Module02;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		try {
			CongNhan cn1 = new CongNhan("Tran", "Tien", 300);
			CongNhan cn2 = new CongNhan("Nguyen", "Tai", 349);
			CongNhan cn3 = new CongNhan("Phan", "Sinh", 30);
			CongNhan cn4 = new CongNhan("Nguyen", "An", 250);
			CongNhan cn5 = new CongNhan("Kha", "Banh", 50);

			DanhSachCongNhan dscn = new DanhSachCongNhan(5);
			dscn.themDanhSach(cn1);
			dscn.themDanhSach(cn2);
			dscn.themDanhSach(cn3);
			dscn.themDanhSach(cn4);
			dscn.themDanhSach(cn5);

			System.out.println("|-----------------Menu------------------|\n"
					+ "|1.Tinh so luong CN trong danh sach     |\n" + "|2.Xoa CN theo ma                       |\n"
					+ "|3.Lay danh sach cong nhan co sp >200   |\n" + "|4.Sap xep danh sach giam dan cua sp    |\n"
					+ "|5.Thoat!                               |\n" + "|-------------Moi ban chon--------------|\n");
			int chon;
			do {
				System.out.println("Chon 1-4 thuc hien chuc nang, nhap 5 de thoat!");
				Scanner sc = new Scanner(System.in);
				chon = sc.nextInt();
				switch (chon) {
				case 1:
					System.out.println("Thuc hien chuc nang tinh sl CN trong danh sach:");
					System.out.println(dscn.inTieuDe());
					System.out.println(dscn.xuatThongTinCN());
					System.out.println("So luong cong nhan: " + dscn.getLength());
					break;
				case 2:
					System.out.println("Thuc hien chuc nang xoa theo ma (mHo, Mten):");
					sc = new Scanner(System.in);
					System.out.println("Nhap ma mHo can xoa: ");
					String mHo = sc.nextLine();
					System.out.println("Nhap ma mTen can xoa: ");
					String mTen = sc.nextLine();
					dscn.xoaCongNhan(mHo, mTen);
					System.out.println(dscn.inTieuDe());
					System.out.println(dscn.xuatThongTinCN());
					break;
				case 3:
					System.out.println("Thuc hien chuc nang lay danh sach cong nhan co SP > 200:");
					System.out.println(dscn.inTieuDe());
					System.out.println(dscn.layDanhSachCN());
					break;
				case 4:
					System.out.println("Thuc hien chuc nang sap xep danh sach cong nhan co SP giam") ;
					dscn.sapXepGiamSP();
					System.out.println(dscn.inTieuDe());
					System.out.println(dscn.xuatThongTinCN());
					break;
				default:
					System.out.println("Thoat chuong trinh");
					break;
				}

			} while (chon != 5);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
