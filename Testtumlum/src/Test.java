import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		String s;
		Scanner sc = new Scanner(System.in);
		s = sc.next();
		String s1;
		s1=s.trim();
		if(s1.indexOf(" ") >= 0) {
			int vt = s1.indexOf(" ",0);
			System.out.println(s1.substring(vt+1));
		}
		else {
			System.out.println(s);
		}
	}
}
