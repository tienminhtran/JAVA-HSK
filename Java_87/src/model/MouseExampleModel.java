package model;

public class MouseExampleModel {

	private int x;
	private int y;
	private int dem;
	private String check;
	public MouseExampleModel() {
		this.x = 0;
		this.y = 0;
		this.dem = 0;
		this.check = "No";
	
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getDem() {
		return dem;
	}
	public void setDem(int dem) {
		this.dem = dem;
	}
	public String getCheck() {
		return check;
	}
	public void setCheck(String check) {
		this.check = check;
	}
	
	public void dem_click()
	{
		this.dem++;
	}
	//enter
	public void enter() {
		this.check = "Yes";
	}
	//exit
	public void exit() {
		this.check = "No";
	}
}

