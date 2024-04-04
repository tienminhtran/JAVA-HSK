
public class Kysu extends Canbo{
	private String branch;
	
	public Kysu(String name, String gender, String address, int age, String branch) {
		super(name,gender,address,age);
		this.branch=branch;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}
	@Override
	public String toString() 
	{
		 return "Ky su{" +
	                "branch='" + branch + '\'' +
	                ", name='" + getName() + '\'' +
	                ", age=" + super.getAge() +
	                ", gender='" + super.getGender() + '\'' +
	                ", address='" + super.getAddress() + '\'' +
	                '}';
	}
}
