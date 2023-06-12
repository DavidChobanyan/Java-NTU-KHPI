import java.util.Comparator;

class Triangle implements Comparator<Triangle> {
    private double a;
    private double b;
    private double c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double S() {
        return Math.sqrt((a + b + c) * (b + c - a) * (a + c - b) * (a + b - c)) / 4;
    }

    @Override
    public String toString() {
        return "[" + a + ", " + b + ", " + c + "]" + " = " + S();
    }

    @Override
    public int compare(Triangle tr1, Triangle tr2) {
        return -Double.compare(tr1.S(), tr2.S());
    }
}

public class Main {
    public static void main(String[] args) {
        Triangle[] test = {new Triangle(3, 4, 5),
                new Triangle(7, 3, 6),
                new Triangle(10, 8, 12)};

        System.out.println("Triagles Array");

        for (Triangle Triangle : test) {
            System.out.println(Triangle);
        }

        java.util.Arrays.sort(test);

        System.out.println("\nSorted Triagles Array");

        for (Triangle Triangle : test) {
            System.out.println(Triangle);
        }
    }
}