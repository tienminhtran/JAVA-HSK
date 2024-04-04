package bai05.Module03;

import java.text.DecimalFormat;

public class HoulyEmployee extends Employee{
	private double wage;
	private double hours;
	public HoulyEmployee(String firstName, String lastName, String socialSecurityNumber, double wage, double hours) {
		super(firstName, lastName, socialSecurityNumber);
		this.wage = wage;
		this.hours = hours;
	}
	public double getWage() {
		return wage;
	}
	public void setWage(double wage) {
		this.wage = wage;
	}
	public double getHours() {
		return hours;
	}
	public void setHours(double hours) {
		this.hours = hours;
	}
	@Override
	public double eamings() {
		if(hours <= 40) {
			return wage*hours;
		} else {
			return 40 * wage + (hours - 40) * wage * 1.5;
		}
	}
	
	@Override
	public String toString() {
		DecimalFormat dec = new DecimalFormat("#,##0.00VND");
		return super.toString() + "\nwage = " +  wage + ", hours = " + hours + "\n" + "eamings = " + dec.format(eamings());
	}
	
	
}
