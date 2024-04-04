package degk_sanpham;

import java.util.ArrayList;

public class DanhMucSanPham {

	private ArrayList<SanPham> dsSanPham;

	public DanhMucSanPham(ArrayList<SanPham> dsSanPham) {
		super();
		this.dsSanPham = dsSanPham;
	}

	public ArrayList<SanPham> getDsSanPham() {
		return dsSanPham;
	}

	public DanhMucSanPham() {
		dsSanPham = new ArrayList<SanPham>();
	}
	public boolean themSP(SanPham sp) {
		if(!dsSanPham.contains(sp)) {
			dsSanPham.add(sp);
			return true;
		}return false;
	}

}
