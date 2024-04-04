import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class main {
	public static <T> void main(String[] args) {
		List<Student> studentlist= new ArrayList<Student>();
		studentlist.add(new Student("Hai",18));
		studentlist.add(new Student("Abc", 20));
		studentlist.add(new Student("Xyz",19));
		Collections.sort(studentlist );
		for(Student student: studentlist) 
		{
			System.out.println(student);
		}
	}
}
