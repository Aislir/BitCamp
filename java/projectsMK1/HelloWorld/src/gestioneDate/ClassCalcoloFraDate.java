package gestioneDate;

import java.time.*;
import java.time.LocalTime;

public class ClassCalcoloFraDate {
    public static void main(String[] args) {
        LocalDate startDate = LocalDate.of(2024, 1, 1);
        LocalDate endDate = LocalDate.of(2024, 12, 31);

        Period period = Period.between(startDate, endDate);
        System.out.println(period);

        LocalTime startTime = LocalTime.of(14, 40);
        LocalTime endTime = LocalTime.of(16, 52);

        Duration duration = Duration.between(startTime, endTime);
        System.out.println("Ore: "+duration.toHours()+ ", Minuti: "+duration.toMinutes());
    }
}
