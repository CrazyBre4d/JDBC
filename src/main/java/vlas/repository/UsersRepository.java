package vlas.repository;

import vlas.entity.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersRepository extends AbstractRepository{
    private static final String dbCommand1 = "INSERT INTO userss (user_id, f_name, l_name, role_id, loginn, passwordd) " +
            "VALUES (%d ,'%s','%s', %d,'%s','%s')";
    private static final String dbCommand2 = "DELETE FROM %s WHERE user_id = %d";

    public void create(Users entity) {
        String query = String.format(dbCommand1, entity.getUserId(), entity.getFirstName(), entity.getLastName(),
                entity.getRoleId(), entity.getLogin(), entity.getPassword());
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
        return "userss";
    }

    @Override
    protected Users mapResultSetToEntity(ResultSet rs) throws SQLException {
        Users users = new Users(rs.getInt(1),rs.getString(2), rs.getString(3),
                rs.getInt(4), rs.getString(5), rs.getString(6));
        return users;
    }
}
