package Demo.KTMP17A_S4;

public class ThongTinLienHe {
	private String soNha;
	private String duong;
	private String quan;
	private String soDienThoai;

	public ThongTinLienHe(String soNha, String duong, String quan, String soDienThoai) {
		setSoNha(soNha);
		setDuong(duong);
		setQuan(quan);
		setSoDienThoai(soDienThoai);
	}

	public String getSoNha() {
		return soNha;
	}

	public void setSoNha(String soNha) {
		if (!soNha.trim().equals(""))
			this.soNha = soNha;
		else
			this.soNha = "Chua xac dinh";
	}

	public String getDuong() {
		return duong;
	}

	public void setDuong(String duong) {
		if (!duong.trim().equals(""))
			this.duong = duong;
		else
			this.duong = "Chua xac dinh";
	}

	public String getQuan() {
		return quan;
	}

	public void setQuan(String quan) {
		if (!quan.trim().equals(""))
			this.quan = quan;
		else
			this.quan = "Chua xac dinh";
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		if (!soDienThoai.trim().equals("") && soDienThoai.length()==10)
			this.soDienThoai = soDienThoai;
		else
			this.soDienThoai = "xxxxxxxxxx";
	}

	@Override
	public String toString() {
		return String.format("Dia chi: %s, %s, %s"
				+ "\nSo dien thoai: %s\n", soNha, duong, quan, soDienThoai);
	}
	

}
