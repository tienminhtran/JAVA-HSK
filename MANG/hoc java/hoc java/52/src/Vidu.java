
public class Vidu {
	public static void main(String[] args) {
		String s1= "tItv";
		String s2= ".Vn";
		String s3=s1+s2;
		String s4= s1.concat(s2);
		System.out.println(s4);
		String t1="Cod3l3an";
//		String t2=t1.replace('3','e');
		String t2= t1.replaceAll("Cod3","code");
		String s5="Tung.vn";
		System.out.println(t2);
		String s6=s5.replaceAll("Tung","TITV");
		String s9="   Xin chao cac ban    ";
		System.out.println(s9.trim());
		System.out.println(s5.substring(0,2));
	}
}
