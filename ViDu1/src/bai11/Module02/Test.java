package bai11.Module02;


import java.time.LocalDate;



public class Test {

	public static void main(String[] args) {

		
			LocalDate ngay = LocalDate.of(2020, 01, 05);
			LocalDate ngay1 = LocalDate.of(2021, 01, 05);

			KhachHang kh = new KhachHang("KH", "Nguyen A", 10);
			kh.themSoTietKiem("111", ngay,10000, 3, 0.005);
			kh.themSoTietKiem("112", ngay1,10000, 4, 0.005);
			System.out.println(kh.layTieuDe());
			System.out.println(kh);
			
	}

}

