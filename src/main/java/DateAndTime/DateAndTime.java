package DateAndTime;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

public class DateAndTime {
    public static void main(String[] args) {

        final Date date = new Date();
        int secondDelta = 1;

        Instant timestampNew = Instant.now();
        System.out.println("timestamp instant: " + timestampNew);
        timestampNew = Instant.now().minusSeconds(1);
        System.out.println("timestamp instant: " + timestampNew);
        System.out.println("raw Date: " + date);

        date.setSeconds(date.getSeconds() - secondDelta);

        System.out.println("getSeconds(): " + date.getSeconds());
        System.out.println("date dopo SecondDelta: " + date);


        LocalDate dateNew = LocalDate.now();
        System.out.println("nuovo: " + dateNew);

        LocalDate today = LocalDate.now();
        System.out.println(today.toString());
    }
}
