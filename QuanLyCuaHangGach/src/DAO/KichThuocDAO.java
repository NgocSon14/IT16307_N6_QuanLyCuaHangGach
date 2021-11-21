
package DAO;
import Entity.KichThuoc;
import Helper.jdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;

public class KichThuocDAO extends DAO<KichThuoc, String>{
    String SELECT_ALL_SQL = "select * from DONVITINH";
    String SELECT_BY_ID_SQL = "select * from DONVITINH where MADONVI =?";
    String INSERT_SQL = "insert into DONVITINH(MADONVI,TENDONVI) values(?,?)";
    String DELETE_SQL = "delete DONVITINH where MADONVI = ?";
    String UPDATE_SQL = "update DONVITINH set TENDONVI = ? where MADONVI = ?";

    @Override
    public void them(KichThuoc entity) {
        jdbcHelper.update(INSERT_SQL, entity.getMaDonVi(),entity.getTenDonVi());
    }

    @Override
    public void capNhat(KichThuoc entity) {
        jdbcHelper.update(UPDATE_SQL, entity.getTenDonVi());
    }

    @Override
    public void xoa(String key) {
        jdbcHelper.update(DELETE_SQL, key);
    }

    @Override
    public ArrayList<KichThuoc> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public KichThuoc selectByID(String key) {
        ArrayList<KichThuoc> list = selectBySql(SELECT_BY_ID_SQL, key);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }

    @Override
    protected ArrayList<KichThuoc> selectBySql(String sql, Object... args) {
         ArrayList<KichThuoc> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {
                KichThuoc entity = new KichThuoc();
                entity.setMaDonVi(rs.getString("MADONVI"));
                entity.setTenDonVi(rs.getString("TENDONVI"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    

}
