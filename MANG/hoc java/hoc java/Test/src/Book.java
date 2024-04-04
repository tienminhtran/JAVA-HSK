
public class Book {
	private String name;
	private int code;
	private double price;
	private String brand;
	public Book(String name, int code, double price, String brand) {
		this.name = name;
		this.code = code;
		this.price = price;
		this.brand = brand;
	}
	
	public Book() {
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	@Override
	public String toString() {
		return String.format("%10s%2d%10f%15s", name,code,price,brand);
//		return "Book [name=" + name + ", code=" + code + ", price=" + price + ", brand=" + brand + "]";
	}
	
}
