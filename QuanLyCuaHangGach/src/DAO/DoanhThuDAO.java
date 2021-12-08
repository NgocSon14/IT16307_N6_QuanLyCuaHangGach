/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.DoanhThu;
import Helper.jdbcHelper;
import java.util.ArrayList;
import java.sql.*;
import java.util.List;

/**
 *
 * @author Asus
 */
public class DoanhThuDAO {

    public List<DoanhThu> getDoanhthu(int thang, int nam) {
        ArrayList<DoanhThu> listDt = new ArrayList<>();
        try {
            ResultSet rs = null;
            String sql = "SELECT * FROM dbo.PHIEUXUATCHITIET JOIN dbo.GACH ON GACH.MAGACH = PHIEUXUATCHITIET.MAGACH JOIN dbo.PHIEUXUAT ON PHIEUXUAT.MAPHIEUXUAT = PHIEUXUATCHITIET.MAPHIEUXUAT WHERE MONTH(NGAYXUAT)=? AND YEAR(NGAYXUAT)=?";
            rs = jdbcHelper.query(sql, thang, nam);
            while (rs.next()) {
                DoanhThu dt = new DoanhThu();
                dt.setNgayXuat(rs.getDate("NGAYXUAT"));
                dt.setMaGach(rs.getString("MAGACH"));
                dt.setTenGach(rs.getString("TENGACH"));
                dt.setSoLuong(rs.getInt("SOLUONG"));
                dt.setGiaBan(rs.getFloat("GIABAN"));
                listDt.add(dt);
            }
            rs.getStatement().getConnection().close();
            return listDt;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Object> getThangDoanhThu(int nam) {
        List<Object> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = jdbcHelper.query("SELECT DISTINCT MONTH(NGAYXUAT) FROM dbo.PHIEUXUATCHITIET JOIN dbo.GACH ON GACH.MAGACH = PHIEUXUATCHITIET.MAGACH JOIN dbo.PHIEUXUAT ON PHIEUXUAT.MAPHIEUXUAT = PHIEUXUATCHITIET.MAPHIEUXUAT ");
                while (rs.next()) {
                    int thang = rs.getInt(1);
                    list.add(thang);

                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }
    public List<Object> getNamDoanhThu() {
        List<Object> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = jdbcHelper.query("SELECT DISTINCT YEAR(NGAYXUAT) FROM dbo.PHIEUXUATCHITIET JOIN dbo.GACH ON GACH.MAGACH = PHIEUXUATCHITIET.MAGACH JOIN dbo.PHIEUXUAT ON PHIEUXUAT.MAPHIEUXUAT = PHIEUXUATCHITIET.MAPHIEUXUAT ");
                while (rs.next()) {
                    int thang = rs.getInt(1);
                    list.add(thang);

                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }
}
