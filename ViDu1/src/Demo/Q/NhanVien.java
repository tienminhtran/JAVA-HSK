package Demo.Q;
import java.time.LocalDate;
import java.util.Objects;

public abstract class NhanVien {
	private String maNhanVien,tenNhanVien,diaChi;
	private int soSuat;
	private double giaSuatAn;
	private LocalDate ngaysinh;
	public String getMaNhanVien() {
		return maNhanVien;
	}
	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	public String getTenNhanVien() {
		return tenNhanVien;
	}
	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public int getSoSuat() {
		return soSuat;
	}
	public void setSoSuat(int soSuat) {
		this.soSuat = soSuat;
	}
	public double getGiaSuatAn() {
		return giaSuatAn;
	}
	public void setGiaSuatAn(double giaSuatAn) {
		this.giaSuatAn = giaSuatAn;
	}
	public LocalDate getNgaysinh() {
		return ngaysinh;
	}
	public void setNgaysinh(LocalDate ngaysinh) {
		this.ngaysinh = ngaysinh;
	}
	public NhanVien(String maNhanVien, String tenNhanVien, String diaChi, int soSuat, double giaSuatAn,
			LocalDate ngaysinh) {
		this.maNhanVien = maNhanVien;
		this.tenNhanVien = tenNhanVien;
		this.diaChi = diaChi;
		this.soSuat = soSuat;
		this.giaSuatAn = giaSuatAn;
		this.ngaysinh = ngaysinh;
	}
	public NhanVien() {
	}
	@Override
	public String toString() {
		return "NhanVien [maNhanVien=" + maNhanVien + ", tenNhanVien=" + tenNhanVien + ", diaChi=" + diaChi
				+ ", soSuat=" + soSuat + ", giaSuatAn=" + giaSuatAn + ", ngaysinh=" + ngaysinh + "]";
	}
	public abstract double tinhTienAn();
	
}
