package chuong05.caseStudy1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DanhSachSinhVien {
	private List<SinhVien> danhSach;

	public List<SinhVien> getDanhSach() {
		return danhSach;
	}

	public int getLength() {
		return danhSach.size();
	}

	public DanhSachSinhVien() {
		danhSach = new ArrayList<SinhVien>();
	}

	public boolean themSV(SinhVien sv) {
		if (danhSach.contains(sv))
			return false;
		danhSach.add(sv);
		return true;
	}

	/**
	 * 
	 * @param ma
	 * @return true neu xoa duoc
	 */
	public boolean xoaSV(int ma) {
		// cach 1:
//		SinhVien sv_xoa = new SinhVien(ma, "", 0);
//		return danhSach.remove(sv_xoa);

		// cach 2:
		return danhSach.removeIf(sv -> sv.getMa() == ma);
	}

	public boolean xoaSVTheoNamSinh(int ns) {
		// cach 1:
		List<SinhVien> dsXoa = new ArrayList<SinhVien>();
		for (SinhVien sinhVien : danhSach) {
			if (sinhVien.getNamSinh() == ns)
				dsXoa.add(sinhVien);
		}
		return danhSach.removeAll(dsXoa);

		// cach 2:
//		return danhSach.removeIf(sv->sv.getNamSinh()==ns);
	}

	public boolean sua(int ma, String ten_moi, int namSinh_moi) {
		SinhVien temp = new SinhVien(ma, "", 0);
		if (!danhSach.contains(temp))
			return false;

		SinhVien sv_sua = danhSach.get(danhSach.indexOf(temp));
		sv_sua.setHoTen(ten_moi);
		sv_sua.setNamSinh(namSinh_moi);
		return true;
	}

	public SinhVien tim(int ma) {
		SinhVien sv = new SinhVien(ma, "", 0);
		if (danhSach.indexOf(sv) == -1)
			return null;
		return danhSach.get(danhSach.indexOf(sv));
	}

	public DanhSachSinhVien tim(String hoten) {
		DanhSachSinhVien kq = new DanhSachSinhVien();
		for (SinhVien sinhVien : danhSach) {
			if (sinhVien.getHoTen().contains(hoten))
				kq.themSV(sinhVien);
		}
		return kq;
	}

	public void sapXepTheoMaTangDan() {
		Collections.sort(danhSach, new Comparator<SinhVien>() {

			@Override
			public int compare(SinhVien o1, SinhVien o2) {
				Integer m1=new Integer(o1.getMa());
				Integer m2=new Integer(o2.getMa());
				return m1.compareTo(m2);
			}
		});
	}

	@Override
	public String toString() {
		String s = "";
		for (SinhVien sinhVien : danhSach) {
			s += sinhVien + "\n";
		}
		return s;
	}
}
