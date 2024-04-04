package entity;

public class lophoc {
	private String malop,tenlop,magiaovien;
	private int siso;
	public lophoc(String malop, String tenlop, String magiaovien, int siso) {
		super();
		this.malop = malop;
		this.tenlop = tenlop;
		this.magiaovien = magiaovien;
		this.siso = siso;
	}
	public String getMalop() {
		return malop;
	}
	public void setMalop(String malop) {
		this.malop = malop;
	}
	public String getTenlop() {
		return tenlop;
	}
	public void setTenlop(String tenlop) {
		this.tenlop = tenlop;
	}
	public String getMagiaovien() {
		return magiaovien;
	}
	public void setMagiaovien(String magiaovien) {
		this.magiaovien = magiaovien;
	}
	public int getSiso() {
		return siso;
	}
	public void setSiso(int siso) {
		this.siso = siso;
	}
	@Override
	public String toString() {
		return "lophoc [malop=" + malop + ", tenlop=" + tenlop + ", magiaovien=" + magiaovien + ", siso=" + siso + "]";
	}
	
}
