package dbutil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBUtil {

    public static void main(String argc[]) {
        DBUtil.createTest("half yearly", false, true, "This is half yearly examinations", 200);
//DBUtil.registerStudent("hello", "hi", "pw1");
        //System.out.println(DBUtil.getAvailableRows("student", "id=1"));
        /*ResultSet rs = DBUtil.getTableResultSet("faculty", "id", 1);
        try {
            while (rs.next()) {
                System.out.println(rs.getString(2));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }
    
    

    public static int getAvailableRows(String tableName, String whereClause) {
        int totalaAvailableRows = 0;

        String query = "select count(1) from " + tableName + " where " + whereClause;
        try {
            ResultSet rs = DBConnector.getStatement().executeQuery(query);
            while (rs.next()) {
                totalaAvailableRows = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return totalaAvailableRows;
    }

    public static int getAvailableRows(String tableName) {
        int totalaAvailableRows = 0;

        String query = "select count(1) from " + tableName;
        try {
            ResultSet rs = DBConnector.getStatement().executeQuery(query);
            while (rs.next()) {
                totalaAvailableRows = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return totalaAvailableRows;
    }

    public static ResultSet getTableResultSet(String tableName) {
        ResultSet rs = null;
        String query = "select * from " + tableName;
        try {
            rs = DBConnector.getStatement().executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public static ResultSet getTableResultSet(String tableName, String columnName, int value) {
        ResultSet rs = null;
        String query = "select * from " + tableName + " where " + columnName + " = " + value;
        try {
            rs = DBConnector.getStatement().executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public static ResultSet getTableResultSet(String tableName, String whereClause) {

        ResultSet rs = null;
        String query = "select * from " + tableName + " where " + whereClause;
        System.out.println(query);
        try {
            rs = DBConnector.getStatement().executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
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

    public static boolean createTest(String testName, boolean assignment, boolean exam, String description, int maxMarksAlloted) {
        PreparedStatement pstmt = null;
        int numberOfRowsCreated = 0;
        try {
            pstmt = DBConnector.getConnection().prepareStatement("insert into test (name,isAssignment,isExam,testdetails,maxmarkalloted) values(?,?,?,?,?)");
            pstmt.setString(1, testName);
            pstmt.setInt(2, assignment ? 1 : 0);
            pstmt.setInt(3, exam ? 1 : 0);
            pstmt.setString(4, description);
            pstmt.setInt(5, maxMarksAlloted);
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
