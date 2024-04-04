package Demo.gk_CuocPhi;

public class Test {

	public static void main(String[] args) {
		ThueBao tb = new ThueBao("012342323", "Nguyen A");
		ThueBao tb1 = new ThueBao("012355555", "Nguyen B");
		ThueBao tb2 = new ThueBao("012342335", "Nguyen C");
		ThueBao tb3 = new ThueBao("", "Nguyen D"); // trống sdt

		CuocPhi cp = new CuocPhi(tb, 3, 2022, 240, 500, 400);
		CuocPhi cp1 = new CuocPhi(tb1, 1, 2022, -100, 500, 400);// SAi MB sử dụng 
		CuocPhi cp2 = new CuocPhi(tb2, 2, 2022, 250, 500, 400);
		CuocPhi cp3 = new CuocPhi(tb3, 14, 2021, 140, 500, 400); // nhập sai tháng 
		System.out.println(cp.getTieuDe());
		System.out.println(cp);
		System.out.println(cp1);
		System.out.println(cp2);
		System.out.println(cp3);

	}

}
