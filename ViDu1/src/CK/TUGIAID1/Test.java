package CK.TUGIAID1;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		QLDS qlds = new QLDS();

		FullName fu = new FullName("Tran", "Tien");
		FullName fu1 = new FullName("Hieu", "T");
		FullName fu2 = new FullName("Phan", "B");
		FullName fu3 = new FullName("Dinh", "A");
		
		LocalDate ngay = LocalDate.of(1999, 10, 10);
		LocalDate ngay1 = LocalDate.of(2000, 10, 10);
		LocalDate ngay2 = LocalDate.of(1777, 2, 2);
		
		Experience e = new Experience("a119", fu1, ngay, "012222222222", 2);
		Experience e1 = new Experience("b112", fu2, ngay1, "032222222222", 12);

		Fresher f = new Fresher("c113", fu, ngay1, "0987654321", 2022, LoaiTotNghiep.A);
		Fresher f1 = new Fresher("e114", fu3, ngay, "0987654322", 1999, LoaiTotNghiep.B);

		Intern i = new Intern("a115", fu1, ngay1, "0987654321", "KTPM", 7);
		Intern i1 = new Intern("b116", fu3, ngay, "0987654300", "KTPM", 7);

		qlds.themNhanVien(e);
		qlds.themNhanVien(e1);
		qlds.themNhanVien(f);
		qlds.themNhanVien(f1);
		qlds.themNhanVien(i);
		qlds.themNhanVien(i1);

		System.out.println(qlds);

		System.out.println("demSoLuongNhanVienToNghiep:" + qlds.demSoLuongNhanVienToNghiep());
		System.out.println("DSNhanVienToNghiep");
		System.out.println(qlds.DSNhanVienToNghiep());

		qlds.suaNgaySinh("112", ngay2);
		System.out.println(qlds);

		System.out.println("layDanhSachNV5NAM\n" + qlds.layDanhSachNV5NAM());

		System.out.println("Sap xep:");
		List <Employee> a = qlds.sapXepTenTangDan();
		
		for (Employee employee : a) {
			System.out.println(employee);
		}
		
		
		
		
		

	}
}
