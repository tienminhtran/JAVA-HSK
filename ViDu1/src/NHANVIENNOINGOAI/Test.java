package NHANVIENNOINGOAI;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class Test {
	public static void main(String[] args) {
		DecimalFormat df = new DecimalFormat("#,##0");
		NhanVienNoi a1 = new NhanVienNoi("NVN001", "N V A", LocalDate.of(1976, 6, 12), "HCM", 10, 35000, true);
		NhanVienNoi a2 = new NhanVienNoi("NVN003", "N V C", LocalDate.of(2000, 6, 12), "HCM", 30, 31000, true);
		NhanVienNoi a3 = new NhanVienNoi("NVN002", "B V A", LocalDate.of(1972, 6, 12), "HCM", 11, 32000, false);

		NhanVienNgoai b3 = new NhanVienNgoai("NGOAI003", "L N", LocalDate.of(1987, 2, 12), "HCM", 22, 34000, 0.5);
		NhanVienNgoai b1 = new NhanVienNgoai("NGOAI001", "L T T", LocalDate.of(1987, 2, 12), "HCM", 22, 34000, 0.5);
		NhanVienNgoai b2 = new NhanVienNgoai("NGOAI002", "L T A", LocalDate.of(2000, 3, 12), "HCM", 4, 32000, 0.15);

		DSNhanVien ds = new DSNhanVien();
		ds.themNV(a1);
		ds.themNV(a2);
		ds.themNV(a3);
		ds.themNV(b1);
		ds.themNV(b2);
		ds.themNV(b3);
		System.out.println(ds);

//		System.out.println("SL NHAN VIEN: " +ds.getSoLuong());
//		System.out.println("Tien an: " +df.format(ds.tinhTienAn()));

//		ds. sapXepTangDanTheoTen();
//		System.out.println(ds);
//		System.out.println(ds.layThongTinNVNoi());
//		
//		System.out.println(ds.tinhTienAnTrungBinhNVNoi());

//		System.out.println("sapXepGiamTheoGiaSuatAn");
//		ds.sapXepGiamTheoGiaSuatAn();
//		System.out.println(ds);

//		System.out.println("Tim ma nhan vien");
//		System.out.println(ds.timMaNV("NGOAI001"));

//		System.out.println("TIM DS NHAN VIÊN CÓ SUẤT ĂN CN");
//		System.out.println(ds.timKiemDSCoSuatAnCN());

//		System.out.println("layDanhSachNVCoSuatAnLon20");
//		System.out.println(ds.layDanhSachNVCoSuatAnLon20());

//		System.out.println("layDanhSachNVSN2000: "+"\n" +ds.layDanhSachNVSN2000());

//		System.out.println("capNhapSoXuatAnNVTheoMa");
//		ds.capNhapSoXuatAnNVTheoMa("NVN002", 300);
//		System.out.println(ds);

//		System.out.println("capNhatDiaChiNhanVienNgoai");
//		System.out.println(ds.capNhatDiaChiNhanVienNgoai("NGOAI002", "TIEN GIANG"));
//		System.out.println(ds);

//		System.out.println(" xoaNhanVienTheoMa");
//		System.out.println(ds.xoaNhanVienTheoMa("NGOAI003"));
//		System.out.println(ds);
		
		System.out.println("xoaNhanVienCoSuatAn10");
		System.out.println(ds.xoaNhanVienCoSuatAn10());
		System.out.println(ds);
	}
}
