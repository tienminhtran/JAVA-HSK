package CK.TUGIAID1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class QLDS {
	private List<Employee> ds;

	public QLDS() {
		ds = new ArrayList<>();
	}

	public List<Employee> getDs() {
		return ds;
	}

	public boolean themNhanVien(Employee e) {
		if (!ds.contains(e) ){
			ds.add(e);
			return true;
		}
		return false;
	}

	public String getTieuDe() {
		return String.format("%-15s %-20s %-15s %-15s %-15s %-15s %-15s %-15s %-15s",
				"Ma","Ho ten","Ngay sinh","SDT","Kinh nghiem","Nam tot nghiep","Loai TN","Chuyen nganh","Hoc ky");
				
	}
	@Override
	public String toString() {
		String s = "";
		s = s + getTieuDe() +"\n";
		for (Employee employee : ds) {
			s = s+employee+"\n";
		}
		return s;
	}
	public int demSoLuongNhanVienToNghiep()
	{
		int dem = 0;
		for (Employee employee : ds) {
			if(employee instanceof Fresher)
			{
				if(((Fresher)employee).getNamTotNghiep() == LocalDate.now().getYear())
					dem++;
			}
		}
		return dem;
	}
	
	public QLDS DSNhanVienToNghiep()
	{
		QLDS kq = new QLDS();
		for (Employee employee : ds) {
			if(employee instanceof Fresher)
			{
				if(((Fresher)employee).getNamTotNghiep() == LocalDate.now().getYear())
					kq.themNhanVien(employee);
			}
		}
		return kq;
	}
	public boolean suaNgaySinh(String maSua, LocalDate ngaySua)
	{
		for (Employee employee : ds) {
			if(employee.getMa().equalsIgnoreCase(maSua)) {
				employee.setNgaySinh(ngaySua);
				return true;
			}
			
		}
		return false;
	}

	public QLDS layDanhSachNV5NAM() {
		QLDS kq = new QLDS();
		for (Employee employee : ds) {
			if(employee instanceof Experience)
			{
				if(((Experience)employee).getSoNamKinhNghiem() >=5)
				{
					kq.themNhanVien(employee);
				}
				
				
			}
		}
		return kq;
	}
	public List<Employee> sapXepTenTangDan() {

		List <Employee> kq = new ArrayList<Employee>();
		kq.addAll(ds);
		Collections.sort(kq, new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {
						if(o1 == null || o2 == null) {
					
					return -1;
				}
				return o1.getHoTen().getFirstName().compareToIgnoreCase(o2.getHoTen().getFirstName());
			}
			
		});
		return kq;
	}

//	private List<Employee> ds;
//
//	public QLDS() {
//		ds = new ArrayList<>();
//	}
//
//	public List<Employee> getDs() {
//		return ds;
//	}
//
//	public boolean them(Employee e)
//	{
//		if(!ds.contains(e.getMa()))
//		{
//			ds.add(e);
//			return true;
//		}
//		return false;
//	}
//
//	@Override
//	public String toString() {
//		String s ="";
//		for (Employee employee : ds) {
//			s = s + employee + "\n";
//		}
//		return s;
//	}
//	
//	public int demSLNV() {
//		int dem = 0;
//		for (Employee employee : ds) {
//			if(employee instanceof Fresher)
//			{
//				if(((Fresher)employee).getNamTotNghiep()==LocalDate.now().getYear())
//				{
//					dem++;
//				}
//			}
//		}
//		return dem;
//	}
//	
//	public QLDS layDSNVTN()
//	{
//		QLDS kq = new QLDS();
//		for (Employee employee : ds) {
//			if(employee instanceof Fresher)
//			{
//				if(((Fresher)employee).getNamTotNghiep() == LocalDate.now().getYear())
//				{
//					kq.them(employee);
//				}
//			}
//		}
//		return kq;
//	}
//	
//	public boolean suaNgaySinhNhanVien(String maTim, LocalDate ngaySua)
//	{
//		for (Employee employee : ds) {
//			if(employee.getMa().compareToIgnoreCase(maTim)==0)
//			{
//				
//				employee.setNgaySinh(ngaySua);
//				return true;
//			}
//		}
//		return false;
//	}
//	
//	public List<Employee> sapXepNhanVien(){
//		List<Employee> kq = new ArrayList<Employee>();
//		kq.addAll(ds);
//		Collections.sort(kq, new Comparator<Employee>() {
//
//			@Override
//			public int compare(Employee o1, Employee o2) {
//				if(o1 == null || o2 == null)
//				{
//					return -1;
//				}
//				return o1.getHoTen().getFirstName().compareToIgnoreCase(o2.getHoTen().getFirstName());
//			}
//		
//		});
//		return kq;
//	}
	public boolean xoaMa(String ma) {
		return ds.removeIf(p->p.getMa().compareToIgnoreCase(ma)==0);
	}

}
