package bai05.Module03;

import java.text.DecimalFormat;

public class SalariedEmployee extends Employee {
	private double weeklySalary;

	public SalariedEmployee(String firstName, String lastName, String socialSecurityNumber, double weeklySalary) {
		super(firstName, lastName, socialSecurityNumber);
		this.weeklySalary = weeklySalary;
	}

	public double getWeeklySalary() {
		return weeklySalary;
	}

	public void setWeeklySalary(double weeklySalary) {
		this.weeklySalary = weeklySalary;
	}

	@Override
	public double eamings() {
		return weeklySalary;
	}
	
	@Override
	public String toString() {
		DecimalFormat dec = new DecimalFormat("#,##0.00VND");
		return super.toString() + "\n" +  "weeklySalary = " + weeklySalary + "\n" + "eamings = " + dec.format(eamings());
	}
}
