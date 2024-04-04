package Excercises_1;

import java.util.Scanner;

public class Ex_1 {

	public static void main(String[] args) {

		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Nhap so nguyen thu 1: ");
			int a = sc.nextInt();
			System.out.println("Nhap so nguyen thu 2: ");
			int b = sc.nextInt();
			System.out.println("Tong a+b la: " + a + b);
			System.out.println("Hieu a-b la: " + (a - b));
			System.out.println("Tich a.b la: " + a * b);
			if (b == 0) {
				System.out.println("Khong the chia cho 0");
			} else {
				System.out.println("Chia a/b la: " + a / b);
			}
		} catch (Exception e) {
			System.out.println("Nhap du lieu la so");
		}
	}
}
