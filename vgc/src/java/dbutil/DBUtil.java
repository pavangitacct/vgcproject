package dbutil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBUtil {

    public static void main(String argc[]) {
        //DBUtil.createCourse("MCA123", "Master Of Computer Applications.");
        //DBUtil.createStudentResult(1L, 3L, 50);
        DBUtil.createFee("first term", 3L, 5000, "August 21 2018");
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

    public static boolean createStudentResult(Long testId, Long studentid, int marks) {
        PreparedStatement pstmt = null;
        int numberOfRowsCreated = 0;
        try {
            pstmt = DBConnector.getConnection().prepareStatement("insert into studenttest (studentid,testid,marksgained) values(?,?,?)");
            pstmt.setLong(1, studentid);
            pstmt.setLong(2, testId);
            pstmt.setInt(3, marks);
            numberOfRowsCreated = pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numberOfRowsCreated == 1;
    }

    public static boolean createBranch(String name, String description) {
        PreparedStatement pstmt = null;
        int numberOfRowsCreated = 0;
        try {
            pstmt = DBConnector.getConnection().prepareStatement("insert into branch (name, details) values(?,?)");
            pstmt.setString(1, name);
            pstmt.setString(2, description);
            numberOfRowsCreated = pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numberOfRowsCreated == 1;
    }

    public static boolean createFee(String feePurpose, Long studentId, int amount, String paidDate) {
        PreparedStatement pstmt = null;
        int numberOfRowsCreated = 0;
        try {
            pstmt = DBConnector.getConnection().prepareStatement("insert into fee (feename,studentid,amount,paiddate) values(?,?,?,?)");
            pstmt.setString(1, feePurpose);
            pstmt.setLong(2, studentId);
            pstmt.setInt(3, amount);
            pstmt.setString(4, paidDate);
            numberOfRowsCreated = pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numberOfRowsCreated == 1;
    }

    public static boolean createCourse(String name, String description) {
        PreparedStatement pstmt = null;
        int numberOfRowsCreated = 0;
        try {
            pstmt = DBConnector.getConnection().prepareStatement("insert into course (name, details) values(?,?)");
            pstmt.setString(1, name);
            pstmt.setString(2, description);
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
