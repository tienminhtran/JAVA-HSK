package Demo.Q;
import java.time.LocalDate;

public class NhanVienNoi extends NhanVien{
	private String loaiSuatAn;

	public String getLoaiSuatAn() {
		return loaiSuatAn;
	}

	public void setLoaiSuatAn(String loaiSuatAn) {
		if(loaiSuatAn.equalsIgnoreCase("cong nghiep")||loaiSuatAn.equalsIgnoreCase("phuc vu"))
			this.loaiSuatAn = loaiSuatAn;
		else
			this.loaiSuatAn = "Truyen";
	}

	@Override
	public String toString() {
		return "PhimNoi: " + super.toString()+"loaiSuatAn=" + loaiSuatAn+"\n";
	}

	public NhanVienNoi(String maNhanVien, String tenNhanVien, String diaChi, int soSuat, double giaSuatAn,
			LocalDate ngaysinh, String loaiSuatAn) {
		super(maNhanVien, tenNhanVien, diaChi, soSuat, giaSuatAn, ngaysinh);
		this.loaiSuatAn = loaiSuatAn;
	}
	@Override
	public double tinhTienAn() {
		if(loaiSuatAn.equalsIgnoreCase("cong nghiep")) 
		{
			return getSoSuat()*getGiaSuatAn();
		}
		else 
			return getSoSuat()*getGiaSuatAn()+(0.5*getGiaSuatAn());
	}
	
}
