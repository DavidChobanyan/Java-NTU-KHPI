class CubicSpline {
    
    private final double[] y;
    private final double[] x;
    private final double[] arg;
    public CubicSpline(double[] x, double[] y){
        this.x = new double[x.length];
        this.y = new double[x.length];
        this.arg = new double[x.length];
        for(int i = 0; i<x.length; i++){
            this.x[i]=x[i];
            this.y[i]=y[i];
        }
        this.calc();
    }

    public void calc(){
        double	a,q,num2,num;
        double[] arr = new double[x.length];

        arg[0]=arr[0]=0.0;
        for(int i = 1; i<=x.length -2; i++){
            num2=(this.x[i]-this.x[i-1])/(this.x[i+1]-this.x[i-1]);
            a=num2*this.arg[i-1]+2.0;
            this.arg[i]=(num2-1.0)/a;
            arr[i]=(this.y[i+1]-this.y[i])/(this.x[i+1]-this.x[i]) - (this.y[i]-this.y[i-1])/(this.x[i]-this.x[i-1]);
            arr[i]=(6.0*arr[i]/(this.x[i+1]-this.x[i-1])-num2*arr[i-1])/a;
        }

        q=num=0.0;
        this.arg[x.length -1]=(num-q*arr[x.length -2])/(q*this.arg[x.length -2]+1.0);
        for(int k = x.length -2; k>=0; k--){
            this.arg[k]=this.arg[k]*this.arg[k+1]+arr[k];
        }
    }

    public void interpolate(double xx){

        double h,b,a, yy;
        int k;
        int num=0;
        int num2=x.length -1;
        while (num2-num > 1){
            k=(num2+num) >> 1;
            if(this.x[k] > xx)
                num2=k;
            else
                num=k;
        }
        h=this.x[num2]-this.x[num];
        a=(this.x[num2]-xx)/h;
        b=(xx-this.x[num])/h;
        yy=a*this.y[num]+b*this.y[num2]+((a*a*a-a)*this.arg[num]+(b*b*b-b)*this.arg[num2])*(h*h)/6.0;
        System.out.print("x=" + xx + " y="+yy + "\n");
    }
}

public class Main {
    static double[] b = new double[5];
    static double[] a = new double[5];

