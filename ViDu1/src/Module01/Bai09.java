package Module01;
//
///*
// * Viết hàm tách chuỗi gốc thành chuỗi con.
//VD: chuỗi gốc S = “ Lap Trinh	HDT”, chuỗi sau khi tách là
//“Lap Trinh HDT”
//*/

import java.util.Scanner;
/*
 * Viết hàm tách chuỗi gốc thành chuỗi con.
VD: chuỗi gốc S = “ Lap Trinh	HDT”, chuỗi sau khi tách là
“Lap Trinh HDT”

 */
public class Bai09 {

	public static String[] tachChuoi(String a) {
		a = a.trim();
		while (a.contains("  ")) {
			a = a.replace("  ", " ");
		}
		return a.split(" ");
	}

	public static void main(String[] args) {
		String s;

		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap vao mot chuoi: ");
		s = sc.nextLine();
		String words[] = tachChuoi(s);
		for (String word : words) {
		
			System.out.println(word);
		}
	}
}
