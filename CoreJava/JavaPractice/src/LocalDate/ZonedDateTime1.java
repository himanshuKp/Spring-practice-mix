package LocalDate;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ZonedDateTime1 {
    public static void main(String[] args) {
        System.out.println(ZonedDateTime.now(ZoneId.of("Europe/Athens")));
        System.out.println(ZonedDateTime.now(ZoneId.of("Asia/Kolkata")));
    }
}
