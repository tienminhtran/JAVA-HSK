package dao;
//

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import connection.ConnectionDB;
import entity.lophoc;

public class lophoc_dao {
	public ArrayList<lophoc> getAlllophoc()
	{
		ArrayList<lophoc> dsLophoc = new ArrayList<>();
		ConnectionDB.getinstace();
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
	
	public void themlophoc(lophoc lh) 
	{
		Connection con= ConnectionDB.getinstace().getConnection();
		PreparedStatement stmt = null;
		String sql = "insert into lophoc values(?,?,?,?)";
		try {
			stmt=con.prepareStatement(sql);
			stmt.setString(1, lh.getMalop());
			stmt.setString(2, lh.getTenlop());
			stmt.setString(3, lh.getMagiaovien());
			stmt.setInt(4, lh.getSiso());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally 
		{
			close(stmt);
		}
	}
	public void xoalophoc(String malop) 
	{
		Connection con= ConnectionDB.getinstace().getConnection();
		PreparedStatement stmt = null;
		String sql = "delete from lophoc where malop = ?";
		try {
			stmt=con.prepareStatement(sql);
			stmt.setString(1, malop);
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally 
		{
			close(stmt);
		}
	}
	public void sualophoc(lophoc lh) 
	{
		Connection con= ConnectionDB.getinstace().getConnection();
		PreparedStatement stmt = null;
		String sql = "update lophoc set tenlop = ?, magiaovien = ?, siso = ? where malop = ?";
		try {
			stmt=con.prepareStatement(sql);
			stmt.setString(1, lh.getTenlop());
			stmt.setString(2, lh.getMagiaovien());
			stmt.setInt(3, lh.getSiso());
			stmt.setString(4, lh.getMalop());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally 
		{
			close(stmt);
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
