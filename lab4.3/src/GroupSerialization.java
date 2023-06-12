import java.io.*;
class Group implements Serializable {
    private static final long serialVersionUID = -3861862668546826739L;
    private String name;
    private Student[] students;

    public Group(String name, Student... countries) {
        this.name = name;
        this.students = countries;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

}

public class GroupSerialization {

    public static void main(String[] args) {
        Group c = new Group("Group name",
                new Student("nametest", "lastnametest", 2000),
                new Student("nametest2", "lastnametest2", 1999),
                new Student("nametest3", "lastnametest2", 2001)
        );
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Group.dat"))) {
            out.writeObject(c);
        }
        catch (IOException e) {
            e.printStackTrace();
        };

    }
}
