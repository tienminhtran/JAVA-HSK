
public class student {
	String name;
	int diem;
	public student(String name, int diem) {
		this.name = name;
		this.diem = diem;
	}
	public student() {
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDiem() {
		return diem;
	}
	public void setDiem(int diem) {
	
		this.diem=diem;
	}
	@Override
	public String toString() {
		return "student [name=" + name + ", diem=" + diem + "]";
	}
	
	
}
