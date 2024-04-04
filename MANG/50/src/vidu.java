
public class vidu {
	public static void main(String[] args) {
	String s1="loideptrai";
	String s2="loideptrai";
	String s3="LOIDEPTRAI";
//	System.out.println(s1.equals(s2));
//	System.out.println(s1.equals(s3));
	
//	System.out.println(s1.equalsIgnoreCase(s2));
//	System.out.println(s1.equalsIgnoreCase(s3));
	String sv1 ="Nguyen van a";
	String sv2 ="Nguyen Van b";
	String sv3 ="Nguyen van";
	String sv4 = "Nguyen VAN A";
	System.out.println(sv1.compareTo(sv2));
	System.out.println(sv1.compareTo(sv3));
	System.out.println(sv1.compareTo(sv4));
	System.out.println(sv1.compareToIgnoreCase(sv4));
	String r1="TITV.vn";
	String r2="TV.vn";
	boolean check = r1.regionMatches(2, r2, 0, 4);
	System.out.println(check);
	
	String oke1="codelearn";
	String oke2="code";
	String oke3="learn";
	System.out.println(oke1.startsWith(oke3));
	System.out.println(oke1.endsWith(oke3));
}	
}
