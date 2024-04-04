package GK2023;

import java.io.Serializable;
import java.util.ArrayList;

public class QuanLy_Phong implements Serializable{
	private ArrayList<Phong> list;

	
	
	public QuanLy_Phong() {
		list = new ArrayList<Phong>();
	}

	public ArrayList<Phong> getList() {
		return list;
	}

	public void setList(ArrayList<Phong> list) {
		this.list = list;
	}
	
	public boolean themPhong(Phong p) {
		if (list.contains(p)) {
			return false;
		}
		list.add(p);
		return true;
	}
	
	
	public boolean xoaPhong(int ma) {
		Phong p = new Phong(ma);
		if (list.contains(p)) {
			list.remove(list.indexOf(p));
			return true;
		}
		return false;
	}
	
	public Phong getPhong(int i) {
		if (i>=0 && i<list.size()) {
			return list.get(i);
		}
		return null;
	}
	
	public int soLuong() {
		return list.size();
	}
}
