package CK.DE1;

public class FullName {
	private String lastName;
	private String firstName;
	public FullName(String lastName, String firstName) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		if(!lastName.trim().equals("")) {
			this.lastName = lastName;
		} else {
			this.lastName = "chua XD";
		}
		
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		if(!firstName.trim().equals("")) {
			this.firstName = firstName;
		} else {
			this.firstName = "chua XD";
		}
	}
	@Override
	public String toString() {
		return ", lastName = " + lastName + ", firstName=" + firstName;
	}
	
	
}
