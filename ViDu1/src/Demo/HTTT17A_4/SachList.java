package Demo.HTTT17A_4;

import java.text.DecimalFormat;

public class SachList {
	private Sach[] ArrSach;
	private int count;

	/**
	 * 
	 * @param n kích thước mảng cần cấp phát
	 * @return
	 */
	public SachList(int n) {
		ArrSach = new Sach[n];
		this.count = 0;
	}

	public boolean timMaTrung(String ma) {
		for (int i = 0; i < count; i++) {
			if (ArrSach[i].getMaNguoiMuon().equals(ma)) // so sánh trùng
				return true;
		}
		return false;
	}

	public void AddSachList(Sach a) 
			//throws Exception 
	{
		if (count < ArrSach.length && !timMaTrung(a.getMaNguoiMuon())) {
			ArrSach[count++] = a;
		} else {
//			throw new Exception("Vuot kich thuoc mang");
		}
	}

	public boolean AddSach(Sach a) {
		if (count < ArrSach.length && !timMaTrung(a.getMaNguoiMuon())) {
			ArrSach[count++] = a;
			return true;
		} else {
			return false;
		}
	}

	public Sach timKiemNguoiMuon(String ma) throws Exception {
		for (int i = 0; i < count; i++) {
			if (ArrSach[i].getMaNguoiMuon().equals(ma))
				return ArrSach[i];
		}
		throw new Exception("Khong tim thay");
	}

	public Sach getDanhSachMuon50000() throws Exception {
		for (int i = 0; i < count; i++) {
			if (ArrSach[i].tinhTienThueSach() > 50000) {
				return ArrSach[i];
			} else
				throw new Exception("Khong tim thay nguoi muon co tien >50000");

		}
		return null;
	}

	public void sapXepGiamDanTien() {
	Sach tmp;
		for (int i = 0; i < count - 1; i++) {
			for (int j = i + 1; j < count; j++) {
				if (ArrSach[i].tinhTienThueSach() < ArrSach[j].tinhTienThueSach()) {	
					
					tmp = ArrSach[i];
					ArrSach[i] = ArrSach[j];
					ArrSach[j] = tmp;
				}
			}
		}
	}
	


	public String toString() {
		String s = "";
		for (int i = 0; i < count; i++) {
			s = s + ArrSach[i];
		}
		return s;
	}

}
