package emtity;

public class LopHoc {
	private String maLop;
	private String tenLop;
	private GiaoVien GiaoVien;
	private String siSo;
	
	

	public LopHoc(String maLop, String tenLop, GiaoVien GiaoVien, String siSo) {
		super();
		this.maLop = maLop;
		this.tenLop = tenLop;
		this.GiaoVien = GiaoVien;
		this.siSo = siSo;
	}
	public String getSiSo() {
		return siSo;
	}
	public void setSiSo(String siSo) {
		this.siSo = siSo;
	}
	public String getMaLop() {
		return maLop;
	}
	public void setMaLop(String maLop) {
		this.maLop = maLop;
	}
	public String getTenLop() {
		return tenLop;
	}
	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
	}
	public GiaoVien getGiaoVien() {
		return GiaoVien;
	}
	public void setGiaoVien(GiaoVien giaoVien) {
		GiaoVien = giaoVien;
	}


}
