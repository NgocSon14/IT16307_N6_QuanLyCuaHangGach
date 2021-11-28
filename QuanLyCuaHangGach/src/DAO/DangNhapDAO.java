
package DAO;

import Entity.TaiKhoan;
import Helper.jdbcHelper;
import java.util.ArrayList;
import java.sql.*;


public class DangNhapDAO extends DAO<TaiKhoan, String>{
    
    String SELECT_ALL_SQL = "select * from DANGNHAP";
    String SELECT_BY_ID_SQL = "select * from DANGNHAP WHERE TAIKHOAN =?";
    String UPDATE_PASSWORD_SQL = "UPDATE DANGNHAP SET MATKHAU = ? WHERE TAIKHOAN = ?";
    @Override
    public void them(TaiKhoan entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void capNhat(TaiKhoan entity) {
        try {
            jdbcHelper.update(UPDATE_PASSWORD_SQL, entity.getMatKhau(),entity.getTaiKhoan());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void xoa(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<TaiKhoan> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public TaiKhoan selectByID(String key) {
        ArrayList<TaiKhoan> listTaiKhoan = selectBySql(SELECT_BY_ID_SQL, key);
        if(listTaiKhoan.isEmpty()){
            return null;
        }
       return listTaiKhoan.get(0);
    }

    @Override
    protected ArrayList<TaiKhoan> selectBySql(String sql, Object... args) {
        ArrayList<TaiKhoan> listTaiKhoan = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {                
                TaiKhoan Entity = new TaiKhoan();
                Entity.setTaiKhoan(rs.getString(1));
                Entity.setMatKhau(rs.getString(2));
                Entity.setVaiTro(rs.getString(3));
                Entity.setTenQuanLi(rs.getString(4));
                Entity.setCCCD(rs.getString(5));
                Entity.setEmail(rs.getString(6));
                listTaiKhoan.add(Entity);
            }
            rs.getStatement().getConnection().close();
            return listTaiKhoan;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
}
