package bai02.Module03;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		Sach[] s = new Sach[6];
		DecimalFormat df = new DecimalFormat("#,##0");
		LocalDate ngay = LocalDate.of(2022, 10, 11);
		LocalDate ngay1 = LocalDate.of(2022, 9, 21);
		LocalDate ngay2 = LocalDate.of(2022, 7, 23);
		LocalDate ngay3 = LocalDate.of(2022, 6, 5);

		s[0] = new SachGiaoKhoa("A01", ngay, 1000, 2, "Thu Hien", false);
		s[1] = new SachGiaoKhoa("A02", ngay1, 2000, 4, "Tien", true);
		s[2] = new SachGiaoKhoa("A03", ngay2, 4000, 5, "Thi Chi", true);
		s[3] = new SachThamKhao("A04", ngay1, 1000, 2, "Khanh Linh", 4);
		s[4] = new SachThamKhao("A05", ngay3, 1200, 4, "Hoai Thi", 3);
		s[5] = new SachThamKhao("A06", ngay2, 3000, 5, "Tien", 2);
		xuatDanhSach(s);
		System.out.println("Tong thanh tien sach giao khoa: " + df.format(tinhTongThanhTienSGK(s)));
		System.out.println("Tong thanh tien sach tham khao: " +  df.format(tinhTongThanhTienSTK(s)));
		
		System.out.println("Xuat danh sach theo nxb: ");
		xuatSachGiaoKhoa(s, "Tien");
		System.out.println("Thanh tien cao nhat: " +  df.format(tinhThanhTienCaoNhat(s)));

	}
	public static void xuatDanhSach(Sach a[]) {
		for (Sach sach : a) {
			System.out.println(sach);
		}
		
	}
	public static double tinhTongThanhTienSGK(Sach[] others)
	{
		double sum = 0;
		for (Sach sach : others) {
			if(sach instanceof SachGiaoKhoa) {
				sum += sach.getThanhTien();
			}
		}
		return sum;
	}
	
	public static double tinhTongThanhTienSTK(Sach[] others)
	{
		double sum = 0;
		for (Sach sach : others) {
			if(sach instanceof SachThamKhao) {
				sum = sum + sach.getThanhTien();
			}
		}
		return sum;
	}
	
	public static void xuatSachGiaoKhoa(Sach []a, String k)
	{
		boolean index = false;
		for (Sach sach : a) {
			if(sach instanceof SachGiaoKhoa)
				if(sach.getNhaXuatBan().equalsIgnoreCase(k))
				{
					System.out.println(sach);
					index = true;
				}
		}
		if(!index )
			System.out.println("Khong tim thay");
	}
	
	public static double tinhThanhTienCaoNhat(Sach[] others)
	{
		double max = 0;
		for (int i = 0; i < others.length; i++) {
			if(max < others[i].getThanhTien()) {
				max = others[i].getThanhTien();
			}
		}
		return max;
	}

}
