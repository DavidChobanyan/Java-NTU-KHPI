import java.io.*;

public class GroupDeserialization {

    public static void main(String[] args) throws ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("Group.dat"))) {
            Group group = (Group) in.readObject();
            for (Student c : group.getStudents()) {
                System.out.println(c.getName() + " " + c.getLast() + " " + c.getYear());
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        };
    }

}