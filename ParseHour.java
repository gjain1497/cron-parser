import util.src.Util;

import java.util.List;

public class ParseHour {
    public boolean parseHours(String currHour, int startLimit, int endLimit, List<Integer> hour) {
          return Util.parseField(currHour, startLimit, endLimit, hour);
    }
}
