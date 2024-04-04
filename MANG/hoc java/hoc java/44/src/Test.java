
public class Test {
	public static void main(String[] args) {
		Toado td1= new Toado(5, 5);
		Toado td2= new Toado(7, 9);
		Toado td3= new Toado(12, 1);
		Hinh h1= new Diem(td1);
		Hinh h2=new HinhTron(td2, 10);
		Hinh h3= new HinhChuNhat(td3, 5, 10);
		System.out.println("DT1: "+h1.tinhdientich());
		System.out.println("DT2: "+h2.tinhdientich());
		System.out.println("DT3: "+h3.tinhdientich());
				
	}
}
