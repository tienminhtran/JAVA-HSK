package deQuyenTHITHUCHANH;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class NhanVien {
	private String maNV;
	private String tenNV;
	private LocalDate ngaySinh;
	private String diaChi;
	private int soSuatAn;
	private double giaSuatAn;

	public NhanVien(String maNV, String tenNV, LocalDate ngaySinh, String diaChi, int soSuatAn, double giaSuatAn) {
		super();
		setMaNV(maNV);
		setTenNV(tenNV);
		setNgaySinh(ngaySinh);
		setDiaChi(diaChi);
		setSoSuatAn(soSuatAn);
		setGiaSuatAn(giaSuatAn);
	}

	public NhanVien() {
		this.maNV = "xxx";
		this.tenNV = "xxx";
		this.ngaySinh = LocalDate.of(2022, 1, 1);
		this.diaChi = "xxx";
		this.soSuatAn = 1;
		this.giaSuatAn = 1;
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		if (!maNV.trim().equals("")) {
			this.maNV = maNV;
		} else {
			this.maNV = "xxx";
		}
	}

	public String getTenNV() {
		return tenNV;
	}

	public void setTenNV(String tenNV) {
		if (!tenNV.trim().equals("")) {
			this.tenNV = tenNV;
		} else {
			this.tenNV = "xxx";
		}
	}

	public LocalDate getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(LocalDate ngaySinh) {
		if (ngaySinh.isBefore(LocalDate.now())) {
			this.ngaySinh = ngaySinh;
		} else {
			this.ngaySinh = LocalDate.of(2022, 1, 1);
		}
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		if (!diaChi.trim().equals("")) {
			this.diaChi = diaChi;
		} else {
			this.diaChi = "xxx";
		}
	}

	public int getSoSuatAn() {
		return soSuatAn;
	}

	public void setSoSuatAn(int soSuatAn) {
		if (soSuatAn > 0) {
			this.soSuatAn = soSuatAn;
		} else {
			this.soSuatAn = 1;
		}
	}

	public double getGiaSuatAn() {
		return giaSuatAn;
	}

	public void setGiaSuatAn(double giaSuatAn) {
		if (giaSuatAn > 0) {
			this.giaSuatAn = giaSuatAn;
		} else {
			this.giaSuatAn = 1;
		}
	}
	
	public abstract double tinhTien(); 
	
	public static String getTieuDe() {
		return String.format("%-10s%10s%14s%20s%14s%14s", "Ma NV","Ten NV","Ngay Sinh","Dia Chi","So Suat An","Gia Suat An");
	}
	
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,##0.00");
		DateTimeFormatter dateTF = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return String.format("%-10s%10s%14s%20s%14d%14s", maNV,tenNV,dateTF.format(ngaySinh),diaChi,soSuatAn,df.format(giaSuatAn));
	}
	
}
