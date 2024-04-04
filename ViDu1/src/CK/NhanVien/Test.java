package CK.NhanVien;

import java.util.List;


public class Test {
	public static void main(String[] args) {
		GiangVien gv = new GiangVien("GV01", 2.5, 2.9,TrinhDo.CN, 45);
		GiangVien gv1 = new GiangVien("GV02", 3.5, 2.7, TrinhDo.TS, 45);

		NhanVienHanhChinh nvhc = new NhanVienHanhChinh("NVHC01", 3, 3, 3);
		NhanVienHanhChinh nvhc1 = new NhanVienHanhChinh("NVHC02", 3, 3, 2);
		
		QuanLyNhanVien qlnv = new QuanLyNhanVien();
		qlnv.themNhanVien(gv);
		qlnv.themNhanVien(gv1);
		qlnv.themNhanVien(nvhc);
		qlnv.themNhanVien(nvhc1);
		
		System.out.println(qlnv);
		
//		System.out.println("xoaNhanVien");
//		System.out.println(qlnv.xoaNhanVien("NVHC02"));
//		System.out.println(qlnv);
//		
//		List<NhanVien> kq = qlnv.sapXepMaGiam();
//		for (NhanVien nhanVien : kq) {
//			System.out.println(nhanVien);
//		}
//		
//		System.out.println("layThongTinTienSi");
//		System.out.println(qlnv.layThongTinTienSi());
		
		System.out.println(qlnv.phuCapLonNhat());
		
	}
}
