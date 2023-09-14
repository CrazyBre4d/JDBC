package vlas.repository;

import oracle.jdbc.proxy.annotation.Pre;
import vlas.entity.ProductType;
import vlas.services.HikariCP;

import java.sql.*;

public class ProdTypeRepository extends AbstractRepository{

    private static final String dbCommand1 = "INSERT INTO product_type (id, type_name) VALUES (myseq.NEXTVAL ,?)";
    public void create(ProductType entity) {
        PreparedStatement stmt = null;
        Connection conn = null;
        String query = dbCommand1;

        try {
            conn = HikariCP.getDataSource().getConnection();
            stmt = conn.prepareStatement(query);
            stmt.setString(1, entity.getTypeName());
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
        return "product_type";
    }

    @Override
    protected ProductType mapResultSetToEntity(ResultSet rs) throws SQLException {
        ProductType prodType = new ProductType(rs.getLong(1),rs.getString(2));
        return prodType;
    }
}
