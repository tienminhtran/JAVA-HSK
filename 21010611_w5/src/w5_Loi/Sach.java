package w5_Loi;
import java.io.Serializable;
import java.util.Objects;


public class Sach implements Serializable  {
	private String masach,Tuasach,tacgia,nhaxuatban,isbn;
	private int namxuatban,sotrang,dongia;
	public Sach(String masach, String tuasach, String tacgia, String nhaxuatban, String isbn, int namxuatban,
			int sotrang, int dongia) {
		super();
		this.masach = masach;
		Tuasach = tuasach;
		this.tacgia = tacgia;
		this.nhaxuatban = nhaxuatban;
		this.isbn = isbn;
		this.namxuatban = namxuatban;
		this.sotrang = sotrang;
		this.dongia = dongia;
	}
	public Sach() {
		super();
	}
	public String getMasach() {
		return masach;
	}
	public void setMasach(String masach) {
		
		this.masach = masach;
	}
	public String getTuasach() {
		return Tuasach;
	}
	public void setTuasach(String tuasach) {
		Tuasach = tuasach;
	}
	public String getTacgia() {
		return tacgia;
	}
	public void setTacgia(String tacgia) {
		this.tacgia = tacgia;
	}
	public String getNhaxuatban() {
		return nhaxuatban;
	}
	public void setNhaxuatban(String nhaxuatban) {
		this.nhaxuatban = nhaxuatban;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public int getNamxuatban() {
		return namxuatban;
	}
	public void setNamxuatban(int namxuatban) {
		this.namxuatban = namxuatban;
	}
	public int getSotrang() {
		return sotrang;
	}
	public void setSotrang(int sotrang) {
		this.sotrang = sotrang;
	}
	public int getDongia() {
		return dongia;
	}
	public void setDongia(int dongia) {
		this.dongia = dongia;
	}
	@Override
	public String toString() {
		return "model [masach=" + masach + ", Tuasach=" + Tuasach + ", tacgia=" + tacgia + ", nhaxuatban=" + nhaxuatban
				+ ", isbn=" + isbn + ", namxuatban=" + namxuatban + ", sotrang=" + sotrang + ", dongia=" + dongia + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(masach);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sach other = (Sach) obj;
		return Objects.equals(masach, other.masach);
	}
	
}
