package bai07.Module03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;



public class Management {
	private List<Person> danhSach;

	public List<Person> getDanhSach() {
		return danhSach;
	}

	public int getLength() {
		return danhSach.size();
	}

	public Management() {
		danhSach = new ArrayList<Person>();
	}

	public boolean them(Person p) {
		if (danhSach.contains(p))
			return false;
		danhSach.add(p);
		return true;
	}
	/**
	 * 
	 * @param ma
	 * @return true neu xoa duoc
	 */
	public boolean xoa(String hoten) {
		return danhSach.removeIf(pe->pe.getHoTen()==hoten);
	}
	
	public void sapXepTheoTenTangDan() {
		Collections.sort(danhSach, new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				if(o1==null || o2==null) return 0; 
				return o1.getHoTen().compareToIgnoreCase(o2.getHoTen());
			}
		});
	}
	@Override
	public String toString() {
		String s = "";
		for (Person person : danhSach) {
			s = s + person + "\n";
		}
		return s;
	}

	
}
