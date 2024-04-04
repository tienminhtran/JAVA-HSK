package bai12.Module02;

public class CDList {
	private CD[] ArrCD;
	private int count;// số lượng pt hiện có trong mảng ArrCD

	/**
	 * 
	 * @param n kích thước mảng cần cấp phát cho ArrCD
	 */
	public CDList(int n) {
		ArrCD = new CD[n];
		count = 0;
	}

	/**
	 * thêm phần tử vào mảng ArrCD
	 */

	public void AddCDList(CD a) throws Exception {
		if (count < ArrCD.length)
			ArrCD[count++] = a;
		else {
			throw new Exception("Vượt quá kích thước mảng");
		}
	}

	public int getLength() {
		return count;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i < count; i++) {
			s = s + ArrCD[i];
		}

		return s;
	}

	public void xoaMaCD(int maXoa) throws Exception {
		for (int i = 0; i < count; i++) {
			if (ArrCD[i].getMaCD() == maXoa) {
				for (int j = i; j < count - 1; j++) {
					ArrCD[j] = ArrCD[j + 1];
				}
				count--;
				return;
			}
		}
		throw new Exception("Khong tim thay ma CD ");
	}

	/**
	 * return trả về tổng thành tiền
	 */
	public double tinhTongThanhTien() {
		double s = 0;
		for (int i = 0; i < count; i++) {
			s = s + ArrCD[i].getGiaThanh();
		}
		return s;
	}

	public boolean timKiemMaCD(int maTim) {
		for (int i = 0; i < count; i++)
			if (ArrCD[i].getMaCD() == maTim) {
				return true;
			}
		return false;
	}
	
	public void sapXepGiamGiaThanh() {
		CD index;
		for (int i = 0; i < count; i++) {
			for (int j = i+1; j < count; j++) {
				if(ArrCD[i].getGiaThanh() < ArrCD[j].getGiaThanh())
				{
					index = ArrCD[i];
					ArrCD[i] = ArrCD[j];
					ArrCD[j] = index;
				} 
			}
		}
	}
	public void sapXepTangTuaPhim() {
		CD index;
		for (int i = 0; i < count - 1; i++) {
			for (int j = i+1; j < count; j++) {
				if(ArrCD[i].getTuaCD().compareTo(ArrCD[j].getTuaCD()) > 0) {
					index = ArrCD[i];
					ArrCD[i] = ArrCD[j];
					ArrCD[j] = index;
				}
			}
		}
	}
	
}
