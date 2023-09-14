package vlas.repository;

import vlas.entity.Roles;
import vlas.services.HikariCP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleRepository extends AbstractRepository<Roles> {
    private static final String dbCommand1 = "INSERT INTO roless (id, role_name) VALUES (MYSEQ.nextval ,?)";

    public void create(Roles entity) {
        String query = dbCommand1;
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = HikariCP.getDataSource().getConnection();
            stmt = conn.prepareStatement(query);

            stmt.setString(1,entity.getRoleName());
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
        return "roless";
    }

    @Override
    protected Roles mapResultSetToEntity(ResultSet rs) throws SQLException {
        Roles role = new Roles(rs.getLong(1),rs.getString(2));
        return role;
    }



}