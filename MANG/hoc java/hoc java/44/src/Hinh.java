
public abstract class Hinh {
	protected Toado toado;

	public Hinh(Toado toado) {
		this.toado = toado;
	}

	public Toado getToado() {
		return toado;
	}

	public void setToado(Toado toado) {
		this.toado = toado;
	}
	public abstract double tinhdientich();
	
}
