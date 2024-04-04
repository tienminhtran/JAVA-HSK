package CK.DE1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class QLDSNV_List {
	private List<Employee> dsEmployees;

	public QLDSNV_List() {
		dsEmployees = new ArrayList<Employee>();
	}
	
	public boolean themNV(Employee other) {
		if(!dsEmployees.contains(other)) {
			dsEmployees.add(other);
			return true;
		}
		return false;
	}
	
	public int demSoLuongNVTotNghiep() {
		int dem = 0;
		for (Employee e: dsEmployees) {
			if(e instanceof Fresher) {
				if(((Fresher)e).getGradYear() == LocalDate.now().getYear()) {
					dem++;
				}
			}
		}
		return dem;
	}
	public boolean suaNgaySinhCuaNV(String matim, LocalDate nS_other) {
		for (Employee employee : dsEmployees) {
			if(employee.getID().equalsIgnoreCase(matim)) {
				employee.setBirthday(nS_other);
				return true;
			}
		}
		return false;
	}
	
	public QLDSNV_List layDSNVKinhNghiemHon5Nam() {
		QLDSNV_List ds = new QLDSNV_List();
		for (Employee employee : dsEmployees) {
			if(employee instanceof Experience) {
				if(((Experience) employee).getExpInyear() > 5) {
					ds.themNV(employee);
				}
				
			}
		}
		return ds;
	}
	
	public void sapXepTenTangDan() {
		Collections.sort(dsEmployees, new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {
				if(o1 == null || o2 == null) {
					return 0;
				}
				return o1.getFullName().getFirstName().compareToIgnoreCase(o2.getFullName().getFirstName());
			}
			
		});
	}
	
	public String toString() {
		String str = "";
		for (Employee employee : dsEmployees) {
			str += employee +"\n";
		}
		return str;
	}
}
