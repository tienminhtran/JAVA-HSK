package dao;

import java.io.Closeable;
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
		GiaoVien_Dao gv_dao = new GiaoVien_Dao();
		List<LopHoc> dsLopHoc = new ArrayList<LopHoc>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "Select * from LopHoc";
		Statement statement;
		try {
			statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				dsLopHoc.add(new LopHoc(rs.getString(1), rs.getString(2), gv_dao.layTen(rs.getString(3)), rs.getString(4)));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsLopHoc;
	}

	public void addLop(LopHoc lh) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement("insert into LopHoc(?,?,?,?)");

			ps.setString(1, lh.getMaLop());
			ps.setString(2, lh.getTenLop());
			ps.setString(3, lh.getGiaoVien().getMaGiaoVien());
			ps.setString(4, lh.getSiSo());
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
