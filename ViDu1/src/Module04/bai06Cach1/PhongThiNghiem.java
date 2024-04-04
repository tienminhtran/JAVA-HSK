package Module04.bai06Cach1;

public class PhongThiNghiem extends Phong {
	private String ttChuyenNganh;
	private int sucChua;
	private boolean bonRua;
	
	public PhongThiNghiem(String maPhong, String dayNha, double dienTich, int soBongDen, String ttChuyenNganh,
			int sucChua, boolean bonRua) {
		super(maPhong, dayNha, dienTich, soBongDen);
		this.ttChuyenNganh = ttChuyenNganh;
		this.sucChua = sucChua;
		this.bonRua = bonRua;
	}

	public String getTtChuyenNganh() {
		return ttChuyenNganh;
	}

	public void setTtChuyenNganh(String ttChuyenNganh) {
		this.ttChuyenNganh = ttChuyenNganh;
	}

	public int getSucChua() {
		return sucChua;
	}

	public void setSucChua(int sucChua) {
		this.sucChua = sucChua;
	}

	public boolean isBonRua() {
		return bonRua;
	}

	public void setBonRua(boolean bonRua) {
		this.bonRua = bonRua;
	}

	@Override
	public boolean kiemTRaPhongDatChuan() {
		if(super.kiemTraDuAnhSach())
			return bonRua; 
		return false;
	}

	@Override
	public String toString() {

		return String.format("%s %-15s ",super.toString(),kiemTRaPhongDatChuan() ? "Co bon rua" : "Khong co bon rua");
	}
	
}
