package bai02.Module02;
public class Test {
	public static void main(String[] args) {
		Point p = new Point(3, 2);
		System.out.println("Toa do diem" + p);
		System.out.println("Diem doi xung cua " +p+ " la: "+ p.negate());
		System.out.printf("Khoang cach tu dem %s den O: %.2f", p, p.getDistance());
	}
}
