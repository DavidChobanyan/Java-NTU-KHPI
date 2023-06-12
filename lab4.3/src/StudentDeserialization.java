import java.io.*;

public class StudentDeserialization {

    public static void main(String[] args) throws ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("Student.dat"))) {
            Student c = (Student) in.readObject();
                System.out.println(c.getName() + " " + c.getLast() + " " + c.getYear());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}