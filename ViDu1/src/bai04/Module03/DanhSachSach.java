package bai04.Module03;

import java.util.Arrays;

public class DanhSachSach {
	private Sach[] list;
	private int count;

	public Sach[] getList() {
		return list;
	}

	public int getCount() {
		return count;
	}

	public DanhSachSach(int n) {

		list = new Sach[n];
		this.count = 0;
	}

	public boolean them(Sach s) {
		if (count < list.length) {
			list[count++] = s;
			return true;
		}
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

	public double tinhTongThanhTienSGK() {
		double sum = 0;
		for (int i = 0; i < count; i++) {
			if (list[i] instanceof SachGiaoKhoa) {
				sum = sum + list[i].getThanhTien();
			}
		}
		return sum;
	}

	public double tinhTongThanhTienSTK() {
		double sum = 0;
		for (int i = 0; i < count; i++) {
			if (list[i] instanceof SachThamKhao) {
				sum = sum + list[i].getThanhTien();
			}
		}
		return sum;
	}

	/**
	 * Xuat ra cac sach giao khoa cua nha xuat ban K
	 * 
	 * @param k
	 * @return Sach
	 */
//	public Sach[] xuatSachGiaoKhoa(String k) {
//		Sach[] kq = new Sach[count];
//		int j = 0;
//		for (int i = 0; i < count; i++) {
//			if (list[i] instanceof SachGiaoKhoa)
//				if (list[i].getNhaXuatBan().equalsIgnoreCase(k)) {
//					kq[j++]=list[i];
//				}
//		}
//		return kq;
//	}
	public Sach[] xuatSachGiaoKhoa(String k) {
		Sach[] kqtam = new Sach[count];
		int j = 0;
		for (int i = 0; i < count; i++) {
			if (list[i] instanceof SachGiaoKhoa)
				if (list[i].getNhaXuatBan().equalsIgnoreCase(k)) {
					kqtam[j++] = list[i];
				}
		}
		Sach kq[] = Arrays.copyOf(kqtam, j);
		return kq;
	}
	
	public double tinhThanhTienCaoNhat() {
		double max = 0;
		for (int i = 0; i < count; i++) {
			if (max < list[i].getThanhTien()) {
				max = list[i].getThanhTien();
			}
		}
		return max;
	}
}
