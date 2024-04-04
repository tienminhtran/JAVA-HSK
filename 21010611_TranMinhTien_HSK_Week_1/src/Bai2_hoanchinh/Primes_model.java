package Bai2_hoanchinh;

public class Primes_model {
	private int n;
	private String answer;

	public Primes_model() {
		answer = "";	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public boolean kiemTraNt(int n) {

		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	public void soNgt(int n) {
		
		for (int i = 2; i < n; i++) {
			if (kiemTraNt(i)) {
				answer +=(""+ i + "\n");
				
			}
		}
	}
}
