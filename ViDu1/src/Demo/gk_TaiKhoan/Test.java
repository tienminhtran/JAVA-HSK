package Demo.gk_TaiKhoan;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) throws Exception {
		DiaChi dc = new DiaChi("194A", "Le Duc Tho", "Phuong 9", "Go Vap");
		KhachHang kh = new KhachHang("Nguyen Van An", dc, true);
//		System.out.println(kh);
		TaiKhoan tk = new TaiKhoan(9999, kh, 10000000);
		System.out.println(tk);
		System.out.println("Nhap so tien muon goi: ");
		Scanner sc = new Scanner(System.in);
		double x;
		x = sc.nextDouble();
		if(tk.goiTien(x)==true)
		{
			System.out.println("GD GOI TIEN THANH CONG. TK sau khi goi la: \n" + tk);
		}
		else
		{
			System.out.println("GD GOI TIEN KHONG THANH CONG: \n" +tk);
		}
		System.out.println("Nhap so tien muon rut: ");
		sc = new Scanner(System.in);
		double y;
		y = sc.nextDouble();
		if(tk.rutTien(y)==true)
		{
			System.out.println("GD RUT TIEN THANH CONG. TK sau khi rut la: \n" + tk);
		}
		else
		{
			System.out.println("GD RUT TIEN KHONG THANH CONG. Vi So tien rut > So tien trong tai khoan hoac So Tien rut: \n" +tk);
		}

	}
}
/*
throw new Exception("GD GOI TIEN THANH CONG. TK sau khi goi la: ");
		}
		else
			throw new Exception("GD GOI TIEN KHONG HANH CONG. TK sau khi goi la: ");
*/