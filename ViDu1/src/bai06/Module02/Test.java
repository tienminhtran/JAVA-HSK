package bai06.Module02;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		ThongTinDangKyXe ttdkx1 = new ThongTinDangKyXe("TT", "TTF", 100, 35000000);
		ThongTinDangKyXe ttdkx2 = new ThongTinDangKyXe("TTTG", "TTF", 3000, 15000000);
		ThongTinDangKyXe ttdkx3 = new ThongTinDangKyXe("TTGFF", "TTF", 1500, 10000000);
		
		System.out.println(String.format("%-20s%-15s%-15s%-15s%-15s","maSinhVien","hoTen","diemLT","diemTH","tinhDiemTB()"));
		System.out.println("===========================================================================");
		System.out.println(ttdkx1.toString());
		System.out.println(ttdkx2.toString());
		System.out.println(ttdkx3.toString());
	}
}
