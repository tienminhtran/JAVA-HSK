package TranMinhTien21010611T3;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;

public class DanhSachNhanVien implements Serializable{
	private ArrayList<NhanVien> dsNhanVien;

	public DanhSachNhanVien() {
		dsNhanVien = new ArrayList<>();
	}

	public DanhSachNhanVien(ArrayList<NhanVien> dsNhanVien) {
		this.dsNhanVien = dsNhanVien;
	}

	public ArrayList<NhanVien> getDsNhanVien() {
		return dsNhanVien;
	}

	// cách 2
	public boolean xoaViTri(int vt) {
		if (vt >= 0 && vt <= dsNhanVien.size() - 1) {
			dsNhanVien.remove(vt);
			return true;
		}
		return false;
	}

	public int timKiem(String ma) {
		for(int i = 0; i<dsNhanVien.size();i++) {
			if(dsNhanVien.get(i).getMaNV().equalsIgnoreCase(ma))
				return i;
		}
		return -1;
	}

	public int tongsoNv() {
		return dsNhanVien.size();
	}


	public void update(NhanVien nv) {
		this.dsNhanVien.remove(nv);
		this.dsNhanVien.add(nv);
	}
	public boolean themNv(NhanVien a) {
		if(!dsNhanVien.contains(a)) {
			dsNhanVien.add(a);
			return true;
		}return false;
	}
}
