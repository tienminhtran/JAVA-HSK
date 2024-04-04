package Mode2Bai5;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) throws Exception {
		try {
			float x, y, z;
			Scanner sc = new Scanner(System.in);
			System.out.println("Nhap do dai canh ma");
			x = sc.nextFloat();
			System.out.println("Nhap do dai canh mb");
			y = sc.nextFloat();
			System.out.println("Nhap do dai canh mv");
			z = sc.nextFloat();
			HinhTamGiac htg = new HinhTamGiac(x, y, z);
			System.out.print(htg.toString());
			System.out.print(htg.kiemTraTamGiac());
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
	}
}
