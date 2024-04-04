package deQuyenTHITHUCHANH;


import java.time.LocalDate;

public class Test {
	public static void main(String[] args) {
		DanhSachNhanVien ds = new DanhSachNhanVien();
		NhanVienNgoai nvgNgoai = new NhanVienNgoai("11A", "Phat", LocalDate.of(2003, 1, 1), "ABC", 500, 600, 700);
		ds.themNV(nvgNgoai);
		ds.themNV(new NhanVienNoi("2B", "Tai", LocalDate.of(1995, 2, 3), "DEF", 200, 210, true));
		ds.themNV(new NhanVienNoi("2BC", "Sinh", LocalDate.of(2002, 2, 3), "HHH", 300, 210, false));
		System.out.println(ds.getTieuDe());
		System.out.println(ds);
		System.out.println(ds.xoaNV("2BC"));
		System.out.println("Danh sach sau khi xoa");
		System.out.println(ds);
		boolean k = ds.sua("2B", "TienChoDien");
		 if(!k)
		 {
			 System.out.println("Khong tim thay");
		 }
		 else {
			 System.out.println("Sau khi sua");
				System.out.println(ds);
		}
	}
//	boolean k = ds.sua(3, "Nguyen Van A", 1990);
//	if (!k)
//		System.out.println("khong co ma can sua");
//	else {
//		System.out.println("Sau khi sua");
//		System.out.println(ds);
//	}

}
