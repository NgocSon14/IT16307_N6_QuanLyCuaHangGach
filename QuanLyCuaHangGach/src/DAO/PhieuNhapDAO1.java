package DAO;

import Entity.PhieuNhap;
import Helper.jdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sktqu
 */
public class PhieuNhapDAO extends DAO<PhieuNhap, String> {

    String SELECT_ALL_SQL = "select * from PHIEUNHAP";
    String SELECT_BY_ID_SQL = "select * from PHIEUNHAP where MAPHIEUNHAP =?";
    String INSERT_SQL = "insert into PHIEUNHAP(MAPHIEUNHAP,NGAYNHAP,MANHACUNGCAP,TRANGTHAI,) values(?,?,?,?)";
    String DELETE_SQL = "delete PHIEUNHAP where MAPHIEUNHAP = ?";
    String UPDATE_SQL = "update PHIEUNHAP set NGAYNHAP = ?, MANHACUNGCAP = ?, TRANGTHAI=? where MAPHIEUNHAPCHITIET = ?";

    @Override
    public void them(PhieuNhap entity) {
        jdbcHelper.update(INSERT_SQL, entity.getMaPhieuNhap(), entity.getNgayNhap(), entity.getMaNhaCungCap(), entity.isTrangThai());
    }

    @Override
    public void capNhat(PhieuNhap entity) {
        jdbcHelper.update(UPDATE_SQL, entity.getNgayNhap(), entity.getMaNhaCungCap(), entity.isTrangThai());
    }

    @Override
    public void xoa(String key) {
        jdbcHelper.update(DELETE_SQL, key);
    }

    @Override
    public ArrayList<PhieuNhap> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public PhieuNhap selectByID(String key) {
        ArrayList<PhieuNhap> list = this.selectBySql(SELECT_BY_ID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected ArrayList<PhieuNhap> selectBySql(String sql, Object... args) {
        ArrayList<PhieuNhap> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {
                PhieuNhap entity = new PhieuNhap();
                entity.setMaPhieuNhap(rs.getString("MAPHIEUNHAP"));
                entity.setNgayNhap(rs.getString("NGAYNNHAP"));
                entity.setMaNhaCungCap(rs.getString("MANHACUNGCAP"));
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
        String sql = "SELECT DISTINCT YEAR(NgayKG) FROM dbo.PHIEUNHAP ORDER BY YEAR(NgayKG) DESC";
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