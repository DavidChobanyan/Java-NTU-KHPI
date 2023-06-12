import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Map<String, String> m = new TreeMap<String, String>();

        m.put("Hello", "awdwaq34rd3.d");
        m.put("yad", "rar.d");
        m.put("General", "adczcfgd12.3#@");
        m.put("ag", "dvv@");
        m.put("Kenobi", "w3r34wrfdv");
        m.put("Neo", "adadzsdasefasfc");
        for (Map.Entry<?, ?> entry : m.entrySet())
            if(entry.getValue().toString().length() > 6)
                System.out.println(entry.getKey() + ": " + entry.getValue());
    }
}