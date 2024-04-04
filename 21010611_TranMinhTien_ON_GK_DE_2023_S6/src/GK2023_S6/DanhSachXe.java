
package GK2023_S6;

import java.io.Serializable;
import java.util.ArrayList;

public class DanhSachXe  implements Serializable{
	private ArrayList<Xe> dsze;

	public DanhSachXe(ArrayList<Xe> dsze) {
		super();
		this.dsze = dsze;
	}

	public ArrayList<Xe> getDsze() {
		return dsze;
	}
	public DanhSachXe() {
		// TODO Auto-generated constructor stub
		dsze = new ArrayList<Xe>();
	}
 
	public boolean them(Xe x) {
		if(!dsze.contains(x)) {
			dsze.add(x);
			return true;
		}
		return false;
	}
	public boolean xoa(int vt) {
		if(vt >=0 && vt<=dsze.size()-1) {
			dsze.remove(vt);
			return true;
		}
		return false;
	}
	public Xe tim(String ma) {
		for (Xe xe : dsze) {
			if(xe.getMa().equals(ma)) {
				return xe;
			}
		}
		return null;
	}
	public void sua(Xe x) {
		dsze.remove(x);
		dsze.add(x);
	}

}
