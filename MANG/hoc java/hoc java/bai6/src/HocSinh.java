
public class HocSinh {
	private String name;
	private int age;
	private String hometown;
	private String classstudent;
	public HocSinh(String name, int age, String hometown, String classstudent) {
		this.name = name;
		this.age = age;
		this.hometown = hometown;
		this.classstudent = classstudent;
	}
	public HocSinh() {
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
	public String getHometown() {
		return hometown;
	}
	public void setHometown(String hometown) {
		this.hometown = hometown;
	}
	public String getClassstudent() {
		return classstudent;
	}
	public void setClassstudent(String classstudent) {
		this.classstudent = classstudent;
	}
	@Override
	public String toString() {
		return "HocSinh [name=" + name + ", age=" + age + ", hometown=" + hometown + ", classstudent=" + classstudent
				+ "]";
	}
	
}
