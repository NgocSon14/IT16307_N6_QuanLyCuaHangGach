package DAO;

import Entity.PhieuXuat;
import Helper.jdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PhieuXuatDAO extends DAO<PhieuXuat, String> {

    String SELECT_ID = "select PHIEUXUAT.MAPHIEUXUAT from PHIEUXUAT";
    String SELECT_ALL_SQL = "select * from PHIEUXUAT";
    String SELECT_BY_ID_SQL = "select * from PHIEUXUAT where MAPHIEUXUAT =?";
    String INSERT_SQL = "insert into PHIEUXUAT(NGAYXUAT,MAKHACHHANG,TRANGTHAI) values(?,?,?)";
    String DELETE_SQL = "delete PHIEUXUAT where MAPHIEUXUAT = ?";
    String UPDATE_SQL = "update PHIEUXUAT set NGAYXUAT = ?, MAKHACHHANG = ?, TRANGTHAI=? where MAPHIEUXUAT = ?";
    String UPDATE_TRANHTHAI_SQL = "update PHIEUXUAT set TRANGTHAI=0 where MAPHIEUXUAT=?";

     public ArrayList<PhieuXuat> selectAllID() {
        return this.selectBySql(SELECT_ID);
    }
     
    public void capNhatTrangThai(String key) {
        jdbcHelper.update(UPDATE_TRANHTHAI_SQL,key);
    }
    @Override
    public void them(PhieuXuat entity) {
        jdbcHelper.update(INSERT_SQL, entity.getNgayXuat(), entity.getMaKhachHang(), entity.getTrangThai() == true);
    }

    @Override
    public void capNhat(PhieuXuat entity) {
        jdbcHelper.update(UPDATE_SQL, entity.getNgayXuat(), entity.getMaKhachHang(), entity.getTrangThai(), entity.getMaPhieuXuat());
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
                entity.setNgayXuat(rs.getDate("NGAYXUAT"));
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

    public List<Integer> selectYear() {
        String sql = "SELECT DISTINCT YEAR(NgayKG) FROM dbo.PHIEUXUAT ORDER BY YEAR(NgayKG) DESC";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(sql);
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
