package vidu;

public class Sinhvien implements Comparable<Sinhvien>{
	private int masinhvien;
	private String hovaten;
	private String tenlop;
	private double diemtrungbinh;
	public Sinhvien(int masinhvien, String hovaten, String tenlop, double diemtrungbinh) {
		this.masinhvien = masinhvien;
		this.hovaten = hovaten;
		this.tenlop = tenlop;
		this.diemtrungbinh = diemtrungbinh;
	}
	public int getMasinhvien() {
		return masinhvien;
	}
	public void setMasinhvien(int masinhvien) {
		this.masinhvien = masinhvien;
	}
	public String getHovaten() {
		return hovaten;
	}
	public void setHovaten(String hovaten) {
		this.hovaten = hovaten;
	}
	public String getTenlop() {
		return tenlop;
	}
	public void setTenlop(String tenlop) {
		this.tenlop = tenlop;
	}
	public double getDiemtrungbinh() {
		return diemtrungbinh;
	}
	public void setDiemtrungbinh(double diemtrungbinh) {
		this.diemtrungbinh = diemtrungbinh;
	}
	public String getTen() 
	{
		String s=this.hovaten.trim();
		if(s.indexOf(" ")>=0) 
		{
			int vt = s.lastIndexOf(" ");
			return s.substring(vt+1);
		}
		else return s;
	}
	@Override
	public String toString() {
		return "Sinhvien [masinhvien=" + masinhvien + ", hovaten=" + hovaten + ", tenlop=" + tenlop + ", diemtrungbinh="
				+ diemtrungbinh + "]";
	}
//	@Override
//	public int compareTo(Sinhvien o) {
//		//<0
//		//=0
//		//>0
//		//Dua tren so sanh ten Adam,Barack Obama,Nguyen Van A,Tran Thi Thanh Yen
//		String tenthis=this.getTen();
//		String teno=o.getTen();		
//		return tenthis.compareTo(teno);
//	}
	@Override
	public int compareTo(Sinhvien o) {
		//<0
		//=0
		//>0
		//Dua tren so sanh ten Adam,Barack Obama,Nguyen Van A,Tran Thi Thanh Yen
	
		return this.getMasinhvien()-o.getMasinhvien();
	}
}
