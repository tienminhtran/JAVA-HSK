package entity;

import java.util.ArrayList;

public class Congty {

	private ArrayList<PhongBan> dspb;

	public Congty() {
		super();
		this.dspb =new ArrayList<PhongBan>();
	}

	public ArrayList<PhongBan> getDspb() {
		return dspb;
	}

	public void themPhongBna(PhongBan pb) {
		dspb.add(pb);
	}
}
