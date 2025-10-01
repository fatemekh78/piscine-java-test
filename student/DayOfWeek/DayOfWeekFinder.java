import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DayOfWeekFinder {
    private static final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public String findNextDayOfWeek(String startDate, String dayOfWeek) {
        try {
            // parse input date strictly according to yyyy-MM-dd
            LocalDate date = LocalDate.parse(startDate, FMT);

            // convert name to DayOfWeek (case-insensitive)
            DayOfWeek target = DayOfWeek.valueOf(dayOfWeek.toUpperCase());

            int current = date.getDayOfWeek().getValue(); // 1..7 (Mon..Sun)
            int wanted = target.getValue(); // 1..7

            int diff = wanted - current;
            if (diff <= 0) diff += 7; // move to next occurrence (not the same day)

            return date.plusDays(diff).toString();
        } catch (DateTimeParseException | IllegalArgumentException e) {
            // invalid date format or invalid day name
            return "Error";
        } catch (Exception e) {
            // any other unexpected error
            return "Error";
        }
    }
}