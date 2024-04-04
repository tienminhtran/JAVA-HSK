package Mode2Bai1;

public class ToaDo {
	private float x;
	private float y;
	private String Name;

	public ToaDo(float x, float y, String Name) {
		this.x = x;
		this.y = y;
		this.Name = Name;
	}

	public ToaDo() {
		x = 0;
		y = 0;
		Name = "O";

	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	@Override
	public String toString() {
		return String.format("%s(%f,%f)", Name, x, y); // A(x,y)
	}

}
