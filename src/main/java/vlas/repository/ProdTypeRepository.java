package vlas.repository;

import vlas.entity.ProductType;
import vlas.services.HikariCP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProdTypeRepository extends AbstractRepository{

    private static final String dbCommand1 = "INSERT INTO product_type (type_id, type_name) VALUES (%d ,'%s')";
    private static final String dbCommand2 = "DELETE FROM %s WHERE type_id = %d";
    public void create(ProductType entity) {
        String query = String.format(dbCommand1, entity.getTypeId(), entity.getTypeName());
        System.out.println(query);
        try (Connection conn = HikariCP.getDataSource().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
             stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public String test() throws SQLException {
     int id = 1;
     String idd = null;
    String query = "SELECT * FROM PRODUCT_TYPE WHERE type_id = ?";
    Connection conn = HikariCP.getDataSource().getConnection();
    PreparedStatement stmt = conn.prepareStatement(query) ;
    stmt.setInt(1, id);
    ResultSet rs = stmt.executeQuery();
    System.out.println(rs);
        while (rs.next()) {
          idd = rs.getString(2);

        }
        conn.close();
        stmt.close();
        rs.close();
        return idd;
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
        return "product_type";
    }

    @Override
    protected ProductType mapResultSetToEntity(ResultSet rs) throws SQLException {
        ProductType prodType = new ProductType(rs.getLong(1),rs.getString(2));
        return prodType;
    }
}