    public static void main(String[] args) {
        b=new double[]{2.01, 2.17, 4.027,2.551, 3.521};
        a=new double[]{3, 5, 7,9, 11};
        printPx();
        System.out.println();
        System.out.printf(3 + " = %.3f;  ", (Px(3)));
        System.out.printf(3.4 + " = %.3f; ", Px(3.4));
        System.out.printf(3.8  + " = %.3f; ", Px(3.8));
        System.out.printf(4.2 + " = %.3f; ", Px(4.2));
        System.out.printf(4.6 + " = %.3f; ", Px(4.6));
        System.out.printf(5 + " = %.3f; \n", Px(5));
        System.out.printf(5.4 + " = %.3f; ", Px(5.4));
        System.out.printf(5.8 + " = %.3f; ", Px(5.8));
        System.out.printf(6.2 + " = %.3f; ", Px(6.2));
        System.out.printf(6.6 + " = %.3f; ", Px(6.6));
        System.out.printf(7 + " = %.3f; \n", (Px(7)));
        System.out.printf(7.4 + " = %.3f; ", Px(7.4));
        System.out.printf(7.8 + " = %.3f; ", Px(7.8));
        System.out.printf(8.2 + " = %.3f; ", Px(8.2));
        System.out.printf(8.6 + " = %.3f; ", Px(8.6));
        System.out.printf(9 + " = %.3f; \n", (Px(9)));
        System.out.printf(9.4 + " = %.3f; ", Px(9.4));
        System.out.printf(9.8 + " = %.3f; ", Px(9.8));
        System.out.printf(10.2 + " = %.3f; ", Px(10.2));
        System.out.printf(10.6 + " = %.3f; ", Px(10.6));
        System.out.printf(11 + " = %.3f; \n", (Px(11)));
        System.out.println("\ne:");
        System.out.printf(2 + " = %.3f; ", (Px(3)-function(3))<0.001? 0:(Px(2)-function(2)));
        System.out.printf(3.4 + " = %.3f; ", Px(3.4)-function(3.4));
        System.out.printf(3.8  + " = %.3f; ", Px(3.8)-function(3.8));
        System.out.printf(4.2 + " = %.3f; ", Px(4.2)-function(4.2));
        System.out.printf(4.6 + " = %.3f; ", Px(4.6)-function(4.6));
        System.out.printf(5 + " = %.3f; \n", (Px(5)-function(5))<0.001? 0:(Px(5)-function(5)));
        System.out.printf(5.4 + " = %.3f; ", Px(5.4)-function(5.4));
        System.out.printf(5.8 + " = %.3f; ", Px(5.8)-function(5.8));
        System.out.printf(6.2 + " = %.3f; ", Px(6.2)-function(6.2));
        System.out.printf(6.6 + " = %.3f; ", Px(6.6)-function(6.6));
        System.out.printf(7 + " = %.3f;\n", (Px(7)-function(7))<0.001? 0:(Px(7)-function(7)));
        System.out.printf(7.4 + " = %.3f; ", Px(7.4)-function(7.4));
        System.out.printf(7.8 + " = %.3f; ", Px(7.8)-function(7.8));
        System.out.printf(8.2 + " = %.3f; ", Px(8.2)-function(8.2));
        System.out.printf(8.6 + " = %.3f; ", Px(8.6)-function(8.6));
        System.out.printf(9 + " = %.3f; \n", (Px(9)-function(9))<0.001? 0:(Px(9)-function(9)));
        System.out.printf(9.4 + " = %.3f; ", Px(9.4)-function(9.4));
        System.out.printf(9.8 + " = %.3f; ", Px(9.8)-function(9.8));
        System.out.printf(10.2 + " = %.3f; ", Px(10.2)-function(10.2));
        System.out.printf(10.6 + " = %.3f; ", Px(10.6)-function(10.6));
        System.out.printf(11 + " = %.3f; \n", (Px(11)-function(11))<0.001? 0:(Px(11)-function(11)));
        System.out.println("\nInterpolation:");
        CubicSpline test = new CubicSpline(new double[]{3, 5, 7, 9, 11}, new double[]{2.01, 2.17, 4.027, 2.551, 3.521});
        test.interpolate(3);
        test.interpolate(3.4);
        test.interpolate(3.8);
        test.interpolate(4.2);
        test.interpolate(4.6);
        test.interpolate(5);
        test.interpolate(5.4);
        test.interpolate(5.8);
        test.interpolate(6.2);
        test.interpolate(6.6);
        test.interpolate(7);
        test.interpolate(7.4);
        test.interpolate(7.8);
        test.interpolate(8.2);
        test.interpolate(8.6);
        test.interpolate(9);
        test.interpolate(9.4);
        test.interpolate(9.8);
        test.interpolate(10.2);
        test.interpolate(10.6);
        test.interpolate(11);
    }
    static double function(double x){
        return Math.sin(2*x)+Math.cbrt(x*4);
    }
    static double f11(){
        return (b[1]-b[0])/(a[1]-a[0]);
    }
    static double f12(){
        return (b[2]-b[1])/(a[2]-a[1]);
    }
    static double f13(){
        return (b[3]-b[2])/(a[2]-a[1]);
    }
    static double f14(){
        return (b[4]-b[3])/(a[4]-a[3]);
    }
    static double f21(){
        return (f12()-f11())/(a[2]-a[0]);
    }
    static double f22(){
        return (f13()-f12())/(a[3]-a[1]);
    }
    static double f23(){
        return (f14()-f13())/(a[4]-a[2]);
    }
    static double f31(){
        return (f22()-f21())/(a[3]-a[0]);
    }
    static double f32(){
        return (f23()-f22())/(a[4]-a[1]);
    }
    static double f41(){
        return (f32()-f31())/(a[4]-a[0]);
    }
    static double Px(double x){
        return b[0] + f11()*(x-a[0])+f21()*(x-a[0])*(x-a[1])+
                f31()*(x-a[0])*(x-a[1])*(x-a[2])+
                f41()*(x-a[0])*(x-a[1])*(x-a[2])*(x-a[3]);
    }
    static void printPx(){
        System.out.printf("Pn(x)=%.3f+%.3f*(x-%.0f)+%.3f*(x-%.0f)*(x-%.0f)%.3f*(x-%.0f)*(x-%.0f)*(x-%.0f)+"
                + "%.3f*(x-%.0f)*(x-%.0f)*(x-%.0f)*(x-%.0f)", b[0], f11(), a[0], f21(), a[0], a[1], f31(), a[0], a[1], a[2], f41(), a[0], a[1], a[2], a[3]);
    }
}