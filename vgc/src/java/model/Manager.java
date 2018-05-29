package model;

import dbutil.DBUtil;
import entity.Branch;
import entity.Course;
import entity.Faculty;
import entity.Student;
import entity.SuperAdmin;
import entity.Test;
import entity.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Manager {

    public Manager() {
    }

    public static void main(String atgc[]) {
        Manager m = new Manager();
        //User user = m.getUser("hellohi", "pw1");
        //System.out.println(user);
        //m.getAllTests();
        m.addFacultY("faculty", "1", "pw");
    }

    public List<Branch> getAllBranches() {
        List<Branch> list = new ArrayList<Branch>();
        ResultSet rs = DBUtil.getTableResultSet("branch");
        try {
            while (rs.next()) {
                Branch branch = new Branch(rs.getString("name"), rs.getString("details"));
                System.out.println(branch);
                list.add(branch);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<Course> getAllCourses() {
        List<Course> list = new ArrayList<Course>();
        ResultSet rs = DBUtil.getTableResultSet("course");
        try {
            while (rs.next()) {
                Course course = new Course(rs.getString("name"), rs.getString("details"));
                System.out.println(course);
                list.add(course);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<Test> getAllTests() {
        List<Test> list = new ArrayList<Test>();
        ResultSet rs = DBUtil.getTableResultSet("test");
        try {
            while (rs.next()) {
                Test test = new Test(rs.getString("name"), rs.getInt("isExam") == 1, rs.getInt("isAssignment") == 1, rs.getString("testdetails"), rs.getInt("maxmarkalloted"));
                System.out.println(test);
                list.add(test);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public boolean createTest(String testName, boolean assignment, boolean exam, String description, int maxMarksAlloted) {
        return DBUtil.createTest(testName, assignment, exam, description, maxMarksAlloted);
    }

    public void addSuperAdmin(String firstName, String lastName, String password) {
        DBUtil.registerSuperAdmin(firstName, lastName, password);
    }

    public void addFacultY(String firstName, String lastName, String password) {
        DBUtil.registerFaculty(firstName, lastName, password);
    }

    public void addStudent(String firstName, String lastName, String password) {
        DBUtil.registerStudent(firstName, lastName, password);
    }

    public User getUser(String username, String password) {
        if (DBUtil.getAvailableRows("superadmin", "username = '" + username + "' and password = '" + password + "'") == 1) {
            ResultSet rs = DBUtil.getTableResultSet("superadmin", "username = '" + username + "' and password = '" + password + "'");
            try {
                while (rs.next()) {
                    try {
                        return new SuperAdmin(rs.getInt("id"), rs.getString("firstname"), rs.getString("lastname"));
                    } catch (SQLException ex) {
                        Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (DBUtil.getAvailableRows("faculty", "username = '" + username + "' and password = '" + password + "'") == 1) {
            ResultSet rs = DBUtil.getTableResultSet("faculty", "username = '" + username + "' and password = '" + password + "'");
            try {
                while (rs.next()) {
                    try {
                        return new Faculty(rs.getLong("id"), rs.getString("firstname"), rs.getString("lastname"));
                    } catch (SQLException ex) {
                        Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (DBUtil.getAvailableRows("student", "username = '" + username + "' and password = '" + password + "'") == 1) {
            ResultSet rs = DBUtil.getTableResultSet("student", "username = '" + username + "' and password = '" + password + "'");
            try {
                while (rs.next()) {
                    try {
                        return new Student(rs.getLong("id"), rs.getString("firstname"), rs.getString("lastname"));
                    } catch (SQLException ex) {
                        Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
}
