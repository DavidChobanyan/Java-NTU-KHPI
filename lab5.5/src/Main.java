import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Введіть строку: ");
        String input = scanner.nextLine();

        // Регулярний вираз для розділення рядка за допомогою цифр
        String regex = "\\d+";

        // Розділення рядка на підрядки за допомогою регулярного виразу
        String[] substrings = input.split(regex);
        // Виведення результату
        System.out.println(Arrays.toString(substrings));
    }
}