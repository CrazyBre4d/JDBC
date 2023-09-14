package vlas.repository;

import vlas.entity.Product;
import vlas.services.HikariCP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRepository extends AbstractRepository {
    private static final String dbCommand1 = "INSERT INTO product (id, product_name, product_price," +
            "product_description, type_id) VALUES (? ,?, ?, ?, ?)";
    public void create(Product entity) {
        String query = dbCommand1;
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = HikariCP.getDataSource().getConnection();
            stmt = conn.prepareStatement(query);
            stmt.setLong(1,entity.getProductId());
            stmt.setString(2,entity.getProductName());
            stmt.setInt(3, entity.getProductPrice());
            stmt.setString(4, entity.getProductDescription());
            stmt.setLong(5, entity.getTypeId());
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
        return "product";
    }

    @Override
    protected Product mapResultSetToEntity(ResultSet rs) throws SQLException {
        Product product = new Product(rs.getLong(1), rs.getString(2), rs.getInt(3),
                rs.getString(4), rs.getLong(5));
        return product;
    }
}
