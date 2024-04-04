package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connectDB.ConnectDB;
import emtity.LopHoc;

public class LopHoc_Dao {
	public List<LopHoc> getAllLopHoc() {
		List<LopHoc> dsLopHoc = new ArrayList<LopHoc>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "Select * from LopHoc";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {

				dsLopHoc.add(new LopHoc(rs.getString(1), rs.getString(2), rs.getString(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsLopHoc;
	}

	public void addLop(LopHoc lopHoc) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("insert into LopHoc values(?, ?, ?)");
			ps.setString(1, lopHoc.getMalop());
			ps.setString(2, lopHoc.getTenlop());
			ps.setString(3, lopHoc.getGiaovienCN());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(ps);
		}
	}

	public void deleteLop(String malop) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement ps = null;
		String sql = "delete from LopHoc where malop = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, malop);
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(ps);
		}
	}

	public void UpdateLop(LopHoc lopHoc) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement ps = null;
		String sql = "update LopHoc set tenlop = ?, GVCN = ? where malop = ?";

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, lopHoc.getTenlop());
			ps.setString(2, lopHoc.getGiaovienCN());
			ps.setString(3, lopHoc.getMalop());

			ps.executeUpdate();

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

	public LopHoc_Dao getInstance() {
		// TODO Auto-generated method stub
		return null;
	}
}
