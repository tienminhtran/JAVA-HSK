package chuong03.baiMyPoint;

public class Test {

	public static void main(String[] args) {
		MyPoint p = new MyPoint(3, 6);
		System.out.println(p);
		System.out.println("Khoang cach den toa do goc=" + p.distance());

		System.out.println("Khoang cach den toa do (10,10)=" + p.distance(10, 10));
		
		MyPoint p1=new MyPoint(10, 10);
		System.out.println("Khoang cach den toa do p1="+p1.distance(p));
	}

}
