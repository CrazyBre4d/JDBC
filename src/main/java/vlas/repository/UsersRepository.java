package vlas.repository;

import oracle.jdbc.proxy.annotation.Pre;
import vlas.entity.Users;
import vlas.services.HikariCP;
import vlas.validation.Validator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersRepository extends AbstractRepository {
    private static final String dbCommand1 = "INSERT INTO userss (id, f_name, l_name, role_id, loginn, passwordd) " +
            "VALUES (MYSEQ.nextval,?,?, ?,?,?)";
    private static final String dbCommand3 = "SELECT * FROM userss WHERE loginn = ?";
    private static final String dbCommand4 = "SELECT * FROM userss WHERE passwordd = ?";

    public void create(Users entity) {
        String query = dbCommand1;
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
             conn = HikariCP.getDataSource().getConnection();
             stmt = conn.prepareStatement(query);
             stmt.setString(1,entity.getFirstName());
             stmt.setString(2, entity.getLastName());
             stmt.setLong(3, entity.getRoleId());
             stmt.setString(4, entity.getLogin());
             stmt.setString(5, entity.getPassword());
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


    public String getPasswordFromDB(String username) {
        String password = null;
        String query = dbCommand3;
        PreparedStatement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
             conn = HikariCP.getDataSource().getConnection();
             stmt = conn.prepareStatement(query);
             stmt.setString(1, username);
             rs = stmt.executeQuery();
                if (rs.next()) {
                    password = rs.getString(6);
                }
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
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return password;
    }
    public String getUserFromDB(String password1) {
        String user = null;
        String pass = Validator.getMD5Hash(password1);
        String query = dbCommand4 ;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
             conn = HikariCP.getDataSource().getConnection();
             stmt = conn.prepareStatement(query);
             stmt.setString(1, password1);
             rs = stmt.executeQuery();
                if (rs.next()) {
                    user = rs.getString(5);
                }
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
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user;
    }
    public int getRoleFromDB(String username) {
        int roleId = 0;
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement stmt = null;
        String query = dbCommand3;
        try {
             conn = HikariCP.getDataSource().getConnection();
             stmt = conn.prepareStatement(query);
             stmt.setString(1,username);
             rs = stmt.executeQuery();
                if (rs.next()) {
                    roleId = rs.getInt(4);

                }

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
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return roleId;
    }

    public int getIdFromDB(String username) {
        int id = 0;
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement stmt = null;
        String query = dbCommand3;
        try {
            conn = HikariCP.getDataSource().getConnection();
            stmt = conn.prepareStatement(query);
            stmt.setString(1,username);
            rs = stmt.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);

            }

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
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
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
