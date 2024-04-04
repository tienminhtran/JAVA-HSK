package OK16_LAMLAI;

import java.io.Serializable;
import java.util.ArrayList;

public class DanhSachSach implements Serializable {
	private ArrayList<Sach> dsSachs;

	public ArrayList<Sach> getDsSachs() {
		return dsSachs;
	}

	public void setDsSachs(ArrayList<Sach> dsSachs) {
		this.dsSachs = dsSachs;
	}

	public DanhSachSach(ArrayList<Sach> dsSachs) {
		super();
		this.dsSachs = dsSachs;
	}

	public DanhSachSach() {
		dsSachs = new ArrayList<Sach>();
		
	}
	public boolean themSach(Sach s) {
		if(!dsSachs.contains(s)) {
			dsSachs.add(s);
			return true;
		}
		return false;
	}
	public boolean xoaSach(int vt ) {
		if(vt>=0 & vt<=dsSachs.size()-1) {
			dsSachs.remove(vt);
			return true;
		}
		return false;
	}

	public Sach tim(String ma) {
		for (Sach sach : dsSachs) {
			if(sach.getMaSach().compareToIgnoreCase(ma)==0) {
				return sach;
			}
			
		}return null;
	}

}
