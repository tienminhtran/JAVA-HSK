package Demo.gk_CuocPhi;

public class ThueBao {
	private String soDienThoai;
	private String hoTen;

	

	public ThueBao(String soDienThoai, String hoTen) {
		setSoDienThoai(soDienThoai);
		setHoTen(hoTen);
	}

	public ThueBao() {
		this.soDienThoai = "012456789";
		this.hoTen = "un-known";
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		if (!soDienThoai.trim().equals(""))
			this.soDienThoai = soDienThoai;
		else
			this.soDienThoai = "chua xac dinh";
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		if (!hoTen.trim().equals(""))
			this.hoTen = hoTen;
		else
			this.hoTen = "chua xac dinh";
	}
	public String getTieuDe() {
		return String.format("-25s", "Ten thue bao");
		
	}

	@Override
	public String toString() {
		return String.format("%s(%s)", hoTen, soDienThoai);
	}
	
}
