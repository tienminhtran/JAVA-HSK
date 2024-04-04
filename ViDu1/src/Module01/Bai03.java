package Module01;
// Viết chương trình in ra tổng 1+3+5+…+n nếu n là số lẻ, 2+4+6+…+n nếu n là số chẵn. 
import java.util.Scanner;

public class Bai03 {
	public static void main(String[] args) {
		int n;
		System.out.println("Nhap so phan tu: ");
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		System.out.println("Ket qua: " + tinhTongTheoN(n));

	} 

	public static int tinhTongTheoN(int n) {
		int sum = 0;
		if (n % 2 == 0) {
			for (int i = 0; i <= n; i = i + 2) {
				sum = sum + i;
			}
		} else {
			for (int i = 1; i <= n; i = i + 2) {
				sum = sum + i;
			}
		}
		return sum;

	}
}
