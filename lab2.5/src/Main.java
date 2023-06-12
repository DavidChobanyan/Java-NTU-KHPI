class Circle implements Comparable<Circle> {
    private double Radius;

    public Circle(double Radius) {
        this.Radius = Radius;
    }

    @Override
    public int compareTo(Circle circle) {
        return -Double.compare(this.Radius, circle.Radius);
    }

    @Override
    public String toString() {
        return "" + Radius;
    }

}

public class Main {
    public static void main(String[] args) {
        Circle[] a = {new Circle(5),
                new Circle(56),
                new Circle(1),
                new Circle(4)};
        System.out.println("Circles Array");
        for(Circle circle : a){
            System.out.print("[" + circle + "]");
        }
        System.out.println("\nSorted Circles Array");
        java.util.Arrays.sort(a); 
        for(Circle circle : a){
            System.out.print("[" + circle + "]");
        }   
    }
}