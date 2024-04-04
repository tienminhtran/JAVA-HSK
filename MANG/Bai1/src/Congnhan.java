
public class Congnhan extends Canbo {
	private int level;

	public Congnhan(String name, String gender, String address, int age, int level) {
		super(name, gender, address, age);
		this.level = level;
	}

	public int getLevel() {
		return level;
	}


	public void setLevel(int level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "Congnhan{" +
                "level='" + this.level + '\'' +
                ", name='" + super.getName() + '\'' +
                ", age=" + getAge() +
                ", gender='" + super.getGender() + '\'' +
                ", address='" + super.getAddress() + '\'' +
                '}';
	}
	
}
