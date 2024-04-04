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

import GUI.DONHANG;
import connectDB.ConnectDB;
import entity.DonHang;
import entity.HoaDon;

public class DonHangDao {
	
	public List<DonHang> getAll() {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		List<DonHang> dshoad = new ArrayList<DonHang>();
		try {
			String sql = "select * from DONHANG";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				dshoad.add(new DonHang(rs.getString("MaHD"), rs.getString("MANV"), rs.getString("TENSP"),
						rs.getString("MAKH"), rs.getString("TENKH"), rs.getDate("NGAYLAPHD"), rs.getDouble("TONGTIEN")));
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dshoad;
	}

	
	public void insertSP(DonHang t) {
	    Connection con = ConnectDB.getInstance().getConnection();
	    CallableStatement cs = null;
	    long millis = System.currentTimeMillis();
	    java.sql.Date date = new java.sql.Date(millis);
	    try {
	        cs = con.prepareCall("{ ? = call dbo.AUTO_IDDH1 }");
	        cs.registerOutParameter(1, Types.VARCHAR);
	        cs.execute();
	        String id = cs.getString(1);
	        cs.close();

	        PreparedStatement ps = con.prepareStatement("insert into DONHANG values (?,?,?,?,?,?,?)");
	        ps.setString(1, id);
	        ps.setString(2, t.getManv());
	        ps.setString(3, t.getTensp());
	        ps.setString(4, t.getMakh());
	        ps.setString(5, t.getTenkh());

	        ps.setDate(6, date);
	        ps.setDouble(7, t.getTongtien());
	        ps.executeUpdate();
	        ps.close();
	    } catch (SQLException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    } finally {
	        close(cs);
	    }
	}
	
	public void deletesp(String mahd) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement ps = null;
		String sql = "delete from DONHANG where MaHD = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mahd);
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(ps);
		}
	}

	public void close(PreparedStatement ps) {
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
