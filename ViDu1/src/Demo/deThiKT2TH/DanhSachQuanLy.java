package Demo.deThiKT2TH;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DanhSachQuanLy {

	private List<Sap> ds;

	public DanhSachQuanLy() {
		ds = new ArrayList<>();
	}

	public List<Sap> getDs() {
		return ds;
	}

	public boolean trungMa(String ma) {
		for (Sap sap : ds) {
			if (sap.getMaSap().compareToIgnoreCase(ma) == 0) {
				return true;
			}
		}
		return false;
	}

	public boolean them(Sap a) {
		if (!ds.contains(a.getMaSap()) && !trungMa(a.getMaSap())) {
			ds.add(a);
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		String s = "";
		for (Sap sap : ds) {
			s = s + sap + "\n";
		}
		return s;
	}

	public DanhSachQuanLy timKiemMa(String ma) {
		DanhSachQuanLy kq = new DanhSachQuanLy();
		for (Sap sap : ds) {
			if (sap.getMaSap().compareToIgnoreCase(ma) == 0) {
				kq.them(sap);
			}
		}
		return kq;
	}

	public Sap timKiemMaSap(String ma) {
		for (Sap sap : ds) {
			if (sap.getMaSap().compareToIgnoreCase(ma) == 0) {
				return sap;
			}
		}
		return null;
	}

	public int demSoLuongSapThucPham() {
		int dem = 0;
		for (Sap sap : ds) {
			if (sap instanceof SapThucPham) {
				dem = dem + 1;
			}
		}
		return dem;
	}

	public DanhSachQuanLy xuatDanhSachSap10112022() {
		DanhSachQuanLy kq = new DanhSachQuanLy();
		for (Sap sap : ds) {
			if (sap.getNgayThanhLap().isEqual(LocalDate.of(2022, 11, 10))) {
				kq.them(sap);
			}
		}
		return kq;
	}

	public double timMax() {
		double max = ds.get(0).getDoanhThu();
		for (Sap sap : ds) {
			if (sap.getDoanhThu() > max) {
				max = sap.getDoanhThu();
			}
		}
		return max;
	}

	public DanhSachQuanLy timDoanhThuMax() {
		DanhSachQuanLy kq = new DanhSachQuanLy();
		for (Sap sap : ds) {
			if (sap.getDoanhThu() == timMax()) {
				kq.them(sap);
			}
		}
		return kq;
	}

	public boolean xoaSap(String ma) {
		return ds.removeIf(p -> p.getMaSap().compareToIgnoreCase(ma) == 0);
	}

	public boolean capNhapPhiDongLanh(String ma, double phi) {
		for (Sap sap : ds) {
			if (sap instanceof SapThucPham) {
				if (sap.getMaSap().compareToIgnoreCase(ma) == 0) {
					((SapThucPham) sap).setPhiDichVuDongLanh(phi);
					return true;
				}
			}
		}
		return false;
	}

	public List<Sap> sapXepDoanhThu() {
		List<Sap> kq = new ArrayList<Sap>();
		kq.addAll(ds);
		Collections.sort(kq, new Comparator<Sap>() {

			@Override
			public int compare(Sap o1, Sap o2) {
				Double d1 = new Double(o1.getDoanhThu());
				Double d2 = new Double(o2.getDoanhThu());
				return d1.compareTo(d2);
			}
		});
		return kq;
	}
	
	public List<Sap> sapXepTheoMa(){
		List<Sap> kq = new ArrayList<Sap>();
		kq.addAll(ds);
		Collections.sort(kq, new Comparator<Sap>() {

			@Override
			public int compare(Sap o1, Sap o2) {
				if(o1 == null || o2==null)
					return -1;
				else
				return o1.getMaSap().compareTo(o2.getMaSap());
			}
			
		});
		return kq;
	}

}
