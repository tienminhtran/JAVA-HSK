
public class Bophim {
 private String tenphim;
 private int namsanxuat;
 private Hangsanxuat hangsanxuat;
 private double giave;
 private Ngay ngaychieu;
public Bophim(String tenphim, int namsanxuat, Hangsanxuat hangsanxuat, double giave, Ngay ngaychieu) {
	super();
	this.tenphim = tenphim;
	this.namsanxuat = namsanxuat;
	this.hangsanxuat = hangsanxuat;
	this.giave = giave;
	this.ngaychieu = ngaychieu;
}
public String getTenphim() {
	return tenphim;
}
public void setTenphim(String tenphim) {
	this.tenphim = tenphim;
}
public int getNamsanxuat() {
	return namsanxuat;
}
public void setNamsanxuat(int namsanxuat) {
	this.namsanxuat = namsanxuat;
}
public Hangsanxuat getHangsanxuat() {
	return hangsanxuat;
}
public void setHangsanxuat(Hangsanxuat hangsanxuat) {
	this.hangsanxuat = hangsanxuat;
}
public double getGiave() {
	return giave;
}
public void setGiave(double giave) {
	this.giave = giave;
}
public Ngay getNgaychieu() {
	return ngaychieu;
}
public void setNgaychieu(Ngay ngaychieu) {
	this.ngaychieu = ngaychieu;
}
public boolean kiemtragiaverehon(Bophim phimkhac) 
{
	return this.giave<phimkhac.giave;
}
}
