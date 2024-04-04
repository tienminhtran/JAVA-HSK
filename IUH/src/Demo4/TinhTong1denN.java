package Demo4;

import java.util.Scanner;

public class TinhTong1denN {
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			int n;
			System.out.println("Nhap n: ");
			n = sc.nextInt();
			System.out.println("Tinh tong: " + tinhTong(n));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}


	}
	public static int tinhTong(int n) throws Exception
	{
		int sum = 0;
		if(n < 0)
				throw new Exception("n phai lon hon 0");
		for (int i = 1; i < n; i++) {
				sum = sum + i;

		}
		return sum;
	}
}
