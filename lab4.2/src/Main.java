import java.io.*;
import java.util.*;

class IntegerNumbers {
    public static class IntegerValueException extends Exception {
        private double wrongValue;

        public IntegerValueException(double wrongValue) {
            this.wrongValue = wrongValue;
        }

        public double getWrongValue() {
            return wrongValue;
        }
    }

    public static Comparator<Integer> compareNumbers() {
        // Локальний клас:
        class LocalComparator implements Comparator<Integer> {
            @Override
            public int compare(Integer d1, Integer d2) {
                return -Integer.compare(d1, d2);
            }
        }
        return new LocalComparator();
    }

    public static void sortIntegers(String inFileName, String firstOutFileName,
                                    String secondOutFileName) throws IntegerValueException, IOException,
            InputMismatchException {
        Integer[] arr = {};
        try (BufferedReader reader = new BufferedReader(new FileReader(inFileName));
             Scanner scanner = new Scanner(reader)) {
            while (scanner.hasNext()) {
                int d = scanner.nextInt();
                if (d < 0) {
                    throw new IntegerValueException(d);
                }
                Integer[] arr1 = new Integer[arr.length + 1];
                System.arraycopy(arr, 0, arr1, 0, arr.length);
                arr1[arr.length] = d;
                arr = arr1;
            }
        }
        PrintWriter firstWriter = new PrintWriter(new FileWriter(firstOutFileName));
        PrintWriter secondWriter = new PrintWriter(new FileWriter(secondOutFileName));
        try {
            Arrays.sort(arr);
            for (Integer x : arr)
                firstWriter.print(x + " ");
            Arrays.sort(arr, compareNumbers());
            for (Integer x : arr)
                secondWriter.print(x + " ");
        }

        finally {
            firstWriter.close();
            secondWriter.close();
        }
    }

    public static void main(String[] args) {
        try {
            sortIntegers("data.txt", "out1.txt", "out2.txt");
        }

        catch (IntegerValueException e) {
            e.printStackTrace();
            System.err.println("Wrong value: " + e.getWrongValue());
        }

        catch (IOException e) {
            e.printStackTrace();
        }
        catch (InputMismatchException e) {
            e.printStackTrace();
        }
    }

}