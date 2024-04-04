
import java.util.Scanner;

public class text {
	public static void main(String[]args) 
	{
		Scanner sc = new Scanner(System.in);
		String s1 = sc.next();
		String s2 = sc.next();
		String s3 ="";
		for(int i = 0; i<s1.length();i++)
		{
			s3=s3+s1.charAt(i);
		}
		if(s3.equals(s2))
			System.out.println("YES");
		else
		System.out.println("NO");
	}

}