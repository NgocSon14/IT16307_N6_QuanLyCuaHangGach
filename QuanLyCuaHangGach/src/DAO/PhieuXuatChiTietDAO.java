package DAO;

import Entity.PhieuXuatChiTiet;
import Helper.jdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PhieuXuatChiTietDAO extends DAO<PhieuXuatChiTiet, Object> {

    String SELECT_ALL_SQL = "select * from PHIEUXUATCHITIET";
    String SELECT_BY_ID_SQL = "select * from PHIEUXUATCHITIET where MAPHIEUXUATCHITIET =?";
    String INSERT_SQL = "insert into PHIEUXUATCHITIET(MAPHIEUXUATCHITIET,MAPHIEUXUAT,MAGACH,MANHACUNGCAP,SOLUONG,GIABAN) values(?,?,?,?,?,?)";
    String DELETE_SQL = "delete PHIEUXUATCHITIET where MAPHIEUXUATCHITIET = ?";
    String UPDATE_SQL = "update PHIEUXUATCHITIET set MAPHIEUXUAT = ?, MAGACH = ?, MANHACUNGCAP=?, SOLUONG=?,GIABAN=? where MAPHIEUXUATCHITIET = ?";

    @Override
    public void them(PhieuXuatChiTiet entity) {
        jdbcHelper.update(INSERT_SQL, entity.getMaPhieuXuatChiTiet(),entity.getMaPhieuXuat(),entity.getMaGach(),entity.getNhaCungCap(),entity.getSoLuong(),entity.getGiaBan());
    }

    @Override
    public void capNhat(PhieuXuatChiTiet entity) {
        jdbcHelper.update(UPDATE_SQL, entity.getMaPhieuXuat(),entity.getMaGach(),entity.getNhaCungCap(),entity.getSoLuong(),entity.getGiaBan());
    }

    @Override
    public void xoa(Object key) {
        jdbcHelper.update(DELETE_SQL, key);
    }

    @Override
    public ArrayList<PhieuXuatChiTiet> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public PhieuXuatChiTiet selectByID(Object key) {
        ArrayList<PhieuXuatChiTiet> list = selectBySql(SELECT_BY_ID_SQL, key);
        if(list.isEmpty()){
            return null;
        }
        return  list.get(0);
    }

    @Override
    protected ArrayList<PhieuXuatChiTiet> selectBySql(String sql, Object... args) {
        ArrayList<PhieuXuatChiTiet> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {
                PhieuXuatChiTiet entity = new PhieuXuatChiTiet();
                entity.setMaPhieuXuatChiTiet(rs.getString("MAPHIEUXUATCHITIET"));
                entity.setMaPhieuXuat(rs.getString("MAPHIEUXUAT"));
                entity.setMaGach(rs.getString("MAGACH"));
                entity.setNhaCungCap(rs.getString("NHACUNGCAP"));
                entity.setSoLuong(rs.getInt("SOLUONG"));
                entity.setGiaBan(rs.getFloat("MAPHIEUXUATCHITIET"));

                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
