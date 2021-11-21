
package DAO;
import Entity.PhieuNhapChiTiet;
import Helper.jdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PhieuNhapChiTietDAO extends DAO<PhieuNhapChiTiet, String>{

    String SELECT_ALL_SQL = "select * from PHIEUNHAPCHITIET";
    String SELECT_BY_ID_SQL = "select * from PHIEUNHAPCHITIET where MAPHIEUNHAPCHITIET =?";
    String INSERT_SQL = "insert into PHIEUNHAPCHITIET(MAPHIEUNHAPCHITIET,MAPHIEUNHAP,MAGACH,SOLUONG,GIANHAP,GIABAN) values(?,?,?,?,?,?)";
    String DELETE_SQL = "delete PHIEUNHAPCHITIET where MAPHIEUNHAPCHITIET = ?";
    String UPDATE_SQL = "update PHIEUNHAPCHITIET set MAPHIEUNHAP = ?, MAGACH = ?, SOLUONG=?, GIANHAP=?,GIABAN=? where MAPHIEUNHAPCHITIET = ?";

    @Override
    public void them(PhieuNhapChiTiet entity) {
        jdbcHelper.update(INSERT_SQL, entity.getMaPhieuNhapChiTiet(),entity.getMaPhieuNhap(),entity.getMaGach(),entity.getSoluong(),entity.getGiaNhap(),entity.getGiaBan());
    }

    @Override
    public void capNhat(PhieuNhapChiTiet entity) {
        jdbcHelper.update(UPDATE_SQL, entity.getMaPhieuNhap(),entity.getMaGach(),entity.getSoluong(),entity.getGiaNhap(),entity.getGiaBan());
    }

    @Override
    public void xoa(String key) {
        jdbcHelper.update(DELETE_SQL, key);
    }

    @Override
    public ArrayList<PhieuNhapChiTiet> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public PhieuNhapChiTiet selectByID(String key) {
         ArrayList<PhieuNhapChiTiet> list = selectBySql(SELECT_BY_ID_SQL, key);
        if(list.isEmpty()){
            return null;
        }
        return  list.get(0);
    }

    @Override
    protected ArrayList<PhieuNhapChiTiet> selectBySql(String sql, Object... args) {
        ArrayList<PhieuNhapChiTiet> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {
                PhieuNhapChiTiet entity = new PhieuNhapChiTiet();
                entity.setMaPhieuNhapChiTiet(rs.getString("MAPHIEUNHAPCHITIET"));
                entity.setMaPhieuNhap(rs.getString("MAPHIEUXUAT"));
                entity.setMaGach(rs.getString("MAGACH"));
                entity.setSoluong(rs.getInt("SOLUONG"));
                entity.setGiaNhap(rs.getFloat("GIANHAP"));
                entity.setGiaBan(rs.getFloat("GIABAN"));

                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
}
