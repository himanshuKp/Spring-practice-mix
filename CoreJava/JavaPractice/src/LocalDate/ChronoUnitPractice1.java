package LocalDate;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ChronoUnitPractice1 {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.of(1993, 4, 29);

        long years = ChronoUnit.YEARS.between(birthday, today);
        System.out.println("Age in years: "+years);

//        calculate days until next birthday
        LocalDate nextBirthday = birthday.withYear(today.getYear());
        if (nextBirthday.isBefore(today)){
            nextBirthday = nextBirthday.plusYears(1);
        }
        long daysToNextBirthday = ChronoUnit.DAYS.between(today, nextBirthday);
        System.out.println("Days until next birthday: "+daysToNextBirthday);

        LocalDate startDate = LocalDate.of(2023, 1, 1);
        LocalDate endDate = LocalDate.of(2023, 6, 30);
        long monthsBetween = ChronoUnit.MONTHS.between(startDate, endDate);
        System.out.println("Months between dates: "+monthsBetween);
    }
}
