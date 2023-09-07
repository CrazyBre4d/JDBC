package vlas;

import java.sql.*;

public class  OracleConnection {
    private String command;

    public OracleConnection(String command) {
        this.command = command;
    }

    public  void  getTable( String name ) throws SQLException {

      /*  Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(name);
        while (rs.next()) {
            System.out.println(rs.getInt(1) + " " + rs.getString(2) + " "
                    + rs.getString(3) + " " + rs.getInt(4) + " " + rs.getString(5) + " " + rs.getString(6));
        }*/
    }

    /*    String sql = "INSERT INTO USERSS (user_id, f_name, l_name, role_id, loginn, passwordd) " +
            "values (2, 'Vlas3', 'Kabakov', 1, 'vlas1', 'vlas')";
    PreparedStatement ps = conn.prepareStatement(sql);
        ps.executeUpdate();*/
}


