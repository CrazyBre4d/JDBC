package vlas.repository;

import vlas.entity.ForUser;
import vlas.services.HikariCP;

import java.sql.*;
import java.time.LocalDate;

public class ViewRepo extends AbstractRepository {

    @Override
    protected String getTableName() {
        return "foruser";
    }

    @Override
    protected ForUser mapResultSetToEntity(ResultSet rs) throws SQLException {
        ForUser forUser = new ForUser(rs.getString(1),rs.getString(2), rs.getString(3),
                rs.getString(4), rs.getLong(5), rs.getInt(6), rs.getLong(7), rs.getDate(8));
        return forUser;
    }
}
