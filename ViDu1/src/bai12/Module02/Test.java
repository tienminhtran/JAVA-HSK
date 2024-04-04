package bai12.Module02;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		try {
			CD p = new CD(1, "Hoa Hai Duong", 2, 35000);
			CD p1 = new CD(3, "Song Gio", 3, 23000);
			CD p2 = new CD(2, "Em gi oi", 4, 32000);

			CDList cdl = new CDList(10);
			cdl.AddCDList(p);
			cdl.AddCDList(p1);
			cdl.AddCDList(p2);
			System.out.println("|-----------------Menu------------------|\n"
					+ "|1.Tinh so luong CD trong danh sach     |\n" + "|2.Xoa CD theo ma                       |\n"
					+ "|3.Tinh tong gia thanh cua cac CD       |\n" + "|4.Tim kiem theo ma CD                  |\n"
					+ "|5.Sap xep danh sach giam dan cua gia   |\n" + "|6.Sap xep danh sach tang dan theo tua  |\n"
					+ "|7.Thoat!                               |\n" + "|-------------Moi ban chon--------------|\n");
			int chon;
			do {
				System.out.println("Chon 1-6 thuc hien chuc nang, nhap 7 de thoat!");
				Scanner sc = new Scanner(System.in);
				chon = sc.nextInt();
				switch (chon) {
				case 1:
					System.out.println("Thuc hien chuc nang tinh sl CD trong danh sach:");
					System.out.println(p.layTieuDe());
					System.out.println(cdl.toString());
					System.out.println("So luong cd: " + cdl.getLength());
					break;
				case 2:
					System.out.println("Thuc hien chuc nang xoa theo ma:");
					System.out.println("Nhap ma can xoa: ");
					int ma = sc.nextInt();
					cdl.xoaMaCD(ma);
					System.out.println(p.layTieuDe());
					System.out.println(cdl.toString());
					break;
				case 3:
					System.out.println("Tinh tong thanh tien:" + cdl.tinhTongThanhTien());
					break;
				case 4:
					System.out.println("Thuc hien chuc nang tim kiem theo ma:");
					System.out.println("Nhap ma can tim kiem: ");
					int matim = sc.nextInt();
					cdl.timKiemMaCD(matim);
					System.out.println("Tim kiem ma CD (" + matim + "): " + cdl.timKiemMaCD(matim));
					break;
				case 5:
					System.out.println("Thuc hien chuc nang sap xep danh sach giam dan cua gia:");
					cdl.sapXepGiamGiaThanh();
					System.out.println(cdl.toString());
					break;
				case 6:
					System.out.println("Thuc hien chuc nang sap xep danh sach tang dan theo tua");
					cdl.sapXepTangTuaPhim();
					System.out.println(cdl.toString());
					break;
				default:
					System.out.println("Thoat chuong trinh");
					break;
				}

			} while (chon != 7);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
