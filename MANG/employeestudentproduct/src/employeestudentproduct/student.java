package employeestudentproduct;

import java.util.Scanner;

public class student {
	String rollno;
	String fullname;
	String classname;
	String subject;
	float mark;
	public student(String rollno, String fullname, String classname, String subject, float mark) {
		this.rollno = rollno;
		this.fullname = fullname;
		this.classname = classname;
		this.subject = subject;
		this.mark = mark;
	}
	public static void main(String[] args) {
		int n;
		Scanner sc= new Scanner(System.in);
		n=Integer.parseInt(sc.nextLine());
		student[] st= new student[n];
		for(int i=0;i<st.length;i++) 
		{
			st[i]= new student();
			st[i].input();
		}
	}
	public static void ktdiem(student st2,student st1) 
	{
		if(st1.getMark()>st2.getMark()) 
		{
			st1.display();
		}
		else st2.display();
	}
	public student() {
	}
	public void input() 
	{
		Scanner sc= new Scanner(System.in);
		System.out.println("Nhap rollNo: ");
		rollno=sc.nextLine();
		
		System.out.println("Nhap ten: ");
		fullname=sc.nextLine();
		
		System.out.println("Nhap lop: ");
		classname=sc.nextLine();
		
		System.out.println("Nhap mon hoc: ");
		subject=sc.nextLine();
		
		System.out.println("Nhap diem: ");
		mark=Float.parseFloat(sc.nextLine());
	}
	public void display() 
	{
		System.out.println(toString());
	}
	
	@Override
	public String toString() {
		return "student [rollno=" + rollno + ", fullname=" + fullname + ", classname=" + classname + ", subject="
				+ subject + ", mark=" + mark + "]";
	}
	public String getRollno() {
		return rollno;
	}
	public void setRollno(String rollno) {
		this.rollno = rollno;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public float getMark() {
		return mark;
	}
	public void setMark(float mark) {
		this.mark = mark;
	}
	
}
