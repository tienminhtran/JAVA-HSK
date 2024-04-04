package chuong03.baiCircle;

public class Test {

	public static void main(String[] args) {
		try {
			Circle c2 = new Circle(6, "blue");
			System.out.println(c2);
			System.out.println("dien tich=" + c2.tinhDienTich());

			c2.setRadius(-10);
			System.out.println(c2);
			System.out.println("dien tich=" + c2.tinhDienTich());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
