import java.util.Scanner;

public class Conhnhan extends Canbo {
	public static final int bac_max=7;
	public int bac;
	public Conhnhan(String fullname, String birthday, String gender, String address, int bac) {
		super(fullname, birthday, gender, address);
		this.bac = bac;
	}
	public int getBac() {
		return bac;
	}
	public Conhnhan() {
	}
	public void setBac(int bac) {
		this.bac = bac;
	}
	@Override
	public String toString() {
		return super.toString()+", bac="+bac;
	}
	@Override
	public void input() {
		super.input();
		Scanner sc= new Scanner(System.in);
		System.out.println("Nhap bac cong nhan: ");
		this.bac=Integer.parseInt(sc.nextLine());
	}
}
