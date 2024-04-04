package bai12.Module02;

public class CD {
	private int maCD;
	private String tuaCD;
	private int soBaiHat;
	private double giaThanh;

	public CD(int maCD, String tuaCD, int soBaiHat, double giaThanh) {
		setMaCD(maCD);
		setTuaCD(tuaCD);
		setSoBaiHat(soBaiHat);
		setGiaThanh(giaThanh);
	}

	public CD() {
		this.maCD = 0;
		this.tuaCD = "chua xac dinh";
		this.soBaiHat = 0;
		this.giaThanh = 0;
	}

	public int getMaCD() {
		return maCD;
	}

	public void setMaCD(int maCD) {
		if (maCD > 0)
			this.maCD = maCD;
		else
			this.maCD = 999999;

	}

	public String getTuaCD() {
		return tuaCD;
	}

	public void setTuaCD(String tuaCD) {
		if (!tuaCD.trim().equals(""))
			this.tuaCD = tuaCD;
		else
			this.tuaCD = "chua xac dinh";
	}

	public int getSoBaiHat() {
		return soBaiHat;
	}

	public void setSoBaiHat(int soBaiHat) {
		if (soBaiHat > 0)
			this.soBaiHat = soBaiHat;
		else
			this.soBaiHat = 999999;
	}

	public double getGiaThanh() {
		return giaThanh;
	}

	public void setGiaThanh(double giaThanh) {
		if (giaThanh > 0)
			this.giaThanh = giaThanh;
		else
			this.giaThanh = 999999;
	}

	public String layTieuDe() {
		return String.format("|%-15s|%-35s|%-15s|%-15s|","Ma CD", "Tua CD", "So bai hat", "Gia thanh");
	}
	@Override
	public String toString() {
		return String.format("|%-15d|%-35s|%-15d|%-15.2f|\n",maCD,tuaCD,soBaiHat,giaThanh);
	}

}
