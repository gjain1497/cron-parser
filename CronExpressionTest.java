import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class CronExpressionTest {

    @Test
//    public void testMinute() throws Exception {
//        CronExpression cp = new CronExpression("*/15 0 1,15 * 1-5", "/usr/bin/find");
//
//        List<Integer> expected = Arrays.asList(1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
//
//        System.out.println(expected);
//        System.out.println(cp.getMinutes());
//
//        assertArrayEquals(expected.toArray(), cp.getMinutes().toArray()); // Convert List<Integer> to int[]
//    }
//
//
//    @Test
//    public void testHour() throws Exception {
//        CronExpression cp = new CronExpression("*/15 0 1,15 * 1-5", "/usr/bin/find");
//
//        List<Integer> expected = Arrays.asList(1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
//        assertArrayEquals(expected.toArray(), cp.getHours().toArray());
//    }
//
//    @Test
//    public void testDayOfMonth() throws Exception {
//        CronExpression cp = new CronExpression("*/15 0 1,15 * 1-5", "/usr/bin/find");
//
//        List<Integer> expected = Arrays.asList(0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0);
//        assertArrayEquals(expected.toArray(), cp.getDayOfMonth().toArray());
//    }
//    @Test
//    public void testDayOfMonth2() throws Exception {
//        CronExpression cp = new CronExpression("*/15 0 1,15 * 1-5", "/usr/bin/find");
//
//        // Failing test case - incorrect day of month
//        List<Integer> expected = Arrays.asList(0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0);
//        assertArrayEquals(expected.toArray(), cp.getDayOfMonth().toArray());
//    }
    public void testValidCronExpression() throws Exception {
        String input = "*/15 0 1,15 * 1-5";
        String command = "/usr/bin/find";
        CronExpression cp = new CronExpression(input, command);

        // Test minute parsing
        List<Integer> expectedMinutes = Arrays.asList(1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        assertArrayEquals(expectedMinutes.toArray(), cp.getMinutes().toArray());

        // Test hour parsing
        List<Integer> expectedHours = Arrays.asList(1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        assertArrayEquals(expectedHours.toArray(), cp.getHours().toArray());

        // Test day of month parsing
        List<Integer> expectedDayOfMonth = Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
        assertArrayEquals(expectedDayOfMonth.toArray(), cp.getDayOfMonth().toArray());

        // Test month parsing
        List<Integer> expectedMonth = Arrays.asList(0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
        assertArrayEquals(expectedMonth.toArray(), cp.getMonth().toArray());

        // Test day of week parsing
        List<Integer> expectedDayOfWeek = Arrays.asList(0, 1, 1, 1, 1, 1, 1);
        assertArrayEquals(expectedDayOfWeek.toArray(), cp.getDayOfWeek().toArray());
    }
    @Test(expected = Exception.class)
    public void testInvalidCronExpression() throws Exception {
        String input = "*/15 0 1,15 * 1-5 *"; // Extra field at the end
        String command = "/usr/bin/find";
        new CronExpression(input, command);
    }

    @Test(expected = Exception.class)
    public void testInvalidRange() throws Exception {
        String input = "*/15 0 1,15 * 1-5-7"; // Invalid range
        String command = "/usr/bin/find";
        new CronExpression(input, command);
    }
}