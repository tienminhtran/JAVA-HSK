package Module01;
//Viết chương trình in ra những số lẻ từ 1 đến 99.  
import java.util.Scanner;

public class Bai12 {
	public static void main(String[] args) {
		System.out.println("In so le tu 1 den 99: ");
		inSole();

	}

	public static void inSole() {
		for (int i = 1; i <= 99; i++) {
			if (i % 2 != 0) {
				System.out.println("" + i);
			}
		}

	}
}
