package oke;

public class oke {
	private String ten,lop;

	public oke(String ten, String lop) {

		this.ten = ten;
		this.lop = lop;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getLop() {
		return lop;
	}

	public void setLop(String lop) {
		this.lop = lop;
	}

	@Override
	public String toString() {
		return "oke [ten=" + ten + ", lop=" + lop + "]";
	}
	
}
