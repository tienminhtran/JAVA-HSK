import java.util.Scanner;

public class Employee {
	String fullname;
	String gender;
	String address;
	String position;
	double salary;
	public Employee(String fullname, String gender, String address, String position, double salary) {
		this.fullname = fullname;
		this.gender = gender;
		this.address = address;
		this.position = position;
		this.salary = salary;
	}
	public Employee() {
	}
	public void input() 
	{
		Scanner sc= new Scanner(System.in);
		System.out.println("Nhap ten: ");
		fullname=sc.nextLine();
		
		System.out.println("Nhap gioi tinh: ");
		gender=sc.nextLine();
		
		System.out.println("Nhap dia chi: ");
		address=sc.nextLine();
		
		System.out.println("Nhap chuc vu: ");
		position=sc.nextLine();
		
		System.out.println("Nhap luong: ");
		salary=Float.parseFloat(sc.nextLine());
	}
	public void display() 
	{
		System.out.println(toString());
	}
	@Override
	public String toString() {
		return "Employee [fullname=" + fullname + ", gender=" + gender + ", address=" + address + ", position="
				+ position + ", salary=" + salary + "]";
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
}
