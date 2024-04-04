package Excercises_3;

import java.util.Scanner;

public class Ex_3 {
	public static void main(String[] args) {
		try {
			int n;
			Scanner sc = new Scanner(System.in);
			do {
				System.out.println("Nhap vao n = ");
				n = sc.nextInt();
				if (n < 0) {
					System.out.println("Nhap lai! ");
				}
			} while (n < 0);
			System.out.println("Tong cac SNT:" + tongSoNguyenTo(n));
		} catch (Exception e) {
			System.out.println("Yeu cau nhap lai!");
		}

	}

	public static boolean kiemTraSoNguyenTo(int n) {
		if (n <= 1) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static int tongSoNguyenTo(int n) {
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			if (kiemTraSoNguyenTo(i) == true) {
				sum = sum + i;
			}
		}
		return sum;
	}
}
