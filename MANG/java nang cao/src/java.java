import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class java {
 public static void main(String[] args) {
	 Scanner sc= new Scanner(System.in);
	 int arr[]= new int[] {1,2,3,4};
	 int c = Arrays.stream(arr).reduce(
		 (x,y)->x+y).getAsInt();
	 System.out.println(c);
}
}
