package Module01;
//Viết chương trình in ra tổng của 10 số chẵn đầu tiên.
import java.util.Scanner;

public class Bai13 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ket qua 10 so nguyen dau tien: "+ tongSoChan());
		
	}
	public static int tongSoChan() {
		int s = 0;
		for(int i = 0; i<=10;i++) {
			if(i % 2 ==0) {
				s = s + i;
			}
		}
		return s;
	}
}
