package chuong03.caseStudy03;

public class Test {

	public static void main(String[] args) {
		try {
			PolyLine po=new PolyLine(10);
			po.appendPoint(6, 4);
			po.appendPoint(new Point(10, 10));
			po.appendPoint(100, 4);
			po.appendPoint(3,8);
			System.out.println(po);
			System.out.println("so phan tu hien tai:"+po.getLength());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
