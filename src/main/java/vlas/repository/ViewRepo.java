package vlas.repository;

import vlas.entity.ForUser;
import vlas.services.HikariCP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewRepo extends AbstractRepository {

    private static final String dbCommand1 = "SELECT * FROM foruser WHERE loginn = ?";
    public ForUser getView(String username) {
        ForUser forUser = new ForUser();
        String query = String.format(dbCommand1) ;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = HikariCP.getDataSource().getConnection();
            stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            rs = stmt.executeQuery();
                if (rs.next()) {
                    forUser = mapResultSetToEntity(rs);
                }

        } catch (SQLException e) {
            e.printStackTrace();
        }return forUser;
        }




    @Override
    protected String getTableName() {
        return "foruser";
    }

    @Override
    protected ForUser mapResultSetToEntity(ResultSet rs) throws SQLException {
        ForUser forUser = new ForUser(rs.getString(1),rs.getString(2), rs.getString(3),
                rs.getString(4), rs.getLong(5));
        return forUser;
    }
}
