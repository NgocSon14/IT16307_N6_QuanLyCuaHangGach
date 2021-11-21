
package DAO;

import Entity.PhieuXuat;
import Helper.jdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class PhieuXuatDAO extends DAO<PhieuXuat, String> {

    String SELECT_ALL_SQL = "select * from PHIEUXUAT";
    String SELECT_BY_ID_SQL = "select * from PHIEUXUAT where MAPHIEUXUAT =?";
    String INSERT_SQL = "insert into PHIEUXUAT(MAPHIEUXUAT,NGAYXUAT,MAKHACHHANG,TRANGTHAI,) values(?,?,?,?)";
    String DELETE_SQL = "delete PHIEUXUAT where MAPHIEUXUAT = ?";
    String UPDATE_SQL = "update PHIEUXUAT set NGAYXUAT = ?, MAKHACHHANG = ?, TRANGTHAI=? where MAPHIEUXUATCHITIET = ?";

    @Override
    public void them(PhieuXuat entity) {
 jdbcHelper.update(INSERT_SQL, entity.getMaPhieuXuat(),entity.getNgayXuat(),entity.getMaKhachHang(),entity.getTrangThai());
    }

    @Override
    public void capNhat(PhieuXuat entity) {
        jdbcHelper.update(UPDATE_SQL, entity.getNgayXuat(),entity.getMaKhachHang(),entity.getTrangThai());
    }

    @Override
    public void xoa(String key) {
        jdbcHelper.update(DELETE_SQL, key);
    }

    @Override
    public ArrayList<PhieuXuat> selectAll() {
         return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public PhieuXuat selectByID(String key) {
         ArrayList<PhieuXuat> list = this.selectBySql(SELECT_BY_ID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected ArrayList<PhieuXuat> selectBySql(String sql, Object... args) {
        ArrayList<PhieuXuat> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {
                PhieuXuat entity = new PhieuXuat();
                entity.setMaPhieuXuat(rs.getString("MAPHIEUXUAT"));
                entity.setNgayXuat(rs.getString("NGAYXUAT"));
                entity.setMaKhachHang(rs.getString("MAKHACHHANG"));
                entity.setTrangThai(rs.getBoolean("TRANGTHAI"));

                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
        public List<Integer> selectYear(){
        String sql = "SELECT DISTINCT YEAR(NgayKG) FROM dbo.PHIEUXUAT ORDER BY YEAR(NgayKG) DESC";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs= jdbcHelper.query(sql);
            while (rs.next()) {                
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
