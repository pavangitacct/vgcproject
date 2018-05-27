package entity;

public class Student extends User {

    public Student(long id, String firstName, String lastName, boolean superAdmin, boolean faculty, boolean student) {
        super(id, firstName, lastName, superAdmin, faculty, student);
    }

    public Student(long id, String firstName, String lastName) {
        super(id, firstName, lastName, false, false, true);
    }
}
