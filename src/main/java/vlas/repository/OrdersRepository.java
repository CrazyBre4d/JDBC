package vlas.repository;

import oracle.jdbc.proxy.annotation.Pre;
import vlas.entity.*;
import vlas.services.HikariCP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class OrdersRepository extends AbstractRepository{
    private static final String dbCommand = "UPDATE ORDERS SET is_ordered = 1 where USER_ID = ?";
    private static final String dbCommand1 = "INSERT INTO orders (id1, user_id, product_id, is_ordered," +
            " purchase_date) VALUES (MYSEQ.nextval , ?, ?, ?, ?)";
    private static final String dbCommand2 = "DELETE FROM orders WHERE id1 = ?";
    private static final String dbCommand3 = "UPDATE ORDERS SET purchase_date = ? where IS_ORDERED = 0 AND USER_ID = ?";

    public void create(Orders entity) {
        String query = dbCommand1;
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = HikariCP.getDataSource().getConnection();
            stmt = conn.prepareStatement(query);
            stmt.setLong(1,entity.getUserId());
            stmt.setLong(2,entity.getProductId());
            stmt.setInt(3, entity.getIsOrdered());
            stmt.setDate(4,entity.getPurchaseDate());
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
    public void setDate( Long userId) {
        LocalDate currentDate = LocalDate.now();
        java.sql.Date sqlCurrentDate = java.sql.Date.valueOf(currentDate);
        String query = dbCommand3;
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = HikariCP.getDataSource().getConnection();
            stmt = conn.prepareStatement(query) ;
            stmt.setDate(1, sqlCurrentDate);
            stmt.setLong(2, userId);
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
    public void updateView( int userId){
        String query = dbCommand;
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = HikariCP.getDataSource().getConnection();
            stmt = conn.prepareStatement(query);
            stmt.setLong(1, userId);
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
    public void delete1(int id) {
        String query = dbCommand2;
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = HikariCP.getDataSource().getConnection();
            stmt = conn.prepareStatement(query) ;
            stmt.setInt(1, id);
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

    @Override
    protected String getTableName() {
        return "orders";
    }

    @Override
    protected Orders mapResultSetToEntity(ResultSet rs) throws SQLException {
        Orders orders = new Orders(rs.getLong(1),rs.getLong(2),rs.getLong(3),
                rs.getInt(4), rs.getDate(5));
        return orders;
    }
}
