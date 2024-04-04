import java.util.ArrayList;
import java.util.List;

public class School {
	private List<HocSinh> students;
	public School() 
	{
		this.students=new ArrayList<>();
	}
	public void add(HocSinh student) 
	{
		this.students.add(student);
	}
	public void getHs20t() 
	{
		for(int i=0;i<students.size();i++) 
		{
			if(this.students.get(i).getAge()==20) 
			{
				System.out.println(students.get(i).toString());
			}
		}
	}
	public int Hocsinh23vaDN() 
	{
		int count=0;
		for (HocSinh hocSinh : students) {
			if(hocSinh.getAge()==23&&hocSinh.getHometown().equals("DN")) 
			{
				count++;
			}
		}
		return count;
	}
	public void display() 
	{
		students.forEach(st1 ->System.out.println(st1));
	}
}
