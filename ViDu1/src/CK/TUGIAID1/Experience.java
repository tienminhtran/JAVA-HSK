package CK.TUGIAID1;

import java.time.LocalDate;

public class Experience extends Employee {
	private int soNamKinhNghiem;

	public Experience(String ma, FullName hoTen, LocalDate ngaySinh, String soDienThoai, int soNamKinhNghiem) {
		super(ma, hoTen, ngaySinh, soDienThoai);
		setSoNamKinhNghiem(soNamKinhNghiem);
	}

	public Experience() {
		this.soNamKinhNghiem = 1;
	}

	public int getSoNamKinhNghiem() {
		return soNamKinhNghiem;
	}

	public void setSoNamKinhNghiem(int soNamKinhNghiem) {
		if(soNamKinhNghiem >0)
			this.soNamKinhNghiem = soNamKinhNghiem;
		else
			this.soNamKinhNghiem = 1;
	}

	@Override
	public String toString() {
		return String.format("%s %-15s %-15s %-15s %-15s %-15s", super.toString(), soNamKinhNghiem,"-","-","-","-");
	}

	
}
