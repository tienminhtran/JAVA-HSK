package bai10.Module02;
public class Test {
	public static void main(String[] args) {
		SinhVien[] sv = new SinhVien[3];
		sv[0] = new SinhVien("123", "Tran Minh Tien");
		sv[1] = new SinhVien("456", "Nguyen Ngoc Tai");
		sv[2] = new SinhVien("456", "Nguyen Ngoc Tai");

		LopHocPhan lhp = new LopHocPhan("123456","LT Huong doi tuong", "Co Ha", "Thu 7, tiet 4-6",sv);
		System.out.println(lhp.toString());
		System.out.println(sv[0].toString()+sv[1].toString()+sv[2].toString());
		System.out.println("Tong so sinh vien: "+lhp.demSV());
	}
//	public static void inBang() {
//		System.out.println("Danh sach sinh vien: ");
//		for(int i = 0; i<=20;i++) {
//			System.out.print("-");
//		}
//		System.out.println();
//	}
	
}
