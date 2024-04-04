package Demo.gk_TaiKhoan;

import java.text.DecimalFormat;

public class TaiKhoan {
	private int soTK;
	private KhachHang khachHang;
	private double soDu = 1000000.0;

	public TaiKhoan(int soTK, KhachHang khachHang, double soDu) {
		this.soTK = soTK;
		this.khachHang = khachHang;
		setSoDu(soDu);
	}

	public int getSoTK() {
		return soTK;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public double getSoDu() {
		return soDu;
	}

	public void setSoDu(double soDu) {
		if (soDu >= 100000)
			this.soDu = soDu;
		else
			this.soDu = 100000;
	}

	public boolean goiTien(double goi) throws Exception{
		if(soDu >=1000000 && goi>=0)
		{
			soDu = soDu + goi;
			return true;
		}
		else
			return false;
	}
	

	public boolean rutTien(double rut) {
		if(soDu > 1000000 && rut < soDu)
		{
			soDu = soDu - rut;
			return true;
		}
		else
			return false;
	}
	public String toString()
	{
		DecimalFormat df = new DecimalFormat("#,##0");
		return String.format("%s [SoTK= %d]So du hien tai = %s",khachHang.toString(),soTK,df.format(soDu) );
	}
}
