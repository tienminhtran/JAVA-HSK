package Module04.bai06Cach2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;




public class QLDanhSachPH {
	private Set<Phong> dsPhong;

	public QLDanhSachPH() {
		dsPhong = new HashSet<Phong>();
	}

	public Set<Phong> getDsPhong() {
		return dsPhong;
	}
	/**
	 * 
	 * @param ma
	 * @return true nếu trùng mã; false không trùng
	 */
	public boolean trungMa(String ma) {
		for (Phong phong : dsPhong) {
			if(phong.getMaPhong().compareToIgnoreCase(ma)==0)
				return true;
		}
		return false;
	}
	public boolean them(Phong p) {
		if(!dsPhong.contains(p.getMaPhong()) && !trungMa(p.getMaPhong())) {
			dsPhong.add(p);
			return true;
		}
		return false;
	}
	public String layTieuDe()
	{
		return String.format("%-8s %-7s %-9s %-11s %-18s","Ma Phong","Day Nha","Dien tich","So Bong Den","Kiem tra dat chuan");
	}
	

	public String toString() {
		String str = "";
		for (Phong phong : dsPhong) {
			str +=phong +"\n";
		}
		return str;
	}

	
	/**
	 * tìm chỉ xuất ra những thông tin không trùng
	 * @param bd
	 * @return thông tin phòng có số bóng đèn
	 */
	public Phong timSoBongDen(int bd) {
		for (Phong phong : dsPhong) {
			if(phong.getSoBongDen()==bd)
				return phong;
		}
		return null;
	}

	
	public QLDanhSachPH timMaPhong(String ma)
	{
		QLDanhSachPH kq = new QLDanhSachPH();
		for (Phong phong : dsPhong) {
			if(phong.getMaPhong().contains(ma))
				kq.them(phong);
		}
		return kq;
	}
	public QLDanhSachPH layDanhSachPhongMayTinh() {
		QLDanhSachPH kq = new QLDanhSachPH();
		for (Phong phong : dsPhong) {
			if(phong instanceof PhongMayTinh)
				kq.them(phong);
		}
		return kq;
	}
	
//	public void sapXepTangDanTheoDayNha() {
//		Collections.sort(dsPhong, new Comparator<Phong>() {
//
//			@Override
//			public int compare(Phong o1, Phong o2) {
//				if(o1 == null || o2 == null)
//				{
//					return -1;
//				}
//				return o1.getDayNha().compareToIgnoreCase(o2.getDayNha());
//			}
//	
//		});
//	}
	public List<Phong> sapXepTangDanTheoDayNha(){
		List<Phong> kq = new ArrayList<Phong>();
		kq.addAll(dsPhong);
		Collections.sort(kq, new Comparator<Phong>() {

			@Override
			public int compare(Phong o1, Phong o2) {
				if(o1 == null || o2 == null)
					return -1;
				else
					return o1.getDayNha().compareToIgnoreCase(o2.getDayNha());
			}
			
		});
		return kq;
	}
	
}
