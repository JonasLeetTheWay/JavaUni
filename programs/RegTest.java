import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegTest {
    public static void main(String[] args) {
//        (\d\d\d\d)-(\d\d)-(\d\d), (\d\d)-(\d\d), (\d\d):(\d\d)-(\d\d):(\d\d), (\w+) to (\w+), (\d+) euro
//        2022-07-05, 07-05, 09:45-11:10, Nuremberg to Zadar, 17 euro
        Pattern p = Pattern.compile("(\\d\\d\\d\\d)-(\\d\\d)-(\\d\\d) {1,5}, *(\\d\\d)-(\\d\\d), (\\d\\d):(\\d\\d)-(\\d\\d):(\\d\\d), (\\w+) to (\\w+), (\\d+) euro");//. represents single character.

        String s = "2022-07-05      ,        07-05, 09:45-11:10, Nuremberg to Zadar, 17 euro";
        Matcher m = p.matcher(s);
        if (m.matches()) {
            System.out.println("match success");
            System.out.printf("year: %s\n", m.group(1));
            System.out.printf("month: %s\n", m.group(2));
            System.out.printf("day: %s\n", m.group(3));

            System.out.printf("price: %s\n", m.group(12));
        }else {
            System.out.println(" match fail");
        }

    }
}
