
public class Cat extends Animail {

	public Cat(String name) {
		super("Name");
	
	}

	@Override
	public void eat() {
		System.out.println("Toi an ca!");
	}

	@Override
	public void makesound() {
		System.out.println("Meo Meo");
	
}
}
