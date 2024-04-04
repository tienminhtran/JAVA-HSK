package w5_Loi;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

public class DsSach implements Serializable {
	public List<Sach> dssach;
	public DsSach() {
		dssach= new ArrayList<>();
	}
	public List<Sach> getDssach() {
		return dssach;
	}
	public void setDssach(List<Sach> dssach) {
		this.dssach = dssach;
	}
	public boolean themSach(Sach s) 
	{
		if(dssach.contains(s)) 
		{
			return false;
		}
		dssach.add(s);
		return true;
	}
	public boolean xoaSach(int index) 
	{
		if(index>=0&&index<=dssach.size()-1) 
		{
			dssach.remove(index);
			return true;
		}
		return false;	
	}
	public Sach timSach(String masach) 
	{
		for (Sach sach : dssach) {
			if(sach.getMasach().equals(masach)) 
			{
				return sach;
			}
		}
		return null;
	}
	public void SuaSach(int index, Sach s) 
	{
			dssach.get(index).setDongia(s.getDongia());
			dssach.get(index).setIsbn(s.getIsbn());
			dssach.get(index).setMasach(s.getMasach());
			dssach.get(index).setNamxuatban(s.getNamxuatban());
			dssach.get(index).setNhaxuatban(s.getNhaxuatban());
			dssach.get(index).setSotrang(s.getSotrang());
			dssach.get(index).setTacgia(s.getTacgia());
			dssach.get(index).setTuasach(s.getTuasach());
			
	}
	public String[] getMaSach() 
	{
		ArrayList<String> list= new ArrayList<>();
		for (Sach sach : dssach) {
			list.add(sach.getMasach());
		}
		return list.toArray(new String[0]);
	}
	

}
