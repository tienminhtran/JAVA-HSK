
public class Xeoto extends Phuongtiendichuyen {
	private String loainguyenlieu;
	public String getLoainguyenlieu() {
		return loainguyenlieu;
	}
	public void setLoainguyenlieu(String loainguyenlieu) {
		this.loainguyenlieu = loainguyenlieu;
	}
	public Xeoto(String tenloaiphuongtien, Hangsanxuat hangsanxuat, String loainguyenlieu) {
		super(tenloaiphuongtien, hangsanxuat);
		this.loainguyenlieu = loainguyenlieu;
	}
	@Override
	public double layvantoc() {
	
		return 100000;
	}


	
}
