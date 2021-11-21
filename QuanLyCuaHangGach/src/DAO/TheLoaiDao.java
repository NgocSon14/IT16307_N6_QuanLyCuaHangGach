/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Entity.TheLoai;
import Helper.jdbcHelper;
import java.awt.List;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author Admin
 */
public class TheLoaiDao extends DAO<TheLoai, String>{
     String SQL_Insert="insert into THELOAI values(?,?) ";
    String SQL_Update="update THELOAI set MATHELOAI=?,TENTHELOAI=?";
    String SQL_Delete="delete from THELOAI WHERE MATHELOAI=?";
    String SQL_SelectAll="select*from THELOAI";
    String SQL_SelectID="select*from THELOAI where MATHELOAI=?";

    @Override
    public void them(TheLoai entity) {
        jdbcHelper.update(SQL_Insert, entity.getMaTheLoai(),entity.getTenTheLoai()); 
    }
    @Override
    public void capNhat(TheLoai entity) {
      jdbcHelper.update(SQL_Update, entity.getMaTheLoai(),entity.getTenTheLoai()); 
    }

    @Override
    public void xoa(String key) {
        jdbcHelper.update(SQL_Delete, key);
    }

    @Override
    public ArrayList<TheLoai> selectAll() {
       return this.selectBySql(SQL_SelectAll);
    }

    @Override
    public TheLoai selectByID(String key) {
        ArrayList<TheLoai> listTL=this.selectBySql(SQL_SelectID, key);
            if(listTL.isEmpty()){
            return null;
            }
            else
            {
            return listTL.get(0);
            }
    }

    @Override
    protected ArrayList<TheLoai> selectBySql(String sql, Object... args) {
       ArrayList<TheLoai> listTheLoai= new ArrayList<>();
        try {
            ResultSet rs= jdbcHelper.query(sql, args);
            while(rs.next()){
            listTheLoai.add(new TheLoai(rs.getString(1),rs.getString(2)));
            }
            rs.getStatement().getConnection().close();
            return  listTheLoai;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }


   
}
