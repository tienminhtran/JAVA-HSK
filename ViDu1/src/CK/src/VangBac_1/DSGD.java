package VangBac_1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DSGD {
	public List<GiaoDich> ds;

	// không tích trong CONTRUCTOR
	public DSGD() {
		ds = new ArrayList<>();
	}

	public List<GiaoDich> getDs() {
		return ds;
	}

	public void setDs(List<GiaoDich> ds) {
		this.ds = ds;
	}

	public boolean themGD(GiaoDich gd) {
		if (!ds.contains(gd)) {
			ds.add(gd);
			return true;
		}
		return false;
	}

	public boolean xoaGD(String ma) {
		return ds.removeIf(p -> p.getMaGiaoDich().equalsIgnoreCase(ma));
	}

	public void sapXepTangDanMa() {
		Collections.sort(ds, new Comparator<GiaoDich>() {
			@Override
			public int compare(GiaoDich o1, GiaoDich o2) {
				if (o1 == null || o2 == null) {
					return -1;
				}
				return o1.getMaGiaoDich().compareTo(o2.getMaGiaoDich());

			}
		});
	}

	// CẬP NHẬT CHA
	public boolean capNhatGiaGD(String ma, double gia) {
		for (GiaoDich a : ds) {
			if (a.getMaGiaoDich().equalsIgnoreCase(ma)) {
				a.setDonGia(gia);
				return true;
			}
		}
		return false;
	}

	// CẬP NHẬT CON SO CARAT
	public boolean capNhatSoCARAT(String ma, double socara) {
		for (GiaoDich a : ds) {
			if (a instanceof Giaodichdaquy) {
				if (a.getMaGiaoDich().equalsIgnoreCase(ma)) {
					((Giaodichdaquy) a).setSoCarat(socara);
					return true;
				}

			}
		}
		return false;
	}

	// XUẤT TOÀN BỘ
	public DSGD layThongTin() {
		DSGD kq = new DSGD();

		for (GiaoDich giaoDich : ds) {
			if (giaoDich.getNgayGiaoDich() == LocalDate.of(2021, 12, 25)) {
				kq.themGD(giaoDich);
			}
		}
		return kq;
	}

	@Override
	public String toString() {
		String s = "";
		for (GiaoDich giaoDich : ds) {
			s = s + giaoDich + "\n";
		}
		return s;

	}

	// tìm kiếm mã giao dịch
	public DSGD timKiemMa(String ma) {
		DSGD kq = new DSGD();
		for (GiaoDich giaoDich : ds) {
			if (giaoDich.getMaGiaoDich().equalsIgnoreCase(ma)) {
				kq.themGD(giaoDich);
			}
		}
		return kq;
	}

}
