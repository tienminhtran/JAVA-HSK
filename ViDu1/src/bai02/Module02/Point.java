package bai02.Module02;

public class Point {

	private double x;
	private double y;

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public Point() {
		x = 0;
		y = 0;
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

	

	public Point negate() {
		Point p = new Point();
		p.x = -x;
		p.y = -y;
		return p;
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
		return String.format("Toa do (%.1f, %.1f) ", this.x, this.y);
				
				
	}

}
