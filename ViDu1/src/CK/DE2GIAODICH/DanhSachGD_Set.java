package CK.DE2GIAODICH;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DanhSachGD_Set {
	private Set<GiaoDich> dsSet;

	public DanhSachGD_Set() {
		dsSet = new HashSet<GiaoDich>();
	}
	
	public boolean themGD(GiaoDich o_ther) {
		if(!dsSet.contains(o_ther)) {
			dsSet.add(o_ther);
			return true;
		}
		return false;
	}
	
	public boolean xoa(String maTim) {
		return dsSet.removeIf(gd -> gd.getMaGD().equalsIgnoreCase(maTim));
	}
	
	public List<GiaoDich> dsSapXepTang() {
		List<GiaoDich> dsList = new ArrayList<GiaoDich>();
		dsList.addAll(dsSet);
		Collections.sort(dsList, new Comparator<GiaoDich>() {

			@Override
			public int compare(GiaoDich o1, GiaoDich o2) {
				if(o1 == null ||o2 == null) {
					return 0;
				}
				return o1.getMaGD().compareToIgnoreCase(o2.getMaGD());
			}
		});
		return dsList;
	}
	
	public boolean capNhat(String ma, double donGiaMoi) {
		for (GiaoDich giaoDich : dsSet) {
			if(giaoDich.getMaGD().equalsIgnoreCase(ma)) {
				giaoDich.setDonGia(donGiaMoi);
				return true;
			}
		}
		return false;
	}
	
	public DanhSachGD_Set xuatGDNgay() {
		DanhSachGD_Set ds = new DanhSachGD_Set();
		for (GiaoDich giaoDich : dsSet) {
			if(giaoDich.getNgayGD().isEqual(LocalDate.of(2021, 12, 25))) {
				ds.themGD(giaoDich);
			}
		}
		return ds;
	}
	
	@Override
	public String toString() {
		String str = "";
		for (GiaoDich giaoDich : dsSet) {
			str += giaoDich +"\n";
		}
		return str;
	}
}
