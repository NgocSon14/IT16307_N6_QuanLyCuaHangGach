package DAO;

import Entity.ChatLieu;
import Helper.jdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sktqu
 */
public class ChatLieuDAO extends DAO<ChatLieu, String> {

    String SELECT_ALL_SQL = "select * from CHATLIEU";
    String SELECT_BY_ID_SQL = "select * from CHATLIEU where MACHATLIEU =?";
    String INSERT_SQL = "insert into CHATLIEU(MACHATLIEU,TENCHATLIEU) values(?,?)";
    String DELETE_SQL = "delete CHATLIEU where MACHATLIEU = ?";
    String UPDATE_SQL = "update CHATLIEU set TENCHATLIEU = ? where MACHATLIEU = ?";

    @Override
    public void them(ChatLieu entity) {
        jdbcHelper.update(INSERT_SQL, entity.getMaChatLieu(), entity.getTenChatLieu());
    }

    @Override
    public void capNhat(ChatLieu entity) {
        jdbcHelper.update(UPDATE_SQL, entity.getTenChatLieu());
    }

    @Override
    public void xoa(String key) {
        jdbcHelper.update(DELETE_SQL, key);
    }

    @Override
    public ArrayList<ChatLieu> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public ChatLieu selectByID(String key) {
        ArrayList<ChatLieu> list = selectBySql(SELECT_BY_ID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected ArrayList<ChatLieu> selectBySql(String sql, Object... args) {
        ArrayList<ChatLieu> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {
                ChatLieu entity = new ChatLieu();
                entity.setMaChatLieu(rs.getString("MACHATLIEU"));
                entity.setTenChatLieu(rs.getString("TENCHATLIEU"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
