package Module04.bai06Cach1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class QLDanhSachPH {
	private List<Phong> dsPhong;

	public QLDanhSachPH() {
		dsPhong = new ArrayList<>();
	}

	public List<Phong> getDsPhong() {
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
	/**
	 * Tìm kiếm phòng
	 * @param maTim
	 * @return Phòng
	 */
	public Phong timKiemPhong(String maTim) {
		for (Phong phong : dsPhong) {
			if(phong.getMaPhong().compareToIgnoreCase(maTim)==0) {
				return phong;
			}
		}
		return null;
	}
	/**
	 * Tìm kiếm dãy nhà (được trùng)
	 * @return DANH SÁCH NẾU 
	 */
	public QLDanhSachPH timDayNha(String daynha)
	{
		QLDanhSachPH kq = new QLDanhSachPH();
		for (Phong phong : dsPhong) {
			if(phong.getDayNha().compareToIgnoreCase(daynha)==0)
				kq.them(phong);
		}
		return kq;
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
	 * Lấy danh sách phòng đạt chuẩn
	 * @return DANH SÁCH phòng đạt chuẩn
	 */
	public QLDanhSachPH dsPhongDatChuan() {
		QLDanhSachPH ds = new QLDanhSachPH();
		for (Phong phong : dsPhong) {
			if (phong.kiemTRaPhongDatChuan()) {
				ds.them(phong);
			}
		}
		return ds;
		
	}
	
	/**
	 * Lấy danh sách phòng đạt chuẩn
	 * LIST 
	 */
	public List<Phong> layPhongDatChuan(){
		List<Phong> a = new ArrayList<Phong>();
		for (Phong phong : dsPhong) {
			if (phong.kiemTRaPhongDatChuan()) {
				a.add(phong);
			}
		}
		
		return a;
	}
	
	
	
	/**
	 * Sắp xếp theo dãy nhà tăng 
	 * VOID  KIỂU STRING
	 */
	public void sapXepDsTangTheoDayNha() {
		Collections.sort(dsPhong, new Comparator<Phong>() {

			@Override
			public int compare(Phong o1, Phong o2) {
				if(o1 == null || o2 == null) {
					return -1;
				}
				return o1.getDayNha().compareToIgnoreCase(o2.getDayNha());
			}
			
		});
	}
	
	/**
	 * Sắp xếp theo dãy nhà tăng
	 * DS
	 */
	public QLDanhSachPH sapXepDsTangTheoDienTichKieuDS()
	{
		Collections.sort(dsPhong, new Comparator<Phong>() {
			@Override
			public int compare(Phong o1, Phong o2) {
				Double d1 = new Double(o1.getDienTich());
				Double d2 = new Double(o2.getDienTich());
				return d1.compareTo(d2);
			}
		});
		return null;
	}
	
	/**
	 * Sắp xếp theo dãy nhà tăng
	 * LIST
	 */
	public List<Phong> sapXepDayNha(){
		List<Phong> a = new ArrayList<Phong>();
		a.addAll(dsPhong);
		Collections.sort(a, new Comparator<Phong>() {

			@Override
			public int compare(Phong o1, Phong o2) {
				if(o1 == null || o2 == null) {
					return -1;
				}
				return o1.getDayNha().compareToIgnoreCase(o2.getDayNha());
			}
				
		});
		return a;
	}
	
	// VOID KIÊU SỐ
	
	public void sapXepDsGiamTheoDienTich() {
		Collections.sort(dsPhong, new Comparator<Phong>() {

			@Override
			public int compare(Phong o1, Phong o2) {
				if(o1 == null || o2 == null) {
					return -1;
				}
				Double p1 = new Double(o1.getDienTich());
				Double p2 = new Double(o2.getDienTich());
				return p1.compareTo(p2);
			}
			
		});
	}
	
	
	/**
	 * 
	 * @param maPhong
	 * @param soMayTinhMoi
	 * @return true cập nhật được, false không cập nhật được
	 */
	
	public boolean capNhatSoMayTinh(String maPhong, int soMayTinhMoi) {
		for (Phong phong : dsPhong) {
			if(phong instanceof PhongMayTinh) {
				if(phong.getMaPhong().equalsIgnoreCase(maPhong)) {
					((PhongMayTinh) phong).setMayTinh(soMayTinhMoi);
					return true;
				}
			}
		}
		return false;
	}
	/**
	 * 
	 * @param ma
	 * @return true xoá được
	 */
	public boolean xoaMaPhong(String ma) {
		return dsPhong.removeIf(p -> p.getMaPhong().equalsIgnoreCase(ma));
	}
	
	
	public int tongSoPhong() {
		return dsPhong.size();
	}
	
	public QLDanhSachPH dsPhongMay60May() {
		QLDanhSachPH ds = new QLDanhSachPH();
		for (Phong phong : dsPhong) {
			if(phong instanceof PhongMayTinh) {
				if(((PhongMayTinh)phong).getMayTinh() == 60) {
					ds.them(phong);
				}
			}
		}
		return ds;
	}
}
