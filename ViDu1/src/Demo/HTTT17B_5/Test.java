package Demo.HTTT17B_5;

import java.time.LocalDate;

public class Test {

	public static void main(String[] args) {
		LocalDate ngay1 = LocalDate.of(2022, 9, 25);
		LocalDate ngay2 = LocalDate.of(2022, 10, 17);
		LocalDate ngay3 = LocalDate.of(2022, 9, 25);
		GiaoDich gd = new GiaoDich("GD01", "NHA",ngay1 , 45, 12);
		GiaoDich gd1 = new GiaoDich("GD02", "DAT",ngay2 , 15, 56);
		GiaoDich gd2 = new GiaoDich("GD01", "NHA",ngay3 , 35, 13);
		GiaoDich gd3 = new GiaoDich("GD03", "KT",ngay1 , 34, 12);
		
		System.out.println(gd);		
		System.out.println(gd1);		
		System.out.println(gd2);
		System.out.println(gd3);

		
	}
}
