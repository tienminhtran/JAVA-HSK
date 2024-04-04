package Demo.Q;
import java.time.LocalDate;

public class NhanVienNgoai extends NhanVien{
	private double thue;

	public double getThue() {
		return thue;
	}

	public void setThue(double thue) {
		this.thue = thue;
	}

	public NhanVienNgoai(String maNhanVien, String tenNhanVien, String diaChi, int soSuat, double giaSuatAn,
			LocalDate ngaysinh, double thue) {
		super(maNhanVien, tenNhanVien, diaChi, soSuat, giaSuatAn, ngaysinh);
		this.thue = thue;
	}

	@Override
	public String toString() {
		return "NhanVienNgoai [thue=" + thue + "]";
	}

	@Override
	public double tinhTienAn() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
