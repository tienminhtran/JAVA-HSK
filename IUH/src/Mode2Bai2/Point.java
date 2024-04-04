package Mode2Bai2;

public class Point {

	private double x;
	private double y;
	private String name;

	public Point(double x, double y, String name) {
		this.x = x;
		this.y = y;
		this.name = name;
	}

	public Point() {
		x = 0;
		y = 0;
		name = "";
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String negate() {
		if (this.x > 0 && this.y > 0) {
			return String.format("%f,%f", -getX(), -getY());
		} else if (this.x > 0 && this.y < 0) {
			return String.format("%f,%f", -getX(), Math.abs(getY()));
		} else if (this.x < 0 && this.y < 0) {
			return String.format("%f,%f", Math.abs(getX()), Math.abs(getY()));
		} else {
			return String.format("%f,%f", Math.abs(getX()), -getY());
		}
	}
//	public void m() {
//		this.x = -x;
//		this.y = -y;
//	}

	public double getDistance() {
		return Math.sqrt(this.x * this.x + this.y * this.y);
	}

	@Override
	public String toString() {
		return String.format("Toa do %s(%f, %f) co %s va khoang cach tu goc O: %.2f: ", this.name, this.x, this.y,
				negate(), getDistance());

	}

}
