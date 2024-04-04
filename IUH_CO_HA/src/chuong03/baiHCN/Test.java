package chuong03.baiHCN;

public class Test {

	public static void main(String[] args) {
		HinhChuNhat h;
		h = new HinhChuNhat(9, 5);

		System.out.println("chu vi la:" + h.tinhChuVi());
		System.out.println("dien tich la:" + h.tinhDienTich());

		h = new HinhChuNhat(2, 8);
		System.out.println("chu vi la:" + h.tinhChuVi());
		System.out.println("dien tich la:" + h.tinhDienTich());
		
		h.setChieuDai(10);
		System.out.println("chu vi la:" + h.tinhChuVi());
		System.out.println("dien tich la:" + h.tinhDienTich());
		
		//xuất thông tin cd cr của h:
		System.out.println(h.layThongTin());
		
		System.out.println("Chieu dai="+h.getChieuDai());
	}

}
