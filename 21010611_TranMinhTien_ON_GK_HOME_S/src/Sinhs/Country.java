package Sinhs;

import java.io.Serializable;

public class Country implements Serializable{
	private String country, captital, population;
	private boolean democracy;
	public Country(String country, String captital, String population, boolean democracy) {
		super();
		this.country = country;
		this.captital = captital;
		this.population = population;
		this.democracy = democracy;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCaptital() {
		return captital;
	}
	public void setCaptital(String captital) {
		this.captital = captital;
	}
	public String getPopulation() {
		return population;
	}
	public void setPopulation(String population) {
		this.population = population;
	}
	public boolean isDemocracy() {
		return democracy;
	}
	public void setDemocracy(boolean democracy) {
		this.democracy = democracy;
	}
	@Override
	public String toString() {
		return "Country [country=" + country + ", captital=" + captital + ", population=" + population + ", democracy="
				+ democracy + "]";
	}
	
	
}
