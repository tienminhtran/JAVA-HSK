package dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import connection.ConnectionDB;
import entity.giaovien;

public class giaovien_dao {
	public ArrayList<giaovien> getAllgiaovien()
	{
		ArrayList<giaovien> dsgv = new ArrayList<>();
		ConnectionDB.getinstance();
		Connection con =ConnectionDB.getConnection();
		try {
			String sql="select * from giaovien";
			Statement statement = con.createStatement();
			ResultSet rs =statement.executeQuery(sql);
			while(rs.next()) 
			{
				dsgv.add(new giaovien(rs.getString(1), rs.getString(2)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsgv;
	}
	
}
