package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connectDB.ConnectDB;
import emtity.GiaoVien;

public class GiaoVien_Dao {
	public List<GiaoVien> getAllGiaoVien() {
		List<GiaoVien> dsGiaoVien = new ArrayList<GiaoVien>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "Select * from GiaoVien";
		Statement statement;
		try {
			statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				dsGiaoVien.add(new GiaoVien(rs.getString(1), rs.getString(2)));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsGiaoVien;

	}

	public GiaoVien layTen(String ma) {
		GiaoVien gv = new GiaoVien();
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("SELECT *from GiaoVien where maGiaoVien = ? ");
			ps.setString(1, ma);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				gv.setMaGiaoVien(rs.getString(1));
				gv.setTenGiaoVien(rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(ps);
		}
		return gv;
	}
	public void addLop(GiaoVien gv) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("insert into GiaoVien(?,?)");
			ps.setString(1, gv.getMaGiaoVien());
			ps.setString(2, gv.getTenGiaoVien());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(ps);
		}
		
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
