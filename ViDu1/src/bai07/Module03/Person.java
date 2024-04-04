package bai07.Module03;

import java.util.Objects;

public abstract class Person {
	private String hoTen;
	private String diaChi;

	public Person(String hoTen, String diaChi) {
		setHoTen(hoTen);
		setDiaChi(diaChi);
	}

	public Person() {
		this.hoTen = "chua duoc rong";
		this.diaChi = "chua xac dinh";
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		if (!hoTen.trim().equals(""))
			this.hoTen = hoTen;
		else
			this.hoTen = "chua duoc rong";
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		if (!diaChi.trim().equals(""))
			this.diaChi = diaChi;
		else
			this.diaChi = "chua xac dinh";
	}

	

	@Override
	public int hashCode() {
		return Objects.hash(hoTen);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(hoTen, other.hoTen);
	}

	@Override
	public String toString() {
		return "Person [hoTen=" + hoTen + ", diaChi=" + diaChi + "]";
	}

}
