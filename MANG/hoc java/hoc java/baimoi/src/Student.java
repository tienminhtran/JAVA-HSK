import java.util.Scanner;

public class Student extends Person {
	String rollNo;
	float mark;
	String email;
	public Student() {
	}
	public String getRollNo() {
		return rollNo;
	}
	public boolean setRollNo(String rollNo) {
		if(rollNo!=null&&rollNo.length()==8) 
		{
			this.rollNo = rollNo;
			return true;
		}
		else 
		{
			System.out.println("Nhap lai ma sinh vien!");
			return false;
		}
	}
	public float getMark() {
		return mark;
	}
	public boolean setMark(float mark) {
		if(mark>=0&&mark<=10) 
		{
			this.mark = mark;
			return true;
		}
		else 
		{
			System.out.println("Nhap Lai diem!");
			return false;
		}
		
	}
	public String getEmail() {
		return email;
	}
	public boolean setEmail(String email) {
		if(email!=null&& email.contains("@")&& !email.contains(" ")) 
		{
			this.email = email;	
			return true;
		}
		else
		{
			System.out.println("Nhap lai dia chi email!");
			return false;
		}
		
		
	}
	@Override
	public void inputInfo() {
		super.inputInfo();
		Scanner sc= new Scanner(System.in);
		System.out.println("Nhap ma sinh vien: ");
		while(true) 
		{
			String rollNoInput= sc.next();
			if(this.setRollNo(rollNoInput)) 
			{
				break;
			}
		}
		System.out.println("Nhap diem sinh vien: ");
		sc.nextLine();
		while(true) 
		{
			float markinput= sc.nextFloat();
			if(setMark(markinput)) 
			{
				break;
			}
		}
		sc.nextLine();
		System.out.println("Nhap email Sinh vien: ");
		while(true) 
		{
			String emailinput=sc.nextLine();
			if(setEmail(emailinput)) 
			{
				break;
			}
		}	 
	}
	public boolean checkScholarship() 
	{
		return mark>=8?true:false;
	}
}
