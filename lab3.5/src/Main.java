import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        String test = "Hello there Wake up Neo Knock Knock";
        Set<String> set = new TreeSet<String>(new Comparator<String>()
        {
            @Override
            public int compare(String s1, String s2) {
                for(int a = 0; a < s1.length(); a++){
                    if(s1.toLowerCase().charAt(a) > s2.toLowerCase().charAt(a)){
                        return 1;
                    }else if(s1.toLowerCase().charAt(a) < s2.toLowerCase().charAt(a)){
                        return -1;
                    }
                }
                return 0;
            }
        });

        String[] test2 = test.split(" ");
            for(int a = 0; a < test2.length; a++)
                set.add(test2[a]);
        System.out.println(test);
        System.out.println(set);
    }
}