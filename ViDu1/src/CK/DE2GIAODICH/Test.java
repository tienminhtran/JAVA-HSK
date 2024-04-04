package CK.DE2GIAODICH;

import java.time.LocalDate;

public class Test {

	public static void main(String[] args) {
		DanhSachGiaoDich list=new DanhSachGiaoDich();
		list.them(new GiaoDichDaQuy("A001", LocalDate.of(2019,12,3), 100000.3,"Kim cương",100));
		list.them(new GiaoDichDaQuy("C002", LocalDate.of(2019,12,3), 200000,"Cẩm thạch",100));
		list.them(new GiaoDichVang("B003", LocalDate.of(2019,12,4), 30000, "9999",200,"Vàng"));
		list.them(new GiaoDichVang("D004", LocalDate.of(2021,12,25), 300000, "999",200,"Vàng"));
		list.them(new GiaoDichVang("F005", LocalDate.of(2021,12,25), 400000, "99",200,"Vàng"));
		System.out.println(list);
		list.xoaGD("A001");
		System.out.println(list);
		
		list.sapXepTang();
		
		System.out.println(list);
		DanhSachGiaoDich ds = list.xuatGD();
		System.out.println(ds);
	}

}
