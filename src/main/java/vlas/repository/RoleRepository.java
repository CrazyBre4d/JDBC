package vlas.repository;

import vlas.entity.Roles;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class RoleRepository extends AbstractRepository<Roles> {

    @Override
    protected String getTableName() {
        return "roles";
    }

    @Override
    protected Roles mapResultSetToEntity(ResultSet rs) throws SQLException {
        Roles role = new Roles();
        role.setRoleId(rs.getLong("role_id"));
        role.setRoleName(rs.getString("role_name"));
        return role;
    }

    @Override
    protected void mapEntityToPreparedStatement(PreparedStatement stmt, Roles entity) throws SQLException {
        stmt.setString(1, entity.getRoleName());
    }

    @Override
    protected String generateInsertQuery() {
        return "(role_name) VALUES (?)";
    }

    @Override
    protected String generateUpdateQuery() {
        return "role_name = ?";
    }

    // Дополнительные методы, если нужно
}