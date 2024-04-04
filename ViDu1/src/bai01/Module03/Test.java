package bai01.Module03;

public class Test {	
	public static double tongDoanhThuCacCX(ChuyenXe[] dsChuyenXes)
	{
		double tong = 0;
		for (ChuyenXe chuyenXe : dsChuyenXes) {
			tong+= chuyenXe.getDoanhThu();
		}
		return tong;
	}
	
	public static double tongDoanhThuCXNoi(ChuyenXe[] dsChuyenXes)
	{
		double tong = 0;
		for (ChuyenXe chuyenXe : dsChuyenXes) {
			if(chuyenXe instanceof ChuyenXeNoiThanh)
				tong+= chuyenXe.getDoanhThu();
		}
		return tong;
	}
	
	public static double tongDoanhThuCXNgoai(ChuyenXe[] dsChuyenXes)
	{
		double tong = 0;
		for (ChuyenXe chuyenXe : dsChuyenXes) {
			if(chuyenXe instanceof ChuyenXeNgoaiThanh)
				tong+= chuyenXe.getDoanhThu();
		}
		return tong;
	}
	public static void main(String[] args) {
		ChuyenXe[] chxe = new ChuyenXe[4];
		chxe[0] = new ChuyenXeNoiThanh("001", "Nguyen VAn A","78A-03641" , 10000, 3.2, 1);
		chxe[1] = new ChuyenXeNoiThanh("002", "Nguyen VAn B","78A-02451" , 12000, 5, 3);
		
		chxe[2] = new ChuyenXeNgoaiThanh("X01", "Nguyen Thi A","77A-051541" , 20000,"Phu yen" , 5);
		chxe[3] = new ChuyenXeNgoaiThanh("X02", "Nguyen Thi B","77A-245120" , 30000,"TPHCM" , 6);
		
		for (ChuyenXe chuyenXe : chxe) {
			System.out.println(chuyenXe);
		}
		
		System.out.println("Tong danh thu cac cuyen xe: "+ tongDoanhThuCacCX(chxe));
		System.out.println("Tong danh thu chuyen xe noi thanh: "+ tongDoanhThuCXNoi(chxe));
		System.out.println("Tong danh thu chuyen xe ngoai thanh: "+ tongDoanhThuCXNgoai(chxe));

	}

}
