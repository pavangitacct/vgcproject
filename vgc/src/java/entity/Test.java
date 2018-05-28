package entity;

public class Test {

    private String name;
    private boolean exam;
    private boolean assignment;
    private String description;
    private int maxMarksAlloted;

    public Test(String name, boolean exam, boolean assignment, String description, int maxMarksAlloted) {
        this.name = name;
        this.exam = exam;
        this.assignment = assignment;
        this.description = description;
        this.maxMarksAlloted = maxMarksAlloted;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isAssignment() {
        return assignment;
    }

    public boolean isExam() {
        return exam;
    }

    public int getMaxMarksAlloted() {
        return maxMarksAlloted;
    }

    public void setAssignment(boolean assignment) {
        this.assignment = assignment;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setExam(boolean exam) {
        this.exam = exam;
    }

    public void setMaxMarksAlloted(int maxMarksAlloted) {
        this.maxMarksAlloted = maxMarksAlloted;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "name : " + this.getName() + " , description : " + this.getDescription() + " , max marks : " + this.getMaxMarksAlloted();
    }
}
