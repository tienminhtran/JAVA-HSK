/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connectDB.ConnectDB;
import entity.SanPham;

/**
 *
 * @author Admin
 */
public class SanPhamDao {
    public List<SanPham> getAll() {
		List<SanPham> dsLinhKien = new ArrayList<SanPham>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from SANPHAM";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				dsLinhKien.add(new SanPham(rs.getString("MASP"), rs.getString("TENSP"), rs.getString("MOTASP"), rs.getDouble("DONGIA"), rs.getString("LOAISP"), rs.getString("THUONGHIEU"), rs.getInt("SOLUONGTON"), rs.getDate("NGAYNHAP"), rs.getInt("BAOHANH")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsLinhKien;
	}

	
	public int insertSP(SanPham t) {
		int ketQua = 0;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			Statement st = con.createStatement();
			String sql = "insert into SANPHAM"
					+ " values (dbo.AUTO_IDLK(), '"+t.getTenLK()+"', '"+t.getMoTaLK()+"', "+t.getDonGia()+", '"+t.getLoaiLK()+"', '"+t.getThuongHieu()+"', "+t.getSoLuongTon()+", '"+t.getNgayNhap()+"', "+t.getBaoHanh()+")";
			ketQua = st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
      
	}

	
	public int update(SanPham t) {
		int ketQua = 0;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			Statement st = con.createStatement();
			String sql = "update LinhKien "+
					" set MALK = '"+t.getMaLK()+"'"+
					", TENLK = '"+t.getTenLK()+"'"+
					", MOTALK = '"+t.getMoTaLK()+"'"+
					", DONGIA = '"+t.getDonGia()+"'"+
					", LOAILK = '"+t.getLoaiLK()+"'"+
					", THUONGHIEU = '"+t.getThuongHieu()+"'"+
					", SOLUONGTON = '"+t.getSoLuongTon()+"'"+
					", NGAYNHAP = '"+t.getNgayNhap()+"'"+
					", BAOHANH = '"+t.getBaoHanh()+"'"+
					"where MALK = '"+t.getMaLK()+"'";
			ketQua = st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	
	public int delete(SanPham t) {
		int ketQua = 0;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			Statement st = con.createStatement();
			String sql = "delete from LinhKien "+
						" where MALK = '"+t.getMaLK()+"'";
			ketQua = st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	
	public SanPham selectByID(SanPham t) {
		SanPham lk = null;
		try {
			//Bước 1: tạo kết nối đến CSDL
			Connection con = ConnectDB.getConnection();
			//Bước 2: Tạo ra đối tượng statement
			Statement st = con.createStatement();
			//Bước 3: Thực thi câu lệnh SQL
			String sql = "select * from LinhKien where MALK = '"+t.getMaLK()+"'";
			ResultSet rs = st.executeQuery(sql);
			//Bước 4:
			while(rs.next()) {
				lk = new SanPham(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getDate(8), rs.getInt(9));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lk;
	}
}
