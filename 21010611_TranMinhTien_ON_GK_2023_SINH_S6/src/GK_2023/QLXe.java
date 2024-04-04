package GK_2023;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class QLXe implements Serializable{
	private List<Xe> ds;
	
	public QLXe() {
		ds = new ArrayList<Xe>();
		// TODO Auto-generated constructor stub
	}
	
	
	public List<Xe> getDs() {
		return ds;
	}


	public boolean them(Xe x) {
		for (int i = 0; i < ds.size(); i++) {
			if(ds.get(i).getMa().equals(x.getMa())) {
				return false;
			}
		}
		ds.add(x);
		return true;
	}
	
	public boolean xoa(int index) {
		if(index >= 0 && index <= ds.size()-1) {
			ds.remove(index);
			return true;
		}
		return false;
	}
	
	public Xe timKiem(String maTim) {
		for (Xe xe : ds) {
			if(xe.getMa().equals(maTim)) {
				return xe;
			}
		}
		return null;
	}
}
