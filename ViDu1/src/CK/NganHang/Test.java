package CK.NganHang;

import java.util.List;

public class Test {
	public static void main(String[] args) {
		TheGhiNo gn = new TheGhiNo("GN01", "Nguyen An", 500000);
		TheGhiNo gn1 = new TheGhiNo("GN02", "Tran Lan", 1200000);

		TheTinDung td = new TheTinDung("TD01", "Ly B", 200000, 500000);
		TheTinDung td1 = new TheTinDung("TD02", "Ly C", 600000, 500000);

		QLThe qlt = new QLThe();
		qlt.themTaiKhoan(gn);
		qlt.themTaiKhoan(td);
		qlt.themTaiKhoan(gn1);
		qlt.themTaiKhoan(td1);

		System.out.println(qlt);
		System.out.println("demSoLuongTheKhongConChiTieu" + qlt.demSoLuongTheKhongConChiTieu());
		System.out.println("suaMucTinDung");
		System.out.println(qlt.suaMucTinDung("TD02", 700000));
		System.out.println(qlt);

		List<TaiKhoan> kq = qlt.sapXepMaTheGiam();
		for (TaiKhoan taiKhoan : kq) {
			System.out.println(taiKhoan);
		}
	}
}
