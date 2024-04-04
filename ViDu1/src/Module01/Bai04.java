package Module01;

//Viết chương trình giải phương trình bậc 1.
import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Bai04 {
	public static void main(String[] args) {

		try {
			DecimalFormat dec = new DecimalFormat("0.##");
			Scanner sc = new Scanner(System.in);
			System.out.print("Nhap so a:");
			int a = sc.nextInt();
			System.out.print("Nhap so b:");
			int b = sc.nextInt();
			System.out.println("Phuon trinh co nghiem: " + tinhPTBac1(a, b));
		} catch (InputMismatchException e) {
			System.out.println("Nhap so nguyen");
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
	}

	static double tinhPTBac1(int a, int b) throws Exception {
		if (a == 0) {
			if (b == 0) {
				throw new Exception("Phuong trinh vo so nghiem");
			} else {
				throw new Exception("Phuong trinh vo nghiem");
			}
		} else {
			return (double) -b / a;
		}
	}

}
