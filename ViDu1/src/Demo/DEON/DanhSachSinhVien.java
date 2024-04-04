package Demo.DEON;

public class DanhSachSinhVien {
	private String lopHP;
	private String khoa;
	private SinhVien[] dssv;
	private int count;

	public DanhSachSinhVien(String lopHP, String khoa) {
		setLopHP(lopHP);
		this.khoa = khoa;
		dssv = new SinhVien[20];
		this.count = 0;
	}

	public String getLopHP() {
		return lopHP;
	}

	public void setLopHP(String lopHP) {
		if (!lopHP.trim().equals(""))
			this.lopHP = lopHP;
		else
			this.lopHP = "chua xac dinh";
	}

	public String getKhoa() {
		return khoa;
	}

	public void setKhoa(String khoa) {
		this.khoa = khoa;
	}

	public SinhVien[] getDssv() {
		return dssv;
	}

	public int getCount() {
		return count;
	}

	/**
	 * kiểm tra trùng mã
	 * 
	 * @return true trùng mã thêm không được false thêm được
	 */
	public boolean trungMa(String ma) {
		for (int i = 0; i < count; i++) {
			if (dssv[i].getMaSSV().compareToIgnoreCase(ma) == 0)
				return true;
		}
		return false;
	}

	/**
	 * thêm sinh viên
	 * 
	 * @param a
	 * @return true thêm được sinh viên false không thêm được sinh viên
	 */
	public boolean themSinhVien(SinhVien a) {
		if (count < dssv.length && !trungMa(a.getMaSSV())) {
			dssv[count++] = a;
			return true;
		} else
			return false;
	}

	public void xoaSinhVien(String ma) throws Exception {
		for (int i = 0; i < count; i++) {
			if (dssv[i].getMaSSV().compareToIgnoreCase(ma) == 0) {
				for (int j = i; j < count - 1; j++) {
					dssv[j] = dssv[j + 1];
				}
				count--;
				return;
			}
		}
		throw new Exception("Khong xoa duoc");
	}

	// sapXepSinhVien(): sắp xếp theo tên sinh viên theo thứ tự tăng dần (A, B..Z)
	public void sapXepSinhVien() {
		SinhVien tmp;
		for (int i = 0; i < count; i++) {
			for (int j = i + 1; j < count; j++) {
				if (dssv[i].getTenSV().compareTo(dssv[j].getTenSV()) > 0) {
					tmp = dssv[i];
					dssv[i] = dssv[j];
					dssv[j] = tmp;
				}
			}
		}
	}

	public void sapXepSinhVienTheoMSSV() {
		SinhVien tmp;
		for (int i = 0; i < count; i++) {
			for (int j = i + 1; j < count; j++) {
				if (dssv[i].getMaSSV().compareToIgnoreCase(dssv[j].getMaSSV()) < 0) {
					tmp = dssv[i];
					dssv[i] = dssv[j];
					dssv[j] = tmp;
				}
			}
		}
	}

	public SinhVien timSinhVien(String ma) {
		for (int i = 0; i < count; i++) {
			if (dssv[i].getMaSSV().compareToIgnoreCase(ma) == 0) {
				return dssv[i];
			}
		}
		return null;
	}

//	public SinhVien timSinhVienTB() {
//		SinhVien index = dssv[1];
//		double max = dssv[0].getDiemTB();
//		for (int i = 0; i < count; i++) {
//			if (dssv[i].getDiemTB() > max) {
//				max = dssv[i].getDiemTB();
//				index = dssv[i];
//			}
//		}
//		return index;
//	}
	public SinhVien timSinhVienTBL() {
		SinhVien max = dssv[0];
		for (int i = 0; i < count; i++) {
			if (dssv[i].getDiemTB() > max.getDiemTB()) {
				max = dssv[i];
			}
		}
		return max;
	}

	public SinhVien timSinhVienCoTuoiLon() {
		SinhVien min = dssv[0];
		for (int i = 0; i < count; i++) {
			// 1993 < 2003
			if (dssv[i].getNgaySinh().getYear() < min.getNgaySinh().getYear()) {
				min = dssv[i];
			}
		}
		return min;
	}

	public int demSinhVienDat10() {
		int dem = 0;
		for (int i = 0; i < count; i++) {
			if (dssv[i].getDiemTB() == 10) {
				dem++;
			}

		}
		return dem;
	}

	public int demSinhVienTheoLop() {
		int dem = 0;
		for (int i = 0; i < count; i++) {
			if (lopHP != null) {
				dem++;
			}
		}
		return dem;

	}

	public int demSinhVienNu() {
		int dem = 0;
		for (int i = 0; i < count; i++) {
			if (dssv[i].isGioiTinh() == false) {
				dem++;
			}
		}
		return dem;
	}

	public String toString() {
		String s = "";
		s = s + ("Ten Lop Hoc Phan: " + lopHP);
		s = s + ("\nKhoa: " + khoa);
		s = s + "\n";
		for (int i = 0; i < count; i++) {
			s = s + String.format("%d %s\n", i + 1, dssv[i].toString());
		}
		return s;
	}

}
