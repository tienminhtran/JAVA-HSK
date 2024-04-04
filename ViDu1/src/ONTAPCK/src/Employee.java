package ONTAPCK.src;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public abstract class Employee {
	private String ID;
	private FullName fullName;
	private LocalDate birthday;
	private String phone;

	public Employee(String iD, FullName fullName, LocalDate birthday, String phone) {
		setID(iD);
		this.fullName = fullName;
		setBirthday(birthday);
		setPhone(phone);
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		if (!iD.trim().equals("")) {
			this.ID = iD;
		} else {
			this.ID = "chua XD";
		}
	}

	public FullName getFullName() {
		return fullName;
	}

	public void setFullName(FullName fullName) {
		this.fullName = fullName;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	/**
	 * Tuoi nhan vien >= 20
	 * @param birthday
	 */
	
	public void setBirthday(LocalDate birthday) {
		Period pe = Period.between(birthday, LocalDate.now());
		if (pe.getYears() >= 20) {
			this.birthday = birthday;
		} else {
			this.birthday = LocalDate.of(2001,1,1);
		}

	}

	public String getPhone() {
		return phone;
	}
	
	/**
	 * So dien thoai phai bat dau chu so 0 va du 10 so
	 * @param phone
	 */

	public void setPhone(String phone) {
		if (phone.startsWith("0") && phone.length() == 10) {
			this.phone = phone;
		} else {
			this.phone = "chua xd";
		}
	}

	@Override
	public String toString() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return "ID = " + ID + ", fullName = " + fullName + ", birthday=" + dtf.format(birthday) + ", phone = " + phone ;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ID == null) ? 0 : ID.hashCode());
		return result;
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
		if (ID == null) {
			if (other.ID != null)
				return false;
		} else if (!ID.equals(other.ID))
			return false;
		return true;
	}

	
}
