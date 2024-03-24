import util.src.Util;

import java.util.List;

public class ParseYear {
    public boolean parseYear(String currMonth, int startLimit, int endLimit, List<Integer> month) {
        return Util.parseField(currMonth, startLimit, endLimit, month);
    }
}
