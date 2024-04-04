
public class ViDu {
	public static void main(String[] args) {
		String s1 = "tieNtot36";
		String s2 = "@gmail.com";
		String s3 = s1 + s2;

		// hàm concat nối
		String s4 = s1.concat(s2);
		System.out.println("S4: " + s4);
		// hàm replace thay thế
		String s5 = "tientot36@gmail";
		String s6 = s5.replace("tien", "IUH");
		System.out.println("S6: " + s6);
		// toLowerCase => chuyển về viết thường
		// toUpperCase => chuyển về viết hoa
		String s7 = s3.toLowerCase();
		String s8 = s3.toUpperCase();
		System.out.println("s7 = " + s7);
		// trim() => xóa khoảng trắng dư thừa ở đầu chuỗi
		String s9 = "  Xin chào các bạn, mình là TITV.vn    ";
		System.out.println(s9.trim());

		/// subString => cắt chuỗi con
		String s10 = "Xin chào các bạn, mình là TITV.vn";
		String s11 = s10.substring(10);
		String s12 = s10.substring(10, 15);
		System.out.println("s11 = " + s11);
		System.out.println("s12 = " + s12);
	}
}
