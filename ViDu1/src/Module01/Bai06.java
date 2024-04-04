package Module01;
//Viết chương trình kiểm tra số nhập vào có phải là số nguyên tố hay không. 
import java.util.InputMismatchException;
//Viết chương trình kiểm tra số nhập vào có phải là số nguyên tố hay không. 
import java.util.Scanner;

public class Bai06 {
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Nhap a: ");
			int a = sc.nextInt();
			if (kiemTraSoNguyenTo(a) == 0) {
				System.out.println("So " + a + " khong la so nguyen to");
			} else {
				System.out.println("So " + a + " la so nguyen to");
			}
		} catch (InputMismatchException e) {
			System.out.println("Nhap so nguyen! ");
		}

	}

	public static int kiemTraSoNguyenTo(int n) {
		if (n < 2) {
			return 0;
		} else {
			for (int i = 2; i <= Math.sqrt(n); i++) {
				if (n % i == 0) {
					return 0;
				}
			}
			return 1;
		}
	}
}
