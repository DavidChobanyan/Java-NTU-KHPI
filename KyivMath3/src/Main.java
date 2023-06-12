interface FunctionToSolve {
    double f(double x);
}

interface FunctionToSolve2 {
    double f(double x);
    double f2(double x);
}

public class Main {
    public static double bisection(double a, double b, FunctionToSolve function, double e){
        double x;
        while(true) {
            x = (a+b) / 2;
            if (function.f(x) * function.f(a)<0){
                b = x;
            }
            else{
                a = x;
            }
            if (Math.abs(b - a) < e && function.f(x) < e) {
                return x;
            }
        }
    }
    public static double hord(double a, double b, FunctionToSolve function, double e){
        double x = 0;
        double xx;
        while(true){
            xx = x;
            x = (a*function.f(b)-b*function.f(a))/(function.f(b)-function.f(a));
            if(function.f(x) * function.f(a)<0)
                b = x;
            else
                a=x;
            if(Math.abs(x-xx)<e&&function.f(x)<e) {
                return x;
            }
        }
    }
    public static double Newton(double x0, FunctionToSolve2 function, double e){
        double x = x0 - function.f(x0)/function.f2(x0);
        while(true){
            x0=x;
            x = x0 - function.f(x0)/function.f2(x0);
            if(Math.abs(x-x0)<e&&function.f(x)<e) {
                return x;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("bisection:");
        System.out.printf("%.2f\n", bisection(0, 1.76, x -> 9*Math.pow(x, 5)+3*Math.pow(x,2)-2*x-1, 0.001));
        System.out.printf("%.2f\n",bisection(-0.5, 0, x -> 9*Math.pow(x, 5)+3*Math.pow(x,2)-2*x-1, 0.001));
        System.out.printf("%.2f\n",bisection(-1.7, -0.5, x -> 9*Math.pow(x, 5)+3*Math.pow(x,2)-2*x-1, 0.001));
        System.out.println("hord:");
        System.out.printf("%.2f\n",hord(0, 1.76, x -> 9*Math.pow(x, 5)+3*Math.pow(x,2)-2*x-1, 0.001));
        System.out.printf("%.2f\n",hord(-0.5, 0, x -> 9*Math.pow(x, 5)+3*Math.pow(x,2)-2*x-1, 0.001));
        System.out.printf("%.2f\n",hord(-1.7, -0.5, x -> 9*Math.pow(x, 5)+3*Math.pow(x,2)-2*x-1, 0.001));
        System.out.println("Newton:");
        System.out.printf("%.2f\n", Newton(1.76, new FunctionToSolve2() {
            @Override
            public double f(double x){
                return 9*Math.pow(x, 5)+3*Math.pow(x,2)-2*x-1;
            }
            @Override
            public double f2(double x){
                return 45*Math.pow(x, 4)+6*x-2;
            }
        }, 0.001));
        System.out.printf("%.2f\n", Newton(-0.5, new FunctionToSolve2() {
            @Override
            public double f(double x){
                return 9*Math.pow(x, 5)+3*Math.pow(x,2)-2*x-1;
            }
            @Override
            public double f2(double x){
                return 45*Math.pow(x, 4)+6*x-2;
            }
        }, 0.001));
        System.out.printf("%.2f\n", Newton(-1.7, new FunctionToSolve2() {
            @Override
            public double f(double x){
                return 9*Math.pow(x, 5)+3*Math.pow(x,2)-2*x-1;
            }
            @Override
            public double f2(double x){
                return 45*Math.pow(x, 4)+6*x-2;
            }
        }, 0.001));
    }
}