import java.util.Scanner;

public class main {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		School school= new School();
		school.add(new HocSinh("Loi", 20, "HN", "A"));
		school.add(new HocSinh("oki", 23, "DN", "B"));
		school.add(new HocSinh("Loi", 23, "HP", "C"));
		school.add(new HocSinh("Loi", 17, "VN", "D"));
		school.display();
		school.getHs20t();
		System.out.println(school.Hocsinh23vaDN());
	}
}
