import java.util.Scanner;

public class Kysu extends Canbo{
	String nganh;

	public Kysu(String fullname, String birthday, String gender, String address,String nganh) {
		super(fullname, birthday, gender, address);
		this.nganh=nganh;
	}

	public Kysu() {
	}

	public String getNganh() {
		return nganh;
	}

	public void setNganh(String nganh) {
		this.nganh = nganh;
	}

	@Override
	public String toString() {
		return super.toString()+", nagnh= "+nganh;
	}
	@Override
	public void input() {
		// TODO Auto-generated method stub
		super.input();
		Scanner sc= new Scanner(System.in);
		System.out.println("Nhap nganh: ");
		nganh=sc.nextLine();
	}
	
}
