package bai03.Module03;

import java.time.LocalDate;

public class Test {

	public static void main(String[] args) {
		LocalDate ngay = LocalDate.of(2022, 11, 1);
		LocalDate ngay1 = LocalDate.of(2022, 9, 24);
		LocalDate ngay2 = LocalDate.of(2022, 11, 23);
		LocalDate ngay3 = LocalDate.of(2022, 12, 1);

		GiaoDich gd[] = new GiaoDich[6];

		gd[0] = new GiaoDichVang("V001", ngay, 3000000, 10, "V24K");
		gd[1] = new GiaoDichVang("V002", ngay2, 4000000, 5, "V18K");
		gd[2] = new GiaoDichVang("V003", ngay1, 3000000, 6, "V9999");

		gd[3] = new GiaoDichTienTe("T001", ngay3, 200, 100, 24, "usd");
		gd[4] = new GiaoDichTienTe("T002", ngay, 300, 120, 500, "VN");
		gd[5] = new GiaoDichTienTe("T003", ngay2, 400, 100, 200, "ThaiLan");
		xuatDanhSach(gd);
		System.out.println("Tong so luong Giao Dich Vang: " + tinhTongSoLuongGiaoDichVang(gd));
		System.out.println("Tong so luong Giao Tien Te: " + tinhTongSoLuongGiaoDichTienTe(gd));
		System.out.printf("Tong trung binh thanh tien Giao Tien Te: %.2f\n", tinhTrungBinhThanhTienGDTienTe(gd));

		System.out.println("Giao dich tren 1 ty: ");
		xuatGiaoDichGDLon1ty(gd);
	}

	public static void xuatDanhSach(GiaoDich a[]) {
		for (GiaoDich giaoDich : a) {
			System.out.println(giaoDich);
		}
	}

	public static int tinhTongSoLuongGiaoDichVang(GiaoDich a[]) {
		int sumV = 0;
		for (GiaoDich giaoDich : a) {
			if (giaoDich instanceof GiaoDichVang) {
				sumV = sumV + giaoDich.getSoLuong();
			}
		}
		return sumV;
	}

	public static int tinhTongSoLuongGiaoDichTienTe(GiaoDich a[]) {
		int sumT = 0;
		for (GiaoDich giaoDich : a) {
			if (giaoDich instanceof GiaoDichTienTe) {
				sumT = sumT + giaoDich.getSoLuong();
			}
		}
		return sumT;
	}

	public static double tinhTrungBinhThanhTienGDTienTe(GiaoDich a[]) {
		double sum = 0;
		double n = 0;
		for (GiaoDich giaoDich : a) {
			if (giaoDich instanceof GiaoDichTienTe) {
				n++;
				sum = sum + giaoDich.getThanhTien();
			}
		}
		return sum / n;
	}

	public static void xuatGiaoDichGDLon1ty(GiaoDich a[]) {
		boolean index = false;
		for (GiaoDich giaoDich : a) {
			if (giaoDich.getDonGia() > 1000000) {
				System.out.println(giaoDich);
				index = true;
			}
		}
		if (!index)
			System.out.println("Khong tim thay");
	}
}
