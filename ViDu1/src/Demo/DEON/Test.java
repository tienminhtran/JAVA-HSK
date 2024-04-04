package Demo.DEON;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Test {
	public static void main(String[] args) {
		try {
			LocalDate ngay = LocalDate.of(2002, 7, 10);
			LocalDate ngay1 = LocalDate.of(2003, 7, 10);
			LocalDate ngay2 = LocalDate.of(1999, 7, 10);

			SinhVien sv = new SinhVien("SV001", "Nguyen An", ngay, true, 3, 7.8);
			SinhVien sv1 = new SinhVien("SV002", "Nguyen Con", ngay2, false, 6, 10);
			SinhVien sv2 = new SinhVien("SV003", "Nguyen Be", ngay1, true, 2, 10);

			SinhVien sv3 = new SinhVien("SV004", "Nguyen Diep", ngay2, false, 3, 7.8);
			SinhVien sv4 = new SinhVien("SV005", "Nguyen Minh ", ngay2, true, 6, 10);
			SinhVien sv5 = new SinhVien("SV006", "Nguyen Za", ngay, false, 2, 9.8);
//			System.out.println(sv);		
//			System.out.println(sv1);
			DanhSachSinhVien dssv = new DanhSachSinhVien("DKKTPM17A", "Cong Nghe Thong Tin");		
			DanhSachSinhVien dssv1 = new DanhSachSinhVien("DKKT", "Kinh Te");

			dssv.themSinhVien(sv);
			dssv.themSinhVien(sv1);
			dssv.themSinhVien(sv2);
			dssv.themSinhVien(sv3);

			dssv1.themSinhVien(sv3);
			dssv1.themSinhVien(sv4);
			dssv1.themSinhVien(sv5);
			
			System.out.println(dssv);
			
			System.out.println(dssv1);

//			System.out.println("Xoa sinh vien ma SV004: ");
//			dssv1.xoaSinhVien("SV004");
//			System.out.println(dssv);
//
//			System.out.println(dssv);
//			System.out.println("Sap xep sinh vien theo ten: ");
//			dssv.sapXepSinhVien();
//			System.out.println(dssv);
//
//			System.out.println("Sap xep sinh vien theo ma: ");
//			dssv.sapXepSinhVienTheoMSSV();
//			System.out.println(dssv);
//
//			SinhVien a = dssv1.timSinhVien("SV006");
//			System.out.println("Tim sinh vien theo ma SV006: \n"+a);

			SinhVien b = dssv.timSinhVienTBL();
			System.out.println("Tim sinh vien TBL: \n"+b);



			
			
//			SinhVien c = dssv.timSinhVienCoTuoiLon();
//			System.out.println("Tim sinh vien Co Tuoi Lon: \n"+c);
//			
//			System.out.println("Dem sinh vien dat diem 10: "+dssv.demSinhVienDat10());
//			System.out.println("Dem sinh vien dat diem 10: "+dssv1.demSinhVienDat10());
//			
//			System.out.println("Dem sinh vien LHP: "+dssv.demSinhVienTheoLop());
//
//			System.out.println("Dem sinh vien nu: "+dssv1.demSinhVienNu());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
