package Module01;
//Tính tổng các số nguyên tố nhỏ hơn N.
import java.util.InputMismatchException;
//Viết chương trình in ra tổng 1+3+5+…+n nếu n là số lẻ, 2+4+6+…+n nếu n là số chẵn. 
import java.util.Scanner;

public class Bai07 {
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Nhap n: ");
			int n = sc.nextInt();
			System.out.println("Ket qua tinh tong SNT: " + tinhTongSoNguyenTo(n));
		} catch (InputMismatchException e) {
			// TODO: handle exception
		}

	}

	public static int kiemTraSoNguyenTo(int n) {
		if (n < 2) {
			return 0;
		}
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				return 0;
			}
		}
		return 1;
	}

	public static int tinhTongSoNguyenTo(int n) {
		int s = 0;
		for (int i = 2; i < n; i++) {
			if (kiemTraSoNguyenTo(i) == 1) {
				s = s + i;
			}
		}
		return s;
	}
}
