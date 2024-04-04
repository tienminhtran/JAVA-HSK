package model;

public class MiniCalculatorModel {

	private double firstValue;
	private double secondValue;
	private double answer;
	public MiniCalculatorModel() {
	}
	public double getFirstValue() {
		return firstValue;
	}
	public void setFirstValue(double firstValue) {
		this.firstValue = firstValue;
	}
	public double getSecondValue() {
		return secondValue;
	}
	public void setSecondValue(double secondValue) {
		this.secondValue = secondValue;
	}
	public double getAnswer() {
		return answer;
	}
	public void setAnswer(double answer) {
		this.answer = answer;
	}
	
	public void cong() {
		this.answer = this.firstValue + this.secondValue;
	}
	public void tru() {
		this.answer = this.firstValue - this.secondValue;
	}
	public void nhan() {
		this.answer = this.firstValue * this.secondValue;
	}
	public void chia() {
		this.answer = this.firstValue / this.secondValue;
	}
	public void luythua() {
		this.answer = Math.pow(this.firstValue,this.secondValue);
	}
	public void mod() {
		this.answer = this.firstValue % this.firstValue;
	}
	
}
