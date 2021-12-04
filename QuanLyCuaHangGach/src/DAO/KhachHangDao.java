/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.KhachHang;
import java.util.ArrayList;
import Helper.jdbcHelper;
import java.awt.List;
import java.sql.ResultSet;

/**
 *
 * @author Administrator
 */
public class KhachHangDao extends DAO<KhachHang, String>{
    String SQL_Update="update KHACHHANG set TENKHACHHANG=?,DIACHI=?,SODIENTHOAI=?,EMAIL=?,THONGTINKHAC=?,TRANGTHAI=? where MAKHACHHANG=?";
    String SQL_Delete="update KHACHHANG set TRANGTHAI=0 where MAKHACHHANG=?";
    String SQL_SelectAll="select*from KHACHHANG";
    String SQL_SelectID="select*from KHACHHANG where MAKHACHHANG=?";
    String SQL_INSERT = "INSERT INTO KHACHHANG(MAKHACHHANG,TENKHACHHANG,DIACHI,SODIENTHOAI,EMAIL,THONGTINKHAC,TRANGTHAI) VALUES(?,?,?,?,?,?,?)";
    @Override
    public void them(KhachHang entity) {
        try {
            jdbcHelper.update(SQL_INSERT,entity.getMaKhachHang(),entity.getTenKhachHang(),entity.getDiaChi(),entity.getSDT(),entity.getEmail(),entity.getThongTinKhac(),entity.isTrangThai());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void capNhat(KhachHang entity) {
        jdbcHelper.update(SQL_Update, entity.getTenKhachHang(),entity.getDiaChi(),entity.getSDT(),entity.getEmail(),entity.getThongTinKhac(),entity.isTrangThai(),entity.getMaKhachHang());
    }

    @Override
    public void xoa(String key) {
        jdbcHelper.update(SQL_Delete, key);
    }

    @Override
    public ArrayList<KhachHang> selectAll() {
       return this.selectBySql(SQL_SelectAll);
    }

    @Override
    public KhachHang selectByID(String key) {
       ArrayList<KhachHang> listKH= this.selectBySql(SQL_SelectID,key); 

if(listKH.isEmpty()){
return null;
}else
{
return listKH.get(0);
}
    }

    @Override
    protected ArrayList<KhachHang> selectBySql(String sql, Object... args) {
        ArrayList<KhachHang> listKH= new ArrayList<>();
        try {
            ResultSet rs=jdbcHelper.query(sql, args);
            while (rs.next()) {
listKH.add(new KhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5), rs.getString(6), rs.getBoolean(7)));          
            }
            rs.getStatement().getConnection().close();
            return listKH;
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
}
