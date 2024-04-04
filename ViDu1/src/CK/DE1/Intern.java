package CK.DE1;

import java.time.LocalDate;

public class Intern extends Employee{
	private String major;
	private int semester;
	
	public Intern(String iD, FullName fullName, LocalDate birthday, String phone, String major, int semester) {
		super(iD, fullName, birthday, phone);
		this.major = major;
		this.semester = semester;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		if(!major.trim().equals("")) {
			this.major = major;
		} else {
			this.major = "chua XD";
		}
	}

	public int getSemester() {
		return semester;
	}

	/**
	 *Phai hoc tu hoc ki 6 den 10
	 * @param semester
	 */
	public void setSemester(int semester) {
		if (semester >= 6 && semester <= 10)
			this.semester = semester;
		else
			this.semester = 1;
	}

	@Override
	public String toString() {
		return "Intern "+super.toString()+", major=" + major + ", semester=" + semester;
	}
	
	
}
