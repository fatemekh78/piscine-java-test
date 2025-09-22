import java.time.LocalDate;
import java.time.Period;

public class AgeFinder {
    public int calculateAge(String date) {
        try {
            // Parse the input date
            LocalDate birthDate = LocalDate.parse(date);
            
            // Get today's date
            LocalDate today = LocalDate.now();
            
            // Check if the birth date is in the future (invalid scenario)
            if (birthDate.isAfter(today)) {
                return -1; // Future dates should return -1
            }
            
            // Calculate age in years
            return Period.between(birthDate, today).getYears();
            
        } catch (Exception e) {
            // Return -1 for any parsing errors or invalid formats
            return -1;
        }
    }
}
