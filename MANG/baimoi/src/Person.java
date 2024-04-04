import java.util.Scanner;

public class Person {
	String name;
	String gender;
	String birtday;
	String address;
	public Person() {
	}
	public Person(String name, String gender, String birtday, String address) {
		this.name = name;
		this.gender = gender;
		this.birtday = birtday;
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirtday() {
		return birtday;
	}
	public void setBirtday(String birtday) {
		this.birtday = birtday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void inputInfo() 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap vao ten: ");
		name=sc.nextLine();
		System.out.println("Nhap gioi tinh: ");
		gender= sc.nextLine();
		System.out.println("Nhap ngay sinh: ");
		birtday= sc.nextLine();
		System.out.println("Nhap dia chi: ");
		address=sc.next();
	}
	public void showInfo() 
	{
		System.out.println("In ra ten: "+this.name);
		System.out.println("In gioi tinh: "+this.gender);
		System.out.println("In ngay sinh: "+this.birtday);
		System.out.println("In dia chi: "+this.address);
	}
}
