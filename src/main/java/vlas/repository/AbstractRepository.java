package vlas.repository;


import vlas.services.HikariCP;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractRepository<T> {

    private static final String dbCommand = "SELECT * FROM %s";

    public List<T> getAll() {
        List<T> entities = new ArrayList<>();
        String query = String.format(dbCommand, getTableName());
        try (Connection conn = HikariCP.getDataSource().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                T entity = mapResultSetToEntity(rs);
                entities.add(entity);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return entities;
    }



    protected abstract String getTableName();
    protected abstract T mapResultSetToEntity(ResultSet rs) throws SQLException;

}