package bai14.Module02;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Order {
	private int orderID; // mã đơn hàng
	private LocalDate orderDate; // ngày
	private OrderDetail[] lineItem; // chi tiết đơn hàng
	private int count;

	public Order(int orderID, LocalDate orderDate) {
		setOrderID(orderID);
		setOrderDate(orderDate);
		lineItem = new OrderDetail[100]; // mặc dù đề k yêu cầu như vẫn khởi tạo
		count = 0;
	}



	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		if (orderID > 0)
			this.orderID = orderID;
		else
			this.orderID = 99999;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		if (orderDate.isBefore(LocalDate.now())) // ngày lập hoá đơn = ngày hiện tại
			this.orderDate = orderDate;
		else
			this.orderDate = LocalDate.now();
	}

	public OrderDetail[] getLineItem() {
		return lineItem;
	}

	public void setLineItem(OrderDetail[] lineItem) {
		this.lineItem = lineItem;
	}

	/**
	 * 
	 * @return tổng thành tiền hoá đơn
	 */
	public double calcTotalCharge() {
		double s = 0;
		for (int i = 0; i < count; i++)
			s = s + lineItem[i].calcTotalPrice();
		return s;
	}

	public void addLineItem(Product p, int x) throws Exception {
		if (count < lineItem.length)
			lineItem[count++] = new OrderDetail(x, p);
		else {
			throw new Exception("Loi kich thuoc mang! ");
		}
	}

	public String layTieuDe() {
		return String.format("%-5s|%-8s|%-15s|%-15s|%-15s|%-15s|", "STT", "Ma SP", "Mo ta", "Don gia", "So luong",
				"Thanh tien");
	}

	public String inThongTinHD() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return  String.format("Ma HD: %d\nNgay lap hoa don: %s\n", orderID, dtf.format(orderDate));
	}
	public String toString() {
		String s = "";
		for (int i = 0; i < count; i++) {
			s = s + lineItem[i]+"\n";
		}
		return s;
	}
}
