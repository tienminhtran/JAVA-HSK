package emtity;

public class SinhVien {
	private String masv;
	private String hoten;
	private String email;
	private String diachi;
	
	private LopHoc lophoc;

	public SinhVien() {
		
	}

	public SinhVien(String masv) {
		super();
		this.masv = masv;
	}

	@Override
	public String toString() {
		return "SinhVien [masv=" + masv + ", hoten=" + hoten + ", email=" + email + ", diachi=" + diachi + ", lophoc="
				+ lophoc + "]";
	}

	public String getMasv() {
		return masv;
	}

	public void setMasv(String masv) {
		this.masv = masv;
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public LopHoc getLophoc() {
		return lophoc;
	}

	public void setLophoc(LopHoc lophoc) {
		this.lophoc = lophoc;
	}

	public SinhVien(String masv, String hoten, String email, String diachi, LopHoc lophoc) {
		super();
		this.masv = masv;
		this.hoten = hoten;
		this.email = email;
		this.diachi = diachi;
		this.lophoc = lophoc;
	}
	
}
