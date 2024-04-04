package Bai1;

public class Model {

	private double a;
	private double b;
	private double c;
	private double x1;
	private double x2;

	public Model() {
		// TODO Auto-generated constructor stub
	}

	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}

	public double getC() {
		return c;
	}

	public void setC(double c) {
		this.c = c;
	}

	public double getX1() {
		return x1;
	}

	public void setX1(double x1) {
		this.x1 = x1;
	}

	public double getX2() {
		return x2;
	}

	public void setX2(double x2) {
		this.x2 = x2;
	}

	public void kq() {
		double deta = b*b - 4*a*c;
		this.x1 = (-b - Math.sqrt(deta))/2*a;
		this.x2 = (-b + Math.sqrt(deta))/2*a;
	}

	
}
