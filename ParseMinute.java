import util.src.Util;

import java.util.List;

public class ParseMinute {
    public boolean parseMinutes(String currMinute, int startLimit, int endLimit, List<Integer> minute) {
        return Util.parseField(currMinute, startLimit, endLimit, minute);
    }
}
