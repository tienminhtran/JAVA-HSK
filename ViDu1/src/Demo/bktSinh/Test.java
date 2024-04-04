package Demo.bktSinh;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Test {
	public static void main(String[] args) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		LocalDate ngay1 = LocalDate.of(2018, 7, 10);
		LocalDate ngay2 = LocalDate.of(2019, 7, 10);

		HoaDonTienDien hdtd = new HoaDonTienDien("A002",ngay1,150,5000);
		HoaDonTienDien hdtd1 = new HoaDonTienDien("B003",ngay2,250,5000);

		System.out.println(hdtd);
		System.out.println(hdtd1);
		

	}
}
