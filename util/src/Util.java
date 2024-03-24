package util.src;

import java.util.ArrayList;
import java.util.List;

public class Util {
    public static boolean parseField(String field, int startLimit, int endLimit, List<Integer> targetList) {
        if (field.equals("*")) {
            for (int i = startLimit; i < endLimit; i++) {
                targetList.set(i, 1);
            }
        } else {
            String[] data = field.split(",");
            for (String val : data) {
                List<Integer> parsedData;
                try {
                    parsedData = parseRanges(val, endLimit);
                    for (int value : parsedData) {
                        targetList.set(value, 1);
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    targetList.clear();
                    return false;
                }
            }
        }
        System.out.println("targetList "+targetList);
        return true;
    }


    public static List<Integer> parseRanges(String val, int endLimit) throws Exception {
        List<Integer> tempData = new ArrayList<>();

        if (val.length() <= 2) {
            tempData.add(Integer.parseInt(val));
        } else if (val.contains("-")) {
            String[] data = val.split("-"); //1,10 //Mon-Tue, Thu-Fri

            int startVal = Integer.parseInt(data[0]); //start -Mon , end - Thurs //start = 4, end = 1
            int endVal = Integer.parseInt(data[1]);

            if (startVal > endVal) {
                throw new Exception("Invalid cron expression");
            }

            for (int i = startVal; i <= endVal; i++) {
                tempData.add(i);
            }
        } else if (val.contains("/")) {
            String[] data = val.split("/");

            int startVal = 0;

            if (!data[0].equals("*")) {
                startVal = Integer.parseInt(data[0]);
            }

            int stepUp = Integer.parseInt(data[1]);

            for (int i = startVal; i < endLimit; i += stepUp) {
                tempData.add(i);
            }
        } else {
            throw new Exception("Invalid cron expression");
        }
        return tempData;
    }

}
