package Excercises_4;

import java.util.Scanner;

public class Ex_4 {
	public static int tinhSoKiTu(String s) {
		s = s.trim();
		int tong = 0;
		for (int i = 0; i < s.length(); i++) // vonh vinh loi
		{
			if (s.charAt(i) == ' ') {
				tong += 0;
			} else
				tong++;
		}
		return tong;
	}

	public static int tinhSoTu(String s) {
		int tong = 0;
		s = s.trim();
		char kytu[] = new char[s.length()];
		for (int i = 0; i < s.length(); i++) // vonh vinh loi
		{ 
			kytu[i] = s.charAt(i);
			if((i > 0)&&(kytu[i]!=0)&&(kytu[i-1]==' ')) {
				tong++;
			}
		}
		return tong+1;
	}
	static int demSoTu(String s) {
		int count = 0;
		String[] b = s.split(" ");
		for (int i =0; i<b.length; i++) {
			count++;
		} 
		return count;
	}

	public static void main(String[] args) {
		String s;
		Scanner sc = new Scanner(System.in);
		s = sc.nextLine();
		System.out.println("Số ky tu: " + tinhSoKiTu(s));
		System.out.println("So tu: " + tinhSoTu(s));

	}

}
