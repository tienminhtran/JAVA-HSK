import java.util.Iterator;
import java.util.Scanner;

public class VD {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s;
		System.out.println("Nhap vao chuoi:");
		s = sc.nextLine();
		System.out.println("-------------");
		System.out.println(s.length());
		int doDai = s.length();
		//---------------------
		for(int  i =0; i < doDai; i++) {
			System.out.println("Vi tri " +i+"la: " + s.charAt(i));
		
		}
		//------------------
		char mang[] = new char[100];
		s.getChars(2, 4, mang, 0);
		for(int i = 0; i< mang.length; i++) {
			System.out.println("Mang "+ i+ "la " + mang[i]);
		}
		//-------------------
		byte[] arrayBytes = s.getBytes();
		for (byte b : arrayBytes) {
			System.out.println(b);
		}
	}
}
