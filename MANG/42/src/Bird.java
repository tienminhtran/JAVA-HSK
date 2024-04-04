
public class Bird extends Animail{

	public Bird(String name) {
		super("Bird");
	}

	@Override
	public void eat() {
		System.out.println("Toi an sau!");
	}

	@Override
	public void makesound() {
		System.out.println("Liu lo");
	}
	
}
