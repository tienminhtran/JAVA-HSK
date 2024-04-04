package ViDu2;

import java.util.Scanner;

public class TinhTongSNT {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap vao n = ");
		int n = sc.nextInt();
		System.out.println("Tong cac SNT" + tongSoNguyenTo(n));
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