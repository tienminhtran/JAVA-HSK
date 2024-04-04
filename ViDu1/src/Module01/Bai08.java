package Module01;
//Viết chương trình in ra số lần kí tự ‘a’ xuất hiện trong một chuỗi. 
import java.util.Scanner;

public class Bai08 {
	public static void main(String[] args) {
		
		String s;
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap chuoi: ");
		s = sc.nextLine();
		System.out.println("So ky tu a la trong chuoi " + s + " la: " + inSoLanKyTu(s));

	}

	public static int inSoLanKyTu(String s) {
		int dem = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'a') {
				dem++;
			}
		}
		return dem;
	}
}
