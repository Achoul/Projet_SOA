package insa.soa.Methodes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

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

    public static void main(String[] args) {
        // Example usage
        String start = "2025-01-10 12:00:00";
        String end = "2025-01-10 12:10:00";
        int interval = 60; // 1 minute

        List<String> timestamps = generateTimestamps(start, end, interval);

        // Print the timestamps
        for (String timestamp : timestamps) {
            System.out.println(timestamp);
        }
    }
}