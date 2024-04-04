package chuong03.caseStudy01;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
//		Author au=new Author("Nguyen Van A", "an@gmail.com", 'F');
//		System.out.println(au);
		Author au = new Author("Nguyen Van A", "a@gmail.com", 'M');
		Book b = new Book("LTHDT", au, 10000, 10);
		System.out.println(b);
	}

}
