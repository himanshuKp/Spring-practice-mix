package LocalDate;

import java.time.LocalDate;
public class AgeFinder{
	public static int getAge(LocalDate dateOfBirth) {
		LocalDate currentDate = LocalDate.now();
		if(dateOfBirth.isAfter(currentDate)){
			return -1;
		}
        return currentDate.getYear() - dateOfBirth.getYear();
	}
	public LocalDate getDateAfterNDays(int noOfDays) {
		//Implementation required
		return LocalDate.now();
	}
	public LocalDate getDateAfterXYearYMonthZDays(int year, int month, int day) {
		//Implementation required
		return LocalDate.now();
	}

	public static void main(String[] args) {
		System.out.println(getAge(LocalDate.of(1989,10, 26)));
	}
}
