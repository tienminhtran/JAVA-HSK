package Module04.bai06Cach1;

public class PhongMayTinh extends Phong {
	private int mayTinh;

	public PhongMayTinh(String maPhong, String dayNha, double dienTich, int soBongDen, int mayTinh) {
		super(maPhong, dayNha, dienTich, soBongDen);
		this.mayTinh = mayTinh;
	}

	public int getMayTinh() {
		return mayTinh;
	}

	public void setMayTinh(int mayTinh) {
		if (mayTinh > 0)
			this.mayTinh = mayTinh;
		else
			this.mayTinh = 0;
	}

	@Override
	public boolean kiemTRaPhongDatChuan() {
		if (mayTinh > 0 && super.kiemTraDuAnhSach()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return String.format("%s %-20s", super.toString(),
				kiemTRaPhongDatChuan() ? "Co may tinh" : "Khong co may tinh");
	}
}
