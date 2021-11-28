/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.PhieuNhap;
import Helper.jdbcHelper;
import java.util.ArrayList;
import java.sql.ResultSet;

/**
 *
 * @author Asus
 */
public class PhieuNhapDAO extends DAO<PhieuNhap, String> {

    String SELECT_ALL_SQL = "select * from PHIEUNHAP";
    String SELECT_BY_ID_SQL = "select * from PHIEUNHAP where MAPHIEUNHAP =?";
    String INSERT_SQL = "insert into PHIEUNHAP(MAPHIEUNHAP,NGAYNHAP,MANHACUNGCAP,TRANGTHAI) values(?,?,?,?)";
    String DELETE_SQL = "update PHIEUNHAP set TRANGTHAI=0 where MAPHIEUNHAP=?";
    String UPDATE_SQL = "update PHIEUNHAP set NGAYNHAP = ?, MANHACUNGCAP = ?, TRANGTHAI=? where MAPHIEUNHAP = ?";

    @Override
    public void them(PhieuNhap entity) {
        try {
            jdbcHelper.update(INSERT_SQL, entity.getMaPhieuNhap(), entity.getNgayNhap(), entity.getMaNhaCungCap(), entity.isTrangThai() == true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void capNhat(PhieuNhap entity) {
        try {
            jdbcHelper.update(UPDATE_SQL, entity.getNgayNhap(), entity.getMaNhaCungCap(), entity.isTrangThai(), entity.getMaPhieuNhap());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void xoa(String key) {
        try {
            jdbcHelper.update(DELETE_SQL, key);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<PhieuNhap> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public PhieuNhap selectByID(String key) {
        ArrayList<PhieuNhap> listPhieuNhap = this.selectBySql(SELECT_BY_ID_SQL, key);
        if (listPhieuNhap.isEmpty()) {
            return null;
        }
        return listPhieuNhap.get(0);
    }

    @Override
    protected ArrayList<PhieuNhap> selectBySql(String sql, Object... args) {
        ArrayList<PhieuNhap> listPhieuNhap = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {
                PhieuNhap pn = new PhieuNhap();
                pn.setMaPhieuNhap(rs.getString(1));
                pn.setNgayNhap(rs.getDate(2));
                pn.setMaNhaCungCap(rs.getString(3));
                pn.setTrangThai(rs.getBoolean(4));
                listPhieuNhap.add(pn);
            }
            rs.getStatement().getConnection().close();
            return listPhieuNhap;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
