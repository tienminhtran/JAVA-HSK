package Demo.HTTT17A_3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Test {
	public static void main(String[] args) throws Exception {
		try {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate ngay1 = LocalDate.of(2003, 7, 10);
			LocalDate ngay2 = LocalDate.of(2002, 7, 10);

			SinhVien sv = new SinhVien("1111111", "Nguyen C", true, ngay1);
			SinhVien sv1 = new SinhVien("2222222", "Nguyen B", true, ngay2);
			SinhVien sv2 = new SinhVien("3333333", "Nguyen L", false, ngay2);

			Phong p = new Phong("H301", 12, true);
			p.themSinhVien(sv);		
			p.themSinhVien(sv1);
			p.themSinhVien(sv2);	
			System.out.println(p.thongTin());
			System.out.println(sv.layTieuDe());
			System.out.println(p);


			System.out.println("Sinh vien co 2222222 da tim thay: \n"+p.timKiemSinhVien("2222222"));
			
			System.out.println("Sap xep sinh vien theo ten: ");
			System.out.println(sv.layTieuDe());
			p.sapXepTenSinhVien();
			System.out.println(p);
			
			System.out.println("Sinh vien tuoi lon: \n"+p.timSinhVienTuoiLN()); 
//			p.timSinhVienTuoiLN();
//			System.out.println(p);

			
			System.out.println("Xoa sinh vien theo ma 1111111: ");
			System.out.println(sv.layTieuDe());
			p.xoaSinhVien("1111111");
			System.out.println(p);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
