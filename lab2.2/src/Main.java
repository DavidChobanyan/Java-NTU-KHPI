class human{
    String name;
    String Last_name;
    String gender;
    int age;
    public human(String name, String Last_name, String gender, int age) {
        this.name = name;
        this.Last_name = Last_name;
        this.gender = gender;
        this.age = age;
    }
    public String toString() {
        return name + " " + Last_name + " " + gender + " " + age;
    }
}
class Citizen extends human{
    String country;
    String origin;
    long id;
    public Citizen(String name, String Last_name, String gender, int age, int id, String country, String origin) {
        super(name, Last_name, gender, age);
        this.country = country;
        this.origin = origin;
        this.id = id;
    }
    public String toString() {
        return name + " " + Last_name + " " + gender +
                " " + age + " " + country + " " + origin + " " + id;
    }
}
class Student extends Citizen{
    String University;
    String Specialization;
    int year_of_study;
    public Student(String name, String Last_name, String gender, int age, int id,
                   String country, String origin, String University, String Specialization, int year_of_study){
        super(name, Last_name, gender, age, id, country, origin);
        this.University = University;
        this.Specialization = Specialization;
        this.year_of_study = year_of_study;
    }
    @Override
    public String toString() {
        return name + " " + Last_name + " " + gender +
                " " + age + " " + country + " " + origin +
                " " + id + " "+ University + " " + Specialization + " " + year_of_study;
    }
}

class employee extends Student{
    String company;
    String post;
    long salary;
    public employee(String name, String Last_name, String gender, int age, int id,
                    String country, String origin, String University, String Specialization, int year_of_study,
                    String company, String post, long salary){
        super(name, Last_name, gender, age, id, country, origin, University, Specialization, year_of_study);
        this.company = company;
        this.post = post;
        this.salary = salary;
    }

    public String toString() {
        return name + " " + Last_name + " " + gender +
                " " + age + " " + country + " " + origin +
                " " + id + " " + University + " " + Specialization + " " + year_of_study + " " + company + " " + post + " " + salary;
    }
}

public class Main {
    public static void main(String[] args) {
        human[] a = {
                new human("Name", "Last", "M", 18),
                new Citizen("Name", "Last", "M", 18, 1, "Ukraine", "Origin"),
                new Student("Name", "Last",
                        "M", 18, 1, "Ukraine", "Origin", "KHPI", "PROGRAMMER", 2),
                new employee("Name", "Last",
                        "M", 18, 1, "Ukraine", "Origin", "KHPI", "PROGRAMMER", 2,
                            "IT", "Programmer", 10000)};
            for (human human : a) {
                System.out.println(human);
        }

    }
}