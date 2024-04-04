package bai07.Module02;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Test {
	public static void main(String[] args) {

		// ngày
		try {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

			LocalDate ngay1 = LocalDate.of(2018, 7, 10);
			LocalDate ngay2 = LocalDate.of(2018, 3, 02);
			LocalDate ngay3 = LocalDate.of(2022, 9, 07);
			LocalDate ngay4 = LocalDate.of(2017, 3, 01); // năm tháng ngày
			LocalDate ngay5 = LocalDate.of(2022, 10, 01); // năm tháng ngày

			// thuc pham
			HangThucPham htp1 = new HangThucPham("001", "Gao", 100000, ngay1, ngay5);
			HangThucPham htp2 = new HangThucPham("002", "Mi", 5000, ngay2, ngay3);
			HangThucPham htp3 = new HangThucPham("003", "Nuoc", 10000, ngay4, ngay2);
			inBang();
			System.out.println(htp1);
			System.out.println(htp2);
			System.out.println(htp3);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public static void inBang() {
		System.out.println(String.format("%-15s%-20s%-15s%-30s%-30s%-30s", "Ma_Hang", "Ten_Hang", "Don_Gia",
				"Ngay_San_Xuat", "Ngay_Het_Han", "Ghi_Chu"));
		for (int i = 1; i <= 123; i++) {
			System.out.print("-");
		}
		System.out.println();

	}
}
