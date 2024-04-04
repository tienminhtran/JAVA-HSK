package Mode2Bai4;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		try {
			DiemSinhVien sv1 = new DiemSinhVien(111111, "Tran Minh Tien", 9.5, 9.5);
			DiemSinhVien sv2 = new DiemSinhVien(222222, "Nguyen Ngoc Tai", 9, 10);
			Scanner sc = new Scanner(System.in);
			System.out.println("Nhap ma so cua sv3: ");
			int a = sc.nextInt();
			System.out.println("Nhap ho va ten cua sv3: ");
			Scanner sc1 = new Scanner(System.in);
			String b = sc1.nextLine();
			System.out.println("Nhap diem ly thuyet cua sv3: ");
			double c = sc1.nextDouble();
			System.out.println("Nhap diem thuc hanh cua sv3: ");
			double d = sc1.nextDouble();
			DiemSinhVien sv3 = new DiemSinhVien(a, b, c, d);
			inBang();
			System.out.println(sv1.toString() + sv2.toString() + sv3.toString());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	public static void inBang() {
		System.out.println(String.format("%-14s%-21s%-10s%-10s%-10s", "masv", "hoten", "diemlt", "diemth", "diemtb"));
		for (int i = 1; i <= 65; i++) {
			System.out.print("-");
		}
		System.out.println();

	}
}
