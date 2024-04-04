package Thong;

import java.io.Serializable;
import java.util.ArrayList;

public class DsNhanVien implements Serializable {
	private ArrayList<NhanVien> ds;

	public ArrayList<NhanVien> getDs() {
		return ds;
	}

	public DsNhanVien() {
		ds = new ArrayList<NhanVien>();
	}

	public boolean them(NhanVien nv) {
		if (ds != null) {
			for (NhanVien nhanVien : ds) {
				if (nhanVien.getMaNV().equalsIgnoreCase(nv.getMaNV())) {
					return false;
				}
			}
		}
		ds.add(nv);
		return true;
	}

	public boolean xoa(int index) {
		if ((index >= 0 && index < ds.size())) {
			ds.remove(index);
			return true;
		}
		return false;
	}

	public NhanVien tim(String maNV) {
		for (NhanVien nhanVien : ds) {
			if (nhanVien.getMaNV().equalsIgnoreCase(maNV)) {
				return nhanVien;
			}
		}
		return null;
	}

}
