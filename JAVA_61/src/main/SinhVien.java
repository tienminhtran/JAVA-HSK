package main;
/*
 * Xây dựng chương trình Quản lý Danh sách sinh viên
Thông tin Sinh viên gồm có:
 Mã sinh viên
Họ và tên 
Năm sinh
Điểm trung bình
Sử dụng ArrayList
Cho phép người dùng chọn lựa và thực hiện
o	Thêm sinh viên vào danh sách.
o	In danh sách sinh viên ra màn hình.
o	Kiểm tra danh sách có rỗng hay không.	
o	Lấy ra số lượng sinh viên trong danh sách.
o	Làm rỗng danh sách sinh viên.
o	Kiểm tra sinh viên có tồn tại trong danh sách hay không, dựa trên mã sinh viên
o	Xóa một sinh viên ra khỏi danh sách dựa trên mã sinh viên
o	Tìm kiếm tất cả sinh viên dựa trên Tên được nhập từ bàn phím
o	Xuất ra danh sách sinh viên có điểm từ cao đến thấp.

 */
import java.util.Objects;

public class SinhVien implements Comparable<SinhVien>{
	private String maSinhVien;
	private String hoVaTen;
	private int namSinh;
	private float diemTrungBinh;
	public SinhVien(String maSinhVien, String hoVaTen, int namSinh, float diemTrungBinh) {
		this.maSinhVien = maSinhVien;
		this.hoVaTen = hoVaTen;
		this.namSinh = namSinh;
		this.diemTrungBinh = diemTrungBinh;
	}
	
	public SinhVien(String maSinhVien) {
		this.maSinhVien = maSinhVien;
	}// áp dụng câu 6

	public String getMaSinhVien() {
		return maSinhVien;
	}
	public void setMaSinhVien(String maSinhVien) {
		this.maSinhVien = maSinhVien;
	}
	public String getHoVaTen() {
		return hoVaTen;
	}
	public void setHoVaTen(String hoVaTen) {
		this.hoVaTen = hoVaTen;
	}
	public int getNamSinh() {
		return namSinh;
	}
	public void setNamSinh(int namSinh) {
		this.namSinh = namSinh;
	}
	public float getDiemTrungBinh() {
		return diemTrungBinh;
	}
	public void setDiemTrungBinh(float diemTrungBinh) {
		this.diemTrungBinh = diemTrungBinh;
	}
	@Override
	public String toString() {
		return "SinhVien [maSinhVien=" + maSinhVien + ", hoVaTen=" + hoVaTen + ", namSinh=" + namSinh
				+ ", diemTrungBinh=" + diemTrungBinh + "]";
	}
	@Override
	public int compareTo(SinhVien o) {
		return this.maSinhVien.compareTo(o.maSinhVien);
	} // khai báo trên public class implements Comparable<SinhVien> so sánh 

	@Override
	public int hashCode() {
		return Objects.hash(diemTrungBinh, hoVaTen, maSinhVien, namSinh);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SinhVien other = (SinhVien) obj;
		return Objects.equals(maSinhVien, other.maSinhVien);
	}

	
}
