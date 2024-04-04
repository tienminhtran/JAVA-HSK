package CK.DE2GIAODICH;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DanhSachGiaoDich {
	
	private List<GiaoDich> dsGiaoDich;
	
	public DanhSachGiaoDich() {
		dsGiaoDich = new ArrayList<GiaoDich>();
	}
	
	public boolean them(GiaoDich gd) {
		if(!dsGiaoDich.contains(gd.getMaGD())) {
			dsGiaoDich.add(gd);
			return true;
		}
		return false;
	}
	
	public boolean xoaGD(String ma) {
		return dsGiaoDich.removeIf(gd->gd.getMaGD().equalsIgnoreCase(ma));
	}
	
	public void sapXepTang() {
		Collections.sort(dsGiaoDich, new Comparator<GiaoDich>() {

			@Override
			public int compare(GiaoDich o1, GiaoDich o2) {
				return o1.getMaGD().compareToIgnoreCase(o2.getMaGD());
			}
		});
	}
	
	public boolean sua(String ma, double dg) {
		for (GiaoDich giaoDich : dsGiaoDich) {
			if(giaoDich.getMaGD().equalsIgnoreCase(ma)) {
				giaoDich.setDonGia(dg);
				return true;
			}
		}
		return false;
	}
	
	public DanhSachGiaoDich xuatGD() {
		DanhSachGiaoDich ds = new DanhSachGiaoDich();
		for (GiaoDich giaoDich : dsGiaoDich) {
			if(giaoDich.getNgayGD().isEqual(LocalDate.of(2021, 12, 25))) {
				ds.them(giaoDich);
			}
		}
		return ds;
	}
	@Override
	public String toString() {
		String str = "";
		for (GiaoDich giaoDich : dsGiaoDich) {
			str += giaoDich +"\n";
		}
		return str;
	}
	
}
