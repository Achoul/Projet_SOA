package insa.soa.Methodes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class horloge {
    
    // Method to get the current date and time as a string, udes for timetamps
    public static String getCurrentDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return now.format(formatter);
    }
    
    // Method to get the current hour of the day
    public static int getHour() {
        LocalDateTime now = LocalDateTime.now();
        return now.getHour();
    }
}