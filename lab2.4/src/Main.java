
abstract class AbstractArrayOfPoints {
    public abstract void setPoint(int i, double x, double y);

    public abstract double getX(int i);

    public abstract double getY(int i);

    public abstract int count();

    public abstract void addPoint(double x, double y);

    public abstract void removeLast();

    public void sortByX() {
        boolean mustSort;
        do {
            mustSort = false;
            for (int i = 0; i < count() - 1; i++) {
                if (getX(i) > getX(i + 1)) {
                    double x = getX(i);
                    double y = getY(i);
                    setPoint(i, getX(i + 1), getY(i + 1));
                    setPoint(i + 1, x, y);
                    mustSort = true;
                }
            }
        }
        while (mustSort);
    }

    public void sortByY() {
        boolean mustSort;
        do {
            mustSort = false;
            for (int i = 0; i < count() - 1; i++) {
                if (getY(i) > getY(i + 1)) {
                    double x = getX(i);
                    double y = getY(i);
                    setPoint(i, getX(i + 1), getY(i + 1));
                    setPoint(i + 1, x, y);
                    mustSort = true;
                }
            }
        }
        while (mustSort);
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < count(); i++) {
            s += "x = " + getX(i) + " \ty = " + getY(i) + "\n";
        }
        return s + "\n";
    }
}
class DoubleArrayOfPointObjects extends AbstractArrayOfPoints {
    private double[][] p = { };

    @Override
    public void setPoint(int i, double x, double y) {
        if (i < count()) {
            p[i][0] = x;
            p[i][1] = y;
        }
    }

    @Override
    public double getX(int i) {
        return p[i][0];
    }

    @Override
    public double getY(int i) {
        return p[i][1];
    }

    @Override
    public int count() {
        return p.length;
    }

    @Override
    public void addPoint(double x, double y) {
        double[][] p1 = new double[p.length + 1][2];
        System.arraycopy(p, 0, p1, 0, p.length);
        p1[p.length][0] = x;
        p1[p.length][1] = y;
        p = p1;
    }

    @Override
    public void removeLast() {
        if (p.length == 0) {
            return;
        }
        double[][] p1 = new double[p.length - 1][2];
        System.arraycopy(p, 0, p1, 0, p1.length);
        p = p1;
    }

}

class ArrayOfPointObjects extends AbstractArrayOfPoints {
    private double[] p = { };


    @Override
    public void setPoint(int i, double x, double y) {
        if (i < count()) {
            if(i % 2 == 0) {
                p[i] = x;
                p[i + 1] = y;
            }else{
                p[i] = y;
                p[i - 1] = x;
            }
        }
    }

    public double getX(int i) {
        if(i%2==0) {
            return p[i];
        }else{
            return p[i-1];
        }
    }

    @Override
    public double getY(int i) {
        if(i%2==0) {
            return p[i+1];
        }else{
            return p[i];
        }
    }

    @Override
    public int count() {
        return p.length;
    }

    @Override
    public void addPoint(double x, double y) {
        double[] p1 = new double[p.length + 2];
        System.arraycopy(p, 0, p1, 0, p.length);
        p1[p.length] = x;
        p1[p.length+1] = y;
        p = p1;
    }

    @Override
    public void removeLast() {
        if (p.length == 0) {
            return;
        }
        double[] p1 = new double[p.length - 2];
        System.arraycopy(p, 0, p1, 0, p1.length);
        p = p1;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < count(); i+=2) {
            s += "x = " + getX(i) + " \ty = " + getY(i) + "\n";
        }
        return s + "\n";
    }
}

public class Main {
    public static void main(String[] args) {
        DoubleArrayOfPointObjects test = new DoubleArrayOfPointObjects();
        ArrayOfPointObjects test2 = new ArrayOfPointObjects();
        test.addPoint(13, 7);
        test.addPoint(8, 9);
        test.addPoint(15, 5);
        test.addPoint(3, 4);
        test2.addPoint(13, 7);
        test2.addPoint(8, 9);
        test2.addPoint(15, 5);
        test2.addPoint(3, 4);
        System.out.println("Double array output");
        System.out.println(test);
        System.out.println("array output");
        System.out.println(test2);
        test.addPoint(10, 1);
        test2.addPoint(10, 1);
        System.out.println("Double array output added");
        System.out.println(test);
        System.out.println("array output added");
        System.out.println(test2);
        System.out.println("Double array output removed");
        test.removeLast();
        System.out.println(test);
        System.out.println("array output removed");
        test2.removeLast();
        System.out.println(test2);
        System.out.println("get first x of Double array: " + test.getX(0));
        System.out.println("get third x of Double array: " + test.getX(2));
        System.out.println("get first x of array: " + test2.getX(0));
        System.out.println("get third x of array: " + test2.getX(2));
        System.out.println("get first y of Double array: " + test.getY(0));
        System.out.println("get third y of Double array: " + test.getY(2));
        System.out.println("get first y of array: " + test2.getY(0));
        System.out.println("get third y of array: " + test2.getY(2));
        System.out.println("\nDouble array SortByX output:");
        test.sortByX();
        System.out.println(test);
        System.out.println("Double array SortByY output:");
        test.sortByY();
        System.out.println(test);
        System.out.println("array SortByX output:");
        test2.sortByX();
        System.out.println(test2);
        System.out.println("array SortByY output:");
        test2.sortByY();
        System.out.println(test2);
    }
}