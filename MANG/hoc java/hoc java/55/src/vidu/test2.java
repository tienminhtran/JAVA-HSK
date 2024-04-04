package vidu;

import java.lang.reflect.Array;
import java.util.Arrays;

public class test2 {
	public static void main(String[] args) {
		Sinhvien sv1= new Sinhvien(150, "Tran Van Thanh", "Lop 1", 9);
		Sinhvien sv2= new Sinhvien(100, "Nguyen Thi Thanh Hoa", "Lop 2", 8);
		Sinhvien sv3= new Sinhvien(199, "Nguyen Van An", "Lop 2", 8);

		Sinhvien[] a_sv= new Sinhvien[] {sv1,sv2,sv3};
		
		System.out.println("Ban dau: "+Arrays.toString(a_sv));
		//ham sap xep
		Arrays.sort(a_sv);
		System.out.println("sau khi sap xep: "+Arrays.toString(a_sv));
		//ham tiem kiem
		System.out.println("Tim kiem An: "+Arrays.binarySearch(a_sv, sv1));
		
	}
}
