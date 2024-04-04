package Bai01;

import java.awt.List;
import java.util.ArrayList;
import java.util.Iterator;

public class QLNVModel {

	private ArrayList<NhanVien> dsNhanVien;

	public QLNVModel() {
		dsNhanVien = new ArrayList<NhanVien>();
	}

	public QLNVModel(ArrayList<NhanVien> dsNhanVien) {
		this.dsNhanVien = dsNhanVien;
	}

	public ArrayList<NhanVien> getDsNhanVien() {
		return dsNhanVien;
	}

	public boolean insert(NhanVien a) {
		for (int i = 0; i < dsNhanVien.size(); i++) {
			if (dsNhanVien.get(i).getMaNV() == a.getMaNV()) // check trùng mã
			{
				return false;
			}
		}
		this.dsNhanVien.add(a);
		return true;
	}



	public boolean removeNV(int ma) {
		NhanVien nv = new NhanVien(ma);
		if (dsNhanVien.contains(nv)) {
			dsNhanVien.remove(nv);
			return true;
		}
		return false;
	}

	public void update(NhanVien a) {
		this.dsNhanVien.remove(a);
		this.dsNhanVien.add(a);

	}

	public NhanVien tim(int matim) {
		NhanVien nv = new NhanVien(matim);
		if (dsNhanVien.contains(nv)) {
			return dsNhanVien.get(dsNhanVien.indexOf(nv));
		}
		return null;
	}
}
