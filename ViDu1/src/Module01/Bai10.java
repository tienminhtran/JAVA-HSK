package Module01;
//Viết chương trình để đếm số lượng ký tự là số có trong chuỗi s. Chuỗi s được nhập từ bàn phím.
import java.util.Scanner;

public class Bai10 {
	public static void main(String[] args) {
		int count = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("NHap chuoi: ");
		String s = sc.nextLine();
		
		System.out.println("So luong ky tu so trong chuoi: "+ demKyTuSo(s));
	}
	static int demKyTuSo(String s)
	{
		int dem = 0;
		for (int i = 0; i < s.length(); i++) {
			if(Character.isDigit(s.charAt(i)))
			{
				dem++;
			}
		}
		return dem;
	}
}
