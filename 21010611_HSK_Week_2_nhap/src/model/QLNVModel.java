package model;

import java.util.ArrayList;

public class QLNVModel {

	private ArrayList<NhanVien> dsNhanVien;
	
	public QLNVModel() {
		dsNhanVien = new ArrayList<>();
	}
	public QLNVModel(ArrayList<NhanVien> dsNhanVien) {
		this.dsNhanVien = dsNhanVien;
	}
	public ArrayList<NhanVien> getDsNhanVien() {
		return dsNhanVien;
	}
	public void setDsNhanVien(ArrayList<NhanVien> dsNhanVien) {
		this.dsNhanVien = dsNhanVien;
	}

	public boolean insert(NhanVien a) {
		if(dsNhanVien.contains(a)) // check trùng mã
		{
			return false;
		}
		this.dsNhanVien.add(a);
		return true;
	}
	public void remove(NhanVien a) {
		this.dsNhanVien.remove(a);
	}
	// hàm ghi thêm thôi
	public void update(NhanVien a) {
		this.dsNhanVien.remove(a);
		this.dsNhanVien.add(a);

	}
	public NhanVien tim(int matim) {
		NhanVien nv = new NhanVien(matim);
		if(dsNhanVien.contains(nv))
		{
			return dsNhanVien.get(dsNhanVien.indexOf(nv));
		}
		return null;
	}
}
