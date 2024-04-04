package HOMEEX;

import java.io.Serializable;
import java.util.ArrayList;

public class DanhSachQuocGia implements Serializable{

	private ArrayList<QuocGia> dsQuocGia;

	public ArrayList<QuocGia> getDsQuocGia() {
		return dsQuocGia;
	}

	public DanhSachQuocGia(ArrayList<QuocGia> dsQuocGia) {
		this.dsQuocGia = dsQuocGia;
	}

	public DanhSachQuocGia() {
		dsQuocGia = new ArrayList<QuocGia>();		
	}
	public boolean them(QuocGia qg) {
		if(!dsQuocGia.contains(qg)) {
			dsQuocGia.add(qg);
			return true;
		}return false;
	}
	public void update(QuocGia qg) {
		dsQuocGia.remove(qg);
		dsQuocGia.add(qg);
	}
	public boolean xoavitri(int vt) {
		if(vt>=0 && vt<=dsQuocGia.size()-1) {
			dsQuocGia.remove(vt);
			return true;
		}
		return false;
	}
	public QuocGia timKiem(String matp) {
		for (QuocGia quocGia : dsQuocGia) {
			if(quocGia.getCountry().compareToIgnoreCase(matp)==0) {
				return quocGia;
			}
			
		}
		return null;
		
	}
}
