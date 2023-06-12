import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
            public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Введите пароль: ");
                String password = scanner.nextLine();

                String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[_\\-*]).{8,}$";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(password);

                if (matcher.matches()) {
                    System.out.println("Пароль соответствует требованиям.");
                } else {
                    System.out.println("Пароль не соответствует требованиям.");
                }
            }
}