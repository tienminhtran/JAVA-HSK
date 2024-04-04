package bai05.Module02;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) throws Exception {
		try {
			float x, y, z;
			HinhTamGiac htg1 = new HinhTamGiac(3,4,5);
			HinhTamGiac htg2 = new HinhTamGiac(3,3,3);
			HinhTamGiac htg3 = new HinhTamGiac(3,3,5);
			HinhTamGiac htg4 = new HinhTamGiac(2,2,2*Math.sqrt(2));
			HinhTamGiac htg5 = new HinhTamGiac(-3,5,6);
			System.out.println(htg1.layTieuDe());
			System.out.println(htg1);
			System.out.println(htg2);
			System.out.println(htg3);
			System.out.println(htg4);
			System.out.println(htg5);
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
	}
}
