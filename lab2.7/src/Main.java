interface Integrable {
    double f(double x);
    default double integral(double a, double b, double c){
        double result = 0;
        for(double i = a; i <= b-c; i+=c){
            result += f(i)*c;
        }

        return result;
    }
}

class Integral implements Integrable{
    @Override
    public double f(double x){
        return 1/Math.log(x);
    }
}

class newIntegral implements Integrable{
    @Override
    public double f(double x){
        return 1/Math.log(x);
    }
    @Override
    public double integral(double start, double end, double eps){
        double sum = 0;
        double sumall = 0;

        for(double i = start+eps; i < end; i+=eps){
                sumall += f(i);
        }

        return eps*(sumall + (f(start)+f(end))/2);
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Метод Прямокутників: " + new Integral().integral(2, 5, 0.6));
        System.out.println("Метод Трапеції: " + new newIntegral().integral(2, 5, 0.6));

    }
}