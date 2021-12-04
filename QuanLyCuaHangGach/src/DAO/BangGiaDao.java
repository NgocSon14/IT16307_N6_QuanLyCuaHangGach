package DAO;

import Entity.BangGia;
import Helper.jdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BangGiaDao extends DAO<BangGia, String> {


    String Select_All_GACH ="SELECT Gach.MAGACH, Gach.MANHACUNGCAP,BANGGIA.GIAGACH,Gach.TENGACH,ANH\n" +
"            FROM Gach\n" +
"            LEFT OUTER JOIN BangGia\n" +
"             ON Gach.MAGACH = BANGGIA.MAGACH ";
           
    String SELECT_BY_ID_GACH = "SELECT Gach.MAGACH, Gach.MANHACUNGCAP,BANGGIA.GIAGACH,Gach.TENGACH,Gach.Anh\n" +
"            FROM Gach\n" +
"            LEFT OUTER JOIN BangGia\n" +
"             ON Gach.MAGACH = BANGGIA.MAGACH where GACH.MAGACH =?";
    

    String INSERT_BANGGIA = "insert into BangGia(MAGACH,MANHACUNGCAP,GIAGACH) VALUES(?,?,?)";
    String SELECT_GIA = "SELECT * FROM BANGGIA WHERE MAGACH = ?";
    
     public BangGia selectByID_Gia(String key) {
        ArrayList<BangGia> listBangGia = selectBySql(SELECT_GIA, key);
        if (listBangGia.isEmpty()) {
            return null;
        }
        return listBangGia.get(0);
    }
    
    @Override
    public void them(BangGia entity) {
        jdbcHelper.update(INSERT_BANGGIA, entity.getMaGach(), entity.getMaNhaCungCap(), entity.getGia());
    }

    @Override
    public void capNhat(BangGia entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void xoa(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<BangGia> selectAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public BangGia selectByID(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected ArrayList<BangGia> selectBySql(String sql, Object... args) {
        try {
            ArrayList<BangGia> listBG = new ArrayList<>();
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {

                listBG.add(new BangGia(rs.getString(1), rs.getString(2), rs.getFloat(3),rs.getString(4),rs.getString(5)));
            }
            rs.getStatement().getConnection().close();
            return listBG;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<BangGia> selectAllGACH() {
        return selectBySql(Select_All_GACH);
    }

    public BangGia selectByIDGACH(String key) {
        ArrayList<BangGia> listbg = this.selectBySql(SELECT_BY_ID_GACH, key);

        if (listbg.isEmpty()) {
            return null;
        } else {
            return listbg.get(0);
        }
    }
}
