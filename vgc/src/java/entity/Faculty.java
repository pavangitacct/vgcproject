package entity;

public class Faculty extends User {

    public Faculty(long id, String firstName, String lastName, boolean superAdmin, boolean faculty, boolean student) {
        super(id, firstName, lastName, superAdmin, faculty, student);
    }

    public Faculty(long id, String firstName, String lastName) {
        super(id, firstName, lastName, false, true, false);
    }
}
