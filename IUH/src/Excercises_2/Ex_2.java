package Excercises_2;

import java.util.Scanner;

public class Ex_2 {
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Nhap so thu 1: ");
			int a = sc.nextInt();
			System.out.println("Nhap so thu 2: ");
			int b = sc.nextInt();
			if (phuongTrinhBacNhat(a, b) == 0) {
				System.out.println("Phuong trinh vo so nghiem");
			} else if (phuongTrinhBacNhat(a, b) == 1) {
				System.out.println("Phuong trinh vo nghiem");
			} else {
				System.out.println("Phuong trinh co nghiem x = " + -b / a);
			}
		} catch (Exception e) {
			System.out.println("Nhap du lieu chua chinh xac, nhap lai");
		}

	}

	public static double phuongTrinhBacNhat(double a, double b) {
		if (a == 0) {
			if (b == 0) {
				return 0;
			} else {
				return 1;
			}
		} else {
			return -1;
		}
	}
}
