package bai14.Module02;

import java.text.DecimalFormat;

public class Product {
	private String description;// mô tả
	private String productID;// mã sp
	private double price;// giá
	public Product(String description, String productID, double price) {
		this.description = description;
		this.productID = productID;
		this.price = price;
	}
	public Product() {
		this.description = "";
		this.productID = "";
		this.price = 0;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getProductID() {
		return productID;
	}
	public void setProductID(String productID) {
		this.productID = productID;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,###.000");// định dạng thành tiền

		return String.format("%-8s|%-15s|%-15s",productID, description, df.format(price));
	}
	
	

	
}
