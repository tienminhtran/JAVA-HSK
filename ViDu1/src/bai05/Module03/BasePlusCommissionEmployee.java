package bai05.Module03;

import java.text.DecimalFormat;

public class BasePlusCommissionEmployee extends CommissionEmployee {
	private double baseSalary;

	public BasePlusCommissionEmployee(String firstName, String lastName, String socialSecurityNumber, double grossSales,
			double commissionRale, double baseSalary) {
		super(firstName, lastName, socialSecurityNumber, grossSales, commissionRale);
		this.baseSalary = baseSalary;
	}

	public double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}
	
	@Override
	public double eamings() {
		return super.eamings() + baseSalary;
	}
	
	@Override
	public String toString() {
		DecimalFormat dec = new DecimalFormat("#,##0.00VND");
		return super.toString() +"\nbaseSalary = "+baseSalary+ "\n" + "eamings = " + dec.format(eamings()) ;
	}
}
