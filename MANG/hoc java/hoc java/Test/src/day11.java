import java.util.Arrays;
import java.util.List;


public class day11 {
	
	public List<Student> getlist()
	{
		Student s1= new Student("nguyen van a",20);
		Student s2= new Student("nguyen van b",20);
		Student s3= new Student("nguyen van c",20);
		Student s4= new Student("nguyen van d",20);
		
		return list;
	}
	public static void main(String[] args) {
		day11 oke= new day11();
		List<Student> list= oke.getlist();
		list.remove(0);
		for (Student student : list) {
			System.out.println(student);
		}
	}
}
