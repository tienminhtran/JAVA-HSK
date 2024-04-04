package ONGK;

import java.io.Serializable;
import java.util.ArrayList;

public class DachSachSinhVien implements Serializable{

	private ArrayList<SinhVien>dsSinhVien;

	public ArrayList<SinhVien> getDsSinhVien() {
		return dsSinhVien;
	}

	public DachSachSinhVien(ArrayList<SinhVien> dsSinhVien) {
		this.dsSinhVien = dsSinhVien;
	}

	public DachSachSinhVien() {
		dsSinhVien = new ArrayList<SinhVien>();
	}


	public boolean themSinhVien(SinhVien sv) {
		if(!dsSinhVien.contains(sv)) {
			dsSinhVien.add(sv);
			return true;
		}
		return false;
	}
	
	public boolean xoaVT(int vt) {
		if(vt>=0 && vt<=dsSinhVien.size()-1) {
			dsSinhVien.remove(vt);
			return true;
		}
		return false;
	}
	public void sua(SinhVien sv) {
		dsSinhVien.add(sv);
		dsSinhVien.remove(sv);
	}
}
