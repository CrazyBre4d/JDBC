package vlas.repository;

import vlas.entity.Roles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractRepository<T> {
    private static final String DB_URL = "jdbc:oracle:thin:@scomplat.scx:1521:komplat";
    private static final String DB_USER = "kabakov";
    private static final String DB_PASSWORD = "kabakov";


    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    public List<T> getAll() {
        List<T> entities = new ArrayList<>();
        String query = "SELECT * FROM " + getTableName();
        try (Connection conn = getConnection();
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