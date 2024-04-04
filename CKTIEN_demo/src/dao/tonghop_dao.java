package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connection.ConnectionDB;
import entity.lophoc;
import entity.tonghop;

public class tonghop_dao {
	public ArrayList<tonghop> getAlltonghop()
	{
		ArrayList<tonghop> dsth = new ArrayList<>();
		ConnectionDB.getinstance();
		Connection con = ConnectionDB.getConnection();
		try {
			String sql = "select lophoc.malop, lophoc.tenlop, giaovien.tengiaovien, lophoc.siso from lophoc join giaovien on lophoc.magiaovien = giaovien.magiaovien";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) 
			{
				dsth.add(new tonghop(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsth;
	}
	
	public void themtonghop(tonghop th) {
		Connection con1 =ConnectionDB.getinstance().getConnection();
		Connection con2 =ConnectionDB.getinstance().getConnection();
		PreparedStatement stmt1 = null;
		String sql1 = "insert into lophoc values(?,?,?,?)";
		try {
			stmt1 = con1.prepareStatement(sql1);
			String sql2 = "select magiaovien from giaovien where tengiaovien=N'"+th.getGiaoviencn()+"'";
			Statement st = con2.createStatement();
			ResultSet rs = st.executeQuery(sql2);
			String ma="";
			if(rs.next()) {
				ma=rs.getString(1);
			}
			stmt1.setString(1, th.getMalop());
			stmt1.setString(2, th.getTenlop());
			stmt1.setString(3, ma);
			stmt1.setInt(4, th.getSiso());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(stmt1);
		}
		

	}
	public void close(PreparedStatement stmt) 
	{
		if(stmt!=null) 
		{
			try {
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
