package VangBac_1;

import java.time.LocalDate;

public class Test {
	public static void main(String[] args) {

		LocalDate ngay = LocalDate.of(1999, 10, 10);
		LocalDate ngay1 = LocalDate.of(2000, 10, 10);
		LocalDate ngay2 = LocalDate.of(1777, 2, 2);

		Giaodichvang v = new Giaodichvang("A0221", ngay, 35, "9999", 10, 2);
		Giaodichvang v1 = new Giaodichvang("B0771", ngay1, 135, "999", 180, 2);
		Giaodichvang v2 = new Giaodichvang("A071", ngay1, 135, "99", 180, 2);

		Giaodichdaquy d = new Giaodichdaquy("C1111", ngay2, 22220, "kim cuong", 3.2);
		Giaodichdaquy d1 = new Giaodichdaquy("A1110", ngay1, 2220, "kim cuong", 3.2);
		Giaodichdaquy d2 = new Giaodichdaquy("C11888", ngay, 12220, "kim cuong", 3.2);

		DSGD gd = new DSGD();
		gd.themGD(v);
		gd.themGD(v1);
		gd.themGD(v2);
		gd.themGD(d);
		gd.themGD(d1);
		gd.themGD(d2);

		System.out.println(gd);

		System.out.println("xoa GD: " + gd.xoaGD("B0771"));
		System.out.println(gd);

		System.out.println("sapXepTangDanMa");
		gd.sapXepTangDanMa();		
		System.out.println(gd);

		System.out.println("capNhatGiaGD");
		System.out.println(gd.capNhatGiaGD("C11888",555555));		System.out.println(gd);
		
		System.out.println("capNhatSoCARAT");
		System.out.println(gd.capNhatSoCARAT("C1111",100));		System.out.println(gd);
	
		System.out.println(gd.layThongTin());
		
		
		System.out.println("TIM "+gd.timKiemMa("C11888"));
		
	}
}
