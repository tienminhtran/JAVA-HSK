package chuong03.association;

public class StudentBody {

	public static void main(String[] args) {
		Address add1=new Address("Nguyen Van Bao", "HCM", "VN", "666666");
		Address add2=new Address("Nguyen Thai Son", "HCM", "VN", "666666");
		Student st=new Student("Nguyen", "Van An", add1, add2);
		
		System.out.println(st);
		
	}

}
