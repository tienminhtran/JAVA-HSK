package Module01;
//Viết chương trình nhập vào M và N, xuất ra các hình sau (dùng cấu trúc lặp):
import java.util.Scanner;

public class Bai17 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int dong;
		System.out.println("Nhap so dong: ");
		dong = sc.nextInt();
		System.out.println("In tam giac A ");
		inTamGiacA(dong);
		System.out.println("In tam giac B ");
		inTamGiacB(dong);
		System.out.println("In tam giac C ");
		inTamGiacC(dong);
		System.out.println("In tam giac D ");
		inTamGiacD(dong);
	}

	public static void inTamGiacA(int dong) {
		for (int i = 1; i <= dong; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public static void inTamGiacB(int dong) {
		for (int i = dong; i >= 1; i--) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public static void inTamGiacC(int dong) {
		;
		for (int i = 1; i <= dong; i++) {
			for (int j = 1; j <= dong - i; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= i; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}

	public static void inTamGiacD(int dong) {
		for (int i = 1; i <= dong; i++) {
			for (int j = 1; j <= dong - 1 + i; j++) {
				if (j == dong + 1 - i || j == dong - 1 + i || i == dong) {
					System.out.print("*");
				} else
					System.out.print(" ");
			}
			System.out.print("\n");

		}
	}
}
