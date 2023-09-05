package vlas;

import java.sql.*;

/*
JDBC
Statement
PreparedStatement
callablestatement

View в базе данных
и не только читать
а реализовывать программу
С авторизацией и регистрацией на JAva
В консольке с подключенной бд. Ну думаю, что пока что все*/

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        Class.forName("oracle.jdbc.driver.OracleDriver");
        conn = DriverManager.getConnection("jdbc:oracle:thin:@scomplat.scx:1521:komplat","kabakov","kabakov");

        String sql = "INSERT INTO USERSS (user_id, f_name, l_name, role_id, loginn, passwordd) " +
                "values (1, 'Vlas', 'Kabakov', 1, 'vlas', 'vlas')";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.executeUpdate();




       /* rs = st.executeQuery("INSERT INTO USERSS (user_id, f_name, l_name, role_id, loginn, passwordd) " +
                "values (1, 'Vlas', 'Kabakov', 1, 'vlas', 'vlas')");
        while (rs.next()) {
            System.out.println(rs.getInt(1) + "" + rs.getString(2) + ""
                    + rs.getString(3) + "" + rs.getInt(4) + "" + rs.getString(5) + "" + rs.getString(6));
        }*/




         if (rs != null) {rs.close();}
         if (st != null) {st.close();}
         if (conn != null) {conn.close();}



        System.out.println("Hello world!");
    }
}