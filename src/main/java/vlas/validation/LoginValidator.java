package vlas.validation;

import vlas.services.HikariCP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginValidator {
    private static final String dbCommand = " SELECT * FROM userss WHERE loginn =?";
public static String check(String username) {
    Connection conn = null;
    ResultSet rs = null;
    String username1 = null;
    PreparedStatement stmt = null;
    String query = dbCommand;
    try {
        conn = HikariCP.getDataSource().getConnection();
        stmt = conn.prepareStatement(query);
        stmt.setString(1,username);
        rs = stmt.executeQuery();
        if (rs.next()) {
            username1 = rs.getString(5);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    return username1;
}
}

