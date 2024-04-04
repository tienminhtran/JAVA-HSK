package Module01;
//Viết chương trình nhập vào tên của mình và xuất ra màn hình “Hello + Tên”.
import java.util.Scanner;

public class Bai02 {
	public static void main(String[] args) {
		Scanner nhap = new Scanner(System.in);
		System.out.println("Ban ten gi? ");
		String a = nhap.nextLine();
		System.out.println("Hello "+a);
	}
}
