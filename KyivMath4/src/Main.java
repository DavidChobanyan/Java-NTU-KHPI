import java.util.Scanner;

public class Main {

    static double b[][] = new double[5][5];
    static double a[] = new double[5];

    double f1(double x){
        return Math.sin(2*x)+Math.cbrt(x*2);
    }
    double f2(double x){
        return (Math.cbrt(2*x)/3*x)+2*Math.cos(2*x);
    }
    double f3(double x){
        return ((2*Math.cbrt(2*x))/9*Math.pow(x, 2))-4*Math.sin(2*x);
    }
    void spline() {
        for(int i = 0; i < 5; i++){
            double ax = f1(a[i]);
            double bx = f2(a[i]);
            double cx = f3(a[i]);

        }
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        a[0] = 2;
        b[0][0] = 1.24;
        a[1] = 4;
        b[1][0] = 3.5;
        a[2] = 6;
        b[2][0] = 2.34;
        a[3] = 8;
        b[3][0] = 2.88;
        a[4] = 10;
        b[4][0] = 4.33;

        for (int i = 1; i < 5; i++) {
            for (int j = i; j < 5; j++) {
                if (i == 1) {
                    b[j][i] = (b[j][0] - b[j - 1][0]) / (a[j] - a[j - 1]);
                } else {
                    b[j][i] = (b[j][i - 1] - b[j - 1][i - 1]) / (a[j] - a[j - i]);
                }
            }

        }

        System.out.print("Newton:\nN (x) ="+b[0][0] + "+");
        for (int i = 1; i < 5; i++) {
            System.out.printf("%.3f *", Math.abs(b[i][i]));
            for (int j = 0; j < i; j++) {
                if (a[j] > 0) {
                    System.out.printf("(x-%.0f)", + a[j]);
                } else {
                    System.out.printf("(x+%.0f)", Math.abs(a[j]));
                }
            }
            if (i != 4) if (b[i + 1][i + 1] > 0) System.out.print("+");
            else System.out.print("-");
        }
        System.out.println();

        System.out.println("x:");

        double x = sc.nextDouble();
        double y = b[0][0];

        for (int i = 1; i < 5; i++) {

            double temp=1;
            for (int j = 0; j < i; j++) {
                temp*=(x-a[j]);
            }
            temp*=b[i][i];
            y+=temp;
        }
        System.out.printf("Result: %.3f", y);
    }
}