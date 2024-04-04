package Module01;
//Viết chương trình tìm USCLN của 2 số nhập vào.
import java.util.Scanner;

public class Bai05 {
	public static void main(String[] args) {
		int a, b;
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap a: ");
		a = sc.nextInt();
		System.out.println("Nhap b: ");
		b = sc.nextInt();
		System.out.println("Uoc chung lon nhat cua " + a + " va " + b + ": " + gCD(a, b));
	}

	public static int gCD(int a, int b) {
		if (b == 0)
			return a;
		return gCD(b, a % b); 
	}
//	int tmp;
//    while(b != 0) {
//        tmp = a % b;
//        a = b;
//        b = tmp;
//    }
//    return a;

//	 //Nếu A hoặc B = 0 thì UCLN = A+ B
//    if (A == 0 || B == 0)
//        return A + B;
// 
//   //Lặp cho tới khi A = B
//    while(A != B) {
//        //Lấy số lớn trừ số bé.
//        if (A > B) {
//            A =A - B;
//        }else{
//            B =B - A;
//        }
//    }
//     
//   // Trả về UCLB
//   // Lúc này A = B nên return về A hay B đều giống nhau
//    return A;
}
