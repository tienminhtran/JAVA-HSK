package Demo3;

import java.util.Scanner;

public class NoiHaiChuoi {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// s1 = new String("  ");
		System.out.println("Nhap chuoi thu nhat: ");
		String a = sc.nextLine();
		System.out.println("Nhap chuoi thu hai: ");
		String b = sc.nextLine();
		String c = new String();
		c = a.concat(b);
		//System.out.println("Noi hai chuoi: "+ a+b);
		System.out.println("Noi hai chuoi: "+ c);
	}
}
