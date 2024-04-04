package bai06.Module03;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

//HÃ ng Ä‘iá»‡n mÃ¡y cáº§n biáº¿t: thá»�i gian báº£o hÃ nh bao nhiÃªu thÃ¡ng (>=0), cÃ´ng suáº¥t bao nhiÃªu KW (>=0).
public class HangDienMay extends HangHoa {
	private int thoiGianBaoHanh;
	private double congSuat;

	public HangDienMay(String maHang, String tenHang, double donGia, int soLuongTon, int thoiGianBaoHanh,
			double congSuat) {
		super(maHang, tenHang, donGia, soLuongTon);
		setThoiGianBaoHanh(thoiGianBaoHanh);
		setCongSuat(congSuat);
	}

	public HangDienMay() {
		this.thoiGianBaoHanh = 0;
		this.congSuat = 0;
	}

	public int getThoiGianBaoHanh() {
		return thoiGianBaoHanh;
	}

	public void setThoiGianBaoHanh(int thoiGianBaoHanh) {
		if (thoiGianBaoHanh >= 0)
			this.thoiGianBaoHanh = thoiGianBaoHanh;
		else
			this.thoiGianBaoHanh = 0;
	}

	public double getCongSuat() {
		return congSuat;
	}

	public void setCongSuat(double congSuat) {
		if (congSuat >= 0)
			this.congSuat = congSuat;
		else
			this.congSuat = 0;
	}
	
	@Override
	public boolean mucDoBuonBan() {
		if (this.getSoLuongTon() < 3) {
			return true;
		}
		return false;
	}

	@Override
	public double tinhTienVAT() {
		
		return getDonGia()*0.1;
	}
	@Override
	public String toString() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("#,##0");
		String s = "-";
		return String.format("%s|%-15s|%-20s|%-20s|%20s|%20s|%-20s|%-20s|%-20s|%20s|", super.toString(),s,s,s
				,thoiGianBaoHanh, congSuat,s,s,mucDoBuonBan()?"Ban duoc" : "Khong danh gia",df.format(tinhTienVAT()));
//		return String.format("%s, Thoi gian bao han: %d(thang), Cong xuat: %.2f(W), Muc do: %s, Tinh tien VAT: %s", super.toString(), thoiGianBaoHanh, congSuat, mucDoBuonBan()?"Ban duoc" : "Khong danh gia",df.format(tinhTienVAT()));
	}
}
