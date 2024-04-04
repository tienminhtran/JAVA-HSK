package chuong05.demo;

public class Circle {
	// các thuộc tính:
	private double radius;
	private String color;

	// các hành vi:
	public double getRadius() {
		return radius;
	}

	public String getColor() {
		return color;
	}

	/**
	 * Kiểm tra r phải >0, nếu r<0 thì ném Exception
	 * 
	 * @param r
	 * @throws Exception
	 */
	public void setRadius(double r)  {
		if (r >= 0)
			radius = r;
		
	}

	/**
	 * color không được rỗng (nếu rỗng thì gán giá trị mặc định).
	 * 
	 * @param c
	 * @throws Exception 
	 */
	public void setColor(String c)  {
		
			color = c;
	}

	public Circle() {
		radius = 1;
		color = "red";
	}

	public Circle(double r) {
		this(r, "red");
	}

	/**
	 * nếu r không hợp lệ thì gán mặc định =1
	 * 
	 * @param r , r phải >=0
	 * @param c
	 * @throws Exception
	 */
	public Circle(double r, String c)  {
		setRadius(r);
		setColor(c);
	}

	@Override
	public String toString() {
		return String.format("Radius=%f, Color=%s", radius, color);
	}

	public double tinhDienTich() {
		return Math.PI * radius * radius;
	}
}
