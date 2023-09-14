package vlas.repository;


import vlas.services.HikariCP;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractRepository<T> {

    private static final String dbCommand = "SELECT * FROM %s";
    private static final String dbCommand2 = "DELETE FROM %s WHERE id = %d";
    public List<T> getAll() {
        List<T> entities = new ArrayList<>();
        String query = String.format(dbCommand, getTableName());
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
             conn = HikariCP.getDataSource().getConnection();
             stmt = conn.prepareStatement(query);
             rs = stmt.executeQuery();
            while (rs.next()) {
                T entity = mapResultSetToEntity(rs);
                entities.add(entity);
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
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return entities;
    }
    public void delete(int id) {
        String query = String.format(dbCommand2, getTableName(), id);
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = HikariCP.getDataSource().getConnection();
            stmt = conn.prepareStatement(query) ;
            stmt.executeUpdate();
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
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    protected abstract String getTableName();
    protected abstract T mapResultSetToEntity(ResultSet rs) throws SQLException;

}