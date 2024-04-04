package entity;

public class giaovien {
	private String magiaovien,tengiaovien;

	public giaovien(String magiaovien, String tengiaovien) {
		super();
		this.magiaovien = magiaovien;
		this.tengiaovien = tengiaovien;
	}

	public String getMagiaovien() {
		return magiaovien;
	}

	public void setMagiaovien(String magiaovien) {
		this.magiaovien = magiaovien;
	}

	public String getTengiaovien() {
		return tengiaovien;
	}

	public void setTengiaovien(String tengiaovien) {
		this.tengiaovien = tengiaovien;
	}

	@Override
	public String toString() {
		return "giaovien [magiaovien=" + magiaovien + ", tengiaovien=" + tengiaovien + "]";
	}
	
}
