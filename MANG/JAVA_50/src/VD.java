
public class VD {
	public static void main(String[] args) {
		String s1 = "titv.vn";
		String s2 = "TITV.VN";
		String s3 = "titv.vn";
		// ------------------equals so sanh do dai phân biệt hoa thg
		System.out.println("equals: " + s1.equals(s3));
		System.out.println("equals: " + s1.equals(s2));
		// -------------------equalsIgnoreCase: so sanh do dai không phân biệt hoa thg
		System.out.println("equalsIgnoreCase(: " + s1.equalsIgnoreCase(s3));
		System.out.println("equalsIgnoreCase(: " + s1.equalsIgnoreCase(s2));
		// -------------------compareTo: so sanh > < =
		String sv1 = "Nguyễn Văn A";
		String sv2 = "Nguyễn Văn B";
		String sv3 = "Nguyễn Văn";
		String sv4 = "Nguyễn Văn A";

		System.out.println("SV1 compareTo  SV3: " + sv1.compareTo(sv3));
		System.out.println("SV1 compareTo  SV2: " + sv1.compareTo(sv2));
		System.out.println("SV1 compareTo  SV4: " + sv1.compareTo(sv4));

		// --------------------compareToIgnoreCase: Tương tự compareTo những KHÔNG BIỆT
		// HOA THG
		String r1 = "TITV.VN";
		String r2 = "TV.V";
		boolean check = r1.regionMatches(2, r2, 0, 4);
		System.out.println("SO SANH " + check);
		// ---------------------starWith kiểm tra chuổi bắt đầu
		String sdt = "037456789";
		System.out.println(sdt.startsWith("037"));
		System.out.println(sdt.startsWith("034"));
		// ---------------------Hàm endWith => Hàm kiểm tra chuỗi kết thúc bằng ...
		String tenFile = "I love you.JPG";
		String tenFile2 = "Hoc Java.PDF";

		if (tenFile.endsWith(".JPG")) {
			System.out.println("File 1 là hình ảnh!");
		} else if (tenFile.endsWith(".PDF")) {
			System.out.println("File 1 là file PDF!");
		}
		if (tenFile2.endsWith(".JPG")) {
			System.out.println("File 2 là hình ảnh!");
		} else if (tenFile2.endsWith(".PDF")) {
			System.out.println("File 2 là file PDF!");
		}

	}
}
