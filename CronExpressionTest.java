import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertArrayEquals;

public class CronExpressionTest {
    @Test
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
        List<Integer> expectedDayOfMonth = Arrays.asList(0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        assertArrayEquals(expectedDayOfMonth.toArray(), cp.getDayOfMonth().toArray());

        // Test month parsing
        List<Integer> expectedMonth = Arrays.asList(0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
        assertArrayEquals(expectedMonth.toArray(), cp.getMonth().toArray());

        // Test day of week parsing
        List<Integer> expectedDayOfWeek = Arrays.asList(0, 1, 1, 1, 1, 1, 0);
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