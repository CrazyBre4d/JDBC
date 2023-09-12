package vlas.repository;

import vlas.entity.Product;
import vlas.services.HikariCP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRepository extends AbstractRepository {
    private static final String dbCommand1 = "INSERT INTO product (product_id, product_name, product_price," +
            "product_description, type_id) VALUES (%d ,'%s', %d,'%s', %d)";
    private static final String dbCommand2 = "DELETE FROM %s WHERE product_id = %d";

    public void create(Product entity) {
        String query = String.format(dbCommand1, entity.getProductId(), entity.getProductName(), entity.getProductPrice(),
                entity.getProductDescription(), entity.getTypeId());
        System.out.println(query);
        try (Connection conn = HikariCP.getDataSource().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String query = String.format(dbCommand2, getTableName(), id);
        try (Connection conn = HikariCP.getDataSource().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    protected String getTableName() {
        return "product";
    }

    @Override
    protected Product mapResultSetToEntity(ResultSet rs) throws SQLException {
        Product product = new Product(rs.getInt(1), rs.getString(2), rs.getInt(3),
                rs.getString(4), rs.getInt(5));
        return product;
    }
}
