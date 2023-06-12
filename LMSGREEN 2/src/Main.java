import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
public class Main {
    static int count = 0;
    static double[][] bisec = new double[14][2];
    static double[][] hord = new double[5][2];
    static double[][] newton = new double[3][2];
    static double[][] comb = new double[2][2];
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
        double left = 1.54;
        double right = 3.17;
        double epsilon = 0.0001; // Точность

        System.out.println("Bisection metod: ");
        double result = bisectionMethod(left, right, epsilon);
        DecimalFormat decimalFormat = new DecimalFormat("#.#####");
        System.out.println("Результат: " + decimalFormat.format(result));
        System.out.println("\nHord metod: ");
        result = chordMethod(left, right, epsilon);
        System.out.println("Результат: " + decimalFormat.format(result));
        System.out.println("\nNewton metod: ");
        result = newtonMethod(left, right, epsilon);
        System.out.println("Результат: " + decimalFormat.format(result));
        System.out.println("\nCombined metod: ");
        result = combinedMethod(left, right, epsilon);
        System.out.println("Результат: " + decimalFormat.format(result));
    }

    private static double function(double x) {
        return x * x - 5 * Math.sin(x);
    }
    private static double derivative(double x) {
        return 2 * x - 5 * Math.cos(x);
    }

    private static double combinedMethod(double left, double right, double epsilon) {
        DecimalFormat decimalFormat = new DecimalFormat("#.#####");
        double x0 = (left + right) / 2;
        double fX0 = function(x0);
        double xNext;
        count=0;
        while (Math.abs(fX0) > epsilon) {
            double fPrimeX0 = derivative(x0);
            double x1 = x0 - fX0 / fPrimeX0;
            double fX1 = function(x1);
            xNext = x1 - (fX1 * (x1 - x0)) / (fX1 - fX0);
            double fXNext = function(xNext);
            comb[count][0] = xNext;
            comb[count][1] = fXNext;
            count++;
            System.out.println("x = " + decimalFormat.format(xNext) + ", y = " + decimalFormat.format(fXNext));

            x0 = xNext;
            fX0 = fXNext;
        }

        return x0;
    }
    private static double newtonMethod(double left, double right, double epsilon) {
        DecimalFormat decimalFormat = new DecimalFormat("#.#####");
        double x0 = (left + right) / 2;
        double fX0 = function(x0);
        double xNext;
        count = 0;
        while (Math.abs(fX0) > epsilon) {
            double fPrimeX0 = derivative(x0);
            xNext = x0 - fX0 / fPrimeX0;
            double fXNext = function(xNext);
            System.out.println("x = " + decimalFormat.format(xNext) + ", y = " + decimalFormat.format(fXNext));
            newton[count][0] = xNext;
            newton[count][1] = fXNext;
            count++;
            x0 = xNext;
            fX0 = fXNext;
        }

        return x0;
    }
    private static double chordMethod(double left, double right, double epsilon) {
        DecimalFormat decimalFormat = new DecimalFormat("#.#####");
        double x0 = left;
        double x1 = right;
        double fX0 = function(x0);
        double fX1 = function(x1);
        double xNext;
        count = 0;
        while (Math.abs(fX1) > epsilon) {
            xNext = x1 - fX1 * (x1 - x0) / (fX1 - fX0);
            double fXNext = function(xNext);
            System.out.println("x = " + decimalFormat.format(xNext) + ", y = " + decimalFormat.format(fXNext));
            hord[count][0] = xNext;
            hord[count][1] = fXNext;
            count++;
            x0 = x1;
            fX0 = fX1;
            x1 = xNext;
            fX1 = fXNext;
        }

        return x1;
    }
    private static double bisectionMethod(double left, double right, double epsilon) {
        DecimalFormat decimalFormat = new DecimalFormat("#.#####");
        double middle = (left + right) / 2;
        double fLeft = function(left);
        double fRight = function(right);
        double fMiddle = function(middle);

        if (Math.abs(fMiddle) < epsilon) {
            // Достигнута достаточная точность, возвращаем найденное значение
            return middle;
        } else if (fLeft * fMiddle < 0) {
            // Меняем правую границу на середину интервала
            System.out.println("x = " + decimalFormat.format(middle) + ", y = " + decimalFormat.format(fMiddle));
            bisec[count][0] = middle;
            bisec[count][1] = fMiddle;
            count++;
            return bisectionMethod(left, middle, epsilon);
        } else {
            // Меняем левую границу на середину интервала
            System.out.println("x = " + decimalFormat.format(middle) + ", y = " + decimalFormat.format(fMiddle));
            bisec[count][0] = middle;
            bisec[count][1] = fMiddle;
            count++;
            return bisectionMethod(middle, right, epsilon);
        }
    }
    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Function Graph with Points");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GraphPanel graphPanel = new GraphPanel();
        graphPanel.full();
        frame.getContentPane().add(graphPanel);

        frame.pack();
        frame.setVisible(true);
    }

    private static class GraphPanel extends JPanel {
        private static final int WIDTH = 400;
        private static final int HEIGHT = 400;

        private double minX = 1.57;
        private double maxX = 3.14;
        private double minY = -10.0;
        private double maxY = 10.0;
        private double stepSize = 0.1;

        private double[][] points = new double[32][2];
        int counter = 0;

        private void full() {
            for (double i = minX; i <= maxX; i += 0.05) {
                points[counter][0] = i;
                points[counter][1] = function(i);
                counter++;
            }
        }
        private double function(double x) {
            return x * x - 5 * Math.sin(x);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Draw x-axis and y-axis
            g2d.setColor(Color.BLACK);
            g2d.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2); // x-axis
            g2d.drawLine(getWidth() / 2, 0, getWidth() / 2, getHeight()); // y-axis



            g2d.setColor(Color.BLUE);
            int space = 0;
            for (double[] bisec : bisec) {
                double x = bisec[0];
                double y = bisec[1];

                int pixelX = (int) (200+x);
                int pixelY = (int) ((maxY - y) * (getHeight() / (maxY - minY)));
                space += 1;
                g2d.fillOval(pixelX + space, pixelY - 3, 5, 5); // Увеличиваем размер точек на 6 пикселей
            }
            space = 0;
            g2d.setColor(Color.GREEN);
            for (double[] hord : hord) {
                double x = hord[0];
                double y = hord[1];

                int pixelX = (int) (200+x);
                int pixelY = (int) ((maxY - y) * (getHeight() / (maxY - minY)));
                space += 1;
                g2d.fillOval(pixelX + space, pixelY - 3, 5, 5); // Увеличиваем размер точек на 6 пикселей
            }
            space = 0;
            g2d.setColor(Color.yellow);
            for (double[] newton : newton) {
                double x = newton[0];
                double y = newton[1];

                int pixelX = (int) (200+x);
                int pixelY = (int) ((maxY - y) * (getHeight() / (maxY - minY)));
                space += 1;
                g2d.fillOval(pixelX + space, pixelY - 3, 5, 5); // Увеличиваем размер точек на 6 пикселей
            }
            space = 0;
            g2d.setColor(Color.pink);
            for (double[] comb : comb) {
                double x = comb[0];
                double y = comb[1];

                int pixelX = (int) (200+x);
                int pixelY = (int) ((maxY - y) * (getHeight() / (maxY - minY)));
                space += 1;
                g2d.fillOval(pixelX + space, pixelY - 3, 5, 5); // Увеличиваем размер точек на 6 пикселей
            }



            // Draw points
            g2d.setColor(Color.RED);
            space = 0;
            for (double[] point : points) {
                double x = point[0];
                double y = point[1];

                int pixelX = (int) (200+x);
                int pixelY = (int) ((maxY - y) * (getHeight() / (maxY - minY)));
                space += 1;
                g2d.fillOval(pixelX + space, pixelY - 3, 5, 5); // Увеличиваем размер точек на 6 пикселей
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(WIDTH, HEIGHT);
        }
    }
}
