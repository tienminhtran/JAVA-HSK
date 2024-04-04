package Demo.KTMP17A_S4;

public class Test {

	public static void main(String[] args) {

		ThongTinLienHe ttlh1 = new ThongTinLienHe("123", "B", "Quan 1", "0123456789");
//		ThongTinLienHe ttlh1 = new ThongTinLienHe("", "Ly Thuong Kiet", "Quan 1", "012345");
//		ThongTinLienHe ttlh2 = new ThongTinLienHe("34A", "", "Quan 2", "01234567891");
//		ThongTinLienHe ttlh3 = new ThongTinLienHe("34A", "Ly Thuong Kiet", "", "0123456789");
		
		ThongTinLienHe ttlh2 = new ThongTinLienHe("12D", "A", "Quan 1", "0123456789");
		ThongTinLienHe ttlh3 = new ThongTinLienHe("48D", "C", "Ha Noi", "0123333333");

		ThongTinLienHe ttlh4 = new ThongTinLienHe("45D", "E", "Quan 3", "0123456789");
		ThongTinLienHe ttlh5 = new ThongTinLienHe("46D", "N", "Quan 5", "0123333333");
//		System.out.println(ttlh);		
//		System.out.println(ttlh1);
//		System.out.println(ttlh2);		
//		System.out.println(ttlh3);

		HeThongLienHe htlh = new HeThongLienHe("ABC", "Loai 1");
		htlh.them(ttlh1);
		htlh.them(ttlh2);
		htlh.them(ttlh3);
		System.out.println(htlh);
		HeThongLienHe htlh2 = new HeThongLienHe("BCD", "Loai 2");
		htlh2.them(ttlh4);
		htlh2.them(ttlh5);
		System.out.println(htlh2);

		htlh.sapXepTangTheoDuong();
		htlh2.sapXepTangTheoDuong();

		System.out.println(htlh);
		System.out.println(htlh2);

		System.out.println("So luong quan: "+htlh.demSLQuan("QuAn 1"));
		System.out.println("So luong quan: "+htlh2.demSLQuan("Quan 3"));

	}

}
