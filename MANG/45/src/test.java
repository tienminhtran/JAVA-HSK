
public class test {
	public static void main(String[] args) {
		Hangsanxuat h1= new Hangsanxuat("Hang 1","Viet Nam");
		Hangsanxuat h2= new Hangsanxuat("Hang 2","USA");
		Hangsanxuat h3= new Hangsanxuat("Hang 3","Nhat ban");
		Phuongtiendichuyen p1= new Maybay("May bay",h1,"Dau diexen");
		Phuongtiendichuyen p2= new Xedap("Xe Dap",h2);
		Phuongtiendichuyen p3= new Xeoto("Xe oto",h3,"Dau oto");
		System.out.println(p1.getTenloaiphuongtien());
	}
}
