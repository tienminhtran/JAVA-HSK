package ViDu1;
import java.util.Scanner;
public class TinhTongSoChan {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap vao n: ");
		int n = sc.nextInt();
		System.out.println("Tinh tong: " + tinhTongSoChan(n));
	}

	public static int tinhTongSoChan(int n) {
		int sum = 0;
		for (int i = 1; i < n; i++) {
			if (i % 2 == 0) {
				sum = sum + i;
			}
		}
		return sum;
	}
}
