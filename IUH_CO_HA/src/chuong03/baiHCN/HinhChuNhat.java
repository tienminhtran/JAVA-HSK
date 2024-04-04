package chuong03.baiHCN;

public class HinhChuNhat {
	// cac thuoc tinh:
	private float cDai;
	private float cRong;

	// cac phuong thuc:
	/**
	 * hàm khởi tạo (constructor) dùng để gán chiều dài chiều rộng cho hcn
	 * 
	 * @param cd
	 * @param cr
	 */
	public HinhChuNhat(float cDai, float cRong) {
		this.cDai = cDai;
		this.cRong = cRong;
	}

	/**
	 * hàm khởi tạo mặc định
	 * 
	 * @return
	 */
	public HinhChuNhat() {
		this(0,0);
	}

	// các hàm gán cho từng thuộc tính
	void setChieuDai(float cd) {
		cDai = cd;
	}
	void setChieuRong(float cr) {
		cRong = cr;
	}

	// các hàm lấy giá trị cho từng thuộc tính:
	float getChieuDai() {
		return cDai;
	}
	float getChieuRong() {
		return cRong;
	}
	
	float tinhChuVi() {
		return (cDai + cRong) * 2;
	}
	float tinhDienTich() {
		return cDai * cRong;
	}
	String layThongTin() {
		return "Chieu dai=" + cDai + ", chieu rong= " + cRong;
	}
}
