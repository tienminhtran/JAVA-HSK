package Demo2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InKetQuaPhepChia {
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Nhap tu so: ");
			int a = sc.nextInt();
			System.out.println("Nhap mau so: ");			int b=0;

			if (b == 0) {
				System.out.println("Không nhap b = 0! ");
			} else {
				b = sc.nextInt();

			}
			float c = (float) a / b;
			System.out.println("Ket qua a/b: " + Math.round(c * 100.0) / 100.0);
		} catch (InputMismatchException e) {
			System.out.println("Chi nhap vao so nguyen! ");
		}

	}
}
