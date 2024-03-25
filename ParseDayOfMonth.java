import util.Util;

import java.util.List;

public class ParseDayOfMonth {
    public boolean parseDayOfMonth(String currDayOfMonth, int startLimit, int endLimit, List<Integer> dayOfMonth) {
        return Util.parseField(currDayOfMonth, startLimit, endLimit, dayOfMonth);
    }
}
