package chuong03.caseStudy01;

public class Book {
	private String name;
	private Author author;
	private double price;
	private int qty;

	public Book() {
		name="xxx";
		author=new Author();
		price=0;
		qty=0;
	}

	public Book(String name, Author author, double price) {
		this.name = name;
		this.author = author;
		this.price = price;
		this.qty = 0;
	}

	public Book(String name, Author author, double price, int qty) {
		this.name = name;
		this.author = author;
		this.price = price;
		this.qty = qty;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String getName() {
		return name;
	}

	public Author getAuthor() {
		return author;
	}

	@Override
	public String toString() {
		return String.format("Book[name=%s,Author%s,price=%f,qty=%d]", name, author, price, qty);
	}
}
