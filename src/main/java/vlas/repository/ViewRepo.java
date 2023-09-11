package vlas.repository;

import vlas.entity.ForUser;
import vlas.entity.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewRepo extends AbstractRepository {

    public void getView(String username) {
        String query =String.format("SELECT * FROM foruser WHERE f_name = '%s'",username) ;
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    System.out.println(mapResultSetToEntity(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected String getTableName() {
        return "foruser";
    }

    @Override
    protected ForUser mapResultSetToEntity(ResultSet rs) throws SQLException {
        ForUser forUser = new ForUser(rs.getString(1), rs.getString(2),
               rs.getInt(3));
        return forUser;
    }
}