package vlas.repository;

import vlas.entity.ForUser;
import vlas.services.HikariCP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewRepo extends AbstractRepository {
    private static final String dbCommand = "UPDATE foruser SET is_ordered = 1";


    public void updateView(){
        String query = dbCommand;
        Connection conn = null;
        PreparedStatement stmt = null;
    }




    @Override
    protected String getTableName() {
        return "foruser";
    }

    @Override
    protected ForUser mapResultSetToEntity(ResultSet rs) throws SQLException {
        ForUser forUser = new ForUser(rs.getString(1),rs.getString(2), rs.getString(3),
                rs.getString(4), rs.getLong(5), rs.getInt(6));
        return forUser;
    }
}
