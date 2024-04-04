package Module04.bai06Cach2;

import java.util.List;

public class Test {
	public static void main(String[] args) {
		QLDanhSachPH q = new QLDanhSachPH();
		q.them(new PhongThiNghiem("PTNI05", "A", 70, 20, "Hoa Hoc", 45, true));
		q.them(new PhongThiNghiem("PTNK05", "H", 90, 20, "Sinh Hoc", 45, true));
		q.them(new PhongThiNghiem("PTNF05", "I", 100, 20, "Vat Li", 45, false));
		q.them(new PhongLyThuyet("PLTA01", "C", 20, 0, true));
		q.them(new PhongMayTinh("PMTD04", "D", 60, 10, 40));
		q.them(new PhongLyThuyet("PLTA03", "B", 30, 10, true));
		q.them(new PhongLyThuyet("PLTA02", "A", 40, 10, false));
		q.them(new PhongMayTinh("PMTA05", "A", 50, 10, 60));
		q.them(new PhongMayTinh("PMTH04", "F", 20, 10, 0));


		System.out.println("Danh sach sau khi them");
		System.out.println(q.layTieuDe());
		System.out.println(q);

//		System.out.println("Tim phong co so bong den 20");
//		System.out.println(q.timSoBongDen(20));
		
//		System.out.println("Tim phong I05");
//		QLDanhSachPH a = q.timMaPhong("I05");
//		System.out.println(a);
		
		
//		System.out.println("Thong tin phong may tinh");
//		QLDanhSachPH b = q.layDanhSachPhongMayTinh();
//		System.out.println(b);
		
//		System.out.println("Sap Xep Tang Dan Theo Day Nha");
//		List<Phong>  c = q.sapXepTangDanTheoDayNha();
//		for (Phong phong : c) {
//			System.out.println(phong);
//		}
		}
		
	}

