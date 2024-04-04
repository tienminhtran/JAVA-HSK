package Demo.gk_CuocPhi;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class CuocPhi {
	private ThueBao thueBao;
	private int thang;
	private int nam;
	private int soMBSuDung;
	private int GIACHUAN = 500;
	private int GIAVUOT = 400;

	public CuocPhi(ThueBao thueBao, int thang, int nam, int soMBSuDung, int gIACHUAN, int gIAVUOT) {
		this.thueBao = thueBao;
		setThang(thang);
		setNam(nam);
		setSoMBSuDung(soMBSuDung);
		GIACHUAN = 500;
		GIAVUOT = 400;
		//setGIAVUOT(gIAVUOT);
		
	}

	public CuocPhi() {
		this.thueBao = thueBao;
		this.thang = 1;
		this.nam = 2022;
		this.soMBSuDung = 0;
		GIACHUAN = 500;
		GIAVUOT = 400;
	}

	public ThueBao getThueBao() {
		return thueBao;
	}

	public void setThueBao(ThueBao thueBao) {
		this.thueBao = thueBao;
	}

	public int getThang() {
		return thang;
	}

	public void setThang(int thang) {
		if (thang >= 1 && thang <= 12)
			this.thang = thang;
		else
			this.thang = 01;
	}

	public int getNam() {
		return nam;
	}

	public void setNam(int nam) {
		if (nam >= 2022)
			this.nam = nam;
		else
			this.nam = 2022;
	}

	public int getSoMBSuDung() {
		return soMBSuDung;
	}

	public void setSoMBSuDung(int soMBSuDung) {
		if (soMBSuDung >= 0)
			this.soMBSuDung = soMBSuDung;
		else
			this.soMBSuDung = 0;
	}

	public int getGIACHUAN() {
		return GIACHUAN;
	}

	public void setGIACHUAN(int gIACHUAN) {
		if (gIACHUAN >= 0)
			this.GIACHUAN = gIACHUAN;
		else
			this.GIACHUAN = 500;
	}

	public int getGIAVUOT() {
		return GIAVUOT;
	}

	public void setGIAVUOT(int gIAVUOT) {
		if (gIAVUOT >= 0)
			this.GIAVUOT = gIAVUOT;
		else
			this.GIAVUOT = 400;
	}

	public boolean vuotChuan()
	{
		if(getGIAVUOT() >200)
			return true;
		else
			return false;
	}
	public double tinhTien()
	{
//		double tmp = 
		if(soMBSuDung <= 200)
		{
			return soMBSuDung*GIACHUAN;
		}else
			return (soMBSuDung - 200)*GIAVUOT + 200*GIACHUAN;
	}
	public String getTieuDe()
	{
		return String.format("%-25s %-10s %20s %30s", "Ten thue bao", "Thang/nam", "So MB su dung", "Thanh Tien");
	}
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,##0");
		return String.format("%-25s %d/%d %24d %30s ",thueBao.toString(),thang, nam,soMBSuDung, df.format(tinhTien()));
	}

 
}
