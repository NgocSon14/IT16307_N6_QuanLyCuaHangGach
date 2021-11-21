/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.Gach;
import Helper.jdbcHelper;
import java.util.ArrayList;
import java.sql.ResultSet;
/**
 *
 * @author Asus
 */
public class GachDAO extends DAO<Gach, String>{
    String INSERT_SQL = "INSERT INTO GACH(MAGACH,TENGACH,MADONVI,SOLUONG,MACHATLIEU,MATHELOAI,MANHACUNGCAP,ANH,TRANGTHAI) VALUES (?,?,?,?,?,?,?,?,?)";
    String UPDATE_SQL = "UPDATE GACH SET TENGACH = ?,MADONVI=?,SOLUONG=?,MACHATLIEU=?,MATHELOAI=?,MANHACUNGCAP=?,ANH=?,TRANGTHAI=? WHERE MAGACH = ?";
    String DELETE_SQL = "DELETE FROM GACH WHERE MAGACH = ?";
    String SELECT_ALL_SQL = "SELECT * FROM GACH";
    String SELECT_BY_ID_SQL = "SELECT * FROM GACH WHERE MAGACH = ?";
    @Override
    public void them(Gach entity) {
        jdbcHelper.update(INSERT_SQL, entity.getMaGach(),entity.getTenGach(),entity.getMaDv(),entity.getSoLuong(),entity.getMaChatLieu(),entity.getMaTheLoai(),
                entity.getMaNhaCungCap(),entity.getAnh(),entity.isTrangThai());
    }

    @Override
    public void capNhat(Gach entity) {
        jdbcHelper.update(UPDATE_SQL,entity.getTenGach(),entity.getMaDv(),entity.getSoLuong(),entity.getMaChatLieu(),entity.getMaTheLoai(),
                entity.getMaNhaCungCap(),entity.getAnh(),entity.isTrangThai(),entity.getMaGach());
    }

    @Override
    public void xoa(String key) {
        jdbcHelper.update(DELETE_SQL, key);
    }

    @Override
    public ArrayList<Gach> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public Gach selectByID(String key) {
        ArrayList<Gach> listGach = this.selectBySql(SELECT_BY_ID_SQL, key);
        if(listGach.isEmpty()){
            return null;
        }
        return listGach.get(0);
    }

    @Override
    protected ArrayList<Gach> selectBySql(String sql, Object... args) {
       ArrayList<Gach> listGach = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {                
                Gach entity = new Gach();
                entity.setMaGach(rs.getString(1));
                entity.setTenGach(rs.getString(2));
                entity.setMaDv(rs.getString(3));
                entity.setSoLuong(rs.getString(4));
                entity.setMaChatLieu(rs.getString(5));
                entity.setMaTheLoai(rs.getString(6));
                entity.setMaNhaCungCap(rs.getString(7));
                entity.setAnh(rs.getString(8));
                entity.setTrangThai(rs.getBoolean(9));
                listGach.add(entity);
            }
            rs.getStatement().getConnection().close();
            return listGach;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
}
