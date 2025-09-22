import java.time.LocalDate;
import java.time.Period;

public class MonthlyPeriod {
    public String calculatePeriod(String startDate, String endDate) {
        try {
            LocalDate start = LocalDate.parse(startDate);
            LocalDate end = LocalDate.parse(endDate);
            
            // Special case: same dates return empty string
            if (start.equals(end)) {
                return "";
            }
            
            // Ensure start date is always before end date
            if (start.isAfter(end)) {
                // Swap the dates
                LocalDate temp = start;
                start = end;
                end = temp;
            }
            
            // Calculate period (now always positive)
            Period period = Period.between(start, end);
            int years = period.getYears();
            int months = period.getMonths();
            
            // Handle all cases
            if (years == 0 && months == 0) {
                return "0 months";
            } else if (years == 0) {
                return months + (months == 1 ? " month" : " months");
            } else if (months == 0) {
                return years + (years == 1 ? " year" : " years");
            } else {
                return years + (years == 1 ? " year" : " years") + " and " + 
                       months + (months == 1 ? " month" : " months");
            }
            
        } catch (Exception e) {
            return "Error";
        }
    }
}