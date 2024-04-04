package chuong05.demo;

import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		List<String> a = new ArrayList<String>();
		a.add("An");
		a.add("Nam");
		System.out.println(a);
		
		if (a.indexOf("An")!=-1)
			System.out.println("tim thay");
		else
			System.out.println("khong tim thay");
//		List<Integer> b = new ArrayList<Integer>();
//		b.add(2);
//		b.add(4);
//		System.out.println(b);
//		
//		List<Circle> c = new ArrayList<Circle>();
//		c.add(new Circle(4));
//		c.add(new Circle(10));
//		System.out.println(c);
	}
}
