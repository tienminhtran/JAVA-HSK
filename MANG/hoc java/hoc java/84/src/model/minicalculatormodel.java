package model;

public class minicalculatormodel {
	private double first_value;
	private double secondvalue;
	private double answer;
	public minicalculatormodel() {	
	}
	public double getFirst_value() {
		return first_value;
	}
	public void setFirst_value(double first_value) {
		this.first_value = first_value;
	}
	public double getSecondvalue() {
		return secondvalue;
	}
	public void setSecondvalue(double secondvalue) {
		this.secondvalue = secondvalue;
	}
	public double getAnswer() {
		return answer;
	}
	public void setAnswer(double answer) {
		this.answer = answer;
	}
	public void plus() 
	{
		this.answer = this.first_value+this.secondvalue;
	}
	public void minus() 
	{
		this.answer = this.first_value-this.secondvalue;
	}
	public void multiply() 
	{
		this.answer = this.first_value*this.secondvalue;
	}
	public void devide() 
	{
		this.answer = this.first_value/this.secondvalue;
	}
	public void power() 
	{
		this.answer = Math.pow(first_value, answer);
	}
	public void mod() 
	{
		this.answer = this.first_value%this.secondvalue;
	}
	public void reset() 
	{
		this.answer=0;
		this.first_value=0;
		this.secondvalue=0;
	}
}
