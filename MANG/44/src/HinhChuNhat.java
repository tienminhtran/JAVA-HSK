
public class HinhChuNhat extends Hinh {
	private double chieurong,chieucao;

	public HinhChuNhat(Toado toado ,double chieurong, double chieucao) {
		super(toado);
		this.chieurong = chieurong;
		this.chieucao = chieucao;
	}

	public double getChieurong() {
		return chieurong;
	}

	public void setChieurong(double chieurong) {
		this.chieurong = chieurong;
	}

	public double getChieucao() {
		return chieucao;
	}

	public void setChieucao(double chieucao) {
		this.chieucao = chieucao;
	}

	@Override
	public double tinhdientich() {
		
		return chieurong*chieucao;
	}
	
}
