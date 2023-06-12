import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Student implements Serializable {
    private static final long serialVersionUID = -6755942443306500892L;
    private String name;
    private String lastname;
    private int year_of_birth;

    public Student(String name, String lastname, int year_of_birth) {
        this.name = name;
        this.lastname = lastname;
        this.year_of_birth = year_of_birth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast() {
        return lastname;
    }

    public void setLast(String lastname) {
        this.lastname = lastname;
    }

    public int getYear() {
        return year_of_birth;
    }

    public void setYear(int year_of_birth) {
        this.year_of_birth = year_of_birth;
    }

}

public class StudentSerialization {

    public static void main(String[] args) {
        Student c = new Student("David", "Chobanyan", 2003);

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Student.dat"))) {
            out.writeObject(c);
        }
        catch (IOException e) {
            e.printStackTrace();
        };
    }
}
