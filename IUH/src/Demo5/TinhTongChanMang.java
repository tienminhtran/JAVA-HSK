package Demo5;

import java.util.Scanner;

public class TinhTongChanMang {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a[] = new int[100];
		System.out.println("Nhap n");
		int n = sc.nextInt();
		for(int i = 1; i <= n;i++)
		{
			System.out.println("Nhap phan tu thu "+i +": ");
			a[i] = sc.nextInt();
		}
		System.out.println("KQ: "+TinhTongChan(n,a));
	}
	public static int TinhTongChan(int n, int a[]) {
		int s = 0;
		for(int i = 1; i <= n;i++) {
			if(a[i] % 2 == 0) {
				s = s + a[i];
			}
		}
		return s;

	}
}
