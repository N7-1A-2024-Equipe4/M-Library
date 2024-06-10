package utils;

public class TimeUtils {
    public static String formatDuration(int totalMinutes) {
        int hours = totalMinutes / 60;
        int minutes = totalMinutes % 60;
        return String.format("%d h %d min", hours, minutes);
    }
}
