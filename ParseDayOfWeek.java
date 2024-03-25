import java.util.List;

public class ParseDayOfWeek {
    public boolean parseDayOfWeek(String currentDayOfWeek, int startLimit, int endLimit, List<Integer> dayOfWeek) {
        return Util.parseField(currentDayOfWeek, startLimit, endLimit, dayOfWeek);
    }
}
