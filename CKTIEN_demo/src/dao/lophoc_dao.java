package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import connection.ConnectionDB;
import entity.giaovien;
import entity.lophoc;

public class lophoc_dao {
	public ArrayList<lophoc> getAllgiaovien()
	{
		ArrayList<lophoc> dsLophoc = new ArrayList<>();
		ConnectionDB.getinstance();
		Connection con = ConnectionDB.getConnection();
		try {
			String sql = "select * from lophoc";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) 
			{
				dsLophoc.add(new lophoc(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsLophoc;
	}
	
	
}
