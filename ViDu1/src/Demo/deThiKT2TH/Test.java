package Demo.deThiKT2TH;

import java.time.LocalDate;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		SapThucPham stp1 = new SapThucPham("STP01", 35, 5000000, 25000000, LocalDate.of(2022, 10, 10), 25);
		SapThucPham stp2 = new SapThucPham("STP02", 12, 5000000, 15000000, LocalDate.of(2023, 10, 11), 25);
		SapThucPham stp3 = new SapThucPham("STP03", 15, 5000000, 45000000, LocalDate.of(2023, 10, 12), 25);

		SapQuanAo sqa1 = new SapQuanAo("SQA01", 122, 5000000, 45000000, LocalDate.of(2022, 10, 10));
		SapQuanAo sqa2 = new SapQuanAo("SQA02", 101, 5000000, 25000000, LocalDate.of(2022, 10, 10));
		SapQuanAo sqa3 = new SapQuanAo("SQA03", 12, 5000000, 45000000, LocalDate.of(2022, 10, 10));
		DanhSachQuanLy ds = new DanhSachQuanLy();
		ds.them(stp1);
		ds.them(sqa1);
		ds.them(stp2);
		ds.them(sqa3);
		ds.them(stp2);
		ds.them(stp3);
		ds.them(sqa2);
		System.out.println(ds);
		
//		System.out.println("Tim kiem ma");
//		DanhSachQuanLy ds1 = ds.timKiemMa("SQA02");
//		System.out.println(ds1);
		
//		System.out.println("Tim kiem ma");
//		System.out.println(ds.timKiemMaSap("SQA02"));
		
//		System.out.println("demSoLuongSapThucPham: "+ds.demSoLuongSapThucPham());
		
//		System.out.println("xuatDanhSachSap10112022");
//		DanhSachQuanLy ds2 = ds.xuatDanhSachSap10112022();
//		System.out.println(ds2);
		
//		System.out.println("timDoanhThuMax");
//		DanhSachQuanLy ds3 = ds.timDoanhThuMax();
//		System.out.println(ds3);
		
//		System.out.println("xoaSap");
//		System.out.println(ds.xoaSap("SQA03"));System.out.println(ds);
		
		
//		System.out.println(" capNhapPhiDongLanh");
//		System.out.println(ds.capNhapPhiDongLanh("STP02",3000));System.out.println(ds);
		
		
//		System.out.println("sapXepDoanhThu");
//		List<Sap> t = ds.sapXepDoanhThu();
//		for (Sap sap : t) {
//			System.out.println(sap);
//		}
		System.out.println("sapXeptheo ma");
		List<Sap> n = ds.sapXepTheoMa();
		for (Sap sap : n) {
			System.out.println(sap);
		}
	}

}
