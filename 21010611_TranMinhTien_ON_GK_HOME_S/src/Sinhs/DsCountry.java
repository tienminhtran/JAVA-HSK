package Sinhs;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class DsCountry implements Serializable {
	private List<Country> dsCtry;

	public DsCountry() {
		dsCtry = new ArrayList<Country>();
	}

	public List<Country> getDsCtry() {
		return dsCtry;
	}
	
	public boolean themCtr(Country other_ctry) {
		for (int i = 0; i < dsCtry.size(); i++) {
			if(dsCtry.get(i).getCountry().equals(other_ctry.getCountry())) {
				return false;
			}
		}
		dsCtry.add(other_ctry);
		return true;
	}

	
	public boolean xoa(int index) {
		if(index>=0 && index <= dsCtry.size()-1) {
			dsCtry.remove(index);
			return true;
		}
		return false;
	}
	
	public Country timKiem(String ctr) {
		for (Country country : dsCtry) {
			if(country.getCountry().equalsIgnoreCase(ctr)) {
				return country;
			}
		}
		return null;
	}
	
	public void sua(Country ctr) {
		
			this.dsCtry.remove(ctr);
			this.dsCtry.add(ctr);
		
	}
}
