package bai13.Module02;



public class DanhSachCongNhan {
	private CongNhan[] dsCongNhan;
	private int count;

	public DanhSachCongNhan(int n) {
		dsCongNhan = new CongNhan[n];
		this.count = 0;
	}

	/**
	 * thêm danh sách công nhân
	 */

	public void themDanhSach(CongNhan a) throws Exception {
		if (count < dsCongNhan.length)
			dsCongNhan[count++] = a;
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
			s = s + dsCongNhan[i];
		}

		return s;
	}

	/**
	 * 
	 * @param mHo
	 * @param mTen
	 * @throws Exception Phương thức xóa công nhân khi biết mã.
	 */
	public void xoaCongNhan(String mHo, String mTen) throws Exception {
		for (int i = 0; i < count; i++) {
			if (dsCongNhan[i].getmHo().equals(mHo) && dsCongNhan[i].getmTen().equals(mTen)) {
				for (int j = i; j < count - 1; j++) {
					dsCongNhan[j] = dsCongNhan[j + 1];
				}
				count--;
				return;
			}
		}
		throw new Exception("Khong tim thay ma CD ");
	}

	public String inTieuDe() {
		return String.format("|%-15s|%-15s|%-10s|%-10s|", "Ho CN", "Ten CN", "So SP", "Luong");
	}

	public String xuatThongTinCN() {
		String tam = "";
		for (int i = 0; i < count; i++) {
			tam = tam + dsCongNhan[i].toString();
		}
		return tam;
	}

	public String layDanhSachCN() {
		String tam = "";
		for (int i = 0; i < count; i++) {
			if (dsCongNhan[i].getmSoSP() > 200) {
				tam = tam + dsCongNhan[i].toString();
			}
		}
		return tam;
	}
	
	public void sapXepGiamSP() {
		CongNhan index;
		for (int i = 0; i < count; i++) {
			for (int j = i+1; j < count; j++) {
				if(dsCongNhan[i].getmSoSP() <dsCongNhan[j].getmSoSP())
				{
					index = dsCongNhan[i];
					dsCongNhan[i] = dsCongNhan[j];
					dsCongNhan[j] = index;
				} 
			}
		}
	}
}
