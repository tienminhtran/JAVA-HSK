package chuong04.caseStudy01;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

public class Test {

	public static void main(String[] args) {
		SinhVien[] a = new SinhVien[5];
		a[0] = new SinhVien(1, "Vinh", 19, "Hanoi");
		a[1] = new SinhVien(2, "Hoa", 18, "Hanoi");
		a[2] = new SinhVien(3, "Phu", 21, "Hanoi");
		a[3] = new SinhVien(4, "Quy", 20, "Hanoi");
		a[4] = new SinhVien(5, "An", 18, "Hanoi");

		for (SinhVien sinhVien : a)
			System.out.println(sinhVien);
//sap xep theo tuoi tang dan
		Arrays.sort(a, new Comparator<SinhVien>() {
			@Override
			public int compare(SinhVien o1, SinhVien o2) {
				if (o1.getTuoi() == o2.getTuoi())
					return 0;
				else if (o1.getTuoi() > o2.getTuoi())
					return 1;
				return -1;
			}
		});

		System.out.println("sau khi sx tuoi tang dan:");
		for (SinhVien sinhVien : a)
			System.out.println(sinhVien);

		//sap xep theo ten tang dan
		Arrays.sort(a, new Comparator<SinhVien>() {

			@Override
			public int compare(SinhVien o1, SinhVien o2) {
				// TODO Auto-generated method stub
				return o1.getTen().compareToIgnoreCase(o2.getTen());
			}
		});
		System.out.println("sau khi sx ten tang dan:");
		for (SinhVien sinhVien : a)
			System.out.println(sinhVien);
	}

}
