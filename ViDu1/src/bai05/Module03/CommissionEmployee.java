package bai05.Module03;

import java.text.DecimalFormat;

public class CommissionEmployee extends Employee {
	private double grossSales;
	private double commissionRale;
	
	public CommissionEmployee(String firstName, String lastName, String socialSecurityNumber, double grossSales,
			double commissionRale) {
		super(firstName, lastName, socialSecurityNumber);
		this.grossSales = grossSales;
		this.commissionRale = commissionRale;
	}

	public double getGrossSales() {
		return grossSales;
	}

	public void setGrossSales(double grossSales) {
		this.grossSales = grossSales;
	}

	public double getCommissionRale() {
		return commissionRale;
	}

	public void setCommissionRale(double commissionRale) {
		this.commissionRale = commissionRale;
	}

	@Override
	public double eamings() {
		return grossSales * commissionRale;
	}
	
	@Override
	public String toString() {
		DecimalFormat dec = new DecimalFormat("#,##0.00VND");
		return super.toString() + "\ngrossSales = " +  grossSales + ", commissionRale = " + commissionRale+ "\n" + "eamings = " + dec.format(eamings());
	}
}
