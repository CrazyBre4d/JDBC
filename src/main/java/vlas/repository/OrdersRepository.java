package vlas.repository;

import oracle.jdbc.proxy.annotation.Pre;
import vlas.entity.*;
import vlas.services.HikariCP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrdersRepository extends AbstractRepository{

    private static final String dbCommand1 = "INSERT INTO orders (id, user_id, product_id, is_ordered," +
            " purchase_date) VALUES (? , ?, ?, ?, ?)";
    private static final String dbCommand2 = "SELECT * FROM %s WHERE user_id = ? and is_ordered = 0,";

    public void create(Orders entity) {
        String query = dbCommand1;
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = HikariCP.getDataSource().getConnection();
            stmt = conn.prepareStatement(query);
            stmt.setLong(1,entity.getOrderId());
            stmt.setLong(2,entity.getUserId());
            stmt.setLong(3,entity.getProductId());
            stmt.setInt(4, entity.getIsOrdered());
            stmt.setDate(5,entity.getPurchaseDate());
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
