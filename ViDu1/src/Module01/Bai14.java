package Module01;
//Viết chương trình cho nhập vào 1 mảng và kiểm tra xem có giá trị k nào đó hay không.
import java.util.Scanner;

public class Bai14 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap n: ");
		int count = 0, n = sc.nextInt();
		int[] a = new int[n];
		nhapMang(a, n);
		System.out.println("Nhap gia tri can kiem tra: ");
		int k = sc.nextInt();
		
		if (kiemTraGiaTri(a, n, k)) {
			System.out.println("Co gia tri "+k+ " trong mang ");
			xuatMang(a, n);
		} else {
			System.out.println("Khong gia tri " +k +" trong mang ");			
			xuatMang(a, n);

		}		
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
	}

	public static boolean kiemTraGiaTri(int[] a, int n, int k) {
		for (int i = 0; i < a.length; i++) {
			if (k == a[i])
				return true;
		}
		return false;
	}

}
