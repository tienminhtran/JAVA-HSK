package Sinh_w5;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class QLSach implements Serializable{
	private List<Sach> dsSach;
	
	public QLSach() {
		dsSach = new ArrayList<Sach>();
	}

	public List<Sach> getDsSach() {
		return dsSach;
	}
	
	/**
	 * Thêm sách
	 * @param other_sach
	 * @return
	 */
	public boolean themSach(Sach other_sach) {
		for (int i = 0; i < dsSach.size(); i++) {
			if(dsSach.get(i).getMaSach().equalsIgnoreCase(other_sach.getMaSach())) {
				return false;
			}
		}
		dsSach.add(other_sach);
		return true;
	}
	
	/**
	 * Xóa vị trí
	 * @param index
	 * @return
	 */
	public boolean xoaSach(int index) {
		if(index>=0 && index <= dsSach.size()-1) {
			dsSach.remove(index);
			return true;
		}
		return false;
	}
	
	/**
	 * Timf kieems
	 * @param ma
	 * @return
	 */
	public Sach timKiem(String ma) {
		for (Sach s : dsSach) {
			if (s.getMaSach().equalsIgnoreCase(ma)) {
				return s;
			}
		}
		return null;
	}
	
//	public boolean suaSach(String maSach, String tuaSach, String tacGia, int namXB, String nhaXB, int soTrang, double donGia,
//			String iSBN) {
//		Sach sach = new Sach(maSach, tuaSach, tacGia, namXB, nhaXB, soTrang, donGia, iSBN);
//		if(dsSach.contains(sach)) {
//			sach.setMaSach(maSach);
//			sach.setTuaSach(tuaSach);
//			sach.setTacGia(tacGia);
//			sach.setNamXB(namXB);
//			sach.setNhaXB(nhaXB);
//			sach.setSoTrang(soTrang);
//			sach.setDonGia(donGia);
//			sach.setISBN(iSBN);
//			return true;
//		} else {
//			return false;
//		}
//	}
	
	public void sua(Sach s) {
		this.dsSach.remove(s);
		this.dsSach.add(s);
	}
	
}
