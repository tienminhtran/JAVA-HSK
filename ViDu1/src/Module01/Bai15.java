package Module01;
//Viết chương trình cho nhập vào 1 mảng và in ra giá trị lớn nhất và nhỏ nhất của mảng.
import java.util.Scanner;

public class Bai15 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap phan tu n: ");
		int n = sc.nextInt();
		int a[] = new int[100];
		nhapMang(a, n);
		System.out.println("Mang vua nhap: ");
		xuatMang(a, n);
		System.out.println("GTLN:" + timMax(a, n));
		System.out.println("GTNN:" + timMin(a, n));
	}

	public static void nhapMang(int a[], int n) {
		for (int i = 0; i < n; i++) {
			System.out.println("Nhap phan tu thu " + i + ": ");
			Scanner sc = new Scanner(System.in);
			a[i] = sc.nextInt();
		}
	}
	public static void xuatMang(int a[], int n) {
		for (int i = 0; i < n; i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
	public static int timMax(int a[], int n) {
		int max = a[0];
		for (int i = 0; i < n; i++) {
			if (max < a[i])
				max = a[i];
		}
		return max;
	}

	public static int timMin(int a[], int n) {
		int min = a[0];
		for (int i = 0; i < n; i++) {
			if (min > a[i])
				min = a[i];
		}
		return min;
	}
}
