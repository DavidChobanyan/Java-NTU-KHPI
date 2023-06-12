public class Main {
    static double round(double x){
        x = Math.round(x * 100.0) / 100.0;
        return x;
    }
    static void initiation(double[][] matrix){
        matrix[0][0] = 2.2;
        matrix[0][1] = -0.15;
        matrix[0][2] = -1.63;
        matrix[0][3] = -0.25;
        matrix[1][0] = -3;
        matrix[1][1] = 8;
        matrix[1][2] = 2;
        matrix[1][3] = 1;
        matrix[2][0] = -2.25;
        matrix[2][1] = 0;
        matrix[2][2] = 5.12;
        matrix[2][3] = 1.81;
        matrix[3][0] = 3;
        matrix[3][1] = -1;
        matrix[3][2] = -3.38;
        matrix[3][3] = 10.56;
        matrix[0][4] = 17;
        matrix[1][4] = 1.2;
        matrix[2][4] = 13.99;
        matrix[3][4] = 28.96;
    }
    public static void main(String[] args) {
        double[][] matrix = new double[4][5];
        initiation(matrix);

        for(int a = 0; a < 4; a++){
            for (int b =0; b < 5; b++){
                System.out.print("[" + matrix[a][b] + "]");
            }
            System.out.println();
        }

        for(int a = 0; a < 4; a++)
            System.out.println(matrix[a][4]);

        double first = matrix[0][4]/matrix[0][0];
        double second = matrix[1][4]/matrix[1][1];
        double third = matrix[2][4]/matrix[2][2];
        double fourth = matrix[3][4]/matrix[3][3];
        System.out.printf("%.2f : %.2f : %.2f : %.2f\n", first, second , third,fourth);
        double x1 = 0;
        double x2 = 0;
        double x3 = 0;
        double x4 = 0;

        for (int a = 0; true; a++){
            double x11 = first - x2*(matrix[0][1]/matrix[0][0]) - x3*(matrix[0][2]/matrix[0][0]) - x4*(matrix[0][3]/matrix[0][0]);
            double x22 = second - x1*(matrix[1][0]/matrix[1][1]) - x3*(matrix[1][2]/matrix[1][1]) - x4*(matrix[1][3]/matrix[1][1]);
            double x33 = third - x1*(matrix[2][0]/matrix[2][2]) - x2*(matrix[2][1]/matrix[2][2]) - x4*(matrix[2][3]/matrix[2][2]);
            double x44 = fourth - x1*(matrix[3][0]/matrix[3][3]) - x2*(matrix[3][1]/matrix[3][3]) - x3*(matrix[3][2]/matrix[3][3]);
            boolean fs = (x11-x1)/x11<0.00001;
            boolean ss = (x22-x2)/x22<0.00001;
            boolean ts = (x33-x3)/x33/x11<0.00001;
            boolean fos = (x44-x4)/x44<0.00001;
            x1 = x11;
            x2 = x22;
            x3 = x33;
            x4 = x44;
            System.out.printf("%d: [%f][%f][%f][%f]\n", a, x1, x2, x3, x4);
            if(fs&&ss&&ts&&fos) {
                for (int i = 0; i < 4; i++) {
                    double buff = 0;
                    buff += matrix[i][0] * x11;
                    buff += matrix[i][1] * x22;
                    buff += matrix[i][2] * x33;
                    buff += matrix[i][3] * x44;
                    System.out.printf("[%.6f]", round(matrix[i][4] - buff));

                }
                break;
            }else {
                for (int i = 0; i < 4; i++) {
                    double buff = 0;
                    buff += matrix[i][0] * x11;
                    buff += matrix[i][1] * x22;
                    buff += matrix[i][2] * x33;
                    buff += matrix[i][3] * x44;
                    System.out.printf("[%.6f]", matrix[i][4] - buff);

                }
            }
            System.out.println('\n');
        }
        System.out.println('\n');
    }
}