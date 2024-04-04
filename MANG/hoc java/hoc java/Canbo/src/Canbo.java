import java.util.Scanner;

public class Canbo {
	String fullname, birthday,gender,address;

	public Canbo(String fullname, String birthday, String gender, String address) {
		super();
		this.fullname = fullname;
		this.birthday = birthday;
		this.gender = gender;
		this.address = address;
	}
	public Canbo() {
	}
	@Override
	public String toString() {
		return "Canbo [fullname=" + fullname + ", birthday=" + birthday + ", gender=" + gender + ", address=" + address;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
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
	public void display() 
	{
		System.out.println(this);
	}
	public void input() 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Nhap ten: ");
		fullname=sc.nextLine();
		System.out.println("Nhap ngay sinh: ");
		birthday=sc.nextLine();
		System.out.println("Nhap gioi tinh: ");
		gender=sc.nextLine();
		System.out.println("Nhap dia chi: ");
		address=sc.nextLine();
		
	}
		
}
