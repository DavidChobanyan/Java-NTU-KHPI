
abstract class AbstractEquation {
    public abstract double f(double x);

    double FMin(double start, double finish, double step) {
        double y = start;
        for(double a = start; a < finish; a+=step){
            if(f(y) > f(a)) {
                y = a;
            }
        }
        return f(y);
    }
}
class SpecificEquationFirst extends AbstractEquation {
    @Override
    public double f (double x) {
        return Math.pow(x, 2);
    }
}

class SpecificEquationSecond extends AbstractEquation {

    @Override
    public double f(double x) {
        return Math.pow(x, 2) + 2*x +5;
    }
}

interface FunctionToSolve {
    double f(double x);
}
class IMin{
    static double FMin(double start, double finish, double step, FunctionToSolve func) {
        double y = start;
        for(double a = start; a < finish; a+=step){
            if(func.f(y) > func.f(a)) {
                y = a;
            }
        }
        return func.f(y);
    }
}
class InterfaceEquationFirst implements FunctionToSolve {
    @Override
    public double f(double x) {
        return Math.pow(x, 2);
    }
}
class InterfaceEquationSecond implements FunctionToSolve {
    @Override
    public double f(double x) {
        return Math.pow(x, 2) + 2*x +5;
    }
}
class SolveUsingReference {
    public static double f1(double x) {
        return Math.pow(x, 2);
    }
    public static double f2(double x) {
        return Math.pow(x, 2) + 2*x +5;
    }

}

public class Main {
    public static void main(String[] args) {
        SpecificEquationFirst test = new SpecificEquationFirst();
        SpecificEquationSecond test2 = new SpecificEquationSecond();
        System.out.println("Solve using Abstract and derivative classes");
        System.out.println(test.FMin(-6.2, 13.2, 0.56));
        System.out.println(test2.FMin(-6.2, 13.2, 0.56));
        System.out.println("\nSolve using Interface and class");
        System.out.println(IMin.FMin(-6.2, 13.2, 0.56, new InterfaceEquationFirst()));
        System.out.println(IMin.FMin(-6.2, 13.2, 0.56, new InterfaceEquationSecond()));
        System.out.println("\nSolve using Interface and anonymous class");
        System.out.println(IMin.FMin(-6.2, 13.2, 0.56, new FunctionToSolve() {
            @Override
            public double f(double x) {
                return Math.pow(x, 2);
            }
        }));
        System.out.println(IMin.FMin(-6.2, 13.2, 0.56, new FunctionToSolve() {
            @Override
            public double f(double x) {
                return Math.pow(x, 2) + 2*x +5;
            }
        }));
        System.out.println("\nSolve using lambda");
        System.out.println(IMin.FMin(-6.2, 13.2, 0.56, x -> Math.pow(x, 2)));
        System.out.println(IMin.FMin(-6.2, 13.2, 0.56, x -> Math.pow(x, 2) + 2*x +5));
        System.out.println("\nSolve using reference");
        System.out.println(IMin.FMin(-6.2, 13.2, 0.56, SolveUsingReference::f1));
        System.out.println(IMin.FMin(-6.2, 13.2, 0.56, SolveUsingReference::f2));
    }
}