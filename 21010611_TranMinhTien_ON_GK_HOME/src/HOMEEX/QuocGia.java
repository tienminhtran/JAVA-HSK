package HOMEEX;

import java.io.Serializable;
import java.util.Objects;

public class QuocGia implements Serializable{
	private String country;
	private String capital;
	private int opulation;
	private boolean democracy;
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	public int getOpulation() {
		return opulation;
	}
	public void setOpulation(int opulation) {
		this.opulation = opulation;
	}
	public boolean isDemocracy() {
		return democracy;
	}
	public void setDemocracy(boolean democracy) {
		this.democracy = democracy;
	}
	public QuocGia(String country, String capital, int opulation, boolean democracy) {
		super();
		this.country = country;
		this.capital = capital;
		this.opulation = opulation;
		this.democracy = democracy;
	}
	@Override
	public String toString() {
		return "QuocGia [country=" + country + ", capital=" + capital + ", opulation=" + opulation + ", democracy="
				+ democracy + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(country);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		QuocGia other = (QuocGia) obj;
		return Objects.equals(country, other.country);
	}

}
