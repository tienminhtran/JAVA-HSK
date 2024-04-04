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
import java.util.ArrayList;
import java.util.List;

import connectDB.ConnectDB;
import entity.KhachHang;
import entity.SanPham;

/**
 *
 * @author Admin
 */
public class KhachHangDao {
	public List<KhachHang> getAll() {
		List<KhachHang> dsKhachHang = new ArrayList<KhachHang>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from KhachHang";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				dsKhachHang.add(new KhachHang(rs.getString("MAKH"), rs.getString("HOTENKH"), rs.getString("GIOITINH"),
						rs.getString("EMAIL"), rs.getString("SODIENTHOAIKH"), rs.getString("DIACHIKH")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsKhachHang;
	}

	public void insertKH(KhachHang t) {
		Connection con = ConnectDB.getInstance().getConnection();
		CallableStatement cs = null;
		try {
			cs = con.prepareCall("{ ? = call dbo.AUTO_IDKH() }");
			cs.registerOutParameter(1, Types.VARCHAR);
			cs.execute();
			String id = cs.getString(1);
			cs.close();

			PreparedStatement ps = con.prepareStatement("insert into KhachHang values (?,?,?,?,?,?)");
			ps.setString(1, id);
			ps.setString(2, t.getHoTenKH());
			ps.setString(3, t.getGioiTinh());
			ps.setString(4, t.getEmail());
			ps.setString(5, t.getSdt());
			ps.setString(6, t.getDiaChi());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(cs);
		}
	}

	public void UpdateKH(KhachHang kh) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement ps = null;
		String sql = "update KhachHang set HOTENKH = ?, GIOITINH = ?, EMAIL= ?, SODIENTHOAIKH = ?, DIACHIKH = ? where MAKH = ?";

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, kh.getHoTenKH());
			ps.setString(2, kh.getGioiTinh());
			ps.setString(3, kh.getEmail());
			ps.setString(4, kh.getSdt());
			ps.setString(5, kh.getDiaChi());
			ps.setString(6, kh.getMaKH());

			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(ps);
		}

	}

	public void deleteKH(String MAKH) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement ps = null;
		String sql = "delete from KHACHHANG where MAKH = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, MAKH);
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(ps);
		}
	}

	public KhachHang selectByID(KhachHang t) {
		KhachHang kh = null;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = ConnectDB.getConnection();
			// Bước 2: Tạo ra đối tượng statement
			Statement st = con.createStatement();
			// Bước 3: Thực thi câu lệnh SQL
			String sql = "select * from KHACHHANG where MAKH = '" + t.getMaKH() + "'";
			ResultSet rs = st.executeQuery(sql);
			// Bước 4:
			while (rs.next()) {
				kh = new KhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kh;
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