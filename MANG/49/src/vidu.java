import java.util.Scanner;
public class vidu {
	public static void main(String[] args) {
	Scanner sc= new Scanner(System.in);
	String s;
	System.out.print("Nhap vao chuoi: ");
	s=sc.nextLine();
	// ham length
//	System.out.println(s.length());
//	System.out.println(s.charAt(0));
//	int dodai= s.length();
//	for(int i=0;i<dodai;i++) 
//	{
//		System.out.print(s.charAt(i)+" ");
//	}
	//s.getchars(vi tri bat dau, vi tri ket thuc)
	//mang luu du lieu, vi tri bat dau luu cua mang)
	char[] arraychar= new char[100];
	s.getChars(2, 4, arraychar, 10);
	for(int i=0;i<arraychar.length;i++) {
		System.out.println(arraychar[i]);
	}
}
}