package TranMinhTien_21010611_W2_3;

import java.util.ArrayList;

public class DanhSachNhanVien {
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

//	public boolean themNv(NhanVien a) {
//		for (int i = 0; i < dsNhanVien.size(); i++) {
//			if (dsNhanVien.get(i).getMaNV().equalsIgnoreCase(a.getMaNV())) // check trùng mã
//			{
//				return false;
//			}
//		}
//		this.dsNhanVien.add(a);
//		return true;
//	}
	public boolean themNv(NhanVien a) {
		if (!dsNhanVien.contains(a)) // check trùng mã
		{
			this.dsNhanVien.add(a);
			return true;
		}
		return false;
	}
	

	// cách 1
	public boolean removeNV(String ma) {
		NhanVien nv = new NhanVien(ma);
		if (dsNhanVien.contains(nv)) {
			dsNhanVien.remove(nv);
			return true;
		}
		return false;
	}

	// cách 2
	public boolean xoaViTri(int vt) {
		if (vt >= 0 && vt <= dsNhanVien.size() - 1) {
			dsNhanVien.remove(vt);
			return true;
		}
		return false;
	}

	public boolean capnhat(String maNV, String ho, String ten, int tuoi, String phai, double tienLuong) {
		NhanVien nv_new = new NhanVien(maNV, ho, ten, tuoi, phai, tienLuong);
		if (dsNhanVien.contains(nv_new)) {
			nv_new.setMaNV(maNV);
			nv_new.setHo(ho);
			nv_new.setTen(ten);
			nv_new.setTuoi(tuoi);
			nv_new.setPhai(phai);
			nv_new.setTienLuong(tienLuong);
			return true;
		}
		return false;
	}

//	public boolean timKiem(String matim) {
//		NhanVien nv = new NhanVien(matim);
//		if(dsNhanVien.contains(nv))
//		{
//			return true;
//		}return false;
//	}
//	public NhanVien timkiem(String matim) {
//		for (NhanVien nhanVien : dsNhanVien) {
//			if(nhanVien.getMaNV().equals(matim))
//			{
//				return nhanVien;
//			}
//		}
//		return null;
//		
//	}

	public NhanVien timkiem(String ma) {
		for (NhanVien nhanVien : dsNhanVien) {
			if (nhanVien.getMaNV().equals(ma)) {
				return nhanVien;
			}
		}
		return null;
	}

//	public int tongsoNv() {
//		return dsNhanVien.size();
//	}
//
//	public NhanVien getNV(int i) {
//		if (i >= 0 && i < dsNhanVien.size())
//			return dsNhanVien.get(i);
//		return null;
//	}

	public void update(NhanVien nv) {
		this.dsNhanVien.remove(nv);
		this.dsNhanVien.add(nv);
	}
}
