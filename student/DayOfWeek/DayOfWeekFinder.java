import java.time.DayOfWeek;
import java.time.LocalDate;

public class DayOfWeekFinder {
    public String findNextDayOfWeek(String startDate, String dayOfWeek) {
        try {
            // Step 1: Parse the input date string into a LocalDate object
            // This will automatically handle the "yyyy-MM-dd" format
            LocalDate date = LocalDate.parse(startDate);
            
            // Step 2: Convert the day name string to a DayOfWeek enum value
            // Using toUpperCase() makes it case-insensitive (MONDAY, monday, Monday all work)
            DayOfWeek target = DayOfWeek.valueOf(dayOfWeek.toUpperCase());
            
            // Step 3: Calculate the difference between target day and current day
            // Day values: Monday=1, Tuesday=2, ..., Sunday=7
            int diff = target.getValue() - date.getDayOfWeek().getValue();
            
            // Step 4: Determine how many days to add
            // If diff is negative or zero, target day is earlier in the week or same day
            // So we add 7 days to get to next week's occurrence
            int daysToAdd = diff <= 0 ? diff + 7 : diff;
            
            // Step 5: Add the calculated days and return the result as string
            // toString() automatically formats it as "yyyy-MM-dd"
            return date.plusDays(daysToAdd).toString();
            
        } catch (Exception e) {
            // Step 6: If anything goes wrong (invalid date or invalid day name), return "Error"
            return "Error";
        }
    }
}