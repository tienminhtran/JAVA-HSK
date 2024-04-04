
public abstract class Phuongtiendichuyen {
	protected String tenloaiphuongtien;
	protected Hangsanxuat hangsanxuat;

	public Phuongtiendichuyen(String tenloaiphuongtien, Hangsanxuat hangsanxuat) {
		this.tenloaiphuongtien = tenloaiphuongtien;
		this.hangsanxuat=hangsanxuat;
	}

	public String getTenloaiphuongtien() {
		return tenloaiphuongtien;
	}

	public Hangsanxuat getHangsanxuat() {
		return hangsanxuat;
	}

	public void setHangsanxuat(Hangsanxuat hangsanxuat) {
		this.hangsanxuat = hangsanxuat;
	}

	public void setTenloaiphuongtien(String tenloaiphuongtien) {
		this.tenloaiphuongtien = tenloaiphuongtien;
	}
	public String laytenhangsanxuat() 
	{
		return hangsanxuat.getTenHangsanxuat();
	}
	public void batdau() 
	{
		System.out.println("Bat dau: ");
	}
	public void tangtoc() 
	{
		System.out.println("Tang toc");
	}
	public void dunglai() 
	{
		System.out.println("Dung lai...");
	}
	public abstract double layvantoc();
}
