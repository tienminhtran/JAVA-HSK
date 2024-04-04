package emtity;

public class LopHoc {
	private String malop;
	private String tenlop;
	private String giaovienCN;














	public LopHoc(String malop, String tenlop, String giaovienCN) {
		super();
		this.malop = malop;
		this.tenlop = tenlop;
		this.giaovienCN = giaovienCN;
	}

	@Override
	public String toString() {
		return "LopHoc [malop=" + malop + ", tenlop=" + tenlop + ", giaovienCN=" + giaovienCN + "]";
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

	public String getGiaovienCN() {
		return giaovienCN;
	}

	public void setGiaovienCN(String giaovienCN) {
		this.giaovienCN = giaovienCN;
	}

}
