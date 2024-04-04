package CK.NhanVien;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class QuanLyNhanVien {

	private List<NhanVien> ds;

	public QuanLyNhanVien() {
		ds = new ArrayList<>();
	}

	public List<NhanVien> getDs() {
		return ds;
	}

	public String layTieuDe()
	{
		return String.format("%-10s%-10s%-10s%-10s%-10s%-10s%-10s", "Ma nv", "HSL","Phu cap", "Trinh do", "Tiet","Ngay nghi","Luong");
	}
	@Override
	public String toString() {
		String s = "";
		s = s + layTieuDe() + "\n";
		for (NhanVien nhanVien : ds) {
			s = s + nhanVien + "\n";
		}
		return s;
	}

	public boolean themNhanVien(NhanVien nv)
	{
		if(!ds.contains(nv))
		{
			ds.add(nv);
			return true;
		}
		return false;
	}

	public boolean xoaNhanVien(String ma)
	{
		return ds.removeIf(p->p.getMaNhanVien().equalsIgnoreCase(ma));
	}
	
	public List<NhanVien> sapXepMaGiam()
	{
		List<NhanVien> kq = new ArrayList<NhanVien>();
		kq.addAll(ds);
		Collections.sort(kq, new Comparator<NhanVien>() {

			@Override
			public int compare(NhanVien o1, NhanVien o2) {
				if(o1 == null || o2 == null)
				{
					return -1;
				}
				return o2.getMaNhanVien().compareToIgnoreCase(o1.getMaNhanVien());
			}
			
		});
		return kq;
	}
	
	public QuanLyNhanVien layThongTinTienSi()
	{
		QuanLyNhanVien kq = new QuanLyNhanVien();
		for (NhanVien nhanVien : ds) {
			if(nhanVien instanceof GiangVien)
			{
				if(((GiangVien)nhanVien).getTrinhDo()==TrinhDo.TS)
				{
					kq.themNhanVien(nhanVien);
				}
			}
		}
		return kq;
	}
	
	public QuanLyNhanVien phuCapLonNhat()
	{
		double max = -1e9;		
		QuanLyNhanVien kq = new QuanLyNhanVien();
		for (NhanVien nhanVien : ds) {
			if(nhanVien.getPhuCap() > max)
			{
				max = nhanVien.getPhuCap();
				
			}
		}
		for (NhanVien nhanVien : ds) {
			if(nhanVien.getPhuCap()==max )
				kq.themNhanVien(nhanVien);
		}
		return kq;
	}
}
