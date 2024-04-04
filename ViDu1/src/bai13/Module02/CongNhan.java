package bai13.Module02;

public class CongNhan {
	private String mHo;
	private String mTen;
	private int mSoSP;
	public CongNhan(String mHo, String mTen, int mSoSP) {
		setmHo(mHo);
		setmTen(mTen);
		setmSoSP(mSoSP);
	}
	public CongNhan() {
		this.mHo = "chua xac dinh";
		this.mTen = "chua xac dinh";
		this.mSoSP = -1;
	}
	public String getmHo() {
		return mHo;
	}
	public void setmHo(String mHo) {
		if(!mHo.trim().equals(""))
			this.mHo = mHo;
		else
			this.mHo = "chua xac dinh";
	}
	public String getmTen() {
		return mTen;
	}
	public void setmTen(String mTen) {
		if(!mTen.trim().equals(""))
			this.mTen = mTen;
		else
			this.mTen = "chua xac dinh";
	}
	public int getmSoSP() {
		return mSoSP;
	}
	public void setmSoSP(int mSoSP) {
		if(mSoSP >=0 )
			this.mSoSP = mSoSP;
		else
			this.mSoSP = -1;
	}
	/**
	 * return tinh luong 
	 * luong = lương = số sản phẩm * đơn giá, với đơn giá tính theo từng cấp như sau:
	 * Số sản phẩm	Đơn giá
		Từ 1 – 199 sản phẩm	0.5
		Từ sản phẩm thứ 200 - 399	0.55
		Từ sản phẩm thứ 400 - 599	0.6
		Từ sản phẩm thứ 600 trở lên	0.65

	 */
	public double tinhLuong() { 
		if(this.mSoSP >=1 && this.mSoSP <= 199)
			return this.mSoSP * 0.5;
		else if(this.mSoSP >=200 && this.mSoSP <= 399)
			return this.mSoSP * 0.55;
		else if(this.mSoSP >=400 && this.mSoSP <= 599)
			return this.mSoSP * 0.6;
		else
			return this.mSoSP * 0.65;
	}
	@Override
	public String toString() {
		return String.format("|%-15s|%-15s|%-10d|%-10.2f|\n", mHo, mTen, mSoSP,tinhLuong());
	}

}
