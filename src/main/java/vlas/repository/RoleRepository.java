package vlas.repository;

import vlas.entity.Roles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class RoleRepository extends AbstractRepository<Roles> {
    private static final String dbCommand1 = "INSERT INTO roless (role_id, role_name) VALUES (%d ,'%s')";
    private static final String dbCommand2 = "DELETE FROM %s WHERE role_id = %d";

    public void create(Roles entity) {
        String query = String.format(dbCommand1, entity.getRoleId(), entity.getRoleName());
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
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected String getTableName() {
        return "roless";
    }

    @Override
    protected Roles mapResultSetToEntity(ResultSet rs) throws SQLException {
        Roles role = new Roles(rs.getInt(1),rs.getString(2));
        return role;
    }



}