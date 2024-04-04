package TranMinhTien21010611T3;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;

public class DanhSachNhanVien implements Serializable{
	private ArrayList<NhanVien> dsNhanVien;

	public DanhSachNhanVien() {
		dsNhanVien = new ArrayList<>();
	}

	public DanhSachNhanVien(ArrayList<NhanVien> dsNhanVien) {
		this.dsNhanVien = dsNhanVien;
	}

	public ArrayList<NhanVien> getDsNhanVien() {
		return dsNhanVien;
	}


	public boolean them

}
