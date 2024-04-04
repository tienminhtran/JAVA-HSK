package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connectDB.ConnectDB;
import entity.NhanVien;

public class LoginDao {
	private ConnectDB con;
	private NhanVien nv;
	
	public LoginDao() {

	}
	public boolean dieuKienLogin(String maNV, String PASS) {
		NhanVien nv = null;
		PreparedStatement stmt = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			stmt = con.prepareStatement("select * from NhanVien where MANV = ? and MATKHAU = ?");
			stmt.setString(1, maNV);
			stmt.setString(2, PASS);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				nv = new NhanVien(rs.getString("MANV"),rs.getString("MATKHAU"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		if(nv.getMaNV()!=null) {
			return true;
		}
		return false;
	}
}
