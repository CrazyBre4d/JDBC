package vlas.repository;

import vlas.entity.Roles;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class RoleRepository extends AbstractRepository<Roles> {
    @Override
    protected String getTableName() {
        return "roless";
    }

    @Override
    protected Roles mapResultSetToEntity(ResultSet rs) throws SQLException {
        Roles role = new Roles();
        role.setRoleId(rs.getInt(1));
        role.setRoleName(rs.getString(2));
        return role;
    }

    @Override
    protected void mapEntityToPreparedStatement(PreparedStatement stmt, Roles entity) throws SQLException {
        stmt.setString(entity.getRoleId(), entity.getRoleName());
    }

    @Override
    protected String generateInsertQuery() {
        return "(role_id, role_name) VALUES (?)";
    }




}