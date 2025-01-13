package LocalDate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

public class PeriodPractice1 {
    public static void main(String[] args) {
        Period period = Period.between(LocalDate.of(1993, 4, 29), LocalDate.now());
        System.out.println(period.getYears());
    }
}
