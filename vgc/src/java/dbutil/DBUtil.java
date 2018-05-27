package dbutil;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBUtil {

    public static void main(String argc[]) {
        DBUtil.registerSuperAdmin("fn", "ln", "pw");
    }

    public static boolean registerStudent(String firstName, String lastName, String password) {
        PreparedStatement pstmt = null;
        int numberOfRowsCreated = 0;
        try {
            pstmt = DBConnector.getConnection().prepareStatement("insert into student (firstname,lastname,username,password) values(?,?,?,?)");
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setString(3, firstName + lastName);
            pstmt.setString(4, password);
            numberOfRowsCreated = pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numberOfRowsCreated == 1;
    }

    public static boolean registerFaculty(String firstName, String lastName, String password) {
        PreparedStatement pstmt = null;
        int numberOfRowsCreated = 0;
        try {
            pstmt = DBConnector.getConnection().prepareStatement("insert into faculty (firstname,lastname,username,password) values(?,?,?,?)");
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setString(3, firstName + lastName);
            pstmt.setString(4, password);
            numberOfRowsCreated = pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numberOfRowsCreated == 1;
    }

    public static boolean registerSuperAdmin(String firstName, String lastName, String password) {
        PreparedStatement pstmt = null;
        int numberOfRowsCreated = 0;
        try {
            pstmt = DBConnector.getConnection().prepareStatement("insert into superadmin(firstname,lastname,username,password) values(?,?,?,?)");
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setString(3, firstName + lastName);
            pstmt.setString(4, password);
            numberOfRowsCreated = pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numberOfRowsCreated == 1;
    }
}
