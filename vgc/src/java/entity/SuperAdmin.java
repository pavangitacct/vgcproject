package entity;

public class SuperAdmin extends User {

    public SuperAdmin(long id, String firstName, String lastName, boolean superAdmin, boolean faculty, boolean student) {
        super(id, firstName, lastName, superAdmin, faculty, student);
    }

    public SuperAdmin(long id, String firstName, String lastName) {
        super(id, firstName, lastName, true, false, false);
    }
}
