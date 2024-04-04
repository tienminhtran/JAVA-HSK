package entity;

public class tonghop {
	private String malop,tenlop,giaoviencn;
	private int siso;
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
	public String getGiaoviencn() {
		return giaoviencn;
	}
	public void setGiaoviencn(String giaoviencn) {
		this.giaoviencn = giaoviencn;
	}
	public int getSiso() {
		return siso;
	}
	public void setSiso(int siso) {
		this.siso = siso;
	}
	public tonghop(String malop, String tenlop, String giaoviencn, int siso) {
		super();
		this.malop = malop;
		this.tenlop = tenlop;
		this.giaoviencn = giaoviencn;
		this.siso = siso;
	}
	
}
