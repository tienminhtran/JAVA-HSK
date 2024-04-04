package NHANVIENNOINGOAI;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class DSNhanVien {

	private List<NhanVien> ds;

	public DSNhanVien() {
		ds = new ArrayList<>();
	}

	public List<NhanVien> getDs() {
		return ds;
	}

	public boolean trungMa(String ma) {
		for (NhanVien nhanVien : ds) {
			if (nhanVien.getMaNhanVien().equalsIgnoreCase(ma)) {
				return true;
			}
		}
		return false;
	}

	public boolean themNV(NhanVien a) {
		if (!ds.contains(a.getMaNhanVien()) && !trungMa(a.getMaNhanVien())) {
			ds.add(a);
			return true;
		}
		return false;
	}

	public int getSoLuong() {
		return ds.size();
	}

	public double tinhTienAn() {

		double s = 0;
		for (NhanVien nhanVien : ds) {
			s = s + nhanVien.tienAn();
		}
		return s;
	}

	public void sapXepTangDanTheoTen() {
		Collections.sort(ds, new Comparator<NhanVien>() {

			@Override
			public int compare(NhanVien o1, NhanVien o2) {
				if (o1 == null || o2 == null)
					return -1;
				else
					return o1.getTenNhanVien().compareTo(o2.getTenNhanVien());
			}

		});
	}

	public void sapXepGiamTheoGiaSuatAn() {
		Collections.sort(ds, new Comparator<NhanVien>() {

			@Override
			public int compare(NhanVien o1, NhanVien o2) {
				if (o1 == null || o2 == null) {
					return -1;
				} else {
					Integer d1 = new Integer(o1.getSoSuatAn());
					Integer d2 = new Integer(o2.getSoSuatAn());
					return d2.compareTo(d1);
				}
			}

		});
	}

	public DSNhanVien layThongTinNVNoi() {
		DSNhanVien kq = new DSNhanVien();
		for (NhanVien nhanVien : ds) {
			if (nhanVien instanceof NhanVienNoi) {
				kq.themNV(nhanVien);
			}
		}
		return kq;
	}

	public double tinhTienAnTrungBinhNVNoi() {
		double s = 0;
		int dem = 0;
		DSNhanVien kq = new DSNhanVien();
		for (NhanVien nhanVien : ds) {
			if (nhanVien instanceof NhanVienNoi) {
				dem = dem + 1;
				s = s + nhanVien.tienAn();
			}
		}
		return s / dem;
	}

	public NhanVien timMaNV(String ma) {
		for (NhanVien nhanVien : ds) {
			if (nhanVien.getMaNhanVien().equalsIgnoreCase(ma)) {
				return nhanVien;
			}
		}
		return null;
	}

	public DSNhanVien timKiemDSCoSuatAnCN() {
		DSNhanVien kq = new DSNhanVien();
		for (NhanVien nhanVien : ds) {
			if (nhanVien instanceof NhanVienNoi) {
				if (((NhanVienNoi) nhanVien).isLoaiXuatAn() == true) {
					kq.themNV(nhanVien);
				}
			}
		}
		return kq;
	}

	public DSNhanVien layDanhSachNVCoSuatAnLon20() {
		DSNhanVien kq = new DSNhanVien();
		for (NhanVien nhanVien : ds) {
			if (nhanVien.getSoSuatAn() > 20) {
				kq.themNV(nhanVien);
			}
		}
		return kq;
	}

	public DSNhanVien layDanhSachNVSN2000() {
		DSNhanVien kq = new DSNhanVien();
		for (NhanVien nhanVien : ds) {
			if (nhanVien.getNgaySinh().getYear() == 2000) {
				kq.themNV(nhanVien);
			}
		}
		return kq;
	}

	public void capNhapSoXuatAnNVTheoMa(String ma, int soxa) {
		for (NhanVien nhanVien : ds) {
			if (nhanVien.getMaNhanVien().equalsIgnoreCase(ma)) {
				nhanVien.setSoSuatAn(soxa);
			}
		}
	}
	
	public boolean capNhatDiaChiNhanVienNgoai(String ma, String dc)
	{
		for (NhanVien nhanVien : ds) {
			if(nhanVien instanceof NhanVienNgoai)
			{
				if(nhanVien.getMaNhanVien().equalsIgnoreCase(ma))
				{
					nhanVien.setDiaChi(dc);
					return true;
				}
			}
		}
		return false;
	}

	public boolean xoaNhanVienTheoMa(String ma)
	{
		return ds.removeIf(p->p.getMaNhanVien().equalsIgnoreCase(ma));
	}
	
	public boolean xoaNhanVienCoSuatAn10()
	{
		List<NhanVien> kq = new ArrayList<NhanVien>();
		for (NhanVien nhanVien : ds) {
			if(nhanVien.getSoSuatAn()==10)
			{
				kq.add(nhanVien);
			}
		}
		return ds.removeAll(kq);
	}
	@Override
	public String toString() {
		String s = "";
		for (NhanVien nhanVien : ds) {
			s = s + nhanVien + "\n";
		}
		return s;
	}

}
