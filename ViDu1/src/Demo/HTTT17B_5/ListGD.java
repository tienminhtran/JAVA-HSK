package Demo.HTTT17B_5;

public class ListGD {
	private GiaoDich[] ListGD;
	private int count;

	public ListGD(int n) {
		ListGD = new GiaoDich[n];
		this.count = 0;
	}

	/**
	 * 
	 * @param ma
	 * @return true trùng mà thì không được thêm flase ko trùng mã
	 */
	public boolean timMaTrung(String ma) {
		for (int i = 0; i < count; i++) {
			if (ListGD[i].getMaGiaoDich().equals(ma)) // so sánh trùng
				return true;
		}
		return false;
	}

	public void AddDGList(GiaoDich a) throws Exception {
		if (count < ListGD.length && !timMaTrung(a.getMaGiaoDich())) {
			ListGD[count++] = a;
		} else {
			throw new Exception("Vuot kich thuoc mang");
		}
	}
//	public
	

}
