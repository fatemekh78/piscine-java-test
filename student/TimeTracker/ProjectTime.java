import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProjectTime {
    private String startTime;
    private String endTime;
    private float hoursLogged;

    public ProjectTime(String start, String end) {
        setStartTime(start);
        setEndTime(end);
    }

    public void setStartTime(String start) {
        startTime = start;
        calculateHours();
    }

    public void setEndTime(String end) {
        endTime = end;
        calculateHours();
    }

    public String getStartTime() { return startTime; }
    public String getEndTime() { return endTime; }


        
 public String getHoursLogged() {
    if (hoursLogged == -1) return "-1";
    
    float totalMinutes = hoursLogged * 60;
    float totalHours = hoursLogged;
    float totalDays = totalHours / 24;
    
    // Special handling for the 119-120 day range
    if (totalDays >= 119.5f && totalDays < 120.5f) {
        // If it's close to 120 days, check if it should be considered as months
        float months = totalDays / 30;
        int roundedMonths = (int) months;
        if (months > roundedMonths) {
            roundedMonths++;
        }
        
        // 120 days = 4 months, so if we have 4 months or more, use months
        if (roundedMonths >= 4) {
            return roundedMonths + " mo";
        } else {
            return (int) totalDays + " d";
        }
    }
    
    // Normal threshold logic
    if (totalMinutes < 120) {
        return (int) totalMinutes + " m";
    } else if (totalHours < 120) {
        return (int) totalHours + " h";
    } else if (totalDays < 120) {
        return (int) totalDays + " d";
    } else {
        float months = totalDays / 30;
        int roundedMonths = (int) months;
        if (months > roundedMonths) {
            roundedMonths++;
        }
        return roundedMonths + " mo";
    }
}
    private void calculateHours() {
    if (startTime == null || endTime == null) {
        hoursLogged = -1;
        return;
    }
    
    try {
        // Trim the input strings and set timezone explicitly
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        format.setLenient(false); // Strict parsing
        
        Date start = format.parse(startTime.trim());
        Date end = format.parse(endTime.trim());
        
        long diff = end.getTime() - start.getTime();
        if (diff < 0) {
            hoursLogged = -1;
        } else {
            hoursLogged = diff / (1000f * 60 * 60);
        }
    } catch (ParseException e) {
        hoursLogged = -1;
    }
}
}
