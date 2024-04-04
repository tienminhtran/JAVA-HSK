
public class Nhanvien extends Canbo {
	private String task;

	public Nhanvien(String name, String gender, String address, int age, String task) {
		super(name, gender, address, age);
		this.task = task;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}
	 @Override
	 public String toString() {
	  return "Nhanvien{" +
	                "task='" + task + '\'' +
	                ", name='" + getName() + '\'' +
	                ", age=" + super.getAge() +
	                ", gender='" + super.getGender() + '\'' +
	                ", address='" + super.getAddress() + '\'' +
	                '}';
	    }
}
