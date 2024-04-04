package Module01;
//Viết chương trình cho nhập vào mảng các chuỗi, kiểm tra xem có chuỗi nào đó trong mảng không.
import java.util.Scanner;

public class Bai16 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap phan tu n: ");
		int n = sc.nextInt();
		String a[] = new String[100];
		sc = new Scanner(System.in);
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextLine();
		}
		System.out.println("Nhap chuoi can kiem tra: ");
		String s = sc.nextLine();
		if(kiemTraChuoi(a, s, n)==true) {
			System.out.println("Data found!");
		}else
			System.out.println("Data no found!");

	}
	
	public static boolean kiemTraChuoi(String a[], String s, int n) {
		for (int i = 0; i < n; i++) {
			if (a[i].equals(s)) {
				return true;
			}
		}
		return false;

	}
}
