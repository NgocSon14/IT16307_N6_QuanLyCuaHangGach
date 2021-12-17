
package Helper;

import java.sql.*;
public class jdbcHelper {
    static String url = "jdbc:sqlserver://localhost\\LAPTOP-SFOPP4EV:1433;databaseName=QuanLiKho";
    static String user = "sa";
    static String pass = "1312002";
    
     public static PreparedStatement getPstm(String sql, Object... args) throws SQLException {
        Connection con = DriverManager.getConnection(url, user, pass);
        PreparedStatement pstm;
        if (sql.trim().startsWith("{")) {
            pstm = con.prepareCall(sql); 
        } else {
            pstm = con.prepareStatement(sql);
        }
        for (int i = 0; i < args.length; i++){
            pstm.setObject(i + 1, args[i]);
        }
        return pstm;
    }

    public static ResultSet query(String sql, Object... args) throws SQLException {
        PreparedStatement pstm = jdbcHelper.getPstm(sql, args);
        return pstm.executeQuery();
    }

    public static Object value(String sql, Object... args) {
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            if (rs.next()) {
                return rs.getObject(0);
            }
            rs.getStatement().getConnection().close();
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static int update(String sql, Object... args) {
        try {
            PreparedStatement pstm = jdbcHelper.getPstm(sql, args);
            try {
                return pstm.executeUpdate();
            } finally {
                pstm.getConnection().close();
            }

        } catch (Exception e) {
            throw new RuntimeException(e);

        }
    }
    public static Connection opConnection() throws Exception {
        String url = "jdbc:sqlserver://localhost\\LAPTOP-SFOPP4EV:1433;databaseName=QuanLiKho";
        String user = "sa";
        String pass = "1312002";
        Connection con = DriverManager.getConnection(url, user, pass);
        return con;
    }
}
