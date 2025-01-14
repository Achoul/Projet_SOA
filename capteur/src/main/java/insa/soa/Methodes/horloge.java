package insa.soa.Methodes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class horloge {
    public static List<String> generateTimestamps(String startTime, String endTime, int intervalSeconds) {
        // Parse start and end times
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime start = LocalDateTime.parse(startTime, formatter);
        LocalDateTime end = LocalDateTime.parse(endTime, formatter);

        // Validate inputs
        if (start.isAfter(end)) {
            throw new IllegalArgumentException("Start time must be before end time.");
        }
        if (intervalSeconds <= 0) {
            throw new IllegalArgumentException("Interval must be a positive number.");
        }

        // Generate timestamps
        List<String> timestamps = new ArrayList<>();
        LocalDateTime current = start;

        while (!current.isAfter(end)) {
            timestamps.add(current.format(formatter));
            current = current.plusSeconds(intervalSeconds);
        }

        return timestamps;
    }


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