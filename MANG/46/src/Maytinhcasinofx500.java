
public class Maytinhcasinofx500 implements Maytinhbotuiinterface {

	double a,b;
	public Maytinhcasinofx500(double a, double b) {
		this.a = a;
		this.b = b;
	}
	@Override
	public double cong(double a, double b) {
		
		return a+b;
	}
	@Override
	public double tru(double a, double b) {
	
		return a-b;
	}
	@Override
	public double nhan(double a, double b) {
		
		return a*b;
	}
	@Override
	public double chia(double a, double b) {
		
		return a/b;
	}	
}
