package BieuThucChinhQuy_Sach;

import java.util.ArrayList;

public class QLSACH {

	ArrayList<Sach> ds;

	public QLSACH(ArrayList<Sach> ds) {
		super();
		this.ds = ds;
	}

	public ArrayList<Sach> getDs() {
		return ds;
	}
	public QLSACH() {
		ds = new ArrayList<Sach>();
	}
	public boolean them(Sach s) {
		if(!ds.contains(s)) {
			ds.add(s);
			return true;
		}
		return false;
	}
}
