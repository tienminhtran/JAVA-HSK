package Module04.bai06Cach1;

import java.util.List;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		QLDanhSachPH q = new QLDanhSachPH();
		q.them(new PhongLyThuyet("A03", "C", 20, 0, true));
		q.them(new PhongLyThuyet("B03", "B", 30, 10, true));
		q.them(new PhongLyThuyet("C03", "A", 40, 10, false));
		q.them(new PhongMayTinh("E04", "A", 50, 10, 60));
		q.them(new PhongMayTinh("D04", "D", 60, 10, 40));
		q.them(new PhongMayTinh("H04", "F", 20, 10, 0));
		q.them(new PhongThiNghiem("I05", "G", 70, 20, "Hoa Hoc", 45, true));
		q.them(new PhongThiNghiem("K05", "H", 90, 20, "Sinh Hoc", 45, true));
		q.them(new PhongThiNghiem("F05", "I", 100, 20, "Vat Li", 45, false));

		System.out.println("Danh sach sau khi them");
		System.out.println(q.layTieuDe());
		System.out.println(q);
//		System.out.println("Tim kiem phong D04 (khong trung): ");
//		Phong kq = q.timKiemPhong("D04");
//		if(kq!=null) {
//			System.out.println("Tim thay");
//			System.out.println(kq);
//		} else {
//			System.out.println("Khong tim thay");
//		}

//		System.out.println("Tim kiem day phong (duoc trung) ");
//		System.out.println(q.timDayNha("A"));

//		q.sapXepDsTangTheoDayNha();
//		System.out.println("Danh sach tang");
//		System.out.println(q);
//		
//		q.sapXepDsGiamTheoDienTich();
//		System.out.println("Danh sach giam");
//		System.out.println(q);
		
		System.out.println("sap xep theo dien tich sai DS: ");
		q.sapXepDsTangTheoDienTichKieuDS();
		System.out.println(q);
		
		
		
//		List<Phong> a = q.sapXepDayNha();
//		for (Phong phong : a) {
//			System.out.println(phong);
//		}
//		
		
//		q.capNhatSoMayTinh("H04", 65);
//		System.out.println(q);

//		Scanner sc = new Scanner(System.in);
//		int cn;
//		System.out.println("Thuc hien chuc nang xoa chon phim 1 de xoa: ");
//		cn = sc.nextInt();
//		if(cn==1)
//		{
//			System.out.println("Xoa phong E04");
//			q.xoaMaPhong("E04");
//			System.out.println(q);
//		} else
//		{
//			System.out.println("Khong thuc hien ");
//		}
		

//		
		QLDanhSachPH ql = q.dsPhongDatChuan();

		System.out.println("Danh sach dat tieu chuan");
		System.out.println(ql);
//	
//		List<Phong> b = q.layPhongDatChuan();
//		for (Phong phong : b) {
//			System.out.println(phong);
//		}
		
	}
}
