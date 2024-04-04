package Demo.KTMP17A_S4;

public class HeThongLienHe {
	private String tenHeThong;
	private String loaiHang;
	private ThongTinLienHe[] dsLienHe;
	private int count;



	public HeThongLienHe(String tenHeThong, String loaiHang) {
		this.tenHeThong = tenHeThong;
		this.loaiHang = loaiHang;
		dsLienHe = new ThongTinLienHe[50];
		this.count = 0;
	}

	public String getTenHeThong() {
		return tenHeThong;
	}

	public String getLoaiHang() {
		return loaiHang;
	}


	public ThongTinLienHe[] getDsLienHe() {
		return dsLienHe;
	}

	
	public int getCount() {
		return count;
	}
	

	/**
	 * thêm thông tin liên hệ
	 * @param đối tương truyền vào 
	 * @return true thêm thành công
	 * false không thêm được
	 */
	public boolean them(ThongTinLienHe a) {
		if (count < dsLienHe.length) {
			dsLienHe[count++] = a;
			return true;
		} else
			return false;
	}
	/**
	 * in ra thongtinlienhe
	 */
	public void sapXepTangTheoDuong() {
		ThongTinLienHe tmp;
		for (int i = 0; i < count; i++) {
			for (int j = i + 1; j < count; j++) {
				if (dsLienHe[i].getDuong().compareTo(dsLienHe[j].getDuong()) > 0) {
					tmp = dsLienHe[i];
					dsLienHe[i] = dsLienHe[j];
					dsLienHe[j] = tmp;
				}
			}
		}
	}
	/**
	 * tinh so luong quan
	 * @param quan
	 * @return so luong quan
	 */
	public int demSLQuan(String quan)
	{
		int dem = 0;
		for(int i = 0; i< count; i++)
		{
			if(dsLienHe[i].getQuan().compareToIgnoreCase(quan)==0)
			{ 
				dem++;
			}
		}
		return dem;
	}
	@Override
	public String toString() {
		String s = "";
		s +=("Ten he thong: \n"+tenHeThong);
		s += ("Loai dich vu: \n"+loaiHang);
		s += "\n";
		for (int i = 0; i < count; i++) {
			s = s + String.format("%d %s", i + 1, dsLienHe[i].toString());
		}
		return s;
	}

}
