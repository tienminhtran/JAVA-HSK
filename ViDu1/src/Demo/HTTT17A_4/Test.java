package Demo.HTTT17A_4;

public class Test {

	public static void main(String[] args) {

//			Sach s1 = new Sach("AB2", "Nguyen Van C", "CoNan", "TR", 10);
//			Sach s3 = new Sach("Th3", "Nguyen Van E", "Sach phieu luu", "AB", -2);
//			System.out.println(s1);
//			System.out.println(s3);

		Sach s0 = new Sach("Th2", "Nguyen Van A", "Sach phieu luu", "KN", 45);
		Sach s = new Sach("Th1", "Nguyen Van B", "Sach phieu luu", "KN", 2);
		Sach s1 = new Sach("Th4", "Nguyen Van C", "CoNan", "TR", 10);
		Sach s2 = new Sach("Th5", "Nguyen Van D", "Sach Doi Song", "KN", 12);
		Sach s3 = new Sach("Th3", "Nguyen Van E", "Sach phieu luu", "KN", 9);
//		System.out.println(s);
//		System.out.println(s1);
//		System.out.println(s2);
//		System.out.println(s3);
		SachList sl = new SachList(10);
//			sl.AddSachList(s0);
//			sl.AddSachList(s1);
//			sl.AddSachList(s2);
//			sl.AddSachList(s3);			
//			sl.AddSachList(s);
		sl.AddSach(s0);
		sl.AddSach(s);
		sl.AddSach(s1);
		sl.AddSach(s2);			
		sl.AddSach(s3);
//			System.out.println(sl);
//			System.out.println("Tim kiem ma nguoi muon:\n" + sl.timKiemNguoiMuon("Th3"));
//			System.out.println("Tim kiem ma nguoi muon: \n"+sl.timKiemNguoiMuon("Th9"));
//			System.out.print("DS nguoi muon >50000:" + sl.getDanhSachMuon50000());
		System.out.println("\nSap xep giam theo tien: ");
		sl.sapXepGiamDanTien();
		System.out.println(sl);

	}
}
