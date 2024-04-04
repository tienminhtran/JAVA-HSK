package bai14.Module02;

import java.text.DecimalFormat;

public class OrderDetail {
	static int dem = 0;
	private int quatity; // số lượng
	private Product product;// sản phẩm

	public OrderDetail(int quatity, Product product) {
		setQuatity(quatity);
		setProduct(product);
	}

	public OrderDetail() {
		this.quatity = 0;
		product = new Product();

	}

	public int getQuatity() {
		return quatity;
	}

	public void setQuatity(int quatity) {
		if (quatity >= 0 && quatity <= 20)
			this.quatity = quatity;
		else
			this.quatity = 9999;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public double calcTotalPrice() {
		return this.quatity * this.product.getPrice();
	}

	@Override
	public String toString() {
		dem++;
		DecimalFormat df = new DecimalFormat("#,###.000VND");// định dạng thành tiền
		return String.format("%-5d|%-38s|%-15d|%-15s|",
				dem,product, quatity, df.format(calcTotalPrice()));
	}

}
