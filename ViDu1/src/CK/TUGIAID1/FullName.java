package CK.TUGIAID1;

public class FullName {
	private String lastName;
	private String firstName;

	public FullName(String lastName, String firstName) {
		setLastName(lastName);
		setFirstName(firstName);
	}

	public FullName() {
		this.lastName = "khong rong";
		this.firstName = "khong rong";
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		if (!lastName.trim().equals(""))
			this.lastName = lastName;
		else
			this.lastName = "khong rong";
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		if(!firstName.trim().equals(""))
		this.firstName = firstName;
		else
			this.firstName = "khong rong";
	}

	@Override
	public String toString() {
		return String.format("%-15s %-15s", lastName,firstName);
	}

	
}
