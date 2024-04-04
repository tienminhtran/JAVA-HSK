package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connectDB.ConnectDB;
import entiy.CT_HoaDon;
import entiy.HoaDon;

public class CTHDDao implements DAOInterface<CT_HoaDon>{

	@Override
	public List<CT_HoaDon> getAll() {
		List<CT_HoaDon> ctHD = new ArrayList<CT_HoaDon>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from CT_HoaDon";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ctHD;
	}

	@Override
	public int insert(CT_HoaDon t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(CT_HoaDon t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(CT_HoaDon t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public CT_HoaDon selectByID(CT_HoaDon t) {
		// TODO Auto-generated method stub
		return null;
	}

}
