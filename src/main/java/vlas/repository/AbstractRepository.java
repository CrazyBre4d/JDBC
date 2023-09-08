package vlas.repository;

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

    // Метод для получения подключения к базе данных
    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    // Общие методы CRUD
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

    public T getById(long id) {
        String query = "SELECT * FROM " + getTableName() + " WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setLong(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToEntity(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void create(T entity) {
        String query = "INSERT INTO " + getTableName() + " " + generateInsertQuery();
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            mapEntityToPreparedStatement(stmt, entity);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(T entity) {
        String query = "UPDATE " + getTableName() + " SET " + generateUpdateQuery() + " WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            mapEntityToPreparedStatement(stmt, entity);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(long id) {
        String query = "DELETE FROM " + getTableName() + " WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Абстрактные методы, которые должны быть реализованы в конкретных репозиториях
    protected abstract String getTableName();
    protected abstract T mapResultSetToEntity(ResultSet rs) throws SQLException;
    protected abstract void mapEntityToPreparedStatement(PreparedStatement stmt, T entity) throws SQLException;
    protected abstract String generateInsertQuery();
    protected abstract String generateUpdateQuery();
}