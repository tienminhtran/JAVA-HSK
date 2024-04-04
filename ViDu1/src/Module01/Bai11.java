package Module01;
//Viết chương trình nhập vào số nguyên n và thực hiện: Xuất ra màn hình 
//n số đầu tiên của chuỗi  Fibonaci (có hai giá trị đầu là 1 và 1). 0 1 1 
import java.util.InputMismatchException;
import java.util.Scanner;

public class Bai11 {
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Nhap so luong n: ");
			int n = sc.nextInt();
			for (int i = 1; i <= n; i++) {
				System.out.println(fibo(i));
			}
		} catch (InputMismatchException e) {
			System.out.println("Nhap so nguyen!");
		}

	}

	public static int fibo(int n) {
		if(n==1 || n ==2)
			return 1;
		else
			return fibo(n - 1) + fibo(n - 2);
	}
}
