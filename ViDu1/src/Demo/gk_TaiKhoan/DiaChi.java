package Demo.gk_TaiKhoan;

public class DiaChi {
	private String soNha;
	private String duong;
	private String phuong;
	private String quan;

	public DiaChi(String soNha, String duong, String phuong, String quan) {
		setSoNha(soNha);
		setDuong(duong);
		setPhuong(phuong);
		setQuan(quan);
	}

	public String getSoNha() {
		return soNha;
	}

	public void setSoNha(String soNha) {
		if (!soNha.trim().equals(""))
			this.soNha = soNha;
		else
			this.soNha = "xxx";
	}

	public String getDuong() {
		return duong;
	}

	public void setDuong(String duong) {
		if (!duong.trim().equals(""))
			this.duong = duong;
		else
			this.duong = "xxx";
	}

	public String getPhuong() {
		return phuong;
	}

	public void setPhuong(String phuong) {
		if (!phuong.trim().equals(""))
			this.phuong = phuong;
		else
			this.phuong = "xxx";
	}

	public String getQuan() {
		return quan;
	}

	public void setQuan(String quan) {
		if (!quan.trim().equals(""))
			this.quan = quan;
		else
			this.quan = "xxx";
	}

	public String toString()
	{
		return String.format("(%s %s, %s, %s)", soNha, duong, phuong, quan);
	}
}
