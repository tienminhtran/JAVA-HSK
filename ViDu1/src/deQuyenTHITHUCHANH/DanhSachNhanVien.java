package deQuyenTHITHUCHANH;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/*
 * Xoá: 'boolean (MA) ->REMOVEIF', void, BOOLEAN (DOI TUONG Nhan vien a) -> remove
 * Them: ham add
 * TK: boolean -> contains, 'nhanvien'
 * SS: void: 
 * LayThongtin: Danh sach:
 * Sửa: 'boolean', void: 
 */
public class DanhSachNhanVien {
	private List<NhanVien> ds;

	public DanhSachNhanVien() {
		this.ds = new ArrayList<NhanVien>();
	}
	
	public int getLength() {
		return ds.size();
	}
	
	public boolean themNV(NhanVien nv) {
		if(ds.contains(nv))
			
			return false;
		else {
			ds.add(nv);
			return true;
		}
	}
	
	public boolean xoaNV(String ma) {
		return ds.removeIf(nv->nv.getMaNV()==ma);
	}
	
	public boolean sua(String ma, String tenMoi) {
		for (NhanVien nhanVien : ds) {
			if(nhanVien.getMaNV().equalsIgnoreCase(ma)) {
				nhanVien.setTenNV(tenMoi);
				return true;
			}
		}
		return false;
	}
	
	public static String getTieuDe() {
		return String.format("%-10s%10s%14s%20s%14s%14s  %20s  %10s", "Ma NV","Ten NV","Ngay Sinh","Dia Chi","So Suat An","Gia Suat An","Loai Suat An  / Thue", "Tien An");
	}
	
	@Override
	public String toString() {
		String str = "";
		for (NhanVien nhanVien : ds) {
			str+="\n"+nhanVien;
		}
		return str;
	}
	
	
}
