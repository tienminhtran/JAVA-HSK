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
public class TrangChuDao {
    public List<SanPham> getAll() {
		List<SanPham> dsSanPham = new ArrayList<SanPham>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from SANPHAM";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
//				dsSanPham.add(new SanPham(rs.getString("MASP"), rs.getString("TENSP"), rs.getString("MOTASP"), rs.getDouble("DONGIA"), rs.getString("LOAISP"), rs.getString("THUONGHIEU"), rs.getInt("SOLUONGTON"), rs.getDate("NGAYNHAP"), rs.getInt("BAOHANH")));
				dsSanPham.add(new SanPham(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getDate(8), rs.getInt(9)));
			}
                        
//			ConnectDB.getInstance().disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dsSanPham;
	}

	
	public int insert(SanPham t) {
		try {
			//Bước 1: tạo kết nối đến CSDL
			Connection con = ConnectDB.getConnection();
			//Bước 2: Tạo ra đối tượng statement
			Statement st = con.createStatement();
			//Bước 3: Thực thi câu lệnh SQL
			String sql = "insert into SanPham(MALK, TENLK, SOLUONGTON, DONGIA, BAOHANH)"+
						" values('"+t.getMaLK()+"','"+ t.getTenLK()+ "', "+ t.getSoLuongTon()+", "+ t.getDonGia()+", "+t.getBaoHanh()+")";
			ResultSet rs = st.executeQuery(sql);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	
	public int update(SanPham t) {
		int ketQua = 0;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			Statement st = con.createStatement();
			String sql = "update SanPham "+
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
			String sql = "delete from SanPham "+
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
			String sql = "select * from SanPham where MALK = '"+t.getMaLK()+"'";
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
	public void first() {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from SanPham";
			Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery(sql);
			rs.first();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
