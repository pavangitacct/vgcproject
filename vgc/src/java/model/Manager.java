package model;

import dbutil.DBUtil;
import entity.Faculty;
import entity.Student;
import entity.SuperAdmin;
import entity.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Manager {

    public Manager() {
    }

    public static void main(String atgc[]) {
        Manager m = new Manager();
        User user = m.getUser("hellohi", "pw1");
        System.out.println(user);
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
