package CK.DE1;

import java.time.LocalDate;

public class Experience extends Employee {

	private int expInyear;

	public Experience(String iD, FullName fullName, LocalDate birthday, String phone, int expInyear) {
		super(iD, fullName, birthday, phone);
		setExpInyear(expInyear);
	}

	public int getExpInyear() {
		return expInyear;
	}

	public void setExpInyear(int expInyear) {
		if (expInyear > 0)
			this.expInyear = expInyear;
		else
			this.expInyear = 1;
	}

	@Override
	public String toString() {
		return "Experience "+super.toString()+", expInyear=" + expInyear;
	}

	
}
