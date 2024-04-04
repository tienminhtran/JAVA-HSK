import java.util.ArrayList;
import java.util.List;

public class test {
	public static void main(String[] args) {
		Student st1= new Student("Loi",19);
		Student st2= new Student("Tien",20);
		Student st3= new Student("oke",21);
		List<Student> liststudent= new ArrayList<>();
		liststudent.add(st1);
		liststudent.add(st2);
		liststudent.add(st3);
		for(int i=0;i<liststudent.size();i++) 
		{
			if(liststudent.get(i).getAge()==19) 
			{
				System.out.println(liststudent.get(i));
			}
		}
		liststudent.stream().filter(p->p.get)
	}
}
