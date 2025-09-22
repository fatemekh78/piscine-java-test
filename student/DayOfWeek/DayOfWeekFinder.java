import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DayOfWeekFinder {
    public String findNextDayOfWeek(String startDate, String dayOfWeek) {
        try {
            LocalDate date = LocalDate.parse(startDate, DateTimeFormatter.ISO_LOCAL_DATE);
            DayOfWeek targetDay = DayOfWeek.valueOf(dayOfWeek.toUpperCase());

            // Find the next occurrence of the target day
            while (date.getDayOfWeek() != targetDay) {
                date = date.plusDays(1);
            }

            return date.format(DateTimeFormatter.ISO_LOCAL_DATE);
        } catch (DateTimeParseException | IllegalArgumentException e) {
            return "Invalid input";
        }
    }
}