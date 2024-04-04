package bai06.Module03;

import java.util.Arrays;
import java.util.Comparator;

import tranMinhTien.bai04.Sach;
import tranMinhTien.bai04.SachGiaoKhoa;

public class DanhSachHangHoa {
	private HangHoa[] list;
	private int count;

	public HangHoa[] getList() {
		return list;
	}

	public int getCount() {
		return count;
	}

	public DanhSachHangHoa(int n) {

		list = new HangHoa[n];
		this.count = 0;
	}

	/**
	 * kiểm tra trùng mã
	 * 
	 * @return true trùng mã thêm không được false thêm được
	 */
	public boolean trungMa(String ma) {
		for (int i = 0; i < count; i++) {
			if (list[i].getMaHang().compareToIgnoreCase(ma) == 0)
				return true;
		}
		return false;
	}

	/**
	 * thêm hàng hoá
	 * 
	 * @param a
	 * @return true thêm được hh false không thêm được hh
	 */
	public boolean them(HangHoa a) {
		if (count < list.length && !trungMa(a.getMaHang())) {
			list[count++] = a;
			return true;
		} else
			return false;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i < count; i++) {
			s = s + list[i] + "\n";
		}
		return s;
	}
	public DanhSachHangHoa layThongTinHangThucPham() {
		DanhSachHangHoa ds = new DanhSachHangHoa(count);
		for (HangHoa hangHoa : list) {
			if (hangHoa instanceof HangThucPham)
			{
				ds.them(hangHoa);
			}
		}
		return ds;
	}
//	public String layThongTinHangThucPham() {
//		String s = "";
//		for (int i = 0; i < count; i++) {
//			if (list[i] instanceof HangThucPham) {
//				s = s + list[i] + "\n";
//			}
//		}
//		return s;
//	}

	public String layThongTinHangSanhSu() {
		String s = "";
		for (int i = 0; i < count; i++) {
			if (list[i] instanceof HangSanhSu) {
				s = s + list[i] + "\n";
			}
		}
		return s;
	}

	public String layThongTinHangDienMay() {
		String s = "";
		for (int i = 0; i < count; i++) {
			if (list[i] instanceof HangDienMay) {
				s = s + list[i] + "\n";
			}
		}
		return s;
	}

	public HangHoa[] timKiemMaHangHoa(String k) {
		HangHoa[] kqtam = new HangHoa[count];
		int j = 0;
		for (int i = 0; i < count; i++) {
			if (list[i].getMaHang().equalsIgnoreCase(k)) {
				kqtam[j++] = list[i];
			}
		}
		HangHoa kq[] = Arrays.copyOf(kqtam, j);
		return kq;
	}

	public void sapXepTenHangHoaTang() {
		Arrays.sort(list, new Comparator<HangHoa>() {

			@Override
			public int compare(HangHoa o1, HangHoa o2) {
				if (o1 == null || o2 == null) {
					return 0;
				}
				return o1.getTenHang().compareTo(o2.getTenHang());
			}

		});
	}

	public void sapXepSoLuongTonGiam() {
		Arrays.sort(list, new Comparator<HangHoa>() {

			@Override
			public int compare(HangHoa o1, HangHoa o2) {
				if (o1 == null || o2 == null) {
					return 0;
				}
				if (o1.getSoLuongTon() > o2.getSoLuongTon())
					return -1;
				else if (o1.getSoLuongTon() < o2.getSoLuongTon())
					return 1;
				return 0;
			}

		});
	}

	public String layThongTinThucPhamKhoBan() {
		String s = "";
		for (int i = 0; i < count; i++) {
			if ((list[i] instanceof HangThucPham) && list[i].mucDoBuonBan()) {
				s = s + list[i] + "\n";
			}
		}
		return s;
	}

	public int timKiemViTri(String k) {
		for (int i = 0; i < count; i++) {
			if (list[i].getMaHang().compareTo(k) == 0) {
				return i;
			}
		}
		return -1;
	}

	public boolean xoaMaHang(String maHang) {
		int vt = timKiemViTri(maHang);
		if (vt == -1)
			return false;
		for (int i = vt; i < count - 1; i++) {
			list[i] = list[i + 1];

		}
		count--;
		return true;

	}

	public boolean suaThongTin(String maHang, double gia) {
		for (int i = 0; i < count; i++) {
			if (list[i].getMaHang().compareTo(maHang) == 0) {
				list[i].setDonGia(gia);

				return true;
			}
		}
		return false;

	}

	public String getTieuDe() {
		return String.format("|%-10s|%-15s|%-15s|%-12s|%-15s|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|",
				"Ma hang", "Ten hang", "DonGia", "So luong ton", "Nha cung cap", "Ngay san xuat", "Ngay het han",
				"Tg bao hanh", "Cong xuat", "Ngay san xuat", "Ngay nhap kho", "Muc do", "Thanh tien");
	}
}
