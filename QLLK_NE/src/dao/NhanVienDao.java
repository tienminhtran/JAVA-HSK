/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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

import connectDB.ConnectDB;
import entity.NhanVien;

/**
 *
 * @author Admin
 */
public class NhanVienDao {

    private Connection con;

    public List<NhanVien> getAll() {
        List<NhanVien> dsNhanVien = new ArrayList<NhanVien>();
        ConnectDB.getInstance();
        con = ConnectDB.getConnection();
        try {
            String sql = "select * from NhanVien";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            System.out.println(rs);
            while (rs.next()) {
//                dsNhanVien.add(new NhanVien(rs.getString(1), rs.getString(2),  rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6)));
                dsNhanVien.add(new NhanVien(rs.getString("MANV"), rs.getString("HOTENNV"), rs.getString("MATKHAU"), rs.getString("GIOITINHNV"), rs.getString("CHUCVU"), rs.getString("SODIENTHOAINV"), rs.getString("DIACHINV")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsNhanVien;
    }


    public void insert(NhanVien t) {
	    Connection con = ConnectDB.getInstance().getConnection();
        CallableStatement cs = null;

        try {
        	cs = con.prepareCall("{ ? = call dbo.AUTO_IDNV() }");
	        cs.registerOutParameter(1, Types.VARCHAR);
	        cs.execute();
	        String id = cs.getString(1);
	        cs.close();
     
            PreparedStatement ps = con.prepareStatement("insert into NhanVien values (?,?,?,?,?,?,?)");
            ps.setString(1, id);
            ps.setString(2, t.getHoTen());
            ps.setString(3, t.getMK());
            ps.setString(4, t.getGioiTinh());
            ps.setString(5, t.getChucVu());
            ps.setString(6, t.getSdt());
            ps.setString(7, t.getDiachi());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    } finally {
	        close(cs);
	    }
        
    }

    public void update(NhanVien t) {
       Connection con = ConnectDB.getInstance().getConnection();
       PreparedStatement pre = null;

       String sql = "update NhanVien "
               + "set HOTENNV = ?"
               + ", MATKHAU = ?"
               + ", GIOITINHNV = ?"
               + ", CHUCVU = ?"
               + ", SODIENTHOAINV = ?"
               + ", DIACHINV = ?"
               + " where MANV = ?";
        try {
        	pre = con.prepareStatement(sql);
        	pre.setString(1, t.getHoTen());
        	pre.setString(2, t.getMK());
        	pre.setString(3, t.getGioiTinh());
        	pre.setString(4, t.getChucVu());
        	pre.setString(5, t.getSdt());
        	pre.setString(6, t.getDiachi());
        	pre.setString(7, t.getMaNV());

        	pre.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
	        close(pre);
	    }
    }

    public void delete(String ma) {
    	Connection con = ConnectDB.getInstance().getConnection();
        PreparedStatement pre = null;
        String sql = "delete from NhanVien "
                + " where MANV = ?";
        try {
            pre = con.prepareStatement(sql);
            pre.setString(1, ma);
           pre.executeUpdate();
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
	        close(pre);
	    }
    }

    public NhanVien selectByID(String ma) {
        NhanVien nv = null;
        Connection connection = ConnectDB.getConnection();
        try {
            String sql = "select * from NhanVien where MANV = '" + ma + "'";
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
				nv = new NhanVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return nv;
    }
    public void close(PreparedStatement pr) {
    	if(pr!=null) {
    		try {
				pr.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
    	}
    }
    
}
