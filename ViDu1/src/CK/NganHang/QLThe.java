package CK.NganHang;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class QLThe {

	private List<TaiKhoan> ds;

	public QLThe() {
		ds =  new ArrayList<>();
	}

	public List<TaiKhoan> getDs() {
		return ds;
	}

	public boolean themTaiKhoan(TaiKhoan a)
	{
		if(!ds.contains(a))
		{
			ds.add(a);
			return true;
		}
		return false;
	}

	public String layTieuDe() {
		return String.format("%-10s%-10s%-10s%-10s%-10s%-10s", "Ma the","Ten chush","Tien co","Muctidung","TongQM","KNCT");
	}
	@Override
	public String toString() {
		String s = "";
		s = s + layTieuDe()+"\n";
		for (TaiKhoan taiKhoan : ds) {
			s = s + taiKhoan + "\n";
		}
		return s;
	}
	
	public int demSoLuongTheKhongConChiTieu()
	{
		int dem =0;
		for (TaiKhoan taiKhoan : ds) {
			if(taiKhoan instanceof TheTinDung)
			{
				if(((TheTinDung)taiKhoan).khaNangChiTieu() == false)
				{
					dem++;
					
				}
			}
		}
		return dem;
	}
	
	public boolean suaMucTinDung(String ma, double muctindung) {
		for (TaiKhoan taiKhoan : ds) {
			if(taiKhoan instanceof TheTinDung)
			{
				((TheTinDung)taiKhoan).setMucHanTinDung(muctindung);
				return true;
			}
			
		}
		return false;
	}
	
	public List<TaiKhoan> sapXepMaTheGiam()
	{
		List<TaiKhoan> kq = new ArrayList<TaiKhoan>();
		kq.addAll(ds);
		Collections.sort(kq, new Comparator<TaiKhoan>() {

			@Override
			public int compare(TaiKhoan o1, TaiKhoan o2) {
				if(o1 == null || o2 ==null)
				{
					return -1;
				}
				return o2.getMaThe().compareToIgnoreCase(o1.getMaThe());
			}
			
		});
		return  kq;
	}
}
