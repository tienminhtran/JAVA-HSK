package VangBac_1;

import java.time.LocalDate;

public class Giaodichdaquy extends GiaoDich {

	private String loaiDa;
	private double soCarat;

	public Giaodichdaquy(String maGiaoDich, LocalDate ngayGiaoDich, double donGia, String loaiDa, double soCarat) {
		super(maGiaoDich, ngayGiaoDich, donGia);
		setLoaiDa(loaiDa);
		setSoCarat(soCarat);
//		this.loaiDa = loaiDa;
//		this.soCarat = soCarat;
	}

	public String getLoaiDa() {
		return loaiDa;
	}

	public void setLoaiDa(String loaiDa) {
		if (loaiDa.equalsIgnoreCase("Kim cuong") || loaiDa.equalsIgnoreCase("Cam thach")) {
			this.loaiDa = loaiDa;
		} else
			this.loaiDa = "Kim cuong";
	}

	public double getSoCarat() {
		return soCarat;
	}

	public void setSoCarat(double soCarat) {
		if (soCarat > 0)
			this.soCarat = soCarat;
		else
			this.soCarat = 0;
	}

	@Override
	public double tinhThanhTien() {
		if(loaiDa.equalsIgnoreCase("Kim cuong"))
		{
			if(soCarat >=2)
			{
				return soCarat*super.getDonGia()
				+0.3*(soCarat*super.getDonGia());
			}
			else // soCarat <2
			{
				return soCarat*super.getDonGia();
			}
		}
		else
			return soCarat*super.getDonGia() + 0.1*(soCarat*super.getDonGia());
	}

	@Override
	public String toString() {
		return "Giaodichdaquy [loaiDa=" + loaiDa + ", soCarat=" + soCarat + ", toString()=" + super.toString() + "]";
	}

	

}
