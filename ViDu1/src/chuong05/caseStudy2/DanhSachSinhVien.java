package chuong05.caseStudy2;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class DanhSachSinhVien {
	private Set<SinhVien> danhSach;

	public Set<SinhVien> getDanhSach() {
		return danhSach;
	}

	public int getLength() {
		return danhSach.size();
	}

	public DanhSachSinhVien() {
		danhSach = new HashSet<SinhVien>();
	}

	public boolean themSV(SinhVien sv) {
		return danhSach.add(sv);
	}

	@Override
	public String toString() {
		String s = "";
		for (SinhVien sinhVien : danhSach) {
			s += sinhVien + "\n";
		}
		return s;
	}

	/**
	 * 
	 * @param ma
	 * @return true neu xoa duoc
	 */
	public boolean xoaSV(int ma) {
		// cach 1:
		SinhVien sv_xoa = new SinhVien(ma, "", 0);
		return danhSach.remove(sv_xoa);

		// cach 2:
//		return danhSach.removeIf(sv -> sv.getMa() == ma);
	}

//
	public boolean xoaSVTheoNamSinh(int ns) {
//		// cach 1:
//		Set<SinhVien> dsXoa = new HashSet<SinhVien>();
//		for (SinhVien sinhVien : danhSach) {
//			if (sinhVien.getNamSinh() == ns)
//				dsXoa.add(sinhVien);
//		}
//		return danhSach.removeAll(dsXoa);

//		 cach 2:
		return danhSach.removeIf(sv -> sv.getNamSinh() == ns);
	}

//
	public boolean sua(int ma, String ten_moi, int namSinh_moi) {
		for (SinhVien sinhVien : danhSach) {
			if (sinhVien.getMa() == ma) {
				sinhVien.setHoTen(ten_moi);
				sinhVien.setNamSinh(namSinh_moi);
				return true;
			}
		}
		return false;
	}

//
	public SinhVien tim(int ma) {
		for (SinhVien sinhVien : danhSach)
			if (sinhVien.getMa() == ma)
				return sinhVien;
		return null;
	}
//
	public DanhSachSinhVien tim(String hoten) {
		DanhSachSinhVien kq = new DanhSachSinhVien();
		for (SinhVien sinhVien : danhSach) {
			if (sinhVien.getHoTen().contains(hoten))
				kq.themSV(sinhVien);
		}
		return kq;
	}
//
	public DanhSachSinhVien sapXepTheoMaTangDan() {
		return null;
		//tu lam:
		//chuyen danhSach qua kiểu lưu trữ là List
		//sap List
		//tra ve ket qua	
//		Collections.sort(danhSach, new Comparator<SinhVien>() {
//
//			@Override
//			public int compare(SinhVien o1, SinhVien o2) {
//				Integer m1=new Integer(o1.getMa());
//				Integer m2=new Integer(o2.getMa());
//				return m1.compareTo(m2);
//			}
//		});
	}

}
