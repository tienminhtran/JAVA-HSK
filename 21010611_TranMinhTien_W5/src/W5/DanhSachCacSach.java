package W5;

import java.io.Serializable;
import java.util.ArrayList;




public class DanhSachCacSach implements Serializable{
	private ArrayList<Sach> dsSach;

	public DanhSachCacSach() {
		dsSach = new ArrayList<Sach>();
	}

	public DanhSachCacSach(ArrayList<Sach> dsSach) {
		this.dsSach = dsSach;
	}
	
	
	public boolean themSach(Sach s) {
		if(!dsSach.contains(s)) {
			dsSach.add(s);
			return true;
			
		}
		return false;
	}
	
	public ArrayList<Sach> getDsSach() {
		return dsSach;
	}


	public boolean xoaViTri(int vt) {
		if(vt>=0 && vt <= dsSach.size()-1) {
			dsSach.remove(vt);
			return true;
		}return false;
	}
	

	
	public void update(Sach s) {
		this.dsSach.remove(s);
		this.dsSach.add(s);
	}

//
	public int timKiem(String ma) {
		for(int i = 0; i<dsSach.size();i++) {
			if(dsSach.get(i).getMaSach().equalsIgnoreCase(ma))
				return i;
		}
		return -1;
		
	}

	
}
