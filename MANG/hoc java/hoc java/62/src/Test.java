import java.util.Stack;
import java.util.Scanner;
public class Test {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		Stack<String> stackchuoi= new Stack<String>();
		stackchuoi.push("Giai Tri");//=) dua gia tri vao stack
//		System.out.println(stackchuoi.pop());
//		System.out.println(stackchuoi.peek());
//		stackchuoi.clear();
//		System.out.println(stackchuoi.contains("Giai Tri"));
		//Vi du dao nguoc chuoi
		System.out.println("Nhap vao chuoi");
//		String s= sc.nextLine();
//		//TITV
//		for(int i=0;i<s.length();i++) 
//		{
//			stackchuoi.push(s.charAt(i)+"");
//		}
//		for(int i=0;i<s.length();i++) 
//		{
//			System.out.print(stackchuoi.pop());
//		}
		//vi du chuyen tu he thap phan sang nhi phan
		System.out.println("Nhap 1 so nguyen duong tu ban phim: ");
		int x= sc.nextInt();
		Stack<String> nhiphan= new Stack<String>();
		while(x>0) 
		{
			int sodu= x%2;
			nhiphan.push(sodu+"");
			x=x/2;
		}
		int n=nhiphan.size();
		for(int i=0;i<n;i++) 
		{
			System.out.print(nhiphan.pop());
		}
		
		
		
	}
}
