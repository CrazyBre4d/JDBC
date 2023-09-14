package vlas.repository;

import vlas.entity.Users;
import vlas.services.HikariCP;
import vlas.validation.Validator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersRepository extends AbstractRepository {
    private static final String dbCommand1 = "INSERT INTO userss (user_id, f_name, l_name, role_id, loginn, passwordd) " +
            "VALUES (%d ,'%s','%s', %d,'%s','%s')";
    private static final String dbCommand2 = "DELETE FROM %s WHERE user_id = %d";
    private static final String dbCommand3 = "SELECT * FROM userss WHERE loginn = '%s'";
    private static final String dbCommand4 = "SELECT * FROM userss WHERE passwordd = '%s'";

    public void create(Users entity) {
        String query = String.format(dbCommand1, entity.getUserId(), entity.getFirstName(), entity.getLastName(),
                entity.getRoleId(), entity.getLogin(), entity.getPassword());
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

    public String getPasswordFromDB(String username) {
        String password = null;
        String query =String.format(dbCommand3,username) ;
        try (Connection conn = HikariCP.getDataSource().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    password = rs.getString(6);

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return password;
    }
    public String getUserFromDB(String password1) {
        String user = null;
        String pass = Validator.getMD5Hash(password1);
        String query =String.format(dbCommand4,pass) ;
        System.out.println(query);
        try (Connection conn = HikariCP.getDataSource().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    user = rs.getString(5);

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    public int getRoleFromDB(String username) {
        int roleId = 0;
        String query =String.format("SELECT * FROM userss WHERE loginn = '%s'",username) ;
        try (Connection conn = HikariCP.getDataSource().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    roleId = rs.getInt(4);

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roleId;
    }

    public int getIdFromDB(String username) {
        int id = 0;
        String query =String.format("SELECT * FROM userss WHERE loginn = '%s'",username) ;
        try (Connection conn = HikariCP.getDataSource().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    id = rs.getInt(1);

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }




    @Override
    protected String getTableName() {
        return "userss";
    }

    @Override
    protected Users mapResultSetToEntity(ResultSet rs) throws SQLException {
        Users users = new Users(rs.getLong(1), rs.getString(2), rs.getString(3),
                rs.getLong(4), rs.getString(5), rs.getString(6));
        return users;
    }



}
