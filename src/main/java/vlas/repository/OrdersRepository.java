package vlas.repository;

import vlas.entity.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrdersRepository extends AbstractRepository{

    private static final String dbCommand1 = "INSERT INTO orders (order_id, user_id, product_id, is_ordered," +
            " purchase_date) VALUES (%d , %d, %d, %d, '%s')";
    private static final String dbCommand2 = "DELETE FROM %s WHERE order_id = %d";
    public void create(Orders entity) {
        String query = String.format(dbCommand1, entity.getOrderId(), entity.getUserId(),
                entity.getProductId(), entity.getIsOrdered(), entity.getPurchaseDate());
        System.out.println(query);
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void delete(int id) {
        String query = String.format(dbCommand2, getTableName(), id);
        System.out.println(query);
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected String getTableName() {
        return "orders";
    }

    @Override
    protected Orders mapResultSetToEntity(ResultSet rs) throws SQLException {
        Orders orders = new Orders(rs.getInt(1),rs.getInt(2),rs.getInt(3),
                rs.getInt(4), rs.getString(2));
        return orders;
    }
}
