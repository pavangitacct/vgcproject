package dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnector {

    private static final String driverName = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/vgc";
    private static final String un = "root";
    private static final String pw = "mysql";

    public static Connection getConnection() {

        Connection connection = null;
        try {
            Class.forName(driverName);
            connection = DriverManager.getConnection(
               url, un, pw);
            return connection;
        } catch (SQLException ex) {
            System.out.println("SQL Exception : " + ex);
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFounException : " + ex);
        }
        return connection;
    }

    public static Statement getStatement() {
        try {
            return getConnection().createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }
}
