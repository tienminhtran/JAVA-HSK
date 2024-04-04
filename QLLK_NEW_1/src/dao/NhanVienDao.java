/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

    public int insert(NhanVien t) {
        int ketQua = 0;
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        try {
            Statement st = con.createStatement();
            String sql = "insert into NhanVien"
                    + " values (dbo.AUTO_IDNV(), '" + t.getHoTen() + "', '" + t.getGioiTinh() + "', '" + t.getChucVu() + "')";
            ketQua = st.executeUpdate(sql);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ketQua;
    }

    public int update(NhanVien t) {
        int ketQua = 0;
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        try {
            Statement st = con.createStatement();
            String sql = "update NhanVien "
                    + "set HOTENNV = '" + t.getHoTen() + "'"
                    + ", GIOITINHNV = '" + t.getGioiTinh() + "'"
                    + ", QUYENTRUYCAP = '" + t.getChucVu()+ "'"
                    + " where MANV = '" + t.getMaNV() + "'";
            ketQua = st.executeUpdate(sql);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ketQua;
    }

    public int delete(NhanVien t) {
        int ketQua = 0;
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        try {
            Statement st = con.createStatement();
            String sql = "delete from NhanVien "
                    + " where MANV = '" + t.getMaNV() + "'";
            ketQua = st.executeUpdate(sql);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ketQua;
    }

    public NhanVien selectByID(NhanVien t) {
        // TODO Auto-generated method stub
        return null;
    }
}
