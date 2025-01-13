package LocalDate;

import java.time.LocalDate;
import java.time.LocalTime;

public class LocalTime2 {
    public static void main(String[] args) {
        LocalTime startTime = LocalTime.now();
        LocalTime endTime = startTime.plusSeconds(10);
        while (true){
            LocalTime current = LocalTime.now();
            int second = current.getSecond();
            if(second == endTime.getSecond()){
                System.out.println("Over");
                break;
            } else {
                System.out.println("Loop is running");
            }
        }
    }
}
