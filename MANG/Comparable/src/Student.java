
public class Student implements Comparable<Student>{
	String name;
	int age;
	public Student() 
	{	
	}
	public Student(String name,int age) 
	{
		this.name=name;
		this.age=age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
//		return this.getAge()-o.getAge(); dung cho ss so nguyen
		return this.getName().compareTo(o.getName());
		//dung cho String compareto
	}
	
	
}
