import java.util.List;

public class ParseMonth {
    public boolean parseMonth(String currMonth, int startLimit, int endLimit, List<Integer> month) {
        return Util.parseField(currMonth, startLimit, endLimit, month);
    }
}
