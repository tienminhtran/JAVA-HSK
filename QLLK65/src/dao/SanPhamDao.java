/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.time.LocalDate;
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
			while (rs.next()) {
				dsLinhKien.add(new SanPham(rs.getString("MASP"), rs.getString("TENSP"), rs.getString("MOTASP"),
						rs.getDouble("DONGIA"), rs.getString("LOAISP"), rs.getString("THUONGHIEU"),
						rs.getInt("SOLUONGTON"), rs.getDate("NGAYNHAP"), rs.getString("BAOHANH")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsLinhKien;
	}

	public void insertSP(SanPham t) {
	    Connection con = ConnectDB.getInstance().getConnection();
	    CallableStatement cs = null;
	    long millis = System.currentTimeMillis();
	    java.sql.Date date = new java.sql.Date(millis);
	    try {
	        cs = con.prepareCall("{ ? = call dbo.AUTO_IDLK() }");
	        cs.registerOutParameter(1, Types.VARCHAR);
	        cs.execute();
	        String id = cs.getString(1);
	        cs.close();

	        PreparedStatement ps = con.prepareStatement("insert into SANPHAM values (?,?,?,?,?,?,?,?,?)");
	        ps.setString(1, id);
	        ps.setString(2, t.getTenLK());
	        ps.setString(3, t.getMoTaLK());
	        ps.setDouble(4, t.getDonGia());
	        ps.setString(5, t.getLoaiLK());
	        ps.setString(6, t.getThuongHieu());
	        ps.setInt(7, t.getSoLuongTon());
	        ps.setDate(8, date);
	        ps.setString(9, t.getBaoHanh());
	        ps.executeUpdate();
	        ps.close();
	    } catch (SQLException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    } finally {
	        close(cs);
	    }
	}
	
	public void Updatesp(SanPham sp) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement ps = null;
		String sql = "update SANPHAM set TENSP = ?, MOTASP = ?, DONGIA= ?, LOAISP = ?, THUONGHIEU = ?, SOLUONGTON = ?, NGAYNHAP= ?, BAOHANH= ? where MASP = ?";

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, sp.getTenLK());
			ps.setString(2, sp.getMoTaLK());
			ps.setDouble(3, sp.getDonGia());
			ps.setString(4, sp.getLoaiLK());
			ps.setString(5, sp.getThuongHieu());
			ps.setInt(6, sp.getSoLuongTon());
			ps.setDate(7, sp.getNgayNhap());
			ps.setString(8, sp.getBaoHanh());
			ps.setString(9, sp.getMaLK());

			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(ps);
		}

	}

	public void deletesp(String masp) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement ps = null;
		String sql = "delete from SANPHAM where MASP = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, masp);
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(ps);
		}
	}



	public SanPham selectByID(SanPham t) {
		SanPham lk = null;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = ConnectDB.getConnection();
			// Bước 2: Tạo ra đối tượng statement
			Statement st = con.createStatement();
			// Bước 3: Thực thi câu lệnh SQL
			String sql = "select * from LinhKien where MALK = '" + t.getMaLK() + "'";
			ResultSet rs = st.executeQuery(sql);
			// Bước 4:
			while (rs.next()) {
				lk = new SanPham(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6), rs.getInt(7), rs.getString(9));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lk;
	}

	private void close(PreparedStatement ps) {
		// TODO Auto-generated method stub
		if (ps != null) {
			try {
				ps.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
}
