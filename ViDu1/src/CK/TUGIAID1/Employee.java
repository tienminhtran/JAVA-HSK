package CK.TUGIAID1;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;
//abstract 
public abstract class Employee {
	private String ma;
	private FullName hoTen;
	private LocalDate ngaySinh;
	private String soDienThoai;

	public Employee(String ma, FullName hoTen, LocalDate ngaySinh, String soDienThoai) {
		super();
		setMa(ma);
		setNgaySinh(ngaySinh);
		setSoDienThoai(soDienThoai);
		this.hoTen = hoTen;
	}

	public Employee() {
		this.ma = "xxx";
		this.ngaySinh = LocalDate.of(2002, 1, 1);
		this.soDienThoai = "0123456789";
	}

	public String getMa() {
		return ma;
	}

	public void setMa(String ma) {
		if (!ma.trim().equals(""))
			this.ma = ma;
		else
			this.ma = "xxx";
	}

	public FullName getHoTen() {
		return hoTen;
	}

	public void setHoTen(FullName hoTen) {
		this.hoTen = hoTen;
	}

	public LocalDate getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(LocalDate ngaySinh) {
		Period tuoi = Period.between(ngaySinh, LocalDate.now());
		

		if (tuoi.getYears() > 20)
			this.ngaySinh = ngaySinh;
		else
			this.ngaySinh = LocalDate.of(2002, 1, 1);
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		if (soDienThoai.length() == 10 && soDienThoai.startsWith("0"))
			this.soDienThoai = soDienThoai;
		else
			this.soDienThoai = "0123456789";
	}

	@Override
	public String toString() {
		return String.format("%-15s %s %-15s %-15s", ma, hoTen, ngaySinh, soDienThoai);
	}

	@Override
	public int hashCode() {
		return Objects.hash(ma);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(ma, other.ma);
	}

}
