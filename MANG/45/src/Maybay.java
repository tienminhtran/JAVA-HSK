
public class Maybay extends Phuongtiendichuyen {
	private String loainhienlieu;

	public Maybay(String tenloaiphuongtien, Hangsanxuat hangsanxuat, String loainhienlieu) {
		super(tenloaiphuongtien, hangsanxuat);
		this.loainhienlieu = loainhienlieu;
	}

	public String getLoainhienlieu() {
		return loainhienlieu;
	}

	public void setLoainhienlieu(String loainhienlieu) {
		this.loainhienlieu = loainhienlieu;
	}

	@Override
	public double layvantoc() {
		
		return 500000;
	}
	public void catcanh() 
	{
		System.out.println("cat canh...");
	}
	public void hacanh() 
	{
		System.out.println("Ha canh");
	}
	
}
