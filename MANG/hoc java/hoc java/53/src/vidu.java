import java.util.Arrays;
public class vidu {
	public static void main(String[] args) {
		int [] mang1= {1,2,3};
		//coppy mang
//		int[] mang1_a = mang1;
//		mang1_a[0]=100;
//		System.out.println(Arrays.toString(mang1));
//		System.out.println(Arrays.toString(mang1_a));
		
		//copy mang bang ham clone
//		int[] mang1_b=mang1.clone();
//		mang1_b[0]=100;
//		System.out.println(Arrays.toString(mang1));
//		System.out.println(Arrays.toString(mang1_b));
		
		//copy mang bang system.arraycopy
		int[] mang1_c= new int[mang1.length];
		
		System.arraycopy(mang1,0, mang1_c, 0, mang1.length);
		mang1_c[0]=90;
		System.out.println(Arrays.toString(mang1));
		System.out.println(Arrays.toString(mang1_c));
	}
}
