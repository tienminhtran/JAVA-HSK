import java.util.Scanner;

public class NVphucvu  extends Canbo{
String congviec;

public NVphucvu(String fullname, String birthday, String gender, String address, String congviec) {
	super(fullname, birthday, gender, address);
	this.congviec = congviec;
}

public NVphucvu() {
}

public String getCongviec() {
	return congviec;
}

public void setCongviec(String congviec) {
	this.congviec = congviec;
}
	
@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+",Cong viec= "+congviec;
	}
@Override
	public void input() {
		// TODO Auto-generated method stub
		super.input();
		Scanner sc= new Scanner(System.in);
		System.out.println("Nhap cong viec: ");
		congviec=sc.nextLine();
	}
}
