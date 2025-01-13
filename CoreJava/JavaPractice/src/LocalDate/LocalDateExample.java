package LocalDate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateExample {
	public static void main(String[] args) {  
		LocalDate date = LocalDate.now();  
		LocalDate yesterday = date.minusDays(1);  
		LocalDate tomorrow = yesterday.plusDays(2);  
		System.out.println("Today date: "+date);  
		System.out.println("Yesterday date: "+yesterday);  
		System.out.println("Tomorrow date: "+tomorrow);

		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy");
		System.out.println(dateTimeFormatter.format(date));
	}
}  
// The value of date may vary according to the system's date.
