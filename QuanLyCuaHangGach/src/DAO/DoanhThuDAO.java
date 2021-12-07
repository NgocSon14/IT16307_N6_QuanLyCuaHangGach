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
/**
 *
 * @author Asus
 */
public class DoanhThuDAO extends DAO<DoanhThu, String>{
    String SELECT_THANG = "Select distinct month(NGAYXUAT) FROM PHIEUXUAT";
    String SELECT_ALL_DOANHTHU = "Select * from PHIEUXUATCHITIET INNER JOIN GACH ON PHIEUXUATCHITIET.MAGACH = GACH.MAGACH INNER JOIN PHIEUXUAT ON PHIEUXUATCHITIET.MAPHIEUXUAT = PHIEUXUAT.MAPHIEUXUAT";
    
    public ArrayList<DoanhThu> selectThang() {
        return this.selectBySql(SELECT_THANG);
    }
    @Override
    public void them(DoanhThu entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void capNhat(DoanhThu entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void xoa(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<DoanhThu> selectAll() {
        return this.selectBySql(SELECT_ALL_DOANHTHU);
    }

    @Override
    public DoanhThu selectByID(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected ArrayList<DoanhThu> selectBySql(String sql, Object... args) {
        ArrayList<DoanhThu> listDt = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
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
    
}
