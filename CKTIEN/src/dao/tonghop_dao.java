package dao;

//
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import connection.ConnectionDB;
import entity.tonghop;

public class tonghop_dao {
	public ArrayList<tonghop> dstonghop()
	{
		ArrayList<tonghop> dsTonghop = new ArrayList<>();
		ConnectionDB.getinstace();
		Connection con = ConnectionDB.getConnection();
		try {
			String sql ="SELECT LopHoc.maLop, LopHoc.tenLop, GiaoVien.tenGiaoVien, LopHoc.siSo FROM LopHoc JOIN GiaoVien ON LopHoc.maGiaoVien = GiaoVien.maGiaoVien";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) 
			{
				dsTonghop.add(new tonghop(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsTonghop;
	}
	public void themtonghop(tonghop th) 
	{
		Connection con1 = ConnectionDB.getinstace().getConnection();
		Connection con2 = ConnectionDB.getinstace().getConnection();

		PreparedStatement stmt1 = null;
		String sql1="insert into lophoc values(?,?,?,?)";
		
		try {
			stmt1=con1.prepareStatement(sql1);
			String sql2="select maGiaoVien from giaovien where tengiaovien=N'"
					+ th.getGiaoviencn()+"'";
			Statement statement = con2.createStatement();
			ResultSet rs = statement.executeQuery(sql2);
			String ma="";
			if(rs.next()) 
			{
				ma=rs.getString(1);
			}
			stmt1.setString(1, th.getMalop());
			stmt1.setString(2, th.getTenlop());
			stmt1.setString(3,	ma);
			stmt1.setInt(4, th.getSiso());
			stmt1.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			close(stmt1);
		}
	}
	
	public void xoatonghop(String malopxoa) 
	{
		Connection con = ConnectionDB.getinstace().getConnection();
		PreparedStatement ps = null;
		String sql="delete from LopHoc where maLop = ?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, malopxoa);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			close(ps);
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
