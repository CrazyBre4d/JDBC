package vlas.repository;

import vlas.entity.ProductType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProdTypeRepository extends AbstractRepository{


    public void create(ProductType entity) {
        String query = String.format("INSERT INTO ROLESS (role_id, role_name) VALUES (%d ,'%s')", entity.getTypeId(), entity.getTypeName());
        System.out.println(query);
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
             stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void delete(int id) {
        String query = String.format("DELETE FROM %s WHERE type_id = %d", getTableName(), id);
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
        return "product_type";
    }

    @Override
    protected ProductType mapResultSetToEntity(ResultSet rs) throws SQLException {
        ProductType prodType = new ProductType(rs.getInt(1),rs.getString(2));
        return prodType;
    }
}
