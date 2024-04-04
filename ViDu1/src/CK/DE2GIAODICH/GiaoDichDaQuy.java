package CK.DE2GIAODICH;

import java.time.LocalDate;

public class GiaoDichDaQuy extends GiaoDich {
	private String loaiDa;
	private int soCara;
	public GiaoDichDaQuy(String maGD, LocalDate ngayGD, double donGia, String loaiDa, int soCara) {
		super(maGD, ngayGD, donGia);
		this.loaiDa = loaiDa;
		this.soCara = soCara;
	}
	public String getLoaiDa() {
		return loaiDa;
	}
	public void setLoaiDa(String loaiDa) {
		this.loaiDa = loaiDa;
	}
	public int getSoCara() {
		return soCara;
	}
	public void setSoCara(int soCara) {
		this.soCara = soCara;
	}
	@Override
	public double tinhThanhTien() {
		if(loaiDa.equalsIgnoreCase("Kim cuong") && soCara > 2) {
			return soCara*donGia+0.3*soCara*donGia;
		} else if(loaiDa.equalsIgnoreCase("Kim cuong") && soCara < 2) {
			return soCara*donGia;
		} else {
			return soCara*donGia+0.1*soCara*donGia;
		}
	}
	@Override
	public String toString() {
		return "GiaoDichDaQuy "+super.toString()+", loaiDa=" + loaiDa + ", soCara=" + soCara + ", tinhThanhTien()=" + tinhThanhTien() ;
	}
	
	
	
}
