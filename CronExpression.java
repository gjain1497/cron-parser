import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class CronExpression {

    private List<Integer> minute;
    private List<Integer> hour;
    private List<Integer> dayOfMonth;
    private List<Integer> month;
    private List<Integer> dayOfWeek;

    private List<Integer> year;

    private Map<Integer, Integer> monthDaysMap;

    public List<Integer> getMinutes() {
        return this.minute;
    }

    public List<Integer> getHours() {
        return this.hour;
    }

    public List<Integer> getDayOfMonth() {
        return this.dayOfMonth;
    }

    public List<Integer> getMonth() {
        return this.month;
    }

    public List<Integer> getDayOfWeek() {
        return this.dayOfWeek;
    }

    public CronExpression(String input, String command) throws Exception {
        initialiseList();

        boolean isValid = processCronString(input);

        if (isValid) {
            printDetails(minute, hour, dayOfMonth, month, dayOfWeek, command);
        }else{
            throw new Exception("Error while parsing");
        }
    }

    private void initialiseList() {
        minute = new ArrayList<>(Collections.nCopies(Constants.endLimitMin, 0)); //minutes length with all 0
        hour = new ArrayList<>(Collections.nCopies(Constants.endLimitHour, 0));
        dayOfMonth = new ArrayList<>(Collections.nCopies(Constants.endLimitDayOfMonth, 0));
        month = new ArrayList<>(Collections.nCopies(Constants.endLimitMonth, 0));
        dayOfWeek = new ArrayList<>(Collections.nCopies(Constants.endLimitDayOfWeek, 0));
        year = new ArrayList<>(Collections.nCopies(Constants.endLimitYear, 0));
    }


    private boolean processCronString(String cronString) {
        String[] vec = cronString.split(" ");

        if (vec.length == 5) {
            String currMinute = vec[0];
            String currHour = vec[1];
            String currDayOfMonth = vec[2];
            String currMonth = vec[3];
            String currDayOfWeek = vec[4];

            ParseMinute parseMinute = new ParseMinute();
            ParseHour parseHour = new ParseHour();
            ParseDayOfMonth parseDayOfMonth = new ParseDayOfMonth();
            ParseMonth parseMonth = new ParseMonth();
            ParseDayOfWeek parseDayOfWeek = new ParseDayOfWeek();

            boolean validMin = parseMinute.parseMinutes(currMinute, Constants.startLimitMin, Constants.endLimitMin, minute);
            boolean validHour = parseHour.parseHours(currHour, Constants.startLimitHour, Constants.endLimitHour, hour);
            boolean validDayOfMonth = parseDayOfMonth.parseDayOfMonth(currDayOfMonth, Constants.startLimitDayOfMonth, Constants.endLimitDayOfMonth, dayOfMonth);
            boolean validMonth = parseMonth.parseMonth(currMonth, Constants.startLimitMonth, Constants.endLimitMonth, month);
            boolean validDayOfWeek = parseDayOfWeek.parseDayOfWeek(currDayOfWeek, Constants.startLimitDayOfWeek, Constants.endLimitDayOfWeek, dayOfWeek);

            return validMin && validHour && validDayOfMonth && validMonth && validDayOfWeek;
        }
        return false;
    }

    public void printDetails(List<Integer> minute, List<Integer> hour, List<Integer> dayOfMonth, List<Integer> month, List<Integer> dayOfWeek, String command) {
        printColumnInfo("minute");
        for (int i = 0; i < minute.size(); i++) {
            if (minute.get(i) == 1) {
                System.out.print(i + " ");
            }
        }
        System.out.println();

        printColumnInfo("hours");
        for (int i = 0; i < hour.size(); i++) {
            if (hour.get(i) == 1) {
                System.out.print(i + " ");
            }
        }
        System.out.println();

        printColumnInfo("day of month");
        for (int i = 0; i < dayOfMonth.size(); i++) {
            if (dayOfMonth.get(i) == 1) {
                System.out.print(i + " ");
            }
        }
        System.out.println();

        printColumnInfo("month");
        for (int i = 0; i < month.size(); i++) {
            if (month.get(i) == 1) {
                System.out.print(i + " ");
            }
        }
        System.out.println();

        printColumnInfo("day of week");
        for (int i = 0; i < dayOfWeek.size(); i++) {
            if (dayOfWeek.get(i) == 1) {
                System.out.print(i + " ");
            }
        }
        System.out.println();

        printColumnInfo("command");
        System.out.println(command);
    }

    private void printColumnInfo(String val) {
        System.out.print(val);
        int len = val.length();
        int idx = len + 1;
        while (idx <= 14) {
            System.out.print(" ");
            idx++;
        }
    }
}
