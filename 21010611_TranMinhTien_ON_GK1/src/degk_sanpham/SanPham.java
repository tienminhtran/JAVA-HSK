package degk_sanpham;

import java.util.Objects;

public class SanPham {

	private String maSP;
	private String tenSP;
	private String doanhMucSP;
	private double giaSP;
	private String moTaSP;
	public SanPham(String maSP, String tenSP, String doanhMucSP, double giaSP, String moTaSP) {
		super();
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.doanhMucSP = doanhMucSP;
		this.giaSP = giaSP;
		this.moTaSP = moTaSP;
	}
	public String getMaSP() {
		return maSP;
	}
	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}
	public String getTenSP() {
		return tenSP;
	}
	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}
	public String getDoanhMucSP() {
		return doanhMucSP;
	}
	public void setDoanhMucSP(String doanhMucSP) {
		this.doanhMucSP = doanhMucSP;
	}
	public double getGiaSP() {
		return giaSP;
	}
	public void setGiaSP(double giaSP) {
		this.giaSP = giaSP;
	}
	public String getMoTaSP() {
		return moTaSP;
	}
	public void setMoTaSP(String moTaSP) {
		this.moTaSP = moTaSP;
	}
	@Override
	public String toString() {
		return "SanPham [maSP=" + maSP + ", tenSP=" + tenSP + ", doanhMucSP=" + doanhMucSP + ", giaSP=" + giaSP
				+ ", moTaSP=" + moTaSP + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(maSP);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SanPham other = (SanPham) obj;
		return Objects.equals(maSP, other.maSP);
	}
	


}
