import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static double[] Cramer(double[][] A, double[] B) {
        int n = A.length;
        double[] X = new double[n];

        double detA = determinant(A);

        if (Math.abs(detA) < 1e-6) {
            throw new IllegalArgumentException("The matrix A is singular. No unique solution exists.");
        }

        for (int i = 0; i < n; i++) {
            double[][] Ai = new double[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    Ai[j][k] = (k == i) ? B[j] : A[j][k];
                }
            }

            X[i] = determinant(Ai) / detA;
        }

        return X;
    }

    private static double determinant(double[][] matrix) {
        int n = matrix.length;

        if (n == 1) {
            return matrix[0][0];
        } else {
            double det = 0.0;

            for (int i = 0; i < n; i++) {
                double[][] subMatrix = new double[n - 1][n - 1];
                for (int j = 1; j < n; j++) {
                    int subMatrixColIndex = 0;
                    for (int k = 0; k < n; k++) {
                        if (k != i) {
                            subMatrix[j - 1][subMatrixColIndex++] = matrix[j][k];
                        }
                    }
                }
                det += (i % 2 == 0 ? 1 : -1) * matrix[0][i] * determinant(subMatrix);
            }

            return det;
        }
    }
    public static double[] gauss(double[][] A, double[] B) {
        int n = B.length;
        double[] X = new double[n];

        // Forward elimination
        for (int k = 0; k < n - 1; k++) {
            for (int i = k + 1; i < n; i++) {
                double factor = A[i][k] / A[k][k];
                for (int j = k + 1; j < n; j++) {
                    A[i][j] -= factor * A[k][j];
                }
                B[i] -= factor * B[k];
            }
        }

        for (int k = n - 1; k >= 0; k--) {
            X[k] = B[k];
            for (int i = k + 1; i < n; i++) {
                X[k] -= A[k][i] * X[i];
            }
            X[k] /= A[k][k];
        }

        return X;
    }

    public static double[] seidel(double[][] A, double[] B) {
        int n = A.length;
        double[] solutions = new double[n];
        double[] previousSolutions = new double[n];
        int maxIterations = 100;
        double tolerance = 0.0001;

        int iteration = 0;
        while (iteration < maxIterations) {
            System.arraycopy(solutions, 0, previousSolutions, 0, n);

            for (int i = 0; i < n; i++) {
                double sum = 0.0;
                for (int j = 0; j < n; j++) {
                    if (j != i) {
                        sum += A[i][j] * solutions[j];
                    }
                }
                solutions[i] = (B[i] - sum) / A[i][i];
            }

            boolean converged = true;
            for (int i = 0; i < n; i++) {
                if (Math.abs(solutions[i] - previousSolutions[i]) > tolerance) {
                    converged = false;
                    break;
                }
            }

            if (converged) {
                return solutions;
            }

            iteration++;
        }

        return null;
    }


    public static double[] gaussJordan(double[][] A, double[] B) {
        int n = A.length;
        int m = A[0].length;

        double[][] augmentedMatrix = new double[n][m + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                augmentedMatrix[i][j] = A[i][j];
            }
            augmentedMatrix[i][m] = B[i];
        }

        for (int i = 0; i < n; i++) {
            int maxRowIndex = i;
            double maxValue = Math.abs(augmentedMatrix[i][i]);
            for (int k = i + 1; k < n; k++) {
                if (Math.abs(augmentedMatrix[k][i]) > maxValue) {
                    maxRowIndex = k;
                    maxValue = Math.abs(augmentedMatrix[k][i]);
                }
            }

            double[] temp = augmentedMatrix[i];
            augmentedMatrix[i] = augmentedMatrix[maxRowIndex];
            augmentedMatrix[maxRowIndex] = temp;

            double leadingCoefficient = augmentedMatrix[i][i];
            if (leadingCoefficient == 0) {
                return null;
            }

            for (int j = i; j <= m; j++) {
                augmentedMatrix[i][j] /= leadingCoefficient;
            }

            for (int k = 0; k < n; k++) {
                if (k != i) {
                    double factor = augmentedMatrix[k][i];
                    for (int j = i; j <= m; j++) {
                        augmentedMatrix[k][j] -= factor * augmentedMatrix[i][j];
                    }
                }
            }
        }

        double[] solution = new double[n];
        for (int i = 0; i < n; i++) {
            solution[i] = augmentedMatrix[i][m];
        }

        return solution;
    }

    public static double[] jacobi(double[][] A, double[] b) {
        int n = A.length;
        double[] X = new double[n];

        int maxIterations = 100;
        double tolerance = 1e-6;

        for (int iteration = 0; iteration < maxIterations; iteration++) {
            double[] newX = new double[n];

            for (int i = 0; i < n; i++) {
                double sum = 0.0;

                for (int j = 0; j < n; j++) {
                    if (j != i) {
                        sum += A[i][j] * X[j];
                    }
                }

                newX[i] = (b[i] - sum) / A[i][i];
            }

            double maxDiff = 0.0;

            for (int i = 0; i < n; i++) {
                double diff = Math.abs(newX[i] - X[i]);
                if (diff > maxDiff) {
                    maxDiff = diff;
                }
            }

            if (maxDiff < tolerance) {
                return newX;
            }

            X = newX;
        }

        return null;
    }

    public static boolean checkRoots(double[] X, double[][] A, double[] B) {
        int n = A.length;

        for (int i = 0; i < n; i++) {
            double sum = 0.0;
            for (int j = 0; j < n; j++) {
                sum += A[i][j] * X[j];
            }

            if (Math.abs(sum - B[i]) > 1e-6) {
                return false;
            }
        }

        return true;
    }
    public static double[][] read_user(int size){
        double[][] r = new double[size][size];
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                Scanner scanner = new Scanner(System.in);
                System.out.print("Write x[" + i + "][" + j + "]: ");
                r[i][j] = scanner.nextDouble();
            }
        }
        return r;
    }
    public static void main(String[] args) {

        System.out.print("Write size: ");
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        double[][] A = read_user(size);
        double[] B = new double[size];
        for(int i = 0; i<size; i++){
            System.out.print("Write B[" + i +"]: ");
            B[i] = scanner.nextInt();
        }
        double[] arrayc = Cramer(A, B);
        System.out.println("Cramer: ");
        String arrayString = Arrays.toString(arrayc);
        System.out.println(arrayString);
        double[] arrayg = gauss(A, B);
        System.out.println("Gauss: ");
        arrayString = Arrays.toString(arrayg);
        System.out.println(arrayString);
        double[] arrays =seidel(A, B);
        System.out.println("Seidel: ");
        arrayString = Arrays.toString(arrays);
        System.out.println(arrayString);
        double[] arraygj = gaussJordan(A, B);
        System.out.println("GaussJordan: ");
        arrayString = Arrays.toString(arraygj);
        System.out.println(arrayString);
        double[] arrayj = jacobi(A, B);
        System.out.println("Jacobi: ");
        arrayString = Arrays.toString(arrayj);
        System.out.println(arrayString);
    }
}