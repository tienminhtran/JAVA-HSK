
/**
 * @author VONG VINH LOI
 *
 */
public class vidu {
	public static void main(String[] args) {
		String s1="Xin chao co chu, xin chao cac ban, Xin chao!";
		String s2="Xin chao";
		String s3="Xin chao 123";
		char c1='o';
		System.out.println(s1.indexOf(s3));
		// su dung vi tri bat dau
		System.out.println(s1.indexOf(s2, 10));
		//tim kiem cha
		System.out.println(s1.indexOf(c1));
		System.out.println(s1.indexOf(c1,20));
		System.out.println(s1.lastIndexOf(s2));
	}
}
