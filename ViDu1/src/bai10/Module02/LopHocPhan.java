package bai10.Module02;
public class LopHocPhan {
	private String maLHP;
	private String tenLHP;
	private String tenGV;
	private String thongTinLopHoc;
	private SinhVien[] dsSV;
	public LopHocPhan(String maLHP, String tenLHP, String tenGV, String thongTinLopHoc, SinhVien[] dsSV) {
		this.maLHP = maLHP;
		this.tenLHP = tenLHP;
		this.tenGV = tenGV;
		this.thongTinLopHoc = thongTinLopHoc;
		this.dsSV = dsSV;
	}
	public String getMaLHP() {
		return maLHP;
	}
	public void setMaLHP(String maLHP) {
		this.maLHP = maLHP;
	}
	public String getTenLHP() {
		return tenLHP;
	}
	public void setTenLHP(String tenLHP) {
		this.tenLHP = tenLHP;
	}
	public String getTenGV() {
		return tenGV;
	}
	public void setTenGV(String tenGV) {
		this.tenGV = tenGV;
	}
	public String getThongTinLopHoc() {
		return thongTinLopHoc;
	}
	public void setThongTinLopHoc(String thongTinLopHoc) {
		this.thongTinLopHoc = thongTinLopHoc;
	}
	public SinhVien[] getDsSV() {
		return dsSV;
	}
	public void setDsSV(SinhVien[] dsSV) {
		this.dsSV = dsSV;
	}
	@Override
	public String toString() {
		return String.format("-Ma LHP: %s \n-Ten LHP: %s \n-GV Giang day: %s \n-Thong Tin buoi hoc: %s", maLHP, tenLHP, tenGV, thongTinLopHoc);
	}
	public int demSV() {
		int dem = 0;
		for(int i = 0; i<dsSV.length; i++) {
			dem++;
		}
		return dem;
	}
	
	
}
