package vidu;

public class test {
	public static void main(String[] args) {
		Sinhvien sv1= new Sinhvien(150, "Tran Van Thanh", "Lop 1", 9);
		Sinhvien sv2= new Sinhvien(100, "Nguyen Thi Thanh Hoa", "Lop 2", 8);
		Sinhvien sv3= new Sinhvien(199, "Nguyen Van An", "Lop 2", 8);
		
		System.out.println(sv1.compareTo(sv2));
		System.out.println(sv3.compareTo(sv1));
	}
}
