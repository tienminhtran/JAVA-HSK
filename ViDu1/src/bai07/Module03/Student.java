package bai07.Module03;

public class Student extends Person {
	private double DiemMon1;
	private double DiemMon2;

	public Student(String hoTen, String diaChi, double diemMon1, double diemMon2) {
		super(hoTen, diaChi);
		setDiemMon1(diemMon1);
		setDiemMon2(diemMon2);
	}

	public double getDiemMon1() {
		return DiemMon1;
	}

	public void setDiemMon1(double diemMon1) {
		if (diemMon1 >= 0 && diemMon1 <= 10)
			DiemMon1 = diemMon1;
		else
			DiemMon1 = 0;
	}

	public double getDiemMon2() {
		return DiemMon2;
	}

	public void setDiemMon2(double diemMon2) {
		if (diemMon2 >= 0 && diemMon2 <= 10)
			DiemMon2 = diemMon2;
		else
			DiemMon2 = 0;
	}

	public String danhgia()
	{
		double a = (this.DiemMon1+this.DiemMon2)/2;
		if(a >=8)
			return "Gioi";
		else if(a >= 7)
			return "Kha";
		else if(a>=5)
			return "TB";
		else
			return "Yeu";	
	}

	@Override
	public String toString() {
		return "Student ["+super.toString() +"DiemMon1=" + DiemMon1 + ", DiemMon2=" + DiemMon2 + ", danhgia()=" + danhgia() 
				+ "]";
	}

}
