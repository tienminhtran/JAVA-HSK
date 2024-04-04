
public class Canbo {
	private String name,gender,address;
	private int age;
	public Canbo(String name, String gender, String address, int age) {
		this.name = name;
		this.gender = gender;
		this.address = address;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Canbo [name=" + name + ", gender=" + gender + ", address=" + address + ", age=" + age + "]";
	}
	
}
