import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main extends JFrame implements ActionListener {
    private JComboBox<String> methodComboBox;
    private JTextField fileTextField;

    public Main() {
        // Настройка окна
        setTitle("Графический интерфейс");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Добавление компонентов на окно
        JLabel methodLabel = new JLabel("Выберите метод:");
        String[] methods = {"Метод Ньютона", "Метод Лагранжа", "Метод дифференцирования"};
        methodComboBox = new JComboBox<>(methods);

        JLabel fileLabel = new JLabel("Введите путь к файлу:");
        fileTextField = new JTextField(20);

        JButton startButton = new JButton("Старт");
        startButton.addActionListener(this);

        add(methodLabel);
        add(methodComboBox);
        add(fileLabel);
        add(fileTextField);
        add(startButton);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Старт")) {
            String selectedMethod = (String) methodComboBox.getSelectedItem();
            String filePath = fileTextField.getText();

            // Чтение данных из файла
            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                String xValues = br.readLine();
                String fValues = br.readLine();
                String XValues = br.readLine();

                // Преобразование строк со значениями в массивы чисел
                double[] x = convertStringToArray(xValues);
                double[] f = convertStringToArray(fValues);
                double[] X = convertStringToArray(XValues);

                // Выполнение выбранного метода
                if (selectedMethod.equals("Метод Ньютона")) {
                    double[] interpolatedValues = newtonInterpolation(x, f, X);
                    System.out.println("Результат интерполяции методом Ньютона: " + arrayToString(interpolatedValues));
                } else if (selectedMethod.equals("Метод Лагранжа")) {
                    double[] interpolatedValues = lagrangeInterpolation(x, f, X);
                    System.out.println("Результат интерполяции методом Лагранжа: " + arrayToString(interpolatedValues));
                } else if (selectedMethod.equals("Метод дифференцирования")) {
                    double[] differentiatedValues = differentiate(x, f, X);
                    System.out.println("Результат дифференцирования: " + arrayToString(differentiatedValues));
                }

            } catch (IOException ex) {
                System.out.println("Ошибка чтения файла: " + ex.getMessage());
            }
        }
    }

    // Вспомогательный метод для преобразования строки с числами в массив десятичных чисел
    private double[] convertStringToArray(String valuesString) {
        String[] valuesArray = valuesString.split(" ");
        double[] result = new double[valuesArray.length];

        for (int i = 0; i < valuesArray.length; i++) {
            result[i] = Double.parseDouble(valuesArray[i].replace(",", "."));
        }

        return result;
    }

    // Вспомогательный метод для преобразования массива чисел в строку
    private String arrayToString(double[] array) {
        StringBuilder sb = new StringBuilder();

        for (double value : array) {
            sb.append(value).append(" ");
        }

        return sb.toString().trim();
    }

    // Функция для дифференцирования
    public static double[] differentiate(double[] x, double[] f, double[] X) {
        int n = x.length;
        int m = X.length;
        double[] F = new double[m];

        for (int i = 0; i < m; i++) {
            int index = findNearestIndex(x, X[i]);

            if (index >= 2 && index <= n - 3) {
                F[i] = (-f[index + 2] + 8 * f[index + 1] - 8 * f[index - 1] + f[index - 2]) / (12 * (x[index + 1] - x[index]));
            } else if (index == 0) {
                F[i] = (-3 * f[0] + 4 * f[1] - f[2]) / (2 * (x[1] - x[0]));
            } else if (index == 1) {
                F[i] = (-f[0] + f[2]) / (2 * (x[2] - x[0]));
            } else if (index == n - 2) {
                F[i] = (-f[n - 3] + f[n - 1]) / (2 * (x[n - 1] - x[n - 3]));
            } else if (index == n - 1) {
                F[i] = (3 * f[n - 1] - 4 * f[n - 2] + f[n - 3]) / (2 * (x[n - 1] - x[n - 2]));
            }
        }

        return F;
    }

    // Функция для интерполяции методом Ньютона
    public static double[] newtonInterpolation(double[] x, double[] f, double[] X) {
        int n = x.length;
        int m = X.length;
        double[][] dividedDifferences = new double[n][n];
        double[] F = new double[m];

        // Вычисление разделенных разностей
        for (int i = 0; i < n; i++) {
            dividedDifferences[i][0] = f[i];
        }

        for (int j = 1; j < n; j++) {
            for (int i = 0; i < n - j; i++) {
                dividedDifferences[i][j] = (dividedDifferences[i + 1][j - 1] - dividedDifferences[i][j - 1]) / (x[i + j] - x[i]);
            }
        }

        // Вычисление значений функции в интерполируемых точках
        for (int i = 0; i < m; i++) {
            double sum = dividedDifferences[0][0];
            double prod = 1.0;

            for (int j = 1; j < n; j++) {
                prod *= (X[i] - x[j - 1]);
                sum += dividedDifferences[0][j] * prod;
            }

            F[i] = sum;
        }

        return F;
    }

    // Функция для интерполяции методом Лагранжа
    public static double[] lagrangeInterpolation(double[] x, double[] f, double[] X) {
        int n = x.length;
        int m = X.length;
        double[] F = new double[m];

        for (int i = 0; i < m; i++) {
            double sum = 0.0;

            for (int j = 0; j < n; j++) {
                double product = 1.0;

                for (int k = 0; k < n; k++) {
                    if (k != j) {
                        product *= (X[i] - x[k]) / (x[j] - x[k]);
                    }
                }

                sum += f[j] * product;
            }

            F[i] = sum;
        }

        return F;
    }

    private static int findNearestIndex(double[] array, double value) {
        int index = Arrays.binarySearch(array, value);
        return index >= 0 ? index : -(index + 1) - 1;
    }

    public static void main(String[] args) {
        new Main();
    }
}
