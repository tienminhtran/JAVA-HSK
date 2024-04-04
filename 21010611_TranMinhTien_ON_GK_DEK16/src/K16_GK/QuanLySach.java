package K16_GK;

import java.io.Serializable;
import java.util.ArrayList;

public class QuanLySach  implements Serializable{

	private ArrayList<Sach> ds;

	public ArrayList<Sach> getDs() {
		return ds;
	}

	public QuanLySach(ArrayList<Sach> ds) {
		super();
		this.ds = ds;
	}

	public QuanLySach() {
		ds = new ArrayList<Sach>();
	}

	public boolean themSach(Sach s) {
		if(!ds.contains(s)) {
			ds.add(s);
			return true;
			
		}
			
		return false;
	}
	public boolean xoaSach(int vt) {
		if(vt>=0 && vt<=ds.size()-1) {
			ds.remove(vt);
			return true;
		}return false;
	}
	public Sach timSach(String matim) {
		for (Sach sach : ds) {
			if(sach.getMaSach().compareToIgnoreCase(matim)==0) {
				return sach;
			}
		}
		return null;
	}
}
