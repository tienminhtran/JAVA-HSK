package chuong03.baiCircle;

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
	public void setRadius(double r) throws Exception {
		if (r >= 0)
			radius = r;
		else
			throw new Exception("Lỗi: bán kính là số âm");
	}

	/**
	 * color không được rỗng (nếu rỗng thì gán giá trị mặc định).
	 * 
	 * @param c
	 * @throws Exception 
	 */
	public void setColor(String c) throws Exception {
		if (c.trim().equals(""))
			throw new Exception("Lỗi: color bị rỗng");
		else
			color = c;
	}

	public Circle() {
		radius = 1;
		color = "red";
	}

	public Circle(double r) throws Exception {
		this(r, "red");
	}

	/**
	 * nếu r không hợp lệ thì gán mặc định =1
	 * 
	 * @param r , r phải >=0
	 * @param c
	 * @throws Exception
	 */
	public Circle(double r, String c) throws Exception {
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
