package CK.DE2GIAODICH;

import java.time.LocalDate;

public abstract class GiaoDich {
	protected String maGD;
	protected LocalDate ngayGD;
	protected double donGia;
	
	public GiaoDich(String maGD, LocalDate ngayGD, double donGia) {
		this.maGD = maGD;
		this.ngayGD = ngayGD;
		this.donGia = donGia;
	}

	public String getMaGD() {
		return maGD;
	}

	public void setMaGD(String maGD) {
		this.maGD = maGD;
	}

	public LocalDate getNgayGD() {
		return ngayGD;
	}

	public void setNgayGD(LocalDate ngayGD) {
		this.ngayGD = ngayGD;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	
	public abstract double tinhThanhTien();

	@Override
	public String toString() {
		return "maGD=" + maGD + ", ngayGD=" + ngayGD + ", donGia=" + donGia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maGD == null) ? 0 : maGD.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GiaoDich other = (GiaoDich) obj;
		if (maGD == null) {
			if (other.maGD != null)
				return false;
		} else if (!maGD.equals(other.maGD))
			return false;
		return true;
	}
	
	
}
