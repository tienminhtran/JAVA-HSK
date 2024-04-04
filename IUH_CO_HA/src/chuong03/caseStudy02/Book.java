package chuong03.caseStudy02;

public class Book {
	private String name;
	private Author[] authors;
	private double price;
	private int qty;

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

	public Author[] getAuthors() {
		return authors;
	}

	public Book(String name, Author[] authors, double price) {
		this.name = name;
		this.authors = authors;
		this.price = price;
		this.qty = 0;
	}

	public Book(String name, Author[] authors, double price, int qty) {
		this.name = name;
		this.authors = authors;
		this.price = price;
		this.qty = qty;
	}

	public String getAuthorNames() {
		String s = "";
		for (Author au : authors) {
			s += au.getName() + ",";
		}
		return s;
	}

	@Override
	public String toString() {
		String s = "";
		for (Author au : authors) {
			s += au + ",";
		}
		return String.format("Book[name=%s, authors={%s}, price=%f, qty=%d]", name, s, price, qty);
	}

}
