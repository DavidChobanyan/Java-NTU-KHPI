import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть рядок дати: ");
        String input = scanner.nextLine();

        // Регулярний вираз для перевірки формату дати
        String regex = "^\\d{2}\\.\\d{2}\\.\\d{4}$";
        Matcher matcher = Pattern.compile(regex).matcher(input);

        if (matcher.matches()) {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
                Date date = dateFormat.parse(input);
                SimpleDateFormat outputDateFormat = new SimpleDateFormat("dd.MM.yyyy");
                String formattedDate = outputDateFormat.format(date);


                // Об'єкт типу Date
                System.out.println("Date: " + formattedDate);

                // Об'єкт типу GregorianCalendar
                Calendar calendar = GregorianCalendar.getInstance();
                calendar.setTime(date);
                System.out.println("GregorianCalendar: " + calendar.getTime());

                // Об'єкт типу LocalDate
                LocalDate localDate = date.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                formattedDate = localDate.format(formatter);
                System.out.println("Об'єкт LocalDate: " + formattedDate);
            } catch (ParseException e) {
                System.out.println("Помилка: неправильний формат дати.");
            }
        } else {
            System.out.println("Помилка: неправильний формат дати.");
        }
    }
}