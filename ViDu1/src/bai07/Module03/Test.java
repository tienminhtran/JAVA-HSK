package bai07.Module03;

public class Test {
	public static void main(String[] args) {
		Management m = new Management();
		Student s = new Student("Tien", "GC", 8.5, 9);
		Student s1 = new Student("Sinh", "Phu Yen", 9, 9);
		m.them(s);
		m.them(s1);		
		Customer c = new Customer("Nguyen Tai", "HCM", "Phan mem", 5.2, true);
		m.them(c);
		Employee e = new Employee("Nguyen Nam", "HCM",3.5);
		m.them(e);
		System.out.println(m);
		System.out.println("Xoa Nguyen Nam: "+m.xoa("Nguyen Nam"));
		System.out.println(m);
		System.out.println("Xep sep ten: ");
		m.sapXepTheoTenTangDan();
		System.out.println(m);

	}
}
