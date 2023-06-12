import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть номер:");
        String userInput = scanner.nextLine();

        String regex = "^\\+380";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(userInput);

        if(userInput.length() != 13){
            System.out.println("Wrong number write again");
        }else{
            for(int i = 0; i < 13; i++){
                if(userInput.charAt(i) != '+' && (int)userInput.charAt(i) < 47 && (int)userInput.charAt(i) > 58){
                    System.out.println("Wrong number write again");
                    return;
                }
            }
            if(matcher.find()){
                regex = "^.{4}(67|68|98|96|97)";
                pattern = Pattern.compile(regex);
                matcher = pattern.matcher(userInput);
                if(matcher.find()){
                    regex = "^.{6}(50|66|95|99|63|73|94|93|91|92)";
                    pattern = Pattern.compile(regex);
                    matcher = pattern.matcher(userInput);
                    if(matcher.find()){
                        System.out.println("True");
                    }else{
                        System.out.println("False");
                    }
                }else{
                    System.out.println("False");
                }
            }else{
                System.out.println("False");
            }
        }
    }
}