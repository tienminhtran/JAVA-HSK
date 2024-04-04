package CK.NganHang;

import java.util.Objects;

public abstract class TaiKhoan {
	private String maThe;
	private String tenChuSoHuu;


	public TaiKhoan(String maThe, String tenChuSoHuu) {
		setMaThe(maThe);
		setTenChuSoHuu(tenChuSoHuu);

	}

	public String getMaThe() {
		return maThe;
	}

	public void setMaThe(String maThe) {
		if (!maThe.trim().equals(""))
			this.maThe = maThe;
		else
			this.maThe = "xxxx";
	}

	public String getTenChuSoHuu() {
		return tenChuSoHuu;
	}

	public void setTenChuSoHuu(String tenChuSoHuu) {
		if (!tenChuSoHuu.trim().equals(""))
			this.tenChuSoHuu = tenChuSoHuu;
		else
			this.tenChuSoHuu = "xxx";
	}
	public abstract boolean khaNangChiTieu();

	@Override
	public String toString() {
		return String.format("%-10s%-10s", maThe, tenChuSoHuu);
	}

	@Override
	public int hashCode() {
		return Objects.hash(maThe);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaiKhoan other = (TaiKhoan) obj;
		return Objects.equals(maThe, other.maThe);
	}
	

}
