package bai14.Module02;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Test {
	public static void main(String[] args) throws Exception {
		DecimalFormat df = new DecimalFormat("#,###.000VND");// định dạng thành tiền
		LocalDate ngay = LocalDate.of(2016, 12, 25);
		Order or = new Order(1, ngay);
		Product pr = new Product("nuoc tuong", "sp1", 8.000);
		Product pr2 = new Product("Gao", "sp2", 18.000);
		Product pr3 = new Product("Duong", "sp3", 10.000);
		Product pr4 = new Product("Dau an", "sp4", 12.000);
		or.addLineItem(pr, 10);
		or.addLineItem(pr2, 5);
		or.addLineItem(pr3, 1);
		or.addLineItem(pr4, 2);
		System.out.println(or.inThongTinHD());
		System.out.println(or.layTieuDe());
		System.out.println(or.toString());
		System.out.println("Tong tien thanh toan: "+df.format(or.calcTotalCharge()));
	}
}
